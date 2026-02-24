package q1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new x();

    /* renamed from: h  reason: collision with root package name */
    public final int f13276h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13277i;

    /* renamed from: j  reason: collision with root package name */
    public final String f13278j;

    /* renamed from: k  reason: collision with root package name */
    public final String f13279k;

    /* renamed from: l  reason: collision with root package name */
    public final String f13280l;

    /* renamed from: m  reason: collision with root package name */
    public final String f13281m;

    public y(int i10, int i11, String str, String str2, String str3, String str4) {
        this.f13276h = i10;
        this.f13277i = i11;
        this.f13278j = str;
        this.f13279k = str2;
        this.f13280l = str3;
        this.f13281m = str4;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f13276h == yVar.f13276h && this.f13277i == yVar.f13277i && TextUtils.equals(this.f13278j, yVar.f13278j) && TextUtils.equals(this.f13279k, yVar.f13279k) && TextUtils.equals(this.f13280l, yVar.f13280l) && TextUtils.equals(this.f13281m, yVar.f13281m);
    }

    public final int hashCode() {
        int i10 = ((this.f13276h * 31) + this.f13277i) * 31;
        int i11 = 0;
        String str = this.f13278j;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13279k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13280l;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f13281m;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f13276h);
        parcel.writeInt(this.f13277i);
        parcel.writeString(this.f13278j);
        parcel.writeString(this.f13279k);
        parcel.writeString(this.f13280l);
        parcel.writeString(this.f13281m);
    }

    public y(Parcel parcel) {
        this.f13276h = parcel.readInt();
        this.f13277i = parcel.readInt();
        this.f13278j = parcel.readString();
        this.f13279k = parcel.readString();
        this.f13280l = parcel.readString();
        this.f13281m = parcel.readString();
    }
}
