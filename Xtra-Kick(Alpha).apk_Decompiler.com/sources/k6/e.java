package k6;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.woxthebox.draglistview.R;
import e4.a;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import j3.j;
import l6.c0;
import l6.x;
import m7.k;
import n3.x3;
import xa.v;
import z5.f;

public final class e extends o implements c0, k {

    /* renamed from: u0  reason: collision with root package name */
    public static final /* synthetic */ int f9214u0 = 0;

    /* renamed from: q0  reason: collision with root package name */
    public f f9215q0;

    /* renamed from: r0  reason: collision with root package name */
    public final j f9216r0 = new j(v.a(q6.f.class), new z1(4, this));

    /* renamed from: s0  reason: collision with root package name */
    public final x1 f9217s0;

    /* renamed from: t0  reason: collision with root package name */
    public x3 f9218t0;

    public e() {
        la.e t10 = h.t(new z1(5, this), 2);
        this.f9217s0 = h0.K(this, v.a(ClipsViewModel.class), new m(t10, 2), new n(t10, 2), new o(this, t10, 2));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_clips, viewGroup, false);
        int i10 = R.id.recyclerViewLayout;
        View a10 = a.a(inflate, R.id.recyclerViewLayout);
        if (a10 != null) {
            j3 b10 = j3.b(a10);
            View a11 = a.a(inflate, R.id.sortBar);
            if (a11 != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.f9215q0 = new f(linearLayout, b10, l.h.j(a11), 0);
                xa.j.e("binding.root", linearLayout);
                return linearLayout;
            }
            i10 = R.id.sortBar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f9215q0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        x3 x3Var;
        boolean z10;
        xa.j.f("view", view);
        androidx.fragment.app.k kVar = new androidx.fragment.app.k(9, this);
        j jVar = this.f9216r0;
        if (((q6.f) jVar.getValue()).f13359g == 0 && ((q6.f) jVar.getValue()).f13360h == null) {
            if (((q6.f) jVar.getValue()).f13353a == 0 && ((q6.f) jVar.getValue()).f13354b == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            x3Var = new j6.f(this, kVar, z10);
        } else {
            x3Var = new c((androidx.fragment.app.c0) this, kVar);
        }
        this.f9218t0 = x3Var;
        f fVar = this.f9215q0;
        xa.j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        xa.j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        x3 x3Var2 = this.f9218t0;
        if (x3Var2 != null) {
            x.q0(gridRecyclerView, x3Var2);
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f9215q0;
        xa.j.c(fVar);
        j3 j3Var = fVar.f17638b;
        xa.j.e("binding.recyclerViewLayout", j3Var);
        x3 x3Var = this.f9218t0;
        if (x3Var != null) {
            x.p0(this, j3Var, x3Var, s0().f3376j, false, 24);
            f fVar2 = this.f9215q0;
            xa.j.c(fVar2);
            l.h hVar = fVar2.f17639c;
            ConstraintLayout constraintLayout = (ConstraintLayout) hVar.f9447i;
            xa.j.e("sortBar.root", constraintLayout);
            constraintLayout.setVisibility(0);
            ((ConstraintLayout) hVar.f9447i).setOnClickListener(new i(4, this));
            s0().f3373g.f(C(), new v1(5, new androidx.fragment.app.k(8, fVar2)));
            return;
        }
        xa.j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f9215q0;
        xa.j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        x3 x3Var = this.f9218t0;
        if (x3Var != null) {
            x3Var.c();
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }

    public final void p(VideoSortEnum videoSortEnum, CharSequence charSequence, VideoPeriodEnum videoPeriodEnum, CharSequence charSequence2, BroadcastTypeEnum broadcastTypeEnum, int i10, boolean z10, boolean z11) {
        VideoSortEnum videoSortEnum2 = videoSortEnum;
        xa.j.f("sort", videoSortEnum);
        xa.j.f("period", videoPeriodEnum);
        xa.j.f("type", broadcastTypeEnum);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new d(this, videoPeriodEnum, i10, charSequence, charSequence2, z10, z11, (pa.e) null), 3);
    }

    public final ClipsViewModel s0() {
        return (ClipsViewModel) this.f9217s0.getValue();
    }
}
