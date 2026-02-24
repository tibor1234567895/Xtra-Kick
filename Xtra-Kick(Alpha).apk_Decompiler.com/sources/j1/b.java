package j1;

import android.os.Bundle;
import android.os.IBinder;
import g1.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Method f8409a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f8410b;

    private b() {
    }

    public static IBinder a(Bundle bundle, String str) {
        String str2;
        if (l0.f8453a >= 18) {
            return bundle.getBinder(str);
        }
        Method method = f8409a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                f8409a = method2;
                method2.setAccessible(true);
                method = f8409a;
            } catch (NoSuchMethodException e10) {
                e = e10;
                str2 = "Failed to retrieve getIBinder method";
                v.e(str2, e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, new Object[]{str});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            e = e11;
            str2 = "Failed to invoke getIBinder via reflection";
        }
    }

    public static void b(Bundle bundle, String str, k kVar) {
        String str2;
        if (l0.f8453a >= 18) {
            bundle.putBinder(str, kVar);
            return;
        }
        Method method = f8410b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f8410b = method2;
                method2.setAccessible(true);
                method = f8410b;
            } catch (NoSuchMethodException e10) {
                e = e10;
                str2 = "Failed to retrieve putIBinder method";
                v.e(str2, e);
                return;
            }
        }
        try {
            method.invoke(bundle, new Object[]{str, kVar});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            e = e11;
            str2 = "Failed to invoke putIBinder via reflection";
        }
    }
}
