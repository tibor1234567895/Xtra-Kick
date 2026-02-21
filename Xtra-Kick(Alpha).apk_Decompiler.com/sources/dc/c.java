package dc;

import java.io.IOException;
import java.io.OutputStream;
import la.v;
import xa.j;

public final class c implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4743h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4744i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f4745j;

    public c(o0 o0Var, c cVar) {
        this.f4744i = o0Var;
        this.f4745j = cVar;
    }

    public final void close() {
        int i10 = this.f4743h;
        Object obj = this.f4744i;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                n0 n0Var = (n0) this.f4745j;
                eVar.i();
                try {
                    n0Var.close();
                    v vVar = v.f9814a;
                    if (eVar.j()) {
                        throw eVar.k((IOException) null);
                    }
                    return;
                } catch (IOException e10) {
                    e = e10;
                    if (eVar.j()) {
                        e = eVar.k(e);
                    }
                    throw e;
                } finally {
                    eVar.j();
                }
            default:
                ((OutputStream) obj).close();
                return;
        }
    }

    public final void flush() {
        int i10 = this.f4743h;
        Object obj = this.f4744i;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                n0 n0Var = (n0) this.f4745j;
                eVar.i();
                try {
                    n0Var.flush();
                    v vVar = v.f9814a;
                    if (eVar.j()) {
                        throw eVar.k((IOException) null);
                    }
                    return;
                } catch (IOException e10) {
                    e = e10;
                    if (eVar.j()) {
                        e = eVar.k(e);
                    }
                    throw e;
                } finally {
                    eVar.j();
                }
            default:
                ((OutputStream) obj).flush();
                return;
        }
    }

    public final void o0(j jVar, long j10) {
        int i10 = this.f4743h;
        Object obj = this.f4745j;
        Object obj2 = this.f4744i;
        switch (i10) {
            case 0:
                j.f("source", jVar);
                w0.b(jVar.f4787i, 0, j10);
                while (j10 > 0) {
                    k0 k0Var = jVar.f4786h;
                    long j11 = 0;
                    while (true) {
                        j.c(k0Var);
                        if (j11 < 65536) {
                            j11 += (long) (k0Var.f4790c - k0Var.f4789b);
                            if (j11 >= j10) {
                                j11 = j10;
                            } else {
                                k0Var = k0Var.f4793f;
                            }
                        }
                    }
                    e eVar = (e) obj2;
                    n0 n0Var = (n0) obj;
                    eVar.i();
                    try {
                        n0Var.o0(jVar, j11);
                        v vVar = v.f9814a;
                        if (!eVar.j()) {
                            j10 -= j11;
                        } else {
                            throw eVar.k((IOException) null);
                        }
                    } catch (IOException e10) {
                        e = e10;
                        if (eVar.j()) {
                            e = eVar.k(e);
                        }
                        throw e;
                    } finally {
                        eVar.j();
                    }
                }
                return;
            default:
                j.f("source", jVar);
                w0.b(jVar.f4787i, 0, j10);
                while (j10 > 0) {
                    ((s0) obj).f();
                    k0 k0Var2 = jVar.f4786h;
                    j.c(k0Var2);
                    int min = (int) Math.min(j10, (long) (k0Var2.f4790c - k0Var2.f4789b));
                    ((OutputStream) obj2).write(k0Var2.f4788a, k0Var2.f4789b, min);
                    int i11 = k0Var2.f4789b + min;
                    k0Var2.f4789b = i11;
                    long j12 = (long) min;
                    j10 -= j12;
                    jVar.f4787i -= j12;
                    if (i11 == k0Var2.f4790c) {
                        jVar.f4786h = k0Var2.a();
                        l0.a(k0Var2);
                    }
                }
                return;
        }
    }

    public final s0 timeout() {
        switch (this.f4743h) {
            case 0:
                return (e) this.f4744i;
            default:
                return (s0) this.f4745j;
        }
    }

    public final String toString() {
        switch (this.f4743h) {
            case 0:
                return "AsyncTimeout.sink(" + ((n0) this.f4745j) + ')';
            default:
                return "sink(" + ((OutputStream) this.f4744i) + ')';
        }
    }

    public c(OutputStream outputStream, s0 s0Var) {
        this.f4744i = outputStream;
        this.f4745j = s0Var;
    }
}
