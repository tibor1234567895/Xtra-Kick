package mb;

import h3.u1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class b extends v {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10839a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f10837a;

    public final Object a(Object obj) {
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10839a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        u1 u1Var = a.f10837a;
        if (obj2 == u1Var) {
            u1 c10 = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == u1Var) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, u1Var, c10)) {
                        if (atomicReferenceFieldUpdater.get(this) != u1Var) {
                            z10 = false;
                            break;
                        }
                    } else {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    obj2 = c10;
                } else {
                    obj2 = atomicReferenceFieldUpdater.get(this);
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract u1 c(Object obj);
}
