package k4;

import dc.f0;
import dc.k;
import dc.z;
import fb.l;
import fb.w;
import fb.y;
import hb.d2;
import hb.h0;
import hb.l1;
import hb.o1;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import mb.f;
import nb.d;
import p1.i0;
import pa.e;
import pa.h;
import xa.j;

public final class i implements Closeable, Flushable {

    /* renamed from: x  reason: collision with root package name */
    public static final l f9099x = new l("[a-z0-9_-]{1,120}");

    /* renamed from: h  reason: collision with root package name */
    public final f0 f9100h;

    /* renamed from: i  reason: collision with root package name */
    public final long f9101i;

    /* renamed from: j  reason: collision with root package name */
    public final f0 f9102j;

    /* renamed from: k  reason: collision with root package name */
    public final f0 f9103k;

    /* renamed from: l  reason: collision with root package name */
    public final f0 f9104l;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashMap f9105m;

    /* renamed from: n  reason: collision with root package name */
    public final f f9106n;

    /* renamed from: o  reason: collision with root package name */
    public long f9107o;

    /* renamed from: p  reason: collision with root package name */
    public int f9108p;

    /* renamed from: q  reason: collision with root package name */
    public k f9109q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9110r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9111s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f9112t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f9113u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f9114v;

    /* renamed from: w  reason: collision with root package name */
    public final g f9115w;

    static {
        new d(0);
    }

    public i(z zVar, f0 f0Var, d dVar, long j10) {
        boolean z10;
        this.f9100h = f0Var;
        this.f9101i = j10;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f9102j = f0Var.c("journal");
            this.f9103k = f0Var.c("journal.tmp");
            this.f9104l = f0Var.c("journal.bkp");
            this.f9105m = new LinkedHashMap(0, 0.75f, true);
            pa.k j12 = h0.j1(new d2((l1) null), dVar.P0(1));
            this.f9106n = new f(j12.N(l1.f7823b) == null ? j12.I0(new o1((l1) null)) : j12);
            this.f9115w = new g(zVar);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public static void H0(String str) {
        if (!f9099x.b(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0111, code lost:
        if (r1 != false) goto L_0x0113;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(k4.i r9, p1.i0 r10, boolean r11) {
        /*
            monitor-enter(r9)
            java.lang.Object r0 = r10.f12465j     // Catch:{ all -> 0x0124 }
            k4.e r0 = (k4.e) r0     // Catch:{ all -> 0x0124 }
            p1.i0 r1 = r0.f9091g     // Catch:{ all -> 0x0124 }
            boolean r1 = xa.j.a(r1, r10)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x0118
            r1 = 0
            r2 = 2
            if (r11 == 0) goto L_0x0092
            boolean r3 = r0.f9090f     // Catch:{ all -> 0x0124 }
            if (r3 != 0) goto L_0x0092
            r3 = 0
        L_0x0016:
            if (r3 >= r2) goto L_0x0038
            java.lang.Object r4 = r10.f12466k     // Catch:{ all -> 0x0124 }
            boolean[] r4 = (boolean[]) r4     // Catch:{ all -> 0x0124 }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0124 }
            if (r4 == 0) goto L_0x0035
            k4.g r4 = r9.f9115w     // Catch:{ all -> 0x0124 }
            java.util.ArrayList r5 = r0.f9088d     // Catch:{ all -> 0x0124 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0124 }
            dc.f0 r5 = (dc.f0) r5     // Catch:{ all -> 0x0124 }
            boolean r4 = r4.f(r5)     // Catch:{ all -> 0x0124 }
            if (r4 != 0) goto L_0x0035
            r10.c()     // Catch:{ all -> 0x0124 }
            goto L_0x0116
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0038:
            r10 = 0
        L_0x0039:
            if (r10 >= r2) goto L_0x00a5
            java.util.ArrayList r3 = r0.f9088d     // Catch:{ all -> 0x0124 }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ all -> 0x0124 }
            dc.f0 r3 = (dc.f0) r3     // Catch:{ all -> 0x0124 }
            java.util.ArrayList r4 = r0.f9087c     // Catch:{ all -> 0x0124 }
            java.lang.Object r4 = r4.get(r10)     // Catch:{ all -> 0x0124 }
            dc.f0 r4 = (dc.f0) r4     // Catch:{ all -> 0x0124 }
            k4.g r5 = r9.f9115w     // Catch:{ all -> 0x0124 }
            boolean r5 = r5.f(r3)     // Catch:{ all -> 0x0124 }
            if (r5 == 0) goto L_0x0059
            k4.g r5 = r9.f9115w     // Catch:{ all -> 0x0124 }
            r5.b(r3, r4)     // Catch:{ all -> 0x0124 }
            goto L_0x0070
        L_0x0059:
            k4.g r3 = r9.f9115w     // Catch:{ all -> 0x0124 }
            java.util.ArrayList r5 = r0.f9087c     // Catch:{ all -> 0x0124 }
            java.lang.Object r5 = r5.get(r10)     // Catch:{ all -> 0x0124 }
            dc.f0 r5 = (dc.f0) r5     // Catch:{ all -> 0x0124 }
            boolean r6 = r3.f(r5)     // Catch:{ all -> 0x0124 }
            if (r6 != 0) goto L_0x0070
            dc.n0 r3 = r3.k(r5)     // Catch:{ all -> 0x0124 }
            w4.e.a(r3)     // Catch:{ all -> 0x0124 }
        L_0x0070:
            long[] r3 = r0.f9086b     // Catch:{ all -> 0x0124 }
            r5 = r3[r10]     // Catch:{ all -> 0x0124 }
            k4.g r3 = r9.f9115w     // Catch:{ all -> 0x0124 }
            dc.p r3 = r3.h(r4)     // Catch:{ all -> 0x0124 }
            java.lang.Long r3 = r3.f4814d     // Catch:{ all -> 0x0124 }
            if (r3 == 0) goto L_0x0083
            long r3 = r3.longValue()     // Catch:{ all -> 0x0124 }
            goto L_0x0085
        L_0x0083:
            r3 = 0
        L_0x0085:
            long[] r7 = r0.f9086b     // Catch:{ all -> 0x0124 }
            r7[r10] = r3     // Catch:{ all -> 0x0124 }
            long r7 = r9.f9107o     // Catch:{ all -> 0x0124 }
            long r7 = r7 - r5
            long r7 = r7 + r3
            r9.f9107o = r7     // Catch:{ all -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x0039
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 >= r2) goto L_0x00a5
            k4.g r3 = r9.f9115w     // Catch:{ all -> 0x0124 }
            java.util.ArrayList r4 = r0.f9088d     // Catch:{ all -> 0x0124 }
            java.lang.Object r4 = r4.get(r10)     // Catch:{ all -> 0x0124 }
            dc.f0 r4 = (dc.f0) r4     // Catch:{ all -> 0x0124 }
            r3.e(r4)     // Catch:{ all -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x0093
        L_0x00a5:
            r10 = 0
            r0.f9091g = r10     // Catch:{ all -> 0x0124 }
            boolean r10 = r0.f9090f     // Catch:{ all -> 0x0124 }
            if (r10 == 0) goto L_0x00b0
            r9.a0(r0)     // Catch:{ all -> 0x0124 }
            goto L_0x0116
        L_0x00b0:
            int r10 = r9.f9108p     // Catch:{ all -> 0x0124 }
            r2 = 1
            int r10 = r10 + r2
            r9.f9108p = r10     // Catch:{ all -> 0x0124 }
            dc.k r10 = r9.f9109q     // Catch:{ all -> 0x0124 }
            xa.j.c(r10)     // Catch:{ all -> 0x0124 }
            r3 = 32
            if (r11 != 0) goto L_0x00d9
            boolean r11 = r0.f9089e     // Catch:{ all -> 0x0124 }
            if (r11 == 0) goto L_0x00c4
            goto L_0x00d9
        L_0x00c4:
            java.util.LinkedHashMap r11 = r9.f9105m     // Catch:{ all -> 0x0124 }
            java.lang.String r4 = r0.f9085a     // Catch:{ all -> 0x0124 }
            r11.remove(r4)     // Catch:{ all -> 0x0124 }
            java.lang.String r11 = "REMOVE"
            r10.v0(r11)     // Catch:{ all -> 0x0124 }
            r10.S(r3)     // Catch:{ all -> 0x0124 }
            java.lang.String r11 = r0.f9085a     // Catch:{ all -> 0x0124 }
            r10.v0(r11)     // Catch:{ all -> 0x0124 }
            goto L_0x00fa
        L_0x00d9:
            r0.f9089e = r2     // Catch:{ all -> 0x0124 }
            java.lang.String r11 = "CLEAN"
            r10.v0(r11)     // Catch:{ all -> 0x0124 }
            r10.S(r3)     // Catch:{ all -> 0x0124 }
            java.lang.String r11 = r0.f9085a     // Catch:{ all -> 0x0124 }
            r10.v0(r11)     // Catch:{ all -> 0x0124 }
            long[] r11 = r0.f9086b     // Catch:{ all -> 0x0124 }
            int r0 = r11.length     // Catch:{ all -> 0x0124 }
            r4 = 0
        L_0x00ec:
            if (r4 >= r0) goto L_0x00fa
            r5 = r11[r4]     // Catch:{ all -> 0x0124 }
            dc.k r7 = r10.S(r3)     // Catch:{ all -> 0x0124 }
            r7.w0(r5)     // Catch:{ all -> 0x0124 }
            int r4 = r4 + 1
            goto L_0x00ec
        L_0x00fa:
            r11 = 10
            r10.S(r11)     // Catch:{ all -> 0x0124 }
            r10.flush()     // Catch:{ all -> 0x0124 }
            long r10 = r9.f9107o     // Catch:{ all -> 0x0124 }
            long r3 = r9.f9101i     // Catch:{ all -> 0x0124 }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0113
            int r10 = r9.f9108p     // Catch:{ all -> 0x0124 }
            r11 = 2000(0x7d0, float:2.803E-42)
            if (r10 < r11) goto L_0x0111
            r1 = 1
        L_0x0111:
            if (r1 == 0) goto L_0x0116
        L_0x0113:
            r9.z()     // Catch:{ all -> 0x0124 }
        L_0x0116:
            monitor-exit(r9)
            return
        L_0x0118:
            java.lang.String r10 = "Check failed."
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0124 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0124 }
            r11.<init>(r10)     // Catch:{ all -> 0x0124 }
            throw r11     // Catch:{ all -> 0x0124 }
        L_0x0124:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.i.c(k4.i, p1.i0, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e A[Catch:{ all -> 0x0083, all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc A[SYNTHETIC, Splitter:B:38:0x00dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void I0() {
        /*
            r12 = this;
            monitor-enter(r12)
            dc.k r0 = r12.f9109q     // Catch:{ all -> 0x00dd }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00dd }
        L_0x0008:
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r1 = r12.f9103k     // Catch:{ all -> 0x00dd }
            dc.n0 r0 = r0.k(r1)     // Catch:{ all -> 0x00dd }
            dc.h0 r0 = hb.h0.n(r0)     // Catch:{ all -> 0x00dd }
            r1 = 0
            r2 = 0
            java.lang.String r3 = "libcore.io.DiskLruCache"
            r0.v0(r3)     // Catch:{ all -> 0x0083 }
            r3 = 10
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "1"
            r0.v0(r4)     // Catch:{ all -> 0x0083 }
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            r4 = 1
            long r4 = (long) r4     // Catch:{ all -> 0x0083 }
            r0.w0(r4)     // Catch:{ all -> 0x0083 }
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            r4 = 2
            long r4 = (long) r4     // Catch:{ all -> 0x0083 }
            r0.w0(r4)     // Catch:{ all -> 0x0083 }
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            java.util.LinkedHashMap r4 = r12.f9105m     // Catch:{ all -> 0x0083 }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x0083 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0083 }
        L_0x0045:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0089
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0083 }
            k4.e r5 = (k4.e) r5     // Catch:{ all -> 0x0083 }
            p1.i0 r6 = r5.f9091g     // Catch:{ all -> 0x0083 }
            r7 = 32
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = "DIRTY"
            r0.v0(r6)     // Catch:{ all -> 0x0083 }
            r0.S(r7)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r5.f9085a     // Catch:{ all -> 0x0083 }
            r0.v0(r5)     // Catch:{ all -> 0x0083 }
            goto L_0x0085
        L_0x0065:
            java.lang.String r6 = "CLEAN"
            r0.v0(r6)     // Catch:{ all -> 0x0083 }
            r0.S(r7)     // Catch:{ all -> 0x0083 }
            java.lang.String r6 = r5.f9085a     // Catch:{ all -> 0x0083 }
            r0.v0(r6)     // Catch:{ all -> 0x0083 }
            long[] r5 = r5.f9086b     // Catch:{ all -> 0x0083 }
            int r6 = r5.length     // Catch:{ all -> 0x0083 }
            r8 = 0
        L_0x0076:
            if (r8 >= r6) goto L_0x0085
            r9 = r5[r8]     // Catch:{ all -> 0x0083 }
            r0.S(r7)     // Catch:{ all -> 0x0083 }
            r0.w0(r9)     // Catch:{ all -> 0x0083 }
            int r8 = r8 + 1
            goto L_0x0076
        L_0x0083:
            r3 = move-exception
            goto L_0x0091
        L_0x0085:
            r0.S(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x0045
        L_0x0089:
            la.v r3 = la.v.f9814a     // Catch:{ all -> 0x0083 }
            r0.close()     // Catch:{ all -> 0x008f }
            goto L_0x009c
        L_0x008f:
            r2 = move-exception
            goto L_0x009c
        L_0x0091:
            r0.close()     // Catch:{ all -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r0 = move-exception
            la.a.a(r3, r0)     // Catch:{ all -> 0x00dd }
        L_0x0099:
            r11 = r3
            r3 = r2
            r2 = r11
        L_0x009c:
            if (r2 != 0) goto L_0x00dc
            xa.j.c(r3)     // Catch:{ all -> 0x00dd }
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r2 = r12.f9102j     // Catch:{ all -> 0x00dd }
            boolean r0 = r0.f(r2)     // Catch:{ all -> 0x00dd }
            if (r0 == 0) goto L_0x00c5
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r2 = r12.f9102j     // Catch:{ all -> 0x00dd }
            dc.f0 r3 = r12.f9104l     // Catch:{ all -> 0x00dd }
            r0.b(r2, r3)     // Catch:{ all -> 0x00dd }
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r2 = r12.f9103k     // Catch:{ all -> 0x00dd }
            dc.f0 r3 = r12.f9102j     // Catch:{ all -> 0x00dd }
            r0.b(r2, r3)     // Catch:{ all -> 0x00dd }
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r2 = r12.f9104l     // Catch:{ all -> 0x00dd }
            r0.e(r2)     // Catch:{ all -> 0x00dd }
            goto L_0x00ce
        L_0x00c5:
            k4.g r0 = r12.f9115w     // Catch:{ all -> 0x00dd }
            dc.f0 r2 = r12.f9103k     // Catch:{ all -> 0x00dd }
            dc.f0 r3 = r12.f9102j     // Catch:{ all -> 0x00dd }
            r0.b(r2, r3)     // Catch:{ all -> 0x00dd }
        L_0x00ce:
            dc.h0 r0 = r12.N()     // Catch:{ all -> 0x00dd }
            r12.f9109q = r0     // Catch:{ all -> 0x00dd }
            r12.f9108p = r1     // Catch:{ all -> 0x00dd }
            r12.f9110r = r1     // Catch:{ all -> 0x00dd }
            r12.f9114v = r1     // Catch:{ all -> 0x00dd }
            monitor-exit(r12)
            return
        L_0x00dc:
            throw r2     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.i.I0():void");
    }

    public final dc.h0 N() {
        g gVar = this.f9115w;
        gVar.getClass();
        f0 f0Var = this.f9102j;
        j.f("file", f0Var);
        return h0.n(new j(gVar.a(f0Var), new androidx.fragment.app.k(7, this)));
    }

    public final void W() {
        Iterator it = this.f9105m.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            e eVar = (e) it.next();
            int i10 = 0;
            if (eVar.f9091g == null) {
                while (i10 < 2) {
                    j10 += eVar.f9086b[i10];
                    i10++;
                }
            } else {
                eVar.f9091g = null;
                while (i10 < 2) {
                    g gVar = this.f9115w;
                    gVar.e((f0) eVar.f9087c.get(i10));
                    gVar.e((f0) eVar.f9088d.get(i10));
                    i10++;
                }
                it.remove();
            }
        }
        this.f9107o = j10;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|(1:21)(1:22)|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r13.f9108p = r11 - r13.f9105m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (r2.R() == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        I0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r13.f9109q = N();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        r0 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        r3 = th;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0060=Splitter:B:18:0x0060, B:27:0x0081=Splitter:B:27:0x0081} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y() {
        /*
            r13 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            k4.g r2 = r13.f9115w
            dc.f0 r3 = r13.f9102j
            dc.p0 r2 = r2.l(r3)
            dc.i0 r2 = hb.h0.o(r2)
            r3 = 0
            java.lang.String r4 = r2.K()     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = r2.K()     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = r2.K()     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = r2.K()     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = r2.K()     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = "libcore.io.DiskLruCache"
            boolean r9 = xa.j.a(r9, r4)     // Catch:{ all -> 0x00b0 }
            if (r9 == 0) goto L_0x0081
            java.lang.String r9 = "1"
            boolean r9 = xa.j.a(r9, r5)     // Catch:{ all -> 0x00b0 }
            if (r9 == 0) goto L_0x0081
            r9 = 1
            java.lang.String r10 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00b0 }
            boolean r10 = xa.j.a(r10, r6)     // Catch:{ all -> 0x00b0 }
            if (r10 == 0) goto L_0x0081
            r10 = 2
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00b0 }
            boolean r10 = xa.j.a(r10, r7)     // Catch:{ all -> 0x00b0 }
            if (r10 == 0) goto L_0x0081
            int r10 = r8.length()     // Catch:{ all -> 0x00b0 }
            r11 = 0
            if (r10 <= 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r9 = 0
        L_0x0054:
            if (r9 != 0) goto L_0x0081
        L_0x0056:
            java.lang.String r0 = r2.K()     // Catch:{ EOFException -> 0x0060 }
            r13.Z(r0)     // Catch:{ EOFException -> 0x0060 }
            int r11 = r11 + 1
            goto L_0x0056
        L_0x0060:
            java.util.LinkedHashMap r0 = r13.f9105m     // Catch:{ all -> 0x00b0 }
            int r0 = r0.size()     // Catch:{ all -> 0x00b0 }
            int r11 = r11 - r0
            r13.f9108p = r11     // Catch:{ all -> 0x00b0 }
            boolean r0 = r2.R()     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x0073
            r13.I0()     // Catch:{ all -> 0x00b0 }
            goto L_0x0079
        L_0x0073:
            dc.h0 r0 = r13.N()     // Catch:{ all -> 0x00b0 }
            r13.f9109q = r0     // Catch:{ all -> 0x00b0 }
        L_0x0079:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x00b0 }
            r2.close()     // Catch:{ all -> 0x007f }
            goto L_0x00bc
        L_0x007f:
            r3 = move-exception
            goto L_0x00bc
        L_0x0081:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r10.<init>(r1)     // Catch:{ all -> 0x00b0 }
            r10.append(r4)     // Catch:{ all -> 0x00b0 }
            r10.append(r0)     // Catch:{ all -> 0x00b0 }
            r10.append(r5)     // Catch:{ all -> 0x00b0 }
            r10.append(r0)     // Catch:{ all -> 0x00b0 }
            r10.append(r6)     // Catch:{ all -> 0x00b0 }
            r10.append(r0)     // Catch:{ all -> 0x00b0 }
            r10.append(r7)     // Catch:{ all -> 0x00b0 }
            r10.append(r0)     // Catch:{ all -> 0x00b0 }
            r10.append(r8)     // Catch:{ all -> 0x00b0 }
            r0 = 93
            r10.append(r0)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x00b0 }
            r9.<init>(r0)     // Catch:{ all -> 0x00b0 }
            throw r9     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r1 = move-exception
            la.a.a(r0, r1)
        L_0x00b9:
            r12 = r3
            r3 = r0
            r0 = r12
        L_0x00bc:
            if (r3 != 0) goto L_0x00c2
            xa.j.c(r0)
            return
        L_0x00c2:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.i.Y():void");
    }

    public final void Z(String str) {
        String str2;
        int t10 = y.t(str, ' ', 0, false, 6);
        if (t10 != -1) {
            int i10 = t10 + 1;
            int t11 = y.t(str, ' ', i10, false, 4);
            LinkedHashMap linkedHashMap = this.f9105m;
            if (t11 == -1) {
                str2 = str.substring(i10);
                j.e("this as java.lang.String).substring(startIndex)", str2);
                if (t10 == 6 && w.m(str, "REMOVE", false)) {
                    linkedHashMap.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, t11);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", str2);
            }
            Object obj = linkedHashMap.get(str2);
            if (obj == null) {
                obj = new e(this, str2);
                linkedHashMap.put(str2, obj);
            }
            e eVar = (e) obj;
            if (t11 != -1 && t10 == 5 && w.m(str, "CLEAN", false)) {
                String substring = str.substring(t11 + 1);
                j.e("this as java.lang.String).substring(startIndex)", substring);
                List E = y.E(substring, new char[]{' '});
                eVar.f9089e = true;
                eVar.f9091g = null;
                int size = E.size();
                eVar.f9093i.getClass();
                if (size == 2) {
                    try {
                        int size2 = E.size();
                        for (int i11 = 0; i11 < size2; i11++) {
                            eVar.f9086b[i11] = Long.parseLong((String) E.get(i11));
                        }
                    } catch (NumberFormatException unused) {
                        throw new IOException("unexpected journal line: " + E);
                    }
                } else {
                    throw new IOException("unexpected journal line: " + E);
                }
            } else if (t11 == -1 && t10 == 5 && w.m(str, "DIRTY", false)) {
                eVar.f9091g = new i0(this, eVar);
            } else if (t11 != -1 || t10 != 4 || !w.m(str, "READ", false)) {
                throw new IOException("unexpected journal line: ".concat(str));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    public final void a0(e eVar) {
        k kVar;
        int i10 = eVar.f9092h;
        String str = eVar.f9085a;
        if (i10 > 0 && (kVar = this.f9109q) != null) {
            kVar.v0("DIRTY");
            kVar.S(32);
            kVar.v0(str);
            kVar.S(10);
            kVar.flush();
        }
        boolean z10 = true;
        if (eVar.f9092h > 0 || eVar.f9091g != null) {
            eVar.f9090f = true;
            return;
        }
        for (int i11 = 0; i11 < 2; i11++) {
            this.f9115w.e((f0) eVar.f9087c.get(i11));
            long j10 = this.f9107o;
            long[] jArr = eVar.f9086b;
            this.f9107o = j10 - jArr[i11];
            jArr[i11] = 0;
        }
        this.f9108p++;
        k kVar2 = this.f9109q;
        if (kVar2 != null) {
            kVar2.v0("REMOVE");
            kVar2.S(32);
            kVar2.v0(str);
            kVar2.S(10);
        }
        this.f9105m.remove(str);
        if (this.f9108p < 2000) {
            z10 = false;
        }
        if (z10) {
            z();
        }
    }

    public final synchronized void close() {
        if (this.f9111s) {
            if (!this.f9112t) {
                for (e eVar : (e[]) this.f9105m.values().toArray(new e[0])) {
                    i0 i0Var = eVar.f9091g;
                    if (i0Var != null) {
                        Object obj = i0Var.f12465j;
                        if (j.a(((e) obj).f9091g, i0Var)) {
                            ((e) obj).f9090f = true;
                        }
                    }
                }
                j0();
                f fVar = this.f9106n;
                l1 l1Var = (l1) fVar.f10848h.N(l1.f7823b);
                if (l1Var != null) {
                    l1Var.e((CancellationException) null);
                    k kVar = this.f9109q;
                    j.c(kVar);
                    kVar.close();
                    this.f9109q = null;
                    this.f9112t = true;
                    return;
                }
                throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + fVar).toString());
            }
        }
        this.f9112t = true;
    }

    public final void e() {
        if (!(!this.f9112t)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public final synchronized void flush() {
        if (this.f9111s) {
            e();
            j0();
            k kVar = this.f9109q;
            j.c(kVar);
            kVar.flush();
        }
    }

    public final void j0() {
        boolean z10;
        do {
            z10 = false;
            if (this.f9107o > this.f9101i) {
                Iterator it = this.f9105m.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e eVar = (e) it.next();
                    if (!eVar.f9090f) {
                        a0(eVar);
                        z10 = true;
                        continue;
                        break;
                    }
                }
            } else {
                this.f9113u = false;
                return;
            }
        } while (z10);
    }

    public final synchronized i0 k(String str) {
        i0 i0Var;
        e();
        H0(str);
        w();
        e eVar = (e) this.f9105m.get(str);
        if (eVar != null) {
            i0Var = eVar.f9091g;
        } else {
            i0Var = null;
        }
        if (i0Var != null) {
            return null;
        }
        if (eVar != null) {
            if (eVar.f9092h != 0) {
                return null;
            }
        }
        if (!this.f9113u) {
            if (!this.f9114v) {
                k kVar = this.f9109q;
                j.c(kVar);
                kVar.v0("DIRTY");
                kVar.S(32);
                kVar.v0(str);
                kVar.S(10);
                kVar.flush();
                if (this.f9110r) {
                    return null;
                }
                if (eVar == null) {
                    eVar = new e(this, str);
                    this.f9105m.put(str, eVar);
                }
                i0 i0Var2 = new i0(this, eVar);
                eVar.f9091g = i0Var2;
                return i0Var2;
            }
        }
        z();
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized k4.f v(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.e()     // Catch:{ all -> 0x004a }
            H0(r5)     // Catch:{ all -> 0x004a }
            r4.w()     // Catch:{ all -> 0x004a }
            java.util.LinkedHashMap r0 = r4.f9105m     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x004a }
            k4.e r0 = (k4.e) r0     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0047
            k4.f r0 = r0.a()     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x001b
            goto L_0x0047
        L_0x001b:
            int r1 = r4.f9108p     // Catch:{ all -> 0x004a }
            r2 = 1
            int r1 = r1 + r2
            r4.f9108p = r1     // Catch:{ all -> 0x004a }
            dc.k r1 = r4.f9109q     // Catch:{ all -> 0x004a }
            xa.j.c(r1)     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "READ"
            r1.v0(r3)     // Catch:{ all -> 0x004a }
            r3 = 32
            r1.S(r3)     // Catch:{ all -> 0x004a }
            r1.v0(r5)     // Catch:{ all -> 0x004a }
            r5 = 10
            r1.S(r5)     // Catch:{ all -> 0x004a }
            int r5 = r4.f9108p     // Catch:{ all -> 0x004a }
            r1 = 2000(0x7d0, float:2.803E-42)
            if (r5 < r1) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            if (r2 == 0) goto L_0x0045
            r4.z()     // Catch:{ all -> 0x004a }
        L_0x0045:
            monitor-exit(r4)
            return r0
        L_0x0047:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x004a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.i.v(java.lang.String):k4.f");
    }

    public final synchronized void w() {
        if (!this.f9111s) {
            this.f9115w.e(this.f9103k);
            if (this.f9115w.f(this.f9104l)) {
                if (this.f9115w.f(this.f9102j)) {
                    this.f9115w.e(this.f9104l);
                } else {
                    this.f9115w.b(this.f9104l, this.f9102j);
                }
            }
            if (this.f9115w.f(this.f9102j)) {
                try {
                    Y();
                    W();
                    this.f9111s = true;
                    return;
                } catch (IOException unused) {
                    close();
                    h0.N(this.f9115w, this.f9100h);
                    this.f9112t = false;
                } catch (Throwable th) {
                    this.f9112t = false;
                    throw th;
                }
            }
            I0();
            this.f9111s = true;
        }
    }

    public final void z() {
        h0.b1(this.f9106n, (h) null, 0, new h(this, (e) null), 3);
    }
}
