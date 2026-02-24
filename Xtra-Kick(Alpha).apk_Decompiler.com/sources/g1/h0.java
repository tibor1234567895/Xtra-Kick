package g1;

import android.os.Bundle;
import j1.l0;

public abstract class h0 implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final i0 f6399m = new i0(new g0());

    /* renamed from: n  reason: collision with root package name */
    public static final String f6400n = l0.C(0);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6401o = l0.C(1);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6402p = l0.C(2);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6403q = l0.C(3);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6404r = l0.C(4);

    /* renamed from: s  reason: collision with root package name */
    public static final a f6405s = new a(8);

    /* renamed from: h  reason: collision with root package name */
    public final long f6406h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6407i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6408j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6409k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f6410l;

    public h0(g0 g0Var) {
        this.f6406h = g0Var.f6377a;
        this.f6407i = g0Var.f6378b;
        this.f6408j = g0Var.f6379c;
        this.f6409k = g0Var.f6380d;
        this.f6410l = g0Var.f6381e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f6406h == h0Var.f6406h && this.f6407i == h0Var.f6407i && this.f6408j == h0Var.f6408j && this.f6409k == h0Var.f6409k && this.f6410l == h0Var.f6410l;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        i0 i0Var = f6399m;
        long j10 = i0Var.f6406h;
        long j11 = this.f6406h;
        if (j11 != j10) {
            bundle.putLong(f6400n, j11);
        }
        long j12 = i0Var.f6407i;
        long j13 = this.f6407i;
        if (j13 != j12) {
            bundle.putLong(f6401o, j13);
        }
        boolean z10 = i0Var.f6408j;
        boolean z11 = this.f6408j;
        if (z11 != z10) {
            bundle.putBoolean(f6402p, z11);
        }
        boolean z12 = i0Var.f6409k;
        boolean z13 = this.f6409k;
        if (z13 != z12) {
            bundle.putBoolean(f6403q, z13);
        }
        boolean z14 = i0Var.f6410l;
        boolean z15 = this.f6410l;
        if (z15 != z14) {
            bundle.putBoolean(f6404r, z15);
        }
        return bundle;
    }

    public final int hashCode() {
        long j10 = this.f6406h;
        long j11 = this.f6407i;
        return (((((((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f6408j ? 1 : 0)) * 31) + (this.f6409k ? 1 : 0)) * 31) + (this.f6410l ? 1 : 0);
    }
}
