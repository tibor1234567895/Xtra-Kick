package t9;

import la.i;

public final class h implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14854h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f14855i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ i f14856j;

    public /* synthetic */ h(i iVar, i iVar2, int i10) {
        this.f14854h = i10;
        this.f14855i = iVar;
        this.f14856j = iVar2;
    }

    public final void run() {
        int i10 = this.f14854h;
        i iVar = this.f14856j;
        i iVar2 = this.f14855i;
        switch (i10) {
            case 0:
                i iVar3 = iVar2.f14858b;
                if (iVar3 != null) {
                    iVar3.a(iVar.f9800i);
                    return;
                }
                return;
            default:
                i iVar4 = iVar2.f14859c;
                if (iVar4 != null) {
                    iVar4.a(iVar.f9799h);
                    return;
                }
                return;
        }
    }
}
