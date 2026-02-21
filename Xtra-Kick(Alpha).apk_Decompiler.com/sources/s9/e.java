package s9;

import android.content.ContentResolver;
import androidx.lifecycle.p1;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import la.f;
import la.o;
import la.v;
import ma.b0;
import p9.b;
import p9.d;
import w9.a;
import xa.j;
import y9.g;
import y9.h;
import y9.l;
import y9.n;
import y9.t;

public final class e implements c {
    public final b A;
    public final h B;
    public final long C;
    public final l D;
    public final a E;
    public final boolean F;
    public final String G;
    public final boolean H;
    public final y9.b I;
    public final boolean J;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f14415h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f14416i;

    /* renamed from: j  reason: collision with root package name */
    public u9.b f14417j;

    /* renamed from: k  reason: collision with root package name */
    public final o f14418k = f.b(new p1(21, this));

    /* renamed from: l  reason: collision with root package name */
    public volatile long f14419l;

    /* renamed from: m  reason: collision with root package name */
    public volatile long f14420m = -1;

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f14421n;

    /* renamed from: o  reason: collision with root package name */
    public double f14422o;

    /* renamed from: p  reason: collision with root package name */
    public final y9.a f14423p = new y9.a(5);

    /* renamed from: q  reason: collision with root package name */
    public long f14424q = -1;

    /* renamed from: r  reason: collision with root package name */
    public ExecutorService f14425r;

    /* renamed from: s  reason: collision with root package name */
    public volatile int f14426s;

    /* renamed from: t  reason: collision with root package name */
    public int f14427t;

    /* renamed from: u  reason: collision with root package name */
    public final Object f14428u = new Object();

    /* renamed from: v  reason: collision with root package name */
    public volatile Throwable f14429v;

    /* renamed from: w  reason: collision with root package name */
    public List f14430w = b0.f10801h;

    /* renamed from: x  reason: collision with root package name */
    public t f14431x;

    /* renamed from: y  reason: collision with root package name */
    public int f14432y;

    /* renamed from: z  reason: collision with root package name */
    public final d f14433z = new d(0, this);

    public e(b bVar, h hVar, long j10, l lVar, a aVar, boolean z10, String str, boolean z11, y9.b bVar2, boolean z12) {
        j.g("initialDownload", bVar);
        j.g("downloader", hVar);
        j.g("logger", lVar);
        j.g("networkInfoProvider", aVar);
        j.g("fileTempDir", str);
        j.g("storageResolver", bVar2);
        this.A = bVar;
        this.B = hVar;
        this.C = j10;
        this.D = lVar;
        this.E = aVar;
        this.F = z10;
        this.G = str;
        this.H = z11;
        this.I = bVar2;
        this.J = z12;
    }

    public static final void a(e eVar) {
        synchronized (eVar.f14428u) {
            eVar.f14426s++;
            v vVar = v.f9814a;
        }
    }

    public final boolean H0() {
        return this.f14415h;
    }

    public final void Y() {
        u9.b bVar = this.f14417j;
        if (!(bVar instanceof u9.b)) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f15441a = true;
        }
        this.f14416i = true;
    }

    public final q9.e Z() {
        e().f13440o = this.f14419l;
        e().f13441p = this.f14420m;
        return e();
    }

    public final void a0(u9.b bVar) {
        this.f14417j = bVar;
    }

    public final void b(g gVar, ArrayList arrayList) {
        boolean z10 = false;
        this.f14426s = 0;
        this.f14427t = arrayList.size();
        if (!this.I.b(gVar.f17259c)) {
            y9.b bVar = this.I;
            String str = gVar.f17259c;
            if (((q9.e) this.A).f13447v == d.INCREMENT_FILE_NAME) {
                z10 = true;
            }
            bVar.a(str, z10);
        }
        if (this.J) {
            this.I.c(gVar.f17259c, e().f13441p);
        }
        ContentResolver contentResolver = this.I.f17239a.getContentResolver();
        j.b("context.contentResolver", contentResolver);
        t z02 = h0.z0(gVar.f17259c, contentResolver);
        this.f14431x = z02;
        z02.c(0);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (!this.f14415h && !this.f14416i) {
                ExecutorService executorService = this.f14425r;
                if (executorService != null) {
                    executorService.execute(new android.support.v4.media.j((Object) this, (Object) nVar, 10));
                }
            } else {
                return;
            }
        }
    }

    public final long c() {
        double d10 = this.f14422o;
        if (d10 < ((double) 1)) {
            return 0;
        }
        return (long) Math.ceil(d10);
    }

    public final u9.b d() {
        return this.f14417j;
    }

    public final q9.e e() {
        return (q9.e) this.f14418k.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4 A[LOOP:0: B:28:0x00a9->B:46:0x00f4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List f(boolean r20, y9.g r21) {
        /*
            r19 = this;
            r0 = r19
            y9.b r1 = r0.I
            q9.e r2 = r19.e()
            java.lang.String r2 = r2.f13436k
            boolean r1 = r1.b(r2)
            if (r1 != 0) goto L_0x001b
            q9.e r1 = r19.e()
            int r1 = r1.f13433h
            java.lang.String r2 = r0.G
            hb.h0.M(r1, r2)
        L_0x001b:
            q9.e r1 = r19.e()
            int r1 = r1.f13433h
            java.lang.String r2 = r0.G
            java.lang.String r3 = "fileTempDir"
            xa.j.g(r3, r2)
            java.lang.String r1 = hb.h0.x0(r1, r2)     // Catch:{ Exception -> 0x0038 }
            java.lang.Long r1 = hb.h0.w0(r1)     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x0038
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0038 }
            int r2 = (int) r1
            goto L_0x0039
        L_0x0038:
            r2 = -1
        L_0x0039:
            r1 = 1
            if (r20 == 0) goto L_0x00f8
            boolean r6 = r0.f14421n
            if (r6 != 0) goto L_0x00f8
            y9.h r6 = r0.B
            r7 = r21
            r6.s0(r7)
            long r6 = r0.f14420m
            float r8 = (float) r6
            r9 = 1149239296(0x44800000, float:1024.0)
            float r10 = r8 / r9
            float r10 = r10 * r9
            float r9 = r9 * r10
            r11 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 < 0) goto L_0x0068
            r6 = 6
            float r7 = (float) r6
            float r8 = r8 / r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            float r7 = (float) r7
            long r7 = (long) r7
            y9.o r9 = new y9.o
            r9.<init>(r6, r7)
            goto L_0x0082
        L_0x0068:
            int r9 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r9 < 0) goto L_0x007c
            r6 = 4
            float r7 = (float) r6
            float r8 = r8 / r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            float r7 = (float) r7
            long r7 = (long) r7
            y9.o r9 = new y9.o
            r9.<init>(r6, r7)
            goto L_0x0082
        L_0x007c:
            y9.o r9 = new y9.o
            r8 = 2
            r9.<init>(r8, r6)
        L_0x0082:
            int r6 = r9.f17274a
            if (r2 == r6) goto L_0x0091
            q9.e r2 = r19.e()
            int r2 = r2.f13433h
            java.lang.String r6 = r0.G
            hb.h0.M(r2, r6)
        L_0x0091:
            q9.e r2 = r19.e()
            int r2 = r2.f13433h
            int r6 = r9.f17274a
            java.lang.String r7 = r0.G
            hb.h0.y1(r2, r6, r7)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r6 = r9.f17274a
            if (r1 > r6) goto L_0x0149
            r13 = 0
        L_0x00a9:
            boolean r7 = r0.f14415h
            if (r7 != 0) goto L_0x0149
            boolean r7 = r0.f14416i
            if (r7 != 0) goto L_0x0149
            int r7 = r9.f17274a
            if (r7 != r1) goto L_0x00b8
            long r7 = r0.f14420m
            goto L_0x00bb
        L_0x00b8:
            long r7 = r9.f17275b
            long r7 = r7 + r13
        L_0x00bb:
            y9.n r15 = new y9.n
            q9.e r10 = r19.e()
            int r11 = r10.f13433h
            q9.e r10 = r19.e()
            int r10 = r10.f13433h
            java.lang.String r12 = r0.G
            xa.j.g(r3, r12)
            java.lang.String r10 = hb.h0.f0(r10, r1, r12)     // Catch:{ Exception -> 0x00df }
            java.lang.Long r10 = hb.h0.w0(r10)     // Catch:{ Exception -> 0x00df }
            if (r10 == 0) goto L_0x00df
            long r16 = r10.longValue()     // Catch:{ Exception -> 0x00df }
            r17 = r16
            goto L_0x00e1
        L_0x00df:
            r17 = 0
        L_0x00e1:
            r10 = r15
            r12 = r1
            r4 = r15
            r15 = r7
            r10.<init>(r11, r12, r13, r15, r17)
            long r10 = r0.f14419l
            long r12 = r4.f17273e
            long r10 = r10 + r12
            r0.f14419l = r10
            r2.add(r4)
            if (r1 == r6) goto L_0x0149
            int r1 = r1 + 1
            r13 = r7
            goto L_0x00a9
        L_0x00f8:
            if (r2 == r1) goto L_0x0105
            q9.e r2 = r19.e()
            int r2 = r2.f13433h
            java.lang.String r4 = r0.G
            hb.h0.M(r2, r4)
        L_0x0105:
            q9.e r2 = r19.e()
            int r2 = r2.f13433h
            java.lang.String r4 = r0.G
            hb.h0.y1(r2, r1, r4)
            y9.n r2 = new y9.n
            q9.e r4 = r19.e()
            int r6 = r4.f13433h
            r7 = 1
            r8 = 0
            long r10 = r0.f14420m
            q9.e r4 = r19.e()
            int r4 = r4.f13433h
            java.lang.String r5 = r0.G
            xa.j.g(r3, r5)
            java.lang.String r1 = hb.h0.f0(r4, r1, r5)     // Catch:{ Exception -> 0x0138 }
            java.lang.Long r1 = hb.h0.w0(r1)     // Catch:{ Exception -> 0x0138 }
            if (r1 == 0) goto L_0x0138
            long r4 = r1.longValue()     // Catch:{ Exception -> 0x0138 }
            r12 = r4
            goto L_0x013a
        L_0x0138:
            r12 = 0
        L_0x013a:
            r5 = r2
            r5.<init>(r6, r7, r8, r10, r12)
            long r3 = r0.f14419l
            long r5 = r2.f17273e
            long r3 = r3 + r5
            r0.f14419l = r3
            java.util.List r2 = ma.q.b(r2)
        L_0x0149:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.e.f(boolean, y9.g):java.util.List");
    }

    public final boolean g() {
        return this.f14416i;
    }

    public final boolean h() {
        return ((this.f14419l > 0 && this.f14420m > 0) || this.f14421n) && this.f14419l >= this.f14420m;
    }

    public final void i(y9.f fVar) {
        if (fVar.f17250b && fVar.f17251c == -1) {
            this.f14421n = true;
        }
    }

    public final void j() {
        long j10 = this.f14419l;
        long nanoTime = System.nanoTime();
        long nanoTime2 = System.nanoTime();
        while (this.f14426s != this.f14427t && !this.f14415h && !this.f14416i) {
            e().f13440o = this.f14419l;
            e().f13441p = this.f14420m;
            boolean M0 = h0.M0(nanoTime2, System.nanoTime(), 1000);
            if (M0) {
                this.f14423p.a((double) (this.f14419l - j10));
                this.f14422o = y9.a.b(this.f14423p);
                this.f14424q = h0.t(this.f14419l, this.f14420m, c());
                j10 = this.f14419l;
            }
            if (h0.M0(nanoTime, System.nanoTime(), this.C)) {
                synchronized (this.f14428u) {
                    if (!this.f14415h && !this.f14416i) {
                        e().f13440o = this.f14419l;
                        e().f13441p = this.f14420m;
                        u9.b bVar = this.f14417j;
                        if (bVar != null) {
                            bVar.f(e());
                        }
                        e().B = this.f14424q;
                        e().C = c();
                        u9.b bVar2 = this.f14417j;
                        if (bVar2 != null) {
                            bVar2.d(e(), e().B, e().C);
                        }
                    }
                    v vVar = v.f9814a;
                }
                nanoTime = System.nanoTime();
            }
            if (M0) {
                nanoTime2 = System.nanoTime();
            }
            try {
                Thread.sleep(this.C);
            } catch (InterruptedException e10) {
                this.D.b("FileDownloader", e10);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0408 A[Catch:{ Exception -> 0x040e }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0419 A[Catch:{ Exception -> 0x041f }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0428 A[SYNTHETIC, Splitter:B:178:0x0428] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0433 A[SYNTHETIC, Splitter:B:183:0x0433] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x051b A[Catch:{ Exception -> 0x0521 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x052c A[Catch:{ Exception -> 0x0532 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x053b A[SYNTHETIC, Splitter:B:259:0x053b] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021d A[Catch:{ Exception -> 0x02be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "GET"
            java.lang.String r3 = "FileDownloader"
            r4 = -1
            r6 = 1
            p9.b r8 = r1.A     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            q9.e r8 = (q9.e) r8     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            long r8 = r8.u()     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            r1.f14419l = r8     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            p9.b r8 = r1.A     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            q9.e r8 = (q9.e) r8     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            long r8 = r8.z()     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            r1.f14420m = r8     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            q9.e r8 = r22.e()     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            long r9 = r1.f14419l     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            r8.A(r9)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            q9.e r8 = r22.e()     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            long r9 = r1.f14420m     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            r8.L(r9)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            y9.h r8 = r1.B     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            p9.b r9 = r1.A     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            y9.g r9 = hb.h0.E0(r9, r2)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            r8.C(r9)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            p9.b r8 = r1.A     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            y9.g r2 = hb.h0.E0(r8, r2)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            y9.h r8 = r1.B     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            s9.d r9 = r1.f14433z     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            y9.f r8 = r8.B(r2, r9)     // Catch:{ Exception -> 0x0439, all -> 0x0434 }
            if (r8 == 0) goto L_0x004d
            r1.i(r8)     // Catch:{ Exception -> 0x02be }
        L_0x004d:
            boolean r9 = r22.H0()     // Catch:{ Exception -> 0x02be }
            r10 = 0
            java.lang.String r12 = "empty_response_body"
            if (r9 != 0) goto L_0x01ae
            boolean r9 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r9 != 0) goto L_0x01ae
            if (r8 == 0) goto L_0x01ae
            boolean r9 = r8.e()     // Catch:{ Exception -> 0x02be }
            if (r9 != r6) goto L_0x01ae
            long r13 = r8.b()     // Catch:{ Exception -> 0x02be }
            r1.f14420m = r13     // Catch:{ Exception -> 0x02be }
            boolean r9 = r1.f14421n     // Catch:{ Exception -> 0x02be }
            if (r9 != 0) goto L_0x007c
            long r13 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            int r9 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            r2.<init>((java.lang.String) r12)     // Catch:{ Exception -> 0x02be }
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x007c:
            r1.f14419l = r10     // Catch:{ Exception -> 0x02be }
            q9.e r9 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r12 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r9.A(r12)     // Catch:{ Exception -> 0x02be }
            q9.e r9 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r12 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            r9.L(r12)     // Catch:{ Exception -> 0x02be }
            boolean r9 = r8.a()     // Catch:{ Exception -> 0x02be }
            java.util.List r9 = r1.f(r9, r2)     // Catch:{ Exception -> 0x02be }
            r1.f14430w = r9     // Catch:{ Exception -> 0x02be }
            int r9 = r9.size()     // Catch:{ Exception -> 0x02be }
            r1.f14432y = r9     // Catch:{ Exception -> 0x02be }
            y9.h r9 = r1.B     // Catch:{ Exception -> 0x00a6 }
            r9.q0(r8)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00ad
        L_0x00a6:
            r0 = move-exception
            r9 = r0
            y9.l r12 = r1.D     // Catch:{ Exception -> 0x02be }
            r12.b(r3, r9)     // Catch:{ Exception -> 0x02be }
        L_0x00ad:
            java.util.List r9 = r1.f14430w     // Catch:{ Exception -> 0x02be }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x02be }
            r12.<init>()     // Catch:{ Exception -> 0x02be }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x02be }
        L_0x00b8:
            boolean r13 = r9.hasNext()     // Catch:{ Exception -> 0x02be }
            if (r13 == 0) goto L_0x00d0
            java.lang.Object r13 = r9.next()     // Catch:{ Exception -> 0x02be }
            r14 = r13
            y9.n r14 = (y9.n) r14     // Catch:{ Exception -> 0x02be }
            boolean r14 = r14.f()     // Catch:{ Exception -> 0x02be }
            r14 = r14 ^ r6
            if (r14 == 0) goto L_0x00b8
            r12.add(r13)     // Catch:{ Exception -> 0x02be }
            goto L_0x00b8
        L_0x00d0:
            boolean r9 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r9 != 0) goto L_0x0207
            boolean r9 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r9 != 0) goto L_0x0207
            q9.e r9 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r13 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r9.A(r13)     // Catch:{ Exception -> 0x02be }
            q9.e r9 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r13 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            r9.L(r13)     // Catch:{ Exception -> 0x02be }
            java.util.List r9 = r1.f14430w     // Catch:{ Exception -> 0x02be }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x02be }
            int r14 = ma.s.i(r9)     // Catch:{ Exception -> 0x02be }
            r13.<init>(r14)     // Catch:{ Exception -> 0x02be }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x02be }
        L_0x00fd:
            boolean r14 = r9.hasNext()     // Catch:{ Exception -> 0x02be }
            if (r14 == 0) goto L_0x0137
            java.lang.Object r14 = r9.next()     // Catch:{ Exception -> 0x02be }
            y9.n r14 = (y9.n) r14     // Catch:{ Exception -> 0x02be }
            y9.d r15 = new y9.d     // Catch:{ Exception -> 0x02be }
            r15.<init>()     // Catch:{ Exception -> 0x02be }
            int r7 = r14.c()     // Catch:{ Exception -> 0x02be }
            r15.v(r7)     // Catch:{ Exception -> 0x02be }
            int r7 = r14.d()     // Catch:{ Exception -> 0x02be }
            r15.u(r7)     // Catch:{ Exception -> 0x02be }
            long r10 = r14.a()     // Catch:{ Exception -> 0x02be }
            r15.w(r10)     // Catch:{ Exception -> 0x02be }
            long r10 = r14.e()     // Catch:{ Exception -> 0x02be }
            r15.y(r10)     // Catch:{ Exception -> 0x02be }
            long r10 = r14.b()     // Catch:{ Exception -> 0x02be }
            r15.x(r10)     // Catch:{ Exception -> 0x02be }
            r13.add(r15)     // Catch:{ Exception -> 0x02be }
            r10 = 0
            goto L_0x00fd
        L_0x0137:
            boolean r7 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r7 != 0) goto L_0x0184
            boolean r7 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r7 != 0) goto L_0x0184
            q9.e r7 = r22.e()     // Catch:{ Exception -> 0x02be }
            r7.E(r4)     // Catch:{ Exception -> 0x02be }
            q9.e r7 = r22.e()     // Catch:{ Exception -> 0x02be }
            r7.B(r4)     // Catch:{ Exception -> 0x02be }
            u9.b r7 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r7 == 0) goto L_0x0162
            q9.e r9 = r22.e()     // Catch:{ Exception -> 0x02be }
            int r10 = r1.f14432y     // Catch:{ Exception -> 0x02be }
            r7.e(r9, r13, r10)     // Catch:{ Exception -> 0x02be }
            la.v r7 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x0162:
            java.util.Iterator r7 = r13.iterator()     // Catch:{ Exception -> 0x02be }
        L_0x0166:
            boolean r9 = r7.hasNext()     // Catch:{ Exception -> 0x02be }
            if (r9 == 0) goto L_0x0184
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x02be }
            y9.d r9 = (y9.d) r9     // Catch:{ Exception -> 0x02be }
            u9.b r10 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r10 == 0) goto L_0x0166
            q9.e r11 = r22.e()     // Catch:{ Exception -> 0x02be }
            int r13 = r1.f14432y     // Catch:{ Exception -> 0x02be }
            r10.b(r11, r9, r13)     // Catch:{ Exception -> 0x02be }
            la.v r9 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
            goto L_0x0166
        L_0x0184:
            boolean r7 = r12.isEmpty()     // Catch:{ Exception -> 0x02be }
            r7 = r7 ^ r6
            if (r7 == 0) goto L_0x0195
            int r7 = r12.size()     // Catch:{ Exception -> 0x02be }
            java.util.concurrent.ExecutorService r7 = java.util.concurrent.Executors.newFixedThreadPool(r7)     // Catch:{ Exception -> 0x02be }
            r1.f14425r = r7     // Catch:{ Exception -> 0x02be }
        L_0x0195:
            r1.b(r2, r12)     // Catch:{ Exception -> 0x02be }
            r22.j()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r2.A(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            r2.L(r9)     // Catch:{ Exception -> 0x02be }
            goto L_0x0207
        L_0x01ae:
            if (r8 != 0) goto L_0x01c9
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x01c9
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x01c9
            boolean r2 = r22.h()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x01c3
            goto L_0x01c9
        L_0x01c3:
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            r2.<init>((java.lang.String) r12)     // Catch:{ Exception -> 0x02be }
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x01c9:
            if (r8 == 0) goto L_0x01ec
            boolean r2 = r8.e()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x01ec
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x01ec
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x01ec
            boolean r2 = r22.h()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x01e4
            goto L_0x01ec
        L_0x01e4:
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = "request_not_successful"
            r2.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x02be }
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x01ec:
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0207
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0207
            boolean r2 = r22.h()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x01ff
            goto L_0x0207
        L_0x01ff:
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = "unknown"
            r2.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x02be }
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x0207:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r2.A(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            r2.L(r9)     // Catch:{ Exception -> 0x02be }
            java.lang.Throwable r2 = r1.f14429v     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0433
            boolean r2 = r22.h()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0271
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0271
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0271
            u9.b r2 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x023e
            q9.e r7 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.f(r7)     // Catch:{ Exception -> 0x02be }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x023e:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14424q     // Catch:{ Exception -> 0x02be }
            r2.E(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r22.c()     // Catch:{ Exception -> 0x02be }
            r2.B(r9)     // Catch:{ Exception -> 0x02be }
            u9.b r16 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r16 == 0) goto L_0x0404
            q9.e r17 = r22.e()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r18 = r2.w()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r20 = r2.v()     // Catch:{ Exception -> 0x02be }
            r16.d(r17, r18, r20)     // Catch:{ Exception -> 0x02be }
            goto L_0x0402
        L_0x0271:
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            boolean r2 = r22.h()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x0404
            boolean r2 = r1.f14421n     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x02c0
            java.util.List r2 = r1.f14430w     // Catch:{ Exception -> 0x02be }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x02be }
            r10 = 0
        L_0x028f:
            boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x02be }
            if (r7 == 0) goto L_0x02a1
            java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x02be }
            y9.n r7 = (y9.n) r7     // Catch:{ Exception -> 0x02be }
            long r12 = r7.a()     // Catch:{ Exception -> 0x02be }
            long r10 = r10 + r12
            goto L_0x028f
        L_0x02a1:
            long r12 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x02d6
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = "download_incomplete"
            r2.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x02be }
            r1.f14429v = r2     // Catch:{ Exception -> 0x02be }
            java.lang.Throwable r2 = r1.f14429v     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x02b5
            goto L_0x02d6
        L_0x02b5:
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x02b6:
            r2 = r0
            goto L_0x0517
        L_0x02b9:
            r2 = r0
            goto L_0x043c
        L_0x02bc:
            r0 = move-exception
            goto L_0x02b6
        L_0x02be:
            r0 = move-exception
            goto L_0x02b9
        L_0x02c0:
            long r9 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r1.f14420m = r9     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14419l     // Catch:{ Exception -> 0x02be }
            r2.A(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14420m     // Catch:{ Exception -> 0x02be }
            r2.L(r9)     // Catch:{ Exception -> 0x02be }
        L_0x02d6:
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x02f1
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x02f1
            u9.b r2 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x02f1
            q9.e r7 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.f(r7)     // Catch:{ Exception -> 0x02be }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x02f1:
            boolean r2 = r1.H     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x0390
            if (r8 == 0) goto L_0x037b
            y9.h r2 = r1.B     // Catch:{ Exception -> 0x02be }
            y9.g r7 = r8.d()     // Catch:{ Exception -> 0x02be }
            java.lang.String r9 = r8.c()     // Catch:{ Exception -> 0x02be }
            boolean r2 = r2.D(r7, r9)     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x037b
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            int r2 = r2.x()     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = r1.G     // Catch:{ Exception -> 0x02be }
            hb.h0.M(r2, r7)     // Catch:{ Exception -> 0x02be }
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14424q     // Catch:{ Exception -> 0x02be }
            r2.E(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r22.c()     // Catch:{ Exception -> 0x02be }
            r2.B(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.getClass()     // Catch:{ Exception -> 0x02be }
            q9.e r7 = new q9.e     // Catch:{ Exception -> 0x02be }
            r7.<init>()     // Catch:{ Exception -> 0x02be }
            hb.h0.T1(r2, r7)     // Catch:{ Exception -> 0x02be }
            u9.b r9 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r9 == 0) goto L_0x0362
            q9.e r10 = r22.e()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r11 = r2.w()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r13 = r2.v()     // Catch:{ Exception -> 0x02be }
            r9.d(r10, r11, r13)     // Catch:{ Exception -> 0x02be }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x0362:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.E(r4)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.B(r4)     // Catch:{ Exception -> 0x02be }
            u9.b r2 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x0404
            r2.a(r7)     // Catch:{ Exception -> 0x02be }
            goto L_0x0402
        L_0x037b:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            int r2 = r2.x()     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = r1.G     // Catch:{ Exception -> 0x02be }
            hb.h0.M(r2, r7)     // Catch:{ Exception -> 0x02be }
            androidx.fragment.app.y r2 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = "invalid content hash"
            r2.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x02be }
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x0390:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            int r2 = r2.x()     // Catch:{ Exception -> 0x02be }
            java.lang.String r7 = r1.G     // Catch:{ Exception -> 0x02be }
            hb.h0.M(r2, r7)     // Catch:{ Exception -> 0x02be }
            boolean r2 = r22.H0()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            boolean r2 = r22.g()     // Catch:{ Exception -> 0x02be }
            if (r2 != 0) goto L_0x0404
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r1.f14424q     // Catch:{ Exception -> 0x02be }
            r2.E(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r9 = r22.c()     // Catch:{ Exception -> 0x02be }
            r2.B(r9)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.getClass()     // Catch:{ Exception -> 0x02be }
            q9.e r7 = new q9.e     // Catch:{ Exception -> 0x02be }
            r7.<init>()     // Catch:{ Exception -> 0x02be }
            hb.h0.T1(r2, r7)     // Catch:{ Exception -> 0x02be }
            u9.b r9 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r9 == 0) goto L_0x03eb
            q9.e r10 = r22.e()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r11 = r2.w()     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            long r13 = r2.v()     // Catch:{ Exception -> 0x02be }
            r9.d(r10, r11, r13)     // Catch:{ Exception -> 0x02be }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x03eb:
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.E(r4)     // Catch:{ Exception -> 0x02be }
            q9.e r2 = r22.e()     // Catch:{ Exception -> 0x02be }
            r2.B(r4)     // Catch:{ Exception -> 0x02be }
            u9.b r2 = r22.d()     // Catch:{ Exception -> 0x02be }
            if (r2 == 0) goto L_0x0404
            r2.a(r7)     // Catch:{ Exception -> 0x02be }
        L_0x0402:
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x02be }
        L_0x0404:
            java.util.concurrent.ExecutorService r2 = r1.f14425r     // Catch:{ Exception -> 0x040e }
            if (r2 == 0) goto L_0x0415
            r2.shutdown()     // Catch:{ Exception -> 0x040e }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x040e }
            goto L_0x0415
        L_0x040e:
            r0 = move-exception
            r2 = r0
            y9.l r4 = r1.D
            r4.b(r3, r2)
        L_0x0415:
            y9.t r2 = r1.f14431x     // Catch:{ Exception -> 0x041f }
            if (r2 == 0) goto L_0x0426
            r2.close()     // Catch:{ Exception -> 0x041f }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x041f }
            goto L_0x0426
        L_0x041f:
            r0 = move-exception
            r2 = r0
            y9.l r4 = r1.D
            r4.b(r3, r2)
        L_0x0426:
            if (r8 == 0) goto L_0x0507
            y9.h r2 = r1.B     // Catch:{ Exception -> 0x042f }
        L_0x042a:
            r2.q0(r8)     // Catch:{ Exception -> 0x042f }
            goto L_0x0507
        L_0x042f:
            r0 = move-exception
            r2 = r0
            goto L_0x0502
        L_0x0433:
            throw r2     // Catch:{ Exception -> 0x02be }
        L_0x0434:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x0517
        L_0x0439:
            r0 = move-exception
            r2 = r0
            r8 = 0
        L_0x043c:
            boolean r7 = r22.H0()     // Catch:{ all -> 0x02bc }
            if (r7 != 0) goto L_0x04da
            boolean r7 = r22.g()     // Catch:{ all -> 0x02bc }
            if (r7 != 0) goto L_0x04da
            y9.l r7 = r1.D     // Catch:{ all -> 0x02bc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r9.<init>()     // Catch:{ all -> 0x02bc }
            java.lang.String r10 = "FileDownloader download:"
            r9.append(r10)     // Catch:{ all -> 0x02bc }
            q9.e r10 = r22.Z()     // Catch:{ all -> 0x02bc }
            r9.append(r10)     // Catch:{ all -> 0x02bc }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02bc }
            r7.b(r9, r2)     // Catch:{ all -> 0x02bc }
            p9.f r7 = hb.h0.i0(r2)     // Catch:{ all -> 0x02bc }
            if (r8 == 0) goto L_0x046b
            hb.h0.F(r8)     // Catch:{ all -> 0x02bc }
        L_0x046b:
            boolean r9 = r1.F     // Catch:{ all -> 0x02bc }
            if (r9 == 0) goto L_0x0498
            w9.a r9 = r1.E     // Catch:{ all -> 0x02bc }
            boolean r9 = r9.b()     // Catch:{ all -> 0x02bc }
            r9 = r9 ^ r6
            r10 = 1
        L_0x0477:
            r11 = 10
            if (r10 > r11) goto L_0x0494
            r11 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r11)     // Catch:{ InterruptedException -> 0x048d }
            w9.a r11 = r1.E     // Catch:{ all -> 0x02bc }
            boolean r11 = r11.b()     // Catch:{ all -> 0x02bc }
            if (r11 != 0) goto L_0x048a
            r9 = 1
            goto L_0x0494
        L_0x048a:
            int r10 = r10 + 1
            goto L_0x0477
        L_0x048d:
            r0 = move-exception
            r10 = r0
            y9.l r11 = r1.D     // Catch:{ all -> 0x02bc }
            r11.b(r3, r10)     // Catch:{ all -> 0x02bc }
        L_0x0494:
            if (r9 == 0) goto L_0x0498
            p9.f r7 = p9.f.NO_NETWORK_CONNECTION     // Catch:{ all -> 0x02bc }
        L_0x0498:
            q9.e r9 = r22.e()     // Catch:{ all -> 0x02bc }
            long r10 = r1.f14419l     // Catch:{ all -> 0x02bc }
            r9.A(r10)     // Catch:{ all -> 0x02bc }
            q9.e r9 = r22.e()     // Catch:{ all -> 0x02bc }
            long r10 = r1.f14420m     // Catch:{ all -> 0x02bc }
            r9.L(r10)     // Catch:{ all -> 0x02bc }
            q9.e r9 = r22.e()     // Catch:{ all -> 0x02bc }
            r9.D(r7)     // Catch:{ all -> 0x02bc }
            boolean r9 = r22.g()     // Catch:{ all -> 0x02bc }
            if (r9 != 0) goto L_0x04da
            boolean r9 = r22.H0()     // Catch:{ all -> 0x02bc }
            if (r9 != 0) goto L_0x04da
            q9.e r9 = r22.e()     // Catch:{ all -> 0x02bc }
            r9.E(r4)     // Catch:{ all -> 0x02bc }
            q9.e r9 = r22.e()     // Catch:{ all -> 0x02bc }
            r9.B(r4)     // Catch:{ all -> 0x02bc }
            u9.b r4 = r22.d()     // Catch:{ all -> 0x02bc }
            if (r4 == 0) goto L_0x04da
            q9.e r5 = r22.e()     // Catch:{ all -> 0x02bc }
            r4.c(r5, r7, r2)     // Catch:{ all -> 0x02bc }
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x02bc }
        L_0x04da:
            java.util.concurrent.ExecutorService r2 = r1.f14425r     // Catch:{ Exception -> 0x04e4 }
            if (r2 == 0) goto L_0x04eb
            r2.shutdown()     // Catch:{ Exception -> 0x04e4 }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x04e4 }
            goto L_0x04eb
        L_0x04e4:
            r0 = move-exception
            r2 = r0
            y9.l r4 = r1.D
            r4.b(r3, r2)
        L_0x04eb:
            y9.t r2 = r1.f14431x     // Catch:{ Exception -> 0x04f5 }
            if (r2 == 0) goto L_0x04fc
            r2.close()     // Catch:{ Exception -> 0x04f5 }
            la.v r2 = la.v.f9814a     // Catch:{ Exception -> 0x04f5 }
            goto L_0x04fc
        L_0x04f5:
            r0 = move-exception
            r2 = r0
            y9.l r4 = r1.D
            r4.b(r3, r2)
        L_0x04fc:
            if (r8 == 0) goto L_0x0507
            y9.h r2 = r1.B     // Catch:{ Exception -> 0x042f }
            goto L_0x042a
        L_0x0502:
            y9.l r4 = r1.D
            r4.b(r3, r2)
        L_0x0507:
            u9.b r2 = r1.f14417j
            boolean r3 = r2 instanceof u9.b
            if (r3 != 0) goto L_0x050f
            r7 = 0
            goto L_0x0510
        L_0x050f:
            r7 = r2
        L_0x0510:
            if (r7 == 0) goto L_0x0514
            r7.f15441a = r6
        L_0x0514:
            r1.f14416i = r6
            return
        L_0x0517:
            java.util.concurrent.ExecutorService r4 = r1.f14425r     // Catch:{ Exception -> 0x0521 }
            if (r4 == 0) goto L_0x0528
            r4.shutdown()     // Catch:{ Exception -> 0x0521 }
            la.v r4 = la.v.f9814a     // Catch:{ Exception -> 0x0521 }
            goto L_0x0528
        L_0x0521:
            r0 = move-exception
            r4 = r0
            y9.l r5 = r1.D
            r5.b(r3, r4)
        L_0x0528:
            y9.t r4 = r1.f14431x     // Catch:{ Exception -> 0x0532 }
            if (r4 == 0) goto L_0x0539
            r4.close()     // Catch:{ Exception -> 0x0532 }
            la.v r4 = la.v.f9814a     // Catch:{ Exception -> 0x0532 }
            goto L_0x0539
        L_0x0532:
            r0 = move-exception
            r4 = r0
            y9.l r5 = r1.D
            r5.b(r3, r4)
        L_0x0539:
            if (r8 == 0) goto L_0x0548
            y9.h r4 = r1.B     // Catch:{ Exception -> 0x0541 }
            r4.q0(r8)     // Catch:{ Exception -> 0x0541 }
            goto L_0x0548
        L_0x0541:
            r0 = move-exception
            r4 = r0
            y9.l r5 = r1.D
            r5.b(r3, r4)
        L_0x0548:
            u9.b r3 = r1.f14417j
            boolean r4 = r3 instanceof u9.b
            if (r4 != 0) goto L_0x0550
            r7 = 0
            goto L_0x0551
        L_0x0550:
            r7 = r3
        L_0x0551:
            if (r7 == 0) goto L_0x0555
            r7.f15441a = r6
        L_0x0555:
            r1.f14416i = r6
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.e.run():void");
    }

    public final void v() {
        u9.b bVar = this.f14417j;
        if (!(bVar instanceof u9.b)) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f15441a = true;
        }
        this.f14415h = true;
    }
}
