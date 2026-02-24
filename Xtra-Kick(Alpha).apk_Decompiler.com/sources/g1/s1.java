package g1;

import d9.r0;
import d9.r1;
import j1.a;

public final class s1 extends u1 {

    /* renamed from: m  reason: collision with root package name */
    public final r0 f6562m;

    /* renamed from: n  reason: collision with root package name */
    public final r0 f6563n;

    /* renamed from: o  reason: collision with root package name */
    public final int[] f6564o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f6565p;

    public s1(r1 r1Var, r1 r1Var2, int[] iArr) {
        boolean z10;
        if (r1Var.f4660k == iArr.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        this.f6562m = r1Var;
        this.f6563n = r1Var2;
        this.f6564o = iArr;
        this.f6565p = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f6565p[iArr[i10]] = i10;
        }
    }

    public final int j(boolean z10) {
        if (y()) {
            return -1;
        }
        if (z10) {
            return this.f6564o[0];
        }
        return 0;
    }

    public final int k(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int l(boolean z10) {
        if (y()) {
            return -1;
        }
        if (!z10) {
            return x() - 1;
        }
        return this.f6564o[x() - 1];
    }

    public final int n(int i10, int i11, boolean z10) {
        if (i11 == 1) {
            return i10;
        }
        if (i10 == l(z10)) {
            if (i11 == 2) {
                return j(z10);
            }
            return -1;
        } else if (!z10) {
            return i10 + 1;
        } else {
            return this.f6564o[this.f6565p[i10] + 1];
        }
    }

    public final r1 o(int i10, r1 r1Var, boolean z10) {
        r1 r1Var2 = (r1) this.f6563n.get(i10);
        r1Var.q(r1Var2.f6542h, r1Var2.f6543i, r1Var2.f6544j, r1Var2.f6545k, r1Var2.f6546l, r1Var2.f6548n, r1Var2.f6547m);
        return r1Var;
    }

    public final int q() {
        return this.f6563n.size();
    }

    public final int t(int i10, int i11, boolean z10) {
        if (i11 == 1) {
            return i10;
        }
        if (i10 == j(z10)) {
            if (i11 == 2) {
                return l(z10);
            }
            return -1;
        } else if (!z10) {
            return i10 - 1;
        } else {
            return this.f6564o[this.f6565p[i10] - 1];
        }
    }

    public final Object u(int i10) {
        throw new UnsupportedOperationException();
    }

    public final t1 w(int i10, t1 t1Var, long j10) {
        t1 t1Var2 = t1Var;
        t1 t1Var3 = (t1) this.f6562m.get(i10);
        Object obj = t1Var3.f6575h;
        s0 s0Var = t1Var3.f6577j;
        s0 s0Var2 = s0Var;
        t1 t1Var4 = t1Var3;
        t1 t1Var5 = t1Var;
        t1Var5.l(obj, s0Var2, t1Var3.f6578k, t1Var3.f6579l, t1Var3.f6580m, t1Var3.f6581n, t1Var3.f6582o, t1Var3.f6583p, t1Var3.f6585r, t1Var3.f6587t, t1Var4.f6588u, t1Var4.f6589v, t1Var4.f6590w, t1Var4.f6591x);
        t1 t1Var6 = t1Var;
        t1Var6.f6586s = t1Var4.f6586s;
        return t1Var6;
    }

    public final int x() {
        return this.f6562m.size();
    }
}
