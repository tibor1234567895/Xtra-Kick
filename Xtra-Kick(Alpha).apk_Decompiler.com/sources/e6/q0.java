package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class q0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5220i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5221j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5222k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(s0 s0Var, int i10, e eVar) {
        super(2, eVar);
        this.f5221j = s0Var;
        this.f5222k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new q0(this.f5221j, this.f5222k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((q0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5220i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5221j.f5233a;
            this.f5220i = 1;
            obj = kickApi.getSubcategories(this.f5222k, 30, this);
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
