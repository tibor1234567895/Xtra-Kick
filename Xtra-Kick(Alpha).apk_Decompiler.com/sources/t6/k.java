package t6;

import androidx.lifecycle.c1;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class k extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14616i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f14617j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, e eVar) {
        super(2, eVar);
        this.f14617j = lVar;
    }

    public final e create(Object obj, e eVar) {
        return new k(this.f14617j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14616i;
        if (i10 == 0) {
            h0.O1(obj);
            s sVar = s.STARTED;
            l lVar = this.f14617j;
            j jVar = new j(lVar, (e) null);
            this.f14616i = 1;
            t o10 = lVar.o();
            if (o10.b() == s.DESTROYED || (obj2 = h0.H(new c1(o10, sVar, jVar, (e) null), this)) != aVar) {
                obj2 = v.f9814a;
            }
            if (obj2 != aVar) {
                obj2 = v.f9814a;
            }
            if (obj2 == aVar) {
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
