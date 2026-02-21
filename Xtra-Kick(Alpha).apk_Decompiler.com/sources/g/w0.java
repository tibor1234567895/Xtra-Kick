package g;

import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static Field f6223a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6224b;

    /* renamed from: c  reason: collision with root package name */
    public static Class f6225c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f6226d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f6227e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f6228f;

    /* renamed from: g  reason: collision with root package name */
    public static Field f6229g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f6230h;

    private w0() {
    }

    public static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f6226d) {
            try {
                f6225c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f6226d = true;
        }
        Class cls = f6225c;
        if (cls != null) {
            if (!f6228f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f6227e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
                }
                f6228f = true;
            }
            Field field = f6227e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e12) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    v0.a(longSparseArray);
                }
            }
        }
    }
}
