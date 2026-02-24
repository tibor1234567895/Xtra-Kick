package b2;

import g1.a;
import j1.l0;
import m1.k0;
import n1.b;
import n1.x;
import v1.a0;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2501h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x f2502i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f2503j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2504k;

    public /* synthetic */ u(x xVar, int i10, long j10) {
        this.f2502i = xVar;
        this.f2504k = i10;
        this.f2503j = j10;
    }

    public final void run() {
        int i10 = this.f2501h;
        long j10 = this.f2503j;
        int i11 = this.f2504k;
        x xVar = this.f2502i;
        switch (i10) {
            case 0:
                xVar.getClass();
                int i12 = l0.f8453a;
                x xVar2 = (x) ((k0) xVar.f2512b).f10314h.f10394r;
                b a02 = xVar2.a0((a0) xVar2.f11000k.f898e);
                xVar2.d0(a02, 1018, new a(a02, i11, j10));
                return;
            default:
                xVar.getClass();
                int i13 = l0.f8453a;
                x xVar3 = (x) ((k0) xVar.f2512b).f10314h.f10394r;
                b a03 = xVar3.a0((a0) xVar3.f11000k.f898e);
                xVar3.d0(a03, 1021, new a(a03, j10, i11));
                return;
        }
    }

    public /* synthetic */ u(x xVar, long j10, int i10) {
        this.f2502i = xVar;
        this.f2503j = j10;
        this.f2504k = i10;
    }
}
