package q1;

import android.os.Parcel;
import android.os.Parcelable;

public final class x implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new y(parcel);
    }

    public final Object[] newArray(int i10) {
        return new y[i10];
    }
}
