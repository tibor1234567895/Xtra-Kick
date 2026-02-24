package q2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.b0;

public final class o extends c {
    public static final Parcelable.Creator<o> CREATOR = new n();

    /* renamed from: h  reason: collision with root package name */
    public final long f13321h;

    /* renamed from: i  reason: collision with root package name */
    public final long f13322i;

    public o(long j10, long j11) {
        this.f13321h = j10;
        this.f13322i = j11;
    }

    public static long u(long j10, b0 b0Var) {
        long v10 = (long) b0Var.v();
        if ((128 & v10) != 0) {
            return 8589934591L & ((((v10 & 1) << 32) | b0Var.w()) + j10);
        }
        return -9223372036854775807L;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f13321h);
        parcel.writeLong(this.f13322i);
    }
}
