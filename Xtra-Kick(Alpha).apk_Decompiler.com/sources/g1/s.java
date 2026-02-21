package g1;

import android.os.Parcel;
import android.os.Parcelable;

public final class s implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new t(parcel);
    }

    public final Object[] newArray(int i10) {
        return new t[i10];
    }
}
