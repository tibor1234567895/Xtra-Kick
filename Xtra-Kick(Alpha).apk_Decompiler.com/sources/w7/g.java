package w7;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.support.v4.media.h;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final long f16165a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final long f16166b = 300;

    /* renamed from: c  reason: collision with root package name */
    public final TimeInterpolator f16167c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f16168d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f16169e = 1;

    public g(long j10) {
        this.f16165a = j10;
        this.f16166b = 150;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.f16165a);
        objectAnimator.setDuration(this.f16166b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.f16168d);
        objectAnimator.setRepeatMode(this.f16169e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f16167c;
        return timeInterpolator != null ? timeInterpolator : a.f16154b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f16165a == gVar.f16165a && this.f16166b == gVar.f16166b && this.f16168d == gVar.f16168d && this.f16169e == gVar.f16169e) {
            return b().getClass().equals(gVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f16165a;
        long j11 = this.f16166b;
        return ((((b().getClass().hashCode() + (((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31) + this.f16168d) * 31) + this.f16169e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(Constants.WRITE_NEW_LINE);
        sb2.append(g.class.getName());
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" delay: ");
        sb2.append(this.f16165a);
        sb2.append(" duration: ");
        sb2.append(this.f16166b);
        sb2.append(" interpolator: ");
        sb2.append(b().getClass());
        sb2.append(" repeatCount: ");
        sb2.append(this.f16168d);
        sb2.append(" repeatMode: ");
        return h.o(sb2, this.f16169e, "}\n");
    }

    public g(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f16165a = j10;
        this.f16166b = j11;
        this.f16167c = timeInterpolator;
    }
}
