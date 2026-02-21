package androidx.appcompat.widget;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.j;
import androidx.activity.o;
import java.util.Objects;

public final class x4 {
    private x4() {
    }

    public static OnBackInvokedDispatcher a(View view) {
        return view.findOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new o(runnable, 1);
    }

    public static void c(Object obj, Object obj2) {
        j.j(obj).registerOnBackInvokedCallback(1000000, j.g(obj2));
    }

    public static void d(Object obj, Object obj2) {
        j.j(obj).unregisterOnBackInvokedCallback(j.g(obj2));
    }
}
