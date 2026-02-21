package l6;

import hb.h0;
import la.v;
import n3.u3;
import n3.x3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class r extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9660i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9661j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ x3 f9662k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(x3 x3Var, e eVar) {
        super(2, eVar);
        this.f9662k = x3Var;
    }

    public final e create(Object obj, e eVar) {
        r rVar = new r(this.f9662k, eVar);
        rVar.f9661j = obj;
        return rVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((r) create((u3) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9660i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f9660i = 1;
            if (this.f9662k.d((u3) this.f9661j, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
