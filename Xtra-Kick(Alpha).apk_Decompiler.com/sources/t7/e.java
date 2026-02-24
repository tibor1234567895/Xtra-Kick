package t7;

import e6.g0;
import e6.s0;
import hb.f0;
import hb.h0;
import hb.p0;
import j9.s;
import j9.u;
import j9.x;
import l9.o;
import la.v;
import qa.a;
import ra.i;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14685i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f14686j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(k kVar, pa.e eVar) {
        super(2, eVar);
        this.f14686j = kVar;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f14686j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        s sVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14685i;
        k kVar = this.f14686j;
        if (i10 == 0) {
            h0.O1(obj);
            s0 s0Var = kVar.f14706e;
            this.f14685i = 1;
            s0Var.getClass();
            obj = h0.c2(p0.f7834b, new g0(s0Var, kVar.f14702a, (pa.e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int intValue = ((Number) obj).intValue();
        j9.v vVar = new j9.v();
        x xVar = new x((Object) "");
        o oVar = vVar.f8878h;
        oVar.put("auth", xVar);
        String str = "chatrooms." + intValue + ".v2";
        if (str == null) {
            sVar = u.f8877h;
        } else {
            sVar = new x((Object) str);
        }
        if (sVar == null) {
            sVar = u.f8877h;
        }
        oVar.put("channel", sVar);
        v vVar2 = v.f9814a;
        kVar.c(4, vVar);
        return v.f9814a;
    }
}
