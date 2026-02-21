package h9;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

public final class m0 extends r implements RunnableFuture {

    /* renamed from: o  reason: collision with root package name */
    public volatile l0 f7757o;

    public m0(Callable callable) {
        this.f7757o = new l0(this, callable);
    }

    public final void d() {
        boolean z10;
        l0 l0Var;
        Object obj = this.f7762h;
        if (!(obj instanceof b) || !((b) obj).f7723a) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && (l0Var = this.f7757o) != null) {
            c0 c0Var = d0.f7733i;
            c0 c0Var2 = d0.f7732h;
            Runnable runnable = (Runnable) l0Var.get();
            if (runnable instanceof Thread) {
                b0 b0Var = new b0(l0Var);
                b0.a(b0Var, Thread.currentThread());
                if (l0Var.compareAndSet(runnable, b0Var)) {
                    try {
                        ((Thread) runnable).interrupt();
                    } finally {
                        if (((Runnable) l0Var.getAndSet(c0Var2)) == c0Var) {
                            LockSupport.unpark((Thread) runnable);
                        }
                    }
                }
            }
        }
        this.f7757o = null;
    }

    public final String j() {
        l0 l0Var = this.f7757o;
        if (l0Var == null) {
            return super.j();
        }
        String valueOf = String.valueOf(l0Var);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
        sb2.append("task=[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    public final void run() {
        l0 l0Var = this.f7757o;
        if (l0Var != null) {
            l0Var.run();
        }
        this.f7757o = null;
    }
}
