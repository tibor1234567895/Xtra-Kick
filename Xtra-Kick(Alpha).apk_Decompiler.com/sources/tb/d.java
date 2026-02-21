package tb;

import androidx.lifecycle.p1;
import bc.f;
import dc.h0;
import dc.i0;
import dc.n;
import dc.s0;
import fb.p;
import fb.w;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import la.v;
import ma.z;
import n3.y3;
import pb.a;
import pb.f1;
import pb.g0;
import pb.g1;
import pb.h1;
import pb.j1;
import pb.k0;
import pb.m;
import pb.m0;
import pb.p0;
import pb.q1;
import pb.r1;
import pb.t;
import pb.t0;
import pb.v1;
import qb.h;
import ub.e;
import vb.g;
import vb.k;
import xa.j;
import xb.s;

public final class d implements z, e {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f14931a;

    /* renamed from: b  reason: collision with root package name */
    public final o f14932b;

    /* renamed from: c  reason: collision with root package name */
    public final v f14933c;

    /* renamed from: d  reason: collision with root package name */
    public final v1 f14934d;

    /* renamed from: e  reason: collision with root package name */
    public final List f14935e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14936f;

    /* renamed from: g  reason: collision with root package name */
    public final j1 f14937g;

    /* renamed from: h  reason: collision with root package name */
    public final int f14938h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f14939i;

    /* renamed from: j  reason: collision with root package name */
    public final g0 f14940j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f14941k;

    /* renamed from: l  reason: collision with root package name */
    public Socket f14942l;

    /* renamed from: m  reason: collision with root package name */
    public Socket f14943m;

    /* renamed from: n  reason: collision with root package name */
    public m0 f14944n;

    /* renamed from: o  reason: collision with root package name */
    public h1 f14945o;

    /* renamed from: p  reason: collision with root package name */
    public i0 f14946p;

    /* renamed from: q  reason: collision with root package name */
    public h0 f14947q;

    /* renamed from: r  reason: collision with root package name */
    public r f14948r;

    static {
        new b(0);
    }

    public d(f1 f1Var, o oVar, v vVar, v1 v1Var, List list, int i10, j1 j1Var, int i11, boolean z10) {
        j.f("client", f1Var);
        j.f("call", oVar);
        j.f("routePlanner", vVar);
        j.f("route", v1Var);
        this.f14931a = f1Var;
        this.f14932b = oVar;
        this.f14933c = vVar;
        this.f14934d = v1Var;
        this.f14935e = list;
        this.f14936f = i10;
        this.f14937g = j1Var;
        this.f14938h = i11;
        this.f14939i = z10;
        this.f14940j = oVar.f14984l;
    }

    public static d l(d dVar, int i10, j1 j1Var, int i11, boolean z10, int i12) {
        if ((i12 & 1) != 0) {
            i10 = dVar.f14936f;
        }
        int i13 = i10;
        if ((i12 & 2) != 0) {
            j1Var = dVar.f14937g;
        }
        j1 j1Var2 = j1Var;
        if ((i12 & 4) != 0) {
            i11 = dVar.f14938h;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            z10 = dVar.f14939i;
        }
        return new d(dVar.f14931a, dVar.f14932b, dVar.f14933c, dVar.f14934d, dVar.f14935e, i13, j1Var2, i14, z10);
    }

    public final z a() {
        return new d(this.f14931a, this.f14932b, this.f14933c, this.f14934d, this.f14935e, this.f14936f, this.f14937g, this.f14938h, this.f14939i);
    }

    public final boolean b() {
        return this.f14945o != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0160, code lost:
        if ((r0 instanceof java.net.ProtocolException) != false) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0165, code lost:
        if ((r0 instanceof java.io.InterruptedIOException) != false) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x016a, code lost:
        if ((r0 instanceof javax.net.ssl.SSLHandshakeException) == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0177, code lost:
        if ((r0 instanceof javax.net.ssl.SSLPeerUnverifiedException) != false) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x017c, code lost:
        if ((r0 instanceof javax.net.ssl.SSLException) != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x017e, code lost:
        r23 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0181, code lost:
        r23 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0183, code lost:
        if (r23 != false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0186, code lost:
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0193, code lost:
        r0 = r1.f14943m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0195, code lost:
        if (r0 != null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0197, code lost:
        qb.h.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x019a, code lost:
        r0 = r1.f14942l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x019c, code lost:
        if (r0 != null) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x019e, code lost:
        qb.h.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        r25 = r9;
        r4 = r11;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0120, code lost:
        r4 = r26;
        r23 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0126, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0127, code lost:
        r4 = r26;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0137, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x013b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013c, code lost:
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0145, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0146, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x015e A[Catch:{ all -> 0x01a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0185 A[Catch:{ all -> 0x01a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0186 A[Catch:{ all -> 0x01a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:68:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0145 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:22:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final tb.y c() {
        /*
            r27 = this;
            r1 = r27
            pb.g0 r2 = r1.f14940j
            pb.f1 r3 = r1.f14931a
            java.net.Socket r0 = r1.f14942l
            r5 = 1
            if (r0 == 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x01c5
            boolean r0 = r27.b()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x01b9
            pb.v1 r0 = r1.f14934d
            pb.a r6 = r0.f13006a
            java.net.Proxy r7 = r0.f13007b
            java.net.InetSocketAddress r8 = r0.f13008c
            pb.a r0 = r0.f13006a
            java.util.List r6 = r6.f12765k
            tb.o r9 = r1.f14932b
            java.util.concurrent.CopyOnWriteArrayList r10 = r9.f14997y
            java.util.concurrent.CopyOnWriteArrayList r11 = r9.f14997y
            r10.add(r1)
            pb.j1 r12 = r1.f14937g     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x004e
            tb.y r12 = r27.k()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            tb.z r13 = r12.f15039b     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r13 != 0) goto L_0x003c
            java.lang.Throwable r13 = r12.f15040c     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r13 == 0) goto L_0x004e
        L_0x003c:
            r11.remove(r1)
            java.net.Socket r0 = r1.f14943m
            if (r0 == 0) goto L_0x0046
            qb.h.c(r0)
        L_0x0046:
            java.net.Socket r0 = r1.f14942l
            if (r0 == 0) goto L_0x004d
            qb.h.c(r0)
        L_0x004d:
            return r12
        L_0x004e:
            javax.net.ssl.SSLSocketFactory r12 = r0.f12757c     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x00b8
            dc.i0 r12 = r1.f14946p     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x0062
            dc.j r12 = r12.f4784i     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x0062
            boolean r12 = r12.R()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 != 0) goto L_0x0062
            r12 = 1
            goto L_0x0063
        L_0x0062:
            r12 = 0
        L_0x0063:
            if (r12 != 0) goto L_0x00b0
            dc.h0 r12 = r1.f14947q     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x0075
            dc.j r12 = r12.f4780i     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 == 0) goto L_0x0075
            boolean r12 = r12.R()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r12 != 0) goto L_0x0075
            r12 = 1
            goto L_0x0076
        L_0x0075:
            r12 = 0
        L_0x0076:
            if (r12 != 0) goto L_0x00b0
            r2.getClass()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            javax.net.ssl.SSLSocketFactory r12 = r0.f12757c     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.net.Socket r13 = r1.f14942l     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            pb.t0 r0 = r0.f12763i     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.lang.String r14 = r0.f12992d     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            int r0 = r0.f12993e     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.net.Socket r0 = r12.createSocket(r13, r14, r0, r5)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.lang.String r12 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            xa.j.d(r12, r0)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            javax.net.ssl.SSLSocket r0 = (javax.net.ssl.SSLSocket) r0     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            tb.d r12 = r1.n(r6, r0)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            int r13 = r12.f14938h     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.lang.Object r13 = r6.get(r13)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            pb.t r13 = (pb.t) r13     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            tb.d r6 = r12.m(r6, r0)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            boolean r12 = r12.f14939i     // Catch:{ IOException -> 0x00a9, all -> 0x0145 }
            r13.a(r0, r12)     // Catch:{ IOException -> 0x00a9, all -> 0x0145 }
            r1.j(r0, r13)     // Catch:{ IOException -> 0x00a9, all -> 0x0145 }
            goto L_0x00cc
        L_0x00a9:
            r0 = move-exception
            r25 = r9
            r4 = r11
            r5 = 0
            goto L_0x0151
        L_0x00b0:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.lang.String r6 = "TLS tunnel buffered too many bytes!"
            r0.<init>(r6)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            throw r0     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
        L_0x00b8:
            java.net.Socket r6 = r1.f14942l     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            r1.f14943m = r6     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            java.util.List r0 = r0.f12764j     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            pb.h1 r6 = pb.h1.H2_PRIOR_KNOWLEDGE     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            boolean r0 = r0.contains(r6)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            if (r0 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            pb.h1 r6 = pb.h1.HTTP_1_1     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
        L_0x00c9:
            r1.f14945o = r6     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
            r6 = 0
        L_0x00cc:
            tb.r r0 = new tb.r     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            sb.g r13 = r3.E     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            pb.q r12 = r3.f12821b     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            tb.u r14 = r12.f12933a     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            pb.v1 r15 = r1.f14934d     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            java.net.Socket r12 = r1.f14942l     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            java.net.Socket r4 = r1.f14943m     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            pb.m0 r5 = r1.f14944n     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            pb.h1 r10 = r1.f14945o     // Catch:{ IOException -> 0x013b, all -> 0x0145 }
            r24 = r6
            dc.i0 r6 = r1.f14946p     // Catch:{ IOException -> 0x0139, all -> 0x0145 }
            r25 = r9
            dc.h0 r9 = r1.f14947q     // Catch:{ IOException -> 0x0137, all -> 0x0145 }
            r26 = r11
            int r11 = r3.B     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            r16 = r12
            r12 = r0
            r17 = r4
            r18 = r5
            r19 = r10
            r20 = r6
            r21 = r9
            r22 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            r1.f14948r = r0     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            r0.j()     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            r2.getClass()     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            java.lang.String r0 = "inetSocketAddress"
            xa.j.f(r0, r8)     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            java.lang.String r0 = "proxy"
            xa.j.f(r0, r7)     // Catch:{ IOException -> 0x012e, all -> 0x0133 }
            tb.y r0 = new tb.y     // Catch:{ IOException -> 0x0126, all -> 0x011f }
            r4 = 6
            r5 = 0
            r0.<init>(r1, r5, r5, r4)     // Catch:{ IOException -> 0x011b, all -> 0x011f }
            r4 = r26
            r4.remove(r1)
            return r0
        L_0x011b:
            r0 = move-exception
            r4 = r26
            goto L_0x012a
        L_0x011f:
            r0 = move-exception
            r4 = r26
            r23 = 1
            goto L_0x01a5
        L_0x0126:
            r0 = move-exception
            r4 = r26
            r5 = 0
        L_0x012a:
            r6 = r24
            r9 = 1
            goto L_0x0152
        L_0x012e:
            r0 = move-exception
            r4 = r26
        L_0x0131:
            r5 = 0
            goto L_0x0142
        L_0x0133:
            r0 = move-exception
            r4 = r26
            goto L_0x0147
        L_0x0137:
            r0 = move-exception
            goto L_0x0140
        L_0x0139:
            r0 = move-exception
            goto L_0x013e
        L_0x013b:
            r0 = move-exception
            r24 = r6
        L_0x013e:
            r25 = r9
        L_0x0140:
            r4 = r11
            goto L_0x0131
        L_0x0142:
            r6 = r24
            goto L_0x0151
        L_0x0145:
            r0 = move-exception
            r4 = r11
        L_0x0147:
            r23 = 0
            goto L_0x01a5
        L_0x014b:
            r0 = move-exception
            r25 = r9
            r4 = r11
            r5 = 0
            r6 = r5
        L_0x0151:
            r9 = 0
        L_0x0152:
            r2.getClass()     // Catch:{ all -> 0x01a2 }
            r2 = r25
            pb.g0.a(r2, r8, r7, r0)     // Catch:{ all -> 0x01a2 }
            boolean r2 = r3.f12825f     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0188
            boolean r2 = r0 instanceof java.net.ProtocolException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0163
            goto L_0x0181
        L_0x0163:
            boolean r2 = r0 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0168
            goto L_0x0181
        L_0x0168:
            boolean r2 = r0 instanceof javax.net.ssl.SSLHandshakeException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0175
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ all -> 0x01a2 }
            boolean r2 = r2 instanceof java.security.cert.CertificateException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0175
            goto L_0x0181
        L_0x0175:
            boolean r2 = r0 instanceof javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x017a
            goto L_0x0181
        L_0x017a:
            boolean r2 = r0 instanceof javax.net.ssl.SSLException     // Catch:{ all -> 0x01a2 }
            if (r2 == 0) goto L_0x0181
            r23 = 1
            goto L_0x0183
        L_0x0181:
            r23 = 0
        L_0x0183:
            if (r23 != 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            r10 = r6
            goto L_0x0189
        L_0x0188:
            r10 = r5
        L_0x0189:
            tb.y r2 = new tb.y     // Catch:{ all -> 0x01a2 }
            r2.<init>(r1, r10, r0)     // Catch:{ all -> 0x01a2 }
            r4.remove(r1)
            if (r9 != 0) goto L_0x01a1
            java.net.Socket r0 = r1.f14943m
            if (r0 == 0) goto L_0x019a
            qb.h.c(r0)
        L_0x019a:
            java.net.Socket r0 = r1.f14942l
            if (r0 == 0) goto L_0x01a1
            qb.h.c(r0)
        L_0x01a1:
            return r2
        L_0x01a2:
            r0 = move-exception
            r23 = r9
        L_0x01a5:
            r4.remove(r1)
            if (r23 != 0) goto L_0x01b8
            java.net.Socket r2 = r1.f14943m
            if (r2 == 0) goto L_0x01b1
            qb.h.c(r2)
        L_0x01b1:
            java.net.Socket r2 = r1.f14942l
            if (r2 == 0) goto L_0x01b8
            qb.h.c(r2)
        L_0x01b8:
            throw r0
        L_0x01b9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "already connected"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01c5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "TCP not connected"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.d.c():tb.y");
    }

    public final void cancel() {
        this.f14941k = true;
        Socket socket = this.f14942l;
        if (socket != null) {
            h.c(socket);
        }
    }

    public final r d() {
        this.f14932b.f14980h.D.a(this.f14934d);
        w e10 = this.f14933c.e(this, this.f14935e);
        if (e10 != null) {
            return e10.f15035a;
        }
        r rVar = this.f14948r;
        j.c(rVar);
        synchronized (rVar) {
            u uVar = this.f14931a.f12821b.f12933a;
            uVar.getClass();
            p0 p0Var = h.f13493a;
            uVar.f15026e.add(rVar);
            uVar.f15024c.d(uVar.f15025d, 0);
            this.f14932b.b(rVar);
            v vVar = v.f9814a;
        }
        g0 g0Var = this.f14940j;
        o oVar = this.f14932b;
        g0Var.getClass();
        j.f("call", oVar);
        return rVar;
    }

    public final v1 e() {
        return this.f14934d;
    }

    public final y f() {
        boolean z10;
        Socket socket;
        IOException e10;
        Socket socket2;
        g0 g0Var = this.f14940j;
        v1 v1Var = this.f14934d;
        boolean z11 = false;
        boolean z12 = true;
        if (this.f14942l == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            o oVar = this.f14932b;
            CopyOnWriteArrayList copyOnWriteArrayList = oVar.f14997y;
            CopyOnWriteArrayList copyOnWriteArrayList2 = oVar.f14997y;
            copyOnWriteArrayList.add(this);
            try {
                InetSocketAddress inetSocketAddress = v1Var.f13008c;
                Proxy proxy = v1Var.f13007b;
                g0Var.getClass();
                j.f("inetSocketAddress", inetSocketAddress);
                j.f("proxy", proxy);
                i();
                try {
                    y yVar = new y(this, (d) null, (Throwable) null, 6);
                    copyOnWriteArrayList2.remove(this);
                    return yVar;
                } catch (IOException e11) {
                    e10 = e11;
                    try {
                        InetSocketAddress inetSocketAddress2 = v1Var.f13008c;
                        Proxy proxy2 = v1Var.f13007b;
                        g0Var.getClass();
                        g0.a(oVar, inetSocketAddress2, proxy2, e10);
                        y yVar2 = new y(this, (d) null, e10, 2);
                        copyOnWriteArrayList2.remove(this);
                        if (!z12 && (socket2 = this.f14942l) != null) {
                            h.c(socket2);
                        }
                        return yVar2;
                    } catch (Throwable th) {
                        th = th;
                        z11 = z12;
                        copyOnWriteArrayList2.remove(this);
                        h.c(socket);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z11 = true;
                    copyOnWriteArrayList2.remove(this);
                    if (!z11 && (socket = this.f14942l) != null) {
                        h.c(socket);
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
                z12 = false;
                InetSocketAddress inetSocketAddress22 = v1Var.f13008c;
                Proxy proxy22 = v1Var.f13007b;
                g0Var.getClass();
                g0.a(oVar, inetSocketAddress22, proxy22, e10);
                y yVar22 = new y(this, (d) null, e10, 2);
                copyOnWriteArrayList2.remove(this);
                h.c(socket2);
                return yVar22;
            } catch (Throwable th3) {
                th = th3;
                copyOnWriteArrayList2.remove(this);
                h.c(socket);
                throw th;
            }
        } else {
            throw new IllegalStateException("TCP already connected".toString());
        }
    }

    public final void g() {
    }

    public final void h(o oVar, IOException iOException) {
        j.f("call", oVar);
    }

    public final void i() {
        int i10;
        Socket socket;
        Proxy.Type type = this.f14934d.f13007b.type();
        if (type == null) {
            i10 = -1;
        } else {
            i10 = c.f14929a[type.ordinal()];
        }
        if (i10 == 1 || i10 == 2) {
            socket = this.f14934d.f13006a.f12756b.createSocket();
            j.c(socket);
        } else {
            socket = new Socket(this.f14934d.f13007b);
        }
        this.f14942l = socket;
        if (!this.f14941k) {
            socket.setSoTimeout(this.f14931a.f12845z);
            try {
                s.f16851a.getClass();
                s.f16852b.e(socket, this.f14934d.f13008c, this.f14931a.f12844y);
                try {
                    this.f14946p = hb.h0.o(hb.h0.J1(socket));
                    this.f14947q = hb.h0.n(hb.h0.H1(socket));
                } catch (NullPointerException e10) {
                    if (j.a(e10.getMessage(), "throw with null exception")) {
                        throw new IOException(e10);
                    }
                }
            } catch (ConnectException e11) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.f14934d.f13008c);
                connectException.initCause(e11);
                throw connectException;
            }
        } else {
            throw new IOException("canceled");
        }
    }

    public final void j(SSLSocket sSLSocket, t tVar) {
        String str;
        h1 h1Var;
        a aVar = this.f14934d.f13006a;
        try {
            if (tVar.f12984b) {
                s.f16851a.getClass();
                s.f16852b.d(sSLSocket, aVar.f12763i.f12992d, aVar.f12764j);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            k0 k0Var = m0.f12903e;
            j.e("sslSocketSession", session);
            k0Var.getClass();
            m0 a10 = k0.a(session);
            HostnameVerifier hostnameVerifier = aVar.f12758d;
            j.c(hostnameVerifier);
            if (!hostnameVerifier.verify(aVar.f12763i.f12992d, session)) {
                List a11 = a10.a();
                if (!a11.isEmpty()) {
                    Object obj = a11.get(0);
                    j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", obj);
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb2 = new StringBuilder("\n            |Hostname ");
                    sb2.append(aVar.f12763i.f12992d);
                    sb2.append(" not verified:\n            |    certificate: ");
                    m.f12899c.getClass();
                    StringBuilder sb3 = new StringBuilder("sha256/");
                    dc.m mVar = n.f4802k;
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    j.e("publicKey.encoded", encoded);
                    sb3.append(dc.m.c(mVar, encoded).c("SHA-256").a());
                    sb2.append(sb3.toString());
                    sb2.append("\n            |    DN: ");
                    sb2.append(x509Certificate.getSubjectDN().getName());
                    sb2.append("\n            |    subjectAltNames: ");
                    f.f2706a.getClass();
                    sb2.append(z.C(f.a(x509Certificate, 2), f.a(x509Certificate, 7)));
                    sb2.append("\n            ");
                    throw new SSLPeerUnverifiedException(p.b(sb2.toString()));
                }
                throw new SSLPeerUnverifiedException("Hostname " + aVar.f12763i.f12992d + " not verified (no certificates)");
            }
            m mVar2 = aVar.f12759e;
            j.c(mVar2);
            m0 m0Var = new m0(a10.f12904a, a10.f12905b, a10.f12906c, new y3(mVar2, a10, aVar, 3));
            this.f14944n = m0Var;
            mVar2.a(aVar.f12763i.f12992d, new p1(27, m0Var));
            if (tVar.f12984b) {
                s.f16851a.getClass();
                str = s.f16852b.f(sSLSocket);
            } else {
                str = null;
            }
            this.f14943m = sSLSocket;
            this.f14946p = hb.h0.o(hb.h0.J1(sSLSocket));
            this.f14947q = hb.h0.n(hb.h0.H1(sSLSocket));
            if (str != null) {
                h1.f12866i.getClass();
                h1Var = g1.a(str);
            } else {
                h1Var = h1.HTTP_1_1;
            }
            this.f14945o = h1Var;
            s.f16851a.getClass();
            s.f16852b.a(sSLSocket);
        } catch (Throwable th) {
            s.f16851a.getClass();
            s.f16852b.a(sSLSocket);
            h.c(sSLSocket);
            throw th;
        }
    }

    public final y k() {
        j1 j1Var;
        j1 j1Var2 = this.f14937g;
        j.c(j1Var2);
        v1 v1Var = this.f14934d;
        t0 t0Var = v1Var.f13006a.f12763i;
        String str = "CONNECT " + h.k(t0Var, true) + " HTTP/1.1";
        while (true) {
            i0 i0Var = this.f14946p;
            j.c(i0Var);
            h0 h0Var = this.f14947q;
            j.c(h0Var);
            k kVar = new k((f1) null, this, i0Var, h0Var);
            s0 timeout = i0Var.timeout();
            f1 f1Var = this.f14931a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.g((long) f1Var.f12845z, timeUnit);
            h0Var.timeout().g((long) f1Var.A, timeUnit);
            kVar.l(j1Var2.f12886c, str);
            kVar.c();
            q1 i10 = kVar.i(false);
            j.c(i10);
            i10.e(j1Var2);
            r1 a10 = i10.a();
            long f10 = h.f(a10);
            if (f10 != -1) {
                g k10 = kVar.k(f10);
                h.i(k10, Integer.MAX_VALUE, timeUnit);
                k10.close();
            }
            int i11 = a10.f12964k;
            if (i11 == 200) {
                j1Var = null;
                break;
            } else if (i11 == 407) {
                j1 a11 = v1Var.f13006a.f12760f.a(v1Var, a10);
                if (a11 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                } else if (w.g("close", r1.e(a10, "Connection"))) {
                    j1Var = a11;
                    break;
                } else {
                    j1Var2 = a11;
                }
            } else {
                throw new IOException(android.support.v4.media.h.i("Unexpected response code for CONNECT: ", i11));
            }
        }
        if (j1Var == null) {
            return new y(this, (d) null, (Throwable) null, 6);
        }
        Socket socket = this.f14942l;
        if (socket != null) {
            h.c(socket);
        }
        int i12 = this.f14936f + 1;
        o oVar = this.f14932b;
        g0 g0Var = this.f14940j;
        Proxy proxy = v1Var.f13007b;
        InetSocketAddress inetSocketAddress = v1Var.f13008c;
        if (i12 < 21) {
            g0Var.getClass();
            j.f("call", oVar);
            j.f("inetSocketAddress", inetSocketAddress);
            j.f("proxy", proxy);
            return new y(this, l(this, i12, j1Var, 0, false, 12), (Throwable) null, 4);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        g0Var.getClass();
        g0.a(oVar, inetSocketAddress, proxy, protocolException);
        return new y(this, (d) null, protocolException, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (qb.f.f(r1, r3, pb.p.f12911c) == false) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[LOOP:0: B:1:0x000e->B:21:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final tb.d m(java.util.List r10, javax.net.ssl.SSLSocket r11) {
        /*
            r9 = this;
            java.lang.String r0 = "connectionSpecs"
            xa.j.f(r0, r10)
            int r0 = r9.f14938h
            int r1 = r0 + 1
            int r2 = r10.size()
            r6 = r1
        L_0x000e:
            if (r6 >= r2) goto L_0x0061
            java.lang.Object r1 = r10.get(r6)
            pb.t r1 = (pb.t) r1
            r1.getClass()
            boolean r3 = r1.f12983a
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0020
            goto L_0x0048
        L_0x0020:
            java.lang.String[] r3 = r1.f12986d
            if (r3 == 0) goto L_0x0033
            java.lang.String[] r7 = r11.getEnabledProtocols()
            oa.c r8 = oa.b.b()
            boolean r3 = qb.f.f(r3, r7, r8)
            if (r3 != 0) goto L_0x0033
            goto L_0x0048
        L_0x0033:
            java.lang.String[] r1 = r1.f12985c
            if (r1 == 0) goto L_0x004a
            java.lang.String[] r3 = r11.getEnabledCipherSuites()
            pb.o r7 = pb.p.f12910b
            r7.getClass()
            pb.n r7 = pb.p.f12911c
            boolean r1 = qb.f.f(r1, r3, r7)
            if (r1 != 0) goto L_0x004a
        L_0x0048:
            r1 = 0
            goto L_0x004b
        L_0x004a:
            r1 = 1
        L_0x004b:
            if (r1 == 0) goto L_0x005e
            r10 = 0
            r11 = 0
            r1 = -1
            if (r0 == r1) goto L_0x0054
            r7 = 1
            goto L_0x0055
        L_0x0054:
            r7 = 0
        L_0x0055:
            r8 = 3
            r3 = r9
            r4 = r10
            r5 = r11
            tb.d r10 = l(r3, r4, r5, r6, r7, r8)
            return r10
        L_0x005e:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0061:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.d.m(java.util.List, javax.net.ssl.SSLSocket):tb.d");
    }

    public final d n(List list, SSLSocket sSLSocket) {
        j.f("connectionSpecs", list);
        if (this.f14938h != -1) {
            return this;
        }
        d m10 = m(list, sSLSocket);
        if (m10 != null) {
            return m10;
        }
        StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f14939i);
        sb2.append(", modes=");
        sb2.append(list);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        j.c(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        j.e("toString(this)", arrays);
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }
}
