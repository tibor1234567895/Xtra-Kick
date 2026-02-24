package w6;

import hb.f0;
import hb.h0;
import la.v;
import qa.a;
import ra.i;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16135i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f16136j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, pa.e eVar) {
        super(2, eVar);
        this.f16136j = fVar;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f16136j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16135i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f16135i = 1;
            if (h0.L(1500, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            this.f16136j.T0();
        } catch (Exception unused) {
        }
        return v.f9814a;
    }
}
