package m0;

import android.view.View;
import android.view.WindowInsets;

public final class p0 {
    private p0() {
    }

    public static q2 a(View view) {
        WindowInsets l10 = view.getRootWindowInsets();
        if (l10 == null) {
            return null;
        }
        q2 h10 = q2.h((View) null, l10);
        m2 m2Var = h10.f10131a;
        m2Var.p(h10);
        m2Var.d(view.getRootView());
        return h10;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i10) {
        view.setScrollIndicators(i10);
    }

    public static void d(View view, int i10, int i11) {
        view.setScrollIndicators(i10, i11);
    }
}
