"""Stage and verify GitHub release assets before replacing the live downloads."""

import hashlib
import json
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile
import time


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


def release_api(release_id):
    return f"repos/{{owner}}/{{repo}}/releases/{release_id}"


def finish_publication(recovery_path):
    state = json.loads(recovery_path.read_text(encoding="utf-8"))
    endpoint = release_api(state["release_id"])
    payload = {"draft": False, "name": "Latest", "body": state["notes"], "make_latest": "true"}
    for attempt in range(1, 4):
        try:
            current = assets(state["release_id"])
            for name, expected in state["assets"].items():
                asset = current.get(name, {})
                if (asset.get("id"), asset.get("digest"), asset.get("state")) != (*expected, "uploaded"):
                    raise ValueError(f"Prepared asset {name} is missing or has changed")
            release = json.loads(gh("api", endpoint))
            if release.get("tag_name") != "latest":
                raise ValueError("Prepared release no longer has the latest tag")
            release = json.loads(gh("api", "--method", "PATCH", endpoint, "--input", "-",
                                    input_text=json.dumps(payload)))
            if release.get("tag_name") != "latest" or release.get("draft") is not False:
                raise ValueError("GitHub did not confirm the latest release is public")
            break
        except (subprocess.CalledProcessError, ValueError) as error:
            if attempt == 3:
                raise
            print(f"Publication attempt {attempt}/3 failed: {getattr(error, 'stderr', None) or error}",
                  file=sys.stderr)
            time.sleep(attempt * 2)

    before = state["published_at"]
    after = release.get("published_at")
    if before and (not after or after <= before):
        print(f"::warning::GitHub kept the previous release publication date ({before}).")


def publish(code, sha, notes, paths, recovery_path):
    release_notes = Path(notes).read_text(encoding="utf-8")
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
        state = {
            "release_id": release_id,
            "published_at": latest.get("published_at"),
            "notes": release_notes,
            "assets": {path.name: [current[name]["id"], current[name]["digest"]] for path, name in staged},
        }

    # Record the exact release and assets before a request can hide them from public clients.
    pending = recovery_path.with_suffix(".tmp")
    pending.write_text(json.dumps(state), encoding="utf-8")
    pending.replace(recovery_path)
    try:
        if not latest["draft"]:
            gh("api", "--method", "PATCH", release_api(release_id), "-F", "draft=true")
    except subprocess.CalledProcessError as error:
        print(f"Warning: Could not set draft mode to refresh timestamp: {error.stderr or error}", file=sys.stderr)
    finally:
        finish_publication(recovery_path)


if __name__ == "__main__":
    try:
        if sys.argv[1] == "--recover":
            finish_publication(Path(sys.argv[2]))
        else:
            code, sha, notes, recovery, *files = sys.argv[1:]
            publish(code, sha, notes, [Path(file) for file in files], Path(recovery))
    except subprocess.CalledProcessError as error:
        raise SystemExit(error.stderr or str(error)) from error
    except (OSError, ValueError) as error:
        raise SystemExit(str(error)) from error
