package p2;

import android.os.Parcel;
import android.os.Parcelable;

public final class f implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new g(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final Object[] newArray(int i10) {
        return new g[i10];
    }
}
