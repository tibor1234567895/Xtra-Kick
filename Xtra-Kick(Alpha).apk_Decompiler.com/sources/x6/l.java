package x6;

import android.util.Log;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.List;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class l extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16701i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerViewModel f16702j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f16703k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(VideoPlayerViewModel videoPlayerViewModel, String str, e eVar) {
        super(2, eVar);
        this.f16702j = videoPlayerViewModel;
        this.f16703k = str;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f16702j, this.f16703k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16701i;
        VideoPlayerViewModel videoPlayerViewModel = this.f16702j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = videoPlayerViewModel.f14603d;
            this.f16701i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new e6.v((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("NOP", "error: ", e10);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        videoPlayerViewModel.f3451r.j((List) obj);
        return v.f9814a;
    }
}
