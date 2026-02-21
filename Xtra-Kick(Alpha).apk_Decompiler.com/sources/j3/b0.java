package j3;

import la.v;
import wa.l;
import xa.j;
import xa.k;
import xa.q;

public final class b0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q f8490h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ q f8491i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k0 f8492j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8493k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ma.l f8494l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(q qVar, q qVar2, k0 k0Var, boolean z10, ma.l lVar) {
        super(1);
        this.f8490h = qVar;
        this.f8491i = qVar2;
        this.f8492j = k0Var;
        this.f8493k = z10;
        this.f8494l = lVar;
    }

    public final Object invoke(Object obj) {
        r rVar = (r) obj;
        j.f("entry", rVar);
        this.f8490h.f16814h = true;
        this.f8491i.f16814h = true;
        this.f8492j.o(rVar, this.f8493k, this.f8494l);
        return v.f9814a;
    }
}
