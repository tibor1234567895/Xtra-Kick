package v1;

import android.net.Uri;
import g1.f0;
import g1.m0;
import g1.r1;
import g1.s0;
import g1.u1;
import j1.a;
import q1.m;

public final class f1 extends u1 {

    /* renamed from: z  reason: collision with root package name */
    public static final Object f15622z = new Object();

    /* renamed from: m  reason: collision with root package name */
    public final long f15623m;

    /* renamed from: n  reason: collision with root package name */
    public final long f15624n;

    /* renamed from: o  reason: collision with root package name */
    public final long f15625o;

    /* renamed from: p  reason: collision with root package name */
    public final long f15626p;

    /* renamed from: q  reason: collision with root package name */
    public final long f15627q;

    /* renamed from: r  reason: collision with root package name */
    public final long f15628r;

    /* renamed from: s  reason: collision with root package name */
    public final long f15629s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f15630t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f15631u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f15632v;

    /* renamed from: w  reason: collision with root package name */
    public final Object f15633w;

    /* renamed from: x  reason: collision with root package name */
    public final s0 f15634x;

    /* renamed from: y  reason: collision with root package name */
    public final m0 f15635y;

    static {
        f0 f0Var = new f0();
        f0Var.f6358a = "SinglePeriodTimeline";
        f0Var.f6359b = Uri.EMPTY;
        f0Var.a();
    }

    public f1(long j10, long j11, long j12, long j13, long j14, long j15, boolean z10, boolean z11, boolean z12, m mVar, s0 s0Var, m0 m0Var) {
        this.f15623m = j10;
        this.f15624n = j11;
        this.f15625o = -9223372036854775807L;
        this.f15626p = j12;
        this.f15627q = j13;
        this.f15628r = j14;
        this.f15629s = j15;
        this.f15630t = z10;
        this.f15631u = z11;
        this.f15632v = z12;
        this.f15633w = mVar;
        s0Var.getClass();
        this.f15634x = s0Var;
        this.f15635y = m0Var;
    }

    public final int k(Object obj) {
        return f15622z.equals(obj) ? 0 : -1;
    }

    public final r1 o(int i10, r1 r1Var, boolean z10) {
        a.c(i10, 1);
        r1Var.p((Object) null, z10 ? f15622z : null, 0, this.f15626p, -this.f15628r);
        return r1Var;
    }

    public final int q() {
        return 1;
    }

    public final Object u(int i10) {
        a.c(i10, 1);
        return f15622z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r1 > r5) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g1.t1 w(int r24, g1.t1 r25, long r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = 1
            r2 = r24
            j1.a.c(r2, r1)
            boolean r13 = r0.f15631u
            long r1 = r0.f15629s
            if (r13 == 0) goto L_0x002c
            boolean r3 = r0.f15632v
            if (r3 != 0) goto L_0x002c
            r3 = 0
            int r5 = (r26 > r3 ? 1 : (r26 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r5 = r0.f15627q
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0024
            goto L_0x002a
        L_0x0024:
            long r1 = r1 + r26
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002c
        L_0x002a:
            r15 = r3
            goto L_0x002d
        L_0x002c:
            r15 = r1
        L_0x002d:
            java.lang.Object r3 = g1.t1.f6573y
            g1.s0 r4 = r0.f15634x
            java.lang.Object r5 = r0.f15633w
            long r6 = r0.f15623m
            long r8 = r0.f15624n
            long r10 = r0.f15625o
            boolean r12 = r0.f15630t
            g1.m0 r14 = r0.f15635y
            long r1 = r0.f15627q
            r17 = r1
            r19 = 0
            r20 = 0
            long r1 = r0.f15628r
            r21 = r1
            r2 = r25
            r2.l(r3, r4, r5, r6, r8, r10, r12, r13, r14, r15, r17, r19, r20, r21)
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.f1.w(int, g1.t1, long):g1.t1");
    }

    public final int x() {
        return 1;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f1(long r20, boolean r22, boolean r23, g1.s0 r24) {
        /*
            r19 = this;
            r14 = 0
            r16 = 0
            r9 = 0
            r11 = 0
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = 0
            if (r23 == 0) goto L_0x0019
            r13 = r24
            g1.m0 r0 = r13.f6558j
            goto L_0x001c
        L_0x0019:
            r13 = r24
            r0 = 0
        L_0x001c:
            r18 = r0
            r0 = r19
            r5 = r20
            r7 = r20
            r13 = r22
            r17 = r24
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.f1.<init>(long, boolean, boolean, g1.s0):void");
    }
}
