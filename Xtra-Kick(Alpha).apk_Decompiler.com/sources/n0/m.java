package n0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeProvider;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Object f10920a;

    public m() {
        this.f10920a = Build.VERSION.SDK_INT >= 26 ? new l(this) : new k(this);
    }

    public i a(int i10) {
        return null;
    }

    public i b(int i10) {
        return null;
    }

    public boolean c(int i10, int i11, Bundle bundle) {
        return false;
    }

    public m(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f10920a = accessibilityNodeProvider;
    }
}
