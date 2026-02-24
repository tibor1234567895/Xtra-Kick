package la;

import java.io.Serializable;
import xa.j;

public final class k implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Throwable f9801h;

    public k(Throwable th) {
        j.f("exception", th);
        this.f9801h = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            if (j.a(this.f9801h, ((k) obj).f9801h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9801h.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f9801h + ')';
    }
}
