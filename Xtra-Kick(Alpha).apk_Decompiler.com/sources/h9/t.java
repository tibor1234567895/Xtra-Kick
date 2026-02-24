package h9;

import d9.g0;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class t extends g0 implements Future {
    /* renamed from: c */
    public abstract e0 b();

    public boolean cancel(boolean z10) {
        return b().cancel(z10);
    }

    public final Object get() {
        return b().get();
    }

    public final boolean isCancelled() {
        return b().isCancelled();
    }

    public final boolean isDone() {
        return b().isDone();
    }

    public final Object get(long j10, TimeUnit timeUnit) {
        return b().get(j10, timeUnit);
    }
}
