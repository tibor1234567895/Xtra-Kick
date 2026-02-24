package com.github.andreyasadchy.xtra.ui.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j3;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import h6.d;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import kb.m0;
import l6.c0;
import l6.x;
import la.e;
import o6.c;
import q6.a0;
import q6.r;
import q6.t;
import xa.v;
import z5.j;

public final class GamesFragment extends a0 implements c0 {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f3425t0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public j f3426p0;

    /* renamed from: q0  reason: collision with root package name */
    public final j3.j f3427q0 = new j3.j(v.a(t.class), new z1(16, this));

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f3428r0;

    /* renamed from: s0  reason: collision with root package name */
    public c f3429s0;

    public GamesFragment() {
        e t10 = h.t(new z1(17, this), 9);
        this.f3428r0 = h0.K(this, v.a(GamesViewModel.class), new m(t10, 9), new n(t10, 9), new o(this, t10, 9));
    }

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_games, viewGroup, false);
        int i10 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            i10 = R.id.menu;
            ImageView imageView = (ImageView) a.a(inflate, R.id.menu);
            if (imageView != null) {
                i10 = R.id.recyclerViewLayout;
                View a10 = a.a(inflate, R.id.recyclerViewLayout);
                if (a10 != null) {
                    j3 b10 = j3.b(a10);
                    i10 = R.id.search;
                    ImageView imageView2 = (ImageView) a.a(inflate, R.id.search);
                    if (imageView2 != null) {
                        i10 = R.id.sortBar;
                        View a11 = a.a(inflate, R.id.sortBar);
                        if (a11 != null) {
                            l.h j10 = l.h.j(a11);
                            i10 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) a.a(inflate, R.id.toolbar);
                            if (toolbar != null) {
                                j jVar = new j(coordinatorLayout, appBarLayout, coordinatorLayout, imageView, b10, imageView2, j10, toolbar);
                                this.f3426p0 = jVar;
                                CoordinatorLayout a12 = jVar.a();
                                xa.j.e("binding.root", a12);
                                return a12;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f3426p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        xa.j.f("view", view);
        j jVar = this.f3426p0;
        xa.j.c(jVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        ((ImageView) jVar.f17680f).setOnClickListener(new r(this, 0));
        ((ImageView) jVar.f17679e).setOnClickListener(new d(mainActivity, account, this, 10));
        this.f3429s0 = new c(2, this);
        j jVar2 = this.f3426p0;
        xa.j.c(jVar2);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) ((j3) jVar2.f17682h).f897d;
        xa.j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar = this.f3429s0;
        if (cVar != null) {
            x.q0(gridRecyclerView, cVar);
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }

    public final void m0() {
        boolean z10;
        boolean z11;
        j jVar = this.f3426p0;
        xa.j.c(jVar);
        j3 j3Var = (j3) jVar.f17682h;
        xa.j.e("binding.recyclerViewLayout", j3Var);
        c cVar = this.f3429s0;
        if (cVar != null) {
            m0 m0Var = ((GamesViewModel) this.f3428r0.getValue()).f3431e;
            String[] strArr = ((t) this.f3427q0.getValue()).f13391a;
            if (strArr != null) {
                if (strArr.length == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    z10 = false;
                    x.p0(this, j3Var, cVar, m0Var, !z10, 8);
                    j jVar2 = this.f3426p0;
                    xa.j.c(jVar2);
                    l.h hVar = (l.h) jVar2.f17683i;
                    ConstraintLayout constraintLayout = (ConstraintLayout) hVar.f9447i;
                    xa.j.e("sortBar.root", constraintLayout);
                    constraintLayout.setVisibility(0);
                    ((ConstraintLayout) hVar.f9447i).setOnClickListener(new r(this, 1));
                    return;
                }
            }
            z10 = true;
            x.p0(this, j3Var, cVar, m0Var, !z10, 8);
            j jVar22 = this.f3426p0;
            xa.j.c(jVar22);
            l.h hVar2 = (l.h) jVar22.f17683i;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) hVar2.f9447i;
            xa.j.e("sortBar.root", constraintLayout2);
            constraintLayout2.setVisibility(0);
            ((ConstraintLayout) hVar2.f9447i).setOnClickListener(new r(this, 1));
            return;
        }
        xa.j.l("pagingAdapter");
        throw null;
    }

    public final void n() {
        j jVar = this.f3426p0;
        xa.j.c(jVar);
        ((AppBarLayout) jVar.f17677c).d(true, true, true);
        ((GridRecyclerView) ((j3) jVar.f17682h).f897d).scrollToPosition(0);
    }

    public final void o0() {
        c cVar = this.f3429s0;
        if (cVar != null) {
            cVar.c();
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }
}
