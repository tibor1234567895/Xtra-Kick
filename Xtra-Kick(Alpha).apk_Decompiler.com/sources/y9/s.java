package y9;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import la.q;
import xa.j;

public final class s extends j {
    public static final r CREATOR = new r(0);

    /* renamed from: j  reason: collision with root package name */
    public final Map f17281j;

    public s() {
        this(new LinkedHashMap());
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((!j.a(s.class, obj != null ? obj.getClass() : null)) || !super.equals(obj)) {
            return false;
        }
        if (obj != null) {
            return !(j.a(this.f17281j, ((s) obj).f17281j) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2core.MutableExtras");
    }

    public final int hashCode() {
        return this.f17281j.hashCode() + (super.hashCode() * 31);
    }

    public final String toString() {
        return u();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        j.g("dest", parcel);
        parcel.writeSerializable(new HashMap(this.f17281j));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Map map) {
        super(map);
        j.g("mutableData", map);
        this.f17281j = map;
    }
}
