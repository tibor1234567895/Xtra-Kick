package androidx.emoji2.text;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import java.util.List;

public class d extends c {
    public final ProviderInfo a(ResolveInfo resolveInfo) {
        return resolveInfo.providerInfo;
    }

    public final List c(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentContentProviders(intent, 0);
    }
}
