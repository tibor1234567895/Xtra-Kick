package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import d4.e;

public final class m0 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$Token(parcel.readParcelable((ClassLoader) null), (f) null, (e) null);
    }

    public final Object[] newArray(int i10) {
        return new MediaSessionCompat$Token[i10];
    }
}
