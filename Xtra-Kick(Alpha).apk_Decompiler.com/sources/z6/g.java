package z6;

import android.content.Context;
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
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import l6.c0;
import l6.w;
import la.e;
import xa.j;
import xa.v;

public final class g extends n implements c0 {

    /* renamed from: r0  reason: collision with root package name */
    public static final /* synthetic */ int f17753r0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public u f17754o0;

    /* renamed from: p0  reason: collision with root package name */
    public final x1 f17755p0;

    /* renamed from: q0  reason: collision with root package name */
    public d f17756q0;

    public g() {
        e t10 = h.t(new z1(22, this), 14);
        this.f17755p0 = h0.K(this, v.a(BookmarksViewModel.class), new m(t10, 14), new n(t10, 14), new o(this, t10, 14));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        u C = u.C(layoutInflater, viewGroup);
        this.f17754o0 = C;
        ConstraintLayout constraintLayout = (ConstraintLayout) C.f428i;
        j.e("binding.root", constraintLayout);
        return constraintLayout;
    }

    public final void Q() {
        super.Q();
        this.f17754o0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        u uVar = this.f17754o0;
        j.c(uVar);
        d dVar = new d(this, new e(this, 2), new e(this, 3), new e(this, 4), new u1(this, 16, (MainActivity) d0()));
        this.f17756q0 = dVar;
        dVar.registerAdapterDataObserver(new w(this, 1, uVar));
        GridRecyclerView gridRecyclerView = (GridRecyclerView) uVar.f430k;
        d dVar2 = this.f17756q0;
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
        u uVar = this.f17754o0;
        j.c(uVar);
        BookmarksViewModel q02 = q0();
        q02.f3460g.f(C(), new v1(18, new u1(this, 15, uVar)));
        if (h0.l1(f0()).getBoolean("player_use_videopositions", true)) {
            BookmarksViewModel q03 = q0();
            q03.f3461h.f(C(), new v1(18, new e(this, 0)));
        }
        if (h0.l1(f0()).getBoolean("ui_bookmark_time_left", true)) {
            BookmarksViewModel q04 = q0();
            q04.f3462i.f(C(), new v1(18, new e(this, 1)));
            BookmarksViewModel q05 = q0();
            if (!q05.f3463j) {
                q05.f3463j = true;
                h0.b1(h0.I0(q05), (pa.h) null, 0, new i(q05, (pa.e) null), 3);
            }
        }
        if (Account.Companion.get(f0()).getId() != 0) {
            BookmarksViewModel q06 = q0();
            Context f02 = f0();
            if (!q06.f3464k) {
                q06.f3464k = true;
                h0.b1(h0.I0(q06), (pa.h) null, 0, new k(q06, f02, (pa.e) null), 3);
            }
        }
    }

    public final void n() {
        u uVar = this.f17754o0;
        j.c(uVar);
        ((GridRecyclerView) uVar.f430k).scrollToPosition(0);
    }

    public final void o0() {
    }

    public final BookmarksViewModel q0() {
        return (BookmarksViewModel) this.f17755p0.getValue();
    }
}
