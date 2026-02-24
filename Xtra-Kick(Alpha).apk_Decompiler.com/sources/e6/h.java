package e6;

import c6.b;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Livestream;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public x f5134i;

    /* renamed from: j  reason: collision with root package name */
    public int f5135j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5136k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ x f5137l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(x xVar, String str, e eVar) {
        super(2, eVar);
        this.f5136k = str;
        this.f5137l = xVar;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f5137l, this.f5136k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        x xVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5135j;
        boolean z10 = true;
        if (i10 == 0) {
            h0.O1(obj);
            String str = this.f5136k;
            if (str != null) {
                x xVar2 = this.f5137l;
                s0 s0Var = xVar2.f5265a;
                this.f5134i = xVar2;
                this.f5135j = 1;
                obj = s0Var.a(str, this);
                if (obj == aVar) {
                    return aVar;
                }
                xVar = xVar2;
            }
            return null;
        } else if (i10 == 1) {
            xVar = this.f5134i;
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Channel channel = (Channel) obj;
        Livestream livestream = channel.getLivestream();
        if (livestream == null || !livestream.isLive()) {
            z10 = false;
        }
        if (z10) {
            xVar.f5266b.getClass();
            return b.b(channel);
        }
        return null;
    }
}
