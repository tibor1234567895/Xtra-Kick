package v1;

import j1.a;
import j1.l0;
import m1.p1;

public final class d implements y, x {

    /* renamed from: h  reason: collision with root package name */
    public final y f15597h;

    /* renamed from: i  reason: collision with root package name */
    public x f15598i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f15599j = new c[0];

    /* renamed from: k  reason: collision with root package name */
    public long f15600k;

    /* renamed from: l  reason: collision with root package name */
    public long f15601l;

    /* renamed from: m  reason: collision with root package name */
    public long f15602m;

    /* renamed from: n  reason: collision with root package name */
    public f f15603n;

    public d(y yVar, boolean z10, long j10, long j11) {
        this.f15597h = yVar;
        this.f15600k = z10 ? j10 : -9223372036854775807L;
        this.f15601l = j10;
        this.f15602m = j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 > r7) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long B(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f15600k = r0
            v1.c[] r0 = r6.f15599j
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0017
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0014
            r4.f15590b = r2
        L_0x0014:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0017:
            v1.y r0 = r6.f15597h
            long r0 = r0.B(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            long r7 = r6.f15601l
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0034
            long r7 = r6.f15602m
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0033
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            j1.a.e(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.d.B(long):long");
    }

    public final boolean C(long j10) {
        return this.f15597h.C(j10);
    }

    public final void D(long j10) {
        this.f15597h.D(j10);
    }

    public final boolean a() {
        return this.f15600k != -9223372036854775807L;
    }

    public final boolean c() {
        return this.f15597h.c();
    }

    public final long f(long j10, p1 p1Var) {
        long j11;
        long j12 = this.f15601l;
        if (j10 == j12) {
            return j12;
        }
        long i10 = l0.i(p1Var.f10436a, 0, j10 - j12);
        long j13 = p1Var.f10437b;
        long j14 = this.f15602m;
        if (j14 == Long.MIN_VALUE) {
            j11 = Long.MAX_VALUE;
        } else {
            j11 = j14 - j10;
        }
        long i11 = l0.i(j13, 0, j11);
        if (!(i10 == p1Var.f10436a && i11 == p1Var.f10437b)) {
            p1Var = new p1(i10, i11);
        }
        return this.f15597h.f(j10, p1Var);
    }

    public final void h(y yVar) {
        if (this.f15603n == null) {
            x xVar = this.f15598i;
            xVar.getClass();
            xVar.h(this);
        }
    }

    public final long j() {
        long j10 = this.f15597h.j();
        if (j10 != Long.MIN_VALUE) {
            long j11 = this.f15602m;
            if (j11 == Long.MIN_VALUE || j10 < j11) {
                return j10;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long k() {
        if (a()) {
            long j10 = this.f15600k;
            this.f15600k = -9223372036854775807L;
            long k10 = k();
            return k10 != -9223372036854775807L ? k10 : j10;
        }
        long k11 = this.f15597h.k();
        if (k11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z10 = true;
        a.e(k11 >= this.f15601l);
        long j11 = this.f15602m;
        if (j11 != Long.MIN_VALUE && k11 > j11) {
            z10 = false;
        }
        a.e(z10);
        return k11;
    }

    public final void m(x xVar, long j10) {
        this.f15598i = xVar;
        this.f15597h.m(this, j10);
    }

    public final l1 o() {
        return this.f15597h.o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (r1 > r5) goto L_0x0084;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long p(z1.s[] r16, boolean[] r17, v1.b1[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r18
            int r1 = r9.length
            v1.c[] r1 = new v1.c[r1]
            r0.f15599j = r1
            int r1 = r9.length
            v1.b1[] r10 = new v1.b1[r1]
            r11 = 0
            r1 = 0
        L_0x000f:
            int r2 = r9.length
            r12 = 0
            if (r1 >= r2) goto L_0x0024
            v1.c[] r2 = r0.f15599j
            r3 = r9[r1]
            v1.c r3 = (v1.c) r3
            r2[r1] = r3
            if (r3 == 0) goto L_0x001f
            v1.b1 r12 = r3.f15589a
        L_0x001f:
            r10[r1] = r12
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0024:
            v1.y r1 = r0.f15597h
            r2 = r16
            r3 = r17
            r4 = r10
            r5 = r19
            r6 = r20
            long r1 = r1.p(r2, r3, r4, r5, r6)
            boolean r3 = r15.a()
            r4 = 1
            if (r3 == 0) goto L_0x0066
            long r5 = r0.f15601l
            int r3 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0066
            r13 = 0
            int r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0061
            int r3 = r8.length
            r5 = 0
        L_0x0048:
            if (r5 >= r3) goto L_0x0061
            r6 = r8[r5]
            if (r6 == 0) goto L_0x005e
            g1.a0 r6 = r6.m()
            java.lang.String r7 = r6.f6276s
            java.lang.String r6 = r6.f6273p
            boolean r6 = g1.a1.a(r7, r6)
            if (r6 != 0) goto L_0x005e
            r3 = 1
            goto L_0x0062
        L_0x005e:
            int r5 = r5 + 1
            goto L_0x0048
        L_0x0061:
            r3 = 0
        L_0x0062:
            if (r3 == 0) goto L_0x0066
            r5 = r1
            goto L_0x006b
        L_0x0066:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x006b:
            r0.f15600k = r5
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0085
            long r5 = r0.f15601l
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0084
            long r5 = r0.f15602m
            r7 = -9223372036854775808
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0085
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r4 = 0
        L_0x0085:
            j1.a.e(r4)
        L_0x0088:
            int r3 = r9.length
            if (r11 >= r3) goto L_0x00ae
            r3 = r10[r11]
            if (r3 != 0) goto L_0x0094
            v1.c[] r3 = r0.f15599j
            r3[r11] = r12
            goto L_0x00a5
        L_0x0094:
            v1.c[] r4 = r0.f15599j
            r5 = r4[r11]
            if (r5 == 0) goto L_0x009e
            v1.b1 r5 = r5.f15589a
            if (r5 == r3) goto L_0x00a5
        L_0x009e:
            v1.c r5 = new v1.c
            r5.<init>(r15, r3)
            r4[r11] = r5
        L_0x00a5:
            v1.c[] r3 = r0.f15599j
            r3 = r3[r11]
            r9[r11] = r3
            int r11 = r11 + 1
            goto L_0x0088
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.d.p(z1.s[], boolean[], v1.b1[], boolean[], long):long");
    }

    public final void r(d1 d1Var) {
        y yVar = (y) d1Var;
        x xVar = this.f15598i;
        xVar.getClass();
        xVar.r(this);
    }

    public final long u() {
        long u10 = this.f15597h.u();
        if (u10 != Long.MIN_VALUE) {
            long j10 = this.f15602m;
            if (j10 == Long.MIN_VALUE || u10 < j10) {
                return u10;
            }
        }
        return Long.MIN_VALUE;
    }

    public final void v() {
        f fVar = this.f15603n;
        if (fVar == null) {
            this.f15597h.v();
            return;
        }
        throw fVar;
    }

    public final void y(long j10, boolean z10) {
        this.f15597h.y(j10, z10);
    }
}
