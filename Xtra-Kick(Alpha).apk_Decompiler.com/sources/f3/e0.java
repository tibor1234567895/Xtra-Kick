package f3;

import d2.y;
import j1.b0;
import j1.h0;

public final class e0 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f5533a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5534b = new b0(32);

    /* renamed from: c  reason: collision with root package name */
    public int f5535c;

    /* renamed from: d  reason: collision with root package name */
    public int f5536d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5537e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5538f;

    public e0(d0 d0Var) {
        this.f5533a = d0Var;
    }

    public final void a() {
        this.f5538f = true;
    }

    public final void b(h0 h0Var, y yVar, j0 j0Var) {
        this.f5533a.b(h0Var, yVar, j0Var);
        this.f5538f = true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e2 A[SYNTHETIC] */
    public final void c(int r11, j1.b0 r12) {
        /*
            r10 = this;
            r0 = 1
            r11 = r11 & r0
            r1 = 0
            if (r11 == 0) goto L_0x0007
            r11 = 1
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            r2 = -1
            if (r11 == 0) goto L_0x0013
            int r3 = r12.v()
            int r4 = r12.f8415b
            int r4 = r4 + r3
            goto L_0x0014
        L_0x0013:
            r4 = -1
        L_0x0014:
            boolean r3 = r10.f5538f
            if (r3 == 0) goto L_0x0022
            if (r11 != 0) goto L_0x001b
            return
        L_0x001b:
            r10.f5538f = r1
            r12.G(r4)
        L_0x0020:
            r10.f5536d = r1
        L_0x0022:
            int r11 = r12.f8416c
            int r3 = r12.f8415b
            int r4 = r11 - r3
            if (r4 <= 0) goto L_0x00e2
            int r4 = r10.f5536d
            r5 = 255(0xff, float:3.57E-43)
            r6 = 3
            j1.b0 r7 = r10.f5534b
            if (r4 >= r6) goto L_0x0097
            if (r4 != 0) goto L_0x0044
            int r11 = r12.v()
            int r3 = r12.f8415b
            int r3 = r3 - r0
            r12.G(r3)
            if (r11 != r5) goto L_0x0044
            r10.f5538f = r0
            return
        L_0x0044:
            int r11 = r12.f8416c
            int r3 = r12.f8415b
            int r11 = r11 - r3
            int r3 = r10.f5536d
            int r3 = 3 - r3
            int r11 = java.lang.Math.min(r11, r3)
            byte[] r3 = r7.f8414a
            int r4 = r10.f5536d
            r12.d(r3, r4, r11)
            int r3 = r10.f5536d
            int r3 = r3 + r11
            r10.f5536d = r3
            if (r3 != r6) goto L_0x0022
            r7.G(r1)
            r7.F(r6)
            r7.H(r0)
            int r11 = r7.v()
            int r3 = r7.v()
            r4 = r11 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0076
            r4 = 1
            goto L_0x0077
        L_0x0076:
            r4 = 0
        L_0x0077:
            r10.f5537e = r4
            r11 = r11 & 15
            int r11 = r11 << 8
            r11 = r11 | r3
            int r11 = r11 + r6
            r10.f5535c = r11
            byte[] r3 = r7.f8414a
            int r4 = r3.length
            if (r4 >= r11) goto L_0x0022
            int r3 = r3.length
            int r3 = r3 * 2
            int r11 = java.lang.Math.max(r11, r3)
            r3 = 4098(0x1002, float:5.743E-42)
            int r11 = java.lang.Math.min(r3, r11)
            r7.a(r11)
            goto L_0x0022
        L_0x0097:
            int r11 = r11 - r3
            int r3 = r10.f5535c
            int r3 = r3 - r4
            int r11 = java.lang.Math.min(r11, r3)
            byte[] r3 = r7.f8414a
            int r4 = r10.f5536d
            r12.d(r3, r4, r11)
            int r3 = r10.f5536d
            int r3 = r3 + r11
            r10.f5536d = r3
            int r11 = r10.f5535c
            if (r3 != r11) goto L_0x0022
            boolean r3 = r10.f5537e
            if (r3 == 0) goto L_0x00d5
            byte[] r3 = r7.f8414a
            int r4 = j1.l0.f8453a
            r4 = 0
            r6 = -1
        L_0x00b9:
            if (r4 >= r11) goto L_0x00cc
            int r8 = r6 << 8
            int r6 = r6 >>> 24
            byte r9 = r3[r4]
            r9 = r9 & r5
            r6 = r6 ^ r9
            r6 = r6 & r5
            int[] r9 = j1.l0.f8464l
            r6 = r9[r6]
            r6 = r6 ^ r8
            int r4 = r4 + 1
            goto L_0x00b9
        L_0x00cc:
            if (r6 == 0) goto L_0x00d1
            r10.f5538f = r0
            return
        L_0x00d1:
            int r11 = r10.f5535c
            int r11 = r11 + -4
        L_0x00d5:
            r7.F(r11)
            r7.G(r1)
            f3.d0 r11 = r10.f5533a
            r11.c(r7)
            goto L_0x0020
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e0.c(int, j1.b0):void");
    }
}
