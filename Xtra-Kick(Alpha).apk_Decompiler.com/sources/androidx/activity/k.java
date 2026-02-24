package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;

public final class k {
    private k() {
    }

    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }
}
