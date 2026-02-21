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

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9230i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ClipsViewModel f9231j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f9232k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ClipsViewModel clipsViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f9231j = clipsViewModel;
        this.f9232k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f9231j, this.f9232k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9230i;
        if (i10 == 0) {
            h0.O1(obj);
            f2 f2Var = this.f9231j.f3371e;
            String valueOf = String.valueOf(this.f9232k);
            this.f9230i = 1;
            obj = f2Var.a(valueOf, this);
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
