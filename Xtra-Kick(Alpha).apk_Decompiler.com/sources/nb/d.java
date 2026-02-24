package nb;

import hb.b1;
import hb.d0;
import hb.h0;
import java.util.concurrent.Executor;
import mb.b0;
import pa.k;
import pa.l;

public final class d extends b1 implements Executor {

    /* renamed from: j  reason: collision with root package name */
    public static final d f11816j = new d();

    /* renamed from: k  reason: collision with root package name */
    public static final d0 f11817k;

    static {
        m mVar = m.f11832j;
        int i10 = b0.f10840a;
        if (64 >= i10) {
            i10 = 64;
        }
        f11817k = mVar.P0(h0.N1("kotlinx.coroutines.io.parallelism", i10, 0, 0, 12));
    }

    private d() {
    }

    public final void M0(k kVar, Runnable runnable) {
        f11817k.M0(kVar, runnable);
    }

    public final void N0(k kVar, Runnable runnable) {
        f11817k.N0(kVar, runnable);
    }

    public final d0 P0(int i10) {
        return m.f11832j.P0(1);
    }

    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public final void execute(Runnable runnable) {
        M0(l.f12754h, runnable);
    }

    public final String toString() {
        return "Dispatchers.IO";
    }
}
