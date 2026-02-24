package p7;

import android.content.Context;
import android.content.SharedPreferences;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import m7.h;
import n3.u3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;
import z5.f;

public final class b extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12588i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c f12589j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f12590k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VideoPeriodEnum f12591l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f12592m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f12593n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12594o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12595p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f12596q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f12597r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum, int i10, CharSequence charSequence, CharSequence charSequence2, boolean z10, boolean z11, e eVar) {
        super(2, eVar);
        this.f12589j = cVar;
        this.f12590k = videoSortEnum;
        this.f12591l = videoPeriodEnum;
        this.f12592m = broadcastTypeEnum;
        this.f12593n = i10;
        this.f12594o = charSequence;
        this.f12595p = charSequence2;
        this.f12596q = z10;
        this.f12597r = z11;
    }

    public final e create(Object obj, e eVar) {
        return new b(this.f12589j, this.f12590k, this.f12591l, this.f12592m, this.f12593n, this.f12594o, this.f12595p, this.f12596q, this.f12597r, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12588i;
        c cVar = this.f12589j;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = cVar.f12599q0;
            j.c(fVar);
            FloatingActionButton floatingActionButton = (FloatingActionButton) fVar.f17638b.f898e;
            j.e("binding.recyclerViewLayout.scrollTop", floatingActionButton);
            h0.J0(floatingActionButton);
            h hVar = cVar.f12601s0;
            if (hVar != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f12588i = 1;
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
        int i11 = c.f12598t0;
        GameVideosViewModel t02 = cVar.t0();
        Context f02 = cVar.f0();
        int i12 = this.f12593n;
        String A = cVar.A(R.string.sort_and_period, this.f12594o, this.f12595p);
        j.e("getString(R.string.sort_…od, sortText, periodText)", A);
        boolean z10 = this.f12596q;
        boolean z11 = this.f12597r;
        VideoSortEnum videoSortEnum = this.f12590k;
        j.f("sort", videoSortEnum);
        VideoPeriodEnum videoPeriodEnum = this.f12591l;
        j.f("period", videoPeriodEnum);
        BroadcastTypeEnum broadcastTypeEnum = this.f12592m;
        j.f("type", broadcastTypeEnum);
        e1 e1Var = t02.f3527k;
        Boolean valueOf = Boolean.valueOf(z10);
        ((e) e1Var.getValue()).getClass();
        e eVar = r8;
        BroadcastTypeEnum broadcastTypeEnum2 = broadcastTypeEnum;
        VideoSortEnum videoSortEnum2 = videoSortEnum;
        e eVar2 = new e(valueOf, videoSortEnum, videoPeriodEnum, broadcastTypeEnum2, i12);
        e1Var.k(eVar);
        t02.f3525i.l(A);
        f0 I0 = h0.I0(t02);
        f fVar2 = r6;
        f fVar3 = new f(t02, z10, z11, videoSortEnum2, f02, videoPeriodEnum, broadcastTypeEnum2, i12, (e) null);
        h0.b1(I0, (pa.h) null, 0, fVar2, 3);
        if (z11 != h0.l1(f02).getBoolean("sort_default_game_videos", false)) {
            SharedPreferences.Editor edit = h0.l1(f02).edit();
            j.e("editor", edit);
            edit.putBoolean("sort_default_game_videos", z11);
            edit.apply();
        }
        return v.f9814a;
    }
}
