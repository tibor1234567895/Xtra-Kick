package d2;

import j1.a;
import j1.l0;

public final class j0 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f4208a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f4209b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4210c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4211d;

    public j0(long j10, long[] jArr, long[] jArr2) {
        a.b(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z10 = length > 0;
        this.f4211d = z10;
        if (!z10 || jArr2[0] <= 0) {
            this.f4208a = jArr;
            this.f4209b = jArr2;
        } else {
            int i10 = length + 1;
            long[] jArr3 = new long[i10];
            this.f4208a = jArr3;
            long[] jArr4 = new long[i10];
            this.f4209b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f4210c = j10;
    }

    public final boolean f() {
        return this.f4211d;
    }

    public final t0 i(long j10) {
        if (!this.f4211d) {
            v0 v0Var = v0.f4300c;
            return new t0(v0Var, v0Var);
        }
        long[] jArr = this.f4209b;
        int f10 = l0.f(jArr, j10, true);
        long j11 = jArr[f10];
        long[] jArr2 = this.f4208a;
        v0 v0Var2 = new v0(j11, jArr2[f10]);
        if (j11 == j10 || f10 == jArr.length - 1) {
            return new t0(v0Var2, v0Var2);
        }
        int i10 = f10 + 1;
        return new t0(v0Var2, new v0(jArr[i10], jArr2[i10]));
    }

    public final long j() {
        return this.f4210c;
    }
}
