package mb;

import eb.m;
import eb.q;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.CoroutineExceptionHandler;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final List f10853a;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        f10853a = q.d(m.a(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }
}
