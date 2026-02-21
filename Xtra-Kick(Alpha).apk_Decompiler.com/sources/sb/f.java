package sb;

import hb.h0;
import java.util.logging.Level;
import java.util.logging.Logger;
import la.v;
import xa.j;

public final class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ g f14470h;

    public f(g gVar) {
        this.f14470h = gVar;
    }

    public final void run() {
        a c10;
        long j10;
        while (true) {
            g gVar = this.f14470h;
            synchronized (gVar) {
                c10 = gVar.c();
            }
            if (c10 != null) {
                Logger logger = this.f14470h.f14474b;
                c cVar = c10.f14459c;
                j.c(cVar);
                g gVar2 = this.f14470h;
                boolean isLoggable = logger.isLoggable(Level.FINE);
                if (isLoggable) {
                    cVar.f14463a.f14473a.getClass();
                    j10 = System.nanoTime();
                    h0.e(logger, c10, cVar, "starting");
                } else {
                    j10 = -1;
                }
                try {
                    g.a(gVar2, c10);
                    v vVar = v.f9814a;
                    if (isLoggable) {
                        cVar.f14463a.f14473a.getClass();
                        h0.e(logger, c10, cVar, "finished run in ".concat(h0.Y(System.nanoTime() - j10)));
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        cVar.f14463a.f14473a.getClass();
                        h0.e(logger, c10, cVar, "failed a run in ".concat(h0.Y(System.nanoTime() - j10)));
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
