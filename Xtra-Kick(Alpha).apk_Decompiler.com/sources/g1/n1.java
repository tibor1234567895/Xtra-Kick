package g1;

import android.os.Parcel;
import android.os.Parcelable;

public final class n1 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new o1(parcel);
    }

    public final Object[] newArray(int i10) {
        return new o1[i10];
    }
}
