package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.r1;
import b4.e0;
import com.woxthebox.draglistview.R;
import java.util.Calendar;

public final class y extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final d f3807a;

    /* renamed from: b  reason: collision with root package name */
    public final g f3808b;

    /* renamed from: c  reason: collision with root package name */
    public final e0 f3809c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3810d;

    public y(ContextThemeWrapper contextThemeWrapper, d dVar, g gVar, e0 e0Var) {
        int i10;
        Calendar calendar = dVar.f3744h.f3791h;
        u uVar = dVar.f3747k;
        if (calendar.compareTo(uVar.f3791h) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (uVar.f3791h.compareTo(dVar.f3745i.f3791h) <= 0) {
            int i11 = v.f3798k;
            int i12 = n.f3767q0;
            int dimensionPixelSize = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i11;
            if (r.t0(contextThemeWrapper)) {
                i10 = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
            } else {
                i10 = 0;
            }
            this.f3810d = dimensionPixelSize + i10;
            this.f3807a = dVar;
            this.f3808b = gVar;
            this.f3809c = e0Var;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public final int getItemCount() {
        return this.f3807a.f3750n;
    }

    public final long getItemId(int i10) {
        Calendar b10 = c0.b(this.f3807a.f3744h.f3791h);
        b10.add(2, i10);
        return new u(b10).f3791h.getTimeInMillis();
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        x xVar = (x) k2Var;
        d dVar = this.f3807a;
        Calendar b10 = c0.b(dVar.f3744h.f3791h);
        b10.add(2, i10);
        u uVar = new u(b10);
        xVar.f3805h.setText(uVar.w());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) xVar.f3806i.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !uVar.equals(materialCalendarGridView.getAdapter().f3800h)) {
            new v(uVar, dVar, this.f3808b);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.getAdapter().getClass();
        throw null;
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!r.t0(viewGroup.getContext())) {
            return new x(linearLayout, false);
        }
        linearLayout.setLayoutParams(new r1(-1, this.f3810d));
        return new x(linearLayout, true);
    }
}
