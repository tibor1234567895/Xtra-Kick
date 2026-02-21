package y9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import la.q;
import ma.j0;
import org.json.JSONObject;

public class j implements Parcelable, Serializable {
    public static final i CREATOR = new i(0);

    /* renamed from: i  reason: collision with root package name */
    public static final j f17263i = new j(j0.d());

    /* renamed from: h  reason: collision with root package name */
    public final Map f17264h;

    public j(Map map) {
        xa.j.g("data", map);
        this.f17264h = map;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!xa.j.a(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return !(xa.j.a(this.f17264h, ((j) obj).f17264h) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2core.Extras");
    }

    public int hashCode() {
        return this.f17264h.hashCode();
    }

    public String toString() {
        return u();
    }

    public final String u() {
        Map map = this.f17264h;
        if (map.isEmpty()) {
            return "{}";
        }
        String jSONObject = new JSONObject(j0.g(map)).toString();
        xa.j.b("JSONObject(map).toString()", jSONObject);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        xa.j.g("dest", parcel);
        parcel.writeSerializable(new HashMap(this.f17264h));
    }
}
