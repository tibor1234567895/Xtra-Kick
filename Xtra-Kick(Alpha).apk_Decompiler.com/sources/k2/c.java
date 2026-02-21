package k2;

import c9.h;
import g1.z0;
import j1.a0;
import j2.a;
import j2.b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class c extends b {
    public final z0 b(a aVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() != 116) {
            return null;
        }
        a0 a0Var = new a0(byteBuffer.limit(), byteBuffer.array());
        a0Var.m(12);
        int d10 = (a0Var.d() + a0Var.g(12)) - 4;
        a0Var.m(44);
        a0Var.n(a0Var.g(12));
        a0Var.m(16);
        ArrayList arrayList = new ArrayList();
        while (a0Var.d() < d10) {
            a0Var.m(48);
            int g10 = a0Var.g(8);
            a0Var.m(4);
            int d11 = a0Var.d() + a0Var.g(12);
            String str = null;
            String str2 = null;
            while (a0Var.d() < d11) {
                int g11 = a0Var.g(8);
                int g12 = a0Var.g(8);
                int d12 = a0Var.d() + g12;
                if (g11 == 2) {
                    int g13 = a0Var.g(16);
                    a0Var.m(8);
                    if (g13 != 3) {
                    }
                    while (a0Var.d() < d12) {
                        int g14 = a0Var.g(8);
                        Charset charset = h.f3033a;
                        byte[] bArr = new byte[g14];
                        a0Var.i(bArr, g14);
                        str = new String(bArr, charset);
                        int g15 = a0Var.g(8);
                        for (int i10 = 0; i10 < g15; i10++) {
                            a0Var.n(a0Var.g(8));
                        }
                    }
                } else if (g11 == 21) {
                    Charset charset2 = h.f3033a;
                    byte[] bArr2 = new byte[g12];
                    a0Var.i(bArr2, g12);
                    str2 = new String(bArr2, charset2);
                }
                a0Var.k(d12 * 8);
            }
            a0Var.k(d11 * 8);
            if (!(str == null || str2 == null)) {
                arrayList.add(new b(g10, str.concat(str2)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new z0((List) arrayList);
    }
}
