#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
PS1_PATH="$SCRIPT_DIR/windows_backup_both.ps1"

if ! command -v powershell.exe >/dev/null 2>&1; then
  echo "Error: powershell.exe not found. Run this from WSL on Windows."
  exit 1
fi

if ! command -v wslpath >/dev/null 2>&1; then
  echo "Error: wslpath not found."
  exit 1
fi

PS1_WIN="$(wslpath -w "$PS1_PATH")"

if [[ $# -gt 0 ]]; then
  powershell.exe -NoProfile -ExecutionPolicy Bypass -File "$PS1_WIN" -CommitMessage "$*"
else
  read -r -p "Backup comment (Enter = auto timestamp): " USER_MSG
  if [[ -n "${USER_MSG// }" ]]; then
    powershell.exe -NoProfile -ExecutionPolicy Bypass -File "$PS1_WIN" -CommitMessage "$USER_MSG"
  else
    powershell.exe -NoProfile -ExecutionPolicy Bypass -File "$PS1_WIN"
  fi
fi
