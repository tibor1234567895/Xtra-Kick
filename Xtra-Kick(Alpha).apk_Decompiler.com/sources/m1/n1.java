package m1;

import android.util.Pair;
import g1.r1;
import g1.t1;
import g1.u1;
import j1.l0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import v1.e1;

public final class n1 extends u1 {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f10403v = 0;

    /* renamed from: m  reason: collision with root package name */
    public final int f10404m;

    /* renamed from: n  reason: collision with root package name */
    public final e1 f10405n;

    /* renamed from: o  reason: collision with root package name */
    public final int f10406o;

    /* renamed from: p  reason: collision with root package name */
    public final int f10407p;

    /* renamed from: q  reason: collision with root package name */
    public final int[] f10408q;

    /* renamed from: r  reason: collision with root package name */
    public final int[] f10409r;

    /* renamed from: s  reason: collision with root package name */
    public final u1[] f10410s;

    /* renamed from: t  reason: collision with root package name */
    public final Object[] f10411t;

    /* renamed from: u  reason: collision with root package name */
    public final HashMap f10412u = new HashMap();

    public n1(List list, e1 e1Var) {
        this.f10405n = e1Var;
        this.f10404m = e1Var.f15616b.length;
        int size = list.size();
        this.f10408q = new int[size];
        this.f10409r = new int[size];
        this.f10410s = new u1[size];
        this.f10411t = new Object[size];
        Iterator it = list.iterator();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            b1 b1Var = (b1) it.next();
            this.f10410s[i12] = b1Var.b();
            this.f10409r[i12] = i10;
            this.f10408q[i12] = i11;
            i10 += this.f10410s[i12].x();
            i11 += this.f10410s[i12].q();
            this.f10411t[i12] = b1Var.a();
            this.f10412u.put(this.f10411t[i12], Integer.valueOf(i12));
            i12++;
        }
        this.f10406o = i10;
        this.f10407p = i11;
    }

    public final int A(int i10, boolean z10) {
        if (z10) {
            e1 e1Var = this.f10405n;
            int i11 = e1Var.f15617c[i10] - 1;
            if (i11 >= 0) {
                return e1Var.f15616b[i11];
            }
            return -1;
        } else if (i10 > 0) {
            return -1 + i10;
        } else {
            return -1;
        }
    }

    public final int j(boolean z10) {
        if (this.f10404m == 0) {
            return -1;
        }
        int i10 = 0;
        if (z10) {
            int[] iArr = this.f10405n.f15616b;
            if (iArr.length > 0) {
                i10 = iArr[0];
            } else {
                i10 = -1;
            }
        }
        do {
            u1[] u1VarArr = this.f10410s;
            if (!u1VarArr[i10].y()) {
                return this.f10409r[i10] + u1VarArr[i10].j(z10);
            }
            i10 = z(i10, z10);
        } while (i10 != -1);
        return -1;
    }

    public final int k(Object obj) {
        int i10;
        int k10;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f10412u.get(obj2);
        if (num == null) {
            i10 = -1;
        } else {
            i10 = num.intValue();
        }
        if (i10 == -1 || (k10 = this.f10410s[i10].k(obj3)) == -1) {
            return -1;
        }
        return this.f10408q[i10] + k10;
    }

    public final int l(boolean z10) {
        int i10;
        int i11 = this.f10404m;
        if (i11 == 0) {
            return -1;
        }
        if (z10) {
            int[] iArr = this.f10405n.f15616b;
            if (iArr.length > 0) {
                i10 = iArr[iArr.length - 1];
            } else {
                i10 = -1;
            }
        } else {
            i10 = i11 - 1;
        }
        do {
            u1[] u1VarArr = this.f10410s;
            if (!u1VarArr[i10].y()) {
                return this.f10409r[i10] + u1VarArr[i10].l(z10);
            }
            i10 = A(i10, z10);
        } while (i10 != -1);
        return -1;
    }

    public final int n(int i10, int i11, boolean z10) {
        int[] iArr = this.f10409r;
        int i12 = 0;
        int e10 = l0.e(iArr, i10 + 1, false, false);
        int i13 = iArr[e10];
        u1[] u1VarArr = this.f10410s;
        u1 u1Var = u1VarArr[e10];
        int i14 = i10 - i13;
        if (i11 != 2) {
            i12 = i11;
        }
        int n10 = u1Var.n(i14, i12, z10);
        if (n10 != -1) {
            return i13 + n10;
        }
        int z11 = z(e10, z10);
        while (z11 != -1 && u1VarArr[z11].y()) {
            z11 = z(z11, z10);
        }
        if (z11 != -1) {
            return u1VarArr[z11].j(z10) + iArr[z11];
        } else if (i11 == 2) {
            return j(z10);
        } else {
            return -1;
        }
    }

    public final r1 o(int i10, r1 r1Var, boolean z10) {
        int[] iArr = this.f10408q;
        int e10 = l0.e(iArr, i10 + 1, false, false);
        int i11 = this.f10409r[e10];
        this.f10410s[e10].o(i10 - iArr[e10], r1Var, z10);
        r1Var.f6544j += i11;
        if (z10) {
            Object obj = this.f10411t[e10];
            Object obj2 = r1Var.f6543i;
            obj2.getClass();
            r1Var.f6543i = Pair.create(obj, obj2);
        }
        return r1Var;
    }

    public final r1 p(Object obj, r1 r1Var) {
        int i10;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f10412u.get(obj2);
        if (num == null) {
            i10 = -1;
        } else {
            i10 = num.intValue();
        }
        int i11 = this.f10409r[i10];
        this.f10410s[i10].p(obj3, r1Var);
        r1Var.f6544j += i11;
        r1Var.f6543i = obj;
        return r1Var;
    }

    public final int q() {
        return this.f10407p;
    }

    public final int t(int i10, int i11, boolean z10) {
        int[] iArr = this.f10409r;
        int i12 = 0;
        int e10 = l0.e(iArr, i10 + 1, false, false);
        int i13 = iArr[e10];
        u1[] u1VarArr = this.f10410s;
        u1 u1Var = u1VarArr[e10];
        int i14 = i10 - i13;
        if (i11 != 2) {
            i12 = i11;
        }
        int t10 = u1Var.t(i14, i12, z10);
        if (t10 != -1) {
            return i13 + t10;
        }
        int A = A(e10, z10);
        while (A != -1 && u1VarArr[A].y()) {
            A = A(A, z10);
        }
        if (A != -1) {
            return u1VarArr[A].l(z10) + iArr[A];
        } else if (i11 == 2) {
            return l(z10);
        } else {
            return -1;
        }
    }

    public final Object u(int i10) {
        int[] iArr = this.f10408q;
        int e10 = l0.e(iArr, i10 + 1, false, false);
        return Pair.create(this.f10411t[e10], this.f10410s[e10].u(i10 - iArr[e10]));
    }

    public final t1 w(int i10, t1 t1Var, long j10) {
        int[] iArr = this.f10409r;
        int e10 = l0.e(iArr, i10 + 1, false, false);
        int i11 = iArr[e10];
        int i12 = this.f10408q[e10];
        this.f10410s[e10].w(i10 - i11, t1Var, j10);
        Object obj = this.f10411t[e10];
        if (!t1.f6573y.equals(t1Var.f6575h)) {
            obj = Pair.create(obj, t1Var.f6575h);
        }
        t1Var.f6575h = obj;
        t1Var.f6589v += i12;
        t1Var.f6590w += i12;
        return t1Var;
    }

    public final int x() {
        return this.f10406o;
    }

    public final int z(int i10, boolean z10) {
        if (z10) {
            e1 e1Var = this.f10405n;
            int i11 = e1Var.f15617c[i10] + 1;
            int[] iArr = e1Var.f15616b;
            if (i11 < iArr.length) {
                return iArr[i11];
            }
            return -1;
        } else if (i10 < this.f10404m - 1) {
            return i10 + 1;
        } else {
            return -1;
        }
    }
}
