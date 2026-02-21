package q0;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import n1.b0;

public final class g {
    private g() {
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        try {
            f.i();
            return b0.r(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    public static float b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static float c(EdgeEffect edgeEffect, float f10, float f11) {
        try {
            return edgeEffect.onPullDistance(f10, f11);
        } catch (Throwable unused) {
            edgeEffect.onPull(f10, f11);
            return 0.0f;
        }
    }
}
