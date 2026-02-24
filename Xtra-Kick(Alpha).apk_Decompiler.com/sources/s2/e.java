package s2;

import d2.p;
import j1.b0;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f14156a = new b0(8);

    /* renamed from: b  reason: collision with root package name */
    public int f14157b;

    public final long a(p pVar) {
        b0 b0Var = this.f14156a;
        int i10 = 0;
        pVar.k(b0Var.f8414a, 0, 1, false);
        byte b10 = b0Var.f8414a[0] & 255;
        if (b10 == 0) {
            return Long.MIN_VALUE;
        }
        int i11 = 128;
        int i12 = 0;
        while ((b10 & i11) == 0) {
            i11 >>= 1;
            i12++;
        }
        int i13 = b10 & (~i11);
        pVar.k(b0Var.f8414a, 1, i12, false);
        while (i10 < i12) {
            i10++;
            i13 = (b0Var.f8414a[i10] & 255) + (i13 << 8);
        }
        this.f14157b = i12 + 1 + this.f14157b;
        return (long) i13;
    }
}
