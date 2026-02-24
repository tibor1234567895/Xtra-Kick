package s1;

import l1.h;

public final class g extends h {

    /* renamed from: p  reason: collision with root package name */
    public long f14016p;

    /* renamed from: q  reason: collision with root package name */
    public int f14017q;

    /* renamed from: r  reason: collision with root package name */
    public int f14018r = 32;

    public g() {
        super(2);
    }

    public final void h() {
        super.h();
        this.f14017q = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if ((r0.remaining() + r3.position()) > 3072000) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(l1.h r5) {
        /*
            r4 = this;
            r0 = 1073741824(0x40000000, float:2.0)
            boolean r0 = r5.f(r0)
            r1 = 1
            r0 = r0 ^ r1
            j1.a.b(r0)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            boolean r0 = r5.f(r0)
            r0 = r0 ^ r1
            j1.a.b(r0)
            r0 = 4
            boolean r0 = r5.f(r0)
            r0 = r0 ^ r1
            j1.a.b(r0)
            int r0 = r4.f14017q
            r2 = 0
            if (r0 <= 0) goto L_0x0025
            r3 = 1
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 != 0) goto L_0x0029
            goto L_0x0051
        L_0x0029:
            int r3 = r4.f14018r
            if (r0 < r3) goto L_0x002e
            goto L_0x004f
        L_0x002e:
            boolean r0 = r5.g()
            boolean r3 = r4.g()
            if (r0 == r3) goto L_0x0039
            goto L_0x004f
        L_0x0039:
            java.nio.ByteBuffer r0 = r5.f9515j
            if (r0 == 0) goto L_0x0051
            java.nio.ByteBuffer r3 = r4.f9515j
            if (r3 == 0) goto L_0x0051
            int r3 = r3.position()
            int r0 = r0.remaining()
            int r0 = r0 + r3
            r3 = 3072000(0x2ee000, float:4.304789E-39)
            if (r0 <= r3) goto L_0x0051
        L_0x004f:
            r0 = 0
            goto L_0x0052
        L_0x0051:
            r0 = 1
        L_0x0052:
            if (r0 != 0) goto L_0x0055
            return r2
        L_0x0055:
            int r0 = r4.f14017q
            int r2 = r0 + 1
            r4.f14017q = r2
            if (r0 != 0) goto L_0x0069
            long r2 = r5.f9517l
            r4.f9517l = r2
            boolean r0 = r5.f(r1)
            if (r0 == 0) goto L_0x0069
            r4.f9501h = r1
        L_0x0069:
            boolean r0 = r5.g()
            if (r0 == 0) goto L_0x0073
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r4.f9501h = r0
        L_0x0073:
            java.nio.ByteBuffer r0 = r5.f9515j
            if (r0 == 0) goto L_0x0083
            int r2 = r0.remaining()
            r4.j(r2)
            java.nio.ByteBuffer r2 = r4.f9515j
            r2.put(r0)
        L_0x0083:
            long r2 = r5.f9517l
            r4.f14016p = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.g.l(l1.h):boolean");
    }
}
