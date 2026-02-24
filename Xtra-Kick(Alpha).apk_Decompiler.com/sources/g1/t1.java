package g1;

import android.net.Uri;
import android.os.Bundle;
import j1.a;
import j1.l0;

public final class t1 implements m {
    public static final s0 A;
    public static final String B = l0.C(1);
    public static final String C = l0.C(2);
    public static final String D = l0.C(3);
    public static final String E = l0.C(4);
    public static final String F = l0.C(5);
    public static final String G = l0.C(6);
    public static final String H = l0.C(7);
    public static final String I = l0.C(8);
    public static final String J = l0.C(9);
    public static final String K = l0.C(10);
    public static final String L = l0.C(11);
    public static final String M = l0.C(12);
    public static final String N = l0.C(13);
    public static final a O = new a(22);

    /* renamed from: y  reason: collision with root package name */
    public static final Object f6573y = new Object();

    /* renamed from: z  reason: collision with root package name */
    public static final Object f6574z = new Object();

    /* renamed from: h  reason: collision with root package name */
    public Object f6575h = f6573y;

    /* renamed from: i  reason: collision with root package name */
    public Object f6576i;

    /* renamed from: j  reason: collision with root package name */
    public s0 f6577j = A;

    /* renamed from: k  reason: collision with root package name */
    public Object f6578k;

    /* renamed from: l  reason: collision with root package name */
    public long f6579l;

    /* renamed from: m  reason: collision with root package name */
    public long f6580m;

    /* renamed from: n  reason: collision with root package name */
    public long f6581n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6582o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6583p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6584q;

    /* renamed from: r  reason: collision with root package name */
    public m0 f6585r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6586s;

    /* renamed from: t  reason: collision with root package name */
    public long f6587t;

    /* renamed from: u  reason: collision with root package name */
    public long f6588u;

    /* renamed from: v  reason: collision with root package name */
    public int f6589v;

    /* renamed from: w  reason: collision with root package name */
    public int f6590w;

    /* renamed from: x  reason: collision with root package name */
    public long f6591x;

    static {
        f0 f0Var = new f0();
        f0Var.f6358a = "androidx.media3.common.Timeline";
        f0Var.f6359b = Uri.EMPTY;
        A = f0Var.a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t1.class.equals(obj.getClass())) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return l0.a(this.f6575h, t1Var.f6575h) && l0.a(this.f6577j, t1Var.f6577j) && l0.a(this.f6578k, t1Var.f6578k) && l0.a(this.f6585r, t1Var.f6585r) && this.f6579l == t1Var.f6579l && this.f6580m == t1Var.f6580m && this.f6581n == t1Var.f6581n && this.f6582o == t1Var.f6582o && this.f6583p == t1Var.f6583p && this.f6586s == t1Var.f6586s && this.f6587t == t1Var.f6587t && this.f6588u == t1Var.f6588u && this.f6589v == t1Var.f6589v && this.f6590w == t1Var.f6590w && this.f6591x == t1Var.f6591x;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        if (!s0.f6549n.equals(this.f6577j)) {
            bundle.putBundle(B, this.f6577j.h());
        }
        long j10 = this.f6579l;
        if (j10 != -9223372036854775807L) {
            bundle.putLong(C, j10);
        }
        long j11 = this.f6580m;
        if (j11 != -9223372036854775807L) {
            bundle.putLong(D, j11);
        }
        long j12 = this.f6581n;
        if (j12 != -9223372036854775807L) {
            bundle.putLong(E, j12);
        }
        boolean z10 = this.f6582o;
        if (z10) {
            bundle.putBoolean(F, z10);
        }
        boolean z11 = this.f6583p;
        if (z11) {
            bundle.putBoolean(G, z11);
        }
        m0 m0Var = this.f6585r;
        if (m0Var != null) {
            bundle.putBundle(H, m0Var.h());
        }
        boolean z12 = this.f6586s;
        if (z12) {
            bundle.putBoolean(I, z12);
        }
        long j13 = this.f6587t;
        if (j13 != 0) {
            bundle.putLong(J, j13);
        }
        long j14 = this.f6588u;
        if (j14 != -9223372036854775807L) {
            bundle.putLong(K, j14);
        }
        int i10 = this.f6589v;
        if (i10 != 0) {
            bundle.putInt(L, i10);
        }
        int i11 = this.f6590w;
        if (i11 != 0) {
            bundle.putInt(M, i11);
        }
        long j15 = this.f6591x;
        if (j15 != 0) {
            bundle.putLong(N, j15);
        }
        return bundle;
    }

    public final int hashCode() {
        int hashCode = (this.f6577j.hashCode() + ((this.f6575h.hashCode() + 217) * 31)) * 31;
        Object obj = this.f6578k;
        int i10 = 0;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        m0 m0Var = this.f6585r;
        if (m0Var != null) {
            i10 = m0Var.hashCode();
        }
        long j10 = this.f6579l;
        long j11 = this.f6580m;
        long j12 = this.f6581n;
        long j13 = this.f6587t;
        long j14 = this.f6588u;
        long j15 = this.f6591x;
        return ((((((((((((((((((((((hashCode2 + i10) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f6582o ? 1 : 0)) * 31) + (this.f6583p ? 1 : 0)) * 31) + (this.f6586s ? 1 : 0)) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f6589v) * 31) + this.f6590w) * 31) + ((int) (j15 ^ (j15 >>> 32)));
    }

    public final long i() {
        return l0.Q(this.f6587t);
    }

    public final long j() {
        return l0.Q(this.f6588u);
    }

    public final boolean k() {
        a.e(this.f6584q == (this.f6585r != null));
        return this.f6585r != null;
    }

    public final void l(Object obj, s0 s0Var, Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, m0 m0Var, long j13, long j14, int i10, int i11, long j15) {
        n0 n0Var;
        s0 s0Var2 = s0Var;
        m0 m0Var2 = m0Var;
        this.f6575h = obj;
        this.f6577j = s0Var2 != null ? s0Var2 : A;
        this.f6576i = (s0Var2 == null || (n0Var = s0Var2.f6557i) == null) ? null : n0Var.f6484g;
        this.f6578k = obj2;
        this.f6579l = j10;
        this.f6580m = j11;
        this.f6581n = j12;
        this.f6582o = z10;
        this.f6583p = z11;
        this.f6584q = m0Var2 != null;
        this.f6585r = m0Var2;
        this.f6587t = j13;
        this.f6588u = j14;
        this.f6589v = i10;
        this.f6590w = i11;
        this.f6591x = j15;
        this.f6586s = false;
    }
}
