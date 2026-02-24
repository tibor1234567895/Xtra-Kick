package m0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

public final class b {
    private b() {
    }

    public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i10, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i10, bundle);
    }
}
