package v2;

import d2.t0;
import d2.u0;
import d2.v0;
import j1.l0;

public final class a implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f15837a;

    public a(b bVar) {
        this.f15837a = bVar;
    }

    public final boolean f() {
        return true;
    }

    public final t0 i(long j10) {
        b bVar = this.f15837a;
        long j11 = bVar.f15839b;
        long j12 = bVar.f15840c;
        v0 v0Var = new v0(j10, l0.i(((((j12 - j11) * ((((long) bVar.f15841d.f15884i) * j10) / 1000000)) / bVar.f15843f) + j11) - 30000, j11, j12 - 1));
        return new t0(v0Var, v0Var);
    }

    public final long j() {
        b bVar = this.f15837a;
        return (bVar.f15843f * 1000000) / ((long) bVar.f15841d.f15884i);
    }
}
