package r3;

import java.util.Arrays;
import la.v;
import xa.j;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f13751a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean[] f13752b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f13753c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13754d;

    static {
        new t(0);
    }

    public u(int i10) {
        this.f13751a = new long[i10];
        this.f13752b = new boolean[i10];
        this.f13753c = new int[i10];
    }

    public final int[] a() {
        synchronized (this) {
            if (!this.f13754d) {
                return null;
            }
            long[] jArr = this.f13751a;
            int length = jArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                int i13 = 1;
                boolean z10 = jArr[i10] > 0;
                boolean[] zArr = this.f13752b;
                if (z10 != zArr[i11]) {
                    int[] iArr = this.f13753c;
                    if (!z10) {
                        i13 = 2;
                    }
                    iArr[i11] = i13;
                } else {
                    this.f13753c[i11] = 0;
                }
                zArr[i11] = z10;
                i10++;
                i11 = i12;
            }
            this.f13754d = false;
            int[] iArr2 = (int[]) this.f13753c.clone();
            return iArr2;
        }
    }

    public final boolean b(int... iArr) {
        boolean z10;
        j.f("tableIds", iArr);
        synchronized (this) {
            z10 = false;
            for (int i10 : iArr) {
                long[] jArr = this.f13751a;
                long j10 = jArr[i10];
                jArr[i10] = 1 + j10;
                if (j10 == 0) {
                    z10 = true;
                    this.f13754d = true;
                }
            }
            v vVar = v.f9814a;
        }
        return z10;
    }

    public final boolean c(int... iArr) {
        boolean z10;
        j.f("tableIds", iArr);
        synchronized (this) {
            z10 = false;
            for (int i10 : iArr) {
                long[] jArr = this.f13751a;
                long j10 = jArr[i10];
                jArr[i10] = j10 - 1;
                if (j10 == 1) {
                    z10 = true;
                    this.f13754d = true;
                }
            }
            v vVar = v.f9814a;
        }
        return z10;
    }

    public final void d() {
        synchronized (this) {
            Arrays.fill(this.f13752b, false);
            this.f13754d = true;
            v vVar = v.f9814a;
        }
    }
}
