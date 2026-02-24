package androidx.appcompat.widget;

import m.q;

public final /* synthetic */ class v4 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1109h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Toolbar f1110i;

    public /* synthetic */ v4(Toolbar toolbar, int i10) {
        this.f1109h = i10;
        this.f1110i = toolbar;
    }

    public final void run() {
        q qVar;
        int i10 = this.f1109h;
        Toolbar toolbar = this.f1110i;
        switch (i10) {
            case 0:
                toolbar.l();
                return;
            default:
                y4 y4Var = toolbar.S;
                if (y4Var == null) {
                    qVar = null;
                } else {
                    qVar = y4Var.f1134i;
                }
                if (qVar != null) {
                    qVar.collapseActionView();
                    return;
                }
                return;
        }
    }
}
