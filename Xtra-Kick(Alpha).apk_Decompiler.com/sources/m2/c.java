package m2;

import android.os.Parcel;
import android.os.Parcelable;

public final class c implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new d(parcel);
    }

    public final Object[] newArray(int i10) {
        return new d[i10];
    }
}
