#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
Usage: scripts/wsl_build_install.sh [options]

Builds debug APK from a fast WSL workspace and installs it via ADB.

Options:
  --serial SERIAL       ADB device serial (default: first online device)
  --source DIR          Source Android project dir (default: <repo>/Xtra)
  --workdir DIR         WSL build dir (default: $HOME/xtra-wsl-build)
  --sdk-dir DIR         Android SDK dir for WSL local.properties
  --task TASK           Gradle task (default: :app:assembleDebug)
  --skip-sync           Skip rsync from source to workdir
  -h, --help            Show this help
EOF
}

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd -- "${SCRIPT_DIR}/.." && pwd)"

SOURCE_DIR="${REPO_ROOT}/Xtra"
WORKDIR="${HOME}/xtra-wsl-build"
TASK=":app:assembleDebug"
SERIAL="${ADB_SERIAL:-}"
SKIP_SYNC=0
SDK_DIR="${ANDROID_SDK_ROOT:-}"

while [[ $# -gt 0 ]]; do
  case "$1" in
    --serial)
      SERIAL="${2:-}"
      shift 2
      ;;
    --source)
      SOURCE_DIR="${2:-}"
      shift 2
      ;;
    --workdir)
      WORKDIR="${2:-}"
      shift 2
      ;;
    --sdk-dir)
      SDK_DIR="${2:-}"
      shift 2
      ;;
    --task)
      TASK="${2:-}"
      shift 2
      ;;
    --skip-sync)
      SKIP_SYNC=1
      shift
      ;;
    -h|--help)
      usage
      exit 0
      ;;
    *)
      echo "Unknown option: $1" >&2
      usage
      exit 1
      ;;
  esac
done

if [[ ! -d "${SOURCE_DIR}" ]]; then
  echo "Source dir not found: ${SOURCE_DIR}" >&2
  exit 1
fi

if [[ -z "${SDK_DIR}" ]]; then
  if [[ -d "${HOME}/Android/Sdk" ]]; then
    SDK_DIR="${HOME}/Android/Sdk"
  else
    echo "Android SDK dir not found. Pass --sdk-dir or set ANDROID_SDK_ROOT." >&2
    exit 1
  fi
fi

if [[ ! -d "${SDK_DIR}" ]]; then
  echo "SDK dir does not exist: ${SDK_DIR}" >&2
  exit 1
fi

if ! command -v adb >/dev/null 2>&1; then
  echo "adb not found in PATH." >&2
  exit 1
fi

if [[ -z "${SERIAL}" ]]; then
  SERIAL="$(adb devices | awk 'NR>1 && $2=="device" {print $1; exit}')"
fi

if [[ -z "${SERIAL}" ]]; then
  echo "No online ADB device found. Connect/start one or pass --serial." >&2
  exit 1
fi

mkdir -p "${WORKDIR}"

if [[ "${SKIP_SYNC}" -eq 0 ]]; then
  echo "Syncing source -> ${WORKDIR}"
  rsync -a --delete \
    --exclude '.gradle/' \
    --exclude 'build/' \
    --exclude '.idea/' \
    --exclude '.kotlin/' \
    "${SOURCE_DIR}/" "${WORKDIR}/"
fi

printf 'sdk.dir=%s\n' "${SDK_DIR}" > "${WORKDIR}/local.properties"

echo "Building ${TASK} in ${WORKDIR}"
SECONDS=0
(cd "${WORKDIR}" && ./gradlew "${TASK}")
echo "Build completed in ${SECONDS}s"

APK="${WORKDIR}/app/build/outputs/apk/debug/app-debug.apk"
if [[ ! -f "${APK}" ]]; then
  echo "APK not found at ${APK}" >&2
  exit 1
fi

echo "Installing to ${SERIAL}"
adb -s "${SERIAL}" install -r -t "${APK}"
echo "Installed ${APK}"
