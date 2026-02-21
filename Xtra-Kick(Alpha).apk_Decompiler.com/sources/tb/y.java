package tb;

import xa.j;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final z f15038a;

    /* renamed from: b  reason: collision with root package name */
    public final z f15039b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f15040c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(z zVar, d dVar, Throwable th, int i10) {
        this(zVar, (i10 & 2) != 0 ? null : dVar, (i10 & 4) != 0 ? null : th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return j.a(this.f15038a, yVar.f15038a) && j.a(this.f15039b, yVar.f15039b) && j.a(this.f15040c, yVar.f15040c);
    }

    public final int hashCode() {
        int hashCode = this.f15038a.hashCode() * 31;
        int i10 = 0;
        z zVar = this.f15039b;
        int hashCode2 = (hashCode + (zVar == null ? 0 : zVar.hashCode())) * 31;
        Throwable th = this.f15040c;
        if (th != null) {
            i10 = th.hashCode();
        }
        return hashCode2 + i10;
    }

    public final String toString() {
        return "ConnectResult(plan=" + this.f15038a + ", nextPlan=" + this.f15039b + ", throwable=" + this.f15040c + ')';
    }

    public y(z zVar, z zVar2, Throwable th) {
        j.f("plan", zVar);
        this.f15038a = zVar;
        this.f15039b = zVar2;
        this.f15040c = th;
    }
}
