package g7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.x1;
import b7.i;
import com.github.andreyasadchy.xtra.ui.search.videos.VideoSearchViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import e7.b;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import kb.e1;
import l6.x;
import la.e;
import la.f;
import xa.j;
import xa.v;

public final class h extends a implements i {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f6861t0 = 0;

    /* renamed from: q0  reason: collision with root package name */
    public j3 f6862q0;

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f6863r0;

    /* renamed from: s0  reason: collision with root package name */
    public m7.h f6864s0;

    public h() {
        e a10 = f.a(new l(new g(0, this), 21));
        this.f6863r0 = h0.K(this, v.a(VideoSearchViewModel.class), new m(a10, 21), new n(a10, 21), new o(this, a10, 21));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        j3 e10 = j3.e(layoutInflater, viewGroup);
        this.f6862q0 = e10;
        ConstraintLayout constraintLayout = (ConstraintLayout) e10.f894a;
        j.e("binding.root", constraintLayout);
        return constraintLayout;
    }

    public final void Q() {
        super.Q();
        this.f6862q0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        this.f6864s0 = new m7.h(this, new f(this, 0), new f(this, 1), false);
        j3 j3Var = this.f6862q0;
        j.c(j3Var);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) j3Var.f897d;
        j.e("binding.recyclerView", gridRecyclerView);
        m7.h hVar = this.f6864s0;
        if (hVar != null) {
            x.q0(gridRecyclerView, hVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void k(String str) {
        j.f("query", str);
        e1 e1Var = t0().f3492h;
        if (!j.a(e1Var.getValue(), str)) {
            e1Var.k(str);
        }
    }

    public final void m0() {
        j3 j3Var = this.f6862q0;
        j.c(j3Var);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new c(this, (pa.e) null), 3);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new e(j3Var, this, (pa.e) null), 3);
        u().Z(this, new b(2, (Object) this));
        VideoSearchViewModel t02 = t0();
        m7.h hVar = this.f6864s0;
        if (hVar != null) {
            r0(t02, hVar);
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final void o0() {
        m7.h hVar = this.f6864s0;
        if (hVar != null) {
            hVar.c();
        } else {
            j.l("pagingAdapter");
            throw null;
        }
    }

    public final VideoSearchViewModel t0() {
        return (VideoSearchViewModel) this.f6863r0.getValue();
    }
}
