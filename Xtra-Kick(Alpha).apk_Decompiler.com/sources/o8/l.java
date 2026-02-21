package o8;

import android.os.Parcel;
import android.os.Parcelable;

public final class l implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new m(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new m[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new m(parcel, classLoader);
    }
}
