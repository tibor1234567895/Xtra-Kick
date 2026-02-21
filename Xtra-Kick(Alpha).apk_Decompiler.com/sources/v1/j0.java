package v1;

import l1.h;
import m1.w0;

public final class j0 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f15680a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15681b;

    public j0(b1 b1Var, long j10) {
        this.f15680a = b1Var;
        this.f15681b = j10;
    }

    public final int a(w0 w0Var, h hVar, int i10) {
        int a10 = this.f15680a.a(w0Var, hVar, i10);
        if (a10 == -4) {
            hVar.f9517l = Math.max(0, hVar.f9517l + this.f15681b);
        }
        return a10;
    }

    public final boolean b() {
        return this.f15680a.b();
    }

    public final void c() {
        this.f15680a.c();
    }

    public final int d(long j10) {
        return this.f15680a.d(j10 - this.f15681b);
    }
}
