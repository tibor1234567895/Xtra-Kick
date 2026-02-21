package b0;

import android.app.Activity;
import androidx.appcompat.widget.w1;

public final class b {
    private b() {
    }

    public static void a(Object obj) {
        w1.h(obj).onSharedElementsReady();
    }

    public static void b(Activity activity, String[] strArr, int i10) {
        activity.requestPermissions(strArr, i10);
    }

    public static boolean c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
