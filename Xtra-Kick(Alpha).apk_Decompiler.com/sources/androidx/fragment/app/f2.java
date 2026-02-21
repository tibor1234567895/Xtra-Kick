package androidx.fragment.app;

import android.support.v4.media.h;
import android.view.View;

public final class f2 {
    private f2() {
    }

    public /* synthetic */ f2(int i10) {
        this();
    }

    public static g2 a(View view) {
        return (!((view.getAlpha() > 0.0f ? 1 : (view.getAlpha() == 0.0f ? 0 : -1)) == 0) || view.getVisibility() != 0) ? b(view.getVisibility()) : g2.INVISIBLE;
    }

    public static g2 b(int i10) {
        if (i10 == 0) {
            return g2.VISIBLE;
        }
        if (i10 == 4) {
            return g2.INVISIBLE;
        }
        if (i10 == 8) {
            return g2.GONE;
        }
        throw new IllegalArgumentException(h.i("Unknown visibility ", i10));
    }
}
