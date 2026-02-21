package t9;

import android.support.v4.media.i;
import la.v;
import p9.l;
import q9.e;
import wa.a;
import xa.j;
import xa.k;

public final class f extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f14848h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f14849i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f14850j = false;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f14851k = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(m mVar, p9.a aVar) {
        super(0);
        this.f14848h = mVar;
        this.f14849i = aVar;
    }

    public final Object b() {
        a aVar = this.f14848h.f14883j;
        l lVar = this.f14849i;
        boolean z10 = this.f14850j;
        boolean z11 = this.f14851k;
        aVar.getClass();
        j.g("listener", lVar);
        synchronized (aVar.f14830i) {
            aVar.f14830i.add(lVar);
        }
        aVar.f14838q.a(aVar.f14829h, lVar);
        if (z10) {
            for (e iVar : aVar.f14833l.get()) {
                aVar.f14839r.post(new i(iVar, aVar, lVar));
            }
        }
        y9.l lVar2 = aVar.f14836o;
        lVar2.a("Added listener " + lVar);
        if (z11) {
            aVar.W();
        }
        return v.f9814a;
    }
}
