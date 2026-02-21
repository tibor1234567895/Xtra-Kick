package s9;

import hb.h0;
import p9.b;
import q9.e;
import wa.a;
import xa.j;
import xa.k;
import y9.d;

public final class f extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14434h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f14435i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(g gVar, int i10) {
        super(0);
        this.f14434h = i10;
        this.f14435i = gVar;
    }

    public final Object b() {
        int i10 = this.f14434h;
        g gVar = this.f14435i;
        switch (i10) {
            case 0:
                d dVar = new d();
                dVar.f17242i = 1;
                dVar.f17241h = ((e) gVar.f14449u).f13433h;
                return dVar;
            default:
                b bVar = gVar.f14449u;
                u9.b bVar2 = gVar.f14438j;
                if (bVar2 != null) {
                    e P = bVar2.f15442b.f15440a.P();
                    h0.T1(bVar, P);
                    return P;
                }
                la.d dVar2 = new la.d();
                j.j(j.class.getName(), dVar2);
                throw dVar2;
        }
    }
}
