package c8;

import android.os.Parcel;
import android.os.Parcelable;

public final class c extends t0.c {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: j  reason: collision with root package name */
    public boolean f3000j;

    public c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            c.class.getClassLoader();
        }
        this.f3000j = parcel.readInt() != 1 ? false : true;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeInt(this.f3000j ? 1 : 0);
    }

    public c(Parcelable parcelable) {
        super(parcelable);
    }
}
