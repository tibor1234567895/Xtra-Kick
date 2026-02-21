package hb;

import android.support.v4.media.j;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mb.c;
import pa.k;

public final class c1 extends b1 implements m0 {

    /* renamed from: j  reason: collision with root package name */
    public final Executor f7783j;

    public c1(Executor executor) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        this.f7783j = executor;
        Method method = c.f10841a;
        try {
            if (executor instanceof ScheduledThreadPoolExecutor) {
                scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            } else {
                scheduledThreadPoolExecutor = null;
            }
            if (scheduledThreadPoolExecutor != null) {
                Method method2 = c.f10841a;
                if (method2 != null) {
                    method2.invoke(scheduledThreadPoolExecutor, new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void M0(k kVar, Runnable runnable) {
        try {
            this.f7783j.execute(runnable);
        } catch (RejectedExecutionException e10) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e10);
            h0.w(kVar, cancellationException);
            p0.f7834b.M0(kVar, runnable);
        }
    }

    public final void W(long j10, l lVar) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = this.f7783j;
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            try {
                scheduledFuture = scheduledExecutorService.schedule(new j((Object) this, (Object) lVar, 11), j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                h0.w(lVar.f7822l, cancellationException);
            }
        }
        if (scheduledFuture != null) {
            lVar.j(new h(0, scheduledFuture));
        } else {
            i0.f7808q.W(j10, lVar);
        }
    }

    public final void close() {
        Executor executor = this.f7783j;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c1) || ((c1) obj).f7783j != this.f7783j) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7783j);
    }

    public final String toString() {
        return this.f7783j.toString();
    }
}
