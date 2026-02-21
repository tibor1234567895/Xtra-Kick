package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class n0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5191i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5192j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5193k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5194l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(s0 s0Var, String str, int i10, e eVar) {
        super(2, eVar);
        this.f5192j = s0Var;
        this.f5193k = str;
        this.f5194l = i10;
    }

    public final e create(Object obj, e eVar) {
        return new n0(this.f5192j, this.f5193k, this.f5194l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5191i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5192j.f5233a;
            String str = this.f5193k;
            int i11 = this.f5194l;
            this.f5191i = 1;
            obj = kickApi.getClipsForChannel(str, i11, 30, "like", "all", this);
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
