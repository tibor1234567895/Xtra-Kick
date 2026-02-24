package e7;

import androidx.appcompat.widget.j3;
import hb.f0;
import hb.h0;
import i7.c;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5304i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f5305j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f5306k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(j3 j3Var, g gVar, e eVar) {
        super(2, eVar);
        this.f5305j = gVar;
        this.f5306k = j3Var;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f5306k, this.f5305j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5304i;
        if (i10 == 0) {
            h0.O1(obj);
            g gVar = this.f5305j;
            c cVar = gVar.f5310r0;
            if (cVar != null) {
                e eVar = new e(this.f5306k, gVar, (e) null);
                this.f5304i = 1;
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
