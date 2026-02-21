package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import mb.y;
import pa.e;
import pa.k;

public final class n0 extends y {

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7829l = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_decision");
    private volatile int _decision;

    public n0(e eVar, k kVar) {
        super(eVar, kVar);
    }

    public final void p(Object obj) {
        q(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.lang.Object r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f7829l
            int r1 = r0.get(r4)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            if (r1 != r2) goto L_0x000e
            r2 = 0
            goto L_0x0021
        L_0x000e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x001a:
            r1 = 2
            boolean r0 = r0.compareAndSet(r4, r3, r1)
            if (r0 == 0) goto L_0x0000
        L_0x0021:
            if (r2 == 0) goto L_0x0024
            return
        L_0x0024:
            pa.e r0 = r4.f10888k
            pa.e r0 = qa.d.b(r0)
            java.lang.Object r5 = hb.h0.r1(r5)
            r1 = 0
            mb.j.a(r0, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.n0.q(java.lang.Object):void");
    }
}
