package g3;

import a2.k;
import d2.w;
import g1.b1;
import j1.b0;
import j1.v;

public final class e {
    private e() {
    }

    public static boolean a(w wVar) {
        b0 b0Var = new b0(8);
        int i10 = k.a(wVar, b0Var).f59a;
        if (i10 != 1380533830 && i10 != 1380333108) {
            return false;
        }
        wVar.m(b0Var.f8414a, 0, 4);
        b0Var.G(0);
        int f10 = b0Var.f();
        if (f10 == 1463899717) {
            return true;
        }
        v.c("WavHeaderReader", "Unsupported form type: " + f10);
        return false;
    }

    public static k b(int i10, w wVar, b0 b0Var) {
        while (true) {
            k a10 = k.a(wVar, b0Var);
            int i11 = a10.f59a;
            if (i11 == i10) {
                return a10;
            }
            v.g("WavHeaderReader", "Ignoring unknown WAV chunk: " + i11);
            long j10 = a10.f60b + 8;
            if (j10 <= 2147483647L) {
                wVar.g((int) j10);
            } else {
                throw b1.c("Chunk is too large (~2GB+) to skip; id: " + i11);
            }
        }
    }
}
