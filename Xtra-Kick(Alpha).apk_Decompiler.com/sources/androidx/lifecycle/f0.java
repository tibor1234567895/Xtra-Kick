package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.util.List;
import xa.j;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public s f1682a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f1683b;

    public f0(c0 c0Var, s sVar) {
        b0 b0Var;
        j.c(c0Var);
        h0 h0Var = h0.f1697a;
        boolean z10 = c0Var instanceof b0;
        boolean z11 = c0Var instanceof h;
        if (z10 && z11) {
            b0Var = new DefaultLifecycleObserverAdapter((h) c0Var, (b0) c0Var);
        } else if (z11) {
            b0Var = new DefaultLifecycleObserverAdapter((h) c0Var, (b0) null);
        } else if (z10) {
            b0Var = (b0) c0Var;
        } else {
            Class<?> cls = c0Var.getClass();
            h0.f1697a.getClass();
            if (h0.b(cls) == 2) {
                Object obj = h0.f1699c.get(cls);
                j.c(obj);
                List list = (List) obj;
                if (list.size() != 1) {
                    int size = list.size();
                    l[] lVarArr = new l[size];
                    if (size <= 0) {
                        b0Var = new CompositeGeneratedAdaptersObserver(lVarArr);
                    } else {
                        h0.a((Constructor) list.get(0), c0Var);
                        throw null;
                    }
                } else {
                    h0.a((Constructor) list.get(0), c0Var);
                    throw null;
                }
            } else {
                b0Var = new ReflectiveGenericLifecycleObserver(c0Var);
            }
        }
        this.f1683b = b0Var;
        this.f1682a = sVar;
    }

    public final void a(d0 d0Var, r rVar) {
        s a10 = rVar.a();
        e0 e0Var = g0.f1685j;
        s sVar = this.f1682a;
        e0Var.getClass();
        j.f("state1", sVar);
        if (a10.compareTo(sVar) < 0) {
            sVar = a10;
        }
        this.f1682a = sVar;
        this.f1683b.d(d0Var, rVar);
        this.f1682a = a10;
    }
}
