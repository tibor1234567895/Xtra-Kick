package c8;

import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new c(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new c[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new c(parcel, classLoader);
    }
}
