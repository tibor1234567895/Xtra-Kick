package e5;

public final class i implements o {

    /* renamed from: a  reason: collision with root package name */
    public final j f5048a;

    /* renamed from: b  reason: collision with root package name */
    public int f5049b;

    /* renamed from: c  reason: collision with root package name */
    public Class f5050c;

    public i(j jVar) {
        this.f5048a = jVar;
    }

    public final void a() {
        this.f5048a.c(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5049b == iVar.f5049b && this.f5050c == iVar.f5050c;
    }

    public final int hashCode() {
        int i10 = this.f5049b * 31;
        Class cls = this.f5050c;
        return i10 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f5049b + "array=" + this.f5050c + '}';
    }
}
