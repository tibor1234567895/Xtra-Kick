package pa;

import wa.p;
import xa.k;

public final class j extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public static final j f12753h = new j();

    public j() {
        super(2);
    }

    public final Object g(Object obj, Object obj2) {
        d dVar;
        k kVar = (k) obj;
        h hVar = (h) obj2;
        xa.j.f("acc", kVar);
        xa.j.f("element", hVar);
        k w10 = kVar.w(hVar.getKey());
        l lVar = l.f12754h;
        if (w10 == lVar) {
            return hVar;
        }
        f fVar = g.f12752g;
        g gVar = (g) w10.N(fVar);
        if (gVar == null) {
            dVar = new d(hVar, w10);
        } else {
            k w11 = w10.w(fVar);
            if (w11 == lVar) {
                return new d(gVar, hVar);
            }
            dVar = new d(gVar, new d(hVar, w11));
        }
        return dVar;
    }
}
