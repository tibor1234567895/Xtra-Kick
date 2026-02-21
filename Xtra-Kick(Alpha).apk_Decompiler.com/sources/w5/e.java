package w5;

import java.util.concurrent.Executor;

public final class e implements Executor {
    public final void execute(Runnable runnable) {
        p.e().post(runnable);
    }
}
