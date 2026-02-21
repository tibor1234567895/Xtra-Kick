package tb;

import dc.h0;
import dc.i0;
import dc.k;
import dc.l;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pb.a;
import pb.f1;
import pb.h1;
import pb.m0;
import pb.v1;
import qb.h;
import sb.g;
import ub.e;
import wb.c;
import wb.g0;
import wb.i;
import wb.o;
import wb.p0;
import wb.q0;
import wb.v;
import xa.j;

public final class r extends o implements e {

    /* renamed from: b  reason: collision with root package name */
    public final g f15002b;

    /* renamed from: c  reason: collision with root package name */
    public final v1 f15003c;

    /* renamed from: d  reason: collision with root package name */
    public final Socket f15004d;

    /* renamed from: e  reason: collision with root package name */
    public final Socket f15005e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f15006f;

    /* renamed from: g  reason: collision with root package name */
    public final h1 f15007g;

    /* renamed from: h  reason: collision with root package name */
    public final l f15008h;

    /* renamed from: i  reason: collision with root package name */
    public final k f15009i;

    /* renamed from: j  reason: collision with root package name */
    public final int f15010j;

    /* renamed from: k  reason: collision with root package name */
    public v f15011k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15012l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f15013m;

    /* renamed from: n  reason: collision with root package name */
    public int f15014n;

    /* renamed from: o  reason: collision with root package name */
    public int f15015o;

    /* renamed from: p  reason: collision with root package name */
    public int f15016p;

    /* renamed from: q  reason: collision with root package name */
    public int f15017q = 1;

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f15018r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public long f15019s = Long.MAX_VALUE;

    static {
        new p(0);
    }

    public r(g gVar, u uVar, v1 v1Var, Socket socket, Socket socket2, m0 m0Var, h1 h1Var, i0 i0Var, h0 h0Var, int i10) {
        j.f("taskRunner", gVar);
        j.f("connectionPool", uVar);
        j.f("route", v1Var);
        this.f15002b = gVar;
        this.f15003c = v1Var;
        this.f15004d = socket;
        this.f15005e = socket2;
        this.f15006f = m0Var;
        this.f15007g = h1Var;
        this.f15008h = i0Var;
        this.f15009i = h0Var;
        this.f15010j = i10;
    }

    public static void c(f1 f1Var, v1 v1Var, IOException iOException) {
        j.f("client", f1Var);
        j.f("failedRoute", v1Var);
        j.f("failure", iOException);
        if (v1Var.f13007b.type() != Proxy.Type.DIRECT) {
            a aVar = v1Var.f13006a;
            aVar.f12762h.connectFailed(aVar.f12763i.i(), v1Var.f13007b.address(), iOException);
        }
        x xVar = f1Var.D;
        synchronized (xVar) {
            xVar.f15037a.add(v1Var);
        }
    }

    public final synchronized void a(v vVar, p0 p0Var) {
        int i10;
        j.f("connection", vVar);
        j.f("settings", p0Var);
        if ((p0Var.f16292a & 16) != 0) {
            i10 = p0Var.f16293b[4];
        } else {
            i10 = Integer.MAX_VALUE;
        }
        this.f15017q = i10;
    }

    public final void b(g0 g0Var) {
        j.f("stream", g0Var);
        g0Var.c(c.REFUSED_STREAM, (IOException) null);
    }

    public final void cancel() {
        Socket socket = this.f15004d;
        if (socket != null) {
            h.c(socket);
        }
    }

    public final synchronized void d() {
        this.f15015o++;
    }

    public final v1 e() {
        return this.f15003c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bf, code lost:
        if (r10 == false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c7 A[SYNTHETIC, Splitter:B:52:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(pb.a r9, java.util.List r10) {
        /*
            r8 = this;
            pb.p0 r0 = qb.h.f13493a
            java.util.ArrayList r0 = r8.f15018r
            int r0 = r0.size()
            int r1 = r8.f15017q
            r2 = 0
            if (r0 >= r1) goto L_0x00e7
            boolean r0 = r8.f15012l
            if (r0 == 0) goto L_0x0013
            goto L_0x00e7
        L_0x0013:
            pb.v1 r0 = r8.f15003c
            pb.a r1 = r0.f13006a
            boolean r1 = r1.a(r9)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            pb.t0 r1 = r9.f12763i
            java.lang.String r3 = r1.f12992d
            pb.a r4 = r0.f13006a
            pb.t0 r5 = r4.f12763i
            java.lang.String r5 = r5.f12992d
            boolean r3 = xa.j.a(r3, r5)
            r5 = 1
            if (r3 == 0) goto L_0x0030
            return r5
        L_0x0030:
            wb.v r3 = r8.f15011k
            if (r3 != 0) goto L_0x0035
            return r2
        L_0x0035:
            if (r10 == 0) goto L_0x00e7
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L_0x003e
            goto L_0x0073
        L_0x003e:
            java.util.Iterator r10 = r10.iterator()
        L_0x0042:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x0073
            java.lang.Object r3 = r10.next()
            pb.v1 r3 = (pb.v1) r3
            java.net.Proxy r6 = r3.f13007b
            java.net.Proxy$Type r6 = r6.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT
            if (r6 != r7) goto L_0x006e
            java.net.Proxy r6 = r0.f13007b
            java.net.Proxy$Type r6 = r6.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT
            if (r6 != r7) goto L_0x006e
            java.net.InetSocketAddress r6 = r0.f13008c
            java.net.InetSocketAddress r3 = r3.f13008c
            boolean r3 = xa.j.a(r6, r3)
            if (r3 == 0) goto L_0x006e
            r3 = 1
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            if (r3 == 0) goto L_0x0042
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            if (r10 != 0) goto L_0x0078
            goto L_0x00e7
        L_0x0078:
            bc.f r10 = bc.f.f2706a
            javax.net.ssl.HostnameVerifier r0 = r9.f12758d
            if (r0 == r10) goto L_0x007f
            return r2
        L_0x007f:
            pb.p0 r0 = qb.h.f13493a
            pb.t0 r0 = r4.f12763i
            int r3 = r0.f12993e
            java.lang.String r4 = r1.f12992d
            int r1 = r1.f12993e
            pb.m0 r6 = r8.f15006f
            if (r1 == r3) goto L_0x008e
            goto L_0x00c3
        L_0x008e:
            java.lang.String r0 = r0.f12992d
            boolean r0 = xa.j.a(r4, r0)
            if (r0 == 0) goto L_0x0097
            goto L_0x00c1
        L_0x0097:
            boolean r0 = r8.f15013m
            if (r0 != 0) goto L_0x00c3
            if (r6 == 0) goto L_0x00c3
            java.util.List r0 = r6.a()
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x00be
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            xa.j.d(r1, r0)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            r10.getClass()
            boolean r10 = bc.f.c(r4, r0)
            if (r10 == 0) goto L_0x00be
            r10 = 1
            goto L_0x00bf
        L_0x00be:
            r10 = 0
        L_0x00bf:
            if (r10 == 0) goto L_0x00c3
        L_0x00c1:
            r10 = 1
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            if (r10 != 0) goto L_0x00c7
            return r2
        L_0x00c7:
            pb.m r9 = r9.f12759e     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            xa.j.c(r9)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            xa.j.c(r6)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            java.util.List r10 = r6.a()     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            java.lang.String r0 = "hostname"
            xa.j.f(r0, r4)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            java.lang.String r0 = "peerCertificates"
            xa.j.f(r0, r10)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            n3.y3 r0 = new n3.y3     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            r1 = 2
            r0.<init>(r9, r10, r4, r1)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            r9.a(r4, r0)     // Catch:{ SSLPeerUnverifiedException -> 0x00e7 }
            return r5
        L_0x00e7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.r.f(pb.a, java.util.List):boolean");
    }

    public final synchronized void g() {
        this.f15012l = true;
    }

    public final synchronized void h(o oVar, IOException iOException) {
        int i10;
        boolean z10;
        j.f("call", oVar);
        if (!(iOException instanceof q0)) {
            if (this.f15011k != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || (iOException instanceof wb.a)) {
                this.f15012l = true;
                if (this.f15015o == 0) {
                    if (iOException != null) {
                        c(oVar.f14980h, this.f15003c, iOException);
                    }
                }
            }
        } else if (((q0) iOException).f16296h == c.REFUSED_STREAM) {
            int i11 = this.f15016p + 1;
            this.f15016p = i11;
            if (i11 > 1) {
                this.f15012l = true;
                i10 = this.f15014n;
                this.f15014n = i10 + 1;
            }
        } else if (((q0) iOException).f16296h != c.CANCEL || !oVar.f14995w) {
            this.f15012l = true;
        }
        i10 = this.f15014n;
        this.f15014n = i10 + 1;
    }

    public final boolean i(boolean z10) {
        long j10;
        int soTimeout;
        pb.p0 p0Var = h.f13493a;
        long nanoTime = System.nanoTime();
        Socket socket = this.f15004d;
        j.c(socket);
        Socket socket2 = this.f15005e;
        j.c(socket2);
        l lVar = this.f15008h;
        j.c(lVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        v vVar = this.f15011k;
        if (vVar != null) {
            return vVar.v(nanoTime);
        }
        synchronized (this) {
            j10 = nanoTime - this.f15019s;
        }
        if (j10 < 10000000000L || !z10) {
            return true;
        }
        try {
            soTimeout = socket2.getSoTimeout();
            socket2.setSoTimeout(1);
            boolean z11 = !lVar.R();
            socket2.setSoTimeout(soTimeout);
            return z11;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            socket2.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public final void j() {
        String str;
        int i10;
        this.f15019s = System.nanoTime();
        h1 h1Var = this.f15007g;
        if (h1Var == h1.HTTP_2 || h1Var == h1.H2_PRIOR_KNOWLEDGE) {
            Socket socket = this.f15005e;
            j.c(socket);
            l lVar = this.f15008h;
            j.c(lVar);
            k kVar = this.f15009i;
            j.c(kVar);
            socket.setSoTimeout(0);
            wb.k kVar2 = new wb.k(this.f15002b);
            String str2 = this.f15003c.f13006a.f12763i.f12992d;
            j.f("peerName", str2);
            kVar2.f16275c = socket;
            if (kVar2.f16273a) {
                str = h.f13495c + ' ' + str2;
            } else {
                str = "MockWebServer ".concat(str2);
            }
            j.f("<set-?>", str);
            kVar2.f16276d = str;
            kVar2.f16277e = lVar;
            kVar2.f16278f = kVar;
            kVar2.f16279g = this;
            kVar2.f16281i = this.f15010j;
            v vVar = new v(kVar2);
            this.f15011k = vVar;
            v.I.getClass();
            p0 p0Var = v.J;
            if ((p0Var.f16292a & 16) != 0) {
                i10 = p0Var.f16293b[4];
            } else {
                i10 = Integer.MAX_VALUE;
            }
            this.f15017q = i10;
            wb.i0 i0Var = vVar.F;
            synchronized (i0Var) {
                if (i0Var.f16265l) {
                    throw new IOException("closed");
                } else if (i0Var.f16262i) {
                    Logger logger = wb.i0.f16260n;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(h.e(">> CONNECTION " + i.f16256b.e(), new Object[0]));
                    }
                    i0Var.f16261h.i0(i.f16256b);
                    i0Var.f16261h.flush();
                }
            }
            vVar.F.W(vVar.f16328y);
            int a10 = vVar.f16328y.a();
            if (a10 != 65535) {
                vVar.F.Y(0, (long) (a10 - 65535));
            }
            sb.c.c(vVar.f16318o.f(), vVar.f16314k, 0, vVar.G, 6);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        v1 v1Var = this.f15003c;
        sb2.append(v1Var.f13006a.f12763i.f12992d);
        sb2.append(':');
        sb2.append(v1Var.f13006a.f12763i.f12993e);
        sb2.append(", proxy=");
        sb2.append(v1Var.f13007b);
        sb2.append(" hostAddress=");
        sb2.append(v1Var.f13008c);
        sb2.append(" cipherSuite=");
        m0 m0Var = this.f15006f;
        if (m0Var == null || (obj = m0Var.f12905b) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f15007g);
        sb2.append('}');
        return sb2.toString();
    }
}
