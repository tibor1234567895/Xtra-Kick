package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class b5 implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new c5(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new c5[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new c5(parcel, classLoader);
    }
}
