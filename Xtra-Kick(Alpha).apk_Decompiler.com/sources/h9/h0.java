package h9;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class h0 extends u implements ScheduledFuture {

    /* renamed from: h  reason: collision with root package name */
    public final e0 f7742h;

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledFuture f7743i;

    public h0(n nVar, ScheduledFuture scheduledFuture) {
        this.f7742h = nVar;
        this.f7743i = scheduledFuture;
    }

    public final Object b() {
        return this.f7742h;
    }

    public final e0 c() {
        return this.f7742h;
    }

    public final boolean cancel(boolean z10) {
        boolean cancel = super.cancel(z10);
        if (cancel) {
            this.f7743i.cancel(z10);
        }
        return cancel;
    }

    public final int compareTo(Object obj) {
        return this.f7743i.compareTo((Delayed) obj);
    }

    public final e0 d() {
        return this.f7742h;
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.f7743i.getDelay(timeUnit);
    }
}
