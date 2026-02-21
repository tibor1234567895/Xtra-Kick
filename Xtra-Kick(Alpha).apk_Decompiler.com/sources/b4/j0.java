package b4;

import android.view.View;

public class j0 extends i0 {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f2550h = true;

    public void a(View view, int i10, int i11, int i12, int i13) {
        if (f2550h) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f2550h = false;
            }
        }
    }
}
