package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public final class d extends r {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: h  reason: collision with root package name */
    public String f12111h;

    public d(Parcel parcel) {
        super(parcel);
        this.f12111h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f12111h);
    }

    public d(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
