"""Reserve headroom for this workflow's short-lived artifacts."""

import os
import subprocess
import sys

MAX_EXISTING_BYTES = 300_000_000


def main():
    repository = os.environ["GITHUB_REPOSITORY"]
    result = subprocess.run(
        ["gh", "api", "--paginate", f"repos/{repository}/actions/artifacts?per_page=100",
         "--jq", ".artifacts[] | select(.expired == false) | .size_in_bytes"],
        capture_output=True, check=True, text=True, timeout=60,
    )
    used = sum(int(size) for size in result.stdout.split())
    print(f"Current repository Actions artifacts: {used} bytes")
    if used > MAX_EXISTING_BYTES:
        sys.exit("Artifact headroom exhausted. Check storage usage and expiry before rerunning.")


if __name__ == "__main__":
    main()
