package p7;

import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import e6.f2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12617i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GameVideosViewModel f12618j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(GameVideosViewModel gameVideosViewModel, e eVar) {
        super(2, eVar);
        this.f12618j = gameVideosViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f12618j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12617i;
        if (i10 == 0) {
            h0.O1(obj);
            f2 f2Var = this.f12618j.f3524h;
            this.f12617i = 1;
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
