package s4;

import android.support.v4.media.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import la.i;
import ma.j0;
import xa.j;
import ya.a;

public final class p implements Iterable, a {

    /* renamed from: i  reason: collision with root package name */
    public static final p f14292i = new p();

    /* renamed from: h  reason: collision with root package name */
    public final Map f14293h;

    static {
        new o(0);
    }

    public p() {
        this(j0.d());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            if (j.a(this.f14293h, ((p) obj).f14293h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f14293h.hashCode();
    }

    public final Iterator iterator() {
        Map map = this.f14293h;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            h.y(entry.getValue());
            arrayList.add(new i((String) entry.getKey(), (Object) null));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.f14293h + ')';
    }

    public p(Map map) {
        this.f14293h = map;
    }
}
