package jb;

import h3.u1;
import hb.k2;
import hb.l;
import mb.a0;
import mb.z;

public final class b implements k2 {

    /* renamed from: h  reason: collision with root package name */
    public Object f8885h = e.f8915p;

    /* renamed from: i  reason: collision with root package name */
    public l f8886i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c f8887j;

    public b(c cVar) {
        this.f8887j = cVar;
    }

    public final void a(z zVar, int i10) {
        l lVar = this.f8886i;
        if (lVar != null) {
            lVar.a(zVar, i10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0140, code lost:
        if (r10 != null) goto L_0x0142;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(ra.c r18) {
        /*
            r17 = this;
            r7 = r17
            r0 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = jb.c.f8893o
            jb.c r8 = r7.f8887j
            java.lang.Object r1 = r1.get(r8)
            jb.l r1 = (jb.l) r1
        L_0x000d:
            r8.getClass()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = jb.c.f8888j
            long r2 = r2.get(r8)
            r9 = 1
            boolean r2 = r8.u(r2, r9)
            if (r2 == 0) goto L_0x002e
            h3.u1 r0 = jb.e.f8911l
            r7.f8885h = r0
            java.lang.Throwable r0 = r8.p()
            if (r0 != 0) goto L_0x002b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0162
        L_0x002b:
            int r1 = mb.a0.f10838a
            throw r0
        L_0x002e:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = jb.c.f8889k
            long r10 = r2.getAndIncrement(r8)
            int r2 = jb.e.f8901b
            long r2 = (long) r2
            long r4 = r10 / r2
            long r2 = r10 % r2
            int r12 = (int) r2
            long r2 = r1.f10890j
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x004b
            jb.l r2 = r8.n(r4, r1)
            if (r2 != 0) goto L_0x0049
            goto L_0x000d
        L_0x0049:
            r13 = r2
            goto L_0x004c
        L_0x004b:
            r13 = r1
        L_0x004c:
            r1 = r8
            r2 = r13
            r3 = r12
            r4 = r10
            r6 = r0
            java.lang.Object r1 = r1.C(r2, r3, r4, r6)
            h3.u1 r14 = jb.e.f8912m
            if (r1 == r14) goto L_0x0163
            h3.u1 r15 = jb.e.f8914o
            if (r1 != r15) goto L_0x006a
            long r1 = r8.s()
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0068
            r13.a()
        L_0x0068:
            r1 = r13
            goto L_0x000d
        L_0x006a:
            h3.u1 r0 = jb.e.f8913n
            if (r1 != r0) goto L_0x015b
            jb.c r0 = r7.f8887j
            pa.e r1 = qa.d.b(r18)
            hb.l r6 = hb.h0.y0(r1)
            r7.f8886i = r6     // Catch:{ all -> 0x0155 }
            r1 = r0
            r2 = r13
            r3 = r12
            r4 = r10
            r9 = r6
            r6 = r17
            java.lang.Object r1 = r1.C(r2, r3, r4, r6)     // Catch:{ all -> 0x008c }
            if (r1 != r14) goto L_0x008f
            r7.a(r13, r12)     // Catch:{ all -> 0x008c }
            goto L_0x0149
        L_0x008c:
            r0 = move-exception
            goto L_0x0157
        L_0x008f:
            pa.k r12 = r9.f7822l
            r14 = 0
            wa.l r6 = r0.f8898i
            if (r1 != r15) goto L_0x0136
            long r1 = r0.s()     // Catch:{ all -> 0x008c }
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a1
            r13.a()     // Catch:{ all -> 0x008c }
        L_0x00a1:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = jb.c.f8893o     // Catch:{ all -> 0x008c }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x008c }
            jb.l r1 = (jb.l) r1     // Catch:{ all -> 0x008c }
        L_0x00a9:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = jb.c.f8888j     // Catch:{ all -> 0x008c }
            long r2 = r2.get(r0)     // Catch:{ all -> 0x008c }
            r10 = 1
            boolean r2 = r0.u(r2, r10)     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x00d7
            hb.l r0 = r7.f8886i     // Catch:{ all -> 0x008c }
            xa.j.c(r0)     // Catch:{ all -> 0x008c }
            r7.f8886i = r14     // Catch:{ all -> 0x008c }
            h3.u1 r1 = jb.e.f8911l     // Catch:{ all -> 0x008c }
            r7.f8885h = r1     // Catch:{ all -> 0x008c }
            java.lang.Throwable r1 = r8.p()     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x00cc
            int r1 = la.l.f9802h     // Catch:{ all -> 0x008c }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008c }
            goto L_0x00d2
        L_0x00cc:
            int r2 = la.l.f9802h     // Catch:{ all -> 0x008c }
            la.k r1 = hb.h0.I(r1)     // Catch:{ all -> 0x008c }
        L_0x00d2:
            r0.resumeWith(r1)     // Catch:{ all -> 0x008c }
            goto L_0x0149
        L_0x00d7:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = jb.c.f8889k     // Catch:{ all -> 0x008c }
            long r15 = r2.getAndIncrement(r0)     // Catch:{ all -> 0x008c }
            int r2 = jb.e.f8901b     // Catch:{ all -> 0x008c }
            long r2 = (long) r2     // Catch:{ all -> 0x008c }
            long r4 = r15 / r2
            long r2 = r15 % r2
            int r11 = (int) r2     // Catch:{ all -> 0x008c }
            long r2 = r1.f10890j     // Catch:{ all -> 0x008c }
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f4
            jb.l r2 = r0.n(r4, r1)     // Catch:{ all -> 0x008c }
            if (r2 != 0) goto L_0x00f2
            goto L_0x00a9
        L_0x00f2:
            r13 = r2
            goto L_0x00f5
        L_0x00f4:
            r13 = r1
        L_0x00f5:
            r1 = r0
            r2 = r13
            r3 = r11
            r4 = r15
            r10 = r6
            r6 = r17
            java.lang.Object r1 = r1.C(r2, r3, r4, r6)     // Catch:{ all -> 0x008c }
            h3.u1 r2 = jb.e.f8912m     // Catch:{ all -> 0x008c }
            if (r1 != r2) goto L_0x0108
            r7.a(r13, r11)     // Catch:{ all -> 0x008c }
            goto L_0x0149
        L_0x0108:
            h3.u1 r2 = jb.e.f8914o     // Catch:{ all -> 0x008c }
            if (r1 != r2) goto L_0x011a
            long r1 = r0.s()     // Catch:{ all -> 0x008c }
            int r3 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0117
            r13.a()     // Catch:{ all -> 0x008c }
        L_0x0117:
            r6 = r10
            r1 = r13
            goto L_0x00a9
        L_0x011a:
            h3.u1 r0 = jb.e.f8913n     // Catch:{ all -> 0x008c }
            if (r1 == r0) goto L_0x012a
            r13.a()     // Catch:{ all -> 0x008c }
            r7.f8885h = r1     // Catch:{ all -> 0x008c }
            r7.f8886i = r14     // Catch:{ all -> 0x008c }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x008c }
            if (r10 == 0) goto L_0x0146
            goto L_0x0142
        L_0x012a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008c }
            r0.<init>(r1)     // Catch:{ all -> 0x008c }
            throw r0     // Catch:{ all -> 0x008c }
        L_0x0136:
            r10 = r6
            r13.a()     // Catch:{ all -> 0x008c }
            r7.f8885h = r1     // Catch:{ all -> 0x008c }
            r7.f8886i = r14     // Catch:{ all -> 0x008c }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x008c }
            if (r10 == 0) goto L_0x0146
        L_0x0142:
            j3.m2 r14 = hb.h0.m(r10, r1, r12)     // Catch:{ all -> 0x008c }
        L_0x0146:
            r9.i(r0, r14)     // Catch:{ all -> 0x008c }
        L_0x0149:
            java.lang.Object r0 = r9.u()
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x0154
            hb.h0.m1(r18)
        L_0x0154:
            return r0
        L_0x0155:
            r0 = move-exception
            r9 = r6
        L_0x0157:
            r9.C()
            throw r0
        L_0x015b:
            r13.a()
            r7.f8885h = r1
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L_0x0162:
            return r0
        L_0x0163:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unreachable"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.b.b(ra.c):java.lang.Object");
    }

    public final Object c() {
        boolean z10;
        Object obj = this.f8885h;
        u1 u1Var = e.f8915p;
        if (obj != u1Var) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f8885h = u1Var;
            if (obj != e.f8911l) {
                return obj;
            }
            Throwable p10 = this.f8887j.p();
            if (p10 == null) {
                p10 = new m();
            }
            int i10 = a0.f10838a;
            throw p10;
        }
        throw new IllegalStateException("`hasNext()` has not been invoked".toString());
    }
}
