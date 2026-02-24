package androidx.emoji2.text;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import java.util.Collections;
import java.util.List;

public class c {
    public ProviderInfo a(ResolveInfo resolveInfo) {
        throw new IllegalStateException("Unable to get provider info prior to API 19");
    }

    public Signature[] b(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public List c(PackageManager packageManager, Intent intent) {
        return Collections.emptyList();
    }
}
