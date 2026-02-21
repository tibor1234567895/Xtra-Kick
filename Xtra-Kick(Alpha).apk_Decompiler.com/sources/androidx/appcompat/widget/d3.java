package androidx.appcompat.widget;

import android.transition.Transition;
import android.widget.PopupWindow;

public final class d3 {
    private d3() {
    }

    public static void a(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    public static void b(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}
