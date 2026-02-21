package e6;

import a6.r;
import a6.s;
import com.github.andreyasadchy.xtra.model.offline.Request;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5118i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ o1 f5119j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Request f5120k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f1(o1 o1Var, Request request, e eVar) {
        super(2, eVar);
        this.f5119j = o1Var;
        this.f5120k = request;
    }

    public final e create(Object obj, e eVar) {
        return new f1(this.f5119j, this.f5120k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5118i;
        if (i10 == 0) {
            h0.O1(obj);
            a6.p pVar = this.f5119j.f5208b;
            this.f5118i = 1;
            s sVar = (s) pVar;
            sVar.getClass();
            if (r3.i.a(sVar.f258a, new r(sVar, this.f5120k, 1), this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
