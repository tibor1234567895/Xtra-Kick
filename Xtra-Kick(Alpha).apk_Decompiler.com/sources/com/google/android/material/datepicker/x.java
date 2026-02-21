package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.e0;

public final class x extends k2 {

    /* renamed from: h  reason: collision with root package name */
    public final TextView f3805h;

    /* renamed from: i  reason: collision with root package name */
    public final MaterialCalendarGridView f3806i;

    public x(LinearLayout linearLayout, boolean z10) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f3805h = textView;
        WeakHashMap weakHashMap = c1.f10054a;
        new e0(R.id.tag_accessibility_heading, 3).c(textView, Boolean.TRUE);
        this.f3806i = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (!z10) {
            textView.setVisibility(8);
        }
    }
}
