package kb;

import hb.f0;
import hb.h0;
import la.v;
import lb.s;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class n extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9358i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ i f9359j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(i iVar, e eVar) {
        super(2, eVar);
        this.f9359j = iVar;
    }

    public final e create(Object obj, e eVar) {
        return new n(this.f9359j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9358i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f9358i = 1;
            Object b10 = this.f9359j.b(s.f9861h, this);
            if (b10 != aVar) {
                b10 = v.f9814a;
            }
            if (b10 == aVar) {
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
