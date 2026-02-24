package mb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10876a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_cur");
    private volatile Object _cur = new t(8, false);

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b A[LOOP:1: B:7:0x001b->B:10:0x0026, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.Object r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f10876a
            java.lang.Object r1 = r0.get(r4)
            mb.t r1 = (mb.t) r1
            int r2 = r1.a(r5)
            r3 = 1
            if (r2 == 0) goto L_0x0029
            if (r2 == r3) goto L_0x0017
            r0 = 2
            if (r2 == r0) goto L_0x0015
            goto L_0x0000
        L_0x0015:
            r5 = 0
            return r5
        L_0x0017:
            mb.t r2 = r1.c()
        L_0x001b:
            boolean r3 = r0.compareAndSet(r4, r1, r2)
            if (r3 == 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            java.lang.Object r3 = r0.get(r4)
            if (r3 == r1) goto L_0x001b
            goto L_0x0000
        L_0x0029:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.q.a(java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0013 A[LOOP:1: B:4:0x0013->B:7:0x001e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f10876a
            java.lang.Object r1 = r0.get(r4)
            mb.t r1 = (mb.t) r1
            boolean r2 = r1.b()
            if (r2 == 0) goto L_0x000f
            return
        L_0x000f:
            mb.t r2 = r1.c()
        L_0x0013:
            boolean r3 = r0.compareAndSet(r4, r1, r2)
            if (r3 == 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            java.lang.Object r3 = r0.get(r4)
            if (r3 == r1) goto L_0x0013
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.q.b():void");
    }

    public final int c() {
        t tVar = (t) f10876a.get(this);
        tVar.getClass();
        long j10 = t.f10880g.get(tVar);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0015 A[LOOP:1: B:4:0x0015->B:7:0x0020, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d() {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f10876a
            java.lang.Object r1 = r0.get(r4)
            mb.t r1 = (mb.t) r1
            java.lang.Object r2 = r1.d()
            h3.u1 r3 = mb.t.f10881h
            if (r2 == r3) goto L_0x0011
            return r2
        L_0x0011:
            mb.t r2 = r1.c()
        L_0x0015:
            boolean r3 = r0.compareAndSet(r4, r1, r2)
            if (r3 == 0) goto L_0x001c
            goto L_0x0000
        L_0x001c:
            java.lang.Object r3 = r0.get(r4)
            if (r3 == r1) goto L_0x0015
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.q.d():java.lang.Object");
    }
}
