package com.github.andreyasadchy.xtra.ui.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.h;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c1;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.viewpager2.widget.ViewPager2;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import g6.a;
import h6.c;
import h6.d;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import j3.m2;
import l6.c0;
import la.e;
import q6.f;
import q6.k;
import q6.z;
import xa.q;
import xa.v;
import z5.j;

public final class GamePagerFragment extends z implements c0 {

    /* renamed from: s0  reason: collision with root package name */
    public static final /* synthetic */ int f3417s0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public j f3418o0;

    /* renamed from: p0  reason: collision with root package name */
    public final j3.j f3419p0 = new j3.j(v.a(f.class), new z1(14, this));

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f3420q0;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f3421r0;

    public GamePagerFragment() {
        e t10 = h.t(new z1(15, this), 8);
        this.f3420q0 = h0.K(this, v.a(GamePagerViewModel.class), new m(t10, 8), new n(t10, 8), new o(this, t10, 8));
        this.f3421r0 = true;
    }

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        this.f3421r0 = bundle == null;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        j b10 = j.b(layoutInflater, viewGroup);
        this.f3418o0 = b10;
        CoordinatorLayout a10 = b10.a();
        xa.j.e("binding.root", a10);
        return a10;
    }

    public final void Q() {
        super.Q();
        this.f3418o0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        xa.j.f("view", view);
        j jVar = this.f3418o0;
        xa.j.c(jVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        Toolbar toolbar = (Toolbar) jVar.f17681g;
        toolbar.setTitle((CharSequence) q0().f13355c);
        a.f6840a.getClass();
        toolbar.setNavigationIcon(a.a(mainActivity));
        toolbar.setNavigationOnClickListener(new c(mainActivity, 2));
        String string = h0.l1(f0()).getString("ui_follow_button", "0");
        if (string != null) {
            i10 = Integer.parseInt(string);
        } else {
            i10 = 0;
        }
        if (i10 < 2) {
            ImageButton imageButton = (ImageButton) jVar.f17682h;
            xa.j.e("followButton", imageButton);
            imageButton.setVisibility(0);
            s0().f3423e.f(C(), new v1(11, new m2(new q(), this, jVar, 9)));
        }
        ((ImageView) jVar.f17680f).setOnClickListener(new i(12, this));
        ((ImageView) jVar.f17679e).setOnClickListener(new d(mainActivity, account, this, 8));
        j jVar2 = this.f3418o0;
        xa.j.c(jVar2);
        u uVar = (u) jVar2.f17683i;
        ((ViewPager2) uVar.f430k).setAdapter(new q6.d(this));
        if (this.f3421r0) {
            ((ViewPager2) uVar.f430k).b(1, false);
            this.f3421r0 = false;
        }
        ((ViewPager2) uVar.f430k).setOffscreenPageLimit(3);
        ViewPager2 viewPager2 = (ViewPager2) uVar.f430k;
        xa.j.e("viewPager", viewPager2);
        h0.s1(viewPager2);
        new x8.n((TabLayout) uVar.f429j, (ViewPager2) uVar.f430k, new p0.c(25, this)).a();
    }

    public final void m0() {
        GamePagerViewModel s02 = s0();
        int i10 = q0().f13353a;
        if (!s02.f3423e.e()) {
            h0.b1(h0.I0(s02), (pa.h) null, 0, new k(i10, s02, (pa.e) null), 3);
        }
        if (q0().f13358f) {
            s0().e(f0(), q0().f13353a, q0().f13355c, q0().f13354b);
        }
    }

    public final void n() {
        c0 c0Var;
        j jVar = this.f3418o0;
        xa.j.c(jVar);
        ((AppBarLayout) jVar.f17677c).d(true, true, true);
        androidx.fragment.app.c0 r02 = r0();
        if (r02 instanceof c0) {
            c0Var = (c0) r02;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            c0Var.n();
        }
    }

    public final void o0() {
    }

    public final f q0() {
        return (f) this.f3419p0.getValue();
    }

    public final androidx.fragment.app.c0 r0() {
        c1 u10 = u();
        j jVar = this.f3418o0;
        xa.j.c(jVar);
        int currentItem = ((ViewPager2) ((u) jVar.f17683i).f430k).getCurrentItem();
        return u10.E("f" + currentItem);
    }

    public final GamePagerViewModel s0() {
        return (GamePagerViewModel) this.f3420q0.getValue();
    }
}
