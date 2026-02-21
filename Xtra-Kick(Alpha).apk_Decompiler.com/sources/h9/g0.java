package h9;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class g0 extends o {

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f7741h;

    public g0(ExecutorService executorService) {
        executorService.getClass();
        this.f7741h = executorService;
    }

    public final boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f7741h.awaitTermination(j10, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.f7741h.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.f7741h.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f7741h.isTerminated();
    }

    public final void shutdown() {
        this.f7741h.shutdown();
    }

    public final List shutdownNow() {
        return this.f7741h.shutdownNow();
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f7741h);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + String.valueOf(obj).length() + 2);
        sb2.append(obj);
        sb2.append("[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
