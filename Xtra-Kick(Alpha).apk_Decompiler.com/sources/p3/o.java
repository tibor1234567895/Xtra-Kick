package p3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class o {
    private o() {
    }

    public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
    }
}
