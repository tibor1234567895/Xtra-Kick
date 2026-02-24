package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import java.util.Locale;
import z5.j;

public final class e0 extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final n f3752a;

    public e0(n nVar) {
        this.f3752a = nVar;
    }

    public final int getItemCount() {
        return this.f3752a.f3769f0.f3749m;
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        String str;
        d0 d0Var = (d0) k2Var;
        n nVar = this.f3752a;
        int i11 = nVar.f3769f0.f3744h.f3793j + i10;
        d0Var.f3751h.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i11)}));
        TextView textView = d0Var.f3751h;
        Context context = textView.getContext();
        if (c0.c().get(1) == i11) {
            str = String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(i11)});
        } else {
            str = String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(i11)});
        }
        textView.setContentDescription(str);
        j jVar = nVar.f3773j0;
        if (c0.c().get(1) == i11) {
            Object obj = jVar.f17682h;
        } else {
            Object obj2 = jVar.f17679e;
        }
        throw null;
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new d0((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
