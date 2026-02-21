package h3;

import android.support.v4.media.h;
import e1.c0;
import j1.l0;
import java.util.Arrays;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    public final c0 f6996a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6997b;

    /* renamed from: c  reason: collision with root package name */
    public final d2 f6998c;

    public e2(c0 c0Var, int i10, boolean z10, d2 d2Var) {
        this.f6996a = c0Var;
        this.f6997b = i10;
        this.f6998c = d2Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e2)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        e2 e2Var = (e2) obj;
        d2 d2Var = this.f6998c;
        return (d2Var == null && e2Var.f6998c == null) ? this.f6996a.equals(e2Var.f6996a) : l0.a(d2Var, e2Var.f6998c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6998c, this.f6996a});
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ControllerInfo {pkg=");
        c0 c0Var = this.f6996a;
        sb2.append(c0Var.f4895a.f4909a);
        sb2.append(", uid=");
        return h.o(sb2, c0Var.f4895a.f4911c, "})");
    }
}
