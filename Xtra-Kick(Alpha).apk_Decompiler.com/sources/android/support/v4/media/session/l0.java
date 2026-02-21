package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public final class l0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$ResultReceiverWrapper(parcel);
    }

    public final Object[] newArray(int i10) {
        return new MediaSessionCompat$ResultReceiverWrapper[i10];
    }
}
