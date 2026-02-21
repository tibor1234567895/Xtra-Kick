package h3;

import d9.r0;
import g9.d;
import j1.l0;
import java.util.List;

public final class f2 {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f7023a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7024b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7025c;

    public f2(int i10, long j10, List list) {
        this.f7023a = r0.j(list);
        this.f7024b = i10;
        this.f7025c = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return this.f7023a.equals(f2Var.f7023a) && l0.a(Integer.valueOf(this.f7024b), Integer.valueOf(f2Var.f7024b)) && l0.a(Long.valueOf(this.f7025c), Long.valueOf(f2Var.f7025c));
    }

    public final int hashCode() {
        return d.a(this.f7025c) + (((this.f7023a.hashCode() * 31) + this.f7024b) * 31);
    }
}
