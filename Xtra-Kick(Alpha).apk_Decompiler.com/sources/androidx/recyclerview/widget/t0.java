package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class t0 implements Parcelable {
    public static final Parcelable.Creator<t0> CREATOR = new s0();

    /* renamed from: h  reason: collision with root package name */
    public int f2196h;

    /* renamed from: i  reason: collision with root package name */
    public int f2197i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2198j;

    public t0() {
    }

    public t0(Parcel parcel) {
        this.f2196h = parcel.readInt();
        this.f2197i = parcel.readInt();
        this.f2198j = parcel.readInt() != 1 ? false : true;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2196h);
        parcel.writeInt(this.f2197i);
        parcel.writeInt(this.f2198j ? 1 : 0);
    }

    public t0(t0 t0Var) {
        this.f2196h = t0Var.f2196h;
        this.f2197i = t0Var.f2197i;
        this.f2198j = t0Var.f2198j;
    }
}
