package w5;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public Class f16122a;

    /* renamed from: b  reason: collision with root package name */
    public Class f16123b;

    /* renamed from: c  reason: collision with root package name */
    public Class f16124c;

    public m() {
    }

    public m(Class cls, Class cls2, Class cls3) {
        this.f16122a = cls;
        this.f16123b = cls2;
        this.f16124c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f16122a.equals(mVar.f16122a) && this.f16123b.equals(mVar.f16123b) && p.b(this.f16124c, mVar.f16124c);
    }

    public final int hashCode() {
        int hashCode = (this.f16123b.hashCode() + (this.f16122a.hashCode() * 31)) * 31;
        Class cls = this.f16124c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f16122a + ", second=" + this.f16123b + '}';
    }
}
