package z3;

import android.os.Parcel;
import android.os.Parcelable;

public final class k implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new l(parcel);
    }

    public final Object[] newArray(int i10) {
        return new l[i10];
    }
}
