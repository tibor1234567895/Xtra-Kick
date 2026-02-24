package b4;

import android.view.View;

public class h0 extends m0 {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2545e = true;

    public float c(View view) {
        if (f2545e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2545e = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view, float f10) {
        if (f2545e) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f2545e = false;
            }
        }
        view.setAlpha(f10);
    }
}
