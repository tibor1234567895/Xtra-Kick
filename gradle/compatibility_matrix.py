"""Resolve supported Android emulator images and test suites."""

import argparse
import json
import os

APIS = tuple(range(26, 38))
PROFILES = {
    "smoke": (26,),
    "routine": (26, 30, 33, 36),
    "extended": (*APIS, "37-16k"),
    "release": (26, 30, 33, 36),
}


def select(profile, apis, suite):
    if profile not in PROFILES:
        raise ValueError(f"Unknown profile {profile!r}")
    available = {str(api): api for api in (*APIS, "37-16k")}
    tokens = [token.strip() for token in apis.split(",")] if apis else []
    if any(token not in available for token in tokens):
        raise ValueError("Use comma-separated APIs 26 through 37, or 37-16k")
    requested = dict.fromkeys(available[token] for token in tokens) if tokens else PROFILES[profile]
    if suite == "auto":
        suite = "smoke" if profile in {"smoke", "routine", "release"} else "functional"
    if suite not in {"smoke", "functional"}:
        raise ValueError(f"Unknown suite {suite!r}")
    lanes = []
    for item in requested:
        large_pages = item == "37-16k"
        api = 37 if large_pages else item
        lanes.append({
            "name": str(item), "sdk": api, "image": "37.0" if api == 37 else str(api),
            "target": "google_apis_ps16k" if large_pages else "default",
            "page_size": 16384 if large_pages else 0,
        })
    return {"include": lanes}, suite, profile == "release"


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--profile", default="routine")
    parser.add_argument("--apis", default="")
    parser.add_argument("--suite", default="auto")
    args = parser.parse_args()
    try:
        matrix, suite, minified = select(args.profile, args.apis, args.suite)
    except ValueError as exc:
        parser.error(str(exc))
    result = {"matrix": json.dumps(matrix), "suite": suite, "minified": str(minified).lower()}
    for key, value in result.items():
        print(f"{key}={value}")
    if output := os.environ.get("GITHUB_OUTPUT"):
        with open(output, "a", encoding="utf-8") as handle:
            handle.writelines(f"{key}={value}\n" for key, value in result.items())
