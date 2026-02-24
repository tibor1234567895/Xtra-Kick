package com.github.andreyasadchy.xtra.ui.saved;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c1;
import androidx.viewpager2.widget.ViewPager2;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import fb.v;
import h6.d;
import hb.h0;
import i3.i;
import l6.c0;
import p0.c;
import x8.n;
import y6.a;
import y6.b;
import z5.j;

public final class SavedPagerFragment extends a implements c0 {

    /* renamed from: k0  reason: collision with root package name */
    public static final /* synthetic */ int f3454k0 = 0;

    /* renamed from: i0  reason: collision with root package name */
    public j f3455i0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f3456j0 = true;

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        this.f3456j0 = bundle == null;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        j b10 = j.b(layoutInflater, viewGroup);
        this.f3455i0 = b10;
        CoordinatorLayout a10 = b10.a();
        xa.j.e("binding.root", a10);
        return a10;
    }

    public final void Q() {
        this.K = true;
        this.f3455i0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        Integer d10;
        xa.j.f("view", view);
        j jVar = this.f3455i0;
        xa.j.c(jVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        ((ImageView) jVar.f17680f).setOnClickListener(new i(14, this));
        ((ImageView) jVar.f17679e).setOnClickListener(new d(mainActivity, account, this, 12));
        j jVar2 = this.f3455i0;
        xa.j.c(jVar2);
        u uVar = (u) jVar2.f17683i;
        b bVar = new b(0, this);
        ((ViewPager2) uVar.f430k).setAdapter(bVar);
        if (this.f3456j0) {
            ViewPager2 viewPager2 = (ViewPager2) uVar.f430k;
            String string = h0.l1(f0()).getString("ui_saved_default_page", "0");
            if (string == null || (d10 = v.d(string)) == null) {
                i10 = 0;
            } else {
                i10 = d10.intValue();
            }
            viewPager2.b(i10, false);
            this.f3456j0 = false;
        }
        ((ViewPager2) uVar.f430k).setOffscreenPageLimit(bVar.getItemCount());
        ViewPager2 viewPager22 = (ViewPager2) uVar.f430k;
        xa.j.e("viewPager", viewPager22);
        h0.s1(viewPager22);
        new n((TabLayout) uVar.f429j, (ViewPager2) uVar.f430k, new c(26, this)).a();
    }

    public final void n() {
        c0 c0Var;
        j jVar = this.f3455i0;
        xa.j.c(jVar);
        ((AppBarLayout) jVar.f17677c).d(true, true, true);
        c1 u10 = u();
        j jVar2 = this.f3455i0;
        xa.j.c(jVar2);
        int currentItem = ((ViewPager2) ((u) jVar2.f17683i).f430k).getCurrentItem();
        androidx.fragment.app.c0 E = u10.E("f" + currentItem);
        if (E instanceof c0) {
            c0Var = (c0) E;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            c0Var.n();
        }
    }
}
