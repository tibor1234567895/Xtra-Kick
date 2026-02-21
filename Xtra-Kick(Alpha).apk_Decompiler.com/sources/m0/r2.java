package m0;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.e;

public class r2 extends v2 {

    /* renamed from: a  reason: collision with root package name */
    public final Window f10132a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10133b;

    public r2(Window window, View view) {
        this.f10132a = window;
        this.f10133b = view;
    }

    public final void a() {
        int i10;
        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
            if ((7 & i11) != 0) {
                if (i11 != 1) {
                    i10 = 2;
                    if (i11 != 2) {
                        if (i11 == 8) {
                            Window window = this.f10132a;
                            ((InputMethodManager) window.getContext().getSystemService("input_method")).hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
                        }
                    }
                } else {
                    i10 = 4;
                }
                g(i10);
            }
        }
    }

    public final void e() {
        h(2048);
        g(4096);
    }

    public final void f() {
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if ((7 & i10) != 0) {
                Window window = this.f10132a;
                if (i10 == 1) {
                    h(4);
                    window.clearFlags(1024);
                } else if (i10 == 2) {
                    h(2);
                } else if (i10 == 8) {
                    View view = this.f10133b;
                    if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                        view.requestFocus();
                    } else {
                        view = window.getCurrentFocus();
                    }
                    if (view == null) {
                        view = window.findViewById(16908290);
                    }
                    if (view != null && view.hasWindowFocus()) {
                        view.post(new e(4, view));
                    }
                }
            }
        }
    }

    public final void g(int i10) {
        View decorView = this.f10132a.getDecorView();
        decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
    }

    public final void h(int i10) {
        View decorView = this.f10132a.getDecorView();
        decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
    }
}
