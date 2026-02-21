package b8;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import t0.c;

public final class d extends c {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: j  reason: collision with root package name */
    public final int f2663j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2664k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2665l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f2666m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f2667n;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2663j = parcel.readInt();
        this.f2664k = parcel.readInt();
        boolean z10 = false;
        this.f2665l = parcel.readInt() == 1;
        this.f2666m = parcel.readInt() == 1;
        this.f2667n = parcel.readInt() == 1 ? true : z10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeInt(this.f2663j);
        parcel.writeInt(this.f2664k);
        parcel.writeInt(this.f2665l ? 1 : 0);
        parcel.writeInt(this.f2666m ? 1 : 0);
        parcel.writeInt(this.f2667n ? 1 : 0);
    }

    public d(AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
        super((Parcelable) absSavedState);
        this.f2663j = bottomSheetBehavior.L;
        this.f2664k = bottomSheetBehavior.f3669e;
        this.f2665l = bottomSheetBehavior.f3663b;
        this.f2666m = bottomSheetBehavior.I;
        this.f2667n = bottomSheetBehavior.J;
    }
}
