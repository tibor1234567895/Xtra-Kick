package j4;

import dc.f0;
import dc.i0;
import dc.l;
import dc.r;
import dc.z;
import w4.e;
import wa.a;
import xa.j;

public final class h0 extends e0 {

    /* renamed from: h  reason: collision with root package name */
    public final d0 f8758h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8759i;

    /* renamed from: j  reason: collision with root package name */
    public l f8760j;

    /* renamed from: k  reason: collision with root package name */
    public a f8761k;

    /* renamed from: l  reason: collision with root package name */
    public f0 f8762l;

    public h0(l lVar, f0 f0Var, d0 d0Var) {
        super(0);
        this.f8758h = d0Var;
        this.f8760j = lVar;
        this.f8761k = f0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x0046, all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[SYNTHETIC, Splitter:B:27:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized dc.f0 c() {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.w()     // Catch:{ all -> 0x006b }
            dc.f0 r0 = r6.f8762l     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r6)
            return r0
        L_0x000a:
            wa.a r0 = r6.f8761k     // Catch:{ all -> 0x006b }
            xa.j.c(r0)     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.b()     // Catch:{ all -> 0x006b }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x006b }
            boolean r1 = r0.isDirectory()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x005f
            dc.e0 r1 = dc.f0.f4761i     // Catch:{ all -> 0x006b }
            java.lang.String r2 = "tmp"
            r3 = 0
            java.io.File r0 = java.io.File.createTempFile(r2, r3, r0)     // Catch:{ all -> 0x006b }
            dc.f0 r0 = dc.e0.b(r1, r0)     // Catch:{ all -> 0x006b }
            dc.z r1 = dc.r.f4819a     // Catch:{ all -> 0x006b }
            dc.n0 r1 = r1.k(r0)     // Catch:{ all -> 0x006b }
            dc.h0 r1 = hb.h0.n(r1)     // Catch:{ all -> 0x006b }
            dc.l r2 = r6.f8760j     // Catch:{ all -> 0x0046 }
            xa.j.c(r2)     // Catch:{ all -> 0x0046 }
            long r4 = r1.F0(r2)     // Catch:{ all -> 0x0046 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0046 }
            r1.close()     // Catch:{ all -> 0x0044 }
            r1 = r3
            goto L_0x0051
        L_0x0044:
            r1 = move-exception
            goto L_0x0051
        L_0x0046:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r1 = move-exception
            la.a.a(r2, r1)     // Catch:{ all -> 0x006b }
        L_0x004f:
            r1 = r2
            r2 = r3
        L_0x0051:
            if (r1 != 0) goto L_0x005e
            xa.j.c(r2)     // Catch:{ all -> 0x006b }
            r6.f8760j = r3     // Catch:{ all -> 0x006b }
            r6.f8762l = r0     // Catch:{ all -> 0x006b }
            r6.f8761k = r3     // Catch:{ all -> 0x006b }
            monitor-exit(r6)
            return r0
        L_0x005e:
            throw r1     // Catch:{ all -> 0x006b }
        L_0x005f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006b }
            java.lang.String r1 = "cacheDirectory must be a directory."
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006b }
            r0.<init>(r1)     // Catch:{ all -> 0x006b }
            throw r0     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.h0.c():dc.f0");
    }

    public final synchronized void close() {
        this.f8759i = true;
        l lVar = this.f8760j;
        if (lVar != null) {
            e.a(lVar);
        }
        f0 f0Var = this.f8762l;
        if (f0Var != null) {
            r.f4819a.e(f0Var);
        }
    }

    public final synchronized f0 e() {
        w();
        return this.f8762l;
    }

    public final d0 k() {
        return this.f8758h;
    }

    public final synchronized l v() {
        w();
        l lVar = this.f8760j;
        if (lVar != null) {
            return lVar;
        }
        z zVar = r.f4819a;
        f0 f0Var = this.f8762l;
        j.c(f0Var);
        i0 o10 = hb.h0.o(zVar.l(f0Var));
        this.f8760j = o10;
        return o10;
    }

    public final void w() {
        if (!(!this.f8759i)) {
            throw new IllegalStateException("closed".toString());
        }
    }
}
