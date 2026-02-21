package vb;

import dc.j;
import dc.k;
import dc.k0;
import dc.l0;
import dc.n0;
import dc.s0;
import dc.u;
import dc.w0;
import hb.h0;
import java.util.zip.Deflater;
import qb.f;

public final class h implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16001h = 1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16002i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f16003j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f16004k;

    public h(j jVar, Deflater deflater) {
        this(h0.n(jVar), deflater);
    }

    public final void c(boolean z10) {
        k0 M0;
        int i10;
        Object obj = this.f16003j;
        j b10 = ((k) obj).b();
        while (true) {
            M0 = b10.M0(1);
            Object obj2 = this.f16004k;
            byte[] bArr = M0.f4788a;
            Deflater deflater = (Deflater) obj2;
            int i11 = M0.f4790c;
            int i12 = 8192 - i11;
            if (z10) {
                i10 = deflater.deflate(bArr, i11, i12, 2);
            } else {
                i10 = deflater.deflate(bArr, i11, i12);
            }
            if (i10 > 0) {
                M0.f4790c += i10;
                b10.f4787i += (long) i10;
                ((k) obj).b0();
            } else if (((Deflater) obj2).needsInput()) {
                break;
            }
        }
        if (M0.f4789b == M0.f4790c) {
            b10.f4786h = M0.a();
            l0.a(M0);
        }
    }

    public final void close() {
        int i10 = this.f16001h;
        Object obj = this.f16003j;
        Object obj2 = this.f16004k;
        switch (i10) {
            case 0:
                if (!this.f16002i) {
                    this.f16002i = true;
                    k kVar = (k) obj2;
                    k.j(kVar, (u) obj);
                    kVar.f16011e = 3;
                    return;
                }
                return;
            default:
                if (!this.f16002i) {
                    try {
                        ((Deflater) obj2).finish();
                        c(false);
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ((Deflater) obj2).end();
                    } catch (Throwable th2) {
                        if (th == null) {
                            th = th2;
                        }
                    }
                    try {
                        ((k) obj).close();
                    } catch (Throwable th3) {
                        if (th == null) {
                            th = th3;
                        }
                    }
                    this.f16002i = true;
                    if (th != null) {
                        throw th;
                    }
                    return;
                }
                return;
        }
    }

    public final void flush() {
        switch (this.f16001h) {
            case 0:
                if (!this.f16002i) {
                    ((k) this.f16004k).f16010d.flush();
                    return;
                }
                return;
            default:
                c(true);
                ((k) this.f16003j).flush();
                return;
        }
    }

    public final void o0(j jVar, long j10) {
        int i10 = this.f16001h;
        Object obj = this.f16004k;
        switch (i10) {
            case 0:
                xa.j.f("source", jVar);
                if (!this.f16002i) {
                    f.a(jVar.f4787i, 0, j10);
                    ((k) obj).f16010d.o0(jVar, j10);
                    return;
                }
                throw new IllegalStateException("closed".toString());
            default:
                xa.j.f("source", jVar);
                w0.b(jVar.f4787i, 0, j10);
                while (j10 > 0) {
                    k0 k0Var = jVar.f4786h;
                    xa.j.c(k0Var);
                    int min = (int) Math.min(j10, (long) (k0Var.f4790c - k0Var.f4789b));
                    ((Deflater) obj).setInput(k0Var.f4788a, k0Var.f4789b, min);
                    c(false);
                    long j11 = (long) min;
                    jVar.f4787i -= j11;
                    int i11 = k0Var.f4789b + min;
                    k0Var.f4789b = i11;
                    if (i11 == k0Var.f4790c) {
                        jVar.f4786h = k0Var.a();
                        l0.a(k0Var);
                    }
                    j10 -= j11;
                }
                return;
        }
    }

    public final s0 timeout() {
        int i10 = this.f16001h;
        Object obj = this.f16003j;
        switch (i10) {
            case 0:
                return (u) obj;
            default:
                return ((k) obj).timeout();
        }
    }

    public final String toString() {
        switch (this.f16001h) {
            case 1:
                return "DeflaterSink(" + ((k) this.f16003j) + ')';
            default:
                return super.toString();
        }
    }

    public h(dc.h0 h0Var, Deflater deflater) {
        this.f16003j = h0Var;
        this.f16004k = deflater;
    }

    public h(k kVar) {
        this.f16004k = kVar;
        this.f16003j = new u(kVar.f16010d.timeout());
    }
}
