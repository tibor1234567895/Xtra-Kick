package t6;

import androidx.fragment.app.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14599i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f0 f14600j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(f0 f0Var, e eVar) {
        super(2, eVar);
        this.f14600j = f0Var;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f14600j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((hb.f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14599i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f14599i = 1;
            if (h0.L(500, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f14600j.setRequestedOrientation(-1);
        return v.f9814a;
    }
}
