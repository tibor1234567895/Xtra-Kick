package lb;

import java.util.concurrent.CancellationException;
import kb.j;

public final class a extends CancellationException {

    /* renamed from: h  reason: collision with root package name */
    public final transient j f9817h;

    public a(j jVar) {
        super("Flow was aborted, no more elements needed");
        this.f9817h = jVar;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
