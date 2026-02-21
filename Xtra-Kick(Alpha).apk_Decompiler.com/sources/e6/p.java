package e6;

import c6.b;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;

public final class p extends i implements wa.p {

    /* renamed from: i  reason: collision with root package name */
    public b f5211i;

    /* renamed from: j  reason: collision with root package name */
    public int f5212j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5213k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ x f5214l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(x xVar, String str, e eVar) {
        super(2, eVar);
        this.f5213k = str;
        this.f5214l = xVar;
    }

    public final e create(Object obj, e eVar) {
        return new p(this.f5214l, this.f5213k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((p) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        b bVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5212j;
        if (i10 == 0) {
            h0.O1(obj);
            String str = this.f5213k;
            if (str == null) {
                return null;
            }
            x xVar = this.f5214l;
            b bVar2 = xVar.f5266b;
            this.f5211i = bVar2;
            this.f5212j = 1;
            obj = xVar.f5265a.a(str, this);
            if (obj == aVar) {
                return aVar;
            }
            bVar = bVar2;
        } else if (i10 == 1) {
            bVar = this.f5211i;
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        bVar.getClass();
        return b.b((Channel) obj);
    }
}
