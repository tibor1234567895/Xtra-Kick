package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import com.github.andreyasadchy.xtra.model.retrofit.kick.post.PresetType;
import com.github.andreyasadchy.xtra.model.retrofit.kick.post.SearchData;
import com.github.andreyasadchy.xtra.model.retrofit.kick.post.SearchRequest;
import hb.f0;
import hb.h0;
import la.v;
import ma.q;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class l0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5174i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5175j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5176k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l0(s0 s0Var, String str, e eVar) {
        super(2, eVar);
        this.f5175j = s0Var;
        this.f5176k = str;
    }

    public final e create(Object obj, e eVar) {
        return new l0(this.f5175j, this.f5176k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5174i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5175j.f5233a;
            SearchRequest searchRequest = new SearchRequest(q.b(new SearchData(PresetType.CATEGORY, this.f5176k)));
            this.f5174i = 1;
            obj = kickApi.loadSearchResult(searchRequest, this);
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
