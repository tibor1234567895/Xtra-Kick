package v2;

import android.support.v4.media.n;
import d2.e0;
import d2.f0;
import d2.u0;
import d2.w;
import j1.a;
import j1.l0;

public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f15850a;

    /* renamed from: b  reason: collision with root package name */
    public final n f15851b;

    /* renamed from: c  reason: collision with root package name */
    public long f15852c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f15853d = -1;

    public c(f0 f0Var, n nVar) {
        this.f15850a = f0Var;
        this.f15851b = nVar;
    }

    public final u0 a() {
        a.e(this.f15852c != -1);
        return new e0(0, this.f15852c, this.f15850a);
    }

    public final long b(w wVar) {
        long j10 = this.f15853d;
        if (j10 < 0) {
            return -1;
        }
        long j11 = -(j10 + 2);
        this.f15853d = -1;
        return j11;
    }

    public final void c(long j10) {
        long[] jArr = (long[]) this.f15851b.f337i;
        this.f15853d = jArr[l0.f(jArr, j10, true)];
    }
}
