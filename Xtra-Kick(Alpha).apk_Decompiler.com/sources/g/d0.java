package g;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.j;
import java.util.Objects;

public final class d0 {
    private d0() {
    }

    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, k0 k0Var) {
        Objects.requireNonNull(k0Var);
        c0 c0Var = new c0(k0Var);
        j.j(obj).registerOnBackInvokedCallback(1000000, c0Var);
        return c0Var;
    }

    public static void c(Object obj, Object obj2) {
        j.j(obj).unregisterOnBackInvokedCallback(j.g(obj2));
    }
}
