package p2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import g1.a0;
import g1.u0;
import g1.y0;
import j1.l0;
import java.util.Arrays;

public final class b implements y0 {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final String f12511h;

    /* renamed from: i  reason: collision with root package name */
    public final byte[] f12512i;

    /* renamed from: j  reason: collision with root package name */
    public final int f12513j;

    /* renamed from: k  reason: collision with root package name */
    public final int f12514k;

    public b(Parcel parcel) {
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12511h = readString;
        this.f12512i = parcel.createByteArray();
        this.f12513j = parcel.readInt();
        this.f12514k = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12511h.equals(bVar.f12511h) && Arrays.equals(this.f12512i, bVar.f12512i) && this.f12513j == bVar.f12513j && this.f12514k == bVar.f12514k;
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f12512i) + h.e(this.f12511h, 527, 31)) * 31) + this.f12513j) * 31) + this.f12514k;
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "mdta: key=" + this.f12511h;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12511h);
        parcel.writeByteArray(this.f12512i);
        parcel.writeInt(this.f12513j);
        parcel.writeInt(this.f12514k);
    }

    public b(String str, byte[] bArr, int i10, int i11) {
        this.f12511h = str;
        this.f12512i = bArr;
        this.f12513j = i10;
        this.f12514k = i11;
    }
}
