package q4;

import android.graphics.Bitmap;
import java.util.Map;
import xa.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f13327a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f13328b;

    public e(Bitmap bitmap, Map map) {
        this.f13327a = bitmap;
        this.f13328b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return j.a(this.f13327a, eVar.f13327a) && j.a(this.f13328b, eVar.f13328b);
        }
    }

    public final int hashCode() {
        return this.f13328b.hashCode() + (this.f13327a.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.f13327a + ", extras=" + this.f13328b + ')';
    }
}
