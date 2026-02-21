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

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12619i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GameVideosViewModel f12620j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12621k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(GameVideosViewModel gameVideosViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f12620j = gameVideosViewModel;
        this.f12621k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f12620j, this.f12621k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12619i;
        if (i10 == 0) {
            h0.O1(obj);
            f2 f2Var = this.f12620j.f3524h;
            String valueOf = String.valueOf(this.f12621k);
            this.f12619i = 1;
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
