package u7;

import android.os.Parcel;
import android.os.Parcelable;

public final class g implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new h(parcel);
    }

    public final Object[] newArray(int i10) {
        return new h[i10];
    }
}
