package a4;

import android.os.Trace;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f134a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f135b;

    private b() {
    }

    public static boolean a() {
        try {
            if (f135b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        Class<Trace> cls = Trace.class;
        try {
            if (f135b == null) {
                f134a = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                f135b = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f135b.invoke((Object) null, new Object[]{Long.valueOf(f134a)})).booleanValue();
        } catch (Exception e10) {
            if (!(e10 instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
