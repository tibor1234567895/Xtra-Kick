package o2;

import android.os.Parcel;
import android.os.Parcelable;

public final class u implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new v(parcel);
    }

    public final Object[] newArray(int i10) {
        return new v[i10];
    }
}
