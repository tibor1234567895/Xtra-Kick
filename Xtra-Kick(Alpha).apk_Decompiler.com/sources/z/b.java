package z;

import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public abstract class b {
    public b() {
    }

    public b(int i10) {
    }

    public boolean a(View view, Rect rect) {
        return false;
    }

    public boolean b(View view, View view2) {
        return false;
    }

    public void c(e eVar) {
    }

    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public void e(CoordinatorLayout coordinatorLayout, View view) {
    }

    public void f() {
    }

    public boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        return false;
    }

    public boolean i(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        return false;
    }

    public boolean j(View view) {
        return false;
    }

    public void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
    }

    public void l(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
        iArr[0] = iArr[0] + i11;
        iArr[1] = iArr[1] + i12;
    }

    public boolean m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
        return false;
    }

    public void n(View view, Parcelable parcelable) {
    }

    public Parcelable o(View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11) {
        return false;
    }

    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i10) {
    }

    public boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }
}
