package dc;

import android.support.v4.media.h;
import hb.h0;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import xa.j;

public final class x implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final l f4843h;

    /* renamed from: i  reason: collision with root package name */
    public final Inflater f4844i;

    /* renamed from: j  reason: collision with root package name */
    public int f4845j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4846k;

    public x(i0 i0Var, Inflater inflater) {
        this.f4843h = i0Var;
        this.f4844i = inflater;
    }

    public final long c(j jVar, long j10) {
        boolean z10;
        Inflater inflater = this.f4844i;
        j.f("sink", jVar);
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
        } else if (!(!this.f4846k)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            try {
                k0 M0 = jVar.M0(1);
                int min = (int) Math.min(j10, (long) (8192 - M0.f4790c));
                boolean needsInput = inflater.needsInput();
                l lVar = this.f4843h;
                if (needsInput) {
                    if (!lVar.R()) {
                        k0 k0Var = lVar.b().f4786h;
                        j.c(k0Var);
                        int i11 = k0Var.f4790c;
                        int i12 = k0Var.f4789b;
                        int i13 = i11 - i12;
                        this.f4845j = i13;
                        inflater.setInput(k0Var.f4788a, i12, i13);
                    }
                }
                int inflate = inflater.inflate(M0.f4788a, M0.f4790c, min);
                int i14 = this.f4845j;
                if (i14 != 0) {
                    int remaining = i14 - inflater.getRemaining();
                    this.f4845j -= remaining;
                    lVar.a((long) remaining);
                }
                if (inflate > 0) {
                    M0.f4790c += inflate;
                    long j11 = (long) inflate;
                    jVar.f4787i += j11;
                    return j11;
                }
                if (M0.f4789b == M0.f4790c) {
                    jVar.f4786h = M0.a();
                    l0.a(M0);
                }
                return 0;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
    }

    public final void close() {
        if (!this.f4846k) {
            this.f4844i.end();
            this.f4846k = true;
            this.f4843h.close();
        }
    }

    public final long read(j jVar, long j10) {
        j.f("sink", jVar);
        do {
            long c10 = c(jVar, j10);
            if (c10 > 0) {
                return c10;
            }
            Inflater inflater = this.f4844i;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1;
            }
        } while (!this.f4843h.R());
        throw new EOFException("source exhausted prematurely");
    }

    public final s0 timeout() {
        return this.f4843h.timeout();
    }

    public x(p0 p0Var, Inflater inflater) {
        this(h0.o(p0Var), inflater);
    }
}
