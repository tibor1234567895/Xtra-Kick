package lb;

import hb.h0;
import jb.r;
import la.v;
import qa.a;
import ra.i;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9829i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9830j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ f f9831k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, pa.e eVar) {
        super(2, eVar);
        this.f9831k = fVar;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        e eVar2 = new e(this.f9831k, eVar);
        eVar2.f9830j = obj;
        return eVar2;
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((r) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9829i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f9829i = 1;
            if (this.f9831k.f((r) this.f9830j, this) == aVar) {
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
