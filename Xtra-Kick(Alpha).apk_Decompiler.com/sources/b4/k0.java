package b4;

import android.os.Build;
import android.view.View;

public class k0 extends j0 {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f2558i = true;

    public void b(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.b(view, i10);
        } else if (f2558i) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f2558i = false;
            }
        }
    }
}
