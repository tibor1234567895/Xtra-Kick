package j3;

import xa.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final g2 f8611a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8612b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8613c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8614d;

    public m(g2 g2Var, boolean z10, Object obj, boolean z11) {
        boolean z12 = true;
        if (g2Var.f8551a || !z10) {
            if (!z10 && z11 && obj == null) {
                z12 = false;
            }
            if (z12) {
                this.f8611a = g2Var;
                this.f8612b = z10;
                this.f8614d = obj;
                this.f8613c = z11;
                return;
            }
            throw new IllegalArgumentException(("Argument with type " + g2Var.b() + " has null value but is not nullable.").toString());
        }
        throw new IllegalArgumentException((g2Var.b() + " does not allow nullable values").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.a(m.class, obj.getClass())) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f8612b != mVar.f8612b || this.f8613c != mVar.f8613c || !j.a(this.f8611a, mVar.f8611a)) {
            return false;
        }
        Object obj2 = mVar.f8614d;
        Object obj3 = this.f8614d;
        return obj3 != null ? j.a(obj3, obj2) : obj2 == null;
    }

    public final int hashCode() {
        int hashCode = ((((this.f8611a.hashCode() * 31) + (this.f8612b ? 1 : 0)) * 31) + (this.f8613c ? 1 : 0)) * 31;
        Object obj = this.f8614d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m.class.getSimpleName());
        sb2.append(" Type: " + this.f8611a);
        sb2.append(" Nullable: " + this.f8612b);
        if (this.f8613c) {
            sb2.append(" DefaultValue: " + this.f8614d);
        }
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}
