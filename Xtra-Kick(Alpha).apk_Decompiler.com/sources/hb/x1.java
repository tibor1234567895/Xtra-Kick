package hb;

import mb.u;
import nb.e;

public abstract class x1 extends d0 {
    public abstract x1 Q0();

    public String toString() {
        String str;
        x1 x1Var;
        e eVar = p0.f7833a;
        x1 x1Var2 = u.f10886a;
        if (this == x1Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                x1Var = x1Var2.Q0();
            } catch (UnsupportedOperationException unused) {
                x1Var = null;
            }
            if (this == x1Var) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + h0.r0(this);
    }
}
