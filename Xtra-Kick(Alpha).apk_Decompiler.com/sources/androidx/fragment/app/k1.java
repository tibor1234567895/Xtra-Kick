package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class k1 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new l1(parcel);
    }

    public final Object[] newArray(int i10) {
        return new l1[i10];
    }
}
