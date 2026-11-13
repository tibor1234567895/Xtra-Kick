"""Keep local release builds on the published APK's versionCode."""

import argparse
import json
import os
from pathlib import Path
import re
import sys
import tempfile
from urllib.error import HTTPError
from urllib.request import Request, urlopen


METADATA_URL = "https://github.com/tibor1234567895/Xtra-Kick/releases/download/latest/release-version.json"
LEGACY_SOURCE_URL = "https://raw.githubusercontent.com/tibor1234567895/Xtra-Kick/latest/app/build.gradle.kts"
LEGACY_VERSION_CODE = 121
MAX_VERSION_CODE = 2_100_000_000


def validate_code(code):
    if type(code) is not int or not 1 <= code <= MAX_VERSION_CODE:
        raise ValueError("Invalid published versionCode")
    return code


def read_metadata(text):
    return validate_code(json.loads(text)["versionCode"])


def write_metadata(path, code):
    code = validate_code(code)
    path.parent.mkdir(parents=True, exist_ok=True)
    with tempfile.NamedTemporaryFile(mode="w", encoding="utf-8", dir=path.parent, delete=False) as output:
        temporary = Path(output.name)
        json.dump({"versionCode": code}, output)
        output.write("\n")
    try:
        os.replace(temporary, path)
    finally:
        temporary.unlink(missing_ok=True)


def fetch_text(url):
    request = Request(url, headers={"User-Agent": "Xtra-Kick-release-version"})
    with urlopen(request, timeout=5) as response:
        return response.read(128 * 1024).decode("utf-8")


def published_code():
    try:
        return read_metadata(fetch_text(METADATA_URL))
    except HTTPError as error:
        if error.code != 404:
            raise
    # Only the existing 2.54.0 release predates the metadata asset.
    source = fetch_text(LEGACY_SOURCE_URL)
    if re.search(r"^\s*versionCode\s*=\s*121\s*$", source, re.MULTILINE) and re.search(
        r'^\s*versionName\s*=\s*"2\.54\.0"\s*$', source, re.MULTILINE
    ):
        return LEGACY_VERSION_CODE
    raise ValueError("Published release metadata is missing; retry after Actions finishes publishing")


def local_code(cache, offline=False):
    if not offline:
        try:
            code = published_code()
        except (OSError, ValueError, KeyError, TypeError) as error:
            if not cache.exists():
                raise ValueError("Cannot resolve the published versionCode and no offline cache exists") from error
        else:
            write_metadata(cache, code)
            return code
    if not cache.exists():
        raise ValueError("No published versionCode cached; build a local release once online first")
    return read_metadata(cache.read_text(encoding="utf-8"))


def ci_code(run_number):
    if run_number < 1:
        raise ValueError("Workflow run number must be positive")
    return validate_code(LEGACY_VERSION_CODE + run_number)


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    modes = parser.add_subparsers(dest="mode", required=True)
    local = modes.add_parser("local")
    local.add_argument("--cache", required=True, type=Path)
    local.add_argument("--offline", action="store_true")
    ci = modes.add_parser("ci")
    ci.add_argument("--run-number", required=True, type=int)
    ci.add_argument("--output", required=True, type=Path)
    args = parser.parse_args()
    try:
        if args.mode == "ci":
            code = ci_code(args.run_number)
            write_metadata(args.output, code)
        else:
            code = local_code(args.cache, args.offline)
        print(code)
    except (OSError, ValueError, KeyError, TypeError) as error:
        print(f"Release version resolution failed: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
