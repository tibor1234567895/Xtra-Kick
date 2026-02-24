package e6;

import a6.d0;
import a6.e0;
import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class g2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j2 f5132i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VodBookmarkIgnoredUser f5133j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g2(j2 j2Var, VodBookmarkIgnoredUser vodBookmarkIgnoredUser, e eVar) {
        super(2, eVar);
        this.f5132i = j2Var;
        this.f5133j = vodBookmarkIgnoredUser;
    }

    public final e create(Object obj, e eVar) {
        return new g2(this.f5132i, this.f5133j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        d0 d0Var = this.f5132i.f5167a;
        VodBookmarkIgnoredUser vodBookmarkIgnoredUser = this.f5133j;
        e0 e0Var = (e0) d0Var;
        n0 n0Var = e0Var.f231a;
        n0Var.b();
        n0Var.c();
        try {
            e0Var.f233c.i(vodBookmarkIgnoredUser);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
