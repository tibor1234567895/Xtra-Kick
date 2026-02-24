package o8;

import android.os.Parcel;
import android.os.Parcelable;
import m8.j;

public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new g();

    /* renamed from: h  reason: collision with root package name */
    public int f12349h;

    /* renamed from: i  reason: collision with root package name */
    public j f12350i;

    public h() {
    }

    public h(Parcel parcel) {
        this.f12349h = parcel.readInt();
        this.f12350i = (j) parcel.readParcelable(h.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f12349h);
        parcel.writeParcelable(this.f12350i, 0);
    }
}
