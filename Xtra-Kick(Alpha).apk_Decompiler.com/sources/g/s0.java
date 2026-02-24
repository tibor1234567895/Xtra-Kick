package g;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import la.v;
import r3.b0;
import xa.j;

public final class s0 implements Executor {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6203h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f6204i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f6205j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f6206k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayDeque f6207l;

    public s0(Executor executor, int i10) {
        this.f6203h = i10;
        if (i10 != 1) {
            this.f6206k = new Object();
            this.f6207l = new ArrayDeque();
            this.f6204i = executor;
            return;
        }
        j.f("executor", executor);
        this.f6204i = executor;
        this.f6207l = new ArrayDeque();
        this.f6206k = new Object();
    }

    private void a(Runnable runnable) {
        j.f("command", runnable);
        synchronized (this.f6206k) {
            this.f6207l.offer(new b0(runnable, 1, this));
            if (this.f6205j == null) {
                b();
            }
            v vVar = v.f9814a;
        }
    }

    private final void c() {
        synchronized (this.f6206k) {
            Object poll = this.f6207l.poll();
            Runnable runnable = (Runnable) poll;
            this.f6205j = runnable;
            if (poll != null) {
                this.f6204i.execute(runnable);
            }
            v vVar = v.f9814a;
        }
    }

    public final void b() {
        switch (this.f6203h) {
            case 0:
                synchronized (this.f6206k) {
                    Runnable runnable = (Runnable) this.f6207l.poll();
                    this.f6205j = runnable;
                    if (runnable != null) {
                        this.f6204i.execute(runnable);
                    }
                }
                return;
            default:
                c();
                return;
        }
    }

    public final void execute(Runnable runnable) {
        switch (this.f6203h) {
            case 0:
                synchronized (this.f6206k) {
                    this.f6207l.add(new r0(this, 0, runnable));
                    if (this.f6205j == null) {
                        b();
                    }
                }
                return;
            default:
                a(runnable);
                return;
        }
    }
}
