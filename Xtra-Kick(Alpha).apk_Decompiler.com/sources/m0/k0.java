package m0;

import android.graphics.Rect;
import android.view.View;

public final class k0 {
    private k0() {
    }

    public static Rect a(View view) {
        return view.getClipBounds();
    }

    public static boolean b(View view) {
        return view.isInLayout();
    }

    public static void c(View view, Rect rect) {
        view.setClipBounds(rect);
    }
}
