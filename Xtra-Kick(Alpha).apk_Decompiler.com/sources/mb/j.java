package mb;

import h3.u1;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f10864a = new u1("UNDEFINED", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final u1 f10865b = new u1("REUSABLE_CLAIMED", 2);

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        if (r5.f0() != false) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(pa.e r7, java.lang.Object r8, wa.l r9) {
        /*
            boolean r0 = r7 instanceof mb.i
            if (r0 == 0) goto L_0x00c4
            mb.i r7 = (mb.i) r7
            java.lang.Throwable r0 = la.l.a(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0017
            if (r9 == 0) goto L_0x0015
            hb.x r0 = new hb.x
            r0.<init>(r8, r9)
            goto L_0x001d
        L_0x0015:
            r0 = r8
            goto L_0x001d
        L_0x0017:
            hb.w r9 = new hb.w
            r9.<init>(r0, r1)
            r0 = r9
        L_0x001d:
            pa.e r9 = r7.f10861l
            pa.k r2 = r7.getContext()
            hb.d0 r3 = r7.f10860k
            boolean r2 = r3.O0(r2)
            r4 = 1
            if (r2 == 0) goto L_0x0039
            r7.f10862m = r0
            r7.f7831j = r4
            pa.k r8 = r7.getContext()
            r3.M0(r8, r7)
            goto L_0x00c7
        L_0x0039:
            hb.f2 r2 = hb.f2.f7793a
            r2.getClass()
            hb.s0 r2 = hb.f2.a()
            boolean r3 = r2.T0()
            if (r3 == 0) goto L_0x0051
            r7.f10862m = r0
            r7.f7831j = r4
            r2.R0(r7)
            goto L_0x00c7
        L_0x0051:
            r2.S0(r4)
            r3 = 0
            pa.k r5 = r7.getContext()     // Catch:{ all -> 0x007b }
            hb.k1 r6 = hb.l1.f7823b     // Catch:{ all -> 0x007b }
            pa.h r5 = r5.N(r6)     // Catch:{ all -> 0x007b }
            hb.l1 r5 = (hb.l1) r5     // Catch:{ all -> 0x007b }
            if (r5 == 0) goto L_0x007d
            boolean r6 = r5.c()     // Catch:{ all -> 0x007b }
            if (r6 != 0) goto L_0x007d
            hb.u1 r5 = (hb.u1) r5     // Catch:{ all -> 0x007b }
            java.util.concurrent.CancellationException r1 = r5.C()     // Catch:{ all -> 0x007b }
            r7.b(r0, r1)     // Catch:{ all -> 0x007b }
            la.k r0 = hb.h0.I(r1)     // Catch:{ all -> 0x007b }
            r7.resumeWith(r0)     // Catch:{ all -> 0x007b }
            r1 = 1
            goto L_0x007d
        L_0x007b:
            r8 = move-exception
            goto L_0x00b8
        L_0x007d:
            if (r1 != 0) goto L_0x00b1
            java.lang.Object r0 = r7.f10863n     // Catch:{ all -> 0x007b }
            pa.k r1 = r9.getContext()     // Catch:{ all -> 0x007b }
            java.lang.Object r0 = mb.f0.c(r1, r0)     // Catch:{ all -> 0x007b }
            h3.u1 r5 = mb.f0.f10849a     // Catch:{ all -> 0x007b }
            if (r0 == r5) goto L_0x0092
            hb.i2 r5 = hb.h0.Z1(r9, r1, r0)     // Catch:{ all -> 0x007b }
            goto L_0x0093
        L_0x0092:
            r5 = r3
        L_0x0093:
            r9.resumeWith(r8)     // Catch:{ all -> 0x00a4 }
            la.v r8 = la.v.f9814a     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x00a0
            boolean r8 = r5.f0()     // Catch:{ all -> 0x007b }
            if (r8 == 0) goto L_0x00b1
        L_0x00a0:
            mb.f0.a(r1, r0)     // Catch:{ all -> 0x007b }
            goto L_0x00b1
        L_0x00a4:
            r8 = move-exception
            if (r5 == 0) goto L_0x00ad
            boolean r9 = r5.f0()     // Catch:{ all -> 0x007b }
            if (r9 == 0) goto L_0x00b0
        L_0x00ad:
            mb.f0.a(r1, r0)     // Catch:{ all -> 0x007b }
        L_0x00b0:
            throw r8     // Catch:{ all -> 0x007b }
        L_0x00b1:
            boolean r8 = r2.V0()     // Catch:{ all -> 0x007b }
            if (r8 != 0) goto L_0x00b1
            goto L_0x00bb
        L_0x00b8:
            r7.h(r8, r3)     // Catch:{ all -> 0x00bf }
        L_0x00bb:
            r2.Q0(r4)
            goto L_0x00c7
        L_0x00bf:
            r7 = move-exception
            r2.Q0(r4)
            throw r7
        L_0x00c4:
            r7.resumeWith(r8)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.j.a(pa.e, java.lang.Object, wa.l):void");
    }
}
