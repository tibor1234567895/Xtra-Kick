package com.github.andreyasadchy.xtra.ui.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.v2;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.a;
import androidx.fragment.app.c1;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import fb.w;
import h6.c;
import h6.d;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i3.i;
import j3.j;
import j3.m2;
import l6.c0;
import la.e;
import q6.f;
import q6.k;
import q6.y;
import xa.q;
import xa.v;
import z5.h;

public final class GameMediaFragment extends y implements c0 {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f3411t0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public h f3412o0;

    /* renamed from: p0  reason: collision with root package name */
    public final j f3413p0 = new j(v.a(f.class), new z1(12, this));

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f3414q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f3415r0;

    /* renamed from: s0  reason: collision with root package name */
    public androidx.fragment.app.c0 f3416s0;

    public GameMediaFragment() {
        e t10 = android.support.v4.media.h.t(new z1(13, this), 7);
        this.f3414q0 = h0.K(this, v.a(GamePagerViewModel.class), new m(t10, 7), new n(t10, 7), new o(this, t10, 7));
        this.f3415r0 = -1;
    }

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        int i10 = -1;
        if (bundle != null) {
            i10 = bundle.getInt("previousItem", -1);
        }
        this.f3415r0 = i10;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        h a10 = h.a(layoutInflater, viewGroup);
        this.f3412o0 = a10;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) a10.f17656b;
        xa.j.e("binding.root", coordinatorLayout);
        return coordinatorLayout;
    }

    public final void Q() {
        super.Q();
        this.f3412o0 = null;
    }

    public final void W(Bundle bundle) {
        bundle.putInt("previousItem", this.f3415r0);
        super.W(bundle);
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        boolean z10;
        androidx.fragment.app.c0 c0Var;
        xa.j.f("view", view);
        h hVar = this.f3412o0;
        xa.j.c(hVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        String string = h0.l1(f0()).getString("ui_follow_button", "0");
        if (string != null) {
            i10 = Integer.parseInt(string);
        } else {
            i10 = 0;
        }
        if (i10 < 2) {
            ImageButton imageButton = (ImageButton) hVar.f17658d;
            xa.j.e("followButton", imageButton);
            imageButton.setVisibility(0);
            r0().f3423e.f(C(), new v1(10, new m2(new q(), this, hVar, 8)));
        }
        ((ImageView) hVar.f17660f).setOnClickListener(new i(11, this));
        hVar.f17655a.setOnClickListener(new d(mainActivity, account, this, 7));
        if (q0().f13353a == 0) {
            String str = q0().f13354b;
            if (str == null || w.h(str)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (this.f3415r0 != 0) {
                    c0Var = s0(0);
                    c1 u10 = u();
                    u10.getClass();
                    a aVar = new a(u10);
                    aVar.e(R.id.fragmentContainer, c0Var, (String) null);
                    aVar.g();
                    this.f3415r0 = 0;
                } else {
                    c0Var = u().D(R.id.fragmentContainer);
                }
                this.f3416s0 = c0Var;
                return;
            }
        }
        Toolbar toolbar = (Toolbar) hVar.f17662h;
        toolbar.setTitle((CharSequence) q0().f13354b);
        g6.a.f6840a.getClass();
        toolbar.setNavigationIcon(g6.a.a(mainActivity));
        toolbar.setNavigationOnClickListener(new c(mainActivity, 1));
        Spinner spinner = (Spinner) hVar.f17661g;
        xa.j.e("spinner", spinner);
        spinner.setVisibility(0);
        spinner.setAdapter(new ArrayAdapter(mainActivity, 17367049, y().getStringArray(R.array.spinnerMedia)));
        spinner.setOnItemSelectedListener(new v2(4, this));
    }

    public final void m0() {
        GamePagerViewModel r02 = r0();
        int i10 = q0().f13353a;
        if (!r02.f3423e.e()) {
            h0.b1(h0.I0(r02), (pa.h) null, 0, new k(i10, r02, (pa.e) null), 3);
        }
        if (q0().f13358f) {
            r0().e(f0(), q0().f13353a, q0().f13355c, q0().f13354b);
        }
    }

    public final void n() {
        c0 c0Var;
        h hVar = this.f3412o0;
        xa.j.c(hVar);
        ((AppBarLayout) hVar.f17657c).d(true, true, true);
        androidx.fragment.app.c0 c0Var2 = this.f3416s0;
        if (c0Var2 instanceof c0) {
            c0Var = (c0) c0Var2;
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
        return (f) this.f3413p0.getValue();
    }

    public final GamePagerViewModel r0() {
        return (GamePagerViewModel) this.f3414q0.getValue();
    }

    public final androidx.fragment.app.c0 s0(int i10) {
        androidx.fragment.app.c0 eVar = i10 != 0 ? i10 != 1 ? new k6.e() : new p7.c() : new j7.d();
        eVar.j0(e0());
        return eVar;
    }
}
