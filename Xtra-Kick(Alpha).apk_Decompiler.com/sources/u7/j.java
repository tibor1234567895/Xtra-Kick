package u7;

import android.os.Parcel;
import android.os.Parcelable;

public final class j implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new k(parcel);
    }

    public final Object[] newArray(int i10) {
        return new k[i10];
    }
}
