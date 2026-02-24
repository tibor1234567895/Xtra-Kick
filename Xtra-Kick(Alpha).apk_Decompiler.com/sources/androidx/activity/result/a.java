package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    public final Object[] newArray(int i10) {
        return new b[i10];
    }
}
