package h9;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class o extends AbstractExecutorService implements f0 {
    /* renamed from: a */
    public final e0 submit(Callable callable) {
        return (e0) super.submit(callable);
    }

    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new m0(Executors.callable(runnable, obj));
    }

    public final Future submit(Runnable runnable) {
        return (e0) super.submit(runnable);
    }

    public final RunnableFuture newTaskFor(Callable callable) {
        return new m0(callable);
    }

    public final Future submit(Runnable runnable, Object obj) {
        return (e0) super.submit(runnable, obj);
    }
}
