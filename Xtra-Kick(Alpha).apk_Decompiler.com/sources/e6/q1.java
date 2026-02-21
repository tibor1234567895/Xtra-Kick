package e6;

import com.github.andreyasadchy.xtra.api.MiscApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class q1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ z1 f5224j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q1(z1 z1Var, e eVar) {
        super(2, eVar);
        this.f5224j = z1Var;
    }

    public final e create(Object obj, e eVar) {
        return new q1(this.f5224j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((q1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5223i;
        if (i10 == 0) {
            h0.O1(obj);
            MiscApi miscApi = this.f5224j.f5283a;
            this.f5223i = 1;
            obj = miscApi.getGlobalStvEmotes(this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
