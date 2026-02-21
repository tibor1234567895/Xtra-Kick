package ma;

import java.util.RandomAccess;
import xa.j;

public final class e extends f implements RandomAccess {

    /* renamed from: i  reason: collision with root package name */
    public final f f10805i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10806j;

    /* renamed from: k  reason: collision with root package name */
    public final int f10807k;

    public e(f fVar, int i10, int i11) {
        j.f("list", fVar);
        this.f10805i = fVar;
        this.f10806j = i10;
        int a10 = fVar.a();
        f.f10810h.getClass();
        c.c(i10, i11, a10);
        this.f10807k = i11 - i10;
    }

    public final int a() {
        return this.f10807k;
    }

    public final Object get(int i10) {
        f.f10810h.getClass();
        c.a(i10, this.f10807k);
        return this.f10805i.get(this.f10806j + i10);
    }
}
