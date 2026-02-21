package f0;

import android.graphics.drawable.Drawable;

public final class c {
    private c() {
    }

    public static int a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static boolean b(Drawable drawable, int i10) {
        return drawable.setLayoutDirection(i10);
    }
}
