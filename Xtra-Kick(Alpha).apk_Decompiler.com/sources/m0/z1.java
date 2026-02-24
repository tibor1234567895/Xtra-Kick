package m0;

import android.view.animation.Interpolator;

public abstract class z1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f10165a;

    /* renamed from: b  reason: collision with root package name */
    public float f10166b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f10167c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10168d;

    public z1(int i10, Interpolator interpolator, long j10) {
        this.f10165a = i10;
        this.f10167c = interpolator;
        this.f10168d = j10;
    }

    public long a() {
        return this.f10168d;
    }

    public float b() {
        Interpolator interpolator = this.f10167c;
        return interpolator != null ? interpolator.getInterpolation(this.f10166b) : this.f10166b;
    }

    public int c() {
        return this.f10165a;
    }

    public void d(float f10) {
        this.f10166b = f10;
    }
}
