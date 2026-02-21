package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;

public final class e implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new f(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new f[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new f(parcel, classLoader);
    }
}
