package h4;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public final class p implements Parcelable.ClassLoaderCreator {
    public final Object createFromParcel(Parcel parcel) {
        return Build.VERSION.SDK_INT >= 24 ? new q(parcel, (ClassLoader) null) : new q(parcel);
    }

    public final Object[] newArray(int i10) {
        return new q[i10];
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 ? new q(parcel, classLoader) : new q(parcel);
    }
}
