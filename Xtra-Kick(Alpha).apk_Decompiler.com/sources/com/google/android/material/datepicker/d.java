package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import l0.b;

public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final u f3744h;

    /* renamed from: i  reason: collision with root package name */
    public final u f3745i;

    /* renamed from: j  reason: collision with root package name */
    public final c f3746j;

    /* renamed from: k  reason: collision with root package name */
    public final u f3747k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3748l;

    /* renamed from: m  reason: collision with root package name */
    public final int f3749m;

    /* renamed from: n  reason: collision with root package name */
    public final int f3750n;

    public d(u uVar, u uVar2, c cVar, u uVar3, int i10) {
        Objects.requireNonNull(uVar, "start cannot be null");
        Objects.requireNonNull(uVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f3744h = uVar;
        this.f3745i = uVar2;
        this.f3747k = uVar3;
        this.f3748l = i10;
        this.f3746j = cVar;
        Calendar calendar = uVar.f3791h;
        if (uVar3 != null && calendar.compareTo(uVar3.f3791h) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (uVar3 != null && uVar3.f3791h.compareTo(uVar2.f3791h) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (i10 < 0 || i10 > c0.d((Calendar) null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else if (calendar instanceof GregorianCalendar) {
            int i11 = uVar2.f3793j;
            int i12 = uVar.f3793j;
            this.f3750n = (uVar2.f3792i - uVar.f3792i) + ((i11 - i12) * 12) + 1;
            this.f3749m = (i11 - i12) + 1;
        } else {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f3744h.equals(dVar.f3744h) || !this.f3745i.equals(dVar.f3745i) || !b.a(this.f3747k, dVar.f3747k) || this.f3748l != dVar.f3748l || !this.f3746j.equals(dVar.f3746j)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3744h, this.f3745i, this.f3747k, Integer.valueOf(this.f3748l), this.f3746j});
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f3744h, 0);
        parcel.writeParcelable(this.f3745i, 0);
        parcel.writeParcelable(this.f3747k, 0);
        parcel.writeParcelable(this.f3746j, 0);
        parcel.writeInt(this.f3748l);
    }
}
