package com.github.andreyasadchy.xtra.ui.search;

import android.os.Bundle;
import android.support.v4.media.h;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.i5;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.k;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.viewpager2.adapter.d;
import androidx.viewpager2.widget.ViewPager2;
import b7.a;
import b7.g;
import b7.l;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.woxthebox.draglistview.R;
import h6.m;
import h6.n;
import h6.o;
import h6.r;
import h6.s;
import hb.h0;
import java.util.List;
import l6.c;
import la.e;
import la.i;
import xa.j;
import xa.v;
import y6.b;

public final class SearchPagerFragment extends a implements l, c {

    /* renamed from: s0  reason: collision with root package name */
    public static final /* synthetic */ int f3468s0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public i5 f3469o0;

    /* renamed from: p0  reason: collision with root package name */
    public final x1 f3470p0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f3471q0 = true;

    /* renamed from: r0  reason: collision with root package name */
    public i f3472r0;

    public SearchPagerFragment() {
        e t10 = h.t(new z1(24, this), 16);
        this.f3470p0 = h0.K(this, v.a(SearchPagerViewModel.class), new m(t10, 16), new n(t10, 16), new o(this, t10, 16));
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        this.f3471q0 = bundle == null;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
        int i10 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) e4.a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            ImageView imageView = (ImageView) e4.a.a(inflate, R.id.menu);
            if (imageView != null) {
                View a10 = e4.a.a(inflate, R.id.pagerLayout);
                if (a10 != null) {
                    u l10 = u.l(a10);
                    SearchView searchView = (SearchView) e4.a.a(inflate, R.id.search);
                    if (searchView != null) {
                        Toolbar toolbar = (Toolbar) e4.a.a(inflate, R.id.toolbar);
                        if (toolbar != null) {
                            this.f3469o0 = new i5(coordinatorLayout, appBarLayout, coordinatorLayout, imageView, l10, searchView, toolbar, 6);
                            j.e("binding.root", coordinatorLayout);
                            return coordinatorLayout;
                        }
                        i10 = R.id.toolbar;
                    } else {
                        i10 = R.id.search;
                    }
                } else {
                    i10 = R.id.pagerLayout;
                }
            } else {
                i10 = R.id.menu;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f3469o0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        MainActivity mainActivity = (MainActivity) d0();
        i5 i5Var = this.f3469o0;
        j.c(i5Var);
        u uVar = (u) i5Var.f878f;
        b bVar = new b(1, this);
        ((ViewPager2) uVar.f430k).setAdapter(bVar);
        if (this.f3471q0) {
            ((ViewPager2) uVar.f430k).b(2, false);
            this.f3471q0 = false;
        }
        ((ViewPager2) uVar.f430k).setOffscreenPageLimit(bVar.getItemCount());
        ViewPager2 viewPager2 = (ViewPager2) uVar.f430k;
        j.e("viewPager", viewPager2);
        h0.s1(viewPager2);
        new x8.n((TabLayout) uVar.f429j, (ViewPager2) uVar.f430k, new p0.c(27, this)).a();
        ((List) ((ViewPager2) uVar.f430k).f2315j.f2296b).add(new d(2, this));
        i5 i5Var2 = this.f3469o0;
        j.c(i5Var2);
        ImageView imageView = (ImageView) i5Var2.f877e;
        j.e("menu", imageView);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new i3.i(15, this));
        Toolbar toolbar = (Toolbar) i5Var2.f880h;
        g6.a.f6840a.getClass();
        toolbar.setNavigationIcon(g6.a.a(mainActivity));
        toolbar.setNavigationOnClickListener(new h6.c(mainActivity, 3));
        SearchView searchView = (SearchView) i5Var2.f879g;
        j.e("search", searchView);
        h0.F1(searchView);
    }

    public final void m0() {
        i5 i5Var = this.f3469o0;
        j.c(i5Var);
        ((SearchView) i5Var.f879g).setOnQueryTextListener(new b7.c(this, 0));
    }

    public final void o0() {
    }

    public final c0 q0() {
        c1 u10 = u();
        i5 i5Var = this.f3469o0;
        j.c(i5Var);
        int currentItem = ((ViewPager2) ((u) i5Var.f878f).f430k).getCurrentItem();
        return u10.E("f" + currentItem);
    }

    public final void r0(int i10, int i11, int i12) {
        if (i12 != 0) {
            this.f3472r0 = new i(Integer.valueOf(i11), Integer.valueOf(i12));
            if (i10 == 0) {
                x1 x1Var = this.f3470p0;
                SearchPagerViewModel searchPagerViewModel = (SearchPagerViewModel) x1Var.getValue();
                if (!searchPagerViewModel.f3475f) {
                    searchPagerViewModel.f3475f = true;
                    searchPagerViewModel.f3474e.l((Object) null);
                    h0.b1(h0.I0(searchPagerViewModel), (pa.h) null, 0, new g(searchPagerViewModel, i12, (pa.e) null), 3);
                }
                ((SearchPagerViewModel) x1Var.getValue()).f3474e.f(C(), new v1(20, new k(15, this)));
            } else if (i10 == 2) {
                s0();
            }
        }
    }

    public final void s0() {
        i iVar = this.f3472r0;
        if (iVar != null) {
            Integer num = (Integer) iVar.f9799h;
            if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 1)) {
                h0.V(this).m(r.a(s.f7686a, ((Number) iVar.f9800i).intValue(), (String) null, (String) null, (String) null, false, 0, 62));
            }
        }
    }
}
