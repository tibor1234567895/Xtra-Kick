package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;

public final class f extends p {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* renamed from: i  reason: collision with root package name */
    public final String f12067i;

    /* renamed from: j  reason: collision with root package name */
    public final int f12068j;

    /* renamed from: k  reason: collision with root package name */
    public final int f12069k;

    /* renamed from: l  reason: collision with root package name */
    public final long f12070l;

    /* renamed from: m  reason: collision with root package name */
    public final long f12071m;

    /* renamed from: n  reason: collision with root package name */
    public final p[] f12072n;

    public f(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12067i = readString;
        this.f12068j = parcel.readInt();
        this.f12069k = parcel.readInt();
        this.f12070l = parcel.readLong();
        this.f12071m = parcel.readLong();
        int readInt = parcel.readInt();
        this.f12072n = new p[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            this.f12072n[i11] = (p) parcel.readParcelable(p.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f12068j == fVar.f12068j && this.f12069k == fVar.f12069k && this.f12070l == fVar.f12070l && this.f12071m == fVar.f12071m && l0.a(this.f12067i, fVar.f12067i) && Arrays.equals(this.f12072n, fVar.f12072n);
    }

    public final int hashCode() {
        int i10 = (((((((527 + this.f12068j) * 31) + this.f12069k) * 31) + ((int) this.f12070l)) * 31) + ((int) this.f12071m)) * 31;
        String str = this.f12067i;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12067i);
        parcel.writeInt(this.f12068j);
        parcel.writeInt(this.f12069k);
        parcel.writeLong(this.f12070l);
        parcel.writeLong(this.f12071m);
        p[] pVarArr = this.f12072n;
        parcel.writeInt(pVarArr.length);
        for (p writeParcelable : pVarArr) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public f(String str, int i10, int i11, long j10, long j11, p[] pVarArr) {
        super("CHAP");
        this.f12067i = str;
        this.f12068j = i10;
        this.f12069k = i11;
        this.f12070l = j10;
        this.f12071m = j11;
        this.f12072n = pVarArr;
    }
}
