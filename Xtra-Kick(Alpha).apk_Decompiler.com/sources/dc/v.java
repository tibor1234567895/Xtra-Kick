package dc;

import java.util.zip.CRC32;
import java.util.zip.Deflater;
import vb.h;
import xa.j;

public final class v implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final h0 f4830h;

    /* renamed from: i  reason: collision with root package name */
    public final Deflater f4831i;

    /* renamed from: j  reason: collision with root package name */
    public final h f4832j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4833k;

    /* renamed from: l  reason: collision with root package name */
    public final CRC32 f4834l = new CRC32();

    public v(n0 n0Var) {
        j.f("sink", n0Var);
        h0 h0Var = new h0(n0Var);
        this.f4830h = h0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f4831i = deflater;
        this.f4832j = new h(h0Var, deflater);
        j jVar = h0Var.f4780i;
        jVar.U0(8075);
        jVar.Q0(8);
        jVar.Q0(0);
        jVar.T0(0);
        jVar.Q0(0);
        jVar.Q0(0);
    }

    public final void close() {
        Deflater deflater = this.f4831i;
        h0 h0Var = this.f4830h;
        if (!this.f4833k) {
            try {
                h hVar = this.f4832j;
                ((Deflater) hVar.f16004k).finish();
                hVar.c(false);
                h0Var.c((int) this.f4834l.getValue());
                h0Var.c((int) deflater.getBytesRead());
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                h0Var.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f4833k = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final void flush() {
        this.f4832j.flush();
    }

    public final void o0(j jVar, long j10) {
        boolean z10;
        j.f("source", jVar);
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(android.support.v4.media.h.k("byteCount < 0: ", j10).toString());
        } else if (i10 != 0) {
            k0 k0Var = jVar.f4786h;
            long j11 = j10;
            while (true) {
                j.c(k0Var);
                if (j11 > 0) {
                    int min = (int) Math.min(j11, (long) (k0Var.f4790c - k0Var.f4789b));
                    this.f4834l.update(k0Var.f4788a, k0Var.f4789b, min);
                    j11 -= (long) min;
                    k0Var = k0Var.f4793f;
                } else {
                    this.f4832j.o0(jVar, j10);
                    return;
                }
            }
        }
    }

    public final s0 timeout() {
        return this.f4830h.timeout();
    }
}
