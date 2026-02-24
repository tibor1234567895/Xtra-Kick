package p2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new f();

    /* renamed from: h  reason: collision with root package name */
    public final long f12520h;

    /* renamed from: i  reason: collision with root package name */
    public final long f12521i;

    /* renamed from: j  reason: collision with root package name */
    public final int f12522j;

    public g(int i10, long j10, long j11) {
        a.b(j10 < j11);
        this.f12520h = j10;
        this.f12521i = j11;
        this.f12522j = i10;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f12520h == gVar.f12520h && this.f12521i == gVar.f12521i && this.f12522j == gVar.f12522j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12520h), Long.valueOf(this.f12521i), Integer.valueOf(this.f12522j)});
    }

    public final String toString() {
        return l0.l("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f12520h), Long.valueOf(this.f12521i), Integer.valueOf(this.f12522j));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f12520h);
        parcel.writeLong(this.f12521i);
        parcel.writeInt(this.f12522j);
    }
}
