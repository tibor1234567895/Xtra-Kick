package androidx.recyclerview.widget;

import android.view.View;

public final class e1 implements c3, l1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1972a;

    public /* synthetic */ e1(RecyclerView recyclerView) {
        this.f1972a = recyclerView;
    }

    public final void a(a aVar) {
        int i10 = aVar.f1925a;
        RecyclerView recyclerView = this.f1972a;
        if (i10 == 1) {
            recyclerView.mLayout.h0(aVar.f1926b, aVar.f1928d);
        } else if (i10 == 2) {
            recyclerView.mLayout.k0(aVar.f1926b, aVar.f1928d);
        } else if (i10 == 4) {
            recyclerView.mLayout.m0(recyclerView, aVar.f1926b, aVar.f1928d);
        } else if (i10 == 8) {
            recyclerView.mLayout.j0(aVar.f1926b, aVar.f1928d);
        }
    }

    public final int b() {
        return this.f1972a.getChildCount();
    }

    public final void c(int i10) {
        RecyclerView recyclerView = this.f1972a;
        View childAt = recyclerView.getChildAt(i10);
        if (childAt != null) {
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i10);
    }
}
