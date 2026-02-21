package n0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

public final class h {
    private h() {
    }

    public static Bundle a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtras();
    }
}
