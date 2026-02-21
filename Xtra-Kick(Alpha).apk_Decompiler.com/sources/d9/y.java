package d9;

import c9.n;
import java.util.Map;

public final class y extends q {

    /* renamed from: h  reason: collision with root package name */
    public final Object f4708h;

    /* renamed from: i  reason: collision with root package name */
    public int f4709i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ z f4710j;

    public y(z zVar, int i10) {
        this.f4710j = zVar;
        Object obj = z.f4714q;
        this.f4708h = zVar.c(i10);
        this.f4709i = i10;
    }

    public final void a() {
        int i10 = this.f4709i;
        Object obj = this.f4708h;
        z zVar = this.f4710j;
        if (i10 == -1 || i10 >= zVar.size() || !n.a(obj, zVar.c(this.f4709i))) {
            Object obj2 = z.f4714q;
            this.f4709i = zVar.b(obj);
        }
    }

    public final Object getKey() {
        return this.f4708h;
    }

    public final Object getValue() {
        z zVar = this.f4710j;
        Map a10 = zVar.a();
        if (a10 != null) {
            return a10.get(this.f4708h);
        }
        a();
        int i10 = this.f4709i;
        if (i10 == -1) {
            return null;
        }
        return zVar.k(i10);
    }

    public final Object setValue(Object obj) {
        z zVar = this.f4710j;
        Map a10 = zVar.a();
        Object obj2 = this.f4708h;
        if (a10 != null) {
            return a10.put(obj2, obj);
        }
        a();
        int i10 = this.f4709i;
        if (i10 == -1) {
            zVar.put(obj2, obj);
            return null;
        }
        Object k10 = zVar.k(i10);
        zVar.i()[this.f4709i] = obj;
        return k10;
    }
}
