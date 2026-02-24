package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class l implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new m(parcel);
    }

    public final Object[] newArray(int i10) {
        return new m[i10];
    }
}
