package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class r0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5225i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5226j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5227k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f5228l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f5229m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r0(int i10, s0 s0Var, String str, String str2, e eVar) {
        super(2, eVar);
        this.f5226j = s0Var;
        this.f5227k = i10;
        this.f5228l = str;
        this.f5229m = str2;
    }

    public final e create(Object obj, e eVar) {
        return new r0(this.f5227k, this.f5226j, this.f5228l, this.f5229m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((r0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5225i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5226j.f5233a;
            int i11 = this.f5227k;
            String str = this.f5228l;
            String str2 = this.f5229m;
            this.f5225i = 1;
            obj = kickApi.getSubcategoryStreams(i11, str, 30, str2, this);
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
