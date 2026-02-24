package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.result.k;
import e.b;

public final class u0 extends b {
    public final Intent a(ComponentActivity componentActivity, Intent intent) {
        Bundle bundleExtra;
        k kVar = (k) intent;
        Intent intent2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent3 = kVar.f522i;
        if (!(intent3 == null || (bundleExtra = intent3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intent3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intent3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                kVar = new k(kVar.f521h, (Intent) null, kVar.f523j, kVar.f524k);
            }
        }
        intent2.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVar);
        if (c1.I(2)) {
            intent2.toString();
        }
        return intent2;
    }

    public final Object c(int i10, Intent intent) {
        return new androidx.activity.result.b(i10, intent);
    }
}
