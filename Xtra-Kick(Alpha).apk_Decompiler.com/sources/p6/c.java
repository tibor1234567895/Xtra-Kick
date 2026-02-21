package p6;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.follow.games.FollowedGamesViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import l6.c0;
import l6.x;
import la.e;
import xa.j;
import xa.v;
import z5.f;

public final class c extends f implements c0 {

    /* renamed from: p0  reason: collision with root package name */
    public f f12578p0;

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f12579q0;

    /* renamed from: r0  reason: collision with root package name */
    public o6.c f12580r0;

    public c() {
        e t10 = h.t(new z1(11, this), 6);
        this.f12579q0 = h0.K(this, v.a(FollowedGamesViewModel.class), new m(t10, 6), new n(t10, 6), new o(this, t10, 6));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        f a10 = f.a(layoutInflater, viewGroup);
        this.f12578p0 = a10;
        LinearLayout linearLayout = a10.f17637a;
        j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f12578p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f12580r0 = new o6.c(1, this);
        f fVar = this.f12578p0;
        j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        o6.c cVar = this.f12580r0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f12578p0;
        j.c(fVar);
        j3 j3Var = fVar.f17638b;
        j.e("binding.recyclerViewLayout", j3Var);
        o6.c cVar = this.f12580r0;
        if (cVar != null) {
            x.p0(this, j3Var, cVar, ((FollowedGamesViewModel) this.f12579q0.getValue()).f3410e, false, 8);
            return;
        }
        j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f12578p0;
        j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        o6.c cVar = this.f12580r0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }
}
