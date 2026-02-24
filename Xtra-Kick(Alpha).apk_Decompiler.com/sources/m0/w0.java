package m0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public final class w0 {
    private w0() {
    }

    public static View.AccessibilityDelegate a(View view) {
        return view.getAccessibilityDelegate();
    }

    public static List<Rect> b(View view) {
        return view.getSystemGestureExclusionRects();
    }

    public static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
    }

    public static void d(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
