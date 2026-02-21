package wb;

import dc.k;
import dc.l;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import qb.f;
import sb.b;
import sb.c;
import sb.g;
import xa.j;
import xa.s;

public final class v implements Closeable {
    public static final l I = new l(0);
    public static final p0 J;
    public long A;
    public long B;
    public long C;
    public long D;
    public final Socket E;
    public final i0 F;
    public final q G;
    public final LinkedHashSet H;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f16311h;

    /* renamed from: i  reason: collision with root package name */
    public final o f16312i;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashMap f16313j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    public final String f16314k;

    /* renamed from: l  reason: collision with root package name */
    public int f16315l;

    /* renamed from: m  reason: collision with root package name */
    public int f16316m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f16317n;

    /* renamed from: o  reason: collision with root package name */
    public final g f16318o;

    /* renamed from: p  reason: collision with root package name */
    public final c f16319p;

    /* renamed from: q  reason: collision with root package name */
    public final c f16320q;

    /* renamed from: r  reason: collision with root package name */
    public final c f16321r;

    /* renamed from: s  reason: collision with root package name */
    public final l0 f16322s;

    /* renamed from: t  reason: collision with root package name */
    public long f16323t;

    /* renamed from: u  reason: collision with root package name */
    public long f16324u;

    /* renamed from: v  reason: collision with root package name */
    public long f16325v;

    /* renamed from: w  reason: collision with root package name */
    public long f16326w;

    /* renamed from: x  reason: collision with root package name */
    public long f16327x;

    /* renamed from: y  reason: collision with root package name */
    public final p0 f16328y;

    /* renamed from: z  reason: collision with root package name */
    public p0 f16329z;

    static {
        p0 p0Var = new p0();
        p0Var.b(7, 65535);
        p0Var.b(5, 16384);
        J = p0Var;
    }

    public v(k kVar) {
        int i10;
        boolean z10 = kVar.f16273a;
        this.f16311h = z10;
        this.f16312i = kVar.f16279g;
        String str = kVar.f16276d;
        if (str != null) {
            this.f16314k = str;
            if (z10) {
                i10 = 3;
            } else {
                i10 = 2;
            }
            this.f16316m = i10;
            g gVar = kVar.f16274b;
            this.f16318o = gVar;
            c f10 = gVar.f();
            this.f16319p = f10;
            this.f16320q = gVar.f();
            this.f16321r = gVar.f();
            this.f16322s = kVar.f16280h;
            p0 p0Var = new p0();
            if (z10) {
                p0Var.b(7, 16777216);
            }
            this.f16328y = p0Var;
            p0 p0Var2 = J;
            this.f16329z = p0Var2;
            this.D = (long) p0Var2.a();
            Socket socket = kVar.f16275c;
            if (socket != null) {
                this.E = socket;
                k kVar2 = kVar.f16278f;
                if (kVar2 != null) {
                    this.F = new i0(kVar2, z10);
                    l lVar = kVar.f16277e;
                    if (lVar != null) {
                        this.G = new q(this, new b0(lVar, z10));
                        this.H = new LinkedHashSet();
                        int i11 = kVar.f16281i;
                        if (i11 != 0) {
                            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i11);
                            String concat = str.concat(" ping");
                            j jVar = new j(0, nanos, this);
                            j.f("name", concat);
                            f10.d(new b(concat, jVar), nanos);
                            return;
                        }
                        return;
                    }
                    j.l("source");
                    throw null;
                }
                j.l("sink");
                throw null;
            }
            j.l("socket");
            throw null;
        }
        j.l("connectionName");
        throw null;
    }

    public final synchronized void N(long j10) {
        long j11 = this.A + j10;
        this.A = j11;
        long j12 = j11 - this.B;
        if (j12 >= ((long) (this.f16328y.a() / 2))) {
            Z(0, j12);
            this.B += j12;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.F.f16264k);
        r6 = (long) r3;
        r8.C += r6;
        r4 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W(int r9, boolean r10, dc.j r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            wb.i0 r12 = r8.F
            r12.e(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x006a
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.C     // Catch:{ InterruptedException -> 0x005b }
            long r5 = r8.D     // Catch:{ InterruptedException -> 0x005b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0032
            java.util.LinkedHashMap r3 = r8.f16313j     // Catch:{ InterruptedException -> 0x005b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005b }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005b }
            if (r3 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x005b }
            goto L_0x0012
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005b }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005b }
            throw r9     // Catch:{ InterruptedException -> 0x005b }
        L_0x0032:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch:{ all -> 0x0059 }
            int r4 = (int) r3     // Catch:{ all -> 0x0059 }
            wb.i0 r3 = r8.F     // Catch:{ all -> 0x0059 }
            int r3 = r3.f16264k     // Catch:{ all -> 0x0059 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0059 }
            long r4 = r8.C     // Catch:{ all -> 0x0059 }
            long r6 = (long) r3     // Catch:{ all -> 0x0059 }
            long r4 = r4 + r6
            r8.C = r4     // Catch:{ all -> 0x0059 }
            la.v r4 = la.v.f9814a     // Catch:{ all -> 0x0059 }
            monitor-exit(r8)
            long r12 = r12 - r6
            wb.i0 r4 = r8.F
            if (r10 == 0) goto L_0x0054
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            r5 = 1
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            r4.e(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0059:
            r9 = move-exception
            goto L_0x0068
        L_0x005b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0059 }
            r9.interrupt()     // Catch:{ all -> 0x0059 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0059 }
            r9.<init>()     // Catch:{ all -> 0x0059 }
            throw r9     // Catch:{ all -> 0x0059 }
        L_0x0068:
            monitor-exit(r8)
            throw r9
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.v.W(int, boolean, dc.j, long):void");
    }

    public final void Y(int i10, c cVar) {
        c cVar2 = this.f16319p;
        c.c(cVar2, this.f16314k + '[' + i10 + "] writeSynReset", 0, new t(this, i10, cVar, 1), 6);
    }

    public final void Z(int i10, long j10) {
        c cVar = this.f16319p;
        c.c(cVar, this.f16314k + '[' + i10 + "] windowUpdate", 0, new u(this, i10, j10), 6);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|5|12|(2:14|(5:16|17|18|31|19))|21|22|23|24|25|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(wb.c r4, wb.c r5, java.io.IOException r6) {
        /*
            r3 = this;
            pb.p0 r0 = qb.h.f13493a
            r3.z(r4)     // Catch:{ IOException -> 0x0005 }
        L_0x0005:
            monitor-enter(r3)
            java.util.LinkedHashMap r4 = r3.f16313j     // Catch:{ all -> 0x0055 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0055 }
            r4 = r4 ^ 1
            r0 = 0
            if (r4 == 0) goto L_0x0028
            java.util.LinkedHashMap r4 = r3.f16313j     // Catch:{ all -> 0x0055 }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x0055 }
            wb.g0[] r1 = new wb.g0[r0]     // Catch:{ all -> 0x0055 }
            java.lang.Object[] r4 = r4.toArray(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            xa.j.d(r1, r4)     // Catch:{ all -> 0x0055 }
            java.util.LinkedHashMap r1 = r3.f16313j     // Catch:{ all -> 0x0055 }
            r1.clear()     // Catch:{ all -> 0x0055 }
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0055 }
            monitor-exit(r3)
            wb.g0[] r4 = (wb.g0[]) r4
            if (r4 == 0) goto L_0x003b
            int r1 = r4.length
        L_0x0031:
            if (r0 >= r1) goto L_0x003b
            r2 = r4[r0]
            r2.c(r5, r6)     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x003b:
            wb.i0 r4 = r3.F     // Catch:{ IOException -> 0x0040 }
            r4.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            java.net.Socket r4 = r3.E     // Catch:{ IOException -> 0x0045 }
            r4.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            sb.c r4 = r3.f16319p
            r4.f()
            sb.c r4 = r3.f16320q
            r4.f()
            sb.c r4 = r3.f16321r
            r4.f()
            return
        L_0x0055:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.v.c(wb.c, wb.c, java.io.IOException):void");
    }

    public final void close() {
        c(c.NO_ERROR, c.CANCEL, (IOException) null);
    }

    public final void e(IOException iOException) {
        c cVar = c.PROTOCOL_ERROR;
        c(cVar, cVar, iOException);
    }

    public final void flush() {
        this.F.flush();
    }

    public final synchronized g0 k(int i10) {
        return (g0) this.f16313j.get(Integer.valueOf(i10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean v(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f16317n     // Catch:{ all -> 0x001b }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r6)
            return r1
        L_0x0008:
            long r2 = r6.f16326w     // Catch:{ all -> 0x001b }
            long r4 = r6.f16325v     // Catch:{ all -> 0x001b }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0018
            long r2 = r6.f16327x     // Catch:{ all -> 0x001b }
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0018
            monitor-exit(r6)
            return r1
        L_0x0018:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x001b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.v.v(long):boolean");
    }

    public final synchronized g0 w(int i10) {
        g0 g0Var;
        g0Var = (g0) this.f16313j.remove(Integer.valueOf(i10));
        notifyAll();
        return g0Var;
    }

    public final void z(c cVar) {
        synchronized (this.F) {
            s sVar = new s();
            synchronized (this) {
                if (!this.f16317n) {
                    this.f16317n = true;
                    int i10 = this.f16315l;
                    sVar.f16816h = i10;
                    la.v vVar = la.v.f9814a;
                    this.F.v(i10, cVar, f.f13487a);
                }
            }
        }
    }
}
