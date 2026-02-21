package o2;

import android.os.Parcel;
import android.os.Parcelable;

public final class i implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new j(parcel);
    }

    public final Object[] newArray(int i10) {
        return new j[i10];
    }
}
