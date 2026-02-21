package hb;

import mb.b0;
import mb.u;
import nb.e;

public abstract class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final m0 f7813a;

    static {
        String str;
        boolean z10;
        m0 m0Var;
        int i10 = b0.f10840a;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            z10 = Boolean.parseBoolean(str);
        } else {
            z10 = false;
        }
        if (z10) {
            e eVar = p0.f7833a;
            x1 x1Var = u.f10886a;
            x1Var.Q0();
            if (x1Var instanceof m0) {
                m0Var = (m0) x1Var;
                f7813a = m0Var;
            }
        }
        m0Var = i0.f7808q;
        f7813a = m0Var;
    }
}
