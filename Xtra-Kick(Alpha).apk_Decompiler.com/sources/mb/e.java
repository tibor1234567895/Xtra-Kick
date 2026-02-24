package mb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import xa.j;

public abstract class e {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10845h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10846i;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<e> cls = e.class;
        Class<Object> cls2 = Object.class;
        f10845h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f10846i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public e(e eVar) {
        this._prev = eVar;
    }

    public final void a() {
        f10846i.lazySet(this, (Object) null);
    }

    public final e b() {
        Object obj = f10845h.get(this);
        if (obj == d.f10843a) {
            return null;
        }
        return (e) obj;
    }

    public abstract boolean c();

    public final void d() {
        boolean z10;
        e eVar;
        boolean z11;
        boolean z12;
        e b10;
        if (b() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10846i;
                e eVar2 = (e) atomicReferenceFieldUpdater.get(this);
                while (eVar2 != null && eVar2.c()) {
                    eVar2 = (e) atomicReferenceFieldUpdater.get(eVar2);
                }
                e b11 = b();
                j.c(b11);
                while (b11.c() && (b10 = b11.b()) != null) {
                    b11 = b10;
                }
                do {
                    Object obj = atomicReferenceFieldUpdater.get(b11);
                    if (((e) obj) == null) {
                        eVar = null;
                    } else {
                        eVar = eVar2;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(b11, obj, eVar)) {
                            if (atomicReferenceFieldUpdater.get(b11) != obj) {
                                z11 = false;
                                continue;
                                break;
                            }
                        } else {
                            z11 = true;
                            continue;
                            break;
                        }
                    }
                } while (!z11);
                if (eVar2 != null) {
                    f10845h.set(eVar2, b11);
                }
                if (b11.c()) {
                    if (b11.b() == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        continue;
                    }
                }
                if (eVar2 == null || !eVar2.c()) {
                    return;
                }
            }
        }
    }
}
