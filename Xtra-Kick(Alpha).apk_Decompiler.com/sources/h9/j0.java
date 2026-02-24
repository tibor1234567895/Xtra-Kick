package h9;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class j0 extends g0 implements ScheduledExecutorService {

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledExecutorService f7745i;

    public j0(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f7745i = scheduledExecutorService;
    }

    public final ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        m0 m0Var = new m0(Executors.callable(runnable, (Object) null));
        return new h0(m0Var, this.f7745i.schedule(m0Var, j10, timeUnit));
    }

    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        i0 i0Var = new i0(runnable);
        return new h0(i0Var, this.f7745i.scheduleAtFixedRate(i0Var, j10, j11, timeUnit));
    }

    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        i0 i0Var = new i0(runnable);
        return new h0(i0Var, this.f7745i.scheduleWithFixedDelay(i0Var, j10, j11, timeUnit));
    }

    public final ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        m0 m0Var = new m0(callable);
        return new h0(m0Var, this.f7745i.schedule(m0Var, j10, timeUnit));
    }
}
