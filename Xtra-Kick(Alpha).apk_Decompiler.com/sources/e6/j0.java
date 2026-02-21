package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Data;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Livestream;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class j0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5161i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5162j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5163k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(s0 s0Var, String str, e eVar) {
        super(2, eVar);
        this.f5162j = s0Var;
        this.f5163k = str;
    }

    public final e create(Object obj, e eVar) {
        return new j0(this.f5162j, this.f5163k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5161i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5162j.f5233a;
            this.f5161i = 1;
            obj = kickApi.getLivestream(this.f5163k, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Livestream livestream = (Livestream) ((Data) obj).getData();
        if (livestream != null) {
            return livestream.getPlaybackUrl();
        }
        return null;
    }
}
