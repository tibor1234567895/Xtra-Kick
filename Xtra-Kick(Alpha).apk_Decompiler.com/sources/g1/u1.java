package g1;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.a;
import j1.b;
import j1.l0;
import java.util.ArrayList;

public abstract class u1 implements m {

    /* renamed from: h  reason: collision with root package name */
    public static final q1 f6622h = new q1();

    /* renamed from: i  reason: collision with root package name */
    public static final String f6623i = l0.C(0);

    /* renamed from: j  reason: collision with root package name */
    public static final String f6624j = l0.C(1);

    /* renamed from: k  reason: collision with root package name */
    public static final String f6625k = l0.C(2);

    /* renamed from: l  reason: collision with root package name */
    public static final a f6626l = new a(20);

    public static r1 i(a aVar, IBinder iBinder) {
        if (iBinder == null) {
            p0 p0Var = r0.f4657i;
            return r1.f4658l;
        }
        o0 o0Var = new o0();
        r1 a10 = k.a(iBinder);
        for (int i10 = 0; i10 < a10.f4660k; i10++) {
            o0Var.c(aVar.e((Bundle) a10.get(i10)));
        }
        return o0Var.e();
    }

    public boolean equals(Object obj) {
        int l10;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        if (u1Var.x() != x() || u1Var.q() != q()) {
            return false;
        }
        t1 t1Var = new t1();
        r1 r1Var = new r1();
        t1 t1Var2 = new t1();
        r1 r1Var2 = new r1();
        for (int i10 = 0; i10 < x(); i10++) {
            if (!v(i10, t1Var).equals(u1Var.v(i10, t1Var2))) {
                return false;
            }
        }
        for (int i11 = 0; i11 < q(); i11++) {
            if (!o(i11, r1Var, true).equals(u1Var.o(i11, r1Var2, true))) {
                return false;
            }
        }
        int j10 = j(true);
        if (j10 != u1Var.j(true) || (l10 = l(true)) != u1Var.l(true)) {
            return false;
        }
        while (j10 != l10) {
            int n10 = n(j10, 0, true);
            if (n10 != u1Var.n(j10, 0, true)) {
                return false;
            }
            j10 = n10;
        }
        return true;
    }

    public final Bundle h() {
        ArrayList arrayList = new ArrayList();
        int x10 = x();
        t1 t1Var = new t1();
        for (int i10 = 0; i10 < x10; i10++) {
            arrayList.add(w(i10, t1Var, 0).h());
        }
        ArrayList arrayList2 = new ArrayList();
        int q10 = q();
        r1 r1Var = new r1();
        for (int i11 = 0; i11 < q10; i11++) {
            arrayList2.add(o(i11, r1Var, false).h());
        }
        int[] iArr = new int[x10];
        if (x10 > 0) {
            iArr[0] = j(true);
        }
        for (int i12 = 1; i12 < x10; i12++) {
            iArr[i12] = n(iArr[i12 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        b.b(bundle, f6623i, new k(arrayList));
        b.b(bundle, f6624j, new k(arrayList2));
        bundle.putIntArray(f6625k, iArr);
        return bundle;
    }

    public int hashCode() {
        int i10;
        t1 t1Var = new t1();
        r1 r1Var = new r1();
        int x10 = x() + 217;
        int i11 = 0;
        while (true) {
            i10 = x10 * 31;
            if (i11 >= x()) {
                break;
            }
            x10 = i10 + v(i11, t1Var).hashCode();
            i11++;
        }
        int q10 = q() + i10;
        for (int i12 = 0; i12 < q(); i12++) {
            q10 = (q10 * 31) + o(i12, r1Var, true).hashCode();
        }
        int j10 = j(true);
        while (j10 != -1) {
            q10 = (q10 * 31) + j10;
            j10 = n(j10, 0, true);
        }
        return q10;
    }

    public int j(boolean z10) {
        return y() ? -1 : 0;
    }

    public abstract int k(Object obj);

    public int l(boolean z10) {
        if (y()) {
            return -1;
        }
        return x() - 1;
    }

    public final int m(int i10, r1 r1Var, t1 t1Var, int i11, boolean z10) {
        int i12 = o(i10, r1Var, false).f6544j;
        if (v(i12, t1Var).f6590w != i10) {
            return i10 + 1;
        }
        int n10 = n(i12, i11, z10);
        if (n10 == -1) {
            return -1;
        }
        return v(n10, t1Var).f6589v;
    }

    public int n(int i10, int i11, boolean z10) {
        if (i11 != 0) {
            if (i11 == 1) {
                return i10;
            }
            if (i11 == 2) {
                return i10 == l(z10) ? j(z10) : i10 + 1;
            }
            throw new IllegalStateException();
        } else if (i10 == l(z10)) {
            return -1;
        } else {
            return i10 + 1;
        }
    }

    public abstract r1 o(int i10, r1 r1Var, boolean z10);

    public r1 p(Object obj, r1 r1Var) {
        return o(k(obj), r1Var, true);
    }

    public abstract int q();

    public final Pair r(t1 t1Var, r1 r1Var, int i10, long j10) {
        Pair s10 = s(t1Var, r1Var, i10, j10, 0);
        s10.getClass();
        return s10;
    }

    public final Pair s(t1 t1Var, r1 r1Var, int i10, long j10, long j11) {
        a.c(i10, x());
        w(i10, t1Var, j11);
        if (j10 == -9223372036854775807L) {
            j10 = t1Var.f6587t;
            if (j10 == -9223372036854775807L) {
                return null;
            }
        }
        int i11 = t1Var.f6589v;
        o(i11, r1Var, false);
        while (i11 < t1Var.f6590w && r1Var.f6546l != j10) {
            int i12 = i11 + 1;
            if (o(i12, r1Var, false).f6546l > j10) {
                break;
            }
            i11 = i12;
        }
        o(i11, r1Var, true);
        long j12 = j10 - r1Var.f6546l;
        long j13 = r1Var.f6545k;
        if (j13 != -9223372036854775807L) {
            j12 = Math.min(j12, j13 - 1);
        }
        long max = Math.max(0, j12);
        Object obj = r1Var.f6543i;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public int t(int i10, int i11, boolean z10) {
        if (i11 != 0) {
            if (i11 == 1) {
                return i10;
            }
            if (i11 == 2) {
                return i10 == j(z10) ? l(z10) : i10 - 1;
            }
            throw new IllegalStateException();
        } else if (i10 == j(z10)) {
            return -1;
        } else {
            return i10 - 1;
        }
    }

    public abstract Object u(int i10);

    public final t1 v(int i10, t1 t1Var) {
        return w(i10, t1Var, 0);
    }

    public abstract t1 w(int i10, t1 t1Var, long j10);

    public abstract int x();

    public final boolean y() {
        return x() == 0;
    }
}
