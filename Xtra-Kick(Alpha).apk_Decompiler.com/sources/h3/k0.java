package h3;

import g1.k;
import h9.a0;
import h9.q;
import j1.a;
import j1.c;
import j1.h;
import j1.p;
import java.util.List;

public final /* synthetic */ class k0 implements u0, h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ y0 f7149h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List f7150i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7151j;

    public /* synthetic */ k0(y0 y0Var, int i10, List list) {
        this.f7149h = y0Var;
        this.f7151j = i10;
        this.f7150i = list;
    }

    public final void b(Object obj) {
        y0 y0Var = this.f7149h;
        b0 b0Var = y0Var.f7453a;
        a0 w10 = ((z) obj).w(this.f7150i);
        a.d(w10, "MediaController.Listener#onSetCustomLayout() must not return null");
        w10.a(new p((Object) y0Var, (Object) w10, this.f7151j, 3), q.f7765h);
    }

    public final void d(r rVar, int i10) {
        y0 y0Var = this.f7149h;
        y0Var.getClass();
        rVar.u(y0Var.f7455c, i10, this.f7151j, new k(c.c(this.f7150i)));
    }
}
