package f3;

import d2.x0;
import d2.y;
import g1.a0;
import j1.b0;

public final class i implements k {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5608a = new b0(new byte[18]);

    /* renamed from: b  reason: collision with root package name */
    public final String f5609b;

    /* renamed from: c  reason: collision with root package name */
    public String f5610c;

    /* renamed from: d  reason: collision with root package name */
    public x0 f5611d;

    /* renamed from: e  reason: collision with root package name */
    public int f5612e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f5613f;

    /* renamed from: g  reason: collision with root package name */
    public int f5614g;

    /* renamed from: h  reason: collision with root package name */
    public long f5615h;

    /* renamed from: i  reason: collision with root package name */
    public a0 f5616i;

    /* renamed from: j  reason: collision with root package name */
    public int f5617j;

    /* renamed from: k  reason: collision with root package name */
    public long f5618k = -9223372036854775807L;

    public i(String str) {
        this.f5609b = str;
    }

    public final void a() {
        this.f5612e = 0;
        this.f5613f = 0;
        this.f5614g = 0;
        this.f5618k = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            d2.x0 r2 = r0.f5611d
            j1.a.f(r2)
        L_0x0009:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x02c7
            int r3 = r0.f5612e
            r5 = 8
            r6 = 1
            r7 = 2
            r9 = 0
            j1.b0 r10 = r0.f5608a
            if (r3 == 0) goto L_0x0269
            if (r3 == r6) goto L_0x005a
            if (r3 != r7) goto L_0x0054
            int r3 = r0.f5617j
            int r4 = r0.f5613f
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            d2.x0 r3 = r0.f5611d
            r3.d(r2, r1)
            int r3 = r0.f5613f
            int r3 = r3 + r2
            r0.f5613f = r3
            int r14 = r0.f5617j
            if (r3 != r14) goto L_0x0009
            long r11 = r0.f5618k
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0051
            d2.x0 r10 = r0.f5611d
            r13 = 1
            r15 = 0
            r16 = 0
            r10.e(r11, r13, r14, r15, r16)
            long r2 = r0.f5618k
            long r4 = r0.f5615h
            long r2 = r2 + r4
            r0.f5618k = r2
        L_0x0051:
            r0.f5612e = r9
            goto L_0x0009
        L_0x0054:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x005a:
            byte[] r3 = r10.f8414a
            int r11 = r0.f5613f
            r12 = 18
            int r11 = 18 - r11
            int r2 = java.lang.Math.min(r2, r11)
            int r11 = r0.f5613f
            r1.d(r3, r11, r2)
            int r3 = r0.f5613f
            int r3 = r3 + r2
            r0.f5613f = r3
            if (r3 != r12) goto L_0x0074
            r2 = 1
            goto L_0x0075
        L_0x0074:
            r2 = 0
        L_0x0075:
            if (r2 == 0) goto L_0x0009
            byte[] r2 = r10.f8414a
            g1.a0 r3 = r0.f5616i
            r11 = 14
            r14 = 31
            r15 = -2
            r4 = -1
            if (r3 != 0) goto L_0x01a2
            java.lang.String r3 = r0.f5610c
            byte r8 = r2[r9]
            r12 = 127(0x7f, float:1.78E-43)
            if (r8 != r12) goto L_0x0093
            j1.a0 r8 = new j1.a0
            int r12 = r2.length
            r8.<init>(r12, r2)
            goto L_0x0144
        L_0x0093:
            int r8 = r2.length
            byte[] r8 = java.util.Arrays.copyOf(r2, r8)
            byte r12 = r8[r9]
            if (r12 == r15) goto L_0x00a1
            if (r12 != r4) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r12 = 0
            goto L_0x00a2
        L_0x00a1:
            r12 = 1
        L_0x00a2:
            if (r12 == 0) goto L_0x00b6
            r12 = 0
        L_0x00a5:
            int r15 = r8.length
            int r15 = r15 - r6
            if (r12 >= r15) goto L_0x00b6
            byte r15 = r8[r12]
            int r17 = r12 + 1
            byte r18 = r8[r17]
            r8[r12] = r18
            r8[r17] = r15
            int r12 = r12 + 2
            goto L_0x00a5
        L_0x00b6:
            j1.a0 r12 = new j1.a0
            int r15 = r8.length
            r12.<init>(r15, r8)
            byte r15 = r8[r9]
            if (r15 != r14) goto L_0x013f
            j1.a0 r15 = new j1.a0
            int r14 = r8.length
            r15.<init>(r14, r8)
        L_0x00c6:
            int r14 = r15.b()
            r9 = 16
            if (r14 < r9) goto L_0x013f
            r15.m(r7)
            int r9 = r15.g(r11)
            r9 = r9 & 16383(0x3fff, float:2.2957E-41)
            int r14 = r12.f8407c
            int r14 = 8 - r14
            int r14 = java.lang.Math.min(r14, r11)
            int r7 = r12.f8407c
            int r19 = 8 - r7
            int r19 = r19 - r14
            r20 = 65280(0xff00, float:9.1477E-41)
            int r7 = r20 >> r7
            int r20 = r6 << r19
            int r20 = r20 + -1
            r7 = r7 | r20
            byte[] r13 = r12.f8405a
            int r4 = r12.f8406b
            byte r22 = r13[r4]
            r7 = r7 & r22
            byte r7 = (byte) r7
            r13[r4] = r7
            int r14 = 14 - r14
            int r22 = r9 >>> r14
            int r19 = r22 << r19
            r7 = r7 | r19
            byte r7 = (byte) r7
            r13[r4] = r7
            int r4 = r4 + r6
        L_0x0107:
            if (r14 <= r5) goto L_0x0118
            byte[] r7 = r12.f8405a
            int r13 = r4 + 1
            int r14 = r14 + -8
            int r5 = r9 >>> r14
            byte r5 = (byte) r5
            r7[r4] = r5
            r4 = r13
            r5 = 8
            goto L_0x0107
        L_0x0118:
            int r5 = 8 - r14
            byte[] r7 = r12.f8405a
            byte r13 = r7[r4]
            int r22 = r6 << r5
            r21 = -1
            int r22 = r22 + -1
            r13 = r13 & r22
            byte r13 = (byte) r13
            r7[r4] = r13
            int r14 = r6 << r14
            int r14 = r14 - r6
            r9 = r9 & r14
            int r5 = r9 << r5
            r5 = r5 | r13
            byte r5 = (byte) r5
            r7[r4] = r5
            r12.m(r11)
            r12.a()
            r4 = -1
            r5 = 8
            r7 = 2
            r9 = 0
            goto L_0x00c6
        L_0x013f:
            int r4 = r8.length
            r12.j(r4, r8)
            r8 = r12
        L_0x0144:
            r4 = 60
            r8.m(r4)
            r4 = 6
            int r5 = r8.g(r4)
            int[] r4 = d2.s.f4293a
            r4 = r4[r5]
            r5 = 4
            int r7 = r8.g(r5)
            int[] r5 = d2.s.f4294b
            r5 = r5[r7]
            r7 = 5
            int r9 = r8.g(r7)
            r7 = 29
            if (r9 < r7) goto L_0x0167
            r7 = -1
            r9 = 2
            goto L_0x016f
        L_0x0167:
            int[] r7 = d2.s.f4295c
            r7 = r7[r9]
            int r7 = r7 * 1000
            r9 = 2
            int r7 = r7 / r9
        L_0x016f:
            r12 = 10
            r8.m(r12)
            int r8 = r8.g(r9)
            if (r8 <= 0) goto L_0x017c
            r8 = 1
            goto L_0x017d
        L_0x017c:
            r8 = 0
        L_0x017d:
            int r4 = r4 + r8
            g1.z r8 = new g1.z
            r8.<init>()
            r8.f6744a = r3
            java.lang.String r3 = "audio/vnd.dts"
            r8.f6754k = r3
            r8.f6749f = r7
            r8.f6767x = r4
            r8.f6768y = r5
            r3 = 0
            r8.f6757n = r3
            java.lang.String r3 = r0.f5609b
            r8.f6746c = r3
            g1.a0 r3 = new g1.a0
            r3.<init>(r8)
            r0.f5616i = r3
            d2.x0 r4 = r0.f5611d
            r4.a(r3)
        L_0x01a2:
            r3 = 0
            byte r4 = r2[r3]
            r3 = 7
            r5 = -2
            if (r4 == r5) goto L_0x01f0
            r5 = -1
            if (r4 == r5) goto L_0x01d5
            r5 = 31
            if (r4 == r5) goto L_0x01c2
            r5 = 5
            byte r7 = r2[r5]
            r5 = 3
            r5 = r5 & r7
            int r5 = r5 << 12
            r7 = 6
            byte r8 = r2[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r9 = 4
            int r8 = r8 << r9
            r5 = r5 | r8
            byte r8 = r2[r3]
            goto L_0x0200
        L_0x01c2:
            r5 = 3
            r7 = 6
            r9 = 4
            byte r8 = r2[r7]
            r5 = r5 & r8
            int r5 = r5 << 12
            byte r7 = r2[r3]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = 8
            byte r7 = r2[r7]
            goto L_0x01e7
        L_0x01d5:
            r5 = 3
            r9 = 4
            byte r7 = r2[r3]
            r5 = r5 & r7
            int r5 = r5 << 12
            r7 = 6
            byte r8 = r2[r7]
            r7 = r8 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = 9
            byte r7 = r2[r7]
        L_0x01e7:
            r8 = 60
            r7 = r7 & r8
            r8 = 2
            int r7 = r7 >> r8
            r5 = r5 | r7
            int r5 = r5 + r6
            r7 = 1
            goto L_0x0206
        L_0x01f0:
            r9 = 4
            byte r5 = r2[r9]
            r7 = 3
            r5 = r5 & r7
            int r5 = r5 << 12
            byte r7 = r2[r3]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = 6
            byte r8 = r2[r7]
        L_0x0200:
            r7 = r8 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r9
            r5 = r5 | r7
            int r5 = r5 + r6
            r7 = 0
        L_0x0206:
            if (r7 == 0) goto L_0x020b
            int r5 = r5 * 16
            int r5 = r5 / r11
        L_0x020b:
            r0.f5617j = r5
            r5 = -2
            if (r4 == r5) goto L_0x0238
            r5 = -1
            if (r4 == r5) goto L_0x022b
            r5 = 31
            if (r4 == r5) goto L_0x0221
            r4 = 4
            byte r3 = r2[r4]
            r3 = r3 & r6
            r5 = 6
            int r3 = r3 << r5
            r7 = 5
            byte r2 = r2[r7]
            goto L_0x0241
        L_0x0221:
            r4 = 4
            r5 = 6
            r7 = 5
            byte r7 = r2[r7]
            r3 = r3 & r7
            int r3 = r3 << r4
            byte r2 = r2[r5]
            goto L_0x0234
        L_0x022b:
            r4 = 4
            byte r5 = r2[r4]
            r5 = r5 & r3
            int r4 = r5 << 4
            byte r2 = r2[r3]
            r3 = r4
        L_0x0234:
            r4 = 60
            r2 = r2 & r4
            goto L_0x0243
        L_0x0238:
            r3 = 5
            r4 = 4
            r5 = 6
            byte r3 = r2[r3]
            r3 = r3 & r6
            int r3 = r3 << r5
            byte r2 = r2[r4]
        L_0x0241:
            r2 = r2 & 252(0xfc, float:3.53E-43)
        L_0x0243:
            r4 = 2
            int r2 = r2 >> r4
            r2 = r2 | r3
            int r2 = r2 + r6
            int r2 = r2 * 32
            long r2 = (long) r2
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 * r4
            g1.a0 r4 = r0.f5616i
            int r4 = r4.G
            long r4 = (long) r4
            long r2 = r2 / r4
            int r3 = (int) r2
            long r2 = (long) r3
            r0.f5615h = r2
            r2 = 0
            r10.G(r2)
            d2.x0 r2 = r0.f5611d
            r3 = 18
            r2.d(r3, r10)
            r2 = 2
            r0.f5612e = r2
            goto L_0x0009
        L_0x0269:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x02bf
            int r2 = r0.f5614g
            r3 = 8
            int r2 = r2 << r3
            r0.f5614g = r2
            int r4 = r24.v()
            r2 = r2 | r4
            r0.f5614g = r2
            r4 = 2147385345(0x7ffe8001, float:NaN)
            if (r2 == r4) goto L_0x0295
            r4 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r2 == r4) goto L_0x0295
            r4 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r2 == r4) goto L_0x0295
            r4 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r2 != r4) goto L_0x0293
            goto L_0x0295
        L_0x0293:
            r4 = 0
            goto L_0x0296
        L_0x0295:
            r4 = 1
        L_0x0296:
            if (r4 == 0) goto L_0x0269
            byte[] r3 = r10.f8414a
            int r4 = r2 >> 24
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 0
            r3[r5] = r4
            int r4 = r2 >> 16
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r3[r6] = r4
            int r4 = r2 >> 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 2
            r3[r5] = r4
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r4 = 3
            r3[r4] = r2
            r2 = 4
            r0.f5613f = r2
            r7 = 0
            r0.f5614g = r7
            r9 = 1
            goto L_0x02c1
        L_0x02bf:
            r7 = 0
            r9 = 0
        L_0x02c1:
            if (r9 == 0) goto L_0x0009
            r0.f5612e = r6
            goto L_0x0009
        L_0x02c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.i.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5610c = j0Var.f5631e;
        j0Var.b();
        this.f5611d = yVar.d(j0Var.f5630d, 1);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5618k = j10;
        }
    }

    public final void f() {
    }
}
