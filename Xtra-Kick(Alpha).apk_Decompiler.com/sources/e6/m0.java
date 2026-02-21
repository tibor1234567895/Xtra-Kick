package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class m0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5183i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5184j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5185k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m0(s0 s0Var, String str, e eVar) {
        super(2, eVar);
        this.f5184j = s0Var;
        this.f5185k = str;
    }

    public final e create(Object obj, e eVar) {
        return new m0(this.f5184j, this.f5185k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((m0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5183i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5184j.f5233a;
            this.f5183i = 1;
            obj = kickApi.getVideo(this.f5185k, this);
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
