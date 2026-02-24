package b1;

import androidx.lifecycle.b2;
import androidx.lifecycle.w1;
import xa.j;

public final class d implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final g[] f2411a;

    public d(g... gVarArr) {
        j.f("initializers", gVarArr);
        this.f2411a = gVarArr;
    }

    public final w1 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public final w1 b(Class cls, f fVar) {
        w1 w1Var = null;
        for (g gVar : this.f2411a) {
            if (j.a(gVar.f2413a, cls)) {
                Object invoke = gVar.f2414b.invoke(fVar);
                if (invoke instanceof w1) {
                    w1Var = (w1) invoke;
                } else {
                    w1Var = null;
                }
            }
        }
        if (w1Var != null) {
            return w1Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
