package g1;

import android.os.Parcel;
import android.os.Parcelable;
import g9.d;
import java.util.Arrays;
import java.util.List;

public final class z0 implements Parcelable {
    public static final Parcelable.Creator<z0> CREATOR = new x0();

    /* renamed from: h  reason: collision with root package name */
    public final y0[] f6770h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6771i;

    public z0(long j10, y0... y0VarArr) {
        this.f6771i = j10;
        this.f6770h = y0VarArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z0.class != obj.getClass()) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return Arrays.equals(this.f6770h, z0Var.f6770h) && this.f6771i == z0Var.f6771i;
    }

    public final int hashCode() {
        return d.a(this.f6771i) + (Arrays.hashCode(this.f6770h) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("entries=");
        sb2.append(Arrays.toString(this.f6770h));
        long j10 = this.f6771i;
        if (j10 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j10;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        y0[] y0VarArr = this.f6770h;
        parcel.writeInt(y0VarArr.length);
        for (y0 writeParcelable : y0VarArr) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.f6771i);
    }

    public z0(Parcel parcel) {
        this.f6770h = new y0[parcel.readInt()];
        int i10 = 0;
        while (true) {
            y0[] y0VarArr = this.f6770h;
            if (i10 < y0VarArr.length) {
                y0VarArr[i10] = (y0) parcel.readParcelable(y0.class.getClassLoader());
                i10++;
            } else {
                this.f6771i = parcel.readLong();
                return;
            }
        }
    }

    public z0(List list) {
        this((y0[]) list.toArray(new y0[0]));
    }

    public z0(y0... y0VarArr) {
        this(-9223372036854775807L, y0VarArr);
    }
}
