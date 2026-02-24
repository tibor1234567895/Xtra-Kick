package o2;

import android.os.Parcel;
import android.os.Parcelable;

public final class e implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new f(parcel);
    }

    public final Object[] newArray(int i10) {
        return new f[i10];
    }
}
