package xa;

import android.support.v4.media.h;
import db.a;
import db.d;

public abstract class p extends b implements d {

    /* renamed from: o  reason: collision with root package name */
    public final boolean f16813o;

    public p() {
        this.f16813o = false;
    }

    public final a d() {
        if (this.f16813o) {
            return this;
        }
        a aVar = this.f16800h;
        if (aVar != null) {
            return aVar;
        }
        a a10 = a();
        this.f16800h = a10;
        return a10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return c().equals(pVar.c()) && this.f16803k.equals(pVar.f16803k) && this.f16804l.equals(pVar.f16804l) && j.a(this.f16801i, pVar.f16801i);
        } else if (obj instanceof d) {
            return obj.equals(d());
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return this.f16804l.hashCode() + h.e(this.f16803k, c().hashCode() * 31, 31);
    }

    public final String toString() {
        a d10 = d();
        if (d10 != this) {
            return d10.toString();
        }
        return h.p(new StringBuilder("property "), this.f16803k, " (Kotlin reflection is not available)");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        boolean z10 = true;
        this.f16813o = (i10 & 2) != 2 ? false : z10;
    }
}
