package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public final class i extends r {
    public static final Parcelable.Creator<i> CREATOR = new h();

    /* renamed from: h  reason: collision with root package name */
    public String f12125h;

    public i(Parcel parcel) {
        super(parcel);
        this.f12125h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f12125h);
    }

    public i(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
