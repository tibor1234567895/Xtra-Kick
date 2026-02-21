package r3;

import hb.f0;
import hb.h0;
import hb.k;
import java.util.concurrent.Callable;
import la.l;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Callable f13679i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f13680j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Callable callable, k kVar, e eVar) {
        super(2, eVar);
        this.f13679i = callable;
        this.f13680j = kVar;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f13679i, this.f13680j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        k kVar = this.f13680j;
        h0.O1(obj);
        try {
            Object call = this.f13679i.call();
            int i10 = l.f9802h;
            kVar.resumeWith(call);
        } catch (Throwable th) {
            int i11 = l.f9802h;
            kVar.resumeWith(h0.I(th));
        }
        return v.f9814a;
    }
}
