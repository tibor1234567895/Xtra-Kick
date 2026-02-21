package d9;

import java.io.Serializable;

public final class z1 extends p1 implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final p1 f4725h;

    public z1(p1 p1Var) {
        p1Var.getClass();
        this.f4725h = p1Var;
    }

    public final p1 a() {
        return this.f4725h;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f4725h.compare(obj2, obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            return this.f4725h.equals(((z1) obj).f4725h);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f4725h.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4725h);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
        sb2.append(valueOf);
        sb2.append(".reverse()");
        return sb2.toString();
    }
}
