package m0;

import android.graphics.Rect;
import android.view.DisplayCutout;
import j4.z;
import java.util.List;

public final class k {
    private k() {
    }

    public static DisplayCutout a(Rect rect, List<Rect> list) {
        z.y();
        return z.n(rect, list);
    }

    public static List<Rect> b(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    public static int c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
