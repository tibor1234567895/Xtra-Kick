package t0;

import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        if (parcel.readParcelable((ClassLoader) null) == null) {
            return c.f14483i;
        }
        throw new IllegalStateException("superState must be null");
    }

    public final Object[] newArray(int i10) {
        return new c[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return c.f14483i;
        }
        throw new IllegalStateException("superState must be null");
    }
}
