package lb;

import java.util.concurrent.CancellationException;

public final class o extends CancellationException {
    public o() {
        super("Child of the scoped flow was cancelled");
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
