package n3;

import la.v;
import xa.j;

public final class u1 implements v5 {

    /* renamed from: a  reason: collision with root package name */
    public final g3 f11499a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f11500b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i2 f11501c;

    public u1(i2 i2Var, g3 g3Var, b0 b0Var) {
        j.f("this$0", i2Var);
        j.f("pageFetcherSnapshot", g3Var);
        j.f("retryEventBus", b0Var);
        this.f11501c = i2Var;
        this.f11499a = g3Var;
        this.f11500b = b0Var;
    }

    public final void a() {
        this.f11500b.a(v.f9814a);
    }

    public final void b(a6 a6Var) {
        y5 y5Var;
        g3 g3Var = this.f11499a;
        g3Var.getClass();
        v0 v0Var = g3Var.f11202i;
        v0Var.getClass();
        if (a6Var instanceof y5) {
            y5Var = (y5) a6Var;
        } else {
            y5Var = null;
        }
        v0Var.f11516a.c(y5Var, new u0(0, a6Var));
    }

    public final void c() {
        this.f11501c.f11253d.a(Boolean.TRUE);
    }
}
