package e6;

import a6.j;
import a6.l;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class d1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e1 f5097i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LocalFollowGame f5098j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d1(e1 e1Var, LocalFollowGame localFollowGame, e eVar) {
        super(2, eVar);
        this.f5097i = e1Var;
        this.f5098j = localFollowGame;
    }

    public final e create(Object obj, e eVar) {
        return new d1(this.f5097i, this.f5098j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        j jVar = this.f5097i.f5108a;
        LocalFollowGame localFollowGame = this.f5098j;
        l lVar = (l) jVar;
        n0 n0Var = lVar.f244a;
        n0Var.b();
        n0Var.c();
        try {
            lVar.f247d.i(localFollowGame);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
