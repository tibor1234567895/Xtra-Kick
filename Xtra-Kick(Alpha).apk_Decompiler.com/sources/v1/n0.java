package v1;

import a2.n;
import android.net.Uri;
import android.support.v4.media.session.u;
import d2.s0;
import d2.y;
import j1.g;
import k1.e0;
import k1.h;
import k1.l;
import k1.m;

public final class n0 implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f15731a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f15732b;

    /* renamed from: c  reason: collision with root package name */
    public final u f15733c;

    /* renamed from: d  reason: collision with root package name */
    public final y f15734d;

    /* renamed from: e  reason: collision with root package name */
    public final g f15735e;

    /* renamed from: f  reason: collision with root package name */
    public final s0 f15736f = new s0();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f15737g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15738h = true;

    /* renamed from: i  reason: collision with root package name */
    public long f15739i;

    /* renamed from: j  reason: collision with root package name */
    public m f15740j;

    /* renamed from: k  reason: collision with root package name */
    public a1 f15741k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15742l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ r0 f15743m;

    public n0(r0 r0Var, Uri uri, h hVar, u uVar, y yVar, g gVar) {
        this.f15743m = r0Var;
        this.f15731a = uri;
        this.f15732b = new e0(hVar);
        this.f15733c = uVar;
        this.f15734d = yVar;
        this.f15735e = gVar;
        r.f15758a.getAndIncrement();
        this.f15740j = c(0);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00ef */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r17 = this;
            r1 = r17
            r0 = 0
            r2 = 0
        L_0x0004:
            if (r2 != 0) goto L_0x0135
            boolean r3 = r1.f15737g
            if (r3 != 0) goto L_0x0135
            r3 = -1
            r5 = 1
            d2.s0 r6 = r1.f15736f     // Catch:{ all -> 0x0116 }
            long r13 = r6.f4296a     // Catch:{ all -> 0x0116 }
            k1.m r6 = r1.c(r13)     // Catch:{ all -> 0x0116 }
            r1.f15740j = r6     // Catch:{ all -> 0x0116 }
            k1.e0 r7 = r1.f15732b     // Catch:{ all -> 0x0116 }
            long r6 = r7.q(r6)     // Catch:{ all -> 0x0116 }
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x002f
            long r6 = r6 + r13
            v1.r0 r8 = r1.f15743m     // Catch:{ all -> 0x0116 }
            android.os.Handler r9 = r8.f15774w     // Catch:{ all -> 0x0116 }
            v1.m0 r10 = new v1.m0     // Catch:{ all -> 0x0116 }
            r11 = 2
            r10.<init>(r8, r11)     // Catch:{ all -> 0x0116 }
            r9.post(r10)     // Catch:{ all -> 0x0116 }
        L_0x002f:
            r15 = r6
            v1.r0 r6 = r1.f15743m     // Catch:{ all -> 0x0116 }
            k1.e0 r7 = r1.f15732b     // Catch:{ all -> 0x0116 }
            java.util.Map r7 = r7.e()     // Catch:{ all -> 0x0116 }
            n2.c r7 = n2.c.u(r7)     // Catch:{ all -> 0x0116 }
            r6.f15776y = r7     // Catch:{ all -> 0x0116 }
            k1.e0 r6 = r1.f15732b     // Catch:{ all -> 0x0116 }
            v1.r0 r7 = r1.f15743m     // Catch:{ all -> 0x0116 }
            n2.c r7 = r7.f15776y     // Catch:{ all -> 0x0116 }
            if (r7 == 0) goto L_0x0066
            int r7 = r7.f11030m     // Catch:{ all -> 0x0116 }
            r8 = -1
            if (r7 == r8) goto L_0x0066
            v1.q r8 = new v1.q     // Catch:{ all -> 0x0116 }
            r8.<init>(r6, r7, r1)     // Catch:{ all -> 0x0116 }
            v1.r0 r6 = r1.f15743m     // Catch:{ all -> 0x0116 }
            r6.getClass()     // Catch:{ all -> 0x0116 }
            v1.p0 r7 = new v1.p0     // Catch:{ all -> 0x0116 }
            r7.<init>(r0, r5)     // Catch:{ all -> 0x0116 }
            v1.a1 r6 = r6.z(r7)     // Catch:{ all -> 0x0116 }
            r1.f15741k = r6     // Catch:{ all -> 0x0116 }
            g1.a0 r7 = v1.r0.U     // Catch:{ all -> 0x0116 }
            r6.a(r7)     // Catch:{ all -> 0x0116 }
            goto L_0x0067
        L_0x0066:
            r8 = r6
        L_0x0067:
            android.support.v4.media.session.u r7 = r1.f15733c     // Catch:{ all -> 0x0116 }
            android.net.Uri r9 = r1.f15731a     // Catch:{ all -> 0x0116 }
            k1.e0 r6 = r1.f15732b     // Catch:{ all -> 0x0116 }
            java.util.Map r10 = r6.e()     // Catch:{ all -> 0x0116 }
            d2.y r6 = r1.f15734d     // Catch:{ all -> 0x0116 }
            r11 = r13
            r3 = r13
            r13 = r15
            r15 = r6
            r7.D(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x0116 }
            v1.r0 r6 = r1.f15743m     // Catch:{ all -> 0x0116 }
            n2.c r6 = r6.f15776y     // Catch:{ all -> 0x0116 }
            if (r6 == 0) goto L_0x0091
            android.support.v4.media.session.u r6 = r1.f15733c     // Catch:{ all -> 0x0116 }
            java.lang.Object r6 = r6.f429j     // Catch:{ all -> 0x0116 }
            r7 = r6
            d2.v r7 = (d2.v) r7     // Catch:{ all -> 0x0116 }
            boolean r7 = r7 instanceof t2.d     // Catch:{ all -> 0x0116 }
            if (r7 == 0) goto L_0x0091
            d2.v r6 = (d2.v) r6     // Catch:{ all -> 0x0116 }
            t2.d r6 = (t2.d) r6     // Catch:{ all -> 0x0116 }
            r6.f14518r = r5     // Catch:{ all -> 0x0116 }
        L_0x0091:
            boolean r6 = r1.f15738h     // Catch:{ all -> 0x0116 }
            if (r6 == 0) goto L_0x00a5
            android.support.v4.media.session.u r6 = r1.f15733c     // Catch:{ all -> 0x0116 }
            long r7 = r1.f15739i     // Catch:{ all -> 0x0116 }
            java.lang.Object r6 = r6.f429j     // Catch:{ all -> 0x0116 }
            d2.v r6 = (d2.v) r6     // Catch:{ all -> 0x0116 }
            r6.getClass()     // Catch:{ all -> 0x0116 }
            r6.c(r3, r7)     // Catch:{ all -> 0x0116 }
            r1.f15738h = r0     // Catch:{ all -> 0x0116 }
        L_0x00a5:
            r13 = r3
        L_0x00a6:
            if (r2 != 0) goto L_0x00f5
            boolean r3 = r1.f15737g     // Catch:{ all -> 0x0116 }
            if (r3 != 0) goto L_0x00f5
            j1.g r3 = r1.f15735e     // Catch:{ InterruptedException -> 0x00ef }
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x00ef }
        L_0x00af:
            boolean r4 = r3.f8430a     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x00b7
            r3.wait()     // Catch:{ all -> 0x00ec }
            goto L_0x00af
        L_0x00b7:
            monitor-exit(r3)     // Catch:{ InterruptedException -> 0x00ef }
            android.support.v4.media.session.u r3 = r1.f15733c     // Catch:{ all -> 0x0116 }
            d2.s0 r4 = r1.f15736f     // Catch:{ all -> 0x0116 }
            java.lang.Object r6 = r3.f429j     // Catch:{ all -> 0x0116 }
            d2.v r6 = (d2.v) r6     // Catch:{ all -> 0x0116 }
            r6.getClass()     // Catch:{ all -> 0x0116 }
            java.lang.Object r3 = r3.f430k     // Catch:{ all -> 0x0116 }
            d2.w r3 = (d2.w) r3     // Catch:{ all -> 0x0116 }
            r3.getClass()     // Catch:{ all -> 0x0116 }
            int r2 = r6.d(r3, r4)     // Catch:{ all -> 0x0116 }
            android.support.v4.media.session.u r3 = r1.f15733c     // Catch:{ all -> 0x0116 }
            long r3 = r3.t()     // Catch:{ all -> 0x0116 }
            v1.r0 r6 = r1.f15743m     // Catch:{ all -> 0x0116 }
            long r6 = r6.f15768q     // Catch:{ all -> 0x0116 }
            long r6 = r6 + r13
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a6
            j1.g r6 = r1.f15735e     // Catch:{ all -> 0x0116 }
            r6.a()     // Catch:{ all -> 0x0116 }
            v1.r0 r6 = r1.f15743m     // Catch:{ all -> 0x0116 }
            android.os.Handler r7 = r6.f15774w     // Catch:{ all -> 0x0116 }
            v1.m0 r6 = r6.f15773v     // Catch:{ all -> 0x0116 }
            r7.post(r6)     // Catch:{ all -> 0x0116 }
            goto L_0x00a5
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedException -> 0x00ef }
            throw r0     // Catch:{ InterruptedException -> 0x00ef }
        L_0x00ef:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0116 }
            r0.<init>()     // Catch:{ all -> 0x0116 }
            throw r0     // Catch:{ all -> 0x0116 }
        L_0x00f5:
            if (r2 != r5) goto L_0x00f9
            r2 = 0
            goto L_0x010f
        L_0x00f9:
            android.support.v4.media.session.u r3 = r1.f15733c
            long r3 = r3.t()
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x010f
            d2.s0 r3 = r1.f15736f
            android.support.v4.media.session.u r4 = r1.f15733c
            long r4 = r4.t()
            r3.f4296a = r4
        L_0x010f:
            k1.e0 r3 = r1.f15732b
            k1.k.a(r3)
            goto L_0x0004
        L_0x0116:
            r0 = move-exception
            if (r2 == r5) goto L_0x012f
            android.support.v4.media.session.u r2 = r1.f15733c
            long r2 = r2.t()
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x012f
            d2.s0 r2 = r1.f15736f
            android.support.v4.media.session.u r3 = r1.f15733c
            long r3 = r3.t()
            r2.f4296a = r3
        L_0x012f:
            k1.e0 r2 = r1.f15732b
            k1.k.a(r2)
            throw r0
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.n0.a():void");
    }

    public final void b() {
        this.f15737g = true;
    }

    public final m c(long j10) {
        l lVar = new l();
        lVar.f9013a = this.f15731a;
        lVar.f9017e = j10;
        lVar.f9019g = this.f15743m.f15767p;
        lVar.f9020h = 6;
        lVar.f9016d = r0.T;
        return lVar.a();
    }
}
