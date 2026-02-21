package kb;

import hb.l;
import lb.b;
import lb.c;
import pa.e;

public final class u0 extends c {

    /* renamed from: a  reason: collision with root package name */
    public long f9402a = -1;

    /* renamed from: b  reason: collision with root package name */
    public l f9403b;

    public final boolean a(b bVar) {
        s0 s0Var = (s0) bVar;
        if (this.f9402a >= 0) {
            return false;
        }
        long j10 = s0Var.f9389p;
        if (j10 < s0Var.f9390q) {
            s0Var.f9390q = j10;
        }
        this.f9402a = j10;
        return true;
    }

    public final e[] b(b bVar) {
        long j10 = this.f9402a;
        this.f9402a = -1;
        this.f9403b = null;
        return ((s0) bVar).w(j10);
    }
}
