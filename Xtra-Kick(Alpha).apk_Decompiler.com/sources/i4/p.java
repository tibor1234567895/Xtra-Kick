package i4;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import s4.d;
import s4.j;

public final class p extends i implements wa.p {

    /* renamed from: i  reason: collision with root package name */
    public int f8254i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t f8255j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ s4.i f8256k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(t tVar, s4.i iVar, e eVar) {
        super(2, eVar);
        this.f8255j = tVar;
        this.f8256k = iVar;
    }

    public final e create(Object obj, e eVar) {
        return new p(this.f8255j, this.f8256k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((p) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8254i;
        t tVar = this.f8255j;
        if (i10 == 0) {
            h0.O1(obj);
            this.f8254i = 1;
            obj = t.a(tVar, this.f8256k, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((j) obj) instanceof d) {
            tVar.getClass();
        }
        return obj;
    }
}
