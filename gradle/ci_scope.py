"""Select CI checks from a complete, NUL-delimited Git diff."""

import argparse
import os
from pathlib import PurePosixPath
import subprocess


def classify(paths):
    documentation = {"LICENSE", "NOTICE"}
    graphics = {".png", ".webp", ".jpg", ".jpeg"}
    scope = "docs"
    for path in paths:
        file = PurePosixPath(path)
        if len(file.parts) == 1 and file.name in documentation:
            continue
        if (len(file.parts) == 1 or path.startswith("docs/")) and file.suffix.lower() in {".md", ".rst"}:
            continue
        if (path.startswith("app/src/main/res/drawable") and file.suffix in graphics
                or path.startswith("app/src/test/")):
            scope = "small"
        else:
            return "full"
    return scope


def compare(base):
    if not base or not base.strip("0"):
        return "full"
    try:
        diff = subprocess.run(
            ["git", "diff", "--relative", "--name-only", "--no-renames", "-z", base, "HEAD", "--"],
            stdout=subprocess.PIPE, stderr=subprocess.PIPE, check=True,
        )
    except subprocess.CalledProcessError:
        print("Unable to compare Git revisions. Running the full suite.")
        return "full"
    return classify(os.fsdecode(path) for path in diff.stdout.split(b"\0") if path)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--base", help="Base commit, omit to force the full suite")
    args = parser.parse_args()
    scope = compare(args.base)
    print(f"Android CI scope: {scope}")
    if output := os.environ.get("GITHUB_OUTPUT"):
        with open(output, "a", encoding="utf-8") as handle:
            handle.write(f"scope={scope}\n")
