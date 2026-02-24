package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class x0 implements Parcelable {
    public static final Parcelable.Creator<x0> CREATOR = new w0();

    /* renamed from: h  reason: collision with root package name */
    public final String f1610h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1611i;

    public x0(Parcel parcel) {
        this.f1610h = parcel.readString();
        this.f1611i = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1610h);
        parcel.writeInt(this.f1611i);
    }

    public x0(String str) {
        this.f1610h = str;
        this.f1611i = 3;
    }
}
