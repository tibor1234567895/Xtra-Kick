package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class e1 implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new f1(parcel);
    }

    public final Object[] newArray(int i10) {
        return new f1[i10];
    }
}
