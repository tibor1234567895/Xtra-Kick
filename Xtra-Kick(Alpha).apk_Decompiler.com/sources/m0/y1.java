package m0;

import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;

public final class y1 extends z1 {

    /* renamed from: e  reason: collision with root package name */
    public final WindowInsetsAnimation f10163e;

    public y1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, (Interpolator) null, 0);
        this.f10163e = windowInsetsAnimation;
    }

    public final long a() {
        return this.f10163e.getDurationMillis();
    }

    public final float b() {
        return this.f10163e.getInterpolatedFraction();
    }

    public final int c() {
        return this.f10163e.getTypeMask();
    }

    public final void d(float f10) {
        this.f10163e.setFraction(f10);
    }
}
