package o2;

import android.os.Parcel;
import android.os.Parcelable;
import d9.r0;

public final class w implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        String readString2 = parcel.readString();
        String[] createStringArray = parcel.createStringArray();
        createStringArray.getClass();
        return new x(readString, readString2, r0.k(createStringArray));
    }

    public final Object[] newArray(int i10) {
        return new x[i10];
    }
}
