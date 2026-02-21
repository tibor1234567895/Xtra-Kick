package ea;

import android.content.Context;
import d9.p0;
import d9.u0;
import d9.x1;
import ja.c;
import y5.h;

public final class b {
    private b() {
    }

    public static boolean a(Context context) {
        boolean z10;
        ((h) ((a) ca.b.a(context, a.class))).getClass();
        int i10 = u0.f4677j;
        x1 x1Var = x1.f4702q;
        if (x1Var.f4707o <= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "Cannot bind the flag @DisableFragmentGetContextFix more than once.", new Object[0]);
        if (x1Var.isEmpty()) {
            return true;
        }
        return ((Boolean) ((p0) x1Var.iterator()).next()).booleanValue();
    }
}
