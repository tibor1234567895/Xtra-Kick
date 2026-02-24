package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class c5 extends c {
    public static final Parcelable.Creator<c5> CREATOR = new b5();

    /* renamed from: j  reason: collision with root package name */
    public int f783j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f784k;

    public c5(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f783j = parcel.readInt();
        this.f784k = parcel.readInt() != 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeInt(this.f783j);
        parcel.writeInt(this.f784k ? 1 : 0);
    }

    public c5(Parcelable parcelable) {
        super(parcelable);
    }
}
