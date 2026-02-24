package d2;

import android.support.v4.media.h;

public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    public final v0 f4297a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f4298b;

    public t0(v0 v0Var, v0 v0Var2) {
        this.f4297a = v0Var;
        this.f4298b = v0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t0.class != obj.getClass()) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f4297a.equals(t0Var.f4297a) && this.f4298b.equals(t0Var.f4298b);
    }

    public final int hashCode() {
        return this.f4298b.hashCode() + (this.f4297a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("[");
        v0 v0Var = this.f4297a;
        sb2.append(v0Var);
        v0 v0Var2 = this.f4298b;
        if (v0Var.equals(v0Var2)) {
            str = "";
        } else {
            str = ", " + v0Var2;
        }
        return h.p(sb2, str, "]");
    }
}
