package x4;

import java.util.concurrent.ThreadFactory;

public final class b implements ThreadFactory {
    private b() {
    }

    public /* synthetic */ b(int i10) {
        this();
    }

    public final synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, "glide-disk-lru-cache-thread");
        thread.setPriority(1);
        return thread;
    }
}
