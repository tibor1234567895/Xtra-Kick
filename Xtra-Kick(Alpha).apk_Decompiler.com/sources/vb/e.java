package vb;

import fb.w;
import fb.y;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import pb.f1;
import pb.p0;
import pb.t0;
import qb.h;
import ub.g;
import xa.j;

public final class e extends c {

    /* renamed from: k  reason: collision with root package name */
    public final t0 f15995k;

    /* renamed from: l  reason: collision with root package name */
    public long f15996l = -1;

    /* renamed from: m  reason: collision with root package name */
    public boolean f15997m = true;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ k f15998n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(k kVar, t0 t0Var) {
        super(kVar);
        j.f("url", t0Var);
        this.f15998n = kVar;
        this.f15995k = t0Var;
    }

    public final void close() {
        if (!this.f15990i) {
            if (this.f15997m && !h.d(this, TimeUnit.MILLISECONDS)) {
                this.f15998n.f16008b.g();
                c();
            }
            this.f15990i = true;
        }
    }

    public final long read(dc.j jVar, long j10) {
        boolean z10;
        j.f("sink", jVar);
        boolean z11 = true;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(android.support.v4.media.h.k("byteCount < 0: ", j10).toString());
        } else if (!(!this.f15990i)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.f15997m) {
            return -1;
        } else {
            long j11 = this.f15996l;
            k kVar = this.f15998n;
            if (j11 == 0 || j11 == -1) {
                if (j11 != -1) {
                    kVar.f16009c.K();
                }
                try {
                    this.f15996l = kVar.f16009c.D0();
                    String obj = y.R(kVar.f16009c.K()).toString();
                    if (this.f15996l >= 0) {
                        if (obj.length() <= 0) {
                            z11 = false;
                        }
                        if (!z11 || w.m(obj, ";", false)) {
                            if (this.f15996l == 0) {
                                this.f15997m = false;
                                kVar.f16013g = kVar.f16012f.a();
                                f1 f1Var = kVar.f16007a;
                                j.c(f1Var);
                                p0 p0Var = kVar.f16013g;
                                j.c(p0Var);
                                g.b(f1Var.f12830k, this.f15995k, p0Var);
                                c();
                            }
                            if (!this.f15997m) {
                                return -1;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f15996l + obj + '\"');
                } catch (NumberFormatException e10) {
                    throw new ProtocolException(e10.getMessage());
                }
            }
            long read = super.read(jVar, Math.min(j10, this.f15996l));
            if (read != -1) {
                this.f15996l -= read;
                return read;
            }
            kVar.f16008b.g();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c();
            throw protocolException;
        }
    }
}
