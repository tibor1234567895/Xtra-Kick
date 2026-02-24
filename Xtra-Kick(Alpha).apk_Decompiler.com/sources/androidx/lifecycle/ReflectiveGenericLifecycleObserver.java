package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

@Deprecated
class ReflectiveGenericLifecycleObserver implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final Object f1632h;

    /* renamed from: i  reason: collision with root package name */
    public final d f1633i;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1632h = obj;
        this.f1633i = f.f1679c.b(obj.getClass());
    }

    public final void d(d0 d0Var, r rVar) {
        HashMap hashMap = this.f1633i.f1672a;
        Object obj = this.f1632h;
        d.a((List) hashMap.get(rVar), d0Var, rVar, obj);
        d.a((List) hashMap.get(r.ON_ANY), d0Var, rVar, obj);
    }
}
