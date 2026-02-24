package g1;

import android.os.Bundle;
import d9.d1;
import d9.r0;
import d9.t0;
import d9.u0;
import g9.b;
import j1.c;
import j1.l0;

public class y1 implements m {
    public static final y1 H = new y1(new x1());
    public static final String I = l0.C(1);
    public static final String J = l0.C(2);
    public static final String K = l0.C(3);
    public static final String L = l0.C(4);
    public static final String M = l0.C(5);
    public static final String N = l0.C(6);
    public static final String O = l0.C(7);
    public static final String P = l0.C(8);
    public static final String Q = l0.C(9);
    public static final String R = l0.C(10);
    public static final String S = l0.C(11);
    public static final String T = l0.C(12);
    public static final String U = l0.C(13);
    public static final String V = l0.C(14);
    public static final String W = l0.C(15);
    public static final String X = l0.C(16);
    public static final String Y = l0.C(17);
    public static final String Z = l0.C(18);

    /* renamed from: a0  reason: collision with root package name */
    public static final String f6717a0 = l0.C(19);

    /* renamed from: b0  reason: collision with root package name */
    public static final String f6718b0 = l0.C(20);

    /* renamed from: c0  reason: collision with root package name */
    public static final String f6719c0 = l0.C(21);

    /* renamed from: d0  reason: collision with root package name */
    public static final String f6720d0 = l0.C(22);

    /* renamed from: e0  reason: collision with root package name */
    public static final String f6721e0 = l0.C(23);

    /* renamed from: f0  reason: collision with root package name */
    public static final String f6722f0 = l0.C(24);

    /* renamed from: g0  reason: collision with root package name */
    public static final String f6723g0 = l0.C(25);

    /* renamed from: h0  reason: collision with root package name */
    public static final String f6724h0 = l0.C(26);
    public final int A;
    public final int B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final t0 F;
    public final u0 G;

    /* renamed from: h  reason: collision with root package name */
    public final int f6725h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6726i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6727j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6728k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6729l;

    /* renamed from: m  reason: collision with root package name */
    public final int f6730m;

    /* renamed from: n  reason: collision with root package name */
    public final int f6731n;

    /* renamed from: o  reason: collision with root package name */
    public final int f6732o;

    /* renamed from: p  reason: collision with root package name */
    public final int f6733p;

    /* renamed from: q  reason: collision with root package name */
    public final int f6734q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f6735r;

    /* renamed from: s  reason: collision with root package name */
    public final r0 f6736s;

    /* renamed from: t  reason: collision with root package name */
    public final int f6737t;

    /* renamed from: u  reason: collision with root package name */
    public final r0 f6738u;

    /* renamed from: v  reason: collision with root package name */
    public final int f6739v;

    /* renamed from: w  reason: collision with root package name */
    public final int f6740w;

    /* renamed from: x  reason: collision with root package name */
    public final int f6741x;

    /* renamed from: y  reason: collision with root package name */
    public final r0 f6742y;

    /* renamed from: z  reason: collision with root package name */
    public final r0 f6743z;

    public y1(x1 x1Var) {
        this.f6725h = x1Var.f6690a;
        this.f6726i = x1Var.f6691b;
        this.f6727j = x1Var.f6692c;
        this.f6728k = x1Var.f6693d;
        this.f6729l = x1Var.f6694e;
        this.f6730m = x1Var.f6695f;
        this.f6731n = x1Var.f6696g;
        this.f6732o = x1Var.f6697h;
        this.f6733p = x1Var.f6698i;
        this.f6734q = x1Var.f6699j;
        this.f6735r = x1Var.f6700k;
        this.f6736s = x1Var.f6701l;
        this.f6737t = x1Var.f6702m;
        this.f6738u = x1Var.f6703n;
        this.f6739v = x1Var.f6704o;
        this.f6740w = x1Var.f6705p;
        this.f6741x = x1Var.f6706q;
        this.f6742y = x1Var.f6707r;
        this.f6743z = x1Var.f6708s;
        this.A = x1Var.f6709t;
        this.B = x1Var.f6710u;
        this.C = x1Var.f6711v;
        this.D = x1Var.f6712w;
        this.E = x1Var.f6713x;
        this.F = t0.a(x1Var.f6714y);
        this.G = u0.j(x1Var.f6715z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        y1 y1Var = (y1) obj;
        if (this.f6725h == y1Var.f6725h && this.f6726i == y1Var.f6726i && this.f6727j == y1Var.f6727j && this.f6728k == y1Var.f6728k && this.f6729l == y1Var.f6729l && this.f6730m == y1Var.f6730m && this.f6731n == y1Var.f6731n && this.f6732o == y1Var.f6732o && this.f6735r == y1Var.f6735r && this.f6733p == y1Var.f6733p && this.f6734q == y1Var.f6734q && this.f6736s.equals(y1Var.f6736s) && this.f6737t == y1Var.f6737t && this.f6738u.equals(y1Var.f6738u) && this.f6739v == y1Var.f6739v && this.f6740w == y1Var.f6740w && this.f6741x == y1Var.f6741x && this.f6742y.equals(y1Var.f6742y) && this.f6743z.equals(y1Var.f6743z) && this.A == y1Var.A && this.B == y1Var.B && this.C == y1Var.C && this.D == y1Var.D && this.E == y1Var.E) {
            t0 t0Var = this.F;
            t0Var.getClass();
            if (!d1.a(t0Var, y1Var.F) || !this.G.equals(y1Var.G)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(N, this.f6725h);
        bundle.putInt(O, this.f6726i);
        bundle.putInt(P, this.f6727j);
        bundle.putInt(Q, this.f6728k);
        bundle.putInt(R, this.f6729l);
        bundle.putInt(S, this.f6730m);
        bundle.putInt(T, this.f6731n);
        bundle.putInt(U, this.f6732o);
        bundle.putInt(V, this.f6733p);
        bundle.putInt(W, this.f6734q);
        bundle.putBoolean(X, this.f6735r);
        r0 r0Var = this.f6736s;
        bundle.putStringArray(Y, (String[]) r0Var.toArray(new String[0]));
        bundle.putInt(f6723g0, this.f6737t);
        bundle.putStringArray(I, (String[]) this.f6738u.toArray(new String[0]));
        bundle.putInt(J, this.f6739v);
        bundle.putInt(Z, this.f6740w);
        bundle.putInt(f6717a0, this.f6741x);
        bundle.putStringArray(f6718b0, (String[]) this.f6742y.toArray(new String[0]));
        bundle.putStringArray(K, (String[]) this.f6743z.toArray(new String[0]));
        bundle.putInt(L, this.A);
        bundle.putInt(f6724h0, this.B);
        bundle.putBoolean(M, this.C);
        bundle.putBoolean(f6719c0, this.D);
        bundle.putBoolean(f6720d0, this.E);
        bundle.putParcelableArrayList(f6721e0, c.b(this.F.values()));
        bundle.putIntArray(f6722f0, b.d(this.G));
        return bundle;
    }

    public int hashCode() {
        int hashCode = this.f6736s.hashCode();
        int hashCode2 = this.f6738u.hashCode();
        int hashCode3 = this.f6742y.hashCode();
        int hashCode4 = this.f6743z.hashCode();
        int hashCode5 = this.F.hashCode();
        return this.G.hashCode() + ((hashCode5 + ((((((((((((hashCode4 + ((hashCode3 + ((((((((hashCode2 + ((((hashCode + ((((((((((((((((((((((this.f6725h + 31) * 31) + this.f6726i) * 31) + this.f6727j) * 31) + this.f6728k) * 31) + this.f6729l) * 31) + this.f6730m) * 31) + this.f6731n) * 31) + this.f6732o) * 31) + (this.f6735r ? 1 : 0)) * 31) + this.f6733p) * 31) + this.f6734q) * 31)) * 31) + this.f6737t) * 31)) * 31) + this.f6739v) * 31) + this.f6740w) * 31) + this.f6741x) * 31)) * 31)) * 31) + this.A) * 31) + this.B) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31)) * 31);
    }

    public x1 i() {
        return new x1(this);
    }
}
