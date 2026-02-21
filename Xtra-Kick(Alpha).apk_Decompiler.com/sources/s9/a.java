package s9;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import la.v;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f14391a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f14392b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f14393c;

    public a(String str) {
        j.g("namespace", str);
        this.f14393c = str;
        this.f14391a = new Object();
        this.f14392b = new LinkedHashMap();
    }

    public final void a(int i10, c cVar) {
        synchronized (this.f14391a) {
            ((Map) this.f14392b).put(Integer.valueOf(i10), cVar);
            v vVar = v.f9814a;
        }
    }

    public final void b() {
        synchronized (this.f14391a) {
            ((Map) this.f14392b).clear();
            v vVar = v.f9814a;
        }
    }

    public final boolean c(int i10) {
        boolean containsKey;
        synchronized (this.f14391a) {
            containsKey = ((Map) this.f14392b).containsKey(Integer.valueOf(i10));
        }
        return containsKey;
    }

    public final void d(int i10) {
        synchronized (this.f14391a) {
            c cVar = (c) ((Map) this.f14392b).remove(Integer.valueOf(i10));
        }
    }

    public a(Method method, Method method2, Method method3) {
        this.f14391a = method;
        this.f14392b = method2;
        this.f14393c = method3;
    }
}
