package b4;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static Method f2560a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2561b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f2562c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2563d;

    public void a(View view, int i10, int i11, int i12, int i13) {
        if (!f2561b) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                f2560a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e10);
            }
            f2561b = true;
        }
        Method method = f2560a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    public void b(View view, int i10) {
        if (!f2563d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2562c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2563d = true;
        }
        Field field = f2562c;
        if (field != null) {
            try {
                f2562c.setInt(view, i10 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
