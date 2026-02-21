package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public final class o0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }

    public final Object[] newArray(int i10) {
        return new PlaybackStateCompat[i10];
    }
}
