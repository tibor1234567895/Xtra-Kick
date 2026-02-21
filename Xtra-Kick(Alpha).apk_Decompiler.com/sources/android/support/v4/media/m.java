package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class m implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new MediaBrowserCompat$MediaItem(parcel);
    }

    public final Object[] newArray(int i10) {
        return new MediaBrowserCompat$MediaItem[i10];
    }
}
