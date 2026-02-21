package d2;

import j1.l0;
import java.util.Arrays;

public final class n implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4242a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f4243b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f4244c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f4245d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f4246e;

    /* renamed from: f  reason: collision with root package name */
    public final long f4247f;

    public n(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f4243b = iArr;
        this.f4244c = jArr;
        this.f4245d = jArr2;
        this.f4246e = jArr3;
        int length = iArr.length;
        this.f4242a = length;
        if (length > 0) {
            this.f4247f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f4247f = 0;
        }
    }

    public final boolean f() {
        return true;
    }

    public final t0 i(long j10) {
        long[] jArr = this.f4246e;
        int f10 = l0.f(jArr, j10, true);
        long j11 = jArr[f10];
        long[] jArr2 = this.f4244c;
        v0 v0Var = new v0(j11, jArr2[f10]);
        if (j11 >= j10 || f10 == this.f4242a - 1) {
            return new t0(v0Var, v0Var);
        }
        int i10 = f10 + 1;
        return new t0(v0Var, new v0(jArr[i10], jArr2[i10]));
    }

    public final long j() {
        return this.f4247f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f4242a + ", sizes=" + Arrays.toString(this.f4243b) + ", offsets=" + Arrays.toString(this.f4244c) + ", timeUs=" + Arrays.toString(this.f4246e) + ", durationsUs=" + Arrays.toString(this.f4245d) + ")";
    }
}
