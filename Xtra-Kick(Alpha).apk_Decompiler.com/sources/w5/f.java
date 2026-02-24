package w5;

import java.util.concurrent.Executor;

public final class f implements Executor {
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
