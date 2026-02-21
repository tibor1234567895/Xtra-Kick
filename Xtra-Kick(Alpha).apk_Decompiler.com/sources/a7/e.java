package a7;

import android.os.Bundle;
import android.support.v4.media.h;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z1;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.recyclerview.widget.n1;
import androidx.recyclerview.widget.o2;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.saved.downloads.DownloadsViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import l6.c0;
import l6.w;
import xa.j;
import xa.v;

public final class e extends j implements c0 {

    /* renamed from: r0  reason: collision with root package name */
    public static final /* synthetic */ int f277r0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public u f278o0;

    /* renamed from: p0  reason: collision with root package name */
    public final x1 f279p0;

    /* renamed from: q0  reason: collision with root package name */
    public d f280q0;

    public e() {
        la.e t10 = h.t(new z1(23, this), 15);
        this.f279p0 = h0.K(this, v.a(DownloadsViewModel.class), new m(t10, 15), new n(t10, 15), new o(this, t10, 15));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        u C = u.C(layoutInflater, viewGroup);
        this.f278o0 = C;
        ConstraintLayout constraintLayout = (ConstraintLayout) C.f428i;
        j.e("binding.root", constraintLayout);
        return constraintLayout;
    }

    public final void Q() {
        super.Q();
        this.f278o0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        u uVar = this.f278o0;
        j.c(uVar);
        d dVar = new d(this, new u1(this, 19, (MainActivity) d0()));
        this.f280q0 = dVar;
        dVar.registerAdapterDataObserver(new w(this, 2, uVar));
        GridRecyclerView gridRecyclerView = (GridRecyclerView) uVar.f430k;
        d dVar2 = this.f280q0;
        if (dVar2 != null) {
            gridRecyclerView.setAdapter(dVar2);
            n1 itemAnimator = ((GridRecyclerView) uVar.f430k).getItemAnimator();
            j.d("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator", itemAnimator);
            ((o2) itemAnimator).f2116g = false;
            return;
        }
        j.l("adapter");
        throw null;
    }

    public final boolean l0() {
        return false;
    }

    public final void m0() {
        u uVar = this.f278o0;
        j.c(uVar);
        ((DownloadsViewModel) this.f279p0.getValue()).f3467f.f(C(), new v1(19, new u1(this, 18, uVar)));
    }

    public final void n() {
        u uVar = this.f278o0;
        j.c(uVar);
        ((GridRecyclerView) uVar.f430k).scrollToPosition(0);
    }

    public final void o0() {
    }
}
