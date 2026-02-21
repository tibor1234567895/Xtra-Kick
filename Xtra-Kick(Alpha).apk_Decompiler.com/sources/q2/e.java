package q2;

import android.os.Parcel;
import android.os.Parcelable;

public final class e implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new g(parcel);
    }

    public final Object[] newArray(int i10) {
        return new g[i10];
    }
}
