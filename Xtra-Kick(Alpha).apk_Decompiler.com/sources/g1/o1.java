package g1;

import android.os.Parcel;
import android.os.Parcelable;

public final class o1 implements Comparable, Parcelable {
    public static final Parcelable.Creator<o1> CREATOR = new n1();

    /* renamed from: h  reason: collision with root package name */
    public final int f6498h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6499i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6500j;

    public o1(Parcel parcel) {
        this.f6498h = parcel.readInt();
        this.f6499i = parcel.readInt();
        this.f6500j = parcel.readInt();
    }

    public final int compareTo(Object obj) {
        o1 o1Var = (o1) obj;
        int i10 = this.f6498h - o1Var.f6498h;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f6499i - o1Var.f6499i;
        if (i11 == 0) {
            return this.f6500j - o1Var.f6500j;
        }
        return i11;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o1.class != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f6498h == o1Var.f6498h && this.f6499i == o1Var.f6499i && this.f6500j == o1Var.f6500j;
    }

    public final int hashCode() {
        return (((this.f6498h * 31) + this.f6499i) * 31) + this.f6500j;
    }

    public final String toString() {
        return this.f6498h + "." + this.f6499i + "." + this.f6500j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f6498h);
        parcel.writeInt(this.f6499i);
        parcel.writeInt(this.f6500j);
    }
}
