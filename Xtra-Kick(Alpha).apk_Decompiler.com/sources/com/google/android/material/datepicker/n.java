package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b1;
import b4.e0;
import com.google.android.material.button.MaterialButton;
import com.woxthebox.draglistview.R;
import g.c;
import h4.r;
import java.util.Calendar;
import java.util.GregorianCalendar;
import m0.c1;
import z5.j;

public final class n<S> extends a0 {

    /* renamed from: q0  reason: collision with root package name */
    public static final /* synthetic */ int f3767q0 = 0;

    /* renamed from: e0  reason: collision with root package name */
    public int f3768e0;

    /* renamed from: f0  reason: collision with root package name */
    public d f3769f0;

    /* renamed from: g0  reason: collision with root package name */
    public g f3770g0;

    /* renamed from: h0  reason: collision with root package name */
    public u f3771h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f3772i0;

    /* renamed from: j0  reason: collision with root package name */
    public j f3773j0;

    /* renamed from: k0  reason: collision with root package name */
    public RecyclerView f3774k0;

    /* renamed from: l0  reason: collision with root package name */
    public RecyclerView f3775l0;

    /* renamed from: m0  reason: collision with root package name */
    public View f3776m0;

    /* renamed from: n0  reason: collision with root package name */
    public View f3777n0;

    /* renamed from: o0  reason: collision with root package name */
    public View f3778o0;

    /* renamed from: p0  reason: collision with root package name */
    public View f3779p0;

    public final void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1357m;
        }
        this.f3768e0 = bundle.getInt("THEME_RES_ID_KEY");
        h.w(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f3769f0 = (d) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f3770g0 = (g) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f3771h0 = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10;
        int i11;
        h hVar;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(v(), this.f3768e0);
        this.f3773j0 = new j(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVar = this.f3769f0.f3744h;
        if (r.t0(contextThemeWrapper)) {
            i11 = R.layout.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i11 = R.layout.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i11, viewGroup, false);
        Resources resources = f0().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i12 = v.f3798k;
        int i13 = dimensionPixelOffset + dimensionPixelSize;
        inflate.setMinimumHeight(i13 + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i12 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i12) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        c1.p(gridView, new j(this, 0));
        int i14 = this.f3769f0.f3748l;
        if (i14 <= 0) {
            hVar = new h();
        }
        gridView.setAdapter(hVar);
        gridView.setNumColumns(uVar.f3794k);
        gridView.setEnabled(false);
        this.f3775l0 = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        v();
        this.f3775l0.setLayoutManager(new k(this, i10, i10));
        this.f3775l0.setTag("MONTHS_VIEW_GROUP_TAG");
        y yVar = new y(contextThemeWrapper, this.f3769f0, this.f3770g0, new e0(23, this));
        this.f3775l0.setAdapter(yVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f3774k0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f3774k0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f3774k0.setAdapter(new e0(this));
            this.f3774k0.addItemDecoration(new l(this));
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            c1.p(materialButton, new j(this, 2));
            View findViewById = inflate.findViewById(R.id.month_navigation_previous);
            this.f3776m0 = findViewById;
            findViewById.setTag("NAVIGATION_PREV_TAG");
            View findViewById2 = inflate.findViewById(R.id.month_navigation_next);
            this.f3777n0 = findViewById2;
            findViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f3778o0 = inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.f3779p0 = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            n0(1);
            materialButton.setText(this.f3771h0.w());
            this.f3775l0.addOnScrollListener(new m(this, yVar, materialButton));
            materialButton.setOnClickListener(new c(5, this));
            this.f3777n0.setOnClickListener(new i(this, yVar, 1));
            this.f3776m0.setOnClickListener(new i(this, yVar, 0));
        }
        if (!r.t0(contextThemeWrapper)) {
            new b1().b(this.f3775l0);
        }
        RecyclerView recyclerView2 = this.f3775l0;
        u uVar2 = this.f3771h0;
        u uVar3 = yVar.f3807a.f3744h;
        if (uVar3.f3791h instanceof GregorianCalendar) {
            recyclerView2.scrollToPosition((uVar2.f3792i - uVar3.f3792i) + ((uVar2.f3793j - uVar3.f3793j) * 12));
            c1.p(this.f3775l0, new j(this, 1));
            return inflate;
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public final void W(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f3768e0);
        bundle.putParcelable("GRID_SELECTOR_KEY", (Parcelable) null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3769f0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f3770g0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f3771h0);
    }

    public final void l0(int i10) {
        this.f3775l0.post(new r(this, i10, 1));
    }

    public final void m0(u uVar) {
        boolean z10;
        RecyclerView recyclerView;
        int i10;
        u uVar2 = ((y) this.f3775l0.getAdapter()).f3807a.f3744h;
        Calendar calendar = uVar2.f3791h;
        if (calendar instanceof GregorianCalendar) {
            int i11 = uVar.f3793j;
            int i12 = uVar2.f3793j;
            int i13 = uVar.f3792i;
            int i14 = uVar2.f3792i;
            int i15 = (i13 - i14) + ((i11 - i12) * 12);
            u uVar3 = this.f3771h0;
            if (calendar instanceof GregorianCalendar) {
                int i16 = i15 - ((uVar3.f3792i - i14) + ((uVar3.f3793j - i12) * 12));
                boolean z11 = false;
                if (Math.abs(i16) > 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i16 > 0) {
                    z11 = true;
                }
                this.f3771h0 = uVar;
                if (!z10 || !z11) {
                    if (z10) {
                        recyclerView = this.f3775l0;
                        i10 = i15 + 3;
                    }
                    l0(i15);
                    return;
                }
                recyclerView = this.f3775l0;
                i10 = i15 - 3;
                recyclerView.scrollToPosition(i10);
                l0(i15);
                return;
            }
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public final void n0(int i10) {
        this.f3772i0 = i10;
        if (i10 == 2) {
            this.f3774k0.getLayoutManager().A0(this.f3771h0.f3793j - ((e0) this.f3774k0.getAdapter()).f3752a.f3769f0.f3744h.f3793j);
            this.f3778o0.setVisibility(0);
            this.f3779p0.setVisibility(8);
            this.f3776m0.setVisibility(8);
            this.f3777n0.setVisibility(8);
        } else if (i10 == 1) {
            this.f3778o0.setVisibility(8);
            this.f3779p0.setVisibility(0);
            this.f3776m0.setVisibility(0);
            this.f3777n0.setVisibility(0);
            m0(this.f3771h0);
        }
    }
}
