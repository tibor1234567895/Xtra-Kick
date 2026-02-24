package d0;

import android.content.res.ColorStateList;
import android.content.res.Resources;

public final class l {
    private l() {
    }

    public static int a(Resources resources, int i10, Resources.Theme theme) {
        return resources.getColor(i10, theme);
    }

    public static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
        return resources.getColorStateList(i10, theme);
    }
}
