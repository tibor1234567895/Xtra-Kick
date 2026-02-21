package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;

public final class z2 implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b3 f1152a;

    public z2(b3 b3Var) {
        this.f1152a = b3Var;
    }

    public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i10) {
        boolean z10 = true;
        if (i10 == 1) {
            b3 b3Var = this.f1152a;
            if (b3Var.G.getInputMethodMode() != 2) {
                z10 = false;
            }
            if (!z10 && b3Var.G.getContentView() != null) {
                Handler handler = b3Var.C;
                u2 u2Var = b3Var.f768y;
                handler.removeCallbacks(u2Var);
                u2Var.run();
            }
        }
    }
}
