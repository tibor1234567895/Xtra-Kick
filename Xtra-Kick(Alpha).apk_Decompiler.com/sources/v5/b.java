package v5;

import b5.j;
import java.security.MessageDigest;
import w5.n;

public final class b implements j {

    /* renamed from: b  reason: collision with root package name */
    public final Object f15928b;

    public b(Object obj) {
        n.b(obj);
        this.f15928b = obj;
    }

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f15928b.toString().getBytes(j.f2629a));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f15928b.equals(((b) obj).f15928b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15928b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f15928b + '}';
    }
}
