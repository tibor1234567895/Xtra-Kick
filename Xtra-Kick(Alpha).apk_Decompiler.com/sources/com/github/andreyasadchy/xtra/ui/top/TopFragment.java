package com.github.andreyasadchy.xtra.ui.top;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.a;
import androidx.fragment.app.c1;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import h6.d;
import i3.i;
import l6.c0;
import l6.p;
import xa.j;
import z5.h;

public final class TopFragment extends p implements c0 {

    /* renamed from: h0  reason: collision with root package name */
    public static final /* synthetic */ int f3513h0 = 0;

    /* renamed from: g0  reason: collision with root package name */
    public h f3514g0;

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        h a10 = h.a(layoutInflater, viewGroup);
        this.f3514g0 = a10;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) a10.f17656b;
        j.e("binding.root", coordinatorLayout);
        return coordinatorLayout;
    }

    public final void Q() {
        this.K = true;
        this.f3514g0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        androidx.fragment.app.c0 c0Var;
        j.f("view", view);
        h hVar = this.f3514g0;
        j.c(hVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        ((ImageView) hVar.f17660f).setOnClickListener(new i(18, this));
        hVar.f17655a.setOnClickListener(new d(mainActivity, account, this, 18));
        if (this.f9656d0 != 0) {
            c0Var = new j7.d();
            c0Var.j0(this.f1357m);
            c1 u10 = u();
            u10.getClass();
            a aVar = new a(u10);
            aVar.e(R.id.fragmentContainer, c0Var, (String) null);
            aVar.g();
            this.f9656d0 = 0;
        } else {
            c0Var = u().D(R.id.fragmentContainer);
        }
        this.f9657e0 = c0Var;
    }

    public final void n() {
        c0 c0Var;
        h hVar = this.f3514g0;
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
