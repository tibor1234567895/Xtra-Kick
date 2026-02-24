package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public final class b0 extends r {
    public static final Parcelable.Creator<b0> CREATOR = new a0();

    /* renamed from: h  reason: collision with root package name */
    public final int f12107h;

    public b0(Parcel parcel) {
        super(parcel);
        this.f12107h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f12107h);
    }

    public b0(AbsSavedState absSavedState, int i10) {
        super(absSavedState);
        this.f12107h = i10;
    }
}
