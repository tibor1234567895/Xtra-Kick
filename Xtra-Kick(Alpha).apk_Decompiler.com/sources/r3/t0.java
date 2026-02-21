package r3;

public final /* synthetic */ class t0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13749h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ u0 f13750i;

    public /* synthetic */ t0(u0 u0Var, int i10) {
        this.f13749h = i10;
        this.f13750i = u0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            r0 = 0
            int r1 = r9.f13749h
            r3.u0 r2 = r9.f13750i
            java.lang.String r3 = "this$0"
            r4 = 1
            r5 = 0
            switch(r1) {
                case 0: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0069
        L_0x000d:
            xa.j.f(r3, r2)
            java.util.concurrent.atomic.AtomicBoolean r1 = r2.f13762s
            boolean r1 = r1.compareAndSet(r5, r4)
            if (r1 == 0) goto L_0x002e
            r3.n0 r1 = r2.f13755l
            r3.y r1 = r1.f13722e
            r1.getClass()
            java.lang.String r3 = "observer"
            r3.a0 r6 = r2.f13759p
            xa.j.f(r3, r6)
            r3.x r3 = new r3.x
            r3.<init>(r1, r6)
            r1.a(r3)
        L_0x002e:
            java.util.concurrent.atomic.AtomicBoolean r1 = r2.f13761r
            boolean r3 = r1.compareAndSet(r5, r4)
            java.util.concurrent.atomic.AtomicBoolean r6 = r2.f13760q
            if (r3 == 0) goto L_0x005f
            r7 = r0
            r3 = 0
        L_0x003a:
            boolean r8 = r6.compareAndSet(r4, r5)     // Catch:{ all -> 0x005a }
            if (r8 == 0) goto L_0x0051
            java.util.concurrent.Callable r3 = r2.f13758o     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r7 = r3.call()     // Catch:{ Exception -> 0x0048 }
            r3 = 1
            goto L_0x003a
        L_0x0048:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x005a }
            java.lang.String r3 = "Exception while computing database live data."
            r2.<init>(r3, r0)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0051:
            if (r3 == 0) goto L_0x0056
            r2.j(r7)     // Catch:{ all -> 0x005a }
        L_0x0056:
            r1.set(r5)
            goto L_0x0060
        L_0x005a:
            r0 = move-exception
            r1.set(r5)
            throw r0
        L_0x005f:
            r3 = 0
        L_0x0060:
            if (r3 == 0) goto L_0x0068
            boolean r1 = r6.get()
            if (r1 != 0) goto L_0x002e
        L_0x0068:
            return
        L_0x0069:
            xa.j.f(r3, r2)
            int r1 = r2.f1721c
            if (r1 <= 0) goto L_0x0072
            r1 = 1
            goto L_0x0073
        L_0x0072:
            r1 = 0
        L_0x0073:
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.f13760q
            boolean r3 = r3.compareAndSet(r5, r4)
            if (r3 == 0) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            boolean r1 = r2.f13757n
            r3.n0 r3 = r2.f13755l
            if (r1 == 0) goto L_0x008e
            g.s0 r1 = r3.f13720c
            if (r1 == 0) goto L_0x0088
            goto L_0x0092
        L_0x0088:
            java.lang.String r1 = "internalTransactionExecutor"
            xa.j.l(r1)
            throw r0
        L_0x008e:
            java.util.concurrent.Executor r1 = r3.f13719b
            if (r1 == 0) goto L_0x0098
        L_0x0092:
            r3.t0 r0 = r2.f13763t
            r1.execute(r0)
            goto L_0x009e
        L_0x0098:
            java.lang.String r1 = "internalQueryExecutor"
            xa.j.l(r1)
            throw r0
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.t0.run():void");
    }
}
