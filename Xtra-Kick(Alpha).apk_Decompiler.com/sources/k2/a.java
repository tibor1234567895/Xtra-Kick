package k2;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        return new b(parcel.readInt(), readString);
    }

    public final Object[] newArray(int i10) {
        return new b[i10];
    }
}
