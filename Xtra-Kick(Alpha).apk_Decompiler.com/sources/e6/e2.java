package e6;

import a6.w;
import com.github.andreyasadchy.xtra.model.offline.SortGame;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class e2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f2 f5109i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SortGame f5110j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e2(f2 f2Var, SortGame sortGame, e eVar) {
        super(2, eVar);
        this.f5109i = f2Var;
        this.f5110j = sortGame;
    }

    public final e create(Object obj, e eVar) {
        return new e2(this.f5109i, this.f5110j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        a6.v vVar = this.f5109i.f5121a;
        SortGame sortGame = this.f5110j;
        w wVar = (w) vVar;
        n0 n0Var = wVar.f263a;
        n0Var.b();
        n0Var.c();
        try {
            wVar.f264b.k(sortGame);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
