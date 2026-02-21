package m0;

import android.view.View;
import com.woxthebox.draglistview.R;
import java.util.Objects;
import q.k;

public final class u0 {
    private u0() {
    }

    public static void a(View view, a1 a1Var) {
        k kVar = (k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar == null) {
            kVar = new k();
            view.setTag(R.id.tag_unhandled_key_listeners, kVar);
        }
        Objects.requireNonNull(a1Var);
        t0 t0Var = new t0();
        kVar.put(a1Var, t0Var);
        view.addOnUnhandledKeyEventListener(t0Var);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, a1 a1Var) {
        View.OnUnhandledKeyEventListener i10;
        k kVar = (k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar != null && (i10 = j.i(kVar.getOrDefault(a1Var, (Object) null))) != null) {
            view.removeOnUnhandledKeyEventListener(i10);
        }
    }

    public static <T> T f(View view, int i10) {
        return view.requireViewById(i10);
    }

    public static void g(View view, boolean z10) {
        view.setAccessibilityHeading(z10);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, boolean z10) {
        view.setScreenReaderFocusable(z10);
    }
}
