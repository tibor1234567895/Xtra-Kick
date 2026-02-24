package d2;

public final class v0 {

    /* renamed from: c  reason: collision with root package name */
    public static final v0 f4300c = new v0(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f4301a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4302b;

    public v0(long j10, long j11) {
        this.f4301a = j10;
        this.f4302b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f4301a == v0Var.f4301a && this.f4302b == v0Var.f4302b;
    }

    public final int hashCode() {
        return (((int) this.f4301a) * 31) + ((int) this.f4302b);
    }

    public final String toString() {
        return "[timeUs=" + this.f4301a + ", position=" + this.f4302b + "]";
    }
}
