package o3;

import android.os.Parcel;
import android.os.Parcelable;

public final class m implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new n(parcel);
    }

    public final Object[] newArray(int i10) {
        return new n[i10];
    }
}
