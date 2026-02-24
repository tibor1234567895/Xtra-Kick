package s5;

import q0.f;

public final class i implements e, d {

    /* renamed from: a  reason: collision with root package name */
    public final e f14355a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f14356b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d f14357c;

    /* renamed from: d  reason: collision with root package name */
    public volatile d f14358d;

    /* renamed from: e  reason: collision with root package name */
    public int f14359e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f14360f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14361g;

    public i(Object obj, e eVar) {
        this.f14356b = obj;
        this.f14355a = eVar;
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f14356b) {
            if (!this.f14358d.a()) {
                if (!this.f14357c.a()) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public final boolean b() {
        boolean z10;
        synchronized (this.f14356b) {
            z10 = this.f14359e == 3;
        }
        return z10;
    }

    public final e c() {
        e c10;
        synchronized (this.f14356b) {
            e eVar = this.f14355a;
            c10 = eVar != null ? eVar.c() : this;
        }
        return c10;
    }

    public final void clear() {
        synchronized (this.f14356b) {
            this.f14361g = false;
            this.f14359e = 3;
            this.f14360f = 3;
            this.f14358d.clear();
            this.f14357c.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(s5.d r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f14356b
            monitor-enter(r0)
            s5.e r1 = r4.f14355a     // Catch:{ all -> 0x0026 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.d(r4)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            if (r1 == 0) goto L_0x0023
            s5.d r1 = r4.f14357c     // Catch:{ all -> 0x0026 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x0026 }
            if (r5 == 0) goto L_0x0023
            int r5 = r4.f14359e     // Catch:{ all -> 0x0026 }
            r1 = 2
            if (r5 == r1) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r2
        L_0x0026:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.i.d(s5.d):boolean");
    }

    public final void e() {
        synchronized (this.f14356b) {
            this.f14361g = true;
            try {
                if (!(this.f14359e == 4 || this.f14360f == 1)) {
                    this.f14360f = 1;
                    this.f14358d.e();
                }
                if (this.f14361g && this.f14359e != 1) {
                    this.f14359e = 1;
                    this.f14357c.e();
                }
            } finally {
                this.f14361g = false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(s5.d r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof s5.i
            r1 = 0
            if (r0 == 0) goto L_0x002e
            s5.i r4 = (s5.i) r4
            s5.d r0 = r3.f14357c
            if (r0 != 0) goto L_0x0010
            s5.d r0 = r4.f14357c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            s5.d r0 = r3.f14357c
            s5.d r2 = r4.f14357c
            boolean r0 = r0.f(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            s5.d r0 = r3.f14358d
            if (r0 != 0) goto L_0x0023
            s5.d r4 = r4.f14358d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            s5.d r0 = r3.f14358d
            s5.d r4 = r4.f14358d
            boolean r4 = r0.f(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.i.f(s5.d):boolean");
    }

    public final void g() {
        synchronized (this.f14356b) {
            if (!f.b(this.f14360f)) {
                this.f14360f = 2;
                this.f14358d.g();
            }
            if (!f.b(this.f14359e)) {
                this.f14359e = 2;
                this.f14357c.g();
            }
        }
    }

    public final boolean h(d dVar) {
        boolean z10;
        boolean z11;
        synchronized (this.f14356b) {
            e eVar = this.f14355a;
            z10 = false;
            if (eVar != null) {
                if (!eVar.h(this)) {
                    z11 = false;
                    if (z11 && dVar.equals(this.f14357c) && !a()) {
                        z10 = true;
                    }
                }
            }
            z11 = true;
            z10 = true;
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(s5.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f14356b
            monitor-enter(r0)
            s5.d r1 = r2.f14358d     // Catch:{ all -> 0x0028 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0028 }
            r1 = 4
            if (r3 == 0) goto L_0x0010
            r2.f14360f = r1     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0010:
            r2.f14359e = r1     // Catch:{ all -> 0x0028 }
            s5.e r3 = r2.f14355a     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x0019
            r3.i(r2)     // Catch:{ all -> 0x0028 }
        L_0x0019:
            int r3 = r2.f14360f     // Catch:{ all -> 0x0028 }
            boolean r3 = q0.f.b(r3)     // Catch:{ all -> 0x0028 }
            if (r3 != 0) goto L_0x0026
            s5.d r3 = r2.f14358d     // Catch:{ all -> 0x0028 }
            r3.clear()     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.i.i(s5.d):void");
    }

    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f14356b) {
            z10 = true;
            if (this.f14359e != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f14356b) {
            z10 = this.f14359e == 4;
        }
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(s5.d r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f14356b
            monitor-enter(r0)
            s5.e r1 = r4.f14355a     // Catch:{ all -> 0x0026 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.k(r4)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            if (r1 == 0) goto L_0x0023
            s5.d r1 = r4.f14357c     // Catch:{ all -> 0x0026 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0024
            int r5 = r4.f14359e     // Catch:{ all -> 0x0026 }
            r1 = 4
            if (r5 == r1) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r2
        L_0x0026:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.i.k(s5.d):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(s5.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f14356b
            monitor-enter(r0)
            s5.d r1 = r2.f14357c     // Catch:{ all -> 0x001b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001b }
            r1 = 5
            if (r3 != 0) goto L_0x0010
            r2.f14360f = r1     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0010:
            r2.f14359e = r1     // Catch:{ all -> 0x001b }
            s5.e r3 = r2.f14355a     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0019
            r3.l(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.i.l(s5.d):void");
    }
}
