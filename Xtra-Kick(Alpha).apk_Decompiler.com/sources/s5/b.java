package s5;

public final class b implements e, d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f14323a;

    /* renamed from: b  reason: collision with root package name */
    public final e f14324b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d f14325c;

    /* renamed from: d  reason: collision with root package name */
    public volatile d f14326d;

    /* renamed from: e  reason: collision with root package name */
    public int f14327e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f14328f = 3;

    public b(Object obj, e eVar) {
        this.f14323a = obj;
        this.f14324b = eVar;
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f14323a) {
            if (!this.f14325c.a()) {
                if (!this.f14326d.a()) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public final boolean b() {
        boolean z10;
        synchronized (this.f14323a) {
            z10 = this.f14327e == 3 && this.f14328f == 3;
        }
        return z10;
    }

    public final e c() {
        e c10;
        synchronized (this.f14323a) {
            e eVar = this.f14324b;
            c10 = eVar != null ? eVar.c() : this;
        }
        return c10;
    }

    public final void clear() {
        synchronized (this.f14323a) {
            this.f14327e = 3;
            this.f14325c.clear();
            if (this.f14328f != 3) {
                this.f14328f = 3;
                this.f14326d.clear();
            }
        }
    }

    public final boolean d(d dVar) {
        boolean z10;
        boolean z11;
        synchronized (this.f14323a) {
            e eVar = this.f14324b;
            z10 = false;
            if (eVar != null) {
                if (!eVar.d(this)) {
                    z11 = false;
                    if (z11 && dVar.equals(this.f14325c)) {
                        z10 = true;
                    }
                }
            }
            z11 = true;
            z10 = true;
        }
        return z10;
    }

    public final void e() {
        synchronized (this.f14323a) {
            if (this.f14327e != 1) {
                this.f14327e = 1;
                this.f14325c.e();
            }
        }
    }

    public final boolean f(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f14325c.f(bVar.f14325c) && this.f14326d.f(bVar.f14326d);
    }

    public final void g() {
        synchronized (this.f14323a) {
            if (this.f14327e == 1) {
                this.f14327e = 2;
                this.f14325c.g();
            }
            if (this.f14328f == 1) {
                this.f14328f = 2;
                this.f14326d.g();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(s5.d r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f14323a
            monitor-enter(r0)
            s5.e r1 = r5.f14324b     // Catch:{ all -> 0x0039 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.h(r5)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            if (r1 == 0) goto L_0x0036
            int r1 = r5.f14327e     // Catch:{ all -> 0x0039 }
            r4 = 5
            if (r1 == r4) goto L_0x0021
            s5.d r1 = r5.f14325c     // Catch:{ all -> 0x0039 }
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0033
        L_0x0021:
            s5.d r1 = r5.f14326d     // Catch:{ all -> 0x0039 }
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0039 }
            if (r6 == 0) goto L_0x0032
            int r6 = r5.f14328f     // Catch:{ all -> 0x0039 }
            r1 = 4
            if (r6 == r1) goto L_0x0030
            if (r6 != r4) goto L_0x0032
        L_0x0030:
            r6 = 1
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            if (r6 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0039:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.b.h(s5.d):boolean");
    }

    public final void i(d dVar) {
        synchronized (this.f14323a) {
            if (dVar.equals(this.f14325c)) {
                this.f14327e = 4;
            } else if (dVar.equals(this.f14326d)) {
                this.f14328f = 4;
            }
            e eVar = this.f14324b;
            if (eVar != null) {
                eVar.i(this);
            }
        }
    }

    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f14323a) {
            z10 = true;
            if (this.f14327e != 1) {
                if (this.f14328f != 1) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f14323a) {
            if (this.f14327e != 4) {
                if (this.f14328f != 4) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public final boolean k(d dVar) {
        boolean z10;
        synchronized (this.f14323a) {
            e eVar = this.f14324b;
            if (eVar != null) {
                if (!eVar.k(this)) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(s5.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f14323a
            monitor-enter(r0)
            s5.d r1 = r2.f14326d     // Catch:{ all -> 0x0027 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0027 }
            r1 = 5
            if (r3 != 0) goto L_0x001c
            r2.f14327e = r1     // Catch:{ all -> 0x0027 }
            int r3 = r2.f14328f     // Catch:{ all -> 0x0027 }
            r1 = 1
            if (r3 == r1) goto L_0x001a
            r2.f14328f = r1     // Catch:{ all -> 0x0027 }
            s5.d r3 = r2.f14326d     // Catch:{ all -> 0x0027 }
            r3.e()     // Catch:{ all -> 0x0027 }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x001c:
            r2.f14328f = r1     // Catch:{ all -> 0x0027 }
            s5.e r3 = r2.f14324b     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0025
            r3.l(r2)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.b.l(s5.d):void");
    }
}
