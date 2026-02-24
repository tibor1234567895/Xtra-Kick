package x6;

import android.util.Log;
import h3.b0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16689i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f16690j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar, e eVar) {
        super(2, eVar);
        this.f16690j = hVar;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f16690j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16689i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f16689i = 1;
            if (h0.L(1500, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            h hVar = this.f16690j;
            d dVar = h.H0;
            b0 s02 = hVar.s0();
            if (s02 != null) {
                s02.e();
            }
        } catch (Exception e10) {
            Log.e("NOP", "error: ", e10);
        }
        return v.f9814a;
    }
}
