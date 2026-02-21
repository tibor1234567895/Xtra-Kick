package androidx.appcompat.widget;

import android.view.View;
import android.widget.PopupWindow;

public final class w2 {
    private w2() {
    }

    public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
        return popupWindow.getMaxAvailableHeight(view, i10, z10);
    }
}
