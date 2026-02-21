package n7;

import android.content.Context;
import android.content.SharedPreferences;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import n3.u3;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;
import z5.f;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11719i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f11720j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f11721k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f11722l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CharSequence f11723m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ CharSequence f11724n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f11725o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f11726p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(g gVar, VideoSortEnum videoSortEnum, BroadcastTypeEnum broadcastTypeEnum, CharSequence charSequence, CharSequence charSequence2, boolean z10, boolean z11, pa.e eVar) {
        super(2, eVar);
        this.f11720j = gVar;
        this.f11721k = videoSortEnum;
        this.f11722l = broadcastTypeEnum;
        this.f11723m = charSequence;
        this.f11724n = charSequence2;
        this.f11725o = z10;
        this.f11726p = z11;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f11720j, this.f11721k, this.f11722l, this.f11723m, this.f11724n, this.f11725o, this.f11726p, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11719i;
        g gVar = this.f11720j;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = gVar.f11730q0;
            j.c(fVar);
            FloatingActionButton floatingActionButton = (FloatingActionButton) fVar.f17638b.f898e;
            j.e("binding.recyclerViewLayout.scrollTop", floatingActionButton);
            h0.J0(floatingActionButton);
            c cVar = gVar.f11732s0;
            if (cVar != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f11719i = 1;
                if (cVar.d(u3Var, this) == aVar) {
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
        int i11 = g.f11729t0;
        ChannelVideosViewModel t02 = gVar.t0();
        String A = gVar.A(R.string.sort_and_period, this.f11723m, this.f11724n);
        j.e("getString(R.string.sort_…od, sortText, periodText)", A);
        boolean z10 = this.f11725o;
        boolean z11 = this.f11726p;
        VideoSortEnum videoSortEnum = this.f11721k;
        j.f("sort", videoSortEnum);
        BroadcastTypeEnum broadcastTypeEnum = this.f11722l;
        j.f("type", broadcastTypeEnum);
        e1 e1Var = t02.f3518k;
        Boolean valueOf = Boolean.valueOf(z10);
        VideoPeriodEnum videoPeriodEnum = ((i) e1Var.getValue()).f11735c;
        j.f("period", videoPeriodEnum);
        e1Var.k(new i(valueOf, videoSortEnum, videoPeriodEnum, broadcastTypeEnum));
        t02.f3516i.l(A);
        h0.b1(h0.I0(t02), (h) null, 0, new j(t02, z10, z11, videoSortEnum, broadcastTypeEnum, (pa.e) null), 3);
        XtraApp.f3319k.getClass();
        Context applicationContext = y5.v.a().getApplicationContext();
        j.e("appContext", applicationContext);
        if (z11 != h0.l1(applicationContext).getBoolean("sort_default_channel_videos", false)) {
            SharedPreferences.Editor edit = h0.l1(applicationContext).edit();
            j.e("editor", edit);
            edit.putBoolean("sort_default_channel_videos", z11);
            edit.apply();
        }
        return v.f9814a;
    }
}
