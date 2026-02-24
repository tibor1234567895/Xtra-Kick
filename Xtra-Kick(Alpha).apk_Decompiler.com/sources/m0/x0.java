package m0;

import android.view.View;

public final class x0 {
    private x0() {
    }

    public static CharSequence a(View view) {
        return view.getStateDescription();
    }

    public static void b(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
