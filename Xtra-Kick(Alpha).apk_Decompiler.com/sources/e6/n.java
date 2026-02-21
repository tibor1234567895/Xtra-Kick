package e6;

import c6.b;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class n extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5188i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5189j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5190k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(x xVar, String str, e eVar) {
        super(2, eVar);
        this.f5189j = xVar;
        this.f5190k = str;
    }

    public final e create(Object obj, e eVar) {
        return new n(this.f5189j, this.f5190k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5188i;
        x xVar = this.f5189j;
        if (i10 == 0) {
            h0.O1(obj);
            s0 s0Var = xVar.f5265a;
            this.f5188i = 1;
            obj = s0Var.a(this.f5190k, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        xVar.f5266b.getClass();
        return b.b((Channel) obj);
    }
}
