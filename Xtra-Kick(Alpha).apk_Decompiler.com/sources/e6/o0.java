package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class o0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5202i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5203j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5204k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5205l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f5206m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(int i10, s0 s0Var, String str, String str2, e eVar) {
        super(2, eVar);
        this.f5203j = s0Var;
        this.f5204k = str;
        this.f5205l = i10;
        this.f5206m = str2;
    }

    public final e create(Object obj, e eVar) {
        return new o0(this.f5205l, this.f5203j, this.f5204k, this.f5206m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((o0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5202i;
        if (i10 == 0) {
            h0.O1(obj);
            KickApi kickApi = this.f5203j.f5233a;
            String str = this.f5204k;
            int i11 = this.f5205l;
            String str2 = this.f5206m;
            this.f5202i = 1;
            obj = kickApi.getClips(str, i11, 30, "like", str2, this);
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
