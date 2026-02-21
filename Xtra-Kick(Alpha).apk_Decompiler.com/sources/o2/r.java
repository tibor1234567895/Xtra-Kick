package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;

public final class r extends p {
    public static final Parcelable.Creator<r> CREATOR = new q();

    /* renamed from: i  reason: collision with root package name */
    public final String f12091i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12092j;

    /* renamed from: k  reason: collision with root package name */
    public final String f12093k;

    public r(Parcel parcel) {
        super("----");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12091i = readString;
        this.f12092j = parcel.readString();
        this.f12093k = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return l0.a(this.f12092j, rVar.f12092j) && l0.a(this.f12091i, rVar.f12091i) && l0.a(this.f12093k, rVar.f12093k);
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f12091i;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12092j;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12093k;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }

    public final String toString() {
        return this.f12090h + ": domain=" + this.f12091i + ", description=" + this.f12092j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12090h);
        parcel.writeString(this.f12091i);
        parcel.writeString(this.f12093k);
    }

    public r(String str, String str2, String str3) {
        super("----");
        this.f12091i = str;
        this.f12092j = str2;
        this.f12093k = str3;
    }
}
