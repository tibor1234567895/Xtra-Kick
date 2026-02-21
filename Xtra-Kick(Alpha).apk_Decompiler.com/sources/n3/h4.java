package n3;

import xa.j;

public final class h4 extends l4 {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f11231a;

    public h4(Throwable th) {
        super(0);
        this.f11231a = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h4) && j.a(this.f11231a, ((h4) obj).f11231a);
    }

    public final int hashCode() {
        return this.f11231a.hashCode();
    }

    public final String toString() {
        return "Error(throwable=" + this.f11231a + ')';
    }
}
