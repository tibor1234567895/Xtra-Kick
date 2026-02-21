package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

public final class w implements AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3803h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y f3804i;

    public w(y yVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3804i = yVar;
        this.f3803h = materialCalendarGridView;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        boolean z10;
        MaterialCalendarGridView materialCalendarGridView = this.f3803h;
        v a10 = materialCalendarGridView.getAdapter();
        boolean z11 = true;
        if (i10 < a10.a() || i10 > (a10.a() + a10.f3800h.f3795l) - 1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (materialCalendarGridView.getAdapter().getItem(i10).longValue() < ((f) ((n) this.f3804i.f3809c.f2538i).f3769f0.f3746j).f3753h) {
                z11 = false;
            }
            if (z11) {
                throw null;
            }
        }
    }
}
