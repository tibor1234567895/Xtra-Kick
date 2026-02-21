package m8;

import android.os.Parcel;
import android.os.Parcelable;

public final class i implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new j(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new j[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new j(parcel, classLoader);
    }
}
