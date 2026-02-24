package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public final class q0 extends r {
    public static final Parcelable.Creator<q0> CREATOR = new p0();

    /* renamed from: h  reason: collision with root package name */
    public int f12167h;

    /* renamed from: i  reason: collision with root package name */
    public int f12168i;

    /* renamed from: j  reason: collision with root package name */
    public int f12169j;

    public q0(Parcel parcel) {
        super(parcel);
        this.f12167h = parcel.readInt();
        this.f12168i = parcel.readInt();
        this.f12169j = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f12167h);
        parcel.writeInt(this.f12168i);
        parcel.writeInt(this.f12169j);
    }

    public q0(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
