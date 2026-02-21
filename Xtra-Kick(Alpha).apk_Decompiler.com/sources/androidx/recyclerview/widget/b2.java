package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class b2 implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return new c2(parcel, (ClassLoader) null);
    }

    public final Object[] newArray(int i10) {
        return new c2[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new c2(parcel, classLoader);
    }
}
