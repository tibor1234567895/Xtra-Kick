package n7;

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
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import l.h;
import l6.c0;
import l6.x;
import la.e;
import m7.k;
import xa.j;
import xa.v;
import z5.f;

public final class g extends o implements c0, k {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f11729t0 = 0;

    /* renamed from: q0  reason: collision with root package name */
    public f f11730q0;

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f11731r0;

    /* renamed from: s0  reason: collision with root package name */
    public c f11732s0;

    public g() {
        e a10 = la.f.a(new l(new g7.g(5, this), 25));
        this.f11731r0 = h0.K(this, v.a(ChannelVideosViewModel.class), new m(a10, 25), new n(a10, 25), new o(this, a10, 25));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        f c10 = f.c(layoutInflater, viewGroup);
        this.f11730q0 = c10;
        LinearLayout linearLayout = c10.f17637a;
        j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f11730q0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f11732s0 = new c(this, new f(this, 0), new f(this, 1));
        f fVar = this.f11730q0;
        j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar = this.f11732s0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f11730q0;
        j.c(fVar);
        j3 j3Var = fVar.f17638b;
        j.e("binding.recyclerViewLayout", j3Var);
        c cVar = this.f11732s0;
        if (cVar != null) {
            x.p0(this, j3Var, cVar, t0().f3519l, false, 24);
            ChannelVideosViewModel t02 = t0();
            c cVar2 = this.f11732s0;
            if (cVar2 != null) {
                r0(t02, cVar2);
                f fVar2 = this.f11730q0;
                j.c(fVar2);
                h hVar = fVar2.f17639c;
                ConstraintLayout constraintLayout = (ConstraintLayout) hVar.f9447i;
                j.e("sortBar.root", constraintLayout);
                constraintLayout.setVisibility(0);
                ((ConstraintLayout) hVar.f9447i).setOnClickListener(new i(19, this));
                t0().f3516i.f(C(), new v1(22, new d(fVar2, 0)));
                return;
            }
            j.l("pagingAdapter");
            throw null;
        }
        j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f11730q0;
        j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        c cVar = this.f11732s0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void p(VideoSortEnum videoSortEnum, CharSequence charSequence, VideoPeriodEnum videoPeriodEnum, CharSequence charSequence2, BroadcastTypeEnum broadcastTypeEnum, int i10, boolean z10, boolean z11) {
        j.f("sort", videoSortEnum);
        VideoPeriodEnum videoPeriodEnum2 = videoPeriodEnum;
        j.f("period", videoPeriodEnum);
        BroadcastTypeEnum broadcastTypeEnum2 = broadcastTypeEnum;
        j.f("type", broadcastTypeEnum2);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new e(this, videoSortEnum, broadcastTypeEnum2, charSequence, charSequence2, z10, z11, (pa.e) null), 3);
    }

    public final ChannelVideosViewModel t0() {
        return (ChannelVideosViewModel) this.f11731r0.getValue();
    }
}
