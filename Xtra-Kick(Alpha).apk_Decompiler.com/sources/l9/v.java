package l9;

import java.lang.reflect.Method;

public final class v extends x {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f9798a;

    public v(Method method) {
        this.f9798a = method;
    }

    public final Object b(Class cls) {
        x.a(cls);
        return this.f9798a.invoke((Object) null, new Object[]{cls, Object.class});
    }
}
