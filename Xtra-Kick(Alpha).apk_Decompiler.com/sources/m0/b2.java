package m0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f10047a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f10048b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f10049c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f10050d = true;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f10047a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f10048b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f10049c = declaredField3;
            declaredField3.setAccessible(true);
        } catch (ReflectiveOperationException e10) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
        }
    }

    private b2() {
    }
}
