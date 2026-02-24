package f3;

import d2.x0;
import d2.y;
import j1.a0;
import j1.b0;

public final class w implements k {

    /* renamed from: a  reason: collision with root package name */
    public final String f5764a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5765b;

    /* renamed from: c  reason: collision with root package name */
    public final a0 f5766c;

    /* renamed from: d  reason: collision with root package name */
    public x0 f5767d;

    /* renamed from: e  reason: collision with root package name */
    public String f5768e;

    /* renamed from: f  reason: collision with root package name */
    public g1.a0 f5769f;

    /* renamed from: g  reason: collision with root package name */
    public int f5770g;

    /* renamed from: h  reason: collision with root package name */
    public int f5771h;

    /* renamed from: i  reason: collision with root package name */
    public int f5772i;

    /* renamed from: j  reason: collision with root package name */
    public int f5773j;

    /* renamed from: k  reason: collision with root package name */
    public long f5774k = -9223372036854775807L;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5775l;

    /* renamed from: m  reason: collision with root package name */
    public int f5776m;

    /* renamed from: n  reason: collision with root package name */
    public int f5777n;

    /* renamed from: o  reason: collision with root package name */
    public int f5778o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5779p;

    /* renamed from: q  reason: collision with root package name */
    public long f5780q;

    /* renamed from: r  reason: collision with root package name */
    public int f5781r;

    /* renamed from: s  reason: collision with root package name */
    public long f5782s;

    /* renamed from: t  reason: collision with root package name */
    public int f5783t;

    /* renamed from: u  reason: collision with root package name */
    public String f5784u;

    public w(String str) {
        this.f5764a = str;
        b0 b0Var = new b0(1024);
        this.f5765b = b0Var;
        byte[] bArr = b0Var.f8414a;
        this.f5766c = new a0(bArr.length, bArr);
    }

    public final void a() {
        this.f5770g = 0;
        this.f5774k = -9223372036854775807L;
        this.f5775l = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0189, code lost:
        if (r0.f5775l == false) goto L_0x0237;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            d2.x0 r2 = r0.f5767d
            j1.a.f(r2)
        L_0x0009:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x0246
            int r3 = r0.f5770g
            r4 = 1
            r5 = 86
            if (r3 == 0) goto L_0x023c
            r6 = 0
            r7 = 2
            if (r3 == r4) goto L_0x0225
            r5 = 3
            r8 = 8
            j1.b0 r9 = r0.f5765b
            j1.a0 r10 = r0.f5766c
            if (r3 == r7) goto L_0x0201
            if (r3 != r5) goto L_0x01fb
            int r3 = r0.f5772i
            int r11 = r0.f5771h
            int r3 = r3 - r11
            int r2 = java.lang.Math.min(r2, r3)
            byte[] r3 = r10.f8405a
            int r11 = r0.f5771h
            r1.d(r3, r11, r2)
            int r3 = r0.f5771h
            int r3 = r3 + r2
            r0.f5771h = r3
            int r2 = r0.f5772i
            if (r3 != r2) goto L_0x0009
            r10.k(r6)
            boolean r2 = r10.f()
            r3 = 0
            if (r2 != 0) goto L_0x0187
            r0.f5775l = r4
            int r2 = r10.g(r4)
            if (r2 != r4) goto L_0x0056
            int r11 = r10.g(r4)
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            r0.f5776m = r11
            if (r11 != 0) goto L_0x0182
            if (r2 != r4) goto L_0x0067
            int r11 = r10.g(r7)
            int r11 = r11 + r4
            int r11 = r11 * 8
            r10.g(r11)
        L_0x0067:
            boolean r11 = r10.f()
            if (r11 == 0) goto L_0x017d
            r11 = 6
            int r12 = r10.g(r11)
            r0.f5777n = r12
            r12 = 4
            int r13 = r10.g(r12)
            int r14 = r10.g(r5)
            if (r13 != 0) goto L_0x0178
            if (r14 != 0) goto L_0x0178
            if (r2 != 0) goto L_0x00ed
            int r13 = r10.e()
            int r14 = r10.b()
            j1.k r15 = d2.a.b(r10, r4)
            java.lang.String r6 = r15.f8452c
            r0.f5784u = r6
            int r6 = r15.f8450a
            r0.f5781r = r6
            int r6 = r15.f8451b
            r0.f5783t = r6
            int r6 = r10.b()
            int r14 = r14 - r6
            r10.k(r13)
            int r6 = r14 + 7
            int r6 = r6 / r8
            byte[] r6 = new byte[r6]
            r10.h(r6, r14)
            g1.z r13 = new g1.z
            r13.<init>()
            java.lang.String r14 = r0.f5768e
            r13.f6744a = r14
            java.lang.String r14 = "audio/mp4a-latm"
            r13.f6754k = r14
            java.lang.String r14 = r0.f5784u
            r13.f6751h = r14
            int r14 = r0.f5783t
            r13.f6767x = r14
            int r14 = r0.f5781r
            r13.f6768y = r14
            java.util.List r6 = java.util.Collections.singletonList(r6)
            r13.f6756m = r6
            java.lang.String r6 = r0.f5764a
            r13.f6746c = r6
            g1.a0 r6 = new g1.a0
            r6.<init>(r13)
            g1.a0 r13 = r0.f5769f
            boolean r13 = r6.equals(r13)
            if (r13 != 0) goto L_0x0117
            r0.f5769f = r6
            int r13 = r6.G
            long r13 = (long) r13
            r16 = 1024000000(0x3d090000, double:5.059232213E-315)
            long r13 = r16 / r13
            r0.f5782s = r13
            d2.x0 r13 = r0.f5767d
            r13.a(r6)
            goto L_0x0117
        L_0x00ed:
            int r6 = r10.g(r7)
            int r6 = r6 + r4
            int r6 = r6 * 8
            int r6 = r10.g(r6)
            long r13 = (long) r6
            int r6 = (int) r13
            int r13 = r10.b()
            j1.k r14 = d2.a.b(r10, r4)
            java.lang.String r15 = r14.f8452c
            r0.f5784u = r15
            int r15 = r14.f8450a
            r0.f5781r = r15
            int r14 = r14.f8451b
            r0.f5783t = r14
            int r14 = r10.b()
            int r13 = r13 - r14
            int r6 = r6 - r13
            r10.m(r6)
        L_0x0117:
            int r6 = r10.g(r5)
            r0.f5778o = r6
            if (r6 == 0) goto L_0x013b
            if (r6 == r4) goto L_0x0138
            if (r6 == r5) goto L_0x013d
            if (r6 == r12) goto L_0x013d
            r5 = 5
            if (r6 == r5) goto L_0x013d
            if (r6 == r11) goto L_0x0134
            r5 = 7
            if (r6 != r5) goto L_0x012e
            goto L_0x0134
        L_0x012e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0134:
            r10.m(r4)
            goto L_0x0140
        L_0x0138:
            r11 = 9
            goto L_0x013d
        L_0x013b:
            r11 = 8
        L_0x013d:
            r10.m(r11)
        L_0x0140:
            boolean r5 = r10.f()
            r0.f5779p = r5
            r11 = 0
            r0.f5780q = r11
            if (r5 == 0) goto L_0x016e
            if (r2 != r4) goto L_0x015d
            int r2 = r10.g(r7)
            int r2 = r2 + r4
            int r2 = r2 * 8
            int r2 = r10.g(r2)
            long r4 = (long) r2
            r0.f5780q = r4
            goto L_0x016e
        L_0x015d:
            boolean r2 = r10.f()
            long r4 = r0.f5780q
            long r4 = r4 << r8
            int r6 = r10.g(r8)
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.f5780q = r4
            if (r2 != 0) goto L_0x015d
        L_0x016e:
            boolean r2 = r10.f()
            if (r2 == 0) goto L_0x018d
            r10.m(r8)
            goto L_0x018d
        L_0x0178:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x017d:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x0182:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x0187:
            boolean r2 = r0.f5775l
            if (r2 != 0) goto L_0x018d
            goto L_0x0237
        L_0x018d:
            int r2 = r0.f5776m
            if (r2 != 0) goto L_0x01f6
            int r2 = r0.f5777n
            if (r2 != 0) goto L_0x01f1
            int r2 = r0.f5778o
            if (r2 != 0) goto L_0x01ec
            r2 = 0
        L_0x019a:
            int r3 = r10.g(r8)
            int r2 = r2 + r3
            r4 = 255(0xff, float:3.57E-43)
            if (r3 == r4) goto L_0x019a
            int r3 = r10.e()
            r4 = r3 & 7
            if (r4 != 0) goto L_0x01ae
            int r3 = r3 >> 3
            goto L_0x01b6
        L_0x01ae:
            byte[] r3 = r9.f8414a
            int r4 = r2 * 8
            r10.h(r3, r4)
            r3 = 0
        L_0x01b6:
            r9.G(r3)
            d2.x0 r3 = r0.f5767d
            r3.d(r2, r9)
            long r3 = r0.f5774k
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01e1
            d2.x0 r5 = r0.f5767d
            r19 = 1
            r21 = 0
            r22 = 0
            r16 = r5
            r17 = r3
            r20 = r2
            r16.e(r17, r19, r20, r21, r22)
            long r2 = r0.f5774k
            long r4 = r0.f5782s
            long r2 = r2 + r4
            r0.f5774k = r2
        L_0x01e1:
            boolean r2 = r0.f5779p
            if (r2 == 0) goto L_0x0237
            long r2 = r0.f5780q
            int r3 = (int) r2
            r10.m(r3)
            goto L_0x0237
        L_0x01ec:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x01f1:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x01f6:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x01fb:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0201:
            int r2 = r0.f5773j
            r2 = r2 & -225(0xffffffffffffff1f, float:NaN)
            int r2 = r2 << r8
            int r3 = r24.v()
            r2 = r2 | r3
            r0.f5772i = r2
            byte[] r3 = r9.f8414a
            int r3 = r3.length
            if (r2 <= r3) goto L_0x021e
            r9.D(r2)
            byte[] r2 = r9.f8414a
            r10.getClass()
            int r3 = r2.length
            r10.j(r3, r2)
        L_0x021e:
            r2 = 0
            r0.f5771h = r2
            r0.f5770g = r5
            goto L_0x0009
        L_0x0225:
            int r2 = r24.v()
            r3 = r2 & 224(0xe0, float:3.14E-43)
            r4 = 224(0xe0, float:3.14E-43)
            if (r3 != r4) goto L_0x0235
            r0.f5773j = r2
            r0.f5770g = r7
            goto L_0x0009
        L_0x0235:
            if (r2 == r5) goto L_0x0009
        L_0x0237:
            r2 = 0
            r0.f5770g = r2
            goto L_0x0009
        L_0x023c:
            int r2 = r24.v()
            if (r2 != r5) goto L_0x0009
            r0.f5770g = r4
            goto L_0x0009
        L_0x0246:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.w.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5767d = yVar.d(j0Var.f5630d, 1);
        j0Var.b();
        this.f5768e = j0Var.f5631e;
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5774k = j10;
        }
    }

    public final void f() {
    }
}
