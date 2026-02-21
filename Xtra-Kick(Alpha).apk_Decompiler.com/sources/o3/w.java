package o3;

import android.view.Window;
import android.view.WindowInsets;

public final class w {
    private w() {
    }

    public static void a(Window window) {
        window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
    }
}
