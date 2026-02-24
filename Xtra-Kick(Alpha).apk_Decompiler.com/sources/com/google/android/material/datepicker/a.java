package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        Class<u> cls = u.class;
        return new d((u) parcel.readParcelable(cls.getClassLoader()), (u) parcel.readParcelable(cls.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (u) parcel.readParcelable(cls.getClassLoader()), parcel.readInt());
    }

    public final Object[] newArray(int i10) {
        return new d[i10];
    }
}
