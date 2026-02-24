package tb;

import dc.p0;
import dc.t;
import java.io.IOException;
import java.net.ProtocolException;
import pb.g0;
import xa.j;

public final class f extends t {

    /* renamed from: h  reason: collision with root package name */
    public final long f14954h;

    /* renamed from: i  reason: collision with root package name */
    public long f14955i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14956j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f14957k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14958l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g f14959m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar, p0 p0Var, long j10) {
        super(p0Var);
        j.f("delegate", p0Var);
        this.f14959m = gVar;
        this.f14954h = j10;
        if (j10 == 0) {
            c((IOException) null);
        }
    }

    public final IOException c(IOException iOException) {
        if (this.f14957k) {
            return iOException;
        }
        this.f14957k = true;
        g gVar = this.f14959m;
        if (iOException == null && this.f14956j) {
            this.f14956j = false;
            gVar.f14961b.getClass();
            j.f("call", gVar.f14960a);
        }
        return gVar.a(true, false, iOException);
    }

    public final void close() {
        if (!this.f14958l) {
            this.f14958l = true;
            try {
                super.close();
                c((IOException) null);
            } catch (IOException e10) {
                throw c(e10);
            }
        }
    }

    public final long read(dc.j jVar, long j10) {
        j.f("sink", jVar);
        if (!this.f14958l) {
            try {
                long read = delegate().read(jVar, j10);
                if (this.f14956j) {
                    this.f14956j = false;
                    g gVar = this.f14959m;
                    g0 g0Var = gVar.f14961b;
                    o oVar = gVar.f14960a;
                    g0Var.getClass();
                    j.f("call", oVar);
                }
                if (read == -1) {
                    c((IOException) null);
                    return -1;
                }
                long j11 = this.f14955i + read;
                long j12 = this.f14954h;
                if (j12 == -1 || j11 <= j12) {
                    this.f14955i = j11;
                    if (j11 == j12) {
                        c((IOException) null);
                    }
                    return read;
                }
                throw new ProtocolException("expected " + j12 + " bytes but received " + j11);
            } catch (IOException e10) {
                throw c(e10);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }
}
