package pb;

import hb.h0;
import java.nio.charset.Charset;
import la.i;
import qb.d;
import qb.f;
import xa.j;

public final class n1 {
    private n1() {
    }

    public /* synthetic */ n1(int i10) {
        this();
    }

    public static d a(String str, x0 x0Var) {
        j.f("<this>", str);
        i z10 = h0.z(x0Var);
        byte[] bytes = str.getBytes((Charset) z10.f9799h);
        j.e("this as java.lang.String).getBytes(charset)", bytes);
        return b(bytes, (x0) z10.f9800i, 0, bytes.length);
    }

    public static d b(byte[] bArr, x0 x0Var, int i10, int i11) {
        j.f("<this>", bArr);
        f.a((long) bArr.length, (long) i10, (long) i11);
        return new d(x0Var, bArr, i11, i10);
    }

    public static /* synthetic */ d c(n1 n1Var, byte[] bArr, x0 x0Var, int i10, int i11) {
        if ((i11 & 1) != 0) {
            x0Var = null;
        }
        int i12 = 0;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            i12 = bArr.length;
        }
        n1Var.getClass();
        return b(bArr, x0Var, i10, i12);
    }
}
