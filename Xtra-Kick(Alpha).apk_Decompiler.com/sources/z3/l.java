package z3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public final class l extends View.BaseSavedState {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* renamed from: h  reason: collision with root package name */
    public final boolean f17549h;

    public l(Parcel parcel) {
        super(parcel);
        this.f17549h = parcel.readByte() != 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeByte(this.f17549h ? (byte) 1 : 0);
    }

    public l(Parcelable parcelable, boolean z10) {
        super(parcelable);
        this.f17549h = z10;
    }
}
