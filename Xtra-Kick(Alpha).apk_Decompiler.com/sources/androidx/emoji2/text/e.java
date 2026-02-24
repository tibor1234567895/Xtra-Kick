package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

public final class e extends d {
    public final Signature[] b(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
