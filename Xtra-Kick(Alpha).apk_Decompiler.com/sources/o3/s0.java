package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public final class s0 extends r {
    public static final Parcelable.Creator<s0> CREATOR = new r0();

    /* renamed from: h  reason: collision with root package name */
    public boolean f12170h;

    public s0(Parcel parcel) {
        super(parcel);
        this.f12170h = parcel.readInt() != 1 ? false : true;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f12170h ? 1 : 0);
    }

    public s0(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
