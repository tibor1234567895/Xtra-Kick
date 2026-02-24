package m0;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;

public final class j0 {
    private j0() {
    }

    public static int a() {
        return View.generateViewId();
    }

    public static Display b(View view) {
        return view.getDisplay();
    }

    public static int c(View view) {
        return view.getLabelFor();
    }

    public static int d(View view) {
        return view.getLayoutDirection();
    }

    public static int e(View view) {
        return view.getPaddingEnd();
    }

    public static int f(View view) {
        return view.getPaddingStart();
    }

    public static boolean g(View view) {
        return view.isPaddingRelative();
    }

    public static void h(View view, int i10) {
        view.setLabelFor(i10);
    }

    public static void i(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static void j(View view, int i10) {
        view.setLayoutDirection(i10);
    }

    public static void k(View view, int i10, int i11, int i12, int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }
}
