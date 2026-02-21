package l9;

import java.lang.reflect.Method;

public final class t extends x {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f9794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9795b;

    public t(Method method, Object obj) {
        this.f9794a = method;
        this.f9795b = obj;
    }

    public final Object b(Class cls) {
        x.a(cls);
        return this.f9794a.invoke(this.f9795b, new Object[]{cls});
    }
}
