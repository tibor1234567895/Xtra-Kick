package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import la.v;
import wa.l;

public final class g2 implements l {

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7797j = AtomicIntegerFieldUpdater.newUpdater(g2.class, "_state");
    private volatile int _state;

    /* renamed from: h  reason: collision with root package name */
    public final Thread f7798h = Thread.currentThread();

    /* renamed from: i  reason: collision with root package name */
    public q0 f7799i;

    public g2(l1 l1Var) {
    }

    public static void c(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public final void a() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7797j;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        c(i10);
                        throw null;
                    }
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i10, 1)) {
                q0 q0Var = this.f7799i;
                if (q0Var != null) {
                    q0Var.a();
                    return;
                }
                return;
            }
        }
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7797j;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == 0) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, 2)) {
                    this.f7798h.interrupt();
                    atomicIntegerFieldUpdater.set(this, 3);
                    break;
                }
            } else if (i10 != 1 && i10 != 2 && i10 != 3) {
                c(i10);
                throw null;
            }
        }
        return v.f9814a;
    }
}
