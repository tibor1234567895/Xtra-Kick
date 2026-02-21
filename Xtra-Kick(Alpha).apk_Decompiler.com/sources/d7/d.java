package d7;

import androidx.appcompat.widget.j3;
import hb.f0;
import hb.h0;
import la.v;
import o6.c;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f4571i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f4572j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f4573k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(j3 j3Var, f fVar, e eVar) {
        super(2, eVar);
        this.f4572j = fVar;
        this.f4573k = j3Var;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f4573k, this.f4572j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f4571i;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = this.f4572j;
            c cVar = fVar.f4580r0;
            if (cVar != null) {
                c cVar2 = new c(this.f4573k, fVar, (e) null);
                this.f4571i = 1;
                if (h0.B(cVar.f11566c, cVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                j.l("pagingAdapter");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
