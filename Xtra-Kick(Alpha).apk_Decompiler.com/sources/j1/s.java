package j1;

import g1.x;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8472a;

    /* renamed from: b  reason: collision with root package name */
    public x f8473b = new x();

    /* renamed from: c  reason: collision with root package name */
    public boolean f8474c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8475d;

    public s(Object obj) {
        this.f8472a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        return this.f8472a.equals(((s) obj).f8472a);
    }

    public final int hashCode() {
        return this.f8472a.hashCode();
    }
}
