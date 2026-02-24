package u8;

import android.os.Parcel;
import android.os.Parcelable;

public final class c implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new d(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new d[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new d(parcel, classLoader);
    }
}
