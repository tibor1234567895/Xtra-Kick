package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public final class n0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }

    public final Object[] newArray(int i10) {
        return new ParcelableVolumeInfo[i10];
    }
}
