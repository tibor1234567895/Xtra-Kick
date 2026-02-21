package com.github.andreyasadchy.xtra.ui.search.tags;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c0;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import e7.b;
import f7.a;
import f7.f;
import f7.k;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import j3.j;
import k6.c;
import kb.e1;
import l6.x;
import la.e;
import xa.v;

public final class TagSearchFragment extends a {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f3484t0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public j3 f3485p0;

    /* renamed from: q0  reason: collision with root package name */
    public final j f3486q0 = new j(v.a(k.class), new z1(28, this));

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f3487r0;

    /* renamed from: s0  reason: collision with root package name */
    public c f3488s0;

    public TagSearchFragment() {
        e t10 = h.t(new z1(29, this), 20);
        this.f3487r0 = h0.K(this, v.a(TagSearchViewModel.class), new m(t10, 20), new n(t10, 20), new o(this, t10, 20));
    }

    public static final void s0(TagSearchFragment tagSearchFragment, String str) {
        xa.j.f("query", str);
        e1 e1Var = ((TagSearchViewModel) tagSearchFragment.f3487r0.getValue()).f3490e;
        if (!xa.j.a(e1Var.getValue(), str)) {
            e1Var.k(str);
        }
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_search_tags, viewGroup, false);
        int i10 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) e4.a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            View a10 = e4.a.a(inflate, R.id.recyclerViewLayout);
            if (a10 != null) {
                j3 b10 = j3.b(a10);
                SearchView searchView = (SearchView) e4.a.a(inflate, R.id.search);
                if (searchView != null) {
                    Toolbar toolbar = (Toolbar) e4.a.a(inflate, R.id.toolbar);
                    if (toolbar != null) {
                        this.f3485p0 = new j3(coordinatorLayout, appBarLayout, coordinatorLayout, b10, searchView, toolbar);
                        xa.j.e("binding.root", coordinatorLayout);
                        return coordinatorLayout;
                    }
                    i10 = R.id.toolbar;
                } else {
                    i10 = R.id.search;
                }
            } else {
                i10 = R.id.recyclerViewLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f3485p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        xa.j.f("view", view);
        this.f3488s0 = new c((c0) this, (k) this.f3486q0.getValue());
        j3 j3Var = this.f3485p0;
        xa.j.c(j3Var);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) ((j3) j3Var.f897d).f897d;
        xa.j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar = this.f3488s0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
            MainActivity mainActivity = (MainActivity) d0();
            j3 j3Var2 = this.f3485p0;
            xa.j.c(j3Var2);
            Toolbar toolbar = (Toolbar) j3Var2.f899f;
            g6.a.f6840a.getClass();
            toolbar.setNavigationIcon(g6.a.a(mainActivity));
            toolbar.setNavigationOnClickListener(new h6.c(mainActivity, 4));
            SearchView searchView = (SearchView) j3Var2.f898e;
            xa.j.e("search", searchView);
            h0.F1(searchView);
            return;
        }
        xa.j.l("pagingAdapter");
        throw null;
    }

    public final void m0() {
        j3 j3Var = this.f3485p0;
        xa.j.c(j3Var);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new f(this, (pa.e) null), 3);
        h0.b1(h0.v0(C()), (pa.h) null, 0, new f7.h((j3) j3Var.f897d, this, (pa.e) null), 3);
        u().Z(this, new b(1, (Object) this));
        j3 j3Var2 = this.f3485p0;
        xa.j.c(j3Var2);
        ((SearchView) j3Var2.f898e).setOnQueryTextListener(new b7.c(this, 1));
    }

    public final void o0() {
        c cVar = this.f3488s0;
        if (cVar != null) {
            cVar.c();
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }
}
