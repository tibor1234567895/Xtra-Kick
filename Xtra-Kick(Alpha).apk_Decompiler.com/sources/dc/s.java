package dc;

import xa.j;

public abstract class s implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final n0 f4820h;

    public s(n0 n0Var) {
        j.f("delegate", n0Var);
        this.f4820h = n0Var;
    }

    public void close() {
        this.f4820h.close();
    }

    public void flush() {
        this.f4820h.flush();
    }

    public void o0(j jVar, long j10) {
        j.f("source", jVar);
        this.f4820h.o0(jVar, j10);
    }

    public final s0 timeout() {
        return this.f4820h.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f4820h + ')';
    }
}
