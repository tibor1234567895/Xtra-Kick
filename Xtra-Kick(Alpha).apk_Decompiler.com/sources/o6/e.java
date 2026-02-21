package o6;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.k;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import l6.c0;
import l6.x;
import xa.j;
import xa.v;
import z5.f;

public final class e extends q implements c0, i {

    /* renamed from: s0  reason: collision with root package name */
    public static final /* synthetic */ int f12249s0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public f f12250p0;

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f12251q0;

    /* renamed from: r0  reason: collision with root package name */
    public c f12252r0;

    public e() {
        la.e t10 = h.t(new z1(10, this), 5);
        this.f12251q0 = h0.K(this, v.a(FollowedChannelsViewModel.class), new m(t10, 5), new n(t10, 5), new o(this, t10, 5));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        f a10 = f.a(layoutInflater, viewGroup);
        this.f12250p0 = a10;
        LinearLayout linearLayout = a10.f17637a;
        j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f12250p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f12252r0 = new c(0, this);
        f fVar = this.f12250p0;
        j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar = this.f12252r0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f12250p0;
        j.c(fVar);
        j3 j3Var = fVar.f17638b;
        j.e("binding.recyclerViewLayout", j3Var);
        c cVar = this.f12252r0;
        if (cVar != null) {
            x.p0(this, j3Var, cVar, s0().f3408j, false, 8);
            f fVar2 = this.f12250p0;
            j.c(fVar2);
            l.h hVar = fVar2.f17639c;
            ConstraintLayout constraintLayout = (ConstraintLayout) hVar.f9447i;
            j.e("sortBar.root", constraintLayout);
            constraintLayout.setVisibility(0);
            ((ConstraintLayout) hVar.f9447i).setOnClickListener(new i(10, this));
            s0().f3406h.f(C(), new v1(9, new k(13, fVar2)));
            return;
        }
        j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f12250p0;
        j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        c cVar = this.f12252r0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final FollowedChannelsViewModel s0() {
        return (FollowedChannelsViewModel) this.f12251q0.getValue();
    }
}
