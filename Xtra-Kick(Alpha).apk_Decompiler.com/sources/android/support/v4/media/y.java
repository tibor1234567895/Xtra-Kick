package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class y implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }

    public final Object[] newArray(int i10) {
        return new MediaMetadataCompat[i10];
    }
}
