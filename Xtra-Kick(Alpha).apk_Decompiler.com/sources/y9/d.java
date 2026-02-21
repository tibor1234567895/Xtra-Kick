package y9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import la.q;
import xa.j;

public final class d implements Parcelable, Serializable {
    public static final c CREATOR = new c(0);

    /* renamed from: h  reason: collision with root package name */
    public int f17241h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f17242i = -1;

    /* renamed from: j  reason: collision with root package name */
    public long f17243j = -1;

    /* renamed from: k  reason: collision with root package name */
    public long f17244k = -1;

    /* renamed from: l  reason: collision with root package name */
    public long f17245l = -1;

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<d> cls2 = d.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!j.a(cls2, cls)) {
            return false;
        }
        if (obj != null) {
            d dVar = (d) obj;
            if (this.f17241h == dVar.f17241h && this.f17242i == dVar.f17242i && this.f17243j == dVar.f17243j && this.f17244k == dVar.f17244k && this.f17245l == dVar.f17245l) {
                return true;
            }
            return false;
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2core.DownloadBlockInfo");
    }

    public final int hashCode() {
        int hashCode = Long.valueOf(this.f17243j).hashCode();
        int hashCode2 = Long.valueOf(this.f17244k).hashCode();
        return Long.valueOf(this.f17245l).hashCode() + ((hashCode2 + ((hashCode + (((this.f17241h * 31) + this.f17242i) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DownloadBlock(downloadId=" + this.f17241h + ", blockPosition=" + this.f17242i + ", startByte=" + this.f17243j + ", endByte=" + this.f17244k + ", downloadedBytes=" + this.f17245l + ')';
    }

    public final void u(int i10) {
        this.f17242i = i10;
    }

    public final void v(int i10) {
        this.f17241h = i10;
    }

    public final void w(long j10) {
        this.f17245l = j10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        j.g("dest", parcel);
        parcel.writeInt(this.f17241h);
        parcel.writeInt(this.f17242i);
        parcel.writeLong(this.f17243j);
        parcel.writeLong(this.f17244k);
        parcel.writeLong(this.f17245l);
    }

    public final void x(long j10) {
        this.f17244k = j10;
    }

    public final void y(long j10) {
        this.f17243j = j10;
    }
}
