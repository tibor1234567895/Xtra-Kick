package o2;

import android.os.Parcel;
import android.os.Parcelable;

public final class y implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new z(parcel);
    }

    public final Object[] newArray(int i10) {
        return new z[i10];
    }
}
