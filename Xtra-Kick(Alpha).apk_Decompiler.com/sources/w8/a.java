package w8;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new b(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new b[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b(parcel, classLoader);
    }
}
