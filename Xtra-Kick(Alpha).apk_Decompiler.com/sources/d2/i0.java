package d2;

import g1.z0;
import i1.c;
import j1.b0;
import java.io.EOFException;
import o2.o;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f4203a = new b0(10);

    public final z0 a(w wVar, c cVar) {
        b0 b0Var = this.f4203a;
        z0 z0Var = null;
        int i10 = 0;
        while (true) {
            try {
                wVar.m(b0Var.f8414a, 0, 10);
                b0Var.G(0);
                if (b0Var.x() != 4801587) {
                    break;
                }
                b0Var.H(3);
                int u10 = b0Var.u();
                int i11 = u10 + 10;
                if (z0Var == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(b0Var.f8414a, 0, bArr, 0, 10);
                    wVar.m(bArr, 10, u10);
                    z0Var = new o(cVar).c(i11, bArr);
                } else {
                    wVar.n(u10);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        wVar.f();
        wVar.n(i10);
        return z0Var;
    }
}
