package u0;

import android.view.animation.Interpolator;

public final class f implements Interpolator {
    public final float getInterpolation(float f10) {
        float f11 = f10 - 1.0f;
        return (f11 * f11 * f11 * f11 * f11) + 1.0f;
    }
}
