package c7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import b7.i;
import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import l6.x;
import la.e;
import o6.c;
import xa.j;
import xa.v;

public final class h extends k implements i {

    /* renamed from: s0  reason: collision with root package name */
    public static final /* synthetic */ int f2991s0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public j3 f2992p0;

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f2993q0;

    /* renamed from: r0  reason: collision with root package name */
    public c f2994r0;

    public h() {
        e t10 = android.support.v4.media.h.t(new z1(25, this), 17);
        this.f2993q0 = h0.K(this, v.a(ChannelSearchViewModel.class), new m(t10, 17), new n(t10, 17), new o(this, t10, 17));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        j3 e10 = j3.e(layoutInflater, viewGroup);
        this.f2992p0 = e10;
        ConstraintLayout constraintLayout = (ConstraintLayout) e10.f894a;
        j.e("binding.root", constraintLayout);
        return constraintLayout;
    }

    public final void Q() {
        super.Q();
        this.f2992p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f2994r0 = new c(3, this);
        j3 j3Var = this.f2992p0;
        j.c(j3Var);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) j3Var.f897d;
        j.e("binding.recyclerView", gridRecyclerView);
        c cVar = this.f2994r0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void k(String str) {
        j.f("query", str);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new g(this, str, (pa.e) null), 3);
    }

    public final void m0() {
        j3 j3Var = this.f2992p0;
        j.c(j3Var);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new d(this, (pa.e) null), 3);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new f(j3Var, this, (pa.e) null), 3);
        u().Z(this, new p0.c(28, this));
    }

    public final void o0() {
        c cVar = this.f2994r0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }
}
