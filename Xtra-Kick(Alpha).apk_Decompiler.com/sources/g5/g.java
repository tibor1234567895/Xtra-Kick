package g5;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g implements ExecutorService {

    /* renamed from: i  reason: collision with root package name */
    public static final long f6837i = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: j  reason: collision with root package name */
    public static volatile int f6838j;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f6839h;

    public g(ThreadPoolExecutor threadPoolExecutor) {
        this.f6839h = threadPoolExecutor;
    }

    public final boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f6839h.awaitTermination(j10, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.f6839h.execute(runnable);
    }

    public final List invokeAll(Collection collection) {
        return this.f6839h.invokeAll(collection);
    }

    public final Object invokeAny(Collection collection) {
        return this.f6839h.invokeAny(collection);
    }

    public final boolean isShutdown() {
        return this.f6839h.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f6839h.isTerminated();
    }

    public final void shutdown() {
        this.f6839h.shutdown();
    }

    public final List shutdownNow() {
        return this.f6839h.shutdownNow();
    }

    public final Future submit(Runnable runnable) {
        return this.f6839h.submit(runnable);
    }

    public final String toString() {
        return this.f6839h.toString();
    }

    public final List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f6839h.invokeAll(collection, j10, timeUnit);
    }

    public final Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f6839h.invokeAny(collection, j10, timeUnit);
    }

    public final Future submit(Runnable runnable, Object obj) {
        return this.f6839h.submit(runnable, obj);
    }

    public final Future submit(Callable callable) {
        return this.f6839h.submit(callable);
    }
}
