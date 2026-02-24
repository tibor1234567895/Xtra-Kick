package xa;

import android.support.v4.media.h;
import java.util.Arrays;
import la.u;

public final class j {
    private j() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(String str, Object obj) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
            j(j.class.getName(), illegalStateException);
            throw illegalStateException;
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            j(j.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void d(String str, Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            j(j.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void e(String str, Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
            j(j.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void f(String str, Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(i(str));
            j(j.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void g(String str, Object obj) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i(str));
            j(j.class.getName(), illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static int h(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = j.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void j(String str, RuntimeException runtimeException) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
    }

    public static String k(String str, Object obj) {
        return str + obj;
    }

    public static void l(String str) {
        u uVar = new u(h.n("lateinit property ", str, " has not been initialized"));
        j(j.class.getName(), uVar);
        throw uVar;
    }
}
