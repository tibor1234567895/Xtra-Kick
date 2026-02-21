package n2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;
import java.util.Arrays;

public final class e implements y0 {
    public static final Parcelable.Creator<e> CREATOR = new d();

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f11031h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11032i;

    /* renamed from: j  reason: collision with root package name */
    public final String f11033j;

    public e(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        createByteArray.getClass();
        this.f11031h = createByteArray;
        this.f11032i = parcel.readString();
        this.f11033j = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f11031h, ((e) obj).f11031h);
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final void h(u0 u0Var) {
        String str = this.f11032i;
        if (str != null) {
            u0Var.f6596a = str;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f11031h);
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.f11032i, this.f11033j, Integer.valueOf(this.f11031h.length)});
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(this.f11031h);
        parcel.writeString(this.f11032i);
        parcel.writeString(this.f11033j);
    }

    public e(byte[] bArr, String str, String str2) {
        this.f11031h = bArr;
        this.f11032i = str;
        this.f11033j = str2;
    }
}
