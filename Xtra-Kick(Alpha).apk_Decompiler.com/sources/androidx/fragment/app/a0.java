package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class a0 implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new b0(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new b0[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b0(parcel, classLoader);
    }
}
