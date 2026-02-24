param(
    [string]$CommitMessage = ("backup: " + (Get-Date -Format "yyyy-MM-dd HH:mm:ss")),
    [string]$PrivateRemote = "private",
    [string]$PublicRemote = "origin",
    [string]$PrivateBranch = "main",
    [string]$PublicBranch = "main",
    [string]$SourceFolder = "Xtra"
)

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

function Run-Git {
    param(
        [string[]]$GitArgs,
        [string]$Cwd
    )
    if ($Cwd) {
        & git -C $Cwd @GitArgs
    } else {
        & git @GitArgs
    }
    if ($LASTEXITCODE -ne 0) {
        throw "git command failed: git $($GitArgs -join ' ')"
    }
}

$repoRoot = (& git rev-parse --show-toplevel).Trim()
if (-not $repoRoot) {
    throw "Not inside a git repository."
}

$currentBranch = (& git -C $repoRoot branch --show-current).Trim()
if ($currentBranch -ne "main") {
    throw "Run this script from main. Current branch: '$currentBranch'."
}

Write-Host "Repo root: $repoRoot"
Write-Host "Step 1/2: Backup full repository to $PrivateRemote/$PrivateBranch"

Run-Git -Cwd $repoRoot -GitArgs @("add", "-A")
$privateStatus = (& git -C $repoRoot status --porcelain)
if ($privateStatus) {
    Run-Git -Cwd $repoRoot -GitArgs @("commit", "-m", $CommitMessage)
    Write-Host "Committed private backup changes."
} else {
    Write-Host "No local changes to commit for private backup."
}
Run-Git -Cwd $repoRoot -GitArgs @("push", $PrivateRemote, $PrivateBranch)

Write-Host "Step 2/2: Backup public app-only snapshot to $PublicRemote/$PublicBranch"

$publicUrl = (& git -C $repoRoot remote get-url $PublicRemote).Trim()
if (-not $publicUrl) {
    throw "Could not resolve URL for remote '$PublicRemote'."
}

$tempDir = Join-Path $env:TEMP ("xtra-public-sync-" + [Guid]::NewGuid().ToString("N"))
Run-Git -GitArgs @("clone", "--depth", "1", "--branch", $PublicBranch, $publicUrl, $tempDir)

try {
    Get-ChildItem -Path $tempDir -Force | Where-Object { $_.Name -ne ".git" } | Remove-Item -Recurse -Force

    $trackedInSource = (& git -C $repoRoot ls-files -- "$SourceFolder/*")
    if (-not $trackedInSource) {
        throw "No tracked files found under '$SourceFolder/'."
    }

    foreach ($file in $trackedInSource) {
        $relative = $file.Substring($SourceFolder.Length + 1)
        $sourcePath = Join-Path $repoRoot $file
        $destPath = Join-Path $tempDir $relative
        $destDir = Split-Path -Path $destPath -Parent
        if ($destDir -and -not (Test-Path $destDir)) {
            New-Item -ItemType Directory -Path $destDir -Force | Out-Null
        }
        Copy-Item -Path $sourcePath -Destination $destPath -Force
    }

    Run-Git -Cwd $tempDir -GitArgs @("add", "-A")
    $publicStatus = (& git -C $tempDir status --porcelain)
    if ($publicStatus) {
        Run-Git -Cwd $tempDir -GitArgs @("commit", "-m", ($CommitMessage + " (public sync)"))
        Run-Git -Cwd $tempDir -GitArgs @("push", "origin", $PublicBranch)
        Write-Host "Public backup pushed."
    } else {
        Write-Host "No public changes to push."
    }
}
finally {
    if (Test-Path $tempDir) {
        Remove-Item -Recurse -Force $tempDir
    }
}

Write-Host "Backup complete."
