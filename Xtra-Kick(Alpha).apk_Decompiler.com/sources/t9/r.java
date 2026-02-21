package t9;

import p9.b;
import p9.l;

public final class r implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14901h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f14902i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b f14903j;

    public /* synthetic */ r(l lVar, b bVar, int i10) {
        this.f14901h = i10;
        this.f14902i = lVar;
        this.f14903j = bVar;
    }

    public final void run() {
        int i10 = this.f14901h;
        b bVar = this.f14903j;
        l lVar = this.f14902i;
        switch (i10) {
            case 0:
                lVar.f(bVar);
                return;
            case 1:
                lVar.m(bVar);
                return;
            case 2:
                lVar.a(bVar);
                return;
            case 3:
                lVar.j(bVar);
                return;
            case 4:
                lVar.k(bVar);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                lVar.e(bVar);
                return;
            case 6:
                lVar.l(bVar);
                return;
            default:
                lVar.h(bVar);
                return;
        }
    }
}
