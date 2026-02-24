package h3;

public final /* synthetic */ class h2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7070h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n2 f7071i;

    public /* synthetic */ h2(n2 n2Var, int i10) {
        this.f7070h = i10;
        this.f7071i = n2Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r2 = r0.f7246s.S0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r0.f7230c.hasMessages(1) != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (h3.t3.a(r2, r0.f7245r.f7414j) == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r3 = r0.f7233f.f7319f;
        r5 = r3.d();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r6 >= r5.size()) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r7 = (h3.e2) r5.get(r6);
        r0.c(r7, new h3.i2(r2, r3.h(16, r7), r3.h(17, r7)));
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.f7234g.f7439i.x(0, r2, true, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        j1.v.d("MSImplBase", "Exception in using media1 API", r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f7070h
            r1 = 0
            switch(r0) {
                case 0: goto L_0x001a;
                case 1: goto L_0x0014;
                case 2: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0082
        L_0x0008:
            h3.n2 r0 = r11.f7071i
            h3.l2 r1 = r0.f7243p
            if (r1 == 0) goto L_0x0013
            h3.a4 r0 = r0.f7246s
            r0.z0(r1)
        L_0x0013:
            return
        L_0x0014:
            h3.n2 r0 = r11.f7071i
            r0.k()
            return
        L_0x001a:
            h3.n2 r0 = r11.f7071i
            java.lang.Object r2 = r0.f7228a
            monitor-enter(r2)
            boolean r3 = r0.f7248u     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x0025
            monitor-exit(r2)     // Catch:{ all -> 0x007f }
            goto L_0x007e
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x007f }
            h3.a4 r2 = r0.f7246s
            h3.i4 r2 = r2.S0()
            h3.j2 r3 = r0.f7230c
            r4 = 1
            boolean r3 = r3.hasMessages(r4)
            if (r3 != 0) goto L_0x007b
            h3.w3 r3 = r0.f7245r
            h3.i4 r3 = r3.f7414j
            boolean r3 = h3.t3.a(r2, r3)
            if (r3 == 0) goto L_0x007b
            h3.s3 r3 = r0.f7233f
            h3.g r3 = r3.f7319f
            d9.r0 r5 = r3.d()
            r6 = 0
        L_0x0048:
            int r7 = r5.size()
            if (r6 >= r7) goto L_0x006b
            java.lang.Object r7 = r5.get(r6)
            h3.e2 r7 = (h3.e2) r7
            r8 = 16
            boolean r8 = r3.h(r8, r7)
            r9 = 17
            boolean r9 = r3.h(r9, r7)
            h3.i2 r10 = new h3.i2
            r10.<init>(r2, r8, r9)
            r0.c(r7, r10)
            int r6 = r6 + 1
            goto L_0x0048
        L_0x006b:
            h3.x2 r3 = r0.f7234g     // Catch:{ RemoteException -> 0x0073 }
            h3.v2 r3 = r3.f7439i     // Catch:{ RemoteException -> 0x0073 }
            r3.x(r1, r2, r4, r4)     // Catch:{ RemoteException -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r1 = move-exception
            java.lang.String r2 = "MSImplBase"
            java.lang.String r3 = "Exception in using media1 API"
            j1.v.d(r2, r3, r1)
        L_0x007b:
            r0.k()
        L_0x007e:
            return
        L_0x007f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x007f }
            throw r0
        L_0x0082:
            h3.n2 r0 = r11.f7071i
            e.a r2 = r0.f7244q
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r2.f4852i
            h3.b3 r2 = (h3.b3) r2
            h3.g2 r0 = r0.f7237j
            r2.g(r0, r1)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.h2.run():void");
    }
}
