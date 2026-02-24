package q1;

import j1.a;
import p1.d;
import p1.m;
import p1.n;
import v1.b1;

public final class r implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f13238a;

    /* renamed from: b  reason: collision with root package name */
    public final v f13239b;

    /* renamed from: c  reason: collision with root package name */
    public int f13240c = -1;

    public r(v vVar, int i10) {
        this.f13239b = vVar;
        this.f13238a = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        if (((q1.n) r8.get(0)).K == false) goto L_0x011d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(m1.w0 r19, l1.h r20, int r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            int r3 = r1.f13240c
            r4 = -3
            if (r3 != r4) goto L_0x0011
            r0 = 4
            r2.e(r0)
            r0 = -4
            return r0
        L_0x0011:
            r5 = -1
            r6 = 1
            r7 = 0
            if (r3 == r5) goto L_0x001d
            if (r3 == r4) goto L_0x001d
            r5 = -2
            if (r3 == r5) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r5 == 0) goto L_0x011d
            q1.v r5 = r1.f13239b
            boolean r8 = r5.z()
            if (r8 == 0) goto L_0x002a
            goto L_0x011d
        L_0x002a:
            java.util.ArrayList r8 = r5.f13270u
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x00a1
            r9 = 0
        L_0x0033:
            int r10 = r8.size()
            int r10 = r10 - r6
            if (r9 >= r10) goto L_0x0063
            java.lang.Object r10 = r8.get(r9)
            q1.n r10 = (q1.n) r10
            int r10 = r10.f13189k
            q1.u[] r11 = r5.C
            int r11 = r11.length
            r12 = 0
        L_0x0046:
            if (r12 >= r11) goto L_0x005d
            boolean[] r13 = r5.U
            boolean r13 = r13[r12]
            if (r13 == 0) goto L_0x005a
            q1.u[] r13 = r5.C
            r13 = r13[r12]
            int r13 = r13.v()
            if (r13 != r10) goto L_0x005a
            r10 = 0
            goto L_0x005e
        L_0x005a:
            int r12 = r12 + 1
            goto L_0x0046
        L_0x005d:
            r10 = 1
        L_0x005e:
            if (r10 == 0) goto L_0x0063
            int r9 = r9 + 1
            goto L_0x0033
        L_0x0063:
            int r10 = j1.l0.f8453a
            int r10 = r8.size()
            if (r9 > r10) goto L_0x009b
            if (r9 < 0) goto L_0x009b
            if (r9 == 0) goto L_0x0076
            java.util.List r9 = r8.subList(r7, r9)
            r9.clear()
        L_0x0076:
            java.lang.Object r9 = r8.get(r7)
            q1.n r9 = (q1.n) r9
            g1.a0 r15 = r9.f16557d
            g1.a0 r10 = r5.N
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x0097
            v1.f0 r10 = r5.f13267r
            int r11 = r5.f13258i
            int r13 = r9.f16558e
            java.lang.Object r14 = r9.f16559f
            long r6 = r9.f16560g
            r12 = r15
            r9 = r15
            r15 = r6
            r10.b(r11, r12, r13, r14, r15)
            goto L_0x0098
        L_0x0097:
            r9 = r15
        L_0x0098:
            r5.N = r9
            goto L_0x00a1
        L_0x009b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x00a1:
            boolean r6 = r8.isEmpty()
            if (r6 != 0) goto L_0x00b3
            r6 = 0
            java.lang.Object r7 = r8.get(r6)
            q1.n r7 = (q1.n) r7
            boolean r7 = r7.K
            if (r7 != 0) goto L_0x00b4
            goto L_0x011d
        L_0x00b3:
            r6 = 0
        L_0x00b4:
            q1.u[] r4 = r5.C
            r4 = r4[r3]
            boolean r7 = r5.f13252a0
            r9 = r21
            int r4 = r4.w(r0, r2, r9, r7)
            r2 = -5
            if (r4 != r2) goto L_0x011d
            g1.a0 r2 = r0.f10523b
            r2.getClass()
            int r7 = r5.I
            if (r3 != r7) goto L_0x011b
            q1.u[] r7 = r5.C
            r3 = r7[r3]
            monitor-enter(r3)
            int r7 = r3.f15581s     // Catch:{ all -> 0x0118 }
            int r7 = r3.p(r7)     // Catch:{ all -> 0x0118 }
            int r9 = r3.f15581s     // Catch:{ all -> 0x0118 }
            int r10 = r3.f15578p     // Catch:{ all -> 0x0118 }
            if (r9 == r10) goto L_0x00e0
            r17 = 1
            goto L_0x00e2
        L_0x00e0:
            r17 = 0
        L_0x00e2:
            if (r17 == 0) goto L_0x00e9
            int[] r9 = r3.f15572j     // Catch:{ all -> 0x0118 }
            r7 = r9[r7]     // Catch:{ all -> 0x0118 }
            goto L_0x00eb
        L_0x00e9:
            int r7 = r3.C     // Catch:{ all -> 0x0118 }
        L_0x00eb:
            monitor-exit(r3)
        L_0x00ec:
            int r3 = r8.size()
            if (r6 >= r3) goto L_0x00ff
            java.lang.Object r3 = r8.get(r6)
            q1.n r3 = (q1.n) r3
            int r3 = r3.f13189k
            if (r3 == r7) goto L_0x00ff
            int r6 = r6 + 1
            goto L_0x00ec
        L_0x00ff:
            int r3 = r8.size()
            if (r6 >= r3) goto L_0x010e
            java.lang.Object r3 = r8.get(r6)
            q1.n r3 = (q1.n) r3
            g1.a0 r3 = r3.f16557d
            goto L_0x0113
        L_0x010e:
            g1.a0 r3 = r5.M
            r3.getClass()
        L_0x0113:
            g1.a0 r2 = r2.m(r3)
            goto L_0x011b
        L_0x0118:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x011b:
            r0.f10523b = r2
        L_0x011d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.r.a(m1.w0, l1.h, int):int");
    }

    public final boolean b() {
        boolean z10;
        boolean z11;
        int i10 = this.f13240c;
        if (i10 == -3) {
            return true;
        }
        if (i10 == -1 || i10 == -3 || i10 == -2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            v vVar = this.f13239b;
            if (vVar.z() || !vVar.C[i10].s(vVar.f13252a0)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        int i10 = this.f13240c;
        v vVar = this.f13239b;
        if (i10 == -2) {
            vVar.i();
            throw new d(vVar.P.i(this.f13238a).f6676k[0].f6276s, 1);
        } else if (i10 == -1) {
            vVar.E();
        } else if (i10 != -3) {
            vVar.E();
            u uVar = vVar.C[i10];
            n nVar = uVar.f15570h;
            if (nVar != null && nVar.getState() == 1) {
                m f10 = uVar.f15570h.f();
                f10.getClass();
                throw f10;
            }
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final int d(long r8) {
        /*
            r7 = this;
            int r0 = r7.f13240c
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == r2) goto L_0x000f
            r4 = -3
            if (r0 == r4) goto L_0x000f
            r4 = -2
            if (r0 == r4) goto L_0x000f
            r4 = 1
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            if (r4 == 0) goto L_0x0085
            q1.v r4 = r7.f13239b
            boolean r5 = r4.z()
            if (r5 == 0) goto L_0x001c
            goto L_0x0085
        L_0x001c:
            q1.u[] r5 = r4.C
            r5 = r5[r0]
            boolean r6 = r4.f13252a0
            int r8 = r5.q(r8, r6)
            java.util.ArrayList r9 = r4.f13270u
            boolean r4 = r9 instanceof java.util.Collection
            if (r4 == 0) goto L_0x003d
            boolean r4 = r9.isEmpty()
            if (r4 == 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            int r4 = r9.size()
            int r4 = r4 + r2
            java.lang.Object r9 = r9.get(r4)
            goto L_0x0054
        L_0x003d:
            java.util.Iterator r9 = r9.iterator()
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0053
        L_0x0047:
            java.lang.Object r2 = r9.next()
            boolean r4 = r9.hasNext()
            if (r4 != 0) goto L_0x0047
            r9 = r2
            goto L_0x0054
        L_0x0053:
            r9 = 0
        L_0x0054:
            q1.n r9 = (q1.n) r9
            if (r9 == 0) goto L_0x006a
            boolean r2 = r9.K
            if (r2 != 0) goto L_0x006a
            int r2 = r5.f15579q
            int r4 = r5.f15581s
            int r2 = r2 + r4
            int r9 = r9.e(r0)
            int r9 = r9 - r2
            int r8 = java.lang.Math.min(r8, r9)
        L_0x006a:
            monitor-enter(r5)
            if (r8 < 0) goto L_0x0077
            int r9 = r5.f15581s     // Catch:{ all -> 0x0075 }
            int r9 = r9 + r8
            int r0 = r5.f15578p     // Catch:{ all -> 0x0075 }
            if (r9 > r0) goto L_0x0077
            goto L_0x0078
        L_0x0075:
            r8 = move-exception
            goto L_0x0083
        L_0x0077:
            r1 = 0
        L_0x0078:
            j1.a.b(r1)     // Catch:{ all -> 0x0075 }
            int r9 = r5.f15581s     // Catch:{ all -> 0x0075 }
            int r9 = r9 + r8
            r5.f15581s = r9     // Catch:{ all -> 0x0075 }
            monitor-exit(r5)
            r3 = r8
            goto L_0x0085
        L_0x0083:
            monitor-exit(r5)
            throw r8
        L_0x0085:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.r.d(long):int");
    }

    public final void e() {
        boolean z10;
        if (this.f13240c == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        v vVar = this.f13239b;
        vVar.i();
        vVar.R.getClass();
        int[] iArr = vVar.R;
        int i10 = this.f13238a;
        int i11 = iArr[i10];
        if (i11 != -1) {
            boolean[] zArr = vVar.U;
            if (!zArr[i11]) {
                zArr[i11] = true;
                this.f13240c = i11;
            }
        } else if (vVar.Q.contains(vVar.P.i(i10))) {
            i11 = -3;
            this.f13240c = i11;
        }
        i11 = -2;
        this.f13240c = i11;
    }
}
