package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class f implements c {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* renamed from: h  reason: collision with root package name */
    public final long f3753h;

    public f(long j10) {
        this.f3753h = j10;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f3753h == ((f) obj).f3753h;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3753h)});
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f3753h);
    }
}
