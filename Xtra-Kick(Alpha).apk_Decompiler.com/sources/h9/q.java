package h9;

import java.util.concurrent.Executor;

public enum q implements Executor {
    ;

    /* access modifiers changed from: public */
    q() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
