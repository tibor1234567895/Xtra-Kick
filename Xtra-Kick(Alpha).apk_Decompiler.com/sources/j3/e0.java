package j3;

import wa.l;
import xa.j;
import xa.k;

public final class e0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final e0 f8522h = new e0();

    public e0() {
        super(1);
    }

    public final Object invoke(Object obj) {
        boolean z10;
        c1 c1Var = (c1) obj;
        j.f("destination", c1Var);
        h1 h1Var = c1Var.f8507i;
        if (h1Var == null || h1Var.f8558s != c1Var.f8513o) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return h1Var;
        }
        return null;
    }
}
