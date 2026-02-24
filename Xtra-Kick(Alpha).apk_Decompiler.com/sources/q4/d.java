package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import xa.j;

public final class d implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<d> CREATOR = new b();

    /* renamed from: h  reason: collision with root package name */
    public final String f13325h;

    /* renamed from: i  reason: collision with root package name */
    public final Map f13326i;

    static {
        new c(0);
    }

    public d(String str, Map map) {
        this.f13325h = str;
        this.f13326i = map;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return j.a(this.f13325h, dVar.f13325h) && j.a(this.f13326i, dVar.f13326i);
        }
    }

    public final int hashCode() {
        return this.f13326i.hashCode() + (this.f13325h.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.f13325h + ", extras=" + this.f13326i + ')';
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f13325h);
        Map map = this.f13326i;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }
}
