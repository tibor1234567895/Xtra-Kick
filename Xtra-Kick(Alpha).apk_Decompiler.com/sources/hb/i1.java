package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import la.v;
import wa.l;

public final class i1 extends n1 {

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7810m = AtomicIntegerFieldUpdater.newUpdater(i1.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: l  reason: collision with root package name */
    public final l f7811l;

    public i1(l lVar) {
        this.f7811l = lVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        o((Throwable) obj);
        return v.f9814a;
    }

    public final void o(Throwable th) {
        if (f7810m.compareAndSet(this, 0, 1)) {
            this.f7811l.invoke(th);
        }
    }
}
