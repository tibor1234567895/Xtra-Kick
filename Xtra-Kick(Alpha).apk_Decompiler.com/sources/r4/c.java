package r4;

import fb.w;
import pb.n0;
import pb.p0;

public final class c {
    private c() {
    }

    public /* synthetic */ c(int i10) {
        this();
    }

    public static p0 a(p0 p0Var, p0 p0Var2) {
        boolean z10;
        n0 n0Var = new n0();
        int length = p0Var.f12931h.length / 2;
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= length) {
                break;
            }
            String c10 = p0Var.c(i10);
            String f10 = p0Var.f(i10);
            if (!w.g("Warning", c10) || !w.m(f10, "1", false)) {
                if (!w.g("Content-Length", c10) && !w.g("Content-Encoding", c10) && !w.g("Content-Type", c10)) {
                    z11 = false;
                }
                if (z11 || !b(c10) || p0Var2.a(c10) == null) {
                    n0Var.a(c10, f10);
                }
            }
            i10++;
        }
        int length2 = p0Var2.f12931h.length / 2;
        for (int i11 = 0; i11 < length2; i11++) {
            String c11 = p0Var2.c(i11);
            if (w.g("Content-Length", c11) || w.g("Content-Encoding", c11) || w.g("Content-Type", c11)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && b(c11)) {
                n0Var.a(c11, p0Var2.f(i11));
            }
        }
        return n0Var.b();
    }

    public static boolean b(String str) {
        return !w.g("Connection", str) && !w.g("Keep-Alive", str) && !w.g("Proxy-Authenticate", str) && !w.g("Proxy-Authorization", str) && !w.g("TE", str) && !w.g("Trailers", str) && !w.g("Transfer-Encoding", str) && !w.g("Upgrade", str);
    }
}
