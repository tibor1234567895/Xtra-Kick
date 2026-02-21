package androidx.appcompat.widget;

import android.graphics.Rect;
import android.widget.PopupWindow;

public final class x2 {
    private x2() {
    }

    public static void a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    public static void b(PopupWindow popupWindow, boolean z10) {
        popupWindow.setIsClippedToScreen(z10);
    }
}
