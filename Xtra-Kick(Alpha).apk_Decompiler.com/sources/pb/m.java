package pb;

import android.support.v4.media.h;
import bc.e;
import java.util.Iterator;
import java.util.Set;
import ma.b0;
import ma.z;
import wa.a;
import xa.j;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    public static final l f12899c = new l(0);

    /* renamed from: d  reason: collision with root package name */
    public static final m f12900d = new m(z.N(new k().f12890a), (e) null);

    /* renamed from: a  reason: collision with root package name */
    public final Set f12901a;

    /* renamed from: b  reason: collision with root package name */
    public final e f12902b;

    public m(Set set, e eVar) {
        j.f("pins", set);
        this.f12901a = set;
        this.f12902b = eVar;
    }

    public final void a(String str, a aVar) {
        j.f("hostname", str);
        b0 b0Var = b0.f10801h;
        Iterator it = this.f12901a.iterator();
        if (!it.hasNext()) {
            b0Var.getClass();
        } else {
            h.y(it.next());
            throw null;
        }
    }

    public final m b(e eVar) {
        return j.a(this.f12902b, eVar) ? this : new m(this.f12901a, eVar);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            return j.a(mVar.f12901a, this.f12901a) && j.a(mVar.f12902b, this.f12902b);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f12901a.hashCode() + 1517) * 41;
        e eVar = this.f12902b;
        return hashCode + (eVar != null ? eVar.hashCode() : 0);
    }
}
