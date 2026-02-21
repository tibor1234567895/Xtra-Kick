package n7;

import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
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
    public int f11746i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelVideosViewModel f11747j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f11748k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ChannelVideosViewModel channelVideosViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f11747j = channelVideosViewModel;
        this.f11748k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f11747j, this.f11748k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11746i;
        if (i10 == 0) {
            h0.O1(obj);
            c2 c2Var = this.f11747j.f3515h;
            String valueOf = String.valueOf(this.f11748k);
            this.f11746i = 1;
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
