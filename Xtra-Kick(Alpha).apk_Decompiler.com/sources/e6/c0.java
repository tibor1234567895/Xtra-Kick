package e6;

import a6.b;
import a6.f;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class c0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f5090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Bookmark f5091j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(e0 e0Var, Bookmark bookmark, e eVar) {
        super(2, eVar);
        this.f5090i = e0Var;
        this.f5091j = bookmark;
    }

    public final e create(Object obj, e eVar) {
        return new c0(this.f5090i, this.f5091j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((c0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        b bVar = this.f5090i.f5105a;
        Bookmark bookmark = this.f5091j;
        f fVar = (f) bVar;
        n0 n0Var = fVar.f234a;
        n0Var.b();
        n0Var.c();
        try {
            fVar.f235b.k(bookmark);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
