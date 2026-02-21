package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import f0.l;
import f0.m;
import java.lang.reflect.InvocationTargetException;

public final class i2 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f869a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f870b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f871c = new Rect();

    private i2() {
    }

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) || (i10 >= 29 && i10 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name))) {
            b(drawable);
        }
    }

    public static void b(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f869a);
        } else {
            drawable.setState(f870b);
        }
        drawable.setState(state);
    }

    public static Rect c(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            Insets a10 = h2.a(drawable);
            return new Rect(a10.left, a10.top, a10.right, a10.bottom);
        }
        if (drawable instanceof l) {
            drawable = ((m) ((l) drawable)).f5427m;
        }
        if (i10 >= 29) {
            boolean z10 = g2.f826a;
        } else if (g2.f826a) {
            try {
                Object invoke = g2.f827b.invoke(drawable, new Object[0]);
                if (invoke != null) {
                    return new Rect(g2.f828c.getInt(invoke), g2.f829d.getInt(invoke), g2.f830e.getInt(invoke), g2.f831f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f871c;
    }

    public static PorterDuff.Mode d(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case Constants.IV_SIZE /*16*/:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
