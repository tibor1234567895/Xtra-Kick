package u8;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;
import t0.c;

public final class d extends c {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: j  reason: collision with root package name */
    public final int f15439j;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f15439j = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeInt(this.f15439j);
    }

    public d(AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
        super((Parcelable) absSavedState);
        this.f15439j = sideSheetBehavior.f3842h;
    }
}
