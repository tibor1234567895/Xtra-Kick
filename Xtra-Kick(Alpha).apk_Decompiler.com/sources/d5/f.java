package d5;

import b5.j;
import java.security.MessageDigest;

public final class f implements j {

    /* renamed from: b  reason: collision with root package name */
    public final j f4381b;

    /* renamed from: c  reason: collision with root package name */
    public final j f4382c;

    public f(j jVar, j jVar2) {
        this.f4381b = jVar;
        this.f4382c = jVar2;
    }

    public final void b(MessageDigest messageDigest) {
        this.f4381b.b(messageDigest);
        this.f4382c.b(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f4381b.equals(fVar.f4381b) && this.f4382c.equals(fVar.f4382c);
    }

    public final int hashCode() {
        return this.f4382c.hashCode() + (this.f4381b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f4381b + ", signature=" + this.f4382c + '}';
    }
}
