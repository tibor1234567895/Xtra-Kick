package mb;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f10841a;

    static {
        Method method;
        Class<ScheduledThreadPoolExecutor> cls = ScheduledThreadPoolExecutor.class;
        try {
            method = cls.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});
        } catch (Throwable unused) {
            method = null;
        }
        f10841a = method;
    }
}
