package k6;

import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import e6.f2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class k extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9233i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ClipsViewModel f9234j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(ClipsViewModel clipsViewModel, e eVar) {
        super(2, eVar);
        this.f9234j = clipsViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new k(this.f9234j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9233i;
        if (i10 == 0) {
            h0.O1(obj);
            f2 f2Var = this.f9234j.f3371e;
            this.f9233i = 1;
            obj = f2Var.a("default", this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
