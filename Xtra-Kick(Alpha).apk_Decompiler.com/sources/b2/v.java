package b2;

import android.view.Surface;
import i1.c;
import j1.l0;
import m1.k0;
import m1.n0;
import n1.b;
import n1.o;
import n1.x;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ x f2505h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f2506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f2507j;

    public /* synthetic */ v(x xVar, Surface surface, long j10) {
        this.f2505h = xVar;
        this.f2506i = surface;
        this.f2507j = j10;
    }

    public final void run() {
        x xVar = this.f2505h;
        xVar.getClass();
        int i10 = l0.f8453a;
        n0 n0Var = ((k0) xVar.f2512b).f10314h;
        x xVar2 = (x) n0Var.f10394r;
        b c02 = xVar2.c0();
        Object obj = this.f2506i;
        xVar2.d0(c02, 26, new o(c02, obj, this.f2507j));
        if (n0Var.Q == obj) {
            n0Var.f10388l.m(26, new c(4));
        }
    }
}
