package h3;

import g1.g1;
import j1.l0;

public final /* synthetic */ class m1 implements n1, m2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ g1 f7196h;

    public /* synthetic */ m1(g1 g1Var) {
        this.f7196h = g1Var;
    }

    public final void g(y0 y0Var) {
        if (y0Var.H0()) {
            g1 g1Var = y0Var.f7469q;
            g1 g1Var2 = this.f7196h;
            if (!l0.a(g1Var, g1Var2)) {
                y0Var.f7469q = g1Var2;
                g1 g1Var3 = y0Var.f7470r;
                g1 y10 = t3.y(y0Var.f7468p, g1Var2);
                y0Var.f7470r = y10;
                if (!l0.a(y10, g1Var3)) {
                    y0Var.f7461i.m(13, new l0(y0Var, 19));
                }
            }
        }
    }

    public final void i(d2 d2Var, int i10) {
        Object obj = n2.f7225w;
        d2Var.u(i10, this.f7196h);
    }
}
