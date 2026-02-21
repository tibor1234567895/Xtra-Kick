package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.drawable.Drawable;

public final class h2 {
    private h2() {
    }

    public static Insets a(Drawable drawable) {
        return drawable.getOpticalInsets();
    }
}
