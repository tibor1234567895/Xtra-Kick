package x6;

import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public o0 f16693i;

    /* renamed from: j  reason: collision with root package name */
    public int f16694j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerViewModel f16695k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f16696l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(VideoPlayerViewModel videoPlayerViewModel, String str, e eVar) {
        super(2, eVar);
        this.f16695k = videoPlayerViewModel;
        this.f16696l = str;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f16695k, this.f16696l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        o0 o0Var;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16694j;
        if (i10 == 0) {
            h0.O1(obj);
            VideoPlayerViewModel videoPlayerViewModel = this.f16695k;
            o0 o0Var2 = videoPlayerViewModel.f3450q;
            this.f16693i = o0Var2;
            this.f16694j = 1;
            obj = videoPlayerViewModel.f3448o.b(this.f16696l, this);
            if (obj == aVar) {
                return aVar;
            }
            o0Var = o0Var2;
        } else if (i10 == 1) {
            o0Var = this.f16693i;
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        o0Var.j(obj);
        return v.f9814a;
    }
}
