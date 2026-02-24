package dc;

import java.io.IOException;
import xa.j;

public abstract class t implements p0 {
    private final p0 delegate;

    public t(p0 p0Var) {
        j.f("delegate", p0Var);
        this.delegate = p0Var;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final p0 m12deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final p0 delegate() {
        return this.delegate;
    }

    public long read(j jVar, long j10) {
        j.f("sink", jVar);
        return this.delegate.read(jVar, j10);
    }

    public s0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
