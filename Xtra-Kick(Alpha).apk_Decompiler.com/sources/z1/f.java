package z1;

import c9.r;

public final /* synthetic */ class f implements r {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q f17397h;

    public /* synthetic */ f(q qVar) {
        this.f17397h = qVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006c, code lost:
        if (r2.f12464i != false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062 A[SYNTHETIC, Splitter:B:35:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean apply(java.lang.Object r9) {
        /*
            r8 = this;
            z1.q r0 = r8.f17397h
            g1.a0 r9 = (g1.a0) r9
            java.lang.Object r1 = r0.f17469c
            monitor-enter(r1)
            z1.j r2 = r0.f17473g     // Catch:{ all -> 0x009e }
            boolean r2 = r2.f17427r0     // Catch:{ all -> 0x009e }
            r3 = 1
            if (r2 == 0) goto L_0x009c
            boolean r2 = r0.f17472f     // Catch:{ all -> 0x009e }
            if (r2 != 0) goto L_0x009c
            int r2 = r9.F     // Catch:{ all -> 0x009e }
            r4 = 2
            if (r2 <= r4) goto L_0x009c
            java.lang.String r2 = r9.f6276s     // Catch:{ all -> 0x009e }
            r5 = 0
            if (r2 != 0) goto L_0x001d
            goto L_0x005b
        L_0x001d:
            int r6 = r2.hashCode()
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0047;
                case 187078296: goto L_0x003c;
                case 187078297: goto L_0x0031;
                case 1504578661: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0052
        L_0x0026:
            java.lang.String r6 = "audio/eac3"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x002f
            goto L_0x0052
        L_0x002f:
            r2 = 3
            goto L_0x0053
        L_0x0031:
            java.lang.String r6 = "audio/ac4"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x003a
            goto L_0x0052
        L_0x003a:
            r2 = 2
            goto L_0x0053
        L_0x003c:
            java.lang.String r6 = "audio/ac3"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0045
            goto L_0x0052
        L_0x0045:
            r2 = 1
            goto L_0x0053
        L_0x0047:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = 0
            goto L_0x0053
        L_0x0052:
            r2 = -1
        L_0x0053:
            if (r2 == 0) goto L_0x005d
            if (r2 == r3) goto L_0x005d
            if (r2 == r4) goto L_0x005d
            if (r2 == r7) goto L_0x005d
        L_0x005b:
            r2 = 0
            goto L_0x005e
        L_0x005d:
            r2 = 1
        L_0x005e:
            r4 = 32
            if (r2 == 0) goto L_0x006e
            int r2 = j1.l0.f8453a     // Catch:{ all -> 0x009e }
            if (r2 < r4) goto L_0x009c
            p1.i0 r2 = r0.f17474h     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009c
            boolean r2 = r2.f12464i     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009c
        L_0x006e:
            int r2 = j1.l0.f8453a     // Catch:{ all -> 0x009e }
            if (r2 < r4) goto L_0x009b
            p1.i0 r2 = r0.f17474h     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009b
            boolean r4 = r2.f12464i     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x009b
            java.lang.Object r2 = r2.f12465j     // Catch:{ all -> 0x009e }
            android.media.Spatializer r2 = (android.media.Spatializer) r2     // Catch:{ all -> 0x009e }
            boolean r2 = r2.isAvailable()     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009b
            p1.i0 r2 = r0.f17474h     // Catch:{ all -> 0x009e }
            java.lang.Object r2 = r2.f12465j     // Catch:{ all -> 0x009e }
            android.media.Spatializer r2 = (android.media.Spatializer) r2     // Catch:{ all -> 0x009e }
            boolean r2 = r2.isEnabled()     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009b
            p1.i0 r2 = r0.f17474h     // Catch:{ all -> 0x009e }
            g1.h r0 = r0.f17475i     // Catch:{ all -> 0x009e }
            boolean r9 = r2.d(r0, r9)     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r3 = 0
        L_0x009c:
            monitor-exit(r1)     // Catch:{ all -> 0x009e }
            return r3
        L_0x009e:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x009e }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.f.apply(java.lang.Object):boolean");
    }
}
