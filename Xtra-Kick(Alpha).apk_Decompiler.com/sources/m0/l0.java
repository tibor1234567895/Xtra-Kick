package m0;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class l0 {
    private l0() {
    }

    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean c(View view) {
        return view.isLaidOut();
    }

    public static boolean d(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static void e(ViewParent viewParent, View view, View view2, int i10) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
    }

    public static void f(View view, int i10) {
        view.setAccessibilityLiveRegion(i10);
    }

    public static void g(AccessibilityEvent accessibilityEvent, int i10) {
        accessibilityEvent.setContentChangeTypes(i10);
    }
}
