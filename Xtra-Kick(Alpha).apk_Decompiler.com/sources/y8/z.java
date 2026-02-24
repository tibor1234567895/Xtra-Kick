package y8;

import android.os.Parcel;
import android.os.Parcelable;

public final class z implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new a0(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new a0[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new a0(parcel, classLoader);
    }
}
