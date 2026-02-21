package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;

public final class h extends p {
    public static final Parcelable.Creator<h> CREATOR = new g();

    /* renamed from: i  reason: collision with root package name */
    public final String f12073i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f12074j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f12075k;

    /* renamed from: l  reason: collision with root package name */
    public final String[] f12076l;

    /* renamed from: m  reason: collision with root package name */
    public final p[] f12077m;

    public h(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12073i = readString;
        boolean z10 = true;
        this.f12074j = parcel.readByte() != 0;
        this.f12075k = parcel.readByte() == 0 ? false : z10;
        this.f12076l = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f12077m = new p[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            this.f12077m[i11] = (p) parcel.readParcelable(p.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f12074j == hVar.f12074j && this.f12075k == hVar.f12075k && l0.a(this.f12073i, hVar.f12073i) && Arrays.equals(this.f12076l, hVar.f12076l) && Arrays.equals(this.f12077m, hVar.f12077m);
    }

    public final int hashCode() {
        int i10 = (((true + (this.f12074j ? 1 : 0)) * 31) + (this.f12075k ? 1 : 0)) * 31;
        String str = this.f12073i;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12073i);
        parcel.writeByte(this.f12074j ? (byte) 1 : 0);
        parcel.writeByte(this.f12075k ? (byte) 1 : 0);
        parcel.writeStringArray(this.f12076l);
        p[] pVarArr = this.f12077m;
        parcel.writeInt(pVarArr.length);
        for (p writeParcelable : pVarArr) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public h(String str, boolean z10, boolean z11, String[] strArr, p[] pVarArr) {
        super("CTOC");
        this.f12073i = str;
        this.f12074j = z10;
        this.f12075k = z11;
        this.f12076l = strArr;
        this.f12077m = pVarArr;
    }
}
