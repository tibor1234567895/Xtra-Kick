package j3;

import android.view.View;
import eb.e;
import eb.f;
import eb.h;
import eb.m;
import eb.p;
import eb.r;
import xa.j;

public final class k2 {

    /* renamed from: a  reason: collision with root package name */
    public static final k2 f8602a = new k2();

    private k2() {
    }

    public static final k0 a(View view) {
        Object obj;
        f8602a.getClass();
        h b10 = m.b(view, i2.f8567h);
        j.f("<this>", b10);
        j2 j2Var = j2.f8573h;
        j.f("transform", j2Var);
        r rVar = new r(b10, j2Var, 1);
        p pVar = p.f5350h;
        j.f("predicate", pVar);
        e eVar = new e(new f(rVar, pVar));
        if (!eVar.hasNext()) {
            obj = null;
        } else {
            obj = eVar.next();
        }
        k0 k0Var = (k0) obj;
        if (k0Var != null) {
            return k0Var;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
