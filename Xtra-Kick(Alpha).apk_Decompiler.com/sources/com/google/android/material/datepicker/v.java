package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import java.util.Calendar;
import z5.j;

public final class v extends BaseAdapter {

    /* renamed from: k  reason: collision with root package name */
    public static final int f3798k = c0.d((Calendar) null).getMaximum(4);

    /* renamed from: l  reason: collision with root package name */
    public static final int f3799l = ((c0.d((Calendar) null).getMaximum(7) + c0.d((Calendar) null).getMaximum(5)) - 1);

    /* renamed from: h  reason: collision with root package name */
    public final u f3800h;

    /* renamed from: i  reason: collision with root package name */
    public j f3801i;

    /* renamed from: j  reason: collision with root package name */
    public final d f3802j;

    public v(u uVar, d dVar, g gVar) {
        this.f3800h = uVar;
        this.f3802j = dVar;
        throw null;
    }

    public final int a() {
        int i10 = this.f3802j.f3748l;
        u uVar = this.f3800h;
        Calendar calendar = uVar.f3791h;
        int i11 = calendar.get(7);
        if (i10 <= 0) {
            i10 = calendar.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            return i12 + uVar.f3794k;
        }
        return i12;
    }

    /* renamed from: b */
    public final Long getItem(int i10) {
        if (i10 < a()) {
            return null;
        }
        int a10 = a();
        u uVar = this.f3800h;
        if (i10 > (a10 + uVar.f3795l) - 1) {
            return null;
        }
        Calendar b10 = c0.b(uVar.f3791h);
        b10.set(5, (i10 - a()) + 1);
        return Long.valueOf(b10.getTimeInMillis());
    }

    public final int getCount() {
        return f3799l;
    }

    public final long getItemId(int i10) {
        return (long) (i10 / this.f3800h.f3794k);
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            android.content.Context r0 = r7.getContext()
            z5.j r1 = r4.f3801i
            if (r1 != 0) goto L_0x000f
            z5.j r1 = new z5.j
            r1.<init>(r0)
            r4.f3801i = r1
        L_0x000f:
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L_0x0027
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r0 = 2131558529(0x7f0d0081, float:1.8742376E38)
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0027:
            int r6 = r4.a()
            int r6 = r5 - r6
            if (r6 < 0) goto L_0x005d
            com.google.android.material.datepicker.u r7 = r4.f3800h
            int r2 = r7.f3795l
            if (r6 < r2) goto L_0x0036
            goto L_0x005d
        L_0x0036:
            r2 = 1
            int r6 = r6 + r2
            r0.setTag(r7)
            android.content.res.Resources r7 = r0.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r1] = r6
            java.lang.String r6 = "%d"
            java.lang.String r6 = java.lang.String.format(r7, r6, r3)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L_0x0065
        L_0x005d:
            r6 = 8
            r0.setVisibility(r6)
            r0.setEnabled(r1)
        L_0x0065:
            java.lang.Long r5 = r4.getItem(r5)
            if (r5 != 0) goto L_0x006c
            goto L_0x0071
        L_0x006c:
            r5.longValue()
            if (r0 != 0) goto L_0x0072
        L_0x0071:
            return r0
        L_0x0072:
            r0.getContext()
            java.util.Calendar r5 = com.google.android.material.datepicker.c0.c()
            r5.getTimeInMillis()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.v.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final boolean hasStableIds() {
        return true;
    }
}
