package o3;

import android.os.Parcel;
import android.os.Parcelable;

public final class a0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new b0(parcel);
    }

    public final Object[] newArray(int i10) {
        return new b0[i10];
    }
}
