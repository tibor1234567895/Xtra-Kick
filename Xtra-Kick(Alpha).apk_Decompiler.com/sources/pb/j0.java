package pb;

import dc.k;
import java.util.ArrayList;
import java.util.List;
import qb.h;
import xa.j;

public final class j0 extends o1 {

    /* renamed from: c  reason: collision with root package name */
    public static final x0 f12881c = w0.a("application/x-www-form-urlencoded");

    /* renamed from: a  reason: collision with root package name */
    public final List f12882a;

    /* renamed from: b  reason: collision with root package name */
    public final List f12883b;

    static {
        new i0(0);
        x0.f13023d.getClass();
    }

    public j0(ArrayList arrayList, ArrayList arrayList2) {
        j.f("encodedNames", arrayList);
        j.f("encodedValues", arrayList2);
        this.f12882a = h.l(arrayList);
        this.f12883b = h.l(arrayList2);
    }

    public final long a(k kVar, boolean z10) {
        dc.j jVar;
        if (z10) {
            jVar = new dc.j();
        } else {
            j.c(kVar);
            jVar = kVar.b();
        }
        List list = this.f12882a;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                jVar.Q0(38);
            }
            jVar.X0((String) list.get(i10));
            jVar.Q0(61);
            jVar.X0((String) this.f12883b.get(i10));
        }
        if (!z10) {
            return 0;
        }
        long j10 = jVar.f4787i;
        jVar.c();
        return j10;
    }

    public final long contentLength() {
        return a((k) null, true);
    }

    public final x0 contentType() {
        return f12881c;
    }

    public final void writeTo(k kVar) {
        j.f("sink", kVar);
        a(kVar, false);
    }
}
