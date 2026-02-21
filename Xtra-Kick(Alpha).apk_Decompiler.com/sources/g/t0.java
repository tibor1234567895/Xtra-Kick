package g;

import java.util.concurrent.Executor;

public final class t0 implements Executor {
    public final void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
