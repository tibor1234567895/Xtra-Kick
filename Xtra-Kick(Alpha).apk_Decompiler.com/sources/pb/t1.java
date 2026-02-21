package pb;

import dc.l;
import hb.h0;
import java.nio.charset.Charset;
import la.i;
import qb.e;
import xa.j;

public final class t1 {
    private t1() {
    }

    public /* synthetic */ t1(int i10) {
        this();
    }

    public static e a(l lVar, x0 x0Var, long j10) {
        j.f("<this>", lVar);
        return new e(x0Var, j10, lVar);
    }

    public static e b(String str, x0 x0Var) {
        j.f("<this>", str);
        i z10 = h0.z(x0Var);
        Charset charset = (Charset) z10.f9799h;
        dc.j jVar = new dc.j();
        j.f("charset", charset);
        jVar.V0(str, 0, str.length(), charset);
        return a(jVar, (x0) z10.f9800i, jVar.f4787i);
    }

    public static e c(byte[] bArr, x0 x0Var) {
        j.f("<this>", bArr);
        t1 t1Var = u1.Companion;
        dc.j jVar = new dc.j();
        jVar.O0(bArr);
        t1Var.getClass();
        return a(jVar, x0Var, (long) bArr.length);
    }
}
