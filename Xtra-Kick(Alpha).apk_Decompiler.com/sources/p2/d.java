package p2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;

public final class d implements y0 {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* renamed from: h  reason: collision with root package name */
    public final long f12515h;

    /* renamed from: i  reason: collision with root package name */
    public final long f12516i;

    /* renamed from: j  reason: collision with root package name */
    public final long f12517j;

    /* renamed from: k  reason: collision with root package name */
    public final long f12518k;

    /* renamed from: l  reason: collision with root package name */
    public final long f12519l;

    public d(long j10, long j11, long j12, long j13, long j14) {
        this.f12515h = j10;
        this.f12516i = j11;
        this.f12517j = j12;
        this.f12518k = j13;
        this.f12519l = j14;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f12515h == dVar.f12515h && this.f12516i == dVar.f12516i && this.f12517j == dVar.f12517j && this.f12518k == dVar.f12518k && this.f12519l == dVar.f12519l;
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        int a10 = g9.d.a(this.f12516i);
        int a11 = g9.d.a(this.f12517j);
        int a12 = g9.d.a(this.f12518k);
        return g9.d.a(this.f12519l) + ((a12 + ((a11 + ((a10 + ((g9.d.a(this.f12515h) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f12515h + ", photoSize=" + this.f12516i + ", photoPresentationTimestampUs=" + this.f12517j + ", videoStartPosition=" + this.f12518k + ", videoSize=" + this.f12519l;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f12515h);
        parcel.writeLong(this.f12516i);
        parcel.writeLong(this.f12517j);
        parcel.writeLong(this.f12518k);
        parcel.writeLong(this.f12519l);
    }

    public d(Parcel parcel) {
        this.f12515h = parcel.readLong();
        this.f12516i = parcel.readLong();
        this.f12517j = parcel.readLong();
        this.f12518k = parcel.readLong();
        this.f12519l = parcel.readLong();
    }
}
