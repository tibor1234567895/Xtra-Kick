package k0;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f8950a;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f8950a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    private f() {
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.c(e.a(e.b(locale)));
        }
        try {
            return d.a((Locale) f8950a.invoke((Object) null, new Object[]{locale}));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            Log.w("ICUCompat", e10);
            return d.a(locale);
        }
    }
}
