package m0;

import android.os.Build;
import android.view.Window;

public final class s1 {
    private s1() {
    }

    public static void a(Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            r1.a(window, z10);
        } else {
            q1.a(window, z10);
        }
    }
}
