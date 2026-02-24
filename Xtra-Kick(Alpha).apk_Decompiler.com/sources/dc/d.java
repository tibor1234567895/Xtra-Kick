package dc;

import android.support.v4.media.h;
import hb.h0;
import java.io.IOException;
import java.io.InputStream;
import la.v;
import xa.j;

public final class d implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4746h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4747i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f4748j;

    public d(o0 o0Var, d dVar) {
        this.f4747i = o0Var;
        this.f4748j = dVar;
    }

    public final void close() {
        int i10 = this.f4746h;
        Object obj = this.f4747i;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                p0 p0Var = (p0) this.f4748j;
                eVar.i();
                try {
                    p0Var.close();
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
                ((InputStream) obj).close();
                return;
        }
    }

    public final long read(j jVar, long j10) {
        boolean z10;
        int i10 = this.f4746h;
        Object obj = this.f4748j;
        Object obj2 = this.f4747i;
        switch (i10) {
            case 0:
                j.f("sink", jVar);
                e eVar = (e) obj2;
                p0 p0Var = (p0) obj;
                eVar.i();
                try {
                    long read = p0Var.read(jVar, j10);
                    if (!eVar.j()) {
                        return read;
                    }
                    throw eVar.k((IOException) null);
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
                j.f("sink", jVar);
                int i11 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                if (i11 == 0) {
                    return 0;
                }
                if (i11 >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    try {
                        ((s0) obj).f();
                        k0 M0 = jVar.M0(1);
                        int read2 = ((InputStream) obj2).read(M0.f4788a, M0.f4790c, (int) Math.min(j10, (long) (8192 - M0.f4790c)));
                        if (read2 == -1) {
                            if (M0.f4789b == M0.f4790c) {
                                jVar.f4786h = M0.a();
                                l0.a(M0);
                            }
                            return -1;
                        }
                        M0.f4790c += read2;
                        long j11 = (long) read2;
                        jVar.f4787i += j11;
                        return j11;
                    } catch (AssertionError e11) {
                        if (h0.R0(e11)) {
                            throw new IOException(e11);
                        }
                        throw e11;
                    }
                } else {
                    throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
                }
        }
    }

    public final s0 timeout() {
        switch (this.f4746h) {
            case 0:
                return (e) this.f4747i;
            default:
                return (s0) this.f4748j;
        }
    }

    public final String toString() {
        switch (this.f4746h) {
            case 0:
                return "AsyncTimeout.source(" + ((p0) this.f4748j) + ')';
            default:
                return "source(" + ((InputStream) this.f4747i) + ')';
        }
    }

    public d(InputStream inputStream, s0 s0Var) {
        j.f("input", inputStream);
        j.f("timeout", s0Var);
        this.f4747i = inputStream;
        this.f4748j = s0Var;
    }
}
