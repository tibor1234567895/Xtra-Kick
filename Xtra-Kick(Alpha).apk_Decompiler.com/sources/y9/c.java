package y9;

import android.os.Parcel;
import android.os.Parcelable;
import xa.j;

public final class c implements Parcelable.Creator {
    private c() {
    }

    public /* synthetic */ c(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        j.g("source", parcel);
        d dVar = new d();
        dVar.f17241h = parcel.readInt();
        dVar.f17242i = parcel.readInt();
        dVar.f17243j = parcel.readLong();
        dVar.f17244k = parcel.readLong();
        dVar.f17245l = parcel.readLong();
        return dVar;
    }

    public final Object[] newArray(int i10) {
        return new d[i10];
    }
}
