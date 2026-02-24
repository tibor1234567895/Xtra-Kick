package f0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static Method f5417a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5418b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f5419c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f5420d;

    private d() {
    }

    public static void a(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Drawable drawable2;
        int i10 = Build.VERSION.SDK_INT;
        drawable.clearColorFilter();
        if (i10 < 23) {
            if (drawable instanceof InsetDrawable) {
                drawable2 = a.c((InsetDrawable) drawable);
            } else if (drawable instanceof l) {
                drawable2 = ((m) ((l) drawable)).f5427m;
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    Drawable b10 = a.b(drawableContainerState, i11);
                    if (b10 != null) {
                        a(b10);
                    }
                }
                return;
            } else {
                return;
            }
            a(drawable2);
        }
    }

    public static int b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.a(drawable);
        }
        if (!f5420d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f5419c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e10);
            }
            f5420d = true;
        }
        Method method = f5419c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e11) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e11);
                f5419c = null;
            }
        }
        return 0;
    }

    public static boolean c(Drawable drawable, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.b(drawable, i10);
        }
        if (!f5418b) {
            Class<Drawable> cls = Drawable.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f5417a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e10);
            }
            f5418b = true;
        }
        Method method = f5417a;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{Integer.valueOf(i10)});
                return true;
            } catch (Exception e11) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e11);
                f5417a = null;
            }
        }
        return false;
    }

    public static void d(Drawable drawable, int i10) {
        b.g(drawable, i10);
    }

    public static void e(Drawable drawable, ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void f(Drawable drawable, PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    public static Drawable g(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof k)) ? new n(drawable) : drawable;
    }
}
