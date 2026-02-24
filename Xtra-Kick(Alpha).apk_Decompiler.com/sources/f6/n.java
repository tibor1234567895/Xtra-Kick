package f6;

import e6.h;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class n extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5869i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ p f5870j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5871k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(p pVar, String str, e eVar) {
        super(2, eVar);
        this.f5870j = pVar;
        this.f5871k = str;
    }

    public final e create(Object obj, e eVar) {
        return new n(this.f5870j, this.f5871k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5869i;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = this.f5870j.f5879c;
            this.f5869i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new h(xVar, this.f5871k, (e) null), this);
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
