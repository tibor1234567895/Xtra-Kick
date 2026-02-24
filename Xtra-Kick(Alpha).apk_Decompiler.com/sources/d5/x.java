package d5;

import s5.g;
import s5.h;

public final class x implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4505h;

    /* renamed from: i  reason: collision with root package name */
    public final g f4506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b0 f4507j;

    public /* synthetic */ x(b0 b0Var, g gVar, int i10) {
        this.f4505h = i10;
        this.f4507j = b0Var;
        this.f4506i = gVar;
    }

    private void a() {
        h hVar = (h) this.f4506i;
        hVar.f14329a.a();
        synchronized (hVar.f14330b) {
            synchronized (this.f4507j) {
                a0 a0Var = this.f4507j.f4340h;
                g gVar = this.f4506i;
                a0Var.getClass();
                if (a0Var.f4336h.contains(new z(gVar, w5.g.f16114b))) {
                    this.f4507j.C.a();
                    b0 b0Var = this.f4507j;
                    g gVar2 = this.f4506i;
                    b0Var.getClass();
                    try {
                        ((h) gVar2).l(b0Var.C, b0Var.f4357y, b0Var.F);
                        this.f4507j.j(this.f4506i);
                    } catch (Throwable th) {
                        throw new d(th);
                    }
                }
                this.f4507j.d();
            }
        }
    }

    public final void run() {
        switch (this.f4505h) {
            case 0:
                h hVar = (h) this.f4506i;
                hVar.f14329a.a();
                synchronized (hVar.f14330b) {
                    synchronized (this.f4507j) {
                        a0 a0Var = this.f4507j.f4340h;
                        g gVar = this.f4506i;
                        a0Var.getClass();
                        if (a0Var.f4336h.contains(new z(gVar, w5.g.f16114b))) {
                            b0 b0Var = this.f4507j;
                            g gVar2 = this.f4506i;
                            b0Var.getClass();
                            try {
                                ((h) gVar2).k(b0Var.A, 5);
                            } catch (Throwable th) {
                                throw new d(th);
                            }
                        }
                        this.f4507j.d();
                    }
                }
                return;
            default:
                a();
                return;
        }
    }
}
