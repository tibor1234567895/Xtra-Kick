package b4;

import android.graphics.Matrix;
import android.view.View;

public class i0 extends h0 {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2546f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2547g = true;

    public void e(View view, Matrix matrix) {
        if (f2546f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2546f = false;
            }
        }
    }

    public void f(View view, Matrix matrix) {
        if (f2547g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2547g = false;
            }
        }
    }
}
