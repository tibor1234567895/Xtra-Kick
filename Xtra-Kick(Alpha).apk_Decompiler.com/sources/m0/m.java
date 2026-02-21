package m0;

import android.graphics.Rect;
import android.view.Gravity;

public final class m {
    private m() {
    }

    public static void a(int i10, int i11, int i12, Rect rect, int i13, int i14, Rect rect2, int i15) {
        Gravity.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
    }

    public static void b(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
        Gravity.apply(i10, i11, i12, rect, rect2, i13);
    }

    public static void c(int i10, Rect rect, Rect rect2, int i11) {
        Gravity.applyDisplay(i10, rect, rect2, i11);
    }
}
