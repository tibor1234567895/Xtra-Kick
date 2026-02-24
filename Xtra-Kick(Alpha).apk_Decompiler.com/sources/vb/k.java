package vb;

import dc.l;
import dc.n0;
import dc.q0;
import dc.s0;
import dc.u;
import fb.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import pb.f1;
import pb.j1;
import pb.o1;
import pb.p0;
import pb.q1;
import pb.r1;
import pb.t0;
import qb.h;
import ub.e;
import ub.f;
import ub.g;
import ub.m;
import ub.n;
import xa.j;

public final class k implements f {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f16007a;

    /* renamed from: b  reason: collision with root package name */
    public final e f16008b;

    /* renamed from: c  reason: collision with root package name */
    public final l f16009c;

    /* renamed from: d  reason: collision with root package name */
    public final dc.k f16010d;

    /* renamed from: e  reason: collision with root package name */
    public int f16011e;

    /* renamed from: f  reason: collision with root package name */
    public final b f16012f;

    /* renamed from: g  reason: collision with root package name */
    public p0 f16013g;

    static {
        new f(0);
    }

    public k(f1 f1Var, e eVar, l lVar, dc.k kVar) {
        j.f("carrier", eVar);
        this.f16007a = f1Var;
        this.f16008b = eVar;
        this.f16009c = lVar;
        this.f16010d = kVar;
        this.f16012f = new b(lVar);
    }

    public static final void j(k kVar, u uVar) {
        kVar.getClass();
        s0 s0Var = uVar.f4825e;
        q0 q0Var = s0.f4821d;
        j.f("delegate", q0Var);
        uVar.f4825e = q0Var;
        s0Var.a();
        s0Var.b();
    }

    public final long a(r1 r1Var) {
        if (!g.a(r1Var)) {
            return 0;
        }
        if (w.g("chunked", r1.e(r1Var, "Transfer-Encoding"))) {
            return -1;
        }
        return h.f(r1Var);
    }

    public final void b(j1 j1Var) {
        boolean z10;
        ub.j jVar = ub.j.f15481a;
        Proxy.Type type = this.f16008b.e().f13007b.type();
        j.e("carrier.route.proxy.type()", type);
        jVar.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j1Var.f12885b);
        sb2.append(' ');
        t0 t0Var = j1Var.f12884a;
        if (t0Var.f12998j || type != Proxy.Type.HTTP) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            sb2.append(t0Var);
        } else {
            sb2.append(ub.j.a(t0Var));
        }
        sb2.append(" HTTP/1.1");
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        l(j1Var.f12886c, sb3);
    }

    public final void c() {
        this.f16010d.flush();
    }

    public final void cancel() {
        this.f16008b.cancel();
    }

    public final void d() {
        this.f16010d.flush();
    }

    public final e e() {
        return this.f16008b;
    }

    public final dc.p0 f(r1 r1Var) {
        if (!g.a(r1Var)) {
            return k(0);
        }
        boolean z10 = false;
        if (w.g("chunked", r1.e(r1Var, "Transfer-Encoding"))) {
            t0 t0Var = r1Var.f12961h.f12884a;
            if (this.f16011e == 4) {
                z10 = true;
            }
            if (z10) {
                this.f16011e = 5;
                return new e(this, t0Var);
            }
            throw new IllegalStateException(("state: " + this.f16011e).toString());
        }
        long f10 = h.f(r1Var);
        if (f10 != -1) {
            return k(f10);
        }
        if (this.f16011e == 4) {
            z10 = true;
        }
        if (z10) {
            this.f16011e = 5;
            this.f16008b.g();
            return new i(this);
        }
        throw new IllegalStateException(("state: " + this.f16011e).toString());
    }

    public final p0 g() {
        if (this.f16011e == 6) {
            p0 p0Var = this.f16013g;
            return p0Var == null ? h.f13493a : p0Var;
        }
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    }

    public final n0 h(j1 j1Var, long j10) {
        boolean z10;
        boolean z11 = false;
        o1 o1Var = j1Var.f12887d;
        if (o1Var == null || !o1Var.isDuplex()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if (w.g("chunked", j1Var.b("Transfer-Encoding"))) {
            if (this.f16011e == 1) {
                z11 = true;
            }
            if (z11) {
                this.f16011e = 2;
                return new d(this);
            }
            throw new IllegalStateException(("state: " + this.f16011e).toString());
        } else if (j10 != -1) {
            if (this.f16011e == 1) {
                z11 = true;
            }
            if (z11) {
                this.f16011e = 2;
                return new h(this);
            }
            throw new IllegalStateException(("state: " + this.f16011e).toString());
        } else {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final q1 i(boolean z10) {
        b bVar = this.f16012f;
        int i10 = this.f16011e;
        boolean z11 = true;
        if (!(i10 == 1 || i10 == 2 || i10 == 3)) {
            z11 = false;
        }
        if (z11) {
            try {
                m mVar = n.f15483d;
                String e02 = bVar.f15987a.e0(bVar.f15988b);
                bVar.f15988b -= (long) e02.length();
                mVar.getClass();
                n a10 = m.a(e02);
                int i11 = a10.f15485b;
                q1 q1Var = new q1();
                q1Var.d(a10.f15484a);
                q1Var.f12936c = i11;
                q1Var.c(a10.f15486c);
                q1Var.b(bVar.a());
                j jVar = j.f16006h;
                j.f("trailersFn", jVar);
                q1Var.f12947n = jVar;
                if (z10 && i11 == 100) {
                    return null;
                }
                if (i11 != 100) {
                    if (i11 != 103) {
                        this.f16011e = 4;
                        return q1Var;
                    }
                }
                this.f16011e = 3;
                return q1Var;
            } catch (EOFException e10) {
                throw new IOException(android.support.v4.media.h.m("unexpected end of stream on ", this.f16008b.e().f13006a.f12763i.g()), e10);
            }
        } else {
            throw new IllegalStateException(("state: " + this.f16011e).toString());
        }
    }

    public final g k(long j10) {
        if (this.f16011e == 4) {
            this.f16011e = 5;
            return new g(this, j10);
        }
        throw new IllegalStateException(("state: " + this.f16011e).toString());
    }

    public final void l(p0 p0Var, String str) {
        boolean z10;
        j.f("headers", p0Var);
        j.f("requestLine", str);
        if (this.f16011e == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            dc.k kVar = this.f16010d;
            kVar.v0(str).v0("\r\n");
            int length = p0Var.f12931h.length / 2;
            for (int i10 = 0; i10 < length; i10++) {
                kVar.v0(p0Var.c(i10)).v0(": ").v0(p0Var.f(i10)).v0("\r\n");
            }
            kVar.v0("\r\n");
            this.f16011e = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.f16011e).toString());
    }
}
