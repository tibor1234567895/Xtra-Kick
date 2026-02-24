package n;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    public final Object f10896a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f10897b = Executors.newFixedThreadPool(4, new c());

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f10898c;

    public static Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
