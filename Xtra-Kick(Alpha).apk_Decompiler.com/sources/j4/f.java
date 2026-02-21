package j4;

import ob.i;
import s4.m;

public final class f implements k {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f8746a;

    /* renamed from: b  reason: collision with root package name */
    public final m f8747b;

    /* renamed from: c  reason: collision with root package name */
    public final ob.f f8748c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8749d;

    static {
        new b(0);
    }

    public f(e0 e0Var, m mVar, i iVar, int i10) {
        this.f8746a = e0Var;
        this.f8747b = mVar;
        this.f8748c = iVar;
        this.f8749d = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        if (r7 == r1) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof j4.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            j4.e r0 = (j4.e) r0
            int r1 = r0.f8745l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8745l = r1
            goto L_0x0018
        L_0x0013:
            j4.e r0 = new j4.e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f8743j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f8745l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.f8741h
            ob.f r0 = (ob.f) r0
            hb.h0.O1(r7)     // Catch:{ all -> 0x002f }
            goto L_0x009f
        L_0x002f:
            r7 = move-exception
            goto L_0x00a7
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003a:
            ob.f r2 = r0.f8742i
            java.lang.Object r4 = r0.f8741h
            j4.f r4 = (j4.f) r4
            hb.h0.O1(r7)
            goto L_0x008a
        L_0x0044:
            hb.h0.O1(r7)
            r0.f8741h = r6
            ob.f r2 = r6.f8748c
            r0.f8742i = r2
            r0.f8745l = r4
            r7 = r2
            ob.i r7 = (ob.i) r7
            r7.getClass()
        L_0x0055:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = ob.i.f12382g
            int r4 = r4.getAndDecrement(r7)
            int r5 = r7.f12383a
            if (r4 > r5) goto L_0x0055
            if (r4 <= 0) goto L_0x0062
            goto L_0x0084
        L_0x0062:
            pa.e r4 = qa.d.b(r0)
            hb.l r4 = hb.h0.y0(r4)
            boolean r5 = r7.b(r4)     // Catch:{ all -> 0x00b0 }
            if (r5 != 0) goto L_0x0073
            r7.a(r4)     // Catch:{ all -> 0x00b0 }
        L_0x0073:
            java.lang.Object r7 = r4.u()
            if (r7 != r1) goto L_0x007c
            hb.h0.m1(r0)
        L_0x007c:
            if (r7 != r1) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            la.v r7 = la.v.f9814a
        L_0x0081:
            if (r7 != r1) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            la.v r7 = la.v.f9814a
        L_0x0086:
            if (r7 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r4 = r6
        L_0x008a:
            androidx.lifecycle.p1 r7 = new androidx.lifecycle.p1     // Catch:{ all -> 0x00a9 }
            r5 = 7
            r7.<init>(r5, r4)     // Catch:{ all -> 0x00a9 }
            r0.f8741h = r2     // Catch:{ all -> 0x00a9 }
            r4 = 0
            r0.f8742i = r4     // Catch:{ all -> 0x00a9 }
            r0.f8745l = r3     // Catch:{ all -> 0x00a9 }
            java.lang.Object r7 = hb.h0.x1(r7, r0)     // Catch:{ all -> 0x00a9 }
            if (r7 != r1) goto L_0x009e
            return r1
        L_0x009e:
            r0 = r2
        L_0x009f:
            j4.h r7 = (j4.h) r7     // Catch:{ all -> 0x002f }
            ob.i r0 = (ob.i) r0
            r0.c()
            return r7
        L_0x00a7:
            r2 = r0
            goto L_0x00aa
        L_0x00a9:
            r7 = move-exception
        L_0x00aa:
            ob.i r2 = (ob.i) r2
            r2.c()
            throw r7
        L_0x00b0:
            r7 = move-exception
            r4.C()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.f.a(pa.e):java.lang.Object");
    }
}
