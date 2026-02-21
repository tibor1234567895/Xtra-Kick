package android.support.v4.media;

import android.media.MediaDescription;
import android.os.Parcel;
import android.os.Parcelable;

public final class t implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return MediaDescriptionCompat.u(MediaDescription.CREATOR.createFromParcel(parcel));
    }

    public final Object[] newArray(int i10) {
        return new MediaDescriptionCompat[i10];
    }
}
