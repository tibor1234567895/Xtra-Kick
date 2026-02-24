package o2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.u0;
import j1.l0;
import java.util.Arrays;

public final class b extends p {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: i  reason: collision with root package name */
    public final String f12062i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12063j;

    /* renamed from: k  reason: collision with root package name */
    public final int f12064k;

    /* renamed from: l  reason: collision with root package name */
    public final byte[] f12065l;

    public b(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12062i = readString;
        this.f12063j = parcel.readString();
        this.f12064k = parcel.readInt();
        this.f12065l = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12064k == bVar.f12064k && l0.a(this.f12062i, bVar.f12062i) && l0.a(this.f12063j, bVar.f12063j) && Arrays.equals(this.f12065l, bVar.f12065l);
    }

    public final void h(u0 u0Var) {
        u0Var.a(this.f12064k, this.f12065l);
    }

    public final int hashCode() {
        int i10 = (527 + this.f12064k) * 31;
        int i11 = 0;
        String str = this.f12062i;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12063j;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return Arrays.hashCode(this.f12065l) + ((hashCode + i11) * 31);
    }

    public final String toString() {
        return this.f12090h + ": mimeType=" + this.f12062i + ", description=" + this.f12063j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12062i);
        parcel.writeString(this.f12063j);
        parcel.writeInt(this.f12064k);
        parcel.writeByteArray(this.f12065l);
    }

    public b(String str, String str2, int i10, byte[] bArr) {
        super("APIC");
        this.f12062i = str;
        this.f12063j = str2;
        this.f12064k = i10;
        this.f12065l = bArr;
    }
}
