package b2;

import j1.l0;
import m1.g;
import m1.k0;
import m1.n0;
import n1.b;
import n1.f;
import n1.x;
import v1.a0;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2508h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x f2509i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f2510j;

    public /* synthetic */ w(x xVar, g gVar, int i10) {
        this.f2508h = i10;
        this.f2509i = xVar;
        this.f2510j = gVar;
    }

    public final void run() {
        switch (this.f2508h) {
            case 0:
                x xVar = this.f2509i;
                xVar.getClass();
                int i10 = l0.f8453a;
                n0 n0Var = ((k0) xVar.f2512b).f10314h;
                n0Var.getClass();
                x xVar2 = (x) n0Var.f10394r;
                b c02 = xVar2.c0();
                xVar2.d0(c02, 1015, new f(0, this.f2510j, c02));
                return;
            default:
                x xVar3 = this.f2509i;
                g gVar = this.f2510j;
                xVar3.getClass();
                synchronized (gVar) {
                }
                y yVar = xVar3.f2512b;
                int i11 = l0.f8453a;
                x xVar4 = (x) ((k0) yVar).f10314h.f10394r;
                b a02 = xVar4.a0((a0) xVar4.f11000k.f898e);
                xVar4.d0(a02, 1020, new f(3, gVar, a02));
                return;
        }
    }
}
