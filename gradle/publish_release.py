"""Stage and verify GitHub release assets before replacing the live downloads."""

import hashlib
import json
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile


def gh(*args, input_text=None):
    result = subprocess.run(["gh", *args], input=input_text, capture_output=True, text=True, check=True)
    return result.stdout


def latest_release():
    pages = json.loads(gh("api", "repos/{owner}/{repo}/releases?per_page=100", "--paginate", "--slurp"))
    return next((release for page in pages for release in page if release["tag_name"] == "latest"), None)


def assets(release_id):
    pages = json.loads(gh("api", f"repos/{{owner}}/{{repo}}/releases/{release_id}/assets", "--paginate", "--slurp"))
    return {asset["name"]: asset for page in pages for asset in page}


def asset_api(asset):
    return f"repos/{{owner}}/{{repo}}/releases/assets/{asset['id']}"


def rename(asset, name):
    gh("api", "--method", "PATCH", asset_api(asset), "--input", "-", input_text=json.dumps({"name": name}))


def verify(asset, path):
    with path.open("rb") as stream:
        digest = hashlib.file_digest(stream, "sha256").hexdigest()
    if asset["state"] != "uploaded" or asset.get("digest") != f"sha256:{digest}":
        raise ValueError(f"GitHub asset verification failed for {path.name}")


def promote(release_id, current, staged):
    backups = []
    promoted = []
    try:
        for path, staging_name in staged:
            name = path.name
            if previous := current.get(name):
                backup_name = f"previous-{previous['id']}-{name}"
                backups.append((previous, name, backup_name))
                rename(previous, backup_name)
            asset = current[staging_name]
            promoted.append((asset, staging_name, name))
            rename(asset, name)
    except subprocess.CalledProcessError:
        # Check remote names because a lost response can follow a successful rename.
        live = assets(release_id)
        for asset, staging_name, name in reversed(promoted):
            if live.get(name, {}).get("id") == asset["id"]:
                rename(asset, staging_name)
        for previous, name, backup_name in reversed(backups):
            if live.get(backup_name, {}).get("id") == previous["id"]:
                rename(previous, name)
        raise

    for previous, _, _ in backups:
        try:
            gh("api", "--method", "DELETE", asset_api(previous))
        except subprocess.CalledProcessError:
            print(f"Previous asset {previous['name']} could not be removed", file=sys.stderr)


def publish(code, sha, notes, paths):
    latest = latest_release()
    if latest is None:
        gh("release", "create", "latest", "--draft", "--target", sha, "--title", "Latest")
        latest = latest_release()
    release_id = latest["id"]

    with tempfile.TemporaryDirectory() as directory:
        staged = [(path, f"{path.name}.{code}.pending") for path in paths]
        for path, staging_name in staged:
            shutil.copyfile(path, Path(directory) / staging_name)
        # Only staging names can be clobbered when a run is retried.
        gh("release", "upload", "latest", "--clobber", *(str(Path(directory) / name) for _, name in staged))
        current = assets(release_id)
        for path, staging_name in staged:
            verify(current[staging_name], path)
        promote(release_id, current, staged)

    gh("release", "edit", "latest", "--draft=false", "--title", "Latest", "--notes-file", notes, "--latest=true")


if __name__ == "__main__":
    code, sha, notes, *files = sys.argv[1:]
    try:
        publish(code, sha, notes, [Path(file) for file in files])
    except subprocess.CalledProcessError as error:
        raise SystemExit(error.stderr or str(error)) from error
