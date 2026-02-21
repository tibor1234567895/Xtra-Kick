package p9;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import java.util.HashMap;
import la.q;
import ma.j0;
import xa.j;

public final class u extends v implements Parcelable {
    public static final t CREATOR = new t(0);

    /* renamed from: r  reason: collision with root package name */
    public final int f12719r;

    /* renamed from: s  reason: collision with root package name */
    public final String f12720s;

    /* renamed from: t  reason: collision with root package name */
    public final String f12721t;

    public u(String str, String str2) {
        j.g("url", str);
        j.g("file", str2);
        this.f12720s = str;
        this.f12721t = str2;
        this.f12719r = str2.hashCode() + (str.hashCode() * 31);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((!j.a(u.class, obj != null ? obj.getClass() : null)) || !super.equals(obj)) {
            return false;
        }
        if (obj != null) {
            u uVar = (u) obj;
            return this.f12719r == uVar.f12719r && !(j.a(this.f12720s, uVar.f12720s) ^ true) && !(j.a(this.f12721t, uVar.f12721t) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2.Request");
    }

    public final int hashCode() {
        return this.f12721t.hashCode() + h.e(this.f12720s, ((super.hashCode() * 31) + this.f12719r) * 31, 31);
    }

    public final String toString() {
        return "Request(url='" + this.f12720s + "', file='" + this.f12721t + "', id=" + this.f12719r + ", groupId=" + this.f12723i + ", headers=" + this.f12724j + ", priority=" + this.f12725k + ", networkType=" + this.f12726l + ", tag=" + this.f12727m + ')';
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        j.g("parcel", parcel);
        parcel.writeString(this.f12720s);
        parcel.writeString(this.f12721t);
        parcel.writeLong(this.f12722h);
        parcel.writeInt(this.f12723i);
        parcel.writeSerializable(new HashMap(this.f12724j));
        parcel.writeInt(this.f12725k.f12715h);
        parcel.writeInt(this.f12726l.f12709h);
        parcel.writeString(this.f12727m);
        parcel.writeInt(this.f12728n.f12636h);
        parcel.writeInt(this.f12729o ? 1 : 0);
        parcel.writeSerializable(new HashMap(j0.g(this.f12731q.f17264h)));
        parcel.writeInt(this.f12730p);
    }
}
