package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;

public final class v extends p {
    public static final Parcelable.Creator<v> CREATOR = new u();

    /* renamed from: i  reason: collision with root package name */
    public final String f12099i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f12100j;

    public v(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12099i = readString;
        this.f12100j = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return l0.a(this.f12099i, vVar.f12099i) && Arrays.equals(this.f12100j, vVar.f12100j);
    }

    public final int hashCode() {
        String str = this.f12099i;
        return Arrays.hashCode(this.f12100j) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return this.f12090h + ": owner=" + this.f12099i;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12099i);
        parcel.writeByteArray(this.f12100j);
    }

    public v(String str, byte[] bArr) {
        super("PRIV");
        this.f12099i = str;
        this.f12100j = bArr;
    }
}
