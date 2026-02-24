package androidx.appcompat.widget;

import android.content.res.Resources;
import android.widget.ThemedSpinnerAdapter;
import l0.b;

public final class z0 {
    private z0() {
    }

    public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
        if (!b.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }
}
