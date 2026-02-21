package f3;

import d2.p0;
import d2.x0;
import d2.y;
import j1.b0;

public final class m implements k {

    /* renamed from: q  reason: collision with root package name */
    public static final double[] f5637q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    public String f5638a;

    /* renamed from: b  reason: collision with root package name */
    public x0 f5639b;

    /* renamed from: c  reason: collision with root package name */
    public final m0 f5640c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f5641d;

    /* renamed from: e  reason: collision with root package name */
    public final y f5642e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f5643f;

    /* renamed from: g  reason: collision with root package name */
    public final l f5644g;

    /* renamed from: h  reason: collision with root package name */
    public long f5645h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5646i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5647j;

    /* renamed from: k  reason: collision with root package name */
    public long f5648k;

    /* renamed from: l  reason: collision with root package name */
    public long f5649l;

    /* renamed from: m  reason: collision with root package name */
    public long f5650m;

    /* renamed from: n  reason: collision with root package name */
    public long f5651n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5652o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5653p;

    public m() {
        this((m0) null);
    }

    public final void a() {
        p0.a(this.f5643f);
        l lVar = this.f5644g;
        lVar.f5633a = false;
        lVar.f5634b = 0;
        lVar.f5635c = 0;
        y yVar = this.f5642e;
        if (yVar != null) {
            yVar.c();
        }
        this.f5645h = 0;
        this.f5646i = false;
        this.f5649l = -9223372036854775807L;
        this.f5651n = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            d2.x0 r2 = r0.f5639b
            j1.a.f(r2)
            int r2 = r1.f8415b
            int r3 = r1.f8416c
            byte[] r4 = r1.f8414a
            long r5 = r0.f5645h
            int r7 = r3 - r2
            long r8 = (long) r7
            long r5 = r5 + r8
            r0.f5645h = r5
            d2.x0 r5 = r0.f5639b
            r5.d(r7, r1)
        L_0x001c:
            boolean[] r5 = r0.f5643f
            int r5 = d2.p0.b(r4, r2, r3, r5)
            f3.l r6 = r0.f5644g
            f3.y r7 = r0.f5642e
            if (r5 != r3) goto L_0x0035
            boolean r1 = r0.f5647j
            if (r1 != 0) goto L_0x002f
            r6.a(r4, r2, r3)
        L_0x002f:
            if (r7 == 0) goto L_0x0034
            r7.a(r4, r2, r3)
        L_0x0034:
            return
        L_0x0035:
            byte[] r8 = r1.f8414a
            int r9 = r5 + 3
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r10 = r5 - r2
            boolean r11 = r0.f5647j
            r12 = 179(0xb3, float:2.51E-43)
            r13 = 0
            if (r11 != 0) goto L_0x013a
            if (r10 <= 0) goto L_0x004b
            r6.a(r4, r2, r5)
        L_0x004b:
            if (r10 >= 0) goto L_0x004f
            int r11 = -r10
            goto L_0x0050
        L_0x004f:
            r11 = 0
        L_0x0050:
            boolean r15 = r6.f5633a
            r14 = 3
            if (r15 == 0) goto L_0x0069
            int r15 = r6.f5634b
            int r15 = r15 - r11
            r6.f5634b = r15
            int r11 = r6.f5635c
            if (r11 != 0) goto L_0x0065
            r11 = 181(0xb5, float:2.54E-43)
            if (r8 != r11) goto L_0x0065
            r6.f5635c = r15
            goto L_0x006e
        L_0x0065:
            r6.f5633a = r13
            r11 = 1
            goto L_0x0074
        L_0x0069:
            if (r8 != r12) goto L_0x006e
            r11 = 1
            r6.f5633a = r11
        L_0x006e:
            byte[] r11 = f3.l.f5632e
            r6.a(r11, r13, r14)
            r11 = 0
        L_0x0074:
            if (r11 == 0) goto L_0x013a
            java.lang.String r11 = r0.f5638a
            r11.getClass()
            byte[] r15 = r6.f5636d
            int r13 = r6.f5634b
            byte[] r13 = java.util.Arrays.copyOf(r15, r13)
            r15 = 4
            byte r12 = r13[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r16 = 5
            byte r14 = r13[r16]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r18 = 6
            r19 = r9
            byte r9 = r13[r18]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r15
            int r18 = r14 >> 4
            r12 = r12 | r18
            r14 = r14 & 15
            r15 = 8
            int r14 = r14 << r15
            r9 = r9 | r14
            r14 = 7
            byte r15 = r13[r14]
            r15 = r15 & 240(0xf0, float:3.36E-43)
            r14 = 4
            int r15 = r15 >> r14
            r14 = 2
            if (r15 == r14) goto L_0x00c0
            r14 = 3
            if (r15 == r14) goto L_0x00ba
            r14 = 4
            if (r15 == r14) goto L_0x00b4
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00c7
        L_0x00b4:
            int r14 = r9 * 121
            float r14 = (float) r14
            int r15 = r12 * 100
            goto L_0x00c5
        L_0x00ba:
            int r14 = r9 * 16
            float r14 = (float) r14
            int r15 = r12 * 9
            goto L_0x00c5
        L_0x00c0:
            int r14 = r9 * 4
            float r14 = (float) r14
            int r15 = r12 * 3
        L_0x00c5:
            float r15 = (float) r15
            float r14 = r14 / r15
        L_0x00c7:
            g1.z r15 = new g1.z
            r15.<init>()
            r15.f6744a = r11
            java.lang.String r11 = "video/mpeg2"
            r15.f6754k = r11
            r15.f6759p = r12
            r15.f6760q = r9
            r15.f6763t = r14
            java.util.List r9 = java.util.Collections.singletonList(r13)
            r15.f6756m = r9
            g1.a0 r9 = new g1.a0
            r9.<init>(r15)
            r11 = 7
            byte r11 = r13[r11]
            r11 = r11 & 15
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x0118
            r12 = 8
            if (r11 >= r12) goto L_0x0118
            double[] r12 = f5637q
            r11 = r12[r11]
            int r6 = r6.f5635c
            int r6 = r6 + 9
            byte r6 = r13[r6]
            r13 = r6 & 96
            int r13 = r13 >> 5
            r6 = r6 & 31
            if (r13 == r6) goto L_0x010f
            double r13 = (double) r13
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r13 + r16
            int r6 = r6 + 1
            r15 = r2
            double r1 = (double) r6
            double r13 = r13 / r1
            double r11 = r11 * r13
            goto L_0x0110
        L_0x010f:
            r15 = r2
        L_0x0110:
            r1 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r1 = r1 / r11
            long r1 = (long) r1
            goto L_0x011b
        L_0x0118:
            r15 = r2
            r1 = 0
        L_0x011b:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            android.util.Pair r1 = android.util.Pair.create(r9, r1)
            d2.x0 r2 = r0.f5639b
            java.lang.Object r6 = r1.first
            g1.a0 r6 = (g1.a0) r6
            r2.a(r6)
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.f5648k = r1
            r1 = 1
            r0.f5647j = r1
            goto L_0x013d
        L_0x013a:
            r15 = r2
            r19 = r9
        L_0x013d:
            if (r7 == 0) goto L_0x0179
            if (r10 <= 0) goto L_0x0147
            r2 = r15
            r7.a(r4, r2, r5)
            r1 = 0
            goto L_0x0148
        L_0x0147:
            int r1 = -r10
        L_0x0148:
            boolean r1 = r7.b(r1)
            if (r1 == 0) goto L_0x0166
            byte[] r1 = r7.f5800d
            int r2 = r7.f5801e
            int r1 = d2.p0.f(r2, r1)
            int r2 = j1.l0.f8453a
            byte[] r2 = r7.f5800d
            j1.b0 r6 = r0.f5641d
            r6.E(r1, r2)
            long r1 = r0.f5651n
            f3.m0 r9 = r0.f5640c
            r9.a(r1, r6)
        L_0x0166:
            r1 = 178(0xb2, float:2.5E-43)
            if (r8 != r1) goto L_0x0179
            r1 = r21
            byte[] r2 = r1.f8414a
            int r6 = r5 + 2
            byte r2 = r2[r6]
            r6 = 1
            if (r2 != r6) goto L_0x017b
            r7.d(r8)
            goto L_0x017b
        L_0x0179:
            r1 = r21
        L_0x017b:
            if (r8 == 0) goto L_0x018a
            r2 = 179(0xb3, float:2.51E-43)
            if (r8 != r2) goto L_0x0182
            goto L_0x018a
        L_0x0182:
            r2 = 184(0xb8, float:2.58E-43)
            if (r8 != r2) goto L_0x01ea
            r2 = 1
            r0.f5652o = r2
            goto L_0x01ea
        L_0x018a:
            int r2 = r3 - r5
            boolean r5 = r0.f5653p
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == 0) goto L_0x01b0
            boolean r5 = r0.f5647j
            if (r5 == 0) goto L_0x01b0
            long r10 = r0.f5651n
            int r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x01b0
            boolean r12 = r0.f5652o
            long r13 = r0.f5645h
            long r6 = r0.f5650m
            long r13 = r13 - r6
            int r5 = (int) r13
            int r13 = r5 - r2
            d2.x0 r9 = r0.f5639b
            r15 = 0
            r14 = r2
            r9.e(r10, r12, r13, r14, r15)
        L_0x01b0:
            boolean r5 = r0.f5646i
            if (r5 == 0) goto L_0x01bc
            boolean r5 = r0.f5653p
            if (r5 == 0) goto L_0x01b9
            goto L_0x01bc
        L_0x01b9:
            r2 = 0
            r5 = 1
            goto L_0x01e3
        L_0x01bc:
            long r5 = r0.f5645h
            long r9 = (long) r2
            long r5 = r5 - r9
            r0.f5650m = r5
            long r5 = r0.f5649l
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01ce
            goto L_0x01d9
        L_0x01ce:
            long r5 = r0.f5651n
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01d8
            long r11 = r0.f5648k
            long r5 = r5 + r11
            goto L_0x01d9
        L_0x01d8:
            r5 = r9
        L_0x01d9:
            r0.f5651n = r5
            r2 = 0
            r0.f5652o = r2
            r0.f5649l = r9
            r5 = 1
            r0.f5646i = r5
        L_0x01e3:
            if (r8 != 0) goto L_0x01e7
            r13 = 1
            goto L_0x01e8
        L_0x01e7:
            r13 = 0
        L_0x01e8:
            r0.f5653p = r13
        L_0x01ea:
            r2 = r19
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.m.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5638a = j0Var.f5631e;
        j0Var.b();
        this.f5639b = yVar.d(j0Var.f5630d, 2);
        m0 m0Var = this.f5640c;
        if (m0Var != null) {
            m0Var.b(yVar, j0Var);
        }
    }

    public final void e(int i10, long j10) {
        this.f5649l = j10;
    }

    public final void f() {
    }

    public m(m0 m0Var) {
        b0 b0Var;
        this.f5640c = m0Var;
        this.f5643f = new boolean[4];
        this.f5644g = new l();
        if (m0Var != null) {
            this.f5642e = new y(178);
            b0Var = new b0();
        } else {
            b0Var = null;
            this.f5642e = null;
        }
        this.f5641d = b0Var;
        this.f5649l = -9223372036854775807L;
        this.f5651n = -9223372036854775807L;
    }
}
