package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;

public final class t extends p {
    public static final Parcelable.Creator<t> CREATOR = new s();

    /* renamed from: i  reason: collision with root package name */
    public final int f12094i;

    /* renamed from: j  reason: collision with root package name */
    public final int f12095j;

    /* renamed from: k  reason: collision with root package name */
    public final int f12096k;

    /* renamed from: l  reason: collision with root package name */
    public final int[] f12097l;

    /* renamed from: m  reason: collision with root package name */
    public final int[] f12098m;

    public t(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        super("MLLT");
        this.f12094i = i10;
        this.f12095j = i11;
        this.f12096k = i12;
        this.f12097l = iArr;
        this.f12098m = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.f12094i == tVar.f12094i && this.f12095j == tVar.f12095j && this.f12096k == tVar.f12096k && Arrays.equals(this.f12097l, tVar.f12097l) && Arrays.equals(this.f12098m, tVar.f12098m);
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f12097l);
        return Arrays.hashCode(this.f12098m) + ((hashCode + ((((((527 + this.f12094i) * 31) + this.f12095j) * 31) + this.f12096k) * 31)) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f12094i);
        parcel.writeInt(this.f12095j);
        parcel.writeInt(this.f12096k);
        parcel.writeIntArray(this.f12097l);
        parcel.writeIntArray(this.f12098m);
    }

    public t(Parcel parcel) {
        super("MLLT");
        this.f12094i = parcel.readInt();
        this.f12095j = parcel.readInt();
        this.f12096k = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i10 = l0.f8453a;
        this.f12097l = createIntArray;
        this.f12098m = parcel.createIntArray();
    }
}
