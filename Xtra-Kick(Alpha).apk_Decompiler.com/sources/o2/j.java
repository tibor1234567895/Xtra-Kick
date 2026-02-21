package o2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;

public final class j extends p {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* renamed from: i  reason: collision with root package name */
    public final String f12078i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12079j;

    /* renamed from: k  reason: collision with root package name */
    public final String f12080k;

    public j(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f12078i = readString;
        this.f12079j = parcel.readString();
        this.f12080k = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return l0.a(this.f12079j, jVar.f12079j) && l0.a(this.f12078i, jVar.f12078i) && l0.a(this.f12080k, jVar.f12080k);
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f12078i;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12079j;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12080k;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }

    public final String toString() {
        return this.f12090h + ": language=" + this.f12078i + ", description=" + this.f12079j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12090h);
        parcel.writeString(this.f12078i);
        parcel.writeString(this.f12080k);
    }

    public j(String str, String str2, String str3) {
        super("COMM");
        this.f12078i = str;
        this.f12079j = str2;
        this.f12080k = str3;
    }
}
