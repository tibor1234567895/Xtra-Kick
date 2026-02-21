package tb;

import dc.n0;
import dc.s;
import java.io.IOException;
import java.net.ProtocolException;
import xa.j;

public final class e extends s {

    /* renamed from: i  reason: collision with root package name */
    public final long f14949i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14950j;

    /* renamed from: k  reason: collision with root package name */
    public long f14951k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14952l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g f14953m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(g gVar, n0 n0Var, long j10) {
        super(n0Var);
        j.f("delegate", n0Var);
        this.f14953m = gVar;
        this.f14949i = j10;
    }

    public final IOException c(IOException iOException) {
        if (this.f14950j) {
            return iOException;
        }
        this.f14950j = true;
        return this.f14953m.a(false, true, iOException);
    }

    public final void close() {
        if (!this.f14952l) {
            this.f14952l = true;
            long j10 = this.f14949i;
            if (j10 == -1 || this.f14951k == j10) {
                try {
                    super.close();
                    c((IOException) null);
                } catch (IOException e10) {
                    throw c(e10);
                }
            } else {
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    public final void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            throw c(e10);
        }
    }

    public final void o0(dc.j jVar, long j10) {
        j.f("source", jVar);
        if (!this.f14952l) {
            long j11 = this.f14949i;
            if (j11 == -1 || this.f14951k + j10 <= j11) {
                try {
                    super.o0(jVar, j10);
                    this.f14951k += j10;
                } catch (IOException e10) {
                    throw c(e10);
                }
            } else {
                throw new ProtocolException("expected " + j11 + " bytes but received " + (this.f14951k + j10));
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }
}
