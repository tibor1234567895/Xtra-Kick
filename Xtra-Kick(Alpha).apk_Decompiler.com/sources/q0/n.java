package q0;

import android.os.Parcel;
import android.os.Parcelable;

public final class n implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new o(parcel);
    }

    public final Object[] newArray(int i10) {
        return new o[i10];
    }
}
