package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class p0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5215i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5216j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5217k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p0(s0 s0Var, int i10, e eVar) {
        super(2, eVar);
        this.f5216j = s0Var;
        this.f5217k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new p0(this.f5216j, this.f5217k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((p0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5215i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5216j.f5233a;
            this.f5215i = 1;
            obj = kickApi.getRecentMessages(this.f5217k, this);
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
