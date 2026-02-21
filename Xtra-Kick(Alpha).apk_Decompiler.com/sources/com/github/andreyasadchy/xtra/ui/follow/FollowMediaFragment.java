package com.github.andreyasadchy.xtra.ui.follow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.widget.v2;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import h6.d;
import hb.h0;
import i3.i;
import l6.c0;
import l6.p;
import xa.j;
import z5.h;

public final class FollowMediaFragment extends p implements c0 {

    /* renamed from: h0  reason: collision with root package name */
    public static final /* synthetic */ int f3397h0 = 0;

    /* renamed from: g0  reason: collision with root package name */
    public h f3398g0;

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        h a10 = h.a(layoutInflater, viewGroup);
        this.f3398g0 = a10;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) a10.f17656b;
        j.e("binding.root", coordinatorLayout);
        return coordinatorLayout;
    }

    public final void Q() {
        this.K = true;
        this.f3398g0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        h hVar = this.f3398g0;
        j.c(hVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        ((ImageView) hVar.f17660f).setOnClickListener(new i(8, this));
        hVar.f17655a.setOnClickListener(new d(mainActivity, account, this, 4));
        View view2 = hVar.f17661g;
        Spinner spinner = (Spinner) view2;
        j.e("spinner", spinner);
        h0.b2(spinner);
        ((Spinner) view2).setAdapter(new ArrayAdapter(mainActivity, 17367049, y().getStringArray(R.array.spinnerFollowedEntriesNotLoggedIn)));
        ((Spinner) view2).setOnItemSelectedListener(new v2(3, this));
    }

    public final void n() {
        c0 c0Var;
        h hVar = this.f3398g0;
        j.c(hVar);
        ((AppBarLayout) hVar.f17657c).d(true, true, true);
        androidx.fragment.app.c0 c0Var2 = this.f9657e0;
        if (c0Var2 instanceof c0) {
            c0Var = (c0) c0Var2;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            c0Var.n();
        }
    }
}
