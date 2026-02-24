package la;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import wa.a;

public final class n implements e, Serializable {

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9803j = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "i");

    /* renamed from: h  reason: collision with root package name */
    public volatile a f9804h;

    /* renamed from: i  reason: collision with root package name */
    public volatile Object f9805i = t.f9813a;

    static {
        new m(0);
    }

    public n(a aVar) {
        this.f9804h = aVar;
    }

    public final Object getValue() {
        boolean z10;
        Object obj = this.f9805i;
        t tVar = t.f9813a;
        if (obj != tVar) {
            return obj;
        }
        a aVar = this.f9804h;
        if (aVar != null) {
            Object b10 = aVar.b();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9803j;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, tVar, b10)) {
                    if (atomicReferenceFieldUpdater.get(this) != tVar) {
                        z10 = false;
                        break;
                    }
                } else {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                this.f9804h = null;
                return b10;
            }
        }
        return this.f9805i;
    }

    public final String toString() {
        boolean z10;
        if (this.f9805i != t.f9813a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
