package m8;

import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: j  reason: collision with root package name */
    public boolean f10716j;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10716j = parcel.readInt() != 1 ? false : true;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeInt(this.f10716j ? 1 : 0);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
    }
}
