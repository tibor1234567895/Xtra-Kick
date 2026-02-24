package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class u implements Comparable, Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new t();

    /* renamed from: h  reason: collision with root package name */
    public final Calendar f3791h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3792i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3793j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3794k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3795l;

    /* renamed from: m  reason: collision with root package name */
    public final long f3796m;

    /* renamed from: n  reason: collision with root package name */
    public String f3797n;

    public u(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b10 = c0.b(calendar);
        this.f3791h = b10;
        this.f3792i = b10.get(2);
        this.f3793j = b10.get(1);
        this.f3794k = b10.getMaximum(7);
        this.f3795l = b10.getActualMaximum(5);
        this.f3796m = b10.getTimeInMillis();
    }

    public static u u(int i10, int i11) {
        Calendar d10 = c0.d((Calendar) null);
        d10.set(1, i10);
        d10.set(2, i11);
        return new u(d10);
    }

    public static u v(long j10) {
        Calendar d10 = c0.d((Calendar) null);
        d10.setTimeInMillis(j10);
        return new u(d10);
    }

    public final int compareTo(Object obj) {
        return this.f3791h.compareTo(((u) obj).f3791h);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (com.google.android.material.datepicker.u) r5;
        r1 = r5.f3792i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.material.datepicker.u
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.material.datepicker.u r5 = (com.google.android.material.datepicker.u) r5
            int r1 = r5.f3792i
            int r3 = r4.f3792i
            if (r3 != r1) goto L_0x0019
            int r1 = r4.f3793j
            int r5 = r5.f3793j
            if (r1 != r5) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.u.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3792i), Integer.valueOf(this.f3793j)});
    }

    public final String w() {
        String str;
        if (this.f3797n == null) {
            long timeInMillis = this.f3791h.getTimeInMillis();
            if (Build.VERSION.SDK_INT >= 24) {
                str = c0.a("yMMMM", Locale.getDefault()).format(new Date(timeInMillis));
            } else {
                str = DateUtils.formatDateTime((Context) null, timeInMillis, 8228);
            }
            this.f3797n = str;
        }
        return this.f3797n;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f3793j);
        parcel.writeInt(this.f3792i);
    }
}
