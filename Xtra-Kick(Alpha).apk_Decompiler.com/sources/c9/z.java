package c9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3061a;

    static {
        Object obj;
        Method method = null;
        try {
            obj = Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            obj = null;
        }
        f3061a = obj;
        Class<Throwable> cls = Throwable.class;
        if (obj != null) {
            try {
                Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod("getStackTraceElement", new Class[]{cls, Integer.TYPE});
            } catch (ThreadDeath e11) {
                throw e11;
            } catch (Throwable unused2) {
            }
        }
        if (obj != null) {
            try {
                method = Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod("getStackTraceDepth", new Class[]{cls});
            } catch (ThreadDeath e12) {
                throw e12;
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused3) {
                return;
            } catch (Throwable unused4) {
            }
            if (method != null) {
                method.invoke(obj, new Object[]{new Throwable()});
            }
        }
    }

    private z() {
    }

    public static void a(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
