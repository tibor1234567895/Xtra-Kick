package p7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import g7.g;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import l6.c0;
import l6.x;
import la.e;
import m7.h;
import m7.k;
import n7.d;
import xa.j;
import xa.v;
import z5.f;

public final class c extends j implements c0, k {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f12598t0 = 0;

    /* renamed from: q0  reason: collision with root package name */
    public f f12599q0;

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f12600r0;

    /* renamed from: s0  reason: collision with root package name */
    public h f12601s0;

    public c() {
        e a10 = la.f.a(new l(new g(7, this), 27));
        this.f12600r0 = h0.K(this, v.a(GameVideosViewModel.class), new m(a10, 27), new n(a10, 27), new o(this, a10, 27));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        f c10 = f.c(layoutInflater, viewGroup);
        this.f12599q0 = c10;
        LinearLayout linearLayout = c10.f17637a;
        j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f12599q0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f12601s0 = new h(this, new a(this, 2), new a(this, 3), true);
        f fVar = this.f12599q0;
        j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        h hVar = this.f12601s0;
        if (hVar != null) {
            x.q0(gridRecyclerView, hVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f12599q0;
        j.c(fVar);
        j3 j3Var = fVar.f17638b;
        j.e("binding.recyclerViewLayout", j3Var);
        h hVar = this.f12601s0;
        if (hVar != null) {
            x.p0(this, j3Var, hVar, t0().f3528l, false, 24);
            GameVideosViewModel t02 = t0();
            h hVar2 = this.f12601s0;
            if (hVar2 != null) {
                r0(t02, hVar2);
                if (h0.l1(f0()).getBoolean("player_use_videopositions", true)) {
                    GameVideosViewModel t03 = t0();
                    t03.f10690f.f(C(), new v1(24, new a(this, 0)));
                }
                GameVideosViewModel t04 = t0();
                t04.f10691g.f(C(), new v1(24, new a(this, 1)));
                f fVar2 = this.f12599q0;
                j.c(fVar2);
                l.h hVar3 = fVar2.f17639c;
                ConstraintLayout constraintLayout = (ConstraintLayout) hVar3.f9447i;
                j.e("sortBar.root", constraintLayout);
                constraintLayout.setVisibility(0);
                ((ConstraintLayout) hVar3.f9447i).setOnClickListener(new i(21, this));
                t0().f3525i.f(C(), new v1(24, new d(fVar2, 2)));
                return;
            }
            j.l("pagingAdapter");
            throw null;
        }
        j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f12599q0;
        j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        h hVar = this.f12601s0;
        if (hVar != null) {
            hVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void p(VideoSortEnum videoSortEnum, CharSequence charSequence, VideoPeriodEnum videoPeriodEnum, CharSequence charSequence2, BroadcastTypeEnum broadcastTypeEnum, int i10, boolean z10, boolean z11) {
        j.f("sort", videoSortEnum);
        VideoPeriodEnum videoPeriodEnum2 = videoPeriodEnum;
        j.f("period", videoPeriodEnum2);
        BroadcastTypeEnum broadcastTypeEnum2 = broadcastTypeEnum;
        j.f("type", broadcastTypeEnum2);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new b(this, videoSortEnum, videoPeriodEnum2, broadcastTypeEnum2, i10, charSequence, charSequence2, z10, z11, (pa.e) null), 3);
    }

    public final GameVideosViewModel t0() {
        return (GameVideosViewModel) this.f12600r0.getValue();
    }
}
