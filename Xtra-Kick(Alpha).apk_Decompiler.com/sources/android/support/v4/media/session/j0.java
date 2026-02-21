package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public final class j0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$QueueItem(parcel);
    }

    public final Object[] newArray(int i10) {
        return new MediaSessionCompat$QueueItem[i10];
    }
}
