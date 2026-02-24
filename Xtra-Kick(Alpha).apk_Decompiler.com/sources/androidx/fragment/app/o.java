package androidx.fragment.app;

public final class o implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1517h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1518i;

    public /* synthetic */ o(int i10, Object obj) {
        this.f1517h = i10;
        this.f1518i = obj;
    }

    public final void run() {
        int i10 = this.f1517h;
        Object obj = this.f1518i;
        switch (i10) {
            case 0:
                t tVar = (t) obj;
                tVar.f1566g0.onDismiss(tVar.f1574o0);
                return;
            default:
                ((c1) obj).y(true);
                return;
        }
    }
}
