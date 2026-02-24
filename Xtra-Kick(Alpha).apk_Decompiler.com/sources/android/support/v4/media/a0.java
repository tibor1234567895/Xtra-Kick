package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class a0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    public final Object[] newArray(int i10) {
        return new RatingCompat[i10];
    }
}
