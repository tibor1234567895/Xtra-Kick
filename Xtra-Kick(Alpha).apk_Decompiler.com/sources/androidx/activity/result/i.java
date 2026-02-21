package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

public final class i implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new k(parcel);
    }

    public final Object[] newArray(int i10) {
        return new k[i10];
    }
}
