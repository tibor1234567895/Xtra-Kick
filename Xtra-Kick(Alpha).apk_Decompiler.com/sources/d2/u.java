package d2;

import g1.a0;
import g1.p;
import j1.b0;
import java.io.EOFException;

public final class u implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4299a = new byte[4096];

    public final void a(a0 a0Var) {
    }

    public final void b(int i10, b0 b0Var) {
        b0Var.H(i10);
    }

    public final int c(p pVar, int i10, boolean z10) {
        return f(pVar, i10, z10);
    }

    public final void d(int i10, b0 b0Var) {
        b0Var.H(i10);
    }

    public final void e(long j10, int i10, int i11, int i12, w0 w0Var) {
    }

    public final int f(p pVar, int i10, boolean z10) {
        byte[] bArr = this.f4299a;
        int o10 = pVar.o(bArr, 0, Math.min(bArr.length, i10));
        if (o10 != -1) {
            return o10;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }
}
