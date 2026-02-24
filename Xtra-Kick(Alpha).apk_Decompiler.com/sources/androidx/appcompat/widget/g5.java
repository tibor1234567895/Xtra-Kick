package androidx.appcompat.widget;

public final /* synthetic */ class g5 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f839h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h5 f840i;

    public /* synthetic */ g5(h5 h5Var, int i10) {
        this.f839h = i10;
        this.f840i = h5Var;
    }

    public final void run() {
        int i10 = this.f839h;
        h5 h5Var = this.f840i;
        switch (i10) {
            case 0:
                h5Var.c(false);
                return;
            default:
                h5Var.a();
                return;
        }
    }
}
