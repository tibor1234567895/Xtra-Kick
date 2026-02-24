package androidx.recyclerview.widget;

import q.i;
import q.k;

public final class d3 {

    /* renamed from: a  reason: collision with root package name */
    public final k f1966a = new k();

    /* renamed from: b  reason: collision with root package name */
    public final i f1967b = new i();

    public final m1 a(k2 k2Var, int i10) {
        b3 b3Var;
        m1 m1Var;
        k kVar = this.f1966a;
        int e10 = kVar.e(k2Var);
        if (e10 >= 0 && (b3Var = (b3) kVar.l(e10)) != null) {
            int i11 = b3Var.f1946a;
            if ((i11 & i10) != 0) {
                int i12 = i11 & (~i10);
                b3Var.f1946a = i12;
                if (i10 == 4) {
                    m1Var = b3Var.f1947b;
                } else if (i10 == 8) {
                    m1Var = b3Var.f1948c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    kVar.j(e10);
                    b3Var.f1946a = 0;
                    b3Var.f1947b = null;
                    b3Var.f1948c = null;
                    b3.f1945d.e(b3Var);
                }
                return m1Var;
            }
        }
        return null;
    }

    public final void b(k2 k2Var) {
        b3 b3Var = (b3) this.f1966a.getOrDefault(k2Var, (Object) null);
        if (b3Var != null) {
            b3Var.f1946a &= -2;
        }
    }

    public final void c(k2 k2Var) {
        i iVar = this.f1967b;
        int i10 = iVar.i() - 1;
        while (true) {
            if (i10 < 0) {
                break;
            } else if (k2Var == iVar.j(i10)) {
                Object[] objArr = iVar.f13068j;
                Object obj = objArr[i10];
                Object obj2 = i.f13065l;
                if (obj != obj2) {
                    objArr[i10] = obj2;
                    iVar.f13066h = true;
                }
            } else {
                i10--;
            }
        }
        b3 b3Var = (b3) this.f1966a.remove(k2Var);
        if (b3Var != null) {
            b3Var.f1946a = 0;
            b3Var.f1947b = null;
            b3Var.f1948c = null;
            b3.f1945d.e(b3Var);
        }
    }
}
