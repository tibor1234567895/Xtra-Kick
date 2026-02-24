package b4;

import android.os.Build;
import android.view.ViewGroup;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2539a = true;

    private f0() {
    }

    public static void a(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else if (f2539a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f2539a = false;
            }
        }
    }
}
