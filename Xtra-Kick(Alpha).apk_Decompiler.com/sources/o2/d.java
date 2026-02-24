package o2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import java.util.Arrays;

public final class d extends p {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: i  reason: collision with root package name */
    public final byte[] f12066i;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = j1.l0.f8453a
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            r2.f12066i = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.d.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f12090h.equals(dVar.f12090h) && Arrays.equals(this.f12066i, dVar.f12066i);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12066i) + h.e(this.f12090h, 527, 31);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12090h);
        parcel.writeByteArray(this.f12066i);
    }

    public d(String str, byte[] bArr) {
        super(str);
        this.f12066i = bArr;
    }
}
