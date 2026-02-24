package o2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import j1.l0;

public final class z extends p {
    public static final Parcelable.Creator<z> CREATOR = new y();

    /* renamed from: i  reason: collision with root package name */
    public final String f12103i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12104j;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = j1.l0.f8453a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.f12103i = r0
            java.lang.String r3 = r3.readString()
            r2.f12104j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.z.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f12090h.equals(zVar.f12090h) && l0.a(this.f12103i, zVar.f12103i) && l0.a(this.f12104j, zVar.f12104j);
    }

    public final int hashCode() {
        int i10;
        int e10 = h.e(this.f12090h, 527, 31);
        int i11 = 0;
        String str = this.f12103i;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (e10 + i10) * 31;
        String str2 = this.f12104j;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    public final String toString() {
        return this.f12090h + ": url=" + this.f12104j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12090h);
        parcel.writeString(this.f12103i);
        parcel.writeString(this.f12104j);
    }

    public z(String str, String str2, String str3) {
        super(str);
        this.f12103i = str2;
        this.f12104j = str3;
    }
}
