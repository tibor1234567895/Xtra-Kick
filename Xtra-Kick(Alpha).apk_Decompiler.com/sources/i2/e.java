package i2;

import d2.t0;
import d2.u0;
import d2.v0;

public final class e implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f8018a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f8019b;

    public e(f fVar, u0 u0Var) {
        this.f8019b = fVar;
        this.f8018a = u0Var;
    }

    public final boolean f() {
        return this.f8018a.f();
    }

    public final t0 i(long j10) {
        t0 i10 = this.f8018a.i(j10);
        v0 v0Var = i10.f4297a;
        long j11 = v0Var.f4301a;
        long j12 = v0Var.f4302b;
        long j13 = this.f8019b.f8020h;
        v0 v0Var2 = new v0(j11, j12 + j13);
        v0 v0Var3 = i10.f4298b;
        return new t0(v0Var2, new v0(v0Var3.f4301a, v0Var3.f4302b + j13));
    }

    public final long j() {
        return this.f8018a.j();
    }
}
