package z;

import android.os.Parcel;
import android.os.Parcelable;

public final class g implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new h(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new h[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new h(parcel, classLoader);
    }
}
