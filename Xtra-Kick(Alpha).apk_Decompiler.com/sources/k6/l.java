package k6;

import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import e6.c2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class l extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9235i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ClipsViewModel f9236j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f9237k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ClipsViewModel clipsViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f9236j = clipsViewModel;
        this.f9237k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f9236j, this.f9237k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9235i;
        if (i10 == 0) {
            h0.O1(obj);
            c2 c2Var = this.f9236j.f3370d;
            String valueOf = String.valueOf(this.f9237k);
            this.f9235i = 1;
            obj = c2Var.a(valueOf, this);
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
