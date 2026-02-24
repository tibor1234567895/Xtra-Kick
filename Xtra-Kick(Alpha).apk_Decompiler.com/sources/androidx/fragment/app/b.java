package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new c(parcel);
    }

    public final Object[] newArray(int i10) {
        return new c[i10];
    }
}
