package n0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public final class o {
    private o() {
    }

    public static void a(AccessibilityRecord accessibilityRecord, View view, int i10) {
        accessibilityRecord.setSource(view, i10);
    }
}
