package z1;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final long f17362a;

    /* renamed from: b  reason: collision with root package name */
    public final long f17363b;

    public a(long j10, long j11) {
        this.f17362a = j10;
        this.f17363b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f17362a == aVar.f17362a && this.f17363b == aVar.f17363b;
    }

    public final int hashCode() {
        return (((int) this.f17362a) * 31) + ((int) this.f17363b);
    }
}
