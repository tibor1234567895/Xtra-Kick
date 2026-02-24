package l9;

import java.lang.reflect.Method;

public final class u extends x {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f9796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f9797b;

    public u(Method method, int i10) {
        this.f9796a = method;
        this.f9797b = i10;
    }

    public final Object b(Class cls) {
        x.a(cls);
        return this.f9796a.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f9797b)});
    }
}
