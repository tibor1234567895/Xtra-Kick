package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new l();

    /* renamed from: h  reason: collision with root package name */
    public int f926h;

    public m() {
    }

    public m(Parcel parcel) {
        this.f926h = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f926h);
    }
}
