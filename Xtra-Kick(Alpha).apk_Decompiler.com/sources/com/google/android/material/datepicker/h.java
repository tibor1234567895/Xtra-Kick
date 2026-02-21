package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import java.util.Calendar;

public final class h extends BaseAdapter {

    /* renamed from: k  reason: collision with root package name */
    public static final int f3754k = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: h  reason: collision with root package name */
    public final Calendar f3755h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3756i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3757j;

    public h() {
        Calendar d10 = c0.d((Calendar) null);
        this.f3755h = d10;
        this.f3756i = d10.getMaximum(7);
        this.f3757j = d10.getFirstDayOfWeek();
    }

    public final int getCount() {
        return this.f3756i;
    }

    public final Object getItem(int i10) {
        int i11 = this.f3756i;
        if (i10 >= i11) {
            return null;
        }
        int i12 = i10 + this.f3757j;
        if (i12 > i11) {
            i12 -= i11;
        }
        return Integer.valueOf(i12);
    }

    public final long getItemId(int i10) {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r7v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x0018
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131558530(0x7f0d0082, float:1.8742378E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0018:
            int r7 = r5.f3757j
            int r6 = r6 + r7
            int r7 = r5.f3756i
            if (r6 <= r7) goto L_0x0020
            int r6 = r6 - r7
        L_0x0020:
            java.util.Calendar r7 = r5.f3755h
            r2 = 7
            r7.set(r2, r6)
            android.content.res.Resources r6 = r0.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            java.util.Locale r6 = r6.locale
            int r3 = f3754k
            java.lang.String r6 = r7.getDisplayName(r2, r3, r6)
            r0.setText(r6)
            android.content.Context r6 = r8.getContext()
            r8 = 2131952146(0x7f130212, float:1.9540727E38)
            java.lang.String r6 = r6.getString(r8)
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r3 = 2
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.getDisplayName(r2, r3, r4)
            r8[r1] = r7
            java.lang.String r6 = java.lang.String.format(r6, r8)
            r0.setContentDescription(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.h.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public h(int i10) {
        Calendar d10 = c0.d((Calendar) null);
        this.f3755h = d10;
        this.f3756i = d10.getMaximum(7);
        this.f3757j = i10;
    }
}
