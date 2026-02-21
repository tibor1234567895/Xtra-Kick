package q2;

import android.os.Parcel;
import android.os.Parcelable;

public final class h implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new i();
    }

    public final Object[] newArray(int i10) {
        return new i[i10];
    }
}
