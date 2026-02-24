package j1;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8477a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final t f8478b = u.f8476a;

    private v() {
    }

    public static String a(String str, Throwable th) {
        String str2;
        boolean z10;
        synchronized (f8477a) {
            if (th == null) {
                try {
                    str2 = null;
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            } else {
                Throwable th3 = th;
                while (true) {
                    if (th3 == null) {
                        z10 = false;
                        break;
                    } else if (th3 instanceof UnknownHostException) {
                        z10 = true;
                        break;
                    } else {
                        th3 = th3.getCause();
                    }
                }
                if (z10) {
                    str2 = "UnknownHostException (no network)";
                } else {
                    str2 = Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "\n  " + str2.replace(Constants.WRITE_NEW_LINE, "\n  ") + 10;
    }

    public static void b() {
        synchronized (f8477a) {
            f8478b.getClass();
        }
    }

    public static void c(String str, String str2) {
        synchronized (f8477a) {
            f8478b.getClass();
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    public static void e(String str, Exception exc) {
        f("BundleUtil", a(str, exc));
    }

    public static void f(String str, String str2) {
        synchronized (f8477a) {
            f8478b.getClass();
            Log.i(str, str2);
        }
    }

    public static void g(String str, String str2) {
        synchronized (f8477a) {
            f8478b.getClass();
            Log.w(str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        g(str, a(str2, th));
    }
}
