package z;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class d implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f17321h;

    public d(CoordinatorLayout coordinatorLayout) {
        this.f17321h = coordinatorLayout;
    }

    public final void onChildViewAdded(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f17321h.f1201x;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    public final void onChildViewRemoved(View view, View view2) {
        CoordinatorLayout coordinatorLayout = this.f17321h;
        coordinatorLayout.q(2);
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.f1201x;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
