package xa;

public final class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Class f16812a;

    public l(Class cls) {
        j.f("jClass", cls);
        this.f16812a = cls;
    }

    public final Class a() {
        return this.f16812a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            if (j.a(this.f16812a, ((l) obj).f16812a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f16812a.hashCode();
    }

    public final String toString() {
        return this.f16812a.toString() + " (Kotlin reflection is not available)";
    }
}
