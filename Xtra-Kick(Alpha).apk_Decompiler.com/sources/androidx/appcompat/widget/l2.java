package androidx.appcompat.widget;

import android.widget.AbsListView;

public final class l2 {
    private l2() {
    }

    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView, boolean z10) {
        absListView.setSelectedChildViewEnabled(z10);
    }
}
