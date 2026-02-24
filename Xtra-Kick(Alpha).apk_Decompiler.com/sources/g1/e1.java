package g1;

import android.os.Bundle;
import j1.a;
import j1.l0;

public final class e1 implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final e1 f6351k = new e1(1.0f);

    /* renamed from: l  reason: collision with root package name */
    public static final String f6352l = l0.C(0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6353m = l0.C(1);

    /* renamed from: n  reason: collision with root package name */
    public static final a f6354n = new a(14);

    /* renamed from: h  reason: collision with root package name */
    public final float f6355h;

    /* renamed from: i  reason: collision with root package name */
    public final float f6356i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6357j;

    public e1(float f10) {
        this(f10, 1.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e1.class != obj.getClass()) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.f6355h == e1Var.f6355h && this.f6356i == e1Var.f6356i;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putFloat(f6352l, this.f6355h);
        bundle.putFloat(f6353m, this.f6356i);
        return bundle;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f6356i) + ((Float.floatToRawIntBits(this.f6355h) + 527) * 31);
    }

    public final String toString() {
        return l0.l("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f6355h), Float.valueOf(this.f6356i));
    }

    public e1(float f10, float f11) {
        boolean z10 = true;
        a.b(f10 > 0.0f);
        a.b(f11 <= 0.0f ? false : z10);
        this.f6355h = f10;
        this.f6356i = f11;
        this.f6357j = Math.round(f10 * 1000.0f);
    }
}
