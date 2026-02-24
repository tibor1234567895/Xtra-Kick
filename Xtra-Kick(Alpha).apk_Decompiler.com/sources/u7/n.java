package u7;

import android.os.Parcel;
import android.os.Parcelable;

public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new m();

    /* renamed from: h  reason: collision with root package name */
    public int f15434h;

    /* renamed from: i  reason: collision with root package name */
    public int f15435i;

    public n() {
    }

    public n(Parcel parcel) {
        this.f15434h = parcel.readInt();
        this.f15435i = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SavedState{mAnchorPosition=" + this.f15434h + ", mAnchorOffset=" + this.f15435i + '}';
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15434h);
        parcel.writeInt(this.f15435i);
    }

    public n(n nVar) {
        this.f15434h = nVar.f15434h;
        this.f15435i = nVar.f15435i;
    }
}
