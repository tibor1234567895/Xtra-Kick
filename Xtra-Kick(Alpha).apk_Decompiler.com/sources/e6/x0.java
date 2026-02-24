package e6;

import a6.g;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class x0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f5267i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LocalFollowChannel f5268j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x0(y0 y0Var, LocalFollowChannel localFollowChannel, e eVar) {
        super(2, eVar);
        this.f5267i = y0Var;
        this.f5268j = localFollowChannel;
    }

    public final e create(Object obj, e eVar) {
        return new x0(this.f5267i, this.f5268j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((x0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        g gVar = this.f5267i.f5273a;
        LocalFollowChannel localFollowChannel = this.f5268j;
        a6.i iVar = (a6.i) gVar;
        n0 n0Var = iVar.f239a;
        n0Var.b();
        n0Var.c();
        try {
            iVar.f242d.i(localFollowChannel);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
