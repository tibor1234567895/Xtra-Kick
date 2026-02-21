package m0;

import android.view.View;
import android.view.Window;

public final class q1 {
    private q1() {
    }

    public static void a(Window window, boolean z10) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z10 ? systemUiVisibility & -1793 : systemUiVisibility | 1792);
    }
}
