package n3;

import la.g;
import xa.j;

public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f11066a;

    public b4(g gVar) {
        this.f11066a = gVar;
    }

    public final void a(int i10, int i11) {
        h hVar = this.f11066a.f11164a;
        if (i11 > 0) {
            hVar.f11214a.f11236b.d(i10, i11, (Object) null);
        } else {
            hVar.getClass();
        }
    }

    public final void b(d1 d1Var, z0 z0Var) {
        a1 a1Var;
        j.f("loadState", z0Var);
        g gVar = this.f11066a;
        g1 g1Var = gVar.f11168e;
        g1Var.getClass();
        c1 c1Var = g1Var.f11185f;
        if (c1Var == null) {
            a1Var = null;
        } else {
            int ordinal = d1Var.ordinal();
            if (ordinal == 0) {
                a1Var = c1Var.f11079a;
            } else if (ordinal == 1) {
                a1Var = c1Var.f11080b;
            } else if (ordinal == 2) {
                a1Var = c1Var.f11081c;
            } else {
                throw new g();
            }
        }
        if (!j.a(a1Var, z0Var)) {
            g1 g1Var2 = gVar.f11168e;
            g1Var2.getClass();
            g1Var2.f11180a = true;
            c1 c1Var2 = g1Var2.f11185f;
            c1 b10 = c1Var2.b(d1Var, z0Var);
            g1Var2.f11185f = b10;
            j.a(b10, c1Var2);
            g1Var2.b();
        }
    }
}
