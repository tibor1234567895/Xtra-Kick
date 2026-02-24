package androidx.fragment.app;

import android.view.ViewGroup;

public final class u implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1587h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f1588i;

    public /* synthetic */ u(int i10, c0 c0Var) {
        this.f1587h = i10;
        this.f1588i = c0Var;
    }

    public final void run() {
        ViewGroup viewGroup;
        c1 c1Var;
        int i10 = this.f1587h;
        c0 c0Var = this.f1588i;
        switch (i10) {
            case 0:
                if (c0Var.P != null) {
                    c0Var.s().getClass();
                    return;
                }
                return;
            default:
                if (c0Var.M != null && (viewGroup = c0Var.L) != null && (c1Var = c0Var.f1370z) != null) {
                    n h10 = n.h(viewGroup, c1Var);
                    h10.i();
                    h10.d();
                    return;
                }
                return;
        }
    }
}
