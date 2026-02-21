package f3;

import d2.p0;
import d2.x0;
import d2.y;
import j1.b0;

public final class p implements k {

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f5670l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final m0 f5671a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5672b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean[] f5673c;

    /* renamed from: d  reason: collision with root package name */
    public final n f5674d;

    /* renamed from: e  reason: collision with root package name */
    public final y f5675e;

    /* renamed from: f  reason: collision with root package name */
    public o f5676f;

    /* renamed from: g  reason: collision with root package name */
    public long f5677g;

    /* renamed from: h  reason: collision with root package name */
    public String f5678h;

    /* renamed from: i  reason: collision with root package name */
    public x0 f5679i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5680j;

    /* renamed from: k  reason: collision with root package name */
    public long f5681k;

    public p() {
        this((m0) null);
    }

    public final void a() {
        p0.a(this.f5673c);
        n nVar = this.f5674d;
        nVar.f5657a = false;
        nVar.f5659c = 0;
        nVar.f5658b = 0;
        o oVar = this.f5676f;
        if (oVar != null) {
            oVar.f5663b = false;
            oVar.f5664c = false;
            oVar.f5665d = false;
            oVar.f5666e = -1;
        }
        y yVar = this.f5675e;
        if (yVar != null) {
            yVar.c();
        }
        this.f5677g = 0;
        this.f5681k = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0252 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0224  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            f3.o r2 = r0.f5676f
            j1.a.f(r2)
            d2.x0 r2 = r0.f5679i
            j1.a.f(r2)
            int r2 = r1.f8415b
            int r3 = r1.f8416c
            byte[] r4 = r1.f8414a
            long r5 = r0.f5677g
            int r7 = r3 - r2
            long r8 = (long) r7
            long r5 = r5 + r8
            r0.f5677g = r5
            d2.x0 r5 = r0.f5679i
            r5.d(r7, r1)
        L_0x0021:
            boolean[] r5 = r0.f5673c
            int r5 = d2.p0.b(r4, r2, r3, r5)
            f3.n r6 = r0.f5674d
            f3.y r7 = r0.f5675e
            if (r5 != r3) goto L_0x003f
            boolean r1 = r0.f5680j
            if (r1 != 0) goto L_0x0034
            r6.a(r4, r2, r3)
        L_0x0034:
            f3.o r1 = r0.f5676f
            r1.a(r4, r2, r3)
            if (r7 == 0) goto L_0x003e
            r7.a(r4, r2, r3)
        L_0x003e:
            return
        L_0x003f:
            byte[] r8 = r1.f8414a
            int r9 = r5 + 3
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r10 = r5 - r2
            boolean r11 = r0.f5680j
            r13 = 1
            if (r11 != 0) goto L_0x01c1
            if (r10 <= 0) goto L_0x0053
            r6.a(r4, r2, r5)
        L_0x0053:
            if (r10 >= 0) goto L_0x0057
            int r11 = -r10
            goto L_0x0058
        L_0x0057:
            r11 = 0
        L_0x0058:
            int r15 = r6.f5658b
            r12 = 2
            java.lang.String r14 = "H263Reader"
            if (r15 == 0) goto L_0x00aa
            r18 = r9
            r9 = 181(0xb5, float:2.54E-43)
            if (r15 == r13) goto L_0x0097
            if (r15 == r12) goto L_0x0090
            r12 = 3
            if (r15 == r12) goto L_0x0083
            r12 = 4
            if (r15 != r12) goto L_0x007d
            r12 = 179(0xb3, float:2.51E-43)
            if (r8 == r12) goto L_0x0073
            if (r8 != r9) goto L_0x00b4
        L_0x0073:
            int r9 = r6.f5659c
            int r9 = r9 - r11
            r6.f5659c = r9
            r9 = 0
            r6.f5657a = r9
            r9 = 1
            goto L_0x00bc
        L_0x007d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0083:
            r9 = r8 & 240(0xf0, float:3.36E-43)
            r11 = 32
            if (r9 == r11) goto L_0x008a
            goto L_0x0099
        L_0x008a:
            int r9 = r6.f5659c
            r6.f5660d = r9
            r9 = 4
            goto L_0x00a7
        L_0x0090:
            r9 = 31
            if (r8 <= r9) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r9 = 3
            goto L_0x00a7
        L_0x0097:
            if (r8 == r9) goto L_0x00a6
        L_0x0099:
            java.lang.String r9 = "Unexpected start code value"
            j1.v.g(r14, r9)
            r9 = 0
            r6.f5657a = r9
            r6.f5659c = r9
            r6.f5658b = r9
            goto L_0x00b4
        L_0x00a6:
            r9 = 2
        L_0x00a7:
            r6.f5658b = r9
            goto L_0x00b4
        L_0x00aa:
            r18 = r9
            r9 = 176(0xb0, float:2.47E-43)
            if (r8 != r9) goto L_0x00b4
            r6.f5658b = r13
            r6.f5657a = r13
        L_0x00b4:
            byte[] r9 = f3.n.f5656f
            r11 = 3
            r12 = 0
            r6.a(r9, r12, r11)
            r9 = 0
        L_0x00bc:
            if (r9 == 0) goto L_0x01c3
            d2.x0 r9 = r0.f5679i
            int r11 = r6.f5660d
            java.lang.String r12 = r0.f5678h
            r12.getClass()
            byte[] r15 = r6.f5661e
            int r6 = r6.f5659c
            byte[] r6 = java.util.Arrays.copyOf(r15, r6)
            j1.a0 r15 = new j1.a0
            int r13 = r6.length
            r15.<init>(r13, r6)
            r15.n(r11)
            r11 = 4
            r15.n(r11)
            r15.l()
            r13 = 8
            r15.m(r13)
            boolean r16 = r15.f()
            if (r16 == 0) goto L_0x00f1
            r15.m(r11)
            r13 = 3
            r15.m(r13)
        L_0x00f1:
            int r11 = r15.g(r11)
            r13 = 15
            if (r11 != r13) goto L_0x010a
            r13 = 8
            int r11 = r15.g(r13)
            int r13 = r15.g(r13)
            if (r13 != 0) goto L_0x0106
            goto L_0x0112
        L_0x0106:
            float r11 = (float) r11
            float r13 = (float) r13
            float r11 = r11 / r13
            goto L_0x0119
        L_0x010a:
            r13 = 7
            if (r11 >= r13) goto L_0x0112
            float[] r13 = f5670l
            r11 = r13[r11]
            goto L_0x0119
        L_0x0112:
            java.lang.String r11 = "Invalid aspect ratio"
            j1.v.g(r14, r11)
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x0119:
            boolean r13 = r15.f()
            if (r13 == 0) goto L_0x0155
            r13 = 2
            r15.m(r13)
            r13 = 1
            r15.m(r13)
            boolean r13 = r15.f()
            if (r13 == 0) goto L_0x0155
            r13 = 15
            r15.m(r13)
            r15.l()
            r15.m(r13)
            r15.l()
            r15.m(r13)
            r15.l()
            r13 = 3
            r15.m(r13)
            r13 = 11
            r15.m(r13)
            r15.l()
            r13 = 15
            r15.m(r13)
            r15.l()
        L_0x0155:
            r13 = 2
            int r13 = r15.g(r13)
            if (r13 == 0) goto L_0x0161
            java.lang.String r13 = "Unhandled video object layer shape"
            j1.v.g(r14, r13)
        L_0x0161:
            r15.l()
            r13 = 16
            int r13 = r15.g(r13)
            r15.l()
            boolean r16 = r15.f()
            if (r16 == 0) goto L_0x0188
            if (r13 != 0) goto L_0x017b
            java.lang.String r13 = "Invalid vop_increment_time_resolution"
            j1.v.g(r14, r13)
            goto L_0x0188
        L_0x017b:
            int r13 = r13 + -1
            r14 = 0
        L_0x017e:
            if (r13 <= 0) goto L_0x0185
            int r14 = r14 + 1
            int r13 = r13 >> 1
            goto L_0x017e
        L_0x0185:
            r15.m(r14)
        L_0x0188:
            r15.l()
            r13 = 13
            int r14 = r15.g(r13)
            r15.l()
            int r13 = r15.g(r13)
            r15.l()
            r15.l()
            g1.z r15 = new g1.z
            r15.<init>()
            r15.f6744a = r12
            java.lang.String r12 = "video/mp4v-es"
            r15.f6754k = r12
            r15.f6759p = r14
            r15.f6760q = r13
            r15.f6763t = r11
            java.util.List r6 = java.util.Collections.singletonList(r6)
            r15.f6756m = r6
            g1.a0 r6 = new g1.a0
            r6.<init>(r15)
            r9.a(r6)
            r6 = 1
            r0.f5680j = r6
            goto L_0x01c3
        L_0x01c1:
            r18 = r9
        L_0x01c3:
            f3.o r6 = r0.f5676f
            r6.a(r4, r2, r5)
            if (r7 == 0) goto L_0x0201
            if (r10 <= 0) goto L_0x01d1
            r7.a(r4, r2, r5)
            r2 = 0
            goto L_0x01d2
        L_0x01d1:
            int r2 = -r10
        L_0x01d2:
            boolean r2 = r7.b(r2)
            if (r2 == 0) goto L_0x01f0
            byte[] r2 = r7.f5800d
            int r6 = r7.f5801e
            int r2 = d2.p0.f(r6, r2)
            int r6 = j1.l0.f8453a
            byte[] r6 = r7.f5800d
            j1.b0 r9 = r0.f5672b
            r9.E(r2, r6)
            long r10 = r0.f5681k
            f3.m0 r2 = r0.f5671a
            r2.a(r10, r9)
        L_0x01f0:
            r2 = 178(0xb2, float:2.5E-43)
            if (r8 != r2) goto L_0x0201
            byte[] r2 = r1.f8414a
            int r6 = r5 + 2
            byte r2 = r2[r6]
            r6 = 1
            if (r2 != r6) goto L_0x0202
            r7.d(r8)
            goto L_0x0202
        L_0x0201:
            r6 = 1
        L_0x0202:
            int r14 = r3 - r5
            long r9 = r0.f5677g
            long r11 = (long) r14
            long r12 = r9 - r11
            f3.o r2 = r0.f5676f
            boolean r5 = r0.f5680j
            int r7 = r2.f5666e
            r15 = 182(0xb6, float:2.55E-43)
            if (r7 != r15) goto L_0x0239
            if (r5 == 0) goto L_0x0239
            boolean r5 = r2.f5663b
            if (r5 == 0) goto L_0x0239
            long r10 = r2.f5669h
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x0239
            long r6 = r2.f5668g
            long r5 = r12 - r6
            int r6 = (int) r5
            boolean r5 = r2.f5665d
            d2.x0 r9 = r2.f5662a
            r7 = 0
            r19 = r12
            r12 = r5
            r13 = r6
            r5 = 182(0xb6, float:2.55E-43)
            r15 = r7
            r9.e(r10, r12, r13, r14, r15)
            goto L_0x023d
        L_0x0239:
            r19 = r12
            r5 = 182(0xb6, float:2.55E-43)
        L_0x023d:
            int r6 = r2.f5666e
            r7 = 179(0xb3, float:2.51E-43)
            if (r6 == r7) goto L_0x0247
            r9 = r19
            r2.f5668g = r9
        L_0x0247:
            f3.o r2 = r0.f5676f
            long r9 = r0.f5681k
            r2.f5666e = r8
            r6 = 0
            r2.f5665d = r6
            if (r8 == r5) goto L_0x0257
            if (r8 != r7) goto L_0x0255
            goto L_0x0257
        L_0x0255:
            r6 = 0
            goto L_0x0258
        L_0x0257:
            r6 = 1
        L_0x0258:
            r2.f5663b = r6
            if (r8 != r5) goto L_0x025e
            r13 = 1
            goto L_0x025f
        L_0x025e:
            r13 = 0
        L_0x025f:
            r2.f5664c = r13
            r5 = 0
            r2.f5667f = r5
            r2.f5669h = r9
            r2 = r18
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.p.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5678h = j0Var.f5631e;
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 2);
        this.f5679i = d10;
        this.f5676f = new o(d10);
        m0 m0Var = this.f5671a;
        if (m0Var != null) {
            m0Var.b(yVar, j0Var);
        }
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5681k = j10;
        }
    }

    public final void f() {
    }

    public p(m0 m0Var) {
        b0 b0Var;
        this.f5671a = m0Var;
        this.f5673c = new boolean[4];
        this.f5674d = new n();
        this.f5681k = -9223372036854775807L;
        if (m0Var != null) {
            this.f5675e = new y(178);
            b0Var = new b0();
        } else {
            b0Var = null;
            this.f5675e = null;
        }
        this.f5672b = b0Var;
    }
}
