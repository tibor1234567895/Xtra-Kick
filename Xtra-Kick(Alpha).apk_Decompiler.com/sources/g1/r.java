package g1;

import android.os.Parcel;
import android.os.Parcelable;

public final class r implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new u(parcel);
    }

    public final Object[] newArray(int i10) {
        return new u[i10];
    }
}
