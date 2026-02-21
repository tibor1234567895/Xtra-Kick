package h9;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class r extends s implements h {
    public final void a(Runnable runnable, Executor executor) {
        super.a(runnable, executor);
    }

    public final boolean cancel(boolean z10) {
        return super.cancel(z10);
    }

    public final Object get() {
        return super.get();
    }

    public final boolean isCancelled() {
        return this.f7762h instanceof b;
    }

    public final boolean isDone() {
        return super.isDone();
    }

    public final Object get(long j10, TimeUnit timeUnit) {
        return super.get(j10, timeUnit);
    }
}
