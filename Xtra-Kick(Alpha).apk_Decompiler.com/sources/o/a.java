package o;

import java.util.HashMap;

public final class a extends g {

    /* renamed from: l  reason: collision with root package name */
    public final HashMap f11838l = new HashMap();

    public final c a(Object obj) {
        return (c) this.f11838l.get(obj);
    }

    public final Object b(Object obj, Object obj2) {
        c a10 = a(obj);
        if (a10 != null) {
            return a10.f11841i;
        }
        HashMap hashMap = this.f11838l;
        c cVar = new c(obj, obj2);
        this.f11852k++;
        c cVar2 = this.f11850i;
        if (cVar2 == null) {
            this.f11849h = cVar;
        } else {
            cVar2.f11842j = cVar;
            cVar.f11843k = cVar2;
        }
        this.f11850i = cVar;
        hashMap.put(obj, cVar);
        return null;
    }

    public final Object c(Object obj) {
        Object c10 = super.c(obj);
        this.f11838l.remove(obj);
        return c10;
    }
}
