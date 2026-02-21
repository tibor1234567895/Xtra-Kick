package nb;

import hb.b1;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import pa.k;

public class h extends b1 {

    /* renamed from: j  reason: collision with root package name */
    public final c f11820j;

    public h() {
        this(l.f11826c, l.f11827d, l.f11828e, "CoroutineScheduler");
    }

    public final void M0(k kVar, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f11805o;
        this.f11820j.e(runnable, l.f11830g, false);
    }

    public final void N0(k kVar, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f11805o;
        this.f11820j.e(runnable, l.f11830g, true);
    }

    public void close() {
        this.f11820j.close();
    }

    public h(int i10, int i11, long j10, String str) {
        this.f11820j = new c(i10, i11, j10, str);
    }
}
