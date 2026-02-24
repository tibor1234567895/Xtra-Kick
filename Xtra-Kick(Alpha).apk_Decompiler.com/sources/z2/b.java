package z2;

import j1.b0;
import java.util.zip.Inflater;
import w2.c;

public final class b extends c {

    /* renamed from: m  reason: collision with root package name */
    public final b0 f17501m = new b0();

    /* renamed from: n  reason: collision with root package name */
    public final b0 f17502n = new b0();

    /* renamed from: o  reason: collision with root package name */
    public final a f17503o = new a();

    /* renamed from: p  reason: collision with root package name */
    public Inflater f17504p;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0173, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.d f(byte[] r24, int r25, boolean r26) {
        /*
            r23 = this;
            r0 = r23
            j1.b0 r1 = r0.f17501m
            r2 = r24
            r3 = r25
            r1.E(r3, r2)
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            r4 = 255(0xff, float:3.57E-43)
            if (r2 <= 0) goto L_0x0039
            byte[] r2 = r1.f8414a
            byte r2 = r2[r3]
            r2 = r2 & r4
            r3 = 120(0x78, float:1.68E-43)
            if (r2 != r3) goto L_0x0039
            java.util.zip.Inflater r2 = r0.f17504p
            if (r2 != 0) goto L_0x0028
            java.util.zip.Inflater r2 = new java.util.zip.Inflater
            r2.<init>()
            r0.f17504p = r2
        L_0x0028:
            java.util.zip.Inflater r2 = r0.f17504p
            j1.b0 r3 = r0.f17502n
            boolean r2 = j1.l0.B(r1, r3, r2)
            if (r2 == 0) goto L_0x0039
            byte[] r2 = r3.f8414a
            int r3 = r3.f8416c
            r1.E(r3, r2)
        L_0x0039:
            z2.a r2 = r0.f17503o
            r3 = 0
            r2.f17495d = r3
            r2.f17496e = r3
            r2.f17497f = r3
            r2.f17498g = r3
            r2.f17499h = r3
            r2.f17500i = r3
            j1.b0 r5 = r2.f17492a
            r5.D(r3)
            r2.f17494c = r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0054:
            int r6 = r1.f8416c
            int r7 = r1.f8415b
            int r7 = r6 - r7
            r8 = 2
            r9 = 3
            if (r7 < r9) goto L_0x023c
            int r7 = r1.v()
            int r10 = r1.A()
            int r11 = r1.f8415b
            int r11 = r11 + r10
            if (r11 <= r6) goto L_0x0076
            r1.G(r6)
            r17 = r5
            r3 = 0
            r4 = 0
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0230
        L_0x0076:
            r6 = 128(0x80, float:1.794E-43)
            int[] r13 = r2.f17493b
            j1.b0 r14 = r2.f17492a
            if (r7 == r6) goto L_0x0177
            r15 = 1
            switch(r7) {
                case 20: goto L_0x00f4;
                case 21: goto L_0x00ab;
                case 22: goto L_0x0088;
                default: goto L_0x0082;
            }
        L_0x0082:
            r17 = r5
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0173
        L_0x0088:
            r6 = 19
            if (r10 >= r6) goto L_0x008d
            goto L_0x0082
        L_0x008d:
            int r6 = r1.A()
            r2.f17495d = r6
            int r6 = r1.A()
            r2.f17496e = r6
            r6 = 11
            r1.H(r6)
            int r6 = r1.A()
            r2.f17497f = r6
            int r6 = r1.A()
            r2.f17498g = r6
            goto L_0x0082
        L_0x00ab:
            r7 = 4
            if (r10 >= r7) goto L_0x00af
            goto L_0x0082
        L_0x00af:
            r1.H(r9)
            int r8 = r1.v()
            r6 = r6 & r8
            if (r6 == 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r15 = 0
        L_0x00bb:
            int r10 = r10 + -4
            if (r15 == 0) goto L_0x00dd
            r6 = 7
            if (r10 >= r6) goto L_0x00c3
            goto L_0x0082
        L_0x00c3:
            int r6 = r1.x()
            if (r6 >= r7) goto L_0x00ca
            goto L_0x0082
        L_0x00ca:
            int r7 = r1.A()
            r2.f17499h = r7
            int r7 = r1.A()
            r2.f17500i = r7
            int r6 = r6 + -4
            r14.D(r6)
            int r10 = r10 + -7
        L_0x00dd:
            int r6 = r14.f8415b
            int r7 = r14.f8416c
            if (r6 >= r7) goto L_0x0082
            if (r10 <= 0) goto L_0x0082
            int r7 = r7 - r6
            int r7 = java.lang.Math.min(r10, r7)
            byte[] r8 = r14.f8414a
            r1.d(r8, r6, r7)
            int r6 = r6 + r7
            r14.G(r6)
            goto L_0x0082
        L_0x00f4:
            int r6 = r10 % 5
            if (r6 == r8) goto L_0x00f9
            goto L_0x0082
        L_0x00f9:
            r1.H(r8)
            java.util.Arrays.fill(r13, r3)
            int r10 = r10 / 5
            r6 = 0
        L_0x0102:
            if (r6 >= r10) goto L_0x016d
            int r7 = r1.v()
            int r8 = r1.v()
            int r9 = r1.v()
            int r14 = r1.v()
            int r16 = r1.v()
            r25 = r13
            double r12 = (double) r8
            int r9 = r9 + -128
            double r8 = (double) r9
            r17 = 4608992865850220347(0x3ff66e978d4fdf3b, double:1.402)
            double r17 = r17 * r8
            double r3 = r17 + r12
            int r3 = (int) r3
            int r14 = r14 + -128
            r17 = r5
            double r4 = (double) r14
            r19 = 4599871095020959050(0x3fd60663c74fb54a, double:0.34414)
            double r19 = r19 * r4
            double r19 = r12 - r19
            r21 = 4604607620821057148(0x3fe6da3c21187e7c, double:0.71414)
            double r8 = r8 * r21
            double r8 = r19 - r8
            int r8 = (int) r8
            r19 = 4610659197712347431(0x3ffc5a1cac083127, double:1.772)
            double r4 = r4 * r19
            double r4 = r4 + r12
            int r4 = (int) r4
            int r5 = r16 << 24
            r9 = 0
            r12 = 255(0xff, float:3.57E-43)
            int r3 = j1.l0.h(r3, r9, r12)
            int r3 = r3 << 16
            r3 = r3 | r5
            int r5 = j1.l0.h(r8, r9, r12)
            int r5 = r5 << 8
            r3 = r3 | r5
            int r4 = j1.l0.h(r4, r9, r12)
            r3 = r3 | r4
            r25[r7] = r3
            int r6 = r6 + 1
            r13 = r25
            r5 = r17
            r3 = 0
            r4 = 255(0xff, float:3.57E-43)
            goto L_0x0102
        L_0x016d:
            r17 = r5
            r12 = 255(0xff, float:3.57E-43)
            r2.f17494c = r15
        L_0x0173:
            r3 = 0
            r4 = 0
            goto L_0x022d
        L_0x0177:
            r17 = r5
            r25 = r13
            r12 = 255(0xff, float:3.57E-43)
            int r3 = r2.f17495d
            if (r3 == 0) goto L_0x021a
            int r3 = r2.f17496e
            if (r3 == 0) goto L_0x021a
            int r3 = r2.f17499h
            if (r3 == 0) goto L_0x021a
            int r3 = r2.f17500i
            if (r3 == 0) goto L_0x021a
            int r3 = r14.f8416c
            if (r3 == 0) goto L_0x021a
            int r4 = r14.f8415b
            if (r4 != r3) goto L_0x021a
            boolean r3 = r2.f17494c
            if (r3 != 0) goto L_0x019b
            goto L_0x021a
        L_0x019b:
            r3 = 0
            r14.G(r3)
            int r3 = r2.f17499h
            int r4 = r2.f17500i
            int r3 = r3 * r4
            int[] r4 = new int[r3]
            r5 = 0
        L_0x01a8:
            if (r5 >= r3) goto L_0x01df
            int r6 = r14.v()
            if (r6 == 0) goto L_0x01b8
            int r7 = r5 + 1
            r6 = r25[r6]
            r4[r5] = r6
        L_0x01b6:
            r5 = r7
            goto L_0x01a8
        L_0x01b8:
            int r6 = r14.v()
            if (r6 == 0) goto L_0x01a8
            r7 = r6 & 64
            if (r7 != 0) goto L_0x01c5
            r7 = r6 & 63
            goto L_0x01ce
        L_0x01c5:
            r7 = r6 & 63
            int r7 = r7 << 8
            int r8 = r14.v()
            r7 = r7 | r8
        L_0x01ce:
            r6 = r6 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x01d4
            r6 = 0
            goto L_0x01da
        L_0x01d4:
            int r6 = r14.v()
            r6 = r25[r6]
        L_0x01da:
            int r7 = r7 + r5
            java.util.Arrays.fill(r4, r5, r7, r6)
            goto L_0x01b6
        L_0x01df:
            int r3 = r2.f17499h
            int r5 = r2.f17500i
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r4, r3, r5, r6)
            i1.a r4 = new i1.a
            r4.<init>()
            r4.f7954b = r3
            int r3 = r2.f17497f
            float r3 = (float) r3
            int r5 = r2.f17495d
            float r5 = (float) r5
            float r3 = r3 / r5
            r4.f7960h = r3
            r3 = 0
            r4.f7961i = r3
            int r6 = r2.f17498g
            float r6 = (float) r6
            int r7 = r2.f17496e
            float r7 = (float) r7
            float r6 = r6 / r7
            r4.f7957e = r6
            r4.f7958f = r3
            r4.f7959g = r3
            int r3 = r2.f17499h
            float r3 = (float) r3
            float r3 = r3 / r5
            r4.f7964l = r3
            int r3 = r2.f17500i
            float r3 = (float) r3
            float r3 = r3 / r7
            r4.f7965m = r3
            i1.b r3 = r4.a()
            goto L_0x021b
        L_0x021a:
            r3 = 0
        L_0x021b:
            r4 = 0
            r2.f17495d = r4
            r2.f17496e = r4
            r2.f17497f = r4
            r2.f17498g = r4
            r2.f17499h = r4
            r2.f17500i = r4
            r14.D(r4)
            r2.f17494c = r4
        L_0x022d:
            r1.G(r11)
        L_0x0230:
            r5 = r17
            if (r3 == 0) goto L_0x0237
            r5.add(r3)
        L_0x0237:
            r3 = 0
            r4 = 255(0xff, float:3.57E-43)
            goto L_0x0054
        L_0x023c:
            x2.j r1 = new x2.j
            java.util.List r2 = java.util.Collections.unmodifiableList(r5)
            r1.<init>(r2, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.b.f(byte[], int, boolean):w2.d");
    }
}
