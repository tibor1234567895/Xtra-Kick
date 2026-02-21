package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

public final class l5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f924a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f925b = (Build.VERSION.SDK_INT >= 27);

    static {
        Class<Rect> cls = Rect.class;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            f924a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    private l5() {
    }

    public static boolean a(View view) {
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(view) == 1) {
            return true;
        }
        return false;
    }
}
