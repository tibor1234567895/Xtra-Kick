package kb;

import h3.u1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jb.a;
import la.v;
import lb.b;
import lb.c;
import lb.i;
import lb.q;
import lb.t;
import pa.e;
import pa.k;

public final class e1 extends b implements l0, i, q {

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9298m = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: l  reason: collision with root package name */
    public int f9299l;

    public e1(Object obj) {
        this._state = obj;
    }

    public final Object a(Object obj, e eVar) {
        k(obj);
        return v.f9814a;
    }

    /* JADX WARNING: type inference failed for: r13v12, types: [pa.h] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b0 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c3 A[Catch:{ all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d7 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d9 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00dc A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kb.j r12, pa.e r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kb.d1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            kb.d1 r0 = (kb.d1) r0
            int r1 = r0.f9289o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9289o = r1
            goto L_0x0018
        L_0x0013:
            kb.d1 r0 = new kb.d1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f9287m
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9289o
            r3 = 1
            r4 = 2
            r5 = 3
            r6 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r3) goto L_0x004f
            if (r2 == r4) goto L_0x0040
            if (r2 != r5) goto L_0x0038
            java.lang.Object r12 = r0.f9286l
            hb.l1 r2 = r0.f9285k
            kb.g1 r7 = r0.f9284j
            kb.j r8 = r0.f9283i
            kb.e1 r9 = r0.f9282h
            hb.h0.O1(r13)     // Catch:{ all -> 0x0059 }
            goto L_0x008c
        L_0x0038:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0040:
            java.lang.Object r12 = r0.f9286l
            hb.l1 r2 = r0.f9285k
            kb.g1 r7 = r0.f9284j
            kb.j r8 = r0.f9283i
            kb.e1 r9 = r0.f9282h
            hb.h0.O1(r13)     // Catch:{ all -> 0x0059 }
            goto L_0x00c5
        L_0x004f:
            kb.g1 r7 = r0.f9284j
            kb.j r12 = r0.f9283i
            kb.e1 r9 = r0.f9282h
            hb.h0.O1(r13)     // Catch:{ all -> 0x0059 }
            goto L_0x007d
        L_0x0059:
            r12 = move-exception
            goto L_0x00ef
        L_0x005c:
            hb.h0.O1(r13)
            lb.c r13 = r11.e()
            kb.g1 r13 = (kb.g1) r13
            boolean r2 = r12 instanceof kb.i1     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x007b
            r2 = r12
            kb.i1 r2 = (kb.i1) r2     // Catch:{ all -> 0x00f1 }
            r0.f9282h = r11     // Catch:{ all -> 0x00f1 }
            r0.f9283i = r12     // Catch:{ all -> 0x00f1 }
            r0.f9284j = r13     // Catch:{ all -> 0x00f1 }
            r0.f9289o = r3     // Catch:{ all -> 0x00f1 }
            java.lang.Object r2 = r2.b(r0)     // Catch:{ all -> 0x00f1 }
            if (r2 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r9 = r11
            r7 = r13
        L_0x007d:
            pa.k r13 = r0.getContext()     // Catch:{ all -> 0x0059 }
            hb.k1 r2 = hb.l1.f7823b     // Catch:{ all -> 0x0059 }
            pa.h r13 = r13.N(r2)     // Catch:{ all -> 0x0059 }
            r2 = r13
            hb.l1 r2 = (hb.l1) r2     // Catch:{ all -> 0x0059 }
            r8 = r12
            r12 = r6
        L_0x008c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = f9298m     // Catch:{ all -> 0x0059 }
            java.lang.Object r13 = r13.get(r9)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00a2
            boolean r10 = r2.c()     // Catch:{ all -> 0x0059 }
            if (r10 == 0) goto L_0x009b
            goto L_0x00a2
        L_0x009b:
            hb.u1 r2 = (hb.u1) r2     // Catch:{ all -> 0x0059 }
            java.util.concurrent.CancellationException r12 = r2.C()     // Catch:{ all -> 0x0059 }
            throw r12     // Catch:{ all -> 0x0059 }
        L_0x00a2:
            if (r12 == 0) goto L_0x00aa
            boolean r10 = xa.j.a(r12, r13)     // Catch:{ all -> 0x0059 }
            if (r10 != 0) goto L_0x00c5
        L_0x00aa:
            h3.u1 r12 = lb.t.f9862a     // Catch:{ all -> 0x0059 }
            if (r13 != r12) goto L_0x00b0
            r12 = r6
            goto L_0x00b1
        L_0x00b0:
            r12 = r13
        L_0x00b1:
            r0.f9282h = r9     // Catch:{ all -> 0x0059 }
            r0.f9283i = r8     // Catch:{ all -> 0x0059 }
            r0.f9284j = r7     // Catch:{ all -> 0x0059 }
            r0.f9285k = r2     // Catch:{ all -> 0x0059 }
            r0.f9286l = r13     // Catch:{ all -> 0x0059 }
            r0.f9289o = r4     // Catch:{ all -> 0x0059 }
            java.lang.Object r12 = r8.a(r12, r0)     // Catch:{ all -> 0x0059 }
            if (r12 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r12 = r13
        L_0x00c5:
            r7.getClass()     // Catch:{ all -> 0x0059 }
            h3.u1 r13 = kb.f1.f9304a     // Catch:{ all -> 0x0059 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = kb.g1.f9315a     // Catch:{ all -> 0x0059 }
            java.lang.Object r13 = r10.getAndSet(r7, r13)     // Catch:{ all -> 0x0059 }
            xa.j.c(r13)     // Catch:{ all -> 0x0059 }
            h3.u1 r10 = kb.f1.f9305b     // Catch:{ all -> 0x0059 }
            if (r13 != r10) goto L_0x00d9
            r13 = 1
            goto L_0x00da
        L_0x00d9:
            r13 = 0
        L_0x00da:
            if (r13 != 0) goto L_0x008c
            r0.f9282h = r9     // Catch:{ all -> 0x0059 }
            r0.f9283i = r8     // Catch:{ all -> 0x0059 }
            r0.f9284j = r7     // Catch:{ all -> 0x0059 }
            r0.f9285k = r2     // Catch:{ all -> 0x0059 }
            r0.f9286l = r12     // Catch:{ all -> 0x0059 }
            r0.f9289o = r5     // Catch:{ all -> 0x0059 }
            java.lang.Object r13 = r7.c(r0)     // Catch:{ all -> 0x0059 }
            if (r13 != r1) goto L_0x008c
            return r1
        L_0x00ef:
            r13 = r7
            goto L_0x00f3
        L_0x00f1:
            r12 = move-exception
            r9 = r11
        L_0x00f3:
            r9.i(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e1.b(kb.j, pa.e):java.lang.Object");
    }

    public final void c() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public final i d(k kVar, int i10, a aVar) {
        boolean z10;
        u1 u1Var = f1.f9304a;
        if (i10 < 0 || i10 >= 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if ((!z10 && i10 != -2) || aVar != a.DROP_OLDEST) {
            u1 u1Var2 = t0.f9395a;
            if (!((i10 == 0 || i10 == -3) && aVar == a.SUSPEND)) {
                return new i(i10, kVar, aVar, this);
            }
        }
        return this;
    }

    public final c f() {
        return new g1();
    }

    public final c[] g() {
        return new g1[2];
    }

    public final Object getValue() {
        u1 u1Var = t.f9862a;
        Object obj = f9298m.get(this);
        if (obj == u1Var) {
            return null;
        }
        return obj;
    }

    public final boolean h(Object obj) {
        k(obj);
        return true;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void k(java.lang.Object r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0004
            h3.u1 r12 = lb.t.f9862a
        L_0x0004:
            monitor-enter(r11)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f9298m     // Catch:{ all -> 0x008f }
            java.lang.Object r1 = r0.get(r11)     // Catch:{ all -> 0x008f }
            boolean r1 = xa.j.a(r1, r12)     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x0014
        L_0x0011:
            monitor-exit(r11)
            goto L_0x008e
        L_0x0014:
            r0.set(r11, r12)     // Catch:{ all -> 0x008f }
            int r12 = r11.f9299l     // Catch:{ all -> 0x008f }
            r0 = r12 & 1
            if (r0 != 0) goto L_0x0089
            r0 = 1
            int r12 = r12 + r0
            r11.f9299l = r12     // Catch:{ all -> 0x008f }
            lb.c[] r1 = r11.f9818h     // Catch:{ all -> 0x008f }
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x008f }
            monitor-exit(r11)
        L_0x0026:
            kb.g1[] r1 = (kb.g1[]) r1
            if (r1 == 0) goto L_0x0074
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x002d:
            if (r4 >= r2) goto L_0x0074
            r5 = r1[r4]
            if (r5 == 0) goto L_0x0071
        L_0x0033:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kb.g1.f9315a
            java.lang.Object r7 = r6.get(r5)
            if (r7 != 0) goto L_0x003c
            goto L_0x0071
        L_0x003c:
            h3.u1 r8 = kb.f1.f9305b
            if (r7 != r8) goto L_0x0041
            goto L_0x0071
        L_0x0041:
            h3.u1 r9 = kb.f1.f9304a
            if (r7 != r9) goto L_0x0057
        L_0x0045:
            boolean r9 = r6.compareAndSet(r5, r7, r8)
            if (r9 == 0) goto L_0x004d
            r6 = 1
            goto L_0x0054
        L_0x004d:
            java.lang.Object r9 = r6.get(r5)
            if (r9 == r7) goto L_0x0045
            r6 = 0
        L_0x0054:
            if (r6 == 0) goto L_0x0033
            goto L_0x0071
        L_0x0057:
            boolean r8 = r6.compareAndSet(r5, r7, r9)
            if (r8 == 0) goto L_0x005f
            r6 = 1
            goto L_0x0066
        L_0x005f:
            java.lang.Object r8 = r6.get(r5)
            if (r8 == r7) goto L_0x0057
            r6 = 0
        L_0x0066:
            if (r6 == 0) goto L_0x0033
            hb.l r7 = (hb.l) r7
            int r5 = la.l.f9802h
            la.v r5 = la.v.f9814a
            r7.resumeWith(r5)
        L_0x0071:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0074:
            monitor-enter(r11)
            int r1 = r11.f9299l     // Catch:{ all -> 0x0086 }
            if (r1 != r12) goto L_0x007d
            int r12 = r12 + r0
            r11.f9299l = r12     // Catch:{ all -> 0x0086 }
            goto L_0x0011
        L_0x007d:
            lb.c[] r12 = r11.f9818h     // Catch:{ all -> 0x0086 }
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x0086 }
            monitor-exit(r11)
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0026
        L_0x0086:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L_0x0089:
            int r12 = r12 + 2
            r11.f9299l = r12     // Catch:{ all -> 0x008f }
            goto L_0x0011
        L_0x008e:
            return
        L_0x008f:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e1.k(java.lang.Object):void");
    }
}
