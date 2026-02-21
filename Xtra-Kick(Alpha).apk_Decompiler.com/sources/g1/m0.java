package g1;

import android.os.Bundle;
import j1.l0;

public final class m0 implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final m0 f6456m = new l0().a();

    /* renamed from: n  reason: collision with root package name */
    public static final String f6457n = l0.C(0);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6458o = l0.C(1);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6459p = l0.C(2);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6460q = l0.C(3);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6461r = l0.C(4);

    /* renamed from: s  reason: collision with root package name */
    public static final a f6462s = new a(9);

    /* renamed from: h  reason: collision with root package name */
    public final long f6463h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6464i;

    /* renamed from: j  reason: collision with root package name */
    public final long f6465j;

    /* renamed from: k  reason: collision with root package name */
    public final float f6466k;

    /* renamed from: l  reason: collision with root package name */
    public final float f6467l;

    public m0(long j10, long j11, long j12, float f10, float f11) {
        this.f6463h = j10;
        this.f6464i = j11;
        this.f6465j = j12;
        this.f6466k = f10;
        this.f6467l = f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.f6463h == m0Var.f6463h && this.f6464i == m0Var.f6464i && this.f6465j == m0Var.f6465j && this.f6466k == m0Var.f6466k && this.f6467l == m0Var.f6467l;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        m0 m0Var = f6456m;
        long j10 = m0Var.f6463h;
        long j11 = this.f6463h;
        if (j11 != j10) {
            bundle.putLong(f6457n, j11);
        }
        long j12 = m0Var.f6464i;
        long j13 = this.f6464i;
        if (j13 != j12) {
            bundle.putLong(f6458o, j13);
        }
        long j14 = m0Var.f6465j;
        long j15 = this.f6465j;
        if (j15 != j14) {
            bundle.putLong(f6459p, j15);
        }
        float f10 = m0Var.f6466k;
        float f11 = this.f6466k;
        if (f11 != f10) {
            bundle.putFloat(f6460q, f11);
        }
        float f12 = m0Var.f6467l;
        float f13 = this.f6467l;
        if (f13 != f12) {
            bundle.putFloat(f6461r, f13);
        }
        return bundle;
    }

    public final int hashCode() {
        long j10 = this.f6463h;
        long j11 = this.f6464i;
        long j12 = this.f6465j;
        int i10 = ((((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        int i11 = 0;
        float f10 = this.f6466k;
        int floatToIntBits = (i10 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f6467l;
        if (f11 != 0.0f) {
            i11 = Float.floatToIntBits(f11);
        }
        return floatToIntBits + i11;
    }
}
