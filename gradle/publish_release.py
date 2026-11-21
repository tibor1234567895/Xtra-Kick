"""Stage and verify GitHub release assets before replacing the live downloads."""

import hashlib
import json
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile
import time


RECOVERY_ASSET = "xtra-release-recovery.pending.json"


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


def promote(release_id, current, planned):
    for name, plan in planned.items():
        asset_id, digest = plan["next"]
        asset = current.get(name, {})
        if asset.get("id") != asset_id:
            asset = current.get(plan["staging"], {})
        if (asset.get("id"), asset.get("digest"), asset.get("state")) != (asset_id, digest, "uploaded"):
            raise ValueError(f"Prepared asset {name} is missing or has changed")
        live_id = current.get(name, {}).get("id")
        if live_id not in (None, asset_id, plan["previous"]):
            raise ValueError(f"Live asset {name} has changed")

    try:
        for name, plan in planned.items():
            live = current.get(name)
            if live and live["id"] == plan["next"][0]:
                continue
            if live:
                rename(live, f"previous-{live['id']}-{name}")
            rename(current[plan["staging"]], name)
    except subprocess.CalledProcessError:
        # Check remote names because a lost response can follow a successful rename.
        live = assets(release_id)
        for name, plan in reversed(planned.items()):
            promoted = live.get(name)
            if promoted and promoted["id"] == plan["next"][0]:
                rename(promoted, plan["staging"])
            if plan["previous"] is not None:
                backup = live.get(f"previous-{plan['previous']}-{name}")
                if backup and backup["id"] == plan["previous"]:
                    rename(backup, name)
        raise


def release_api(release_id):
    return f"repos/{{owner}}/{{repo}}/releases/{release_id}"


def update_latest_tag(sha):
    endpoint = "repos/{owner}/{repo}/git/ref/tags/latest"
    try:
        ref = json.loads(gh("api", endpoint))
    except subprocess.CalledProcessError as error:
        if "HTTP 404" not in (error.stderr or ""):
            raise
        gh("api", "--method", "POST", "repos/{owner}/{repo}/git/refs", "--input", "-",
           input_text=json.dumps({"ref": "refs/tags/latest", "sha": sha}))
    else:
        if ref["object"]["sha"] != sha:
            gh("api", "--method", "PATCH", "repos/{owner}/{repo}/git/refs/tags/latest", "--input", "-",
               input_text=json.dumps({"sha": sha, "force": True}))
    if json.loads(gh("api", endpoint))["object"]["sha"] != sha:
        raise ValueError("GitHub did not confirm the expected latest tag")


def finish_publication(state, journal):
    endpoint = release_api(state["release_id"])
    payload = {"draft": False, "name": "Latest", "body": state["notes"], "make_latest": "true"}
    release = json.loads(gh("api", endpoint))
    if release.get("tag_name") != "latest":
        raise ValueError("Prepared release no longer has the latest tag")
    current = assets(state["release_id"])
    canonical_pair_ready = all(current.get(name, {}).get("id") == plan["next"][0]
                               for name, plan in state["assets"].items())
    if not release["draft"] and not canonical_pair_ready:
        drafted = json.loads(gh("api", "--method", "PATCH", endpoint, "-F", "draft=true"))
        if drafted.get("draft") is not True:
            raise ValueError("GitHub did not confirm the release is hidden during promotion")
    promote(state["release_id"], current, state["assets"])
    update_latest_tag(state["sha"])

    for attempt in range(1, 4):
        try:
            current = assets(state["release_id"])
            for name, plan in state["assets"].items():
                asset = current.get(name, {})
                if (asset.get("id"), asset.get("digest"), asset.get("state")) != (*plan["next"], "uploaded"):
                    raise ValueError(f"Prepared asset {name} is missing or has changed")
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

    for name, plan in state["assets"].items():
        backup = current.get(f"previous-{plan['previous']}-{name}")
        if backup and backup["id"] == plan["previous"]:
            try:
                gh("api", "--method", "DELETE", asset_api(backup))
            except subprocess.CalledProcessError:
                print(f"Previous asset {backup['name']} could not be removed", file=sys.stderr)

    before = state["published_at"]
    after = release.get("published_at")
    if before and (not after or after <= before):
        print(f"::warning::GitHub kept the previous release publication date ({before}).")
    try:
        gh("api", "--method", "DELETE", asset_api(journal))
    except subprocess.CalledProcessError:
        if RECOVERY_ASSET in assets(state["release_id"]):
            raise


def recover_publication():
    release = latest_release()
    if release is None:
        return False
    journal = assets(release["id"]).get(RECOVERY_ASSET)
    if journal is None:
        return False
    if journal["state"] != "uploaded":
        # Promotion requires a verified upload, so a failed upload cannot have started it.
        gh("api", "--method", "DELETE", asset_api(journal))
        return False
    content = gh("api", asset_api(journal), "-H", "Accept: application/octet-stream")
    digest = hashlib.sha256(content.encode("utf-8")).hexdigest()
    if journal.get("digest") != f"sha256:{digest}":
        raise ValueError("GitHub release recovery record failed verification")
    state = json.loads(content)
    if state["release_id"] != release["id"]:
        raise ValueError("Recovery record belongs to a different release")
    finish_publication(state, journal)
    return True


def publish(code, sha, notes, paths):
    recover_publication()
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
        state = {
            "release_id": release_id,
            "sha": sha,
            "published_at": latest.get("published_at"),
            "notes": release_notes,
            "assets": {
                path.name: {
                    "staging": name,
                    "next": [current[name]["id"], current[name]["digest"]],
                    "previous": current.get(path.name, {}).get("id"),
                }
                for path, name in staged
            },
        }
        # A later runner can finish the swap even if this one is forcibly stopped.
        recovery_path = Path(directory) / RECOVERY_ASSET
        recovery_path.write_text(json.dumps(state), encoding="utf-8")
        gh("release", "upload", "latest", str(recovery_path))
        journal = assets(release_id)[RECOVERY_ASSET]
        verify(journal, recovery_path)
    finish_publication(state, journal)


if __name__ == "__main__":
    try:
        if sys.argv[1] == "--recover":
            if not recover_publication() and "--required" in sys.argv[2:]:
                raise ValueError("No pending release publication to recover")
        else:
            code, sha, notes, *files = sys.argv[1:]
            publish(code, sha, notes, [Path(file) for file in files])
    except subprocess.CalledProcessError as error:
        raise SystemExit(error.stderr or str(error)) from error
    except (OSError, ValueError) as error:
        raise SystemExit(str(error)) from error
