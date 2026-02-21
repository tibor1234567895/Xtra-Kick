package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import m0.c;
import n0.i;

public class m2 extends c {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f2086d;

    /* renamed from: e  reason: collision with root package name */
    public final l2 f2087e;

    public m2(RecyclerView recyclerView) {
        this.f2086d = recyclerView;
        c j10 = j();
        this.f2087e = (j10 == null || !(j10 instanceof l2)) ? new l2(this) : (l2) j10;
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !this.f2086d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().d0(accessibilityEvent);
            }
        }
    }

    public final void d(View view, i iVar) {
        this.f10052a.onInitializeAccessibilityNodeInfo(view, iVar.f10916a);
        RecyclerView recyclerView = this.f2086d;
        if (!recyclerView.hasPendingAdapterUpdates() && recyclerView.getLayoutManager() != null) {
            q1 layoutManager = recyclerView.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f2144i;
            layoutManager.e0(recyclerView2.mRecycler, recyclerView2.mState, iVar);
        }
    }

    public final boolean g(View view, int i10, Bundle bundle) {
        if (super.g(view, i10, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f2086d;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        q1 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2144i;
        return layoutManager.s0(recyclerView2.mRecycler, recyclerView2.mState, i10, bundle);
    }

    public c j() {
        return this.f2087e;
    }
}
