package n3;

import androidx.fragment.app.k;
import cb.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import la.g;
import ma.l;
import ma.r;
import ma.w;
import q0.f;
import s.i;
import xa.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f11070a;

    /* renamed from: b  reason: collision with root package name */
    public final w0[] f11071b;

    /* renamed from: c  reason: collision with root package name */
    public final l f11072c;

    public c() {
        int length = d1.values().length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = 1;
        }
        this.f11070a = iArr;
        int length2 = d1.values().length;
        w0[] w0VarArr = new w0[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            w0VarArr[i11] = null;
        }
        this.f11071b = w0VarArr;
        this.f11072c = new l();
    }

    public final void a(d1 d1Var) {
        int d10;
        j.f("loadType", d1Var);
        k kVar = new k(3, d1Var);
        l lVar = this.f11072c;
        j.f("<this>", lVar);
        if (!(lVar instanceof RandomAccess)) {
            w.l(lVar, kVar, true);
            return;
        }
        int i10 = 0;
        cb.c a10 = new e(0, r.d(lVar)).iterator();
        while (a10.f3068j) {
            int a11 = a10.a();
            Object obj = lVar.get(a11);
            if (!((Boolean) kVar.invoke(obj)).booleanValue()) {
                if (i10 != a11) {
                    lVar.set(i10, obj);
                }
                i10++;
            }
        }
        if (i10 < lVar.a() && i10 <= (d10 = r.d(lVar))) {
            while (true) {
                lVar.b(d10);
                if (d10 != i10) {
                    d10--;
                } else {
                    return;
                }
            }
        }
    }

    public final a1 b(d1 d1Var) {
        boolean z10;
        int i10 = this.f11070a[d1Var.ordinal()];
        l lVar = this.f11072c;
        boolean z11 = false;
        if (!(lVar instanceof Collection) || !lVar.isEmpty()) {
            Iterator it = lVar.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((a) it.next()).f11034a == d1Var) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z11 && i10 != 3) {
            return x0.f11553b;
        }
        w0 w0Var = this.f11071b[d1Var.ordinal()];
        if (w0Var != null) {
            return w0Var;
        }
        int a10 = i.a(i10);
        if (a10 != 0) {
            if (a10 != 1) {
                if (a10 != 2) {
                    throw new g();
                }
            } else if (b.f11055a[d1Var.ordinal()] != 1) {
                z0.f11599b.getClass();
                return z0.f11600c;
            }
        }
        z0.f11599b.getClass();
        return z0.f11601d;
    }

    public final void c(d1 d1Var, int i10) {
        f.j("state", i10);
        this.f11070a[d1Var.ordinal()] = i10;
    }
}
