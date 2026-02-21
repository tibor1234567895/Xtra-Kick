package androidx.activity;

import android.window.OnBackInvokedCallback;
import java.util.Objects;

public final class p {
    private p() {
    }

    public static OnBackInvokedCallback a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new o(runnable, 0);
    }

    public static void b(Object obj, int i10, Object obj2) {
        j.j(obj).registerOnBackInvokedCallback(i10, j.g(obj2));
    }

    public static void c(Object obj, Object obj2) {
        j.j(obj).unregisterOnBackInvokedCallback(j.g(obj2));
    }
}
