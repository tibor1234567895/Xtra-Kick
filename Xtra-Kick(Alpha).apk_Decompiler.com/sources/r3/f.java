package r3;

import hb.f0;
import hb.h0;
import java.util.concurrent.Callable;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Callable f13677i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Callable callable, e eVar) {
        super(2, eVar);
        this.f13677i = callable;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f13677i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return this.f13677i.call();
    }
}
