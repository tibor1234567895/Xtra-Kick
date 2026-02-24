package jb;

import xa.j;

public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f8922a;

    public h(Throwable th) {
        this.f8922a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (j.a(this.f8922a, ((h) obj).f8922a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f8922a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Closed(" + this.f8922a + ')';
    }
}
