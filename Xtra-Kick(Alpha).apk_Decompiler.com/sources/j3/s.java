package j3;

import android.os.Parcel;
import android.os.Parcelable;
import xa.j;

public final class s implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        j.f("inParcel", parcel);
        return new u(parcel);
    }

    public final Object[] newArray(int i10) {
        return new u[i10];
    }
}
