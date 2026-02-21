package e7;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import b7.i;
import com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i7.c;
import kb.e1;
import l6.x;
import la.e;
import xa.j;
import xa.v;

public final class g extends a implements i {

    /* renamed from: s0  reason: collision with root package name */
    public static final /* synthetic */ int f5307s0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public j3 f5308p0;

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f5309q0;

    /* renamed from: r0  reason: collision with root package name */
    public c f5310r0;

    public g() {
        e t10 = h.t(new z1(27, this), 19);
        this.f5309q0 = h0.K(this, v.a(StreamSearchViewModel.class), new m(t10, 19), new n(t10, 19), new o(this, t10, 19));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        j3 e10 = j3.e(layoutInflater, viewGroup);
        this.f5308p0 = e10;
        ConstraintLayout constraintLayout = (ConstraintLayout) e10.f894a;
        j.e("binding.root", constraintLayout);
        return constraintLayout;
    }

    public final void Q() {
        super.Q();
        this.f5308p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        j.f("view", view);
        if (j.a(h0.l1(f0()).getString("compactStreamsV2", "disabled"), "all")) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        this.f5310r0 = new c(this, i10);
        j3 j3Var = this.f5308p0;
        j.c(j3Var);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) j3Var.f897d;
        j.e("binding.recyclerView", gridRecyclerView);
        c cVar = this.f5310r0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void k(String str) {
        j.f("query", str);
        e1 e1Var = ((StreamSearchViewModel) this.f5309q0.getValue()).f3482d;
        if (!j.a(e1Var.getValue(), str)) {
            e1Var.k(str);
        }
    }

    public final void m0() {
        j3 j3Var = this.f5308p0;
        j.c(j3Var);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new d(this, (pa.e) null), 3);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new f(j3Var, this, (pa.e) null), 3);
        u().Z(this, new b(0, (Object) this));
    }

    public final void o0() {
        c cVar = this.f5310r0;
        if (cVar != null) {
            cVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }
}
