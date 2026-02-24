package v1;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15592h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f15593i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f15594j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f15595k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f15596l;

    public /* synthetic */ c0(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f15592h = i10;
        this.f15593i = obj;
        this.f15594j = obj2;
        this.f15595k = obj3;
        this.f15596l = obj4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee A[SYNTHETIC, Splitter:B:33:0x00ee] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r18 = this;
            r1 = r18
            int r0 = r1.f15592h
            r2 = 0
            r3 = 1
            switch(r0) {
                case 0: goto L_0x017e;
                case 1: goto L_0x0159;
                case 2: goto L_0x0118;
                case 3: goto L_0x00f2;
                case 4: goto L_0x0034;
                case 5: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0194
        L_0x000b:
            java.lang.Object r0 = r1.f15593i
            h3.n2 r0 = (h3.n2) r0
            java.lang.Object r2 = r1.f15594j
            h9.k0 r2 = (h9.k0) r2
            java.lang.Object r3 = r1.f15595k
            j1.h r3 = (j1.h) r3
            java.lang.Object r4 = r1.f15596l
            h9.e0 r4 = (h9.e0) r4
            int r5 = h3.s3.f7316j
            boolean r0 = r0.f()
            r5 = 0
            if (r0 == 0) goto L_0x0028
            r2.l(r5)
            goto L_0x0033
        L_0x0028:
            r3.b(r4)     // Catch:{ all -> 0x002f }
            r2.l(r5)     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r2.m(r0)
        L_0x0033:
            return
        L_0x0034:
            java.lang.Object r0 = r1.f15593i
            r7 = r0
            h3.s3 r7 = (h3.s3) r7
            java.lang.Object r0 = r1.f15594j
            h3.e2 r0 = (h3.e2) r0
            java.lang.Object r4 = r1.f15595k
            r14 = r4
            h3.n2 r14 = (h3.n2) r14
            java.lang.Object r4 = r1.f15596l
            r15 = r4
            h3.o r15 = (h3.o) r15
            h3.g r4 = r7.f7319f
            java.lang.String r5 = "Controller "
            java.util.Set r6 = r7.f7320g     // Catch:{ all -> 0x00ea }
            r6.remove(r0)     // Catch:{ all -> 0x00ea }
            boolean r6 = r14.f()     // Catch:{ all -> 0x00ea }
            if (r6 == 0) goto L_0x0058
            goto L_0x00e4
        L_0x0058:
            h3.d2 r6 = r0.f6998c     // Catch:{ all -> 0x00ea }
            h3.n3 r6 = (h3.n3) r6     // Catch:{ all -> 0x00ea }
            j1.a.f(r6)     // Catch:{ all -> 0x00ea }
            h3.o r6 = r6.f7250a     // Catch:{ all -> 0x00ea }
            android.os.IBinder r6 = r6.asBinder()     // Catch:{ all -> 0x00ea }
            h3.b2 r8 = r14.f7231d     // Catch:{ all -> 0x00ea }
            h3.g2 r9 = r14.f7237j     // Catch:{ all -> 0x00ea }
            h3.c2 r8 = r8.c(r9, r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = "onConnect must return non-null future"
            j1.a.d(r8, r9)     // Catch:{ all -> 0x00ea }
            boolean r9 = r4.g(r0)     // Catch:{ all -> 0x00ea }
            if (r9 == 0) goto L_0x008e
            java.lang.String r9 = "MediaSessionStub"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r10.<init>(r5)     // Catch:{ all -> 0x00ea }
            r10.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = " has sent connection request multiple times"
            r10.append(r5)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x00ea }
            j1.v.g(r9, r5)     // Catch:{ all -> 0x00ea }
        L_0x008e:
            h3.h4 r5 = r8.f6955a     // Catch:{ all -> 0x00ea }
            g1.g1 r9 = r8.f6956b     // Catch:{ all -> 0x00ea }
            r4.a(r6, r0, r5, r9)     // Catch:{ all -> 0x00ea }
            h3.e4 r0 = r4.f(r0)     // Catch:{ all -> 0x00ea }
            j1.a.f(r0)     // Catch:{ all -> 0x00ea }
            h3.a4 r4 = r14.f7246s     // Catch:{ all -> 0x00ea }
            h3.w3 r5 = r4.Q0()     // Catch:{ all -> 0x00ea }
            h3.w3 r13 = r7.D0(r5)     // Catch:{ all -> 0x00ea }
            h3.i r16 = new h3.i     // Catch:{ all -> 0x00ea }
            r5 = 1000002300(0x3b9ad2fc, float:0.0047248583)
            r6 = 1
            android.app.PendingIntent r9 = r14.f7238k     // Catch:{ all -> 0x00ea }
            h3.h4 r10 = r8.f6955a     // Catch:{ all -> 0x00ea }
            g1.g1 r11 = r8.f6956b     // Catch:{ all -> 0x00ea }
            g1.g1 r12 = r4.w()     // Catch:{ all -> 0x00ea }
            h3.l4 r4 = r14.f7236i     // Catch:{ all -> 0x00ea }
            h3.k4 r4 = r4.f7191h     // Catch:{ all -> 0x00ea }
            android.os.Bundle r17 = r4.f()     // Catch:{ all -> 0x00ea }
            r4 = r16
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ea }
            boolean r4 = r14.f()     // Catch:{ all -> 0x00ea }
            if (r4 == 0) goto L_0x00d0
            goto L_0x00e4
        L_0x00d0:
            int r0 = r0.a()     // Catch:{ RemoteException -> 0x00dc }
            android.os.Bundle r4 = r16.h()     // Catch:{ RemoteException -> 0x00dc }
            r15.Q(r0, r4)     // Catch:{ RemoteException -> 0x00dc }
            goto L_0x00dd
        L_0x00dc:
            r3 = 0
        L_0x00dd:
            h3.b2 r0 = r14.f7231d     // Catch:{ all -> 0x00e8 }
            r0.a()     // Catch:{ all -> 0x00e8 }
            if (r3 != 0) goto L_0x00e7
        L_0x00e4:
            r15.g(r2)     // Catch:{ RemoteException -> 0x00e7 }
        L_0x00e7:
            return
        L_0x00e8:
            r0 = move-exception
            goto L_0x00ec
        L_0x00ea:
            r0 = move-exception
            r3 = 0
        L_0x00ec:
            if (r3 != 0) goto L_0x00f1
            r15.g(r2)     // Catch:{ RemoteException -> 0x00f1 }
        L_0x00f1:
            throw r0
        L_0x00f2:
            java.lang.Object r0 = r1.f15593i
            h3.c3 r0 = (h3.c3) r0
            java.lang.Object r2 = r1.f15594j
            java.util.concurrent.atomic.AtomicReference r2 = (java.util.concurrent.atomic.AtomicReference) r2
            java.lang.Object r3 = r1.f15595k
            h3.e2 r3 = (h3.e2) r3
            java.lang.Object r4 = r1.f15596l
            j1.g r4 = (j1.g) r4
            h3.n2 r0 = r0.f6958q
            h3.b2 r5 = r0.f7231d
            h3.g2 r0 = r0.f7237j
            h3.c2 r0 = r5.c(r0, r3)
            java.lang.String r3 = "onConnect must return non-null future"
            j1.a.d(r0, r3)
            r2.set(r0)
            r4.b()
            return
        L_0x0118:
            java.lang.Object r0 = r1.f15593i
            h3.y1 r0 = (h3.y1) r0
            java.lang.Object r4 = r1.f15594j
            h9.e0 r4 = (h9.e0) r4
            java.lang.Object r5 = r1.f15595k
            h3.x1 r5 = (h3.x1) r5
            java.lang.Object r6 = r1.f15596l
            h3.g2 r6 = (h3.g2) r6
            r0.getClass()
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            r8 = 0
            java.lang.Object r4 = r4.get(r8, r7)     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            h3.b0 r4 = (h3.b0) r4     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            h3.b0 r7 = r0.a(r6)     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            if (r7 == 0) goto L_0x014c
            g1.u1 r8 = r7.j0()     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            boolean r8 = r8.y()     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            if (r8 != 0) goto L_0x014c
            int r7 = r7.b()     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            if (r7 == r3) goto L_0x014c
            r2 = 1
        L_0x014c:
            r5.C(r2)     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            r4.x0(r5)     // Catch:{ InterruptedException | CancellationException | ExecutionException | TimeoutException -> 0x0153 }
            goto L_0x0158
        L_0x0153:
            h3.b3 r0 = r0.f7479a
            r0.h(r6)
        L_0x0158:
            return
        L_0x0159:
            java.lang.Object r0 = r1.f15593i
            h3.g r0 = (h3.g) r0
            java.lang.Object r2 = r1.f15594j
            java.util.concurrent.atomic.AtomicBoolean r2 = (java.util.concurrent.atomic.AtomicBoolean) r2
            java.lang.Object r4 = r1.f15595k
            h3.f r4 = (h3.f) r4
            java.lang.Object r5 = r1.f15596l
            java.util.concurrent.atomic.AtomicBoolean r5 = (java.util.concurrent.atomic.AtomicBoolean) r5
            java.lang.Object r6 = r0.f7037a
            monitor-enter(r6)
            boolean r2 = r2.get()     // Catch:{ all -> 0x017b }
            if (r2 != 0) goto L_0x0176
            r0.b(r4)     // Catch:{ all -> 0x017b }
            goto L_0x0179
        L_0x0176:
            r5.set(r3)     // Catch:{ all -> 0x017b }
        L_0x0179:
            monitor-exit(r6)     // Catch:{ all -> 0x017b }
            return
        L_0x017b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x017b }
            throw r0
        L_0x017e:
            java.lang.Object r0 = r1.f15593i
            v1.f0 r0 = (v1.f0) r0
            java.lang.Object r2 = r1.f15594j
            v1.g0 r2 = (v1.g0) r2
            java.lang.Object r3 = r1.f15595k
            v1.a0 r3 = (v1.a0) r3
            java.lang.Object r4 = r1.f15596l
            v1.w r4 = (v1.w) r4
            int r0 = r0.f15618a
            r2.o(r0, r3, r4)
            return
        L_0x0194:
            java.lang.Object r0 = r1.f15593i
            h3.n2 r0 = (h3.n2) r0
            java.lang.Object r2 = r1.f15594j
            h3.p3 r2 = (h3.p3) r2
            java.lang.Object r3 = r1.f15595k
            h3.e2 r3 = (h3.e2) r3
            java.lang.Object r4 = r1.f15596l
            java.util.List r4 = (java.util.List) r4
            int r5 = h3.s3.f7316j
            boolean r5 = r0.f()
            if (r5 != 0) goto L_0x01b1
            h3.a4 r0 = r0.f7246s
            r2.a(r0, r3, r4)
        L_0x01b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.c0.run():void");
    }
}
