package v2;

import d2.u0;
import j1.a;
import j1.l0;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public final g f15838a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15839b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15840c;

    /* renamed from: d  reason: collision with root package name */
    public final l f15841d;

    /* renamed from: e  reason: collision with root package name */
    public int f15842e;

    /* renamed from: f  reason: collision with root package name */
    public long f15843f;

    /* renamed from: g  reason: collision with root package name */
    public long f15844g;

    /* renamed from: h  reason: collision with root package name */
    public long f15845h;

    /* renamed from: i  reason: collision with root package name */
    public long f15846i;

    /* renamed from: j  reason: collision with root package name */
    public long f15847j;

    /* renamed from: k  reason: collision with root package name */
    public long f15848k;

    /* renamed from: l  reason: collision with root package name */
    public long f15849l;

    public b(l lVar, long j10, long j11, long j12, long j13, boolean z10) {
        a.b(j10 >= 0 && j11 > j10);
        this.f15841d = lVar;
        this.f15839b = j10;
        this.f15840c = j11;
        if (j12 == j11 - j10 || z10) {
            this.f15843f = j13;
            this.f15842e = 4;
        } else {
            this.f15842e = 0;
        }
        this.f15838a = new g();
    }

    public final u0 a() {
        if (this.f15843f != 0) {
            return new a(this);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long b(d2.w r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            int r2 = r0.f15842e
            r3 = 0
            long r5 = r0.f15840c
            r7 = 0
            v2.g r8 = r0.f15838a
            r9 = 1
            r10 = 4
            r11 = -1
            if (r2 == 0) goto L_0x0108
            if (r2 == r9) goto L_0x0106
            r5 = 2
            r6 = 3
            if (r2 == r5) goto L_0x0029
            if (r2 == r6) goto L_0x0024
            if (r2 != r10) goto L_0x001e
            return r11
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0024:
            r23 = r8
            r2 = r11
            goto L_0x00d1
        L_0x0029:
            long r13 = r0.f15846i
            long r10 = r0.f15847j
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x0032
            goto L_0x006e
        L_0x0032:
            long r9 = r25.p()
            long r11 = r0.f15847j
            boolean r5 = r8.b(r1, r11)
            if (r5 != 0) goto L_0x0053
            long r3 = r0.f15846i
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x004b
            r15 = r3
            r23 = r8
        L_0x0047:
            r2 = -1
            goto L_0x00ca
        L_0x004b:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0053:
            r8.a(r1, r7)
            r25.f()
            long r11 = r0.f15845h
            long r13 = r8.f15865b
            long r11 = r11 - r13
            int r5 = r8.f15867d
            int r2 = r8.f15868e
            int r5 = r5 + r2
            int r2 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0075
            r17 = 72000(0x11940, double:3.55727E-319)
            int r2 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x0075
        L_0x006e:
            r23 = r8
            r2 = -1
            r15 = -1
            goto L_0x00ca
        L_0x0075:
            int r2 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x007e
            r0.f15847j = r9
            r0.f15849l = r13
            goto L_0x008a
        L_0x007e:
            long r3 = r25.p()
            long r9 = (long) r5
            long r3 = r3 + r9
            r0.f15846i = r3
            long r3 = r8.f15865b
            r0.f15848k = r3
        L_0x008a:
            long r3 = r0.f15847j
            long r9 = r0.f15846i
            long r3 = r3 - r9
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r17 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r17 >= 0) goto L_0x009c
            r0.f15847j = r9
            r23 = r8
            r15 = r9
            goto L_0x0047
        L_0x009c:
            long r3 = (long) r5
            r9 = 1
            if (r2 > 0) goto L_0x00a4
            r13 = 2
            goto L_0x00a5
        L_0x00a4:
            r13 = r9
        L_0x00a5:
            long r3 = r3 * r13
            long r13 = r25.p()
            long r13 = r13 - r3
            long r2 = r0.f15847j
            long r4 = r0.f15846i
            long r17 = r2 - r4
            long r17 = r17 * r11
            long r11 = r0.f15849l
            r23 = r8
            long r7 = r0.f15848k
            long r11 = r11 - r7
            long r17 = r17 / r11
            long r17 = r17 + r13
            long r21 = r2 - r9
            r19 = r4
            long r2 = j1.l0.i(r17, r19, r21)
            r15 = r2
            goto L_0x0047
        L_0x00ca:
            int r4 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00cf
            return r15
        L_0x00cf:
            r0.f15842e = r6
        L_0x00d1:
            r7 = r23
        L_0x00d3:
            r7.b(r1, r2)
            r2 = 0
            r7.a(r1, r2)
            long r2 = r7.f15865b
            long r4 = r0.f15845h
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ef
            r25.f()
            r1 = 4
            r0.f15842e = r1
            long r1 = r0.f15848k
            r10 = 2
            long r1 = r1 + r10
            long r1 = -r1
            return r1
        L_0x00ef:
            r10 = 2
            int r3 = r7.f15867d
            int r4 = r7.f15868e
            int r3 = r3 + r4
            r1.g(r3)
            long r3 = r25.p()
            r0.f15846i = r3
            long r3 = r7.f15865b
            r0.f15848k = r3
            r2 = -1
            goto L_0x00d3
        L_0x0106:
            r7 = r8
            goto L_0x011b
        L_0x0108:
            r7 = r8
            long r10 = r25.p()
            r0.f15844g = r10
            r0.f15842e = r9
            r12 = 65307(0xff1b, double:3.2266E-319)
            long r12 = r5 - r12
            int r8 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x011b
            return r12
        L_0x011b:
            r8 = 0
            r7.f15864a = r8
            r7.f15865b = r3
            r7.f15866c = r8
            r7.f15867d = r8
            r7.f15868e = r8
            r3 = -1
            boolean r10 = r7.b(r1, r3)
            if (r10 == 0) goto L_0x016c
            r7.a(r1, r8)
            int r3 = r7.f15867d
            int r4 = r7.f15868e
            int r3 = r3 + r4
            r1.g(r3)
        L_0x0139:
            long r3 = r7.f15865b
            int r10 = r7.f15864a
            r2 = 4
            r10 = r10 & r2
            if (r10 == r2) goto L_0x0164
            r10 = -1
            boolean r12 = r7.b(r1, r10)
            if (r12 == 0) goto L_0x0164
            long r12 = r25.p()
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x0164
            boolean r12 = r7.a(r1, r9)
            if (r12 == 0) goto L_0x0164
            int r12 = r7.f15867d
            int r13 = r7.f15868e
            int r12 = r12 + r13
            r1.g(r12)     // Catch:{ EOFException -> 0x0161 }
            r12 = 1
            goto L_0x0162
        L_0x0161:
            r12 = 0
        L_0x0162:
            if (r12 != 0) goto L_0x0139
        L_0x0164:
            r0.f15843f = r3
            r1 = 4
            r0.f15842e = r1
            long r1 = r0.f15844g
            return r1
        L_0x016c:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.b.b(d2.w):long");
    }

    public final void c(long j10) {
        this.f15845h = l0.i(j10, 0, this.f15843f - 1);
        this.f15842e = 2;
        this.f15846i = this.f15839b;
        this.f15847j = this.f15840c;
        this.f15848k = 0;
        this.f15849l = this.f15843f;
    }
}
