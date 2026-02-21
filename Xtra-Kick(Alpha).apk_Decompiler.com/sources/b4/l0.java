package b4;

import android.graphics.Matrix;
import android.view.View;

public final class l0 extends k0 {
    public final void a(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    public final void b(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    public final float c(View view) {
        return view.getTransitionAlpha();
    }

    public final void d(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    public final void e(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public final void f(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
