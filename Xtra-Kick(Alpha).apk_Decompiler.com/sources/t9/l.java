package t9;

import hb.h0;
import java.util.ArrayList;
import java.util.List;
import la.v;
import ma.b0;
import ma.s;
import ma.z;
import p9.b;
import p9.f;
import q9.e;
import wa.a;
import xa.k;
import z5.i;

public final class l extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14868h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f14869i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List f14870j = null;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f14871k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ i f14872l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ i f14873m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(m mVar, Integer num, int i10) {
        super(0);
        this.f14868h = i10;
        this.f14869i = mVar;
        this.f14871k = num;
        this.f14872l = null;
        this.f14873m = null;
    }

    public final void a() {
        Iterable<b> iterable;
        Iterable<b> iterable2;
        int i10 = this.f14868h;
        i iVar = this.f14873m;
        Integer num = this.f14871k;
        List list = this.f14870j;
        m mVar = this.f14869i;
        switch (i10) {
            case 0:
                if (list != null) {
                    try {
                        a aVar = mVar.f14883j;
                        aVar.getClass();
                        iterable2 = aVar.w(z.q(aVar.f14833l.L0(list)));
                    } catch (Exception e10) {
                        y9.l lVar = mVar.f14884k;
                        lVar.b("Fetch with namespace " + mVar.f14879f + " error", e10);
                        f h02 = h0.h0(e10.getMessage());
                        if (iVar != null) {
                            mVar.f14882i.post(new j(this, 5, h02));
                            return;
                        }
                        return;
                    }
                } else if (num != null) {
                    a aVar2 = mVar.f14883j;
                    iterable2 = aVar2.w(aVar2.f14833l.G(num.intValue()));
                } else {
                    iterable2 = b0.f10801h;
                }
                for (b bVar : iterable2) {
                    y9.l lVar2 = mVar.f14884k;
                    lVar2.a("Paused download " + bVar);
                    ((p9.l) mVar.f14885l.f17667e).k(bVar);
                }
                mVar.f14882i.post(new j(this, 4, iterable2));
                return;
            default:
                if (list != null) {
                    try {
                        a aVar3 = mVar.f14883j;
                        aVar3.getClass();
                        iterable = aVar3.N(list);
                    } catch (Exception e11) {
                        y9.l lVar3 = mVar.f14884k;
                        lVar3.b("Fetch with namespace " + mVar.f14879f + " error", e11);
                        f h03 = h0.h0(e11.getMessage());
                        if (iVar != null) {
                            mVar.f14882i.post(new j(this, 7, h03));
                            return;
                        }
                        return;
                    }
                } else if (num != null) {
                    a aVar4 = mVar.f14883j;
                    List<e> G = aVar4.f14833l.G(num.intValue());
                    ArrayList arrayList = new ArrayList(s.i(G));
                    for (e eVar : G) {
                        arrayList.add(Integer.valueOf(eVar.f13433h));
                    }
                    iterable = aVar4.N(arrayList);
                } else {
                    iterable = b0.f10801h;
                }
                for (b bVar2 : iterable) {
                    y9.l lVar4 = mVar.f14884k;
                    i iVar2 = mVar.f14885l;
                    lVar4.a("Queued download " + bVar2);
                    ((p9.l) iVar2.f17667e).c(bVar2, false);
                    y9.l lVar5 = mVar.f14884k;
                    lVar5.a("Resumed download " + bVar2);
                    ((p9.l) iVar2.f17667e).l(bVar2);
                }
                mVar.f14882i.post(new j(this, 6, iterable));
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object b() {
        switch (this.f14868h) {
            case 0:
                a();
                return v.f9814a;
            default:
                a();
                return v.f9814a;
        }
    }
}
