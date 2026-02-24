package g1;

import android.os.Bundle;
import j1.l0;

public final class s0 implements m {

    /* renamed from: n  reason: collision with root package name */
    public static final s0 f6549n = new f0().a();

    /* renamed from: o  reason: collision with root package name */
    public static final String f6550o = l0.C(0);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6551p = l0.C(1);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6552q = l0.C(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6553r = l0.C(3);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6554s = l0.C(4);

    /* renamed from: t  reason: collision with root package name */
    public static final a f6555t = new a(7);

    /* renamed from: h  reason: collision with root package name */
    public final String f6556h;

    /* renamed from: i  reason: collision with root package name */
    public final n0 f6557i;

    /* renamed from: j  reason: collision with root package name */
    public final m0 f6558j;

    /* renamed from: k  reason: collision with root package name */
    public final v0 f6559k;

    /* renamed from: l  reason: collision with root package name */
    public final i0 f6560l;

    /* renamed from: m  reason: collision with root package name */
    public final p0 f6561m;

    public s0(String str, i0 i0Var, n0 n0Var, m0 m0Var, v0 v0Var, p0 p0Var) {
        this.f6556h = str;
        this.f6557i = n0Var;
        this.f6558j = m0Var;
        this.f6559k = v0Var;
        this.f6560l = i0Var;
        this.f6561m = p0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return l0.a(this.f6556h, s0Var.f6556h) && this.f6560l.equals(s0Var.f6560l) && l0.a(this.f6557i, s0Var.f6557i) && l0.a(this.f6558j, s0Var.f6558j) && l0.a(this.f6559k, s0Var.f6559k) && l0.a(this.f6561m, s0Var.f6561m);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        String str = this.f6556h;
        if (!str.equals("")) {
            bundle.putString(f6550o, str);
        }
        m0 m0Var = m0.f6456m;
        m0 m0Var2 = this.f6558j;
        if (!m0Var2.equals(m0Var)) {
            bundle.putBundle(f6551p, m0Var2.h());
        }
        v0 v0Var = v0.P;
        v0 v0Var2 = this.f6559k;
        if (!v0Var2.equals(v0Var)) {
            bundle.putBundle(f6552q, v0Var2.h());
        }
        i0 i0Var = h0.f6399m;
        i0 i0Var2 = this.f6560l;
        if (!i0Var2.equals(i0Var)) {
            bundle.putBundle(f6553r, i0Var2.h());
        }
        p0 p0Var = p0.f6501k;
        p0 p0Var2 = this.f6561m;
        if (!p0Var2.equals(p0Var)) {
            bundle.putBundle(f6554s, p0Var2.h());
        }
        return bundle;
    }

    public final int hashCode() {
        int hashCode = this.f6556h.hashCode() * 31;
        n0 n0Var = this.f6557i;
        int b10 = n0Var != null ? n0Var.hashCode() : 0;
        int hashCode2 = this.f6558j.hashCode();
        int hashCode3 = this.f6560l.hashCode();
        return this.f6561m.hashCode() + ((this.f6559k.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + b10) * 31)) * 31)) * 31)) * 31);
    }
}
