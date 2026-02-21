package o7;

import android.content.Context;
import android.content.SharedPreferences;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import m7.h;
import n3.u3;
import pa.e;
import ra.i;
import wa.p;
import xa.j;
import z5.f;

public final class a extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12279i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c f12280j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f12281k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VideoPeriodEnum f12282l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f12283m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12284n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12285o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f12286p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar, VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum, CharSequence charSequence, CharSequence charSequence2, boolean z10, e eVar) {
        super(2, eVar);
        this.f12280j = cVar;
        this.f12281k = videoSortEnum;
        this.f12282l = videoPeriodEnum;
        this.f12283m = broadcastTypeEnum;
        this.f12284n = charSequence;
        this.f12285o = charSequence2;
        this.f12286p = z10;
    }

    public final e create(Object obj, e eVar) {
        return new a(this.f12280j, this.f12281k, this.f12282l, this.f12283m, this.f12284n, this.f12285o, this.f12286p, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        int i10 = this.f12279i;
        c cVar = this.f12280j;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = cVar.f12290q0;
            j.c(fVar);
            FloatingActionButton floatingActionButton = (FloatingActionButton) fVar.f17638b.f898e;
            j.e("binding.recyclerViewLayout.scrollTop", floatingActionButton);
            h0.J0(floatingActionButton);
            h hVar = cVar.f12292s0;
            if (hVar != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f12279i = 1;
                if (hVar.d(u3Var, this) == aVar) {
                    return aVar;
                }
            } else {
                j.l("pagingAdapter");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i11 = c.f12289t0;
        FollowedVideosViewModel t02 = cVar.t0();
        String A = cVar.A(R.string.sort_and_period, this.f12284n, this.f12285o);
        j.e("getString(R.string.sort_…od, sortText, periodText)", A);
        VideoSortEnum videoSortEnum = this.f12281k;
        j.f("sort", videoSortEnum);
        VideoPeriodEnum videoPeriodEnum = this.f12282l;
        j.f("period", videoPeriodEnum);
        BroadcastTypeEnum broadcastTypeEnum = this.f12283m;
        j.f("type", broadcastTypeEnum);
        e1 e1Var = t02.f3522j;
        ((e) e1Var.getValue()).getClass();
        e1Var.k(new e(videoSortEnum, videoPeriodEnum, broadcastTypeEnum));
        t02.f3521i.l(A);
        boolean z10 = this.f12286p;
        if (z10) {
            h0.b1(h0.I0(t02), (pa.h) null, 0, new f(t02, videoSortEnum, broadcastTypeEnum, (e) null), 3);
        }
        XtraApp.f3319k.getClass();
        Context applicationContext = y5.v.a().getApplicationContext();
        j.e("appContext", applicationContext);
        if (z10 != h0.l1(applicationContext).getBoolean("sort_default_followed_videos", false)) {
            SharedPreferences.Editor edit = h0.l1(applicationContext).edit();
            j.e("editor", edit);
            edit.putBoolean("sort_default_followed_videos", z10);
            edit.apply();
        }
        return v.f9814a;
    }
}
