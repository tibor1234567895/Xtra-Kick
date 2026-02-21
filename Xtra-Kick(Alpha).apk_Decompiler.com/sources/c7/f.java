package c7;

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

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f2985i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f2986j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f2987k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(j3 j3Var, h hVar, e eVar) {
        super(2, eVar);
        this.f2986j = hVar;
        this.f2987k = j3Var;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f2987k, this.f2986j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2985i;
        if (i10 == 0) {
            h0.O1(obj);
            h hVar = this.f2986j;
            c cVar = hVar.f2994r0;
            if (cVar != null) {
                e eVar = new e(this.f2987k, hVar, (e) null);
                this.f2985i = 1;
                if (h0.B(cVar.f11566c, eVar, this) == aVar) {
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
