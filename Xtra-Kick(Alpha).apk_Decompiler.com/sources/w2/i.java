package w2;

import java.util.List;

public abstract class i extends l1.i implements d {

    /* renamed from: j  reason: collision with root package name */
    public d f16065j;

    /* renamed from: k  reason: collision with root package name */
    public long f16066k;

    public final int a(long j10) {
        d dVar = this.f16065j;
        dVar.getClass();
        return dVar.a(j10 - this.f16066k);
    }

    public final long b(int i10) {
        d dVar = this.f16065j;
        dVar.getClass();
        return dVar.b(i10) + this.f16066k;
    }

    public final List c(long j10) {
        d dVar = this.f16065j;
        dVar.getClass();
        return dVar.c(j10 - this.f16066k);
    }

    public final int d() {
        d dVar = this.f16065j;
        dVar.getClass();
        return dVar.d();
    }

    public final void i(long j10, d dVar, long j11) {
        this.f9521i = j10;
        this.f16065j = dVar;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.f16066k = j10;
    }
}
