package hb;

import java.util.concurrent.locks.LockSupport;
import pa.k;
import xa.j;

public final class f extends a {

    /* renamed from: k  reason: collision with root package name */
    public final Thread f7791k;

    /* renamed from: l  reason: collision with root package name */
    public final s0 f7792l;

    public f(k kVar, Thread thread, s0 s0Var) {
        super(kVar, true);
        this.f7791k = thread;
        this.f7792l = s0Var;
    }

    public final void p(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f7791k;
        if (!j.a(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
