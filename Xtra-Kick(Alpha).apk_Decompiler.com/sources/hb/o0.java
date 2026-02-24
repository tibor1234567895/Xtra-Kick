package hb;

import java.util.concurrent.CancellationException;
import la.a;
import nb.j;
import pa.e;

public abstract class o0 extends j {

    /* renamed from: j  reason: collision with root package name */
    public int f7831j;

    public o0(int i10) {
        this.f7831j = i10;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract e c();

    public Throwable e(Object obj) {
        w wVar = obj instanceof w ? (w) obj : null;
        if (wVar != null) {
            return wVar.f7875a;
        }
        return null;
    }

    public Object g(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            xa.j.c(th);
            h0.K0(c().getContext(), new g0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object k();

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        if (r4.f0() != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
        if (r4.f0() != false) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ all -> 0x0060, all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062 A[Catch:{ all -> 0x0060, all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078 A[SYNTHETIC, Splitter:B:29:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            e0.q r0 = r12.f11822i
            pa.e r1 = r12.c()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            xa.j.d(r2, r1)     // Catch:{ all -> 0x00a2 }
            mb.i r1 = (mb.i) r1     // Catch:{ all -> 0x00a2 }
            pa.e r2 = r1.f10861l     // Catch:{ all -> 0x00a2 }
            java.lang.Object r1 = r1.f10863n     // Catch:{ all -> 0x00a2 }
            pa.k r3 = r2.getContext()     // Catch:{ all -> 0x00a2 }
            java.lang.Object r1 = mb.f0.c(r3, r1)     // Catch:{ all -> 0x00a2 }
            h3.u1 r4 = mb.f0.f10849a     // Catch:{ all -> 0x00a2 }
            r5 = 0
            if (r1 == r4) goto L_0x0023
            hb.i2 r4 = hb.h0.Z1(r2, r3, r1)     // Catch:{ all -> 0x00a2 }
            goto L_0x0024
        L_0x0023:
            r4 = r5
        L_0x0024:
            pa.k r6 = r2.getContext()     // Catch:{ all -> 0x0060 }
            java.lang.Object r7 = r12.k()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r8 = r12.e(r7)     // Catch:{ all -> 0x0060 }
            if (r8 != 0) goto L_0x0047
            int r9 = r12.f7831j     // Catch:{ all -> 0x0060 }
            r10 = 1
            if (r9 == r10) goto L_0x003c
            r11 = 2
            if (r9 != r11) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 == 0) goto L_0x0047
            hb.k1 r9 = hb.l1.f7823b     // Catch:{ all -> 0x0060 }
            pa.h r6 = r6.N(r9)     // Catch:{ all -> 0x0060 }
            hb.l1 r6 = (hb.l1) r6     // Catch:{ all -> 0x0060 }
            goto L_0x0048
        L_0x0047:
            r6 = r5
        L_0x0048:
            if (r6 == 0) goto L_0x0062
            boolean r9 = r6.c()     // Catch:{ all -> 0x0060 }
            if (r9 != 0) goto L_0x0062
            hb.u1 r6 = (hb.u1) r6     // Catch:{ all -> 0x0060 }
            java.util.concurrent.CancellationException r6 = r6.C()     // Catch:{ all -> 0x0060 }
            r12.b(r7, r6)     // Catch:{ all -> 0x0060 }
            int r7 = la.l.f9802h     // Catch:{ all -> 0x0060 }
            la.k r6 = hb.h0.I(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0071
        L_0x0060:
            r2 = move-exception
            goto L_0x0096
        L_0x0062:
            if (r8 == 0) goto L_0x006b
            int r6 = la.l.f9802h     // Catch:{ all -> 0x0060 }
            la.k r6 = hb.h0.I(r8)     // Catch:{ all -> 0x0060 }
            goto L_0x0071
        L_0x006b:
            int r6 = la.l.f9802h     // Catch:{ all -> 0x0060 }
            java.lang.Object r6 = r12.g(r7)     // Catch:{ all -> 0x0060 }
        L_0x0071:
            r2.resumeWith(r6)     // Catch:{ all -> 0x0060 }
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x007e
            boolean r2 = r4.f0()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0081
        L_0x007e:
            mb.f0.a(r3, r1)     // Catch:{ all -> 0x00a2 }
        L_0x0081:
            r0.getClass()     // Catch:{ all -> 0x0087 }
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x0087 }
            goto L_0x008e
        L_0x0087:
            r0 = move-exception
            int r1 = la.l.f9802h
            la.k r0 = hb.h0.I(r0)
        L_0x008e:
            java.lang.Throwable r0 = la.l.a(r0)
            r12.h(r5, r0)
            goto L_0x00b9
        L_0x0096:
            if (r4 == 0) goto L_0x009e
            boolean r4 = r4.f0()     // Catch:{ all -> 0x00a2 }
            if (r4 == 0) goto L_0x00a1
        L_0x009e:
            mb.f0.a(r3, r1)     // Catch:{ all -> 0x00a2 }
        L_0x00a1:
            throw r2     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r1 = move-exception
            int r2 = la.l.f9802h     // Catch:{ all -> 0x00ab }
            r0.getClass()     // Catch:{ all -> 0x00ab }
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x00ab }
            goto L_0x00b2
        L_0x00ab:
            r0 = move-exception
            int r2 = la.l.f9802h
            la.k r0 = hb.h0.I(r0)
        L_0x00b2:
            java.lang.Throwable r0 = la.l.a(r0)
            r12.h(r1, r0)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.o0.run():void");
    }
}
