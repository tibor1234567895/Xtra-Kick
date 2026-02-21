package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class d implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new e(parcel);
    }

    public final Object[] newArray(int i10) {
        return new e[i10];
    }
}
