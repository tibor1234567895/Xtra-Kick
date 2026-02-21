package cc;

import android.support.v4.media.h;
import dc.k;
import dc.l;
import dc.m;
import dc.n;
import dc.x;
import fb.w;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import la.v;
import ma.q;
import pb.h1;
import pb.j1;
import pb.p0;
import pb.r1;
import pb.y1;
import pb.z1;
import sb.b;
import sb.c;
import t7.f;
import tb.o;
import tb.t;
import xa.j;

public final class g implements y1, k {

    /* renamed from: x  reason: collision with root package name */
    public static final List f3092x = q.b(h1.HTTP_1_1);

    /* renamed from: a  reason: collision with root package name */
    public final j1 f3093a;

    /* renamed from: b  reason: collision with root package name */
    public final z1 f3094b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f3095c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3096d;

    /* renamed from: e  reason: collision with root package name */
    public i f3097e = null;

    /* renamed from: f  reason: collision with root package name */
    public final long f3098f;

    /* renamed from: g  reason: collision with root package name */
    public final String f3099g;

    /* renamed from: h  reason: collision with root package name */
    public o f3100h;

    /* renamed from: i  reason: collision with root package name */
    public t f3101i;

    /* renamed from: j  reason: collision with root package name */
    public l f3102j;

    /* renamed from: k  reason: collision with root package name */
    public m f3103k;

    /* renamed from: l  reason: collision with root package name */
    public final c f3104l;

    /* renamed from: m  reason: collision with root package name */
    public String f3105m;

    /* renamed from: n  reason: collision with root package name */
    public tb.q f3106n;

    /* renamed from: o  reason: collision with root package name */
    public final ArrayDeque f3107o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayDeque f3108p;

    /* renamed from: q  reason: collision with root package name */
    public long f3109q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3110r;

    /* renamed from: s  reason: collision with root package name */
    public int f3111s;

    /* renamed from: t  reason: collision with root package name */
    public String f3112t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3113u;

    /* renamed from: v  reason: collision with root package name */
    public int f3114v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3115w;

    static {
        new d(0);
    }

    public g(sb.g gVar, j1 j1Var, f fVar, Random random, long j10, long j11) {
        j.f("taskRunner", gVar);
        this.f3093a = j1Var;
        this.f3094b = fVar;
        this.f3095c = random;
        this.f3096d = j10;
        this.f3098f = j11;
        this.f3104l = gVar.f();
        this.f3107o = new ArrayDeque();
        this.f3108p = new ArrayDeque();
        this.f3111s = -1;
        String str = j1Var.f12885b;
        if (j.a("GET", str)) {
            m mVar = n.f4802k;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            v vVar = v.f9814a;
            this.f3099g = m.c(mVar, bArr).a();
            return;
        }
        throw new IllegalArgumentException(h.m("Request must be GET: ", str).toString());
    }

    public final void a(r1 r1Var, tb.g gVar) {
        int i10 = r1Var.f12964k;
        if (i10 == 101) {
            String e10 = r1.e(r1Var, "Connection");
            if (w.g("Upgrade", e10)) {
                String e11 = r1.e(r1Var, "Upgrade");
                if (w.g("websocket", e11)) {
                    String e12 = r1.e(r1Var, "Sec-WebSocket-Accept");
                    n.f4802k.getClass();
                    String a10 = m.b(this.f3099g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c("SHA-1").a();
                    if (!j.a(a10, e12)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + a10 + "' but was '" + e12 + '\'');
                    } else if (gVar == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + e11 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + e10 + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + i10 + ' ' + r1Var.f12963j + '\'');
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "reason.size() > 123: "
            monitor-enter(r9)
            cc.j r1 = cc.j.f3123a     // Catch:{ all -> 0x0069 }
            r1.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = cc.j.a(r10)     // Catch:{ all -> 0x0069 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r4 = 1
            goto L_0x0013
        L_0x0012:
            r4 = 0
        L_0x0013:
            if (r4 == 0) goto L_0x005c
            if (r11 == 0) goto L_0x003e
            dc.m r1 = dc.n.f4802k     // Catch:{ all -> 0x0069 }
            r1.getClass()     // Catch:{ all -> 0x0069 }
            dc.n r1 = dc.m.b(r11)     // Catch:{ all -> 0x0069 }
            byte[] r4 = r1.f4804h     // Catch:{ all -> 0x0069 }
            int r4 = r4.length     // Catch:{ all -> 0x0069 }
            long r4 = (long) r4     // Catch:{ all -> 0x0069 }
            r6 = 123(0x7b, double:6.1E-322)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0030
            goto L_0x003f
        L_0x0030:
            java.lang.String r10 = r0.concat(r11)     // Catch:{ all -> 0x0069 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0069 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0069 }
            r11.<init>(r10)     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x0069 }
        L_0x003e:
            r1 = 0
        L_0x003f:
            boolean r11 = r9.f3113u     // Catch:{ all -> 0x0069 }
            if (r11 != 0) goto L_0x0059
            boolean r11 = r9.f3110r     // Catch:{ all -> 0x0069 }
            if (r11 == 0) goto L_0x0048
            goto L_0x0059
        L_0x0048:
            r9.f3110r = r2     // Catch:{ all -> 0x0069 }
            java.util.ArrayDeque r11 = r9.f3108p     // Catch:{ all -> 0x0069 }
            cc.c r0 = new cc.c     // Catch:{ all -> 0x0069 }
            r0.<init>(r10, r1)     // Catch:{ all -> 0x0069 }
            r11.add(r0)     // Catch:{ all -> 0x0069 }
            r9.h()     // Catch:{ all -> 0x0069 }
            monitor-exit(r9)
            goto L_0x005b
        L_0x0059:
            monitor-exit(r9)
            r2 = 0
        L_0x005b:
            return r2
        L_0x005c:
            xa.j.c(r1)     // Catch:{ all -> 0x0069 }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0069 }
            r10.<init>(r11)     // Catch:{ all -> 0x0069 }
            throw r10     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.g.b(int, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.f3094b.a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r5 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        qb.f.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r1 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        qb.f.b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r2 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        qb.f.b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.Exception r4, pb.r1 r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.f3113u     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            r5 = 1
            r3.f3113u = r5     // Catch:{ all -> 0x0045 }
            tb.q r5 = r3.f3106n     // Catch:{ all -> 0x0045 }
            r0 = 0
            r3.f3106n = r0     // Catch:{ all -> 0x0045 }
            cc.l r1 = r3.f3102j     // Catch:{ all -> 0x0045 }
            r3.f3102j = r0     // Catch:{ all -> 0x0045 }
            cc.m r2 = r3.f3103k     // Catch:{ all -> 0x0045 }
            r3.f3103k = r0     // Catch:{ all -> 0x0045 }
            sb.c r0 = r3.f3104l     // Catch:{ all -> 0x0045 }
            r0.f()     // Catch:{ all -> 0x0045 }
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            pb.z1 r0 = r3.f3094b     // Catch:{ all -> 0x0034 }
            r0.a(r3, r4)     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x0029
            qb.f.b(r5)
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            qb.f.b(r1)
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            qb.f.b(r2)
        L_0x0033:
            return
        L_0x0034:
            r4 = move-exception
            if (r5 == 0) goto L_0x003a
            qb.f.b(r5)
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            qb.f.b(r1)
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            qb.f.b(r2)
        L_0x0044:
            throw r4
        L_0x0045:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.g.c(java.lang.Exception, pb.r1):void");
    }

    public final void d(String str, tb.q qVar) {
        boolean z10;
        boolean z11;
        j.f("name", str);
        i iVar = this.f3097e;
        j.c(iVar);
        synchronized (this) {
            this.f3105m = str;
            this.f3106n = qVar;
            boolean z12 = qVar.f14998h;
            k kVar = qVar.f15000j;
            Random random = this.f3095c;
            boolean z13 = iVar.f3117a;
            if (z12) {
                z10 = iVar.f3119c;
            } else {
                z10 = iVar.f3121e;
            }
            this.f3103k = new m(z12, kVar, random, z13, z10, this.f3098f);
            this.f3101i = new t(this);
            long j10 = this.f3096d;
            if (j10 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j10);
                c cVar = this.f3104l;
                String concat = str.concat(" ping");
                wb.j jVar = new wb.j(1, nanos, this);
                cVar.getClass();
                j.f("name", concat);
                cVar.d(new b(concat, jVar), nanos);
            }
            if (!this.f3108p.isEmpty()) {
                h();
            }
            v vVar = v.f9814a;
        }
        boolean z14 = qVar.f14998h;
        l lVar = qVar.f14999i;
        boolean z15 = iVar.f3117a;
        if (!z14) {
            z11 = iVar.f3119c;
        } else {
            z11 = iVar.f3121e;
        }
        this.f3102j = new l(z14, lVar, this, z15, z11);
    }

    public final void e() {
        boolean z10;
        while (this.f3111s == -1) {
            l lVar = this.f3102j;
            j.c(lVar);
            lVar.e();
            if (lVar.f3133q) {
                lVar.c();
            } else {
                int i10 = lVar.f3130n;
                if (i10 == 1 || i10 == 2) {
                    while (!lVar.f3129m) {
                        long j10 = lVar.f3131o;
                        dc.j jVar = lVar.f3136t;
                        if (j10 > 0) {
                            lVar.f3125i.H(jVar, j10);
                            if (!lVar.f3124h) {
                                dc.g gVar = lVar.f3139w;
                                j.c(gVar);
                                jVar.W(gVar);
                                gVar.e(jVar.f4787i - lVar.f3131o);
                                j jVar2 = j.f3123a;
                                byte[] bArr = lVar.f3138v;
                                j.c(bArr);
                                jVar2.getClass();
                                j.b(gVar, bArr);
                                gVar.close();
                            }
                        }
                        if (!lVar.f3132p) {
                            while (!lVar.f3129m) {
                                lVar.e();
                                if (!lVar.f3133q) {
                                    break;
                                }
                                lVar.c();
                            }
                            if (lVar.f3130n != 0) {
                                int i11 = lVar.f3130n;
                                p0 p0Var = qb.h.f13493a;
                                String hexString = Integer.toHexString(i11);
                                j.e("toHexString(this)", hexString);
                                throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString));
                            }
                        } else {
                            if (!lVar.f3134r) {
                                k kVar = lVar.f3126j;
                            } else {
                                a aVar = lVar.f3137u;
                                if (aVar == null) {
                                    aVar = new a(1, lVar.f3128l);
                                    lVar.f3137u = aVar;
                                }
                                j.f("buffer", jVar);
                                dc.j jVar3 = aVar.f3081j;
                                if (jVar3.f4787i == 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (z10) {
                                    boolean z11 = aVar.f3080i;
                                    Object obj = aVar.f3082k;
                                    if (z11) {
                                        ((Inflater) obj).reset();
                                    }
                                    jVar3.F0(jVar);
                                    jVar3.T0(65535);
                                    Inflater inflater = (Inflater) obj;
                                    long bytesRead = inflater.getBytesRead() + jVar3.f4787i;
                                    do {
                                        ((x) aVar.f3083l).c(jVar, Long.MAX_VALUE);
                                    } while (inflater.getBytesRead() < bytesRead);
                                } else {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                            }
                            k kVar2 = lVar.f3126j;
                            if (i10 == 1) {
                                String j02 = jVar.j0();
                                g gVar2 = (g) kVar2;
                                gVar2.getClass();
                                gVar2.f3094b.b(gVar2, j02);
                            } else {
                                n m10 = jVar.m();
                                g gVar3 = (g) kVar2;
                                gVar3.getClass();
                                j.f("bytes", m10);
                                gVar3.f3094b.getClass();
                            }
                        }
                    }
                    throw new IOException("closed");
                }
                p0 p0Var2 = qb.h.f13493a;
                String hexString2 = Integer.toHexString(i10);
                j.e("toHexString(this)", hexString2);
                throw new ProtocolException("Unknown opcode: ".concat(hexString2));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r6v3, types: [cc.l, cc.m, tb.q] */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            if (r5 == r2) goto L_0x0007
            r3 = 1
            goto L_0x0008
        L_0x0007:
            r3 = 0
        L_0x0008:
            if (r3 == 0) goto L_0x0077
            monitor-enter(r4)
            int r3 = r4.f3111s     // Catch:{ all -> 0x0074 }
            if (r3 != r2) goto L_0x0010
            r0 = 1
        L_0x0010:
            if (r0 == 0) goto L_0x0068
            r4.f3111s = r5     // Catch:{ all -> 0x0074 }
            r4.f3112t = r6     // Catch:{ all -> 0x0074 }
            boolean r5 = r4.f3110r     // Catch:{ all -> 0x0074 }
            r6 = 0
            if (r5 == 0) goto L_0x0036
            java.util.ArrayDeque r5 = r4.f3108p     // Catch:{ all -> 0x0074 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r5 == 0) goto L_0x0036
            tb.q r5 = r4.f3106n     // Catch:{ all -> 0x0074 }
            r4.f3106n = r6     // Catch:{ all -> 0x0074 }
            cc.l r0 = r4.f3102j     // Catch:{ all -> 0x0074 }
            r4.f3102j = r6     // Catch:{ all -> 0x0074 }
            cc.m r1 = r4.f3103k     // Catch:{ all -> 0x0074 }
            r4.f3103k = r6     // Catch:{ all -> 0x0074 }
            sb.c r6 = r4.f3104l     // Catch:{ all -> 0x0074 }
            r6.f()     // Catch:{ all -> 0x0074 }
            r6 = r5
            goto L_0x0038
        L_0x0036:
            r0 = r6
            r1 = r0
        L_0x0038:
            la.v r5 = la.v.f9814a     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            pb.z1 r5 = r4.f3094b     // Catch:{ all -> 0x0057 }
            r5.getClass()     // Catch:{ all -> 0x0057 }
            if (r6 == 0) goto L_0x0047
            pb.z1 r5 = r4.f3094b     // Catch:{ all -> 0x0057 }
            r5.getClass()     // Catch:{ all -> 0x0057 }
        L_0x0047:
            if (r6 == 0) goto L_0x004c
            qb.f.b(r6)
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            qb.f.b(r0)
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            qb.f.b(r1)
        L_0x0056:
            return
        L_0x0057:
            r5 = move-exception
            if (r6 == 0) goto L_0x005d
            qb.f.b(r6)
        L_0x005d:
            if (r0 == 0) goto L_0x0062
            qb.f.b(r0)
        L_0x0062:
            if (r1 == 0) goto L_0x0067
            qb.f.b(r1)
        L_0x0067:
            throw r5
        L_0x0068:
            java.lang.String r5 = "already closed"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0074 }
            r6.<init>(r5)     // Catch:{ all -> 0x0074 }
            throw r6     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0077:
            java.lang.String r5 = "Failed requirement."
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.g.f(int, java.lang.String):void");
    }

    public final synchronized void g(n nVar) {
        j.f("payload", nVar);
        this.f3115w = false;
    }

    public final void h() {
        p0 p0Var = qb.h.f13493a;
        t tVar = this.f3101i;
        if (tVar != null) {
            this.f3104l.d(tVar, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r0 == null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        xa.j.c(r3);
        r3.c(10, (dc.n) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        if ((r6 instanceof cc.e) == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        r6 = (cc.e) r6;
        xa.j.c(r3);
        r3.e(r6.f3088a, r6.f3089b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008f, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.f3109q -= (long) r6.f3089b.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a3, code lost:
        if ((r6 instanceof cc.c) == false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a5, code lost:
        r6 = (cc.c) r6;
        xa.j.c(r3);
        r0 = r6.f3085a;
        r6 = r6.f3086b;
        r7 = dc.n.f4803l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        if (r0 != 0) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b2, code lost:
        if (r6 == null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        if (r0 == 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b6, code lost:
        cc.j.f3123a.getClass();
        r7 = cc.j.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bf, code lost:
        if (r7 != null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c1, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c2, code lost:
        if (r2 == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c5, code lost:
        xa.j.c(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d1, code lost:
        throw new java.lang.IllegalArgumentException(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d2, code lost:
        r2 = new dc.j();
        r2.U0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00da, code lost:
        if (r6 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00dc, code lost:
        r2.N0(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00df, code lost:
        r7 = r2.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r3.c(8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r3.f3148p = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ea, code lost:
        if (r5 == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ec, code lost:
        r0 = r1.f3094b;
        xa.j.c(r8);
        r0.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f4, code lost:
        if (r5 == null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        qb.f.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f9, code lost:
        if (r9 == null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fb, code lost:
        qb.f.b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00fe, code lost:
        if (r10 == null) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0100, code lost:
        qb.f.b(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0103, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0104, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0105, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r3.f3148p = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0108, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010e, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x010f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0110, code lost:
        if (r5 != null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0112, code lost:
        qb.f.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0115, code lost:
        if (r9 != null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0117, code lost:
        qb.f.b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x011a, code lost:
        if (r10 != null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x011c, code lost:
        qb.f.b(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x011f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            boolean r0 = r1.f3113u     // Catch:{ all -> 0x0120 }
            r2 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r17)
            return r2
        L_0x000a:
            cc.m r3 = r1.f3103k     // Catch:{ all -> 0x0120 }
            java.util.ArrayDeque r0 = r1.f3107o     // Catch:{ all -> 0x0120 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0120 }
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L_0x006a
            java.util.ArrayDeque r6 = r1.f3108p     // Catch:{ all -> 0x0120 }
            java.lang.Object r6 = r6.poll()     // Catch:{ all -> 0x0120 }
            boolean r7 = r6 instanceof cc.c     // Catch:{ all -> 0x0120 }
            if (r7 == 0) goto L_0x0066
            int r7 = r1.f3111s     // Catch:{ all -> 0x0120 }
            java.lang.String r8 = r1.f3112t     // Catch:{ all -> 0x0120 }
            r9 = -1
            if (r7 == r9) goto L_0x003a
            tb.q r7 = r1.f3106n     // Catch:{ all -> 0x0120 }
            r1.f3106n = r5     // Catch:{ all -> 0x0120 }
            cc.l r9 = r1.f3102j     // Catch:{ all -> 0x0120 }
            r1.f3102j = r5     // Catch:{ all -> 0x0120 }
            cc.m r10 = r1.f3103k     // Catch:{ all -> 0x0120 }
            r1.f3103k = r5     // Catch:{ all -> 0x0120 }
            sb.c r5 = r1.f3104l     // Catch:{ all -> 0x0120 }
            r5.f()     // Catch:{ all -> 0x0120 }
            r5 = r7
            goto L_0x006e
        L_0x003a:
            r7 = r6
            cc.c r7 = (cc.c) r7     // Catch:{ all -> 0x0120 }
            long r9 = r7.f3087c     // Catch:{ all -> 0x0120 }
            sb.c r11 = r1.f3104l     // Catch:{ all -> 0x0120 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0120 }
            r7.<init>()     // Catch:{ all -> 0x0120 }
            java.lang.String r12 = r1.f3105m     // Catch:{ all -> 0x0120 }
            r7.append(r12)     // Catch:{ all -> 0x0120 }
            java.lang.String r12 = " cancel"
            r7.append(r12)     // Catch:{ all -> 0x0120 }
            java.lang.String r12 = r7.toString()     // Catch:{ all -> 0x0120 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0120 }
            long r13 = r7.toNanos(r9)     // Catch:{ all -> 0x0120 }
            ec.e r15 = new ec.e     // Catch:{ all -> 0x0120 }
            r15.<init>(r4, r1)     // Catch:{ all -> 0x0120 }
            r16 = 4
            sb.c.c(r11, r12, r13, r15, r16)     // Catch:{ all -> 0x0120 }
            r9 = r5
            goto L_0x006d
        L_0x0066:
            if (r6 != 0) goto L_0x006b
            monitor-exit(r17)
            return r2
        L_0x006a:
            r6 = r5
        L_0x006b:
            r8 = r5
            r9 = r8
        L_0x006d:
            r10 = r9
        L_0x006e:
            la.v r7 = la.v.f9814a     // Catch:{ all -> 0x0120 }
            monitor-exit(r17)
            if (r0 == 0) goto L_0x007f
            xa.j.c(r3)     // Catch:{ all -> 0x010f }
            dc.n r0 = (dc.n) r0     // Catch:{ all -> 0x010f }
            r2 = 10
            r3.c(r2, r0)     // Catch:{ all -> 0x010f }
            goto L_0x00f4
        L_0x007f:
            boolean r0 = r6 instanceof cc.e     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x00a1
            cc.e r6 = (cc.e) r6     // Catch:{ all -> 0x010f }
            xa.j.c(r3)     // Catch:{ all -> 0x010f }
            int r0 = r6.f3088a     // Catch:{ all -> 0x010f }
            dc.n r2 = r6.f3089b     // Catch:{ all -> 0x010f }
            r3.e(r0, r2)     // Catch:{ all -> 0x010f }
            monitor-enter(r17)     // Catch:{ all -> 0x010f }
            long r2 = r1.f3109q     // Catch:{ all -> 0x009e }
            dc.n r0 = r6.f3089b     // Catch:{ all -> 0x009e }
            int r0 = r0.d()     // Catch:{ all -> 0x009e }
            long r6 = (long) r0     // Catch:{ all -> 0x009e }
            long r2 = r2 - r6
            r1.f3109q = r2     // Catch:{ all -> 0x009e }
            monitor-exit(r17)     // Catch:{ all -> 0x010f }
            goto L_0x00f4
        L_0x009e:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x010f }
            throw r0     // Catch:{ all -> 0x010f }
        L_0x00a1:
            boolean r0 = r6 instanceof cc.c     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x0109
            cc.c r6 = (cc.c) r6     // Catch:{ all -> 0x010f }
            xa.j.c(r3)     // Catch:{ all -> 0x010f }
            int r0 = r6.f3085a     // Catch:{ all -> 0x010f }
            dc.n r6 = r6.f3086b     // Catch:{ all -> 0x010f }
            dc.n r7 = dc.n.f4803l     // Catch:{ all -> 0x010f }
            if (r0 != 0) goto L_0x00b4
            if (r6 == 0) goto L_0x00e3
        L_0x00b4:
            if (r0 == 0) goto L_0x00d2
            cc.j r7 = cc.j.f3123a     // Catch:{ all -> 0x010f }
            r7.getClass()     // Catch:{ all -> 0x010f }
            java.lang.String r7 = cc.j.a(r0)     // Catch:{ all -> 0x010f }
            if (r7 != 0) goto L_0x00c2
            r2 = 1
        L_0x00c2:
            if (r2 == 0) goto L_0x00c5
            goto L_0x00d2
        L_0x00c5:
            xa.j.c(r7)     // Catch:{ all -> 0x010f }
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x010f }
            r0.<init>(r2)     // Catch:{ all -> 0x010f }
            throw r0     // Catch:{ all -> 0x010f }
        L_0x00d2:
            dc.j r2 = new dc.j     // Catch:{ all -> 0x010f }
            r2.<init>()     // Catch:{ all -> 0x010f }
            r2.U0(r0)     // Catch:{ all -> 0x010f }
            if (r6 == 0) goto L_0x00df
            r2.N0(r6)     // Catch:{ all -> 0x010f }
        L_0x00df:
            dc.n r7 = r2.m()     // Catch:{ all -> 0x010f }
        L_0x00e3:
            r0 = 8
            r3.c(r0, r7)     // Catch:{ all -> 0x0104 }
            r3.f3148p = r4     // Catch:{ all -> 0x010f }
            if (r5 == 0) goto L_0x00f4
            pb.z1 r0 = r1.f3094b     // Catch:{ all -> 0x010f }
            xa.j.c(r8)     // Catch:{ all -> 0x010f }
            r0.getClass()     // Catch:{ all -> 0x010f }
        L_0x00f4:
            if (r5 == 0) goto L_0x00f9
            qb.f.b(r5)
        L_0x00f9:
            if (r9 == 0) goto L_0x00fe
            qb.f.b(r9)
        L_0x00fe:
            if (r10 == 0) goto L_0x0103
            qb.f.b(r10)
        L_0x0103:
            return r4
        L_0x0104:
            r0 = move-exception
            r2 = r0
            r3.f3148p = r4     // Catch:{ all -> 0x010f }
            throw r2     // Catch:{ all -> 0x010f }
        L_0x0109:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x010f }
            r0.<init>()     // Catch:{ all -> 0x010f }
            throw r0     // Catch:{ all -> 0x010f }
        L_0x010f:
            r0 = move-exception
            if (r5 == 0) goto L_0x0115
            qb.f.b(r5)
        L_0x0115:
            if (r9 == 0) goto L_0x011a
            qb.f.b(r9)
        L_0x011a:
            if (r10 == 0) goto L_0x011f
            qb.f.b(r10)
        L_0x011f:
            throw r0
        L_0x0120:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.g.i():boolean");
    }
}
