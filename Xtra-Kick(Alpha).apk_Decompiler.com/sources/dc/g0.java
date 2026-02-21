package dc;

import xa.j;

public final class g0 implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final l f4771h;

    /* renamed from: i  reason: collision with root package name */
    public final j f4772i;

    /* renamed from: j  reason: collision with root package name */
    public k0 f4773j;

    /* renamed from: k  reason: collision with root package name */
    public int f4774k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4775l;

    /* renamed from: m  reason: collision with root package name */
    public long f4776m;

    public g0(l lVar) {
        j.f("upstream", lVar);
        this.f4771h = lVar;
        j b10 = lVar.b();
        this.f4772i = b10;
        k0 k0Var = b10.f4786h;
        this.f4773j = k0Var;
        this.f4774k = k0Var != null ? k0Var.f4789b : -1;
    }

    public final void close() {
        this.f4775l = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r4 == r6.f4789b) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(dc.j r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            xa.j.f(r0, r9)
            r0 = 0
            r1 = 0
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x000e
            r4 = 1
            goto L_0x000f
        L_0x000e:
            r4 = 0
        L_0x000f:
            if (r4 == 0) goto L_0x007e
            boolean r4 = r8.f4775l
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0072
            dc.k0 r4 = r8.f4773j
            dc.j r5 = r8.f4772i
            if (r4 == 0) goto L_0x002a
            dc.k0 r6 = r5.f4786h
            if (r4 != r6) goto L_0x002b
            int r4 = r8.f4774k
            xa.j.c(r6)
            int r6 = r6.f4789b
            if (r4 != r6) goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x0066
            if (r3 != 0) goto L_0x0030
            return r1
        L_0x0030:
            long r0 = r8.f4776m
            r2 = 1
            long r0 = r0 + r2
            dc.l r2 = r8.f4771h
            boolean r0 = r2.t(r0)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            dc.k0 r0 = r8.f4773j
            if (r0 != 0) goto L_0x004e
            dc.k0 r0 = r5.f4786h
            if (r0 == 0) goto L_0x004e
            r8.f4773j = r0
            int r0 = r0.f4789b
            r8.f4774k = r0
        L_0x004e:
            long r0 = r5.f4787i
            long r2 = r8.f4776m
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            dc.j r2 = r8.f4772i
            long r3 = r8.f4776m
            r5 = r10
            r7 = r9
            r2.k(r3, r5, r7)
            long r0 = r8.f4776m
            long r0 = r0 + r10
            r8.f4776m = r0
            return r10
        L_0x0066:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0072:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007e:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = android.support.v4.media.h.k(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.g0.read(dc.j, long):long");
    }

    public final s0 timeout() {
        return this.f4771h.timeout();
    }
}
