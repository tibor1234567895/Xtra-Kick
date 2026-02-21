package e6;

import a6.t;
import a6.u;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class b2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c2 f5084i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SortChannel f5085j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b2(c2 c2Var, SortChannel sortChannel, e eVar) {
        super(2, eVar);
        this.f5084i = c2Var;
        this.f5085j = sortChannel;
    }

    public final e create(Object obj, e eVar) {
        return new b2(this.f5084i, this.f5085j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        t tVar = this.f5084i.f5094a;
        SortChannel sortChannel = this.f5085j;
        u uVar = (u) tVar;
        n0 n0Var = uVar.f261a;
        n0Var.b();
        n0Var.c();
        try {
            uVar.f262b.k(sortChannel);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
