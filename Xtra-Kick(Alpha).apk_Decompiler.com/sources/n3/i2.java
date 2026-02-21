package n3;

import hb.h0;
import kb.i;
import pa.e;
import wa.l;

public final class i2 {

    /* renamed from: a  reason: collision with root package name */
    public final l f11250a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11251b;

    /* renamed from: c  reason: collision with root package name */
    public final r3 f11252c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f11253d = new b0(0);

    /* renamed from: e  reason: collision with root package name */
    public final b0 f11254e = new b0(0);

    /* renamed from: f  reason: collision with root package name */
    public final i f11255f = h0.G1(new a2((r4) null, this, (e) null));

    public i2(p3 p3Var, Object obj, r3 r3Var) {
        this.f11250a = p3Var;
        this.f11251b = obj;
        this.f11252c = r3Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        if (r8 == r1) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        if (r3 != false) goto L_0x0099;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(n3.i2 r6, n3.n4 r7, pa.e r8) {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof n3.b2
            if (r0 == 0) goto L_0x0016
            r0 = r8
            n3.b2 r0 = (n3.b2) r0
            int r1 = r0.f11062l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.f11062l = r1
            goto L_0x001b
        L_0x0016:
            n3.b2 r0 = new n3.b2
            r0.<init>(r6, r8)
        L_0x001b:
            java.lang.Object r8 = r0.f11060j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11062l
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            n3.n4 r7 = r0.f11059i
            n3.i2 r6 = r0.f11058h
            hb.h0.O1(r8)
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            hb.h0.O1(r8)
            r0.f11058h = r6
            r0.f11059i = r7
            r0.f11062l = r3
            wa.l r8 = r6.f11250a
            java.lang.Object r8 = r8.invoke(r0)
            if (r8 != r1) goto L_0x0049
            goto L_0x00c4
        L_0x0049:
            r1 = r8
            n3.n4 r1 = (n3.n4) r1
            r8 = 0
            if (r1 == r7) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x00cf
            n3.w1 r0 = new n3.w1
            r0.<init>(r3, r6)
            r1.getClass()
            androidx.emoji2.text.w r2 = r1.f11359a
            java.lang.Object r4 = r2.f1296c
            wa.a r4 = (wa.a) r4
            if (r4 != 0) goto L_0x0065
            goto L_0x0073
        L_0x0065:
            java.lang.Object r4 = r4.b()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != r3) goto L_0x0073
            r4 = 1
            goto L_0x0074
        L_0x0073:
            r4 = 0
        L_0x0074:
            if (r4 == 0) goto L_0x0079
            r2.c()
        L_0x0079:
            boolean r4 = r2.f1294a
            if (r4 == 0) goto L_0x007e
            goto L_0x0099
        L_0x007e:
            java.lang.Object r4 = r2.f1297d
            java.util.concurrent.locks.ReentrantLock r4 = (java.util.concurrent.locks.ReentrantLock) r4
            r4.lock()
            boolean r5 = r2.f1294a     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x008c
            la.v r8 = la.v.f9814a     // Catch:{ all -> 0x00ca }
            goto L_0x0094
        L_0x008c:
            java.lang.Object r3 = r2.f1298e     // Catch:{ all -> 0x00ca }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x00ca }
            r3.add(r0)     // Catch:{ all -> 0x00ca }
            r3 = 0
        L_0x0094:
            r4.unlock()
            if (r3 == 0) goto L_0x00a0
        L_0x0099:
            java.lang.Object r8 = r2.f1295b
            wa.l r8 = (wa.l) r8
            r8.invoke(r0)
        L_0x00a0:
            if (r7 != 0) goto L_0x00a3
            goto L_0x00bc
        L_0x00a3:
            n3.w1 r8 = new n3.w1
            r0 = 2
            r8.<init>(r0, r6)
            androidx.emoji2.text.w r6 = r7.f11359a
            java.lang.Object r0 = r6.f1297d
            java.util.concurrent.locks.ReentrantLock r0 = (java.util.concurrent.locks.ReentrantLock) r0
            r0.lock()
            java.lang.Object r6 = r6.f1298e     // Catch:{ all -> 0x00c5 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x00c5 }
            r6.remove(r8)     // Catch:{ all -> 0x00c5 }
            r0.unlock()
        L_0x00bc:
            if (r7 != 0) goto L_0x00bf
            goto L_0x00c4
        L_0x00bf:
            androidx.emoji2.text.w r6 = r7.f11359a
            r6.c()
        L_0x00c4:
            return r1
        L_0x00c5:
            r6 = move-exception
            r0.unlock()
            throw r6
        L_0x00ca:
            r6 = move-exception
            r4.unlock()
            throw r6
        L_0x00cf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.i2.a(n3.i2, n3.n4, pa.e):java.lang.Object");
    }
}
