package o1;

import android.support.v4.media.n;
import j1.l0;
import m1.g;
import m1.k0;
import m1.n0;
import n1.b;
import n1.f;
import n1.x;
import v1.a0;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11866h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f11867i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f11868j;

    public /* synthetic */ d(n nVar, g gVar, int i10) {
        this.f11866h = i10;
        this.f11867i = nVar;
        this.f11868j = gVar;
    }

    public final void run() {
        switch (this.f11866h) {
            case 0:
                n nVar = this.f11867i;
                g gVar = this.f11868j;
                nVar.getClass();
                synchronized (gVar) {
                }
                int i10 = l0.f8453a;
                x xVar = (x) ((k0) nVar.f338j).f10314h.f10394r;
                b a02 = xVar.a0((a0) xVar.f11000k.f898e);
                xVar.d0(a02, 1013, new f(2, gVar, a02));
                return;
            default:
                int i11 = l0.f8453a;
                n0 n0Var = ((k0) this.f11867i.f338j).f10314h;
                n0Var.getClass();
                x xVar2 = (x) n0Var.f10394r;
                b c02 = xVar2.c0();
                xVar2.d0(c02, 1007, new f(1, this.f11868j, c02));
                return;
        }
    }
}
