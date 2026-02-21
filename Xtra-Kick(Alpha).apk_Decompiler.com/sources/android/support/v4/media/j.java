package android.support.v4.media;

import c9.l;
import c9.m;
import h9.v;

public final class j implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f332h;

    /* renamed from: i  reason: collision with root package name */
    public Object f333i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f334j;

    public /* synthetic */ j(Object obj, int i10, Object obj2) {
        this.f332h = i10;
        this.f334j = obj;
        this.f333i = obj2;
    }

    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r2v79 */
    /* JADX WARNING: type inference failed for: r2v80 */
    /* JADX WARNING: type inference failed for: r2v81 */
    /* JADX WARNING: type inference failed for: r2v82 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    private final void a() {
        /*
            r31 = this;
            r1 = r31
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "Thread.currentThread()"
            xa.j.b(r2, r0)     // Catch:{ Exception -> 0x0044 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0044 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0044 }
            q9.e r3 = r3.e()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r3.f13434i     // Catch:{ Exception -> 0x0044 }
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r3 = 45
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0044 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0044 }
            q9.e r3 = r3.e()     // Catch:{ Exception -> 0x0044 }
            int r3 = r3.f13433h     // Catch:{ Exception -> 0x0044 }
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "-Slice-"
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.f334j     // Catch:{ Exception -> 0x0044 }
            y9.n r3 = (y9.n) r3     // Catch:{ Exception -> 0x0044 }
            int r3 = r3.f17270b     // Catch:{ Exception -> 0x0044 }
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r0.setName(r2)     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            y9.d r0 = new y9.d
            r0.<init>()
            java.lang.Object r2 = r1.f334j
            y9.n r2 = (y9.n) r2
            int r3 = r2.f17269a
            r0.f17241h = r3
            int r3 = r2.f17270b
            r0.f17242i = r3
            long r3 = r2.f17273e
            r0.f17245l = r3
            long r3 = r2.f17271c
            r0.f17243j = r3
            long r2 = r2.f17272d
            r0.f17244k = r2
            java.lang.Object r2 = r1.f333i
            s9.e r2 = (s9.e) r2
            q9.e r3 = r2.e()
            java.lang.Object r2 = r1.f334j
            y9.n r2 = (y9.n) r2
            long r4 = r2.f17271c
            long r6 = r2.f17273e
            long r4 = r4 + r6
            r6 = 0
            r8 = 0
            int r2 = r2.f17270b
            r11 = 1
            int r9 = r2 + 1
            r10 = 12
            y9.g r2 = hb.h0.F0(r3, r4, r6, r8, r9, r10)
            r3 = 0
            java.lang.Object r4 = r1.f334j     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            r5 = r4
            y9.n r5 = (y9.n) r5     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            int r5 = r5.f17269a     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            y9.n r4 = (y9.n) r4     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            int r4 = r4.f17270b     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.lang.Object r6 = r1.f333i     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            s9.e r6 = (s9.e) r6     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.lang.String r6 = r6.G     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.lang.String r4 = hb.h0.f0(r5, r4, r6)     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.io.File r4 = hb.h0.l0(r4)     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0309, all -> 0x0305 }
            java.lang.Object r4 = r1.f333i     // Catch:{ Exception -> 0x0303 }
            r6 = r4
            s9.e r6 = (s9.e) r6     // Catch:{ Exception -> 0x0303 }
            y9.h r6 = r6.B     // Catch:{ Exception -> 0x0303 }
            s9.e r4 = (s9.e) r4     // Catch:{ Exception -> 0x0303 }
            s9.d r4 = r4.f14433z     // Catch:{ Exception -> 0x0303 }
            y9.f r3 = r6.B(r2, r4)     // Catch:{ Exception -> 0x0303 }
            java.lang.Object r4 = r1.f333i     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            s9.e r4 = (s9.e) r4     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            boolean r4 = r4.f14416i     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            if (r4 != 0) goto L_0x0289
            java.lang.Object r4 = r1.f333i     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            s9.e r4 = (s9.e) r4     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            boolean r4 = r4.f14415h     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            if (r4 != 0) goto L_0x0289
            if (r3 == 0) goto L_0x0289
            boolean r4 = r3.f17250b     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            if (r4 != r11) goto L_0x0289
            xa.t r4 = new xa.t     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r4.<init>()     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            java.lang.Object r6 = r1.f333i     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            s9.e r6 = (s9.e) r6     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            y9.h r6 = r6.B     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r6.y0(r2)     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r2]     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            java.io.InputStream r7 = r3.f17252d     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r8 = 0
            if (r7 == 0) goto L_0x00e2
            int r7 = r7.read(r6, r8, r2)     // Catch:{ Exception -> 0x0303 }
            goto L_0x00e3
        L_0x00e2:
            r7 = -1
        L_0x00e3:
            java.lang.Object r10 = r1.f334j     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r11 = r10
            y9.n r11 = (y9.n) r11     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            long r11 = r11.f17272d     // Catch:{ Exception -> 0x0300, all -> 0x02fd }
            r13 = 1
            r15 = r3
            int r16 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r16 >= 0) goto L_0x00f4
            r11 = 0
            goto L_0x00f9
        L_0x00f4:
            r11 = r10
            y9.n r11 = (y9.n) r11     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r11 = r11.f17272d     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
        L_0x00f9:
            r13 = r10
            y9.n r13 = (y9.n) r13     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r13 = r13.f17271c     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            y9.n r10 = (y9.n) r10     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r8 = r10.f17273e     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r13 = r13 + r8
            long r8 = r11 - r13
            long r13 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            xa.s r10 = new xa.s     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r10.<init>()     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            xa.t r2 = new xa.t     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r2.<init>()     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
        L_0x0113:
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r3 = r3.f14421n     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            if (r3 != 0) goto L_0x0121
            r17 = 0
            int r3 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0281
        L_0x0121:
            r3 = -1
            if (r7 == r3) goto L_0x0281
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r3 = r3.f14415h     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            if (r3 != 0) goto L_0x0281
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r3 = r3.f14416i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            if (r3 != 0) goto L_0x0281
            java.lang.Object r3 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r3 = (s9.e) r3     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r3 = r3.f14421n     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r25 = r11
            if (r3 != 0) goto L_0x0147
            long r11 = (long) r7     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            int r3 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0144
            goto L_0x0147
        L_0x0144:
            int r7 = (int) r8     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r3 = -1
            goto L_0x0148
        L_0x0147:
            r3 = r7
        L_0x0148:
            r10.f16816h = r7     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            java.lang.Object r7 = r1.f334j     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r11 = r7
            y9.n r11 = (y9.n) r11     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r11 = r11.f17271c     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            y9.n r7 = (y9.n) r7     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            r27 = r8
            long r7 = r7.f17273e     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            long r11 = r11 + r7
            r2.f16817h = r11     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            java.lang.Object r7 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r7 = (s9.e) r7     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            java.lang.Object r7 = r7.f14428u     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            monitor-enter(r7)     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            boolean r8 = r8.f14415h     // Catch:{ all -> 0x0277 }
            if (r8 != 0) goto L_0x021b
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            boolean r8 = r8.f14416i     // Catch:{ all -> 0x0277 }
            if (r8 != 0) goto L_0x021b
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            y9.t r8 = r8.f14431x     // Catch:{ all -> 0x0277 }
            if (r8 == 0) goto L_0x017e
            long r11 = r2.f16817h     // Catch:{ all -> 0x0277 }
            r8.c(r11)     // Catch:{ all -> 0x0277 }
        L_0x017e:
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            y9.t r8 = r8.f14431x     // Catch:{ all -> 0x0277 }
            if (r8 == 0) goto L_0x018b
            int r9 = r10.f16816h     // Catch:{ all -> 0x0277 }
            r8.e(r6, r9)     // Catch:{ all -> 0x0277 }
        L_0x018b:
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            boolean r8 = r8.f14415h     // Catch:{ all -> 0x0277 }
            if (r8 != 0) goto L_0x01c9
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            boolean r8 = r8.f14416i     // Catch:{ all -> 0x0277 }
            if (r8 != 0) goto L_0x01c9
            java.lang.Object r8 = r1.f334j     // Catch:{ all -> 0x0277 }
            y9.n r8 = (y9.n) r8     // Catch:{ all -> 0x0277 }
            long r11 = r8.f17273e     // Catch:{ all -> 0x0277 }
            int r9 = r10.f16816h     // Catch:{ all -> 0x0277 }
            r29 = r2
            r30 = r3
            long r2 = (long) r9     // Catch:{ all -> 0x0277 }
            long r11 = r11 + r2
            r8.f17273e = r11     // Catch:{ all -> 0x0277 }
            r2 = 0
            r5.seek(r2)     // Catch:{ all -> 0x0277 }
            r5.setLength(r2)     // Catch:{ all -> 0x0277 }
            java.lang.Object r8 = r1.f334j     // Catch:{ all -> 0x0277 }
            y9.n r8 = (y9.n) r8     // Catch:{ all -> 0x0277 }
            long r8 = r8.f17273e     // Catch:{ all -> 0x0277 }
            r5.writeLong(r8)     // Catch:{ all -> 0x0277 }
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            long r11 = r8.f14419l     // Catch:{ all -> 0x0277 }
            int r9 = r10.f16816h     // Catch:{ all -> 0x0277 }
            long r2 = (long) r9     // Catch:{ all -> 0x0277 }
            long r11 = r11 + r2
            r8.f14419l = r11     // Catch:{ all -> 0x0277 }
            goto L_0x01cd
        L_0x01c9:
            r29 = r2
            r30 = r3
        L_0x01cd:
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0277 }
            r4.f16817h = r2     // Catch:{ all -> 0x0277 }
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            long r8 = r8.C     // Catch:{ all -> 0x0277 }
            r19 = r13
            r21 = r2
            r23 = r8
            boolean r2 = hb.h0.M0(r19, r21, r23)     // Catch:{ all -> 0x0277 }
            if (r2 == 0) goto L_0x021f
            java.lang.Object r2 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r2 = (s9.e) r2     // Catch:{ all -> 0x0277 }
            boolean r2 = r2.f14415h     // Catch:{ all -> 0x0277 }
            if (r2 != 0) goto L_0x0215
            java.lang.Object r2 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r2 = (s9.e) r2     // Catch:{ all -> 0x0277 }
            boolean r2 = r2.f14416i     // Catch:{ all -> 0x0277 }
            if (r2 != 0) goto L_0x0215
            java.lang.Object r2 = r1.f334j     // Catch:{ all -> 0x0277 }
            y9.n r2 = (y9.n) r2     // Catch:{ all -> 0x0277 }
            long r2 = r2.f17273e     // Catch:{ all -> 0x0277 }
            r0.f17245l = r2     // Catch:{ all -> 0x0277 }
            java.lang.Object r2 = r1.f333i     // Catch:{ all -> 0x0277 }
            r3 = r2
            s9.e r3 = (s9.e) r3     // Catch:{ all -> 0x0277 }
            u9.b r3 = r3.f14417j     // Catch:{ all -> 0x0277 }
            if (r3 == 0) goto L_0x0215
            s9.e r2 = (s9.e) r2     // Catch:{ all -> 0x0277 }
            q9.e r2 = r2.e()     // Catch:{ all -> 0x0277 }
            java.lang.Object r8 = r1.f333i     // Catch:{ all -> 0x0277 }
            s9.e r8 = (s9.e) r8     // Catch:{ all -> 0x0277 }
            int r8 = r8.f14432y     // Catch:{ all -> 0x0277 }
            r3.b(r2, r0, r8)     // Catch:{ all -> 0x0277 }
        L_0x0215:
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0277 }
            r13 = r2
            goto L_0x021f
        L_0x021b:
            r29 = r2
            r30 = r3
        L_0x021f:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x0277 }
            monitor-exit(r7)     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            java.lang.Object r2 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r2 = (s9.e) r2     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r2 = r2.f14415h     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            if (r2 != 0) goto L_0x0266
            java.lang.Object r2 = r1.f333i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            s9.e r2 = (s9.e) r2     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            boolean r2 = r2.f14416i     // Catch:{ Exception -> 0x0286, all -> 0x0283 }
            if (r2 != 0) goto L_0x0266
            r7 = r30
            r3 = -1
            if (r7 == r3) goto L_0x0264
            r2 = r15
            java.io.InputStream r7 = r2.f17252d     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r7 == 0) goto L_0x0244
            r8 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            int r7 = r7.read(r6, r8, r9)     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            goto L_0x0248
        L_0x0244:
            r8 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            r7 = -1
        L_0x0248:
            java.lang.Object r11 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r11 = (s9.e) r11     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r11 = r11.f14421n     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r11 != 0) goto L_0x0262
            java.lang.Object r11 = r1.f334j     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            r12 = r11
            y9.n r12 = (y9.n) r12     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            r15 = r4
            long r3 = r12.f17271c     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            y9.n r11 = (y9.n) r11     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            long r11 = r11.f17273e     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            long r3 = r3 + r11
            long r11 = r25 - r3
            r27 = r11
            goto L_0x026d
        L_0x0262:
            r15 = r4
            goto L_0x026d
        L_0x0264:
            r2 = r15
            goto L_0x0269
        L_0x0266:
            r2 = r15
            r7 = r30
        L_0x0269:
            r8 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0262
        L_0x026d:
            r4 = r15
            r11 = r25
            r8 = r27
            r15 = r2
            r2 = r29
            goto L_0x0113
        L_0x0277:
            r0 = move-exception
            r2 = r15
            monitor-exit(r7)     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            throw r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
        L_0x027b:
            r3 = r2
            goto L_0x0362
        L_0x027e:
            r3 = r2
            goto L_0x030b
        L_0x0281:
            r2 = r15
            goto L_0x02e1
        L_0x0283:
            r0 = move-exception
            r2 = r15
            goto L_0x027b
        L_0x0286:
            r0 = move-exception
            r2 = r15
            goto L_0x027e
        L_0x0289:
            r2 = r3
            if (r2 != 0) goto L_0x02a9
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14415h     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 != 0) goto L_0x02a9
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14416i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 == 0) goto L_0x029d
            goto L_0x02a9
        L_0x029d:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            java.lang.String r3 = "empty_response_body"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            throw r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
        L_0x02a5:
            r0 = move-exception
            goto L_0x027b
        L_0x02a7:
            r0 = move-exception
            goto L_0x027e
        L_0x02a9:
            if (r2 == 0) goto L_0x02c8
            boolean r0 = r2.f17250b     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 != 0) goto L_0x02c8
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14415h     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 != 0) goto L_0x02c8
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14416i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 == 0) goto L_0x02c0
            goto L_0x02c8
        L_0x02c0:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            java.lang.String r3 = "request_not_successful"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            throw r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
        L_0x02c8:
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14415h     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 != 0) goto L_0x02e1
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            boolean r0 = r0.f14416i     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            if (r0 == 0) goto L_0x02d9
            goto L_0x02e1
        L_0x02d9:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            java.lang.String r3 = "unknown"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
            throw r0     // Catch:{ Exception -> 0x02a7, all -> 0x02a5 }
        L_0x02e1:
            if (r2 == 0) goto L_0x02f9
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x02ed }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x02ed }
            y9.h r0 = r0.B     // Catch:{ Exception -> 0x02ed }
            r0.q0(r2)     // Catch:{ Exception -> 0x02ed }
            goto L_0x02f9
        L_0x02ed:
            r0 = move-exception
            java.lang.Object r2 = r1.f333i
            s9.e r2 = (s9.e) r2
            y9.l r2 = r2.D
            java.lang.String r3 = "FileDownloader"
            r2.b(r3, r0)
        L_0x02f9:
            r5.close()     // Catch:{ Exception -> 0x034d }
            goto L_0x0359
        L_0x02fd:
            r0 = move-exception
            r2 = r3
            goto L_0x0362
        L_0x0300:
            r0 = move-exception
            r2 = r3
            goto L_0x030b
        L_0x0303:
            r0 = move-exception
            goto L_0x030b
        L_0x0305:
            r0 = move-exception
            r2 = r0
            r5 = r3
            goto L_0x0363
        L_0x0309:
            r0 = move-exception
            r5 = r3
        L_0x030b:
            java.lang.Object r2 = r1.f333i     // Catch:{ all -> 0x0361 }
            s9.e r2 = (s9.e) r2     // Catch:{ all -> 0x0361 }
            y9.l r2 = r2.D     // Catch:{ all -> 0x0361 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0361 }
            r4.<init>()     // Catch:{ all -> 0x0361 }
            java.lang.String r6 = "FileDownloader downloads slice "
            r4.append(r6)     // Catch:{ all -> 0x0361 }
            java.lang.Object r6 = r1.f334j     // Catch:{ all -> 0x0361 }
            y9.n r6 = (y9.n) r6     // Catch:{ all -> 0x0361 }
            r4.append(r6)     // Catch:{ all -> 0x0361 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0361 }
            r2.b(r4, r0)     // Catch:{ all -> 0x0361 }
            java.lang.Object r2 = r1.f333i     // Catch:{ all -> 0x0361 }
            s9.e r2 = (s9.e) r2     // Catch:{ all -> 0x0361 }
            r2.f14429v = r0     // Catch:{ all -> 0x0361 }
            if (r3 == 0) goto L_0x0347
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x033b }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x033b }
            y9.h r0 = r0.B     // Catch:{ Exception -> 0x033b }
            r0.q0(r3)     // Catch:{ Exception -> 0x033b }
            goto L_0x0347
        L_0x033b:
            r0 = move-exception
            java.lang.Object r2 = r1.f333i
            s9.e r2 = (s9.e) r2
            y9.l r2 = r2.D
            java.lang.String r3 = "FileDownloader"
            r2.b(r3, r0)
        L_0x0347:
            if (r5 == 0) goto L_0x0359
            r5.close()     // Catch:{ Exception -> 0x034d }
            goto L_0x0359
        L_0x034d:
            r0 = move-exception
            java.lang.Object r2 = r1.f333i
            s9.e r2 = (s9.e) r2
            y9.l r2 = r2.D
            java.lang.String r3 = "FileDownloader"
            r2.b(r3, r0)
        L_0x0359:
            java.lang.Object r0 = r1.f333i
            s9.e r0 = (s9.e) r0
            s9.e.a(r0)
            return
        L_0x0361:
            r0 = move-exception
        L_0x0362:
            r2 = r0
        L_0x0363:
            if (r3 == 0) goto L_0x037b
            java.lang.Object r0 = r1.f333i     // Catch:{ Exception -> 0x036f }
            s9.e r0 = (s9.e) r0     // Catch:{ Exception -> 0x036f }
            y9.h r0 = r0.B     // Catch:{ Exception -> 0x036f }
            r0.q0(r3)     // Catch:{ Exception -> 0x036f }
            goto L_0x037b
        L_0x036f:
            r0 = move-exception
            java.lang.Object r3 = r1.f333i
            s9.e r3 = (s9.e) r3
            y9.l r3 = r3.D
            java.lang.String r4 = "FileDownloader"
            r3.b(r4, r0)
        L_0x037b:
            if (r5 == 0) goto L_0x038e
            r5.close()     // Catch:{ Exception -> 0x0381 }
            goto L_0x038e
        L_0x0381:
            r0 = move-exception
            r3 = r0
            java.lang.Object r0 = r1.f333i
            s9.e r0 = (s9.e) r0
            y9.l r0 = r0.D
            java.lang.String r4 = "FileDownloader"
            r0.b(r4, r3)
        L_0x038e:
            java.lang.Object r0 = r1.f333i
            s9.e r0 = (s9.e) r0
            s9.e.a(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.j.a():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02c3  */
    public final void run() {
        /*
            r10 = this;
            int r0 = r10.f332h
            r1 = 0
            r2 = 0
            r3 = 1
            switch(r0) {
                case 0: goto L_0x02cc;
                case 1: goto L_0x0291;
                case 2: goto L_0x0288;
                case 3: goto L_0x027c;
                case 4: goto L_0x022b;
                case 5: goto L_0x01fe;
                case 6: goto L_0x01f1;
                case 7: goto L_0x01c6;
                case 8: goto L_0x0194;
                case 9: goto L_0x002a;
                case 10: goto L_0x0026;
                case 11: goto L_0x0018;
                case 12: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x02ec
        L_0x000a:
            java.lang.Object r0 = r10.f333i
            hb.k r0 = (hb.k) r0
            java.lang.Object r1 = r10.f334j
            ib.a r1 = (ib.a) r1
            la.v r2 = la.v.f9814a
            r0.d(r1, r2)
            return
        L_0x0018:
            java.lang.Object r0 = r10.f334j
            hb.k r0 = (hb.k) r0
            java.lang.Object r1 = r10.f333i
            hb.d0 r1 = (hb.d0) r1
            la.v r2 = la.v.f9814a
            r0.d(r1, r2)
            return
        L_0x0026:
            r10.a()
            return
        L_0x002a:
            java.lang.String r0 = "DownloadManager starting download "
            java.lang.String r1 = "DownloadManager failed to start download "
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x005e }
            java.lang.String r5 = "Thread.currentThread()"
            xa.j.b(r5, r4)     // Catch:{ Exception -> 0x005e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            r5.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.Object r6 = r10.f334j     // Catch:{ Exception -> 0x005e }
            p9.b r6 = (p9.b) r6     // Catch:{ Exception -> 0x005e }
            q9.e r6 = (q9.e) r6     // Catch:{ Exception -> 0x005e }
            java.lang.String r6 = r6.f13434i     // Catch:{ Exception -> 0x005e }
            r5.append(r6)     // Catch:{ Exception -> 0x005e }
            r6 = 45
            r5.append(r6)     // Catch:{ Exception -> 0x005e }
            java.lang.Object r6 = r10.f334j     // Catch:{ Exception -> 0x005e }
            p9.b r6 = (p9.b) r6     // Catch:{ Exception -> 0x005e }
            q9.e r6 = (q9.e) r6     // Catch:{ Exception -> 0x005e }
            int r6 = r6.f13433h     // Catch:{ Exception -> 0x005e }
            r5.append(r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005e }
            r4.setName(r5)     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            java.lang.Object r4 = r10.f333i     // Catch:{ Exception -> 0x0111 }
            s9.b r4 = (s9.b) r4     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r5 = r10.f334j     // Catch:{ Exception -> 0x0111 }
            p9.b r5 = (p9.b) r5     // Catch:{ Exception -> 0x0111 }
            s9.c r4 = r4.W(r5)     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r5 = r10.f333i     // Catch:{ Exception -> 0x0111 }
            s9.b r5 = (s9.b) r5     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r5 = r5.f14394h     // Catch:{ Exception -> 0x0111 }
            monitor-enter(r5)     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r6 = r10.f333i     // Catch:{ all -> 0x010e }
            s9.b r6 = (s9.b) r6     // Catch:{ all -> 0x010e }
            java.util.HashMap r6 = r6.f14397k     // Catch:{ all -> 0x010e }
            java.lang.Object r7 = r10.f334j     // Catch:{ all -> 0x010e }
            p9.b r7 = (p9.b) r7     // Catch:{ all -> 0x010e }
            q9.e r7 = (q9.e) r7     // Catch:{ all -> 0x010e }
            int r7 = r7.f13433h     // Catch:{ all -> 0x010e }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x010e }
            boolean r6 = r6.containsKey(r7)     // Catch:{ all -> 0x010e }
            if (r6 == 0) goto L_0x00e1
            java.lang.Object r2 = r10.f333i     // Catch:{ all -> 0x010e }
            s9.b r2 = (s9.b) r2     // Catch:{ all -> 0x010e }
            u9.b r6 = new u9.b     // Catch:{ all -> 0x010e }
            z5.i r7 = r2.f14407u     // Catch:{ all -> 0x010e }
            java.lang.Object r7 = r7.f17667e     // Catch:{ all -> 0x010e }
            p9.l r7 = (p9.l) r7     // Catch:{ all -> 0x010e }
            boolean r8 = r2.f14404r     // Catch:{ all -> 0x010e }
            int r9 = r2.B     // Catch:{ all -> 0x010e }
            u9.a r2 = r2.f14405s     // Catch:{ all -> 0x010e }
            r6.<init>(r2, r7, r8, r9)     // Catch:{ all -> 0x010e }
            r4.a0(r6)     // Catch:{ all -> 0x010e }
            java.lang.Object r2 = r10.f333i     // Catch:{ all -> 0x010e }
            s9.b r2 = (s9.b) r2     // Catch:{ all -> 0x010e }
            java.util.HashMap r2 = r2.f14397k     // Catch:{ all -> 0x010e }
            java.lang.Object r6 = r10.f334j     // Catch:{ all -> 0x010e }
            p9.b r6 = (p9.b) r6     // Catch:{ all -> 0x010e }
            q9.e r6 = (q9.e) r6     // Catch:{ all -> 0x010e }
            int r6 = r6.f13433h     // Catch:{ all -> 0x010e }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x010e }
            r2.put(r6, r4)     // Catch:{ all -> 0x010e }
            java.lang.Object r2 = r10.f333i     // Catch:{ all -> 0x010e }
            s9.b r2 = (s9.b) r2     // Catch:{ all -> 0x010e }
            s9.a r2 = r2.f14406t     // Catch:{ all -> 0x010e }
            java.lang.Object r6 = r10.f334j     // Catch:{ all -> 0x010e }
            p9.b r6 = (p9.b) r6     // Catch:{ all -> 0x010e }
            q9.e r6 = (q9.e) r6     // Catch:{ all -> 0x010e }
            int r6 = r6.f13433h     // Catch:{ all -> 0x010e }
            r2.a(r6, r4)     // Catch:{ all -> 0x010e }
            java.lang.Object r2 = r10.f333i     // Catch:{ all -> 0x010e }
            s9.b r2 = (s9.b) r2     // Catch:{ all -> 0x010e }
            y9.l r2 = r2.f14402p     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r6.<init>(r0)     // Catch:{ all -> 0x010e }
            java.lang.Object r0 = r10.f334j     // Catch:{ all -> 0x010e }
            p9.b r0 = (p9.b) r0     // Catch:{ all -> 0x010e }
            r6.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x010e }
            r2.a(r0)     // Catch:{ all -> 0x010e }
            r2 = 1
        L_0x00e1:
            monitor-exit(r5)     // Catch:{ Exception -> 0x0111 }
            if (r2 == 0) goto L_0x00e7
            r4.run()     // Catch:{ Exception -> 0x0111 }
        L_0x00e7:
            java.lang.Object r0 = r10.f333i     // Catch:{ Exception -> 0x0111 }
            s9.b r0 = (s9.b) r0     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r2 = r10.f334j     // Catch:{ Exception -> 0x0111 }
            p9.b r2 = (p9.b) r2     // Catch:{ Exception -> 0x0111 }
            s9.b.c(r0, r2)     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r0 = r10.f333i     // Catch:{ Exception -> 0x0111 }
            s9.b r0 = (s9.b) r0     // Catch:{ Exception -> 0x0111 }
            l.h r0 = r0.A     // Catch:{ Exception -> 0x0111 }
            r0.k()     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r0 = r10.f333i
            s9.b r0 = (s9.b) r0
            java.lang.Object r1 = r10.f334j
            p9.b r1 = (p9.b) r1
            s9.b.c(r0, r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r0.<init>(r1)
            goto L_0x013d
        L_0x010e:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ Exception -> 0x0111 }
            throw r0     // Catch:{ Exception -> 0x0111 }
        L_0x0111:
            r0 = move-exception
            java.lang.Object r2 = r10.f333i     // Catch:{ all -> 0x015f }
            s9.b r2 = (s9.b) r2     // Catch:{ all -> 0x015f }
            y9.l r2 = r2.f14402p     // Catch:{ all -> 0x015f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r3.<init>(r1)     // Catch:{ all -> 0x015f }
            java.lang.Object r1 = r10.f334j     // Catch:{ all -> 0x015f }
            p9.b r1 = (p9.b) r1     // Catch:{ all -> 0x015f }
            r3.append(r1)     // Catch:{ all -> 0x015f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x015f }
            r2.b(r1, r0)     // Catch:{ all -> 0x015f }
            java.lang.Object r0 = r10.f333i
            s9.b r0 = (s9.b) r0
            java.lang.Object r1 = r10.f334j
            p9.b r1 = (p9.b) r1
            s9.b.c(r0, r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r0.<init>(r1)
        L_0x013d:
            java.lang.Object r1 = r10.f333i
            s9.b r1 = (s9.b) r1
            android.content.Context r1 = r1.f14411y
            java.lang.String r1 = r1.getPackageName()
            r0.setPackage(r1)
            java.lang.String r1 = "com.tonyodev.fetch2.extra.NAMESPACE"
            java.lang.Object r2 = r10.f333i
            s9.b r2 = (s9.b) r2
            java.lang.String r2 = r2.f14412z
            r0.putExtra(r1, r2)
            java.lang.Object r1 = r10.f333i
            s9.b r1 = (s9.b) r1
            android.content.Context r1 = r1.f14411y
            r1.sendBroadcast(r0)
            return
        L_0x015f:
            r0 = move-exception
            java.lang.Object r1 = r10.f333i
            s9.b r1 = (s9.b) r1
            java.lang.Object r2 = r10.f334j
            p9.b r2 = (p9.b) r2
            s9.b.c(r1, r2)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r1.<init>(r2)
            java.lang.Object r2 = r10.f333i
            s9.b r2 = (s9.b) r2
            android.content.Context r2 = r2.f14411y
            java.lang.String r2 = r2.getPackageName()
            r1.setPackage(r2)
            java.lang.String r2 = "com.tonyodev.fetch2.extra.NAMESPACE"
            java.lang.Object r3 = r10.f333i
            s9.b r3 = (s9.b) r3
            java.lang.String r3 = r3.f14412z
            r1.putExtra(r2, r3)
            java.lang.Object r2 = r10.f333i
            s9.b r2 = (s9.b) r2
            android.content.Context r2 = r2.f14411y
            r2.sendBroadcast(r1)
            throw r0
        L_0x0194:
            java.lang.Object r0 = r10.f333i
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            boolean r1 = r0 instanceof i9.a
            java.lang.Object r2 = r10.f334j
            if (r1 == 0) goto L_0x01a7
            i9.a r0 = (i9.a) r0
            java.lang.Throwable r0 = r0.b()
            if (r0 == 0) goto L_0x01a7
            goto L_0x01b8
        L_0x01a7:
            java.lang.Object r0 = r10.f333i     // Catch:{ ExecutionException -> 0x01bb, RuntimeException -> 0x01b7, Error -> 0x01b5 }
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0     // Catch:{ ExecutionException -> 0x01bb, RuntimeException -> 0x01b7, Error -> 0x01b5 }
            java.lang.Object r0 = h9.w.b(r0)     // Catch:{ ExecutionException -> 0x01bb, RuntimeException -> 0x01b7, Error -> 0x01b5 }
            h9.v r2 = (h9.v) r2
            r2.d(r0)
            goto L_0x01c5
        L_0x01b5:
            r0 = move-exception
            goto L_0x01b8
        L_0x01b7:
            r0 = move-exception
        L_0x01b8:
            h9.v r2 = (h9.v) r2
            goto L_0x01c2
        L_0x01bb:
            r0 = move-exception
            h9.v r2 = (h9.v) r2
            java.lang.Throwable r0 = r0.getCause()
        L_0x01c2:
            r2.c(r0)
        L_0x01c5:
            return
        L_0x01c6:
            java.lang.Object r0 = r10.f334j
            g5.b r0 = (g5.b) r0
            boolean r1 = r0.f6834d
            if (r1 == 0) goto L_0x01e2
            android.os.StrictMode$ThreadPolicy$Builder r1 = new android.os.StrictMode$ThreadPolicy$Builder
            r1.<init>()
            android.os.StrictMode$ThreadPolicy$Builder r1 = r1.detectNetwork()
            android.os.StrictMode$ThreadPolicy$Builder r1 = r1.penaltyDeath()
            android.os.StrictMode$ThreadPolicy r1 = r1.build()
            android.os.StrictMode.setThreadPolicy(r1)
        L_0x01e2:
            java.lang.Object r1 = r10.f333i     // Catch:{ all -> 0x01ea }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x01ea }
            r1.run()     // Catch:{ all -> 0x01ea }
            goto L_0x01f0
        L_0x01ea:
            r1 = move-exception
            g5.f r0 = r0.f6833c
            r0.a(r1)
        L_0x01f0:
            return
        L_0x01f1:
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            java.lang.Object r0 = r10.f333i
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r0.run()
            return
        L_0x01fe:
            java.lang.Object r0 = r10.f334j
            androidx.recyclerview.widget.f r0 = (androidx.recyclerview.widget.f) r0
            java.lang.Object r1 = r0.f1978m
            androidx.recyclerview.widget.h r1 = (androidx.recyclerview.widget.h) r1
            int r2 = r1.f2039g
            int r3 = r0.f1974i
            if (r2 != r3) goto L_0x022a
            java.lang.Object r2 = r0.f1976k
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r10.f333i
            androidx.recyclerview.widget.v r3 = (androidx.recyclerview.widget.v) r3
            java.lang.Object r0 = r0.f1977l
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            java.util.List r4 = r1.f2038f
            r1.f2037e = r2
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.f2038f = r2
            androidx.recyclerview.widget.x0 r2 = r1.f2033a
            r3.b(r2)
            r1.a(r0)
        L_0x022a:
            return
        L_0x022b:
            java.lang.reflect.Method r0 = b0.g.f2349d     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.Object r1 = r10.f334j
            r4 = 2
            if (r0 == 0) goto L_0x0245
            java.lang.Object r5 = r10.f333i     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r6[r2] = r1     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r6[r3] = r1     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.String r1 = "AppCompat recreation"
            r6[r4] = r1     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r0.invoke(r5, r6)     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            goto L_0x027b
        L_0x0245:
            java.lang.reflect.Method r0 = b0.g.f2350e     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.Object r5 = r10.f333i     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r4[r2] = r1     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r4[r3] = r1     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            r0.invoke(r5, r4)     // Catch:{ RuntimeException -> 0x025e, all -> 0x0255 }
            goto L_0x027b
        L_0x0255:
            r0 = move-exception
            java.lang.String r1 = "ActivityRecreator"
            java.lang.String r2 = "Exception while invoking performStopActivity"
            android.util.Log.e(r1, r2, r0)
            goto L_0x027b
        L_0x025e:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()
            java.lang.Class<java.lang.RuntimeException> r2 = java.lang.RuntimeException.class
            if (r1 != r2) goto L_0x027b
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x027b
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Unable to stop"
            boolean r1 = r1.startsWith(r2)
            if (r1 != 0) goto L_0x027a
            goto L_0x027b
        L_0x027a:
            throw r0
        L_0x027b:
            return
        L_0x027c:
            java.lang.Object r0 = r10.f333i
            android.app.Application r0 = (android.app.Application) r0
            java.lang.Object r1 = r10.f334j
            b0.f r1 = (b0.f) r1
            r0.unregisterActivityLifecycleCallbacks(r1)
            return
        L_0x0288:
            java.lang.Object r0 = r10.f333i
            b0.f r0 = (b0.f) r0
            java.lang.Object r1 = r10.f334j
            r0.f2340a = r1
            return
        L_0x0291:
            java.lang.Object r0 = r10.f334j
            androidx.appcompat.widget.n r0 = (androidx.appcompat.widget.n) r0
            m.o r4 = r0.f946j
            if (r4 == 0) goto L_0x02a0
            m.m r5 = r4.f9976e
            if (r5 == 0) goto L_0x02a0
            r5.l(r4)
        L_0x02a0:
            m.e0 r4 = r0.f951o
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x02c9
            android.os.IBinder r4 = r4.getWindowToken()
            if (r4 == 0) goto L_0x02c9
            java.lang.Object r4 = r10.f333i
            androidx.appcompat.widget.h r4 = (androidx.appcompat.widget.h) r4
            boolean r5 = r4.b()
            if (r5 == 0) goto L_0x02b8
        L_0x02b6:
            r2 = 1
            goto L_0x02c1
        L_0x02b8:
            android.view.View r5 = r4.f9895f
            if (r5 != 0) goto L_0x02bd
            goto L_0x02c1
        L_0x02bd:
            r4.d(r2, r2, r2, r2)
            goto L_0x02b6
        L_0x02c1:
            if (r2 == 0) goto L_0x02c9
            java.lang.Object r2 = r10.f333i
            androidx.appcompat.widget.h r2 = (androidx.appcompat.widget.h) r2
            r0.A = r2
        L_0x02c9:
            r0.C = r1
            return
        L_0x02cc:
            boolean r0 = android.support.v4.media.s.f343b
            java.lang.Object r2 = r10.f334j
            if (r0 != 0) goto L_0x02da
            android.support.v4.media.k r2 = (android.support.v4.media.k) r2
            java.lang.String r0 = "onServiceDisconnected"
            r2.a(r0)
            throw r1
        L_0x02da:
            java.lang.Object r0 = r10.f333i
            android.content.ComponentName r0 = (android.content.ComponentName) r0
            java.util.Objects.toString(r0)
            r10.toString()
            android.support.v4.media.k r2 = (android.support.v4.media.k) r2
            java.lang.Object r0 = r2.f335h
            android.support.v4.media.h.y(r0)
            throw r1
        L_0x02ec:
            java.lang.Object r0 = r10.f333i     // Catch:{ all -> 0x02f4 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x02f4 }
            r0.run()     // Catch:{ all -> 0x02f4 }
            goto L_0x02fa
        L_0x02f4:
            r0 = move-exception
            pa.l r1 = pa.l.f12754h
            hb.h0.K0(r1, r0)
        L_0x02fa:
            java.lang.Object r0 = r10.f334j
            mb.l r0 = (mb.l) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = mb.l.f10866o
            java.lang.Runnable r1 = r0.Q0()
            if (r1 != 0) goto L_0x0307
            goto L_0x031b
        L_0x0307:
            r10.f333i = r1
            int r2 = r2 + r3
            r1 = 16
            if (r2 < r1) goto L_0x02ec
            hb.d0 r1 = r0.f10867j
            boolean r1 = r1.O0(r0)
            if (r1 == 0) goto L_0x02ec
            hb.d0 r1 = r0.f10867j
            r1.M0(r0, r10)
        L_0x031b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.j.run():void");
    }

    public final String toString() {
        switch (this.f332h) {
            case 8:
                m mVar = new m(j.class.getSimpleName());
                l lVar = new l(0);
                mVar.f3043c.f3040b = lVar;
                mVar.f3043c = lVar;
                lVar.f3039a = (v) this.f334j;
                return mVar.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ j(Object obj, Object obj2, int i10) {
        this.f332h = i10;
        this.f333i = obj;
        this.f334j = obj2;
    }
}
