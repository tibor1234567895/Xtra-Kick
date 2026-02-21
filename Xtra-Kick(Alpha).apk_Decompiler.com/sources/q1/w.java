package q1;

import android.os.Parcel;
import android.os.Parcelable;

public final class w implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new z(parcel);
    }

    public final Object[] newArray(int i10) {
        return new z[i10];
    }
}
