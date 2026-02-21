package x6;

import android.net.Uri;
import android.util.Log;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import e6.z1;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class k extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16697i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerViewModel f16698j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f16699k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f16700l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(VideoPlayerViewModel videoPlayerViewModel, String str, String str2, e eVar) {
        super(2, eVar);
        this.f16698j = videoPlayerViewModel;
        this.f16699k = str;
        this.f16700l = str2;
    }

    public final e create(Object obj, e eVar) {
        return new k(this.f16698j, this.f16699k, this.f16700l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Uri uri;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16697i;
        VideoPlayerViewModel videoPlayerViewModel = this.f16698j;
        if (i10 == 0) {
            h0.O1(obj);
            z1 z1Var = videoPlayerViewModel.f3447n;
            String str = this.f16699k;
            this.f16697i = 1;
            obj = z1Var.b(str, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception e10) {
                Log.e("NOP", "error: ", e10);
                uri = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        uri = (Uri) obj;
        videoPlayerViewModel.f3449p.j(uri);
        return v.f9814a;
    }
}
