package d2;

import j1.a;
import java.util.Arrays;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4278a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f4279b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final Object f4280c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static int[] f4281d = new int[10];

    private p0() {
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i10, int i11, boolean[] zArr) {
        int i12 = i11 - i10;
        boolean z10 = false;
        a.e(i12 >= 0);
        if (i12 == 0) {
            return i11;
        }
        if (zArr[0]) {
            a(zArr);
            return i10 - 3;
        } else if (i12 > 1 && zArr[1] && bArr[i10] == 1) {
            a(zArr);
            return i10 - 2;
        } else if (i12 <= 2 || !zArr[2] || bArr[i10] != 0 || bArr[i10 + 1] != 1) {
            int i13 = i11 - 1;
            int i14 = i10 + 2;
            while (i14 < i13) {
                byte b10 = bArr[i14];
                if ((b10 & 254) == 0) {
                    int i15 = i14 - 2;
                    if (bArr[i15] == 0 && bArr[i14 - 1] == 0 && b10 == 1) {
                        a(zArr);
                        return i15;
                    }
                    i14 -= 2;
                }
                i14 += 3;
            }
            zArr[0] = i12 <= 2 ? !(i12 != 2 ? !zArr[1] || bArr[i13] != 1 : !(zArr[2] && bArr[i11 + -2] == 0 && bArr[i13] == 1)) : bArr[i11 + -3] == 0 && bArr[i11 + -2] == 0 && bArr[i13] == 1;
            zArr[1] = i12 <= 1 ? !(!zArr[2] || bArr[i13] != 0) : bArr[i11 + -2] == 0 && bArr[i13] == 0;
            if (bArr[i13] == 0) {
                z10 = true;
            }
            zArr[2] = z10;
            return i11;
        } else {
            a(zArr);
            return i10 - 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0330  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d2.m0 c(byte[] r24, int r25, int r26) {
        /*
            r0 = 2
            int r1 = r25 + 2
            d2.r0 r2 = new d2.r0
            r3 = 0
            r4 = r24
            r5 = r26
            r2.<init>((int) r1, (int) r5, (int) r3, (byte[]) r4)
            r1 = 4
            r2.m(r1)
            r4 = 3
            int r5 = r2.h(r4)
            r2.l()
            int r7 = r2.h(r0)
            boolean r8 = r2.f()
            r6 = 5
            int r9 = r2.h(r6)
            r6 = 0
            r10 = 0
        L_0x0028:
            r11 = 32
            r12 = 1
            if (r6 >= r11) goto L_0x0039
            boolean r11 = r2.f()
            if (r11 == 0) goto L_0x0036
            int r11 = r12 << r6
            r10 = r10 | r11
        L_0x0036:
            int r6 = r6 + 1
            goto L_0x0028
        L_0x0039:
            r6 = 6
            int[] r11 = new int[r6]
            r13 = 0
        L_0x003d:
            r14 = 8
            if (r13 >= r6) goto L_0x004a
            int r14 = r2.h(r14)
            r11[r13] = r14
            int r13 = r13 + 1
            goto L_0x003d
        L_0x004a:
            int r13 = r2.h(r14)
            r14 = 0
        L_0x004f:
            if (r14 >= r5) goto L_0x0064
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x0059
            int r3 = r3 + 89
        L_0x0059:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x0061
            int r3 = r3 + 8
        L_0x0061:
            int r14 = r14 + 1
            goto L_0x004f
        L_0x0064:
            r2.m(r3)
            if (r5 <= 0) goto L_0x0070
            int r3 = 8 - r5
            int r3 = r3 * 2
            r2.m(r3)
        L_0x0070:
            r2.i()
            int r3 = r2.i()
            if (r3 != r4) goto L_0x007c
            r2.l()
        L_0x007c:
            int r14 = r2.i()
            int r15 = r2.i()
            boolean r16 = r2.f()
            if (r16 == 0) goto L_0x00b5
            int r16 = r2.i()
            int r17 = r2.i()
            int r18 = r2.i()
            int r19 = r2.i()
            if (r3 == r12) goto L_0x00a2
            if (r3 != r0) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r20 = 1
            goto L_0x00a4
        L_0x00a2:
            r20 = 2
        L_0x00a4:
            if (r3 != r12) goto L_0x00a8
            r3 = 2
            goto L_0x00a9
        L_0x00a8:
            r3 = 1
        L_0x00a9:
            int r16 = r16 + r17
            int r16 = r16 * r20
            int r14 = r14 - r16
            int r18 = r18 + r19
            int r18 = r18 * r3
            int r15 = r15 - r18
        L_0x00b5:
            r2.i()
            r2.i()
            int r3 = r2.i()
            boolean r16 = r2.f()
            if (r16 == 0) goto L_0x00c8
            r16 = 0
            goto L_0x00ca
        L_0x00c8:
            r16 = r5
        L_0x00ca:
            r1 = r16
        L_0x00cc:
            if (r1 > r5) goto L_0x00da
            r2.i()
            r2.i()
            r2.i()
            int r1 = r1 + 1
            goto L_0x00cc
        L_0x00da:
            r2.i()
            r2.i()
            r2.i()
            r2.i()
            r2.i()
            r2.i()
            boolean r1 = r2.f()
            if (r1 == 0) goto L_0x0132
            boolean r1 = r2.f()
            if (r1 == 0) goto L_0x0132
            r1 = 0
            r5 = 4
        L_0x00fa:
            if (r1 >= r5) goto L_0x0132
            r5 = 0
        L_0x00fd:
            if (r5 >= r6) goto L_0x012c
            boolean r6 = r2.f()
            if (r6 != 0) goto L_0x0109
            r2.i()
            goto L_0x0123
        L_0x0109:
            int r6 = r1 << 1
            int r6 = r6 + 4
            int r6 = r12 << r6
            r0 = 64
            int r0 = java.lang.Math.min(r0, r6)
            if (r1 <= r12) goto L_0x011a
            r2.j()
        L_0x011a:
            r6 = 0
        L_0x011b:
            if (r6 >= r0) goto L_0x0123
            r2.j()
            int r6 = r6 + 1
            goto L_0x011b
        L_0x0123:
            if (r1 != r4) goto L_0x0127
            r0 = 3
            goto L_0x0128
        L_0x0127:
            r0 = 1
        L_0x0128:
            int r5 = r5 + r0
            r6 = 6
            r0 = 2
            goto L_0x00fd
        L_0x012c:
            int r1 = r1 + 1
            r5 = 4
            r6 = 6
            r0 = 2
            goto L_0x00fa
        L_0x0132:
            r2.m(r0)
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x0149
            r0 = 8
            r2.m(r0)
            r2.i()
            r2.i()
            r2.l()
        L_0x0149:
            int r0 = r2.i()
            r1 = 0
            int[] r4 = new int[r1]
            int[] r5 = new int[r1]
            r12 = -1
            r16 = -1
            r6 = -1
        L_0x0156:
            if (r1 >= r0) goto L_0x0282
            if (r1 == 0) goto L_0x0163
            boolean r16 = r2.f()
            if (r16 == 0) goto L_0x0163
            r16 = 1
            goto L_0x0165
        L_0x0163:
            r16 = 0
        L_0x0165:
            if (r16 == 0) goto L_0x0233
            r25 = r0
            int r0 = r6 + r12
            boolean r16 = r2.f()
            int r17 = r2.i()
            int r17 = r17 + 1
            int r16 = r16 * 2
            int r16 = 1 - r16
            int r16 = r16 * r17
            r26 = r14
            int r14 = r0 + 1
            r17 = r13
            boolean[] r13 = new boolean[r14]
            r18 = 0
            r19 = r11
            r11 = 0
        L_0x0188:
            if (r11 > r0) goto L_0x019e
            boolean r18 = r2.f()
            if (r18 != 0) goto L_0x0197
            boolean r18 = r2.f()
            r13[r11] = r18
            goto L_0x019b
        L_0x0197:
            r18 = 1
            r13[r11] = r18
        L_0x019b:
            int r11 = r11 + 1
            goto L_0x0188
        L_0x019e:
            int[] r11 = new int[r14]
            int[] r14 = new int[r14]
            int r18 = r12 + -1
            r20 = 0
        L_0x01a6:
            if (r18 < 0) goto L_0x01bd
            r21 = r5[r18]
            int r21 = r21 + r16
            if (r21 >= 0) goto L_0x01ba
            int r22 = r6 + r18
            boolean r22 = r13[r22]
            if (r22 == 0) goto L_0x01ba
            int r22 = r20 + 1
            r11[r20] = r21
            r20 = r22
        L_0x01ba:
            int r18 = r18 + -1
            goto L_0x01a6
        L_0x01bd:
            if (r16 >= 0) goto L_0x01c9
            boolean r18 = r13[r0]
            if (r18 == 0) goto L_0x01c9
            int r18 = r20 + 1
            r11[r20] = r16
            r20 = r18
        L_0x01c9:
            r18 = 0
            r18 = r9
            r21 = r10
            r9 = r20
            r10 = 0
        L_0x01d2:
            if (r10 >= r6) goto L_0x01e7
            r20 = r4[r10]
            int r20 = r20 + r16
            if (r20 >= 0) goto L_0x01e4
            boolean r22 = r13[r10]
            if (r22 == 0) goto L_0x01e4
            int r22 = r9 + 1
            r11[r9] = r20
            r9 = r22
        L_0x01e4:
            int r10 = r10 + 1
            goto L_0x01d2
        L_0x01e7:
            int[] r10 = java.util.Arrays.copyOf(r11, r9)
            int r11 = r6 + -1
            r20 = 0
        L_0x01ef:
            if (r11 < 0) goto L_0x0204
            r22 = r4[r11]
            int r22 = r22 + r16
            if (r22 <= 0) goto L_0x0201
            boolean r23 = r13[r11]
            if (r23 == 0) goto L_0x0201
            int r23 = r20 + 1
            r14[r20] = r22
            r20 = r23
        L_0x0201:
            int r11 = r11 + -1
            goto L_0x01ef
        L_0x0204:
            if (r16 <= 0) goto L_0x0210
            boolean r0 = r13[r0]
            if (r0 == 0) goto L_0x0210
            int r0 = r20 + 1
            r14[r20] = r16
            r20 = r0
        L_0x0210:
            r0 = 0
            r4 = r20
        L_0x0213:
            if (r0 >= r12) goto L_0x022a
            r11 = r5[r0]
            int r11 = r11 + r16
            if (r11 <= 0) goto L_0x0227
            int r20 = r6 + r0
            boolean r20 = r13[r20]
            if (r20 == 0) goto L_0x0227
            int r20 = r4 + 1
            r14[r4] = r11
            r4 = r20
        L_0x0227:
            int r0 = r0 + 1
            goto L_0x0213
        L_0x022a:
            int[] r0 = java.util.Arrays.copyOf(r14, r4)
            r5 = r0
            r12 = r4
            r6 = r9
            r4 = r10
            goto L_0x0272
        L_0x0233:
            r25 = r0
            r18 = r9
            r21 = r10
            r19 = r11
            r17 = r13
            r26 = r14
            int r0 = r2.i()
            int r4 = r2.i()
            int[] r5 = new int[r0]
            r6 = 0
        L_0x024a:
            if (r6 >= r0) goto L_0x025a
            int r9 = r2.i()
            int r9 = r9 + 1
            r5[r6] = r9
            r2.l()
            int r6 = r6 + 1
            goto L_0x024a
        L_0x025a:
            r6 = 1
            int[] r9 = new int[r4]
            r10 = 0
        L_0x025e:
            if (r10 >= r4) goto L_0x026e
            int r11 = r2.i()
            int r11 = r11 + r6
            r9[r10] = r11
            r2.l()
            int r10 = r10 + 1
            r6 = 1
            goto L_0x025e
        L_0x026e:
            r6 = r0
            r12 = r4
            r4 = r5
            r5 = r9
        L_0x0272:
            int r1 = r1 + 1
            r0 = r25
            r14 = r26
            r13 = r17
            r9 = r18
            r11 = r19
            r10 = r21
            goto L_0x0156
        L_0x0282:
            r18 = r9
            r21 = r10
            r19 = r11
            r17 = r13
            r26 = r14
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x02a3
            r0 = 0
        L_0x0293:
            int r1 = r2.i()
            if (r0 >= r1) goto L_0x02a3
            int r1 = r3 + 4
            int r1 = r1 + 1
            r2.m(r1)
            int r0 = r0 + 1
            goto L_0x0293
        L_0x02a3:
            r0 = 2
            r2.m(r0)
            boolean r1 = r2.f()
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x0338
            boolean r1 = r2.f()
            if (r1 == 0) goto L_0x02e1
            r1 = 8
            int r1 = r2.h(r1)
            r4 = 255(0xff, float:3.57E-43)
            if (r1 != r4) goto L_0x02d1
            r1 = 16
            int r4 = r2.h(r1)
            int r1 = r2.h(r1)
            if (r4 == 0) goto L_0x02e1
            if (r1 == 0) goto L_0x02e1
            float r3 = (float) r4
            float r1 = (float) r1
            float r3 = r3 / r1
            goto L_0x02e1
        L_0x02d1:
            r4 = 17
            if (r1 >= r4) goto L_0x02da
            float[] r3 = f4279b
            r3 = r3[r1]
            goto L_0x02e1
        L_0x02da:
            java.lang.String r4 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r5 = "NalUnitUtil"
            android.support.v4.media.h.z(r4, r1, r5)
        L_0x02e1:
            boolean r1 = r2.f()
            if (r1 == 0) goto L_0x02ea
            r2.l()
        L_0x02ea:
            boolean r1 = r2.f()
            if (r1 == 0) goto L_0x0318
            r1 = 3
            r2.m(r1)
            boolean r1 = r2.f()
            boolean r4 = r2.f()
            if (r4 == 0) goto L_0x0318
            r4 = 8
            int r5 = r2.h(r4)
            int r6 = r2.h(r4)
            r2.m(r4)
            int r4 = g1.o.i(r5)
            if (r1 == 0) goto L_0x0312
            r0 = 1
        L_0x0312:
            int r1 = g1.o.j(r6)
            r6 = r0
            goto L_0x031b
        L_0x0318:
            r4 = -1
            r1 = -1
            r6 = -1
        L_0x031b:
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x0327
            r2.i()
            r2.i()
        L_0x0327:
            r2.l()
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x0332
            int r15 = r15 * 2
        L_0x0332:
            r16 = r4
            r2 = r6
            r14 = r15
            r15 = r3
            goto L_0x0342
        L_0x0338:
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = -1
            r2 = -1
            r14 = r15
            r1 = -1
            r15 = 1065353216(0x3f800000, float:1.0)
            r16 = -1
        L_0x0342:
            d2.m0 r0 = new d2.m0
            r6 = r0
            r9 = r18
            r10 = r21
            r11 = r19
            r12 = r17
            r13 = r26
            r17 = r2
            r18 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.p0.c(byte[], int, int):d2.m0");
    }

    public static n0 d(byte[] bArr, int i10) {
        r0 r0Var = new r0(4, i10, 0, bArr);
        int i11 = r0Var.i();
        int i12 = r0Var.i();
        r0Var.l();
        return new n0(i11, i12, r0Var.f());
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d2.o0 e(byte[] r19, int r20, int r21) {
        /*
            r0 = 1
            int r1 = r20 + 1
            d2.r0 r2 = new d2.r0
            r3 = 0
            r4 = r19
            r5 = r21
            r2.<init>((int) r1, (int) r5, (int) r3, (byte[]) r4)
            r1 = 8
            int r4 = r2.h(r1)
            int r5 = r2.h(r1)
            int r6 = r2.h(r1)
            int r7 = r2.i()
            r1 = 100
            r3 = 3
            if (r4 == r1) goto L_0x004d
            r1 = 110(0x6e, float:1.54E-43)
            if (r4 == r1) goto L_0x004d
            r1 = 122(0x7a, float:1.71E-43)
            if (r4 == r1) goto L_0x004d
            r1 = 244(0xf4, float:3.42E-43)
            if (r4 == r1) goto L_0x004d
            r1 = 44
            if (r4 == r1) goto L_0x004d
            r1 = 83
            if (r4 == r1) goto L_0x004d
            r1 = 86
            if (r4 == r1) goto L_0x004d
            r1 = 118(0x76, float:1.65E-43)
            if (r4 == r1) goto L_0x004d
            r1 = 128(0x80, float:1.794E-43)
            if (r4 == r1) goto L_0x004d
            r1 = 138(0x8a, float:1.93E-43)
            if (r4 != r1) goto L_0x0049
            goto L_0x004d
        L_0x0049:
            r1 = 1
            r3 = 0
            r11 = 0
            goto L_0x009d
        L_0x004d:
            int r1 = r2.i()
            if (r1 != r3) goto L_0x0058
            boolean r8 = r2.f()
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            r2.i()
            r2.i()
            r2.l()
            boolean r9 = r2.f()
            if (r9 == 0) goto L_0x009c
            if (r1 == r3) goto L_0x006d
            r3 = 8
            goto L_0x006f
        L_0x006d:
            r3 = 12
        L_0x006f:
            r9 = 0
        L_0x0070:
            if (r9 >= r3) goto L_0x009c
            boolean r10 = r2.f()
            if (r10 == 0) goto L_0x0099
            r10 = 6
            if (r9 >= r10) goto L_0x007e
            r10 = 16
            goto L_0x0080
        L_0x007e:
            r10 = 64
        L_0x0080:
            r11 = 0
            r12 = 8
            r13 = 8
        L_0x0085:
            if (r11 >= r10) goto L_0x0099
            if (r12 == 0) goto L_0x0092
            int r12 = r2.j()
            int r12 = r12 + r13
            int r12 = r12 + 256
            int r12 = r12 % 256
        L_0x0092:
            if (r12 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r13 = r12
        L_0x0096:
            int r11 = r11 + 1
            goto L_0x0085
        L_0x0099:
            int r9 = r9 + 1
            goto L_0x0070
        L_0x009c:
            r11 = r8
        L_0x009d:
            int r3 = r2.i()
            int r13 = r3 + 4
            int r14 = r2.i()
            if (r14 != 0) goto L_0x00b2
            int r3 = r2.i()
            int r3 = r3 + 4
            r19 = r1
            goto L_0x00d9
        L_0x00b2:
            if (r14 != r0) goto L_0x00d6
            boolean r3 = r2.f()
            r2.j()
            r2.j()
            int r8 = r2.i()
            long r8 = (long) r8
            r10 = 0
            r19 = r1
        L_0x00c6:
            long r0 = (long) r10
            int r15 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r15 >= 0) goto L_0x00d1
            r2.i()
            int r10 = r10 + 1
            goto L_0x00c6
        L_0x00d1:
            r0 = 0
            r16 = r3
            r15 = 0
            goto L_0x00dd
        L_0x00d6:
            r19 = r1
            r3 = 0
        L_0x00d9:
            r0 = 0
            r15 = r3
            r16 = 0
        L_0x00dd:
            r2.i()
            r2.l()
            int r0 = r2.i()
            r1 = 1
            int r0 = r0 + r1
            int r3 = r2.i()
            int r3 = r3 + r1
            boolean r1 = r2.f()
            int r8 = 2 - r1
            int r3 = r3 * r8
            if (r1 != 0) goto L_0x00fb
            r2.l()
        L_0x00fb:
            r2.l()
            int r0 = r0 * 16
            int r3 = r3 * 16
            boolean r9 = r2.f()
            if (r9 == 0) goto L_0x013f
            int r9 = r2.i()
            int r10 = r2.i()
            int r17 = r2.i()
            int r18 = r2.i()
            if (r19 != 0) goto L_0x011e
            r21 = r15
            r12 = 1
            goto L_0x0134
        L_0x011e:
            r12 = 3
            r21 = r15
            r15 = r19
            if (r15 != r12) goto L_0x0129
            r12 = 1
            r19 = 1
            goto L_0x012c
        L_0x0129:
            r12 = 2
            r19 = 2
        L_0x012c:
            r12 = 1
            if (r15 != r12) goto L_0x0130
            r12 = 2
        L_0x0130:
            int r8 = r8 * r12
            r12 = r19
        L_0x0134:
            int r9 = r9 + r10
            int r9 = r9 * r12
            int r0 = r0 - r9
            int r17 = r17 + r18
            int r17 = r17 * r8
            int r3 = r3 - r17
            goto L_0x0141
        L_0x013f:
            r21 = r15
        L_0x0141:
            r8 = r0
            r9 = r3
            boolean r0 = r2.f()
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0180
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x0180
            r0 = 8
            int r0 = r2.h(r0)
            r10 = 255(0xff, float:3.57E-43)
            if (r0 != r10) goto L_0x016f
            r0 = 16
            int r10 = r2.h(r0)
            int r0 = r2.h(r0)
            if (r10 == 0) goto L_0x016d
            if (r0 == 0) goto L_0x016d
            float r2 = (float) r10
            float r0 = (float) r0
            float r3 = r2 / r0
        L_0x016d:
            r10 = r3
            goto L_0x0184
        L_0x016f:
            r2 = 17
            if (r0 >= r2) goto L_0x0179
            float[] r2 = f4279b
            r0 = r2[r0]
            r10 = r0
            goto L_0x0184
        L_0x0179:
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r3 = "NalUnitUtil"
            android.support.v4.media.h.z(r2, r0, r3)
        L_0x0180:
            r0 = 1065353216(0x3f800000, float:1.0)
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0184:
            d2.o0 r0 = new d2.o0
            r3 = r0
            r12 = r1
            r15 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.p0.e(byte[], int, int):d2.o0");
    }

    public static int f(int i10, byte[] bArr) {
        int i11;
        synchronized (f4280c) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10) {
                while (true) {
                    if (i12 < i10 - 2) {
                        if (bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 3) {
                            break;
                        }
                        i12++;
                    } else {
                        i12 = i10;
                        break;
                    }
                }
                if (i12 < i10) {
                    int[] iArr = f4281d;
                    if (iArr.length <= i13) {
                        f4281d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f4281d[i13] = i12;
                    i12 += 3;
                    i13++;
                }
            }
            i11 = i10 - i13;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = f4281d[i16] - i15;
                System.arraycopy(bArr, i15, bArr, i14, i17);
                int i18 = i14 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i14 = i19 + 1;
                bArr[i19] = 0;
                i15 += i17 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i14, i11 - i14);
        }
        return i11;
    }
}
