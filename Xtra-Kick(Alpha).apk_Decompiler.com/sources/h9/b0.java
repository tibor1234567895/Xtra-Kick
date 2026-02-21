package h9;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public final class b0 extends AbstractOwnableSynchronizer implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final d0 f7725h;

    public b0(d0 d0Var) {
        this.f7725h = d0Var;
    }

    public static void a(b0 b0Var, Thread thread) {
        b0Var.setExclusiveOwnerThread(thread);
    }

    public final void run() {
    }

    public final String toString() {
        return this.f7725h.toString();
    }
}
