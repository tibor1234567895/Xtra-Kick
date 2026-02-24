package l;

import android.view.Window;

public final class q {
    private q() {
    }

    public static void a(Window.Callback callback, boolean z10) {
        callback.onPointerCaptureChanged(z10);
    }
}
