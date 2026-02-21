package q0;

import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static Method f13120a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13121b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f13122c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13123d;

    private s() {
    }

    public static void a(PopupWindow popupWindow, boolean z10) {
        if (Build.VERSION.SDK_INT >= 23) {
            r.c(popupWindow, z10);
            return;
        }
        if (!f13123d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f13122c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e10);
            }
            f13123d = true;
        }
        Field field = f13122c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z10));
            } catch (IllegalAccessException e11) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e11);
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            r.d(popupWindow, i10);
            return;
        }
        if (!f13121b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f13120a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f13121b = true;
        }
        Method method = f13120a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i10)});
            } catch (Exception unused2) {
            }
        }
    }
}
