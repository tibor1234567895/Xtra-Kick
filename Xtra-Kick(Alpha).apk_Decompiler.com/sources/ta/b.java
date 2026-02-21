package ta;

import xa.j;

public class b extends sa.b {
    public final void a(Throwable th, Throwable th2) {
        boolean z10;
        j.f("cause", th);
        j.f("exception", th2);
        Integer num = a.f14917a;
        if (num == null || num.intValue() >= 19) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
