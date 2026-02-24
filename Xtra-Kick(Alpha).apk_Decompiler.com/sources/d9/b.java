package d9;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class b extends t implements Serializable {

    /* renamed from: l  reason: collision with root package name */
    public final transient Map f4592l;

    /* renamed from: m  reason: collision with root package name */
    public transient int f4593m;

    public b(Map map) {
        if (map.isEmpty()) {
            this.f4592l = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final Map a() {
        return super.a();
    }

    public final r c() {
        return new r(this);
    }

    public final Collection e() {
        return super.e();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final c f() {
        return new c(this, 1);
    }

    public final Iterator g() {
        return new c(this, 0);
    }

    public final void h() {
        Map map = this.f4592l;
        for (Collection clear : map.values()) {
            clear.clear();
        }
        map.clear();
        this.f4593m = 0;
    }

    public final s i() {
        return new s(0, this);
    }

    public final Collection j() {
        Collection collection = this.f4668j;
        if (collection != null) {
            return collection;
        }
        s i10 = i();
        this.f4668j = i10;
        return i10;
    }
}
