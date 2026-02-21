package h9;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class d0 extends AtomicReference implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f7732h = new c0(0);

    /* renamed from: i  reason: collision with root package name */
    public static final c0 f7733i = new c0(0);

    public abstract void a(Throwable th);

    public abstract void b(Object obj);

    public abstract boolean c();

    public abstract Object d();

    public abstract String e();

    public final void f(Thread thread) {
        Runnable runnable = (Runnable) get();
        b0 b0Var = null;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            boolean z11 = runnable instanceof b0;
            c0 c0Var = f7733i;
            if (!z11 && runnable != c0Var) {
                break;
            }
            if (z11) {
                b0Var = (b0) runnable;
            }
            i10++;
            if (i10 <= 1000) {
                Thread.yield();
            } else if (runnable == c0Var || compareAndSet(runnable, c0Var)) {
                z10 = Thread.interrupted() || z10;
                LockSupport.park(b0Var);
            }
            runnable = (Runnable) get();
        }
        if (z10) {
            thread.interrupt();
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z10 = !c();
            c0 c0Var = f7732h;
            if (z10) {
                try {
                    obj = d();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, c0Var)) {
                        f(currentThread);
                    }
                    if (z10) {
                        a(th);
                        return;
                    }
                    return;
                }
            }
            if (!compareAndSet(currentThread, c0Var)) {
                f(currentThread);
            }
            if (z10) {
                b(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f7732h) {
            str = "running=[DONE]";
        } else if (runnable instanceof b0) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 21);
            sb2.append("running=[RUNNING ON ");
            sb2.append(name);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String e10 = e();
        StringBuilder sb3 = new StringBuilder(String.valueOf(e10).length() + String.valueOf(str).length() + 2);
        sb3.append(str);
        sb3.append(", ");
        sb3.append(e10);
        return sb3.toString();
    }
}
