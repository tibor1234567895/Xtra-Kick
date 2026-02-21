package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class g implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new h(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public final Object[] newArray(int i10) {
        return new h[i10];
    }
}
