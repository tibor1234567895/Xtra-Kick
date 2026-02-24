package m0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import q.k;

public final class u2 extends v2 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowInsetsController f10150a;

    /* renamed from: b  reason: collision with root package name */
    public final Window f10151b;

    public u2(Window window) {
        WindowInsetsController f10 = window.getInsetsController();
        new k();
        this.f10150a = f10;
        this.f10151b = window;
    }

    public final void a() {
        this.f10150a.hide(7);
    }

    public final boolean b() {
        return (this.f10150a.getSystemBarsAppearance() & 8) != 0;
    }

    public final void c(boolean z10) {
        WindowInsetsController windowInsetsController = this.f10150a;
        Window window = this.f10151b;
        if (z10) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -17);
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    public final void d(boolean z10) {
        WindowInsetsController windowInsetsController = this.f10150a;
        Window window = this.f10151b;
        if (z10) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -8193);
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    public final void e() {
        this.f10150a.setSystemBarsBehavior(2);
    }

    public final void f() {
        Window window = this.f10151b;
        this.f10150a.show(7);
    }
}
