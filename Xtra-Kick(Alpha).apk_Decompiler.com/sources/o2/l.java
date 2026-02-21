package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;

public final class l extends p {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* renamed from: i  reason: collision with root package name */
    public final String f12081i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12082j;

    /* renamed from: k  reason: collision with root package name */
    public final String f12083k;

    /* renamed from: l  reason: collision with root package name */
    public final byte[] f12084l;

    public l(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12081i = readString;
        this.f12082j = parcel.readString();
        this.f12083k = parcel.readString();
        this.f12084l = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return l0.a(this.f12081i, lVar.f12081i) && l0.a(this.f12082j, lVar.f12082j) && l0.a(this.f12083k, lVar.f12083k) && Arrays.equals(this.f12084l, lVar.f12084l);
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f12081i;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12082j;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12083k;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return Arrays.hashCode(this.f12084l) + ((hashCode2 + i10) * 31);
    }

    public final String toString() {
        return this.f12090h + ": mimeType=" + this.f12081i + ", filename=" + this.f12082j + ", description=" + this.f12083k;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12081i);
        parcel.writeString(this.f12082j);
        parcel.writeString(this.f12083k);
        parcel.writeByteArray(this.f12084l);
    }

    public l(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f12081i = str;
        this.f12082j = str2;
        this.f12083k = str3;
        this.f12084l = bArr;
    }
}
