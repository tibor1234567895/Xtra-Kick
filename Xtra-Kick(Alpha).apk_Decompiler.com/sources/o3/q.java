package o3;

import android.os.Parcel;
import android.os.Parcelable;

public final class q implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new r(parcel);
    }

    public final Object[] newArray(int i10) {
        return new r[i10];
    }
}
