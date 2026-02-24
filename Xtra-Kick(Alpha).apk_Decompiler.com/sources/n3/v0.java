package n3;

import j3.w0;
import kb.s0;
import xa.j;

public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final w0 f11516a = new w0(this);

    public final s0 a(d1 d1Var) {
        j.f("loadType", d1Var);
        int ordinal = d1Var.ordinal();
        w0 w0Var = this.f11516a;
        if (ordinal == 1) {
            return ((s0) w0Var.f8714a).f11472b;
        }
        if (ordinal == 2) {
            return ((s0) w0Var.f8715b).f11472b;
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }
}
