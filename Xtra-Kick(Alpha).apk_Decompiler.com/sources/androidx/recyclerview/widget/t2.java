package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class t2 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new u2(parcel);
    }

    public final Object[] newArray(int i10) {
        return new u2[i10];
    }
}
