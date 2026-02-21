package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class t implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return u.u(parcel.readInt(), parcel.readInt());
    }

    public final Object[] newArray(int i10) {
        return new u[i10];
    }
}
