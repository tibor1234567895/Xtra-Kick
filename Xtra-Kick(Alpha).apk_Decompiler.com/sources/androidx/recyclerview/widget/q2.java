package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class q2 extends t1 {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f2158a;

    /* renamed from: b  reason: collision with root package name */
    public final p2 f2159b = new p2(this);

    public final boolean a(int i10, int i11) {
        boolean z10;
        a1 d10;
        int f10;
        q1 layoutManager = this.f2158a.getLayoutManager();
        if (layoutManager == null || this.f2158a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f2158a.getMinFlingVelocity();
        if (Math.abs(i11) <= minFlingVelocity && Math.abs(i10) <= minFlingVelocity) {
            return false;
        }
        if (!(layoutManager instanceof e2) || (d10 = d(layoutManager)) == null || (f10 = f(layoutManager, i10, i11)) == -1) {
            z10 = false;
        } else {
            d10.f1983a = f10;
            layoutManager.L0(d10);
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public final void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2158a;
        if (recyclerView2 != recyclerView) {
            p2 p2Var = this.f2159b;
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(p2Var);
                this.f2158a.setOnFlingListener((t1) null);
            }
            this.f2158a = recyclerView;
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.getOnFlingListener() == null) {
                this.f2158a.addOnScrollListener(p2Var);
                this.f2158a.setOnFlingListener(this);
                new Scroller(this.f2158a.getContext(), new DecelerateInterpolator());
                g();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public abstract int[] c(q1 q1Var, View view);

    public a1 d(q1 q1Var) {
        if (!(q1Var instanceof e2)) {
            return null;
        }
        return new a1(1, this.f2158a.getContext(), this);
    }

    public abstract View e(q1 q1Var);

    public abstract int f(q1 q1Var, int i10, int i11);

    public final void g() {
        q1 layoutManager;
        View e10;
        RecyclerView recyclerView = this.f2158a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (e10 = e(layoutManager)) != null) {
            int[] c10 = c(layoutManager, e10);
            int i10 = c10[0];
            if (i10 != 0 || c10[1] != 0) {
                this.f2158a.smoothScrollBy(i10, c10[1]);
            }
        }
    }
}
