package m0;

import android.view.View;
import java.util.Collection;

public final class s0 {
    private s0() {
    }

    public static void a(View view, Collection<View> collection, int i10) {
        view.addKeyboardNavigationClusters(collection, i10);
    }

    public static int b(View view) {
        return view.getImportantForAutofill();
    }

    public static int c(View view) {
        return view.getNextClusterForwardId();
    }

    public static boolean d(View view) {
        return view.hasExplicitFocusable();
    }

    public static boolean e(View view) {
        return view.isFocusedByDefault();
    }

    public static boolean f(View view) {
        return view.isImportantForAutofill();
    }

    public static boolean g(View view) {
        return view.isKeyboardNavigationCluster();
    }

    public static View h(View view, View view2, int i10) {
        return view.keyboardNavigationClusterSearch(view2, i10);
    }

    public static boolean i(View view) {
        return view.restoreDefaultFocus();
    }

    public static void j(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    public static void k(View view, boolean z10) {
        view.setFocusedByDefault(z10);
    }

    public static void l(View view, int i10) {
        view.setImportantForAutofill(i10);
    }

    public static void m(View view, boolean z10) {
        view.setKeyboardNavigationCluster(z10);
    }

    public static void n(View view, int i10) {
        view.setNextClusterForwardId(i10);
    }

    public static void o(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
