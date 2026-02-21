package i8;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import f0.b;
import f0.d;

public final class a {
    private a() {
    }

    public static Drawable a(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        boolean z10;
        if (Build.VERSION.SDK_INT < 23) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            Drawable mutate = d.g(drawable).mutate();
            if (mode == null) {
                return mutate;
            }
            b.i(mutate, mode);
            return mutate;
        } else if (!z10) {
            return drawable;
        } else {
            drawable.mutate();
            return drawable;
        }
    }

    public static void b(Drawable drawable, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Build.VERSION.SDK_INT == 21) {
            if (z10) {
                drawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter((ColorFilter) null);
            }
        } else if (z10) {
            b.g(drawable, i10);
        } else {
            b.h(drawable, (ColorStateList) null);
        }
    }
}
