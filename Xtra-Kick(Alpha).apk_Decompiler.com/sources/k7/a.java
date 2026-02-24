package k7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j3;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.streams.followed.FollowedStreamsViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import g7.g;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i7.c;
import l6.c0;
import l6.x;
import la.e;
import xa.j;
import xa.v;
import z5.f;

public final class a extends d implements c0 {

    /* renamed from: p0  reason: collision with root package name */
    public f f9245p0;

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f9246q0;

    /* renamed from: r0  reason: collision with root package name */
    public c f9247r0;

    public a() {
        e a10 = la.f.a(new l(new g(4, this), 24));
        this.f9246q0 = h0.K(this, v.a(FollowedStreamsViewModel.class), new m(a10, 24), new n(a10, 24), new o(this, a10, 24));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        f b10 = f.b(layoutInflater, viewGroup);
        this.f9245p0 = b10;
        LinearLayout linearLayout = b10.f17637a;
        j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f9245p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        j.f("view", view);
        if (!j.a(h0.l1(f0()).getString("compactStreamsV2", "disabled"), "disabled")) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        this.f9247r0 = new c(this, i10);
        f fVar = this.f9245p0;
        j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar = this.f9247r0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        f fVar = this.f9245p0;
        j.c(fVar);
        j3 j3Var = fVar.f17638b;
        j.e("binding.recyclerViewLayout", j3Var);
        c cVar = this.f9247r0;
        if (cVar != null) {
            x.p0(this, j3Var, cVar, ((FollowedStreamsViewModel) this.f9246q0.getValue()).f3512f, false, 8);
            return;
        }
        j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        f fVar = this.f9245p0;
        j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        c cVar = this.f9247r0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }
}
