package n9;

import j9.t;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public static Class f11761d;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11762b;

    /* renamed from: c  reason: collision with root package name */
    public final Field f11763c;

    public c() {
        Object obj;
        Field field = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f11761d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get((Object) null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f11762b = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.f11763c = field;
    }

    public final void a(AccessibleObject accessibleObject) {
        Field field;
        boolean z10 = false;
        Object obj = this.f11762b;
        if (!(obj == null || (field = this.f11763c) == null)) {
            try {
                long longValue = ((Long) f11761d.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(obj, new Object[]{field})).longValue();
                f11761d.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(obj, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.TRUE});
                z10 = true;
            } catch (Exception unused) {
            }
        }
        if (!z10) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e10) {
                throw new t("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e10);
            }
        }
    }
}
