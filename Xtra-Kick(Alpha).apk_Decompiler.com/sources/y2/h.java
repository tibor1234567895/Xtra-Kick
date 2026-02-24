package y2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import j1.a0;
import j1.l0;
import o1.g0;

public final class h {

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f16907h = {0, 7, 8, 15};

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f16908i = {0, 119, -120, -1};

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f16909j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f16910a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f16911b;

    /* renamed from: c  reason: collision with root package name */
    public final Canvas f16912c = new Canvas();

    /* renamed from: d  reason: collision with root package name */
    public final g0 f16913d = new g0(719, 575, 0, 719, 0, 575);

    /* renamed from: e  reason: collision with root package name */
    public final b f16914e = new b(0, new int[]{0, -1, -16777216, -8421505}, a(), b());

    /* renamed from: f  reason: collision with root package name */
    public final g f16915f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f16916g;

    public h(int i10, int i11) {
        Paint paint = new Paint();
        this.f16910a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.f16911b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.f16915f = new g(i10, i11);
    }

    public static int[] a() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = c(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                int i11 = 127;
                int i12 = (i10 & 1) != 0 ? 127 : 0;
                int i13 = (i10 & 2) != 0 ? 127 : 0;
                if ((i10 & 4) == 0) {
                    i11 = 0;
                }
                iArr[i10] = c(255, i12, i13, i11);
            }
        }
        return iArr;
    }

    public static int[] b() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = 255;
            if (i10 < 8) {
                int i12 = (i10 & 1) != 0 ? 255 : 0;
                int i13 = (i10 & 2) != 0 ? 255 : 0;
                if ((i10 & 4) == 0) {
                    i11 = 0;
                }
                iArr[i10] = c(63, i12, i13, i11);
            } else {
                int i14 = i10 & 136;
                int i15 = 170;
                int i16 = 85;
                if (i14 == 0) {
                    int i17 = ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0);
                    int i18 = ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0);
                    if ((i10 & 4) == 0) {
                        i16 = 0;
                    }
                    if ((i10 & 64) == 0) {
                        i15 = 0;
                    }
                    iArr[i10] = c(255, i17, i18, i16 + i15);
                } else if (i14 != 8) {
                    int i19 = 43;
                    if (i14 == 128) {
                        int i20 = ((i10 & 1) != 0 ? 43 : 0) + 127 + ((i10 & 16) != 0 ? 85 : 0);
                        int i21 = ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0);
                        if ((i10 & 4) == 0) {
                            i19 = 0;
                        }
                        int i22 = i19 + 127;
                        if ((i10 & 64) == 0) {
                            i16 = 0;
                        }
                        iArr[i10] = c(255, i20, i21, i22 + i16);
                    } else if (i14 == 136) {
                        int i23 = ((i10 & 1) != 0 ? 43 : 0) + ((i10 & 16) != 0 ? 85 : 0);
                        int i24 = ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0);
                        if ((i10 & 4) == 0) {
                            i19 = 0;
                        }
                        if ((i10 & 64) == 0) {
                            i16 = 0;
                        }
                        iArr[i10] = c(255, i23, i24, i19 + i16);
                    }
                } else {
                    int i25 = ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0);
                    int i26 = ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0);
                    if ((i10 & 4) == 0) {
                        i16 = 0;
                    }
                    if ((i10 & 64) == 0) {
                        i15 = 0;
                    }
                    iArr[i10] = c(127, i25, i26, i16 + i15);
                }
            }
        }
        return iArr;
    }

    public static int c(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v13, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v5, types: [byte] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ce A[LOOP:3: B:80:0x0151->B:109:0x01ce, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0127 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012d A[LOOP:2: B:35:0x0099->B:67:0x012d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            r0 = r22
            r1 = r24
            r8 = r27
            j1.a0 r9 = new j1.a0
            int r2 = r0.length
            r9.<init>(r2, r0)
            r2 = r25
            r10 = r26
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0013:
            int r3 = r9.b()
            if (r3 == 0) goto L_0x020c
            r14 = 8
            int r3 = r9.g(r14)
            r4 = 240(0xf0, float:3.36E-43)
            if (r3 == r4) goto L_0x0206
            r15 = 4
            r7 = 2
            r6 = 1
            r16 = 0
            r5 = 3
            switch(r3) {
                case 16: goto L_0x0136;
                case 17: goto L_0x0089;
                case 18: goto L_0x0030;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r3) {
                case 32: goto L_0x01f6;
                case 33: goto L_0x01e4;
                case 34: goto L_0x01d1;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0013
        L_0x0030:
            r15 = r2
            r2 = 0
        L_0x0032:
            int r3 = r9.g(r14)
            if (r3 == 0) goto L_0x003d
            r17 = r2
            r18 = 1
            goto L_0x0063
        L_0x003d:
            boolean r3 = r9.f()
            r4 = 7
            if (r3 != 0) goto L_0x0056
            int r3 = r9.g(r4)
            if (r3 == 0) goto L_0x0050
            r17 = r2
            r18 = r3
            r3 = 0
            goto L_0x0063
        L_0x0050:
            r3 = 0
            r17 = 1
            r18 = 0
            goto L_0x0063
        L_0x0056:
            int r3 = r9.g(r4)
            int r4 = r9.g(r14)
            r17 = r2
            r18 = r3
            r3 = r4
        L_0x0063:
            if (r18 == 0) goto L_0x007e
            if (r8 == 0) goto L_0x007e
            r2 = r23[r3]
            r8.setColor(r2)
            float r3 = (float) r15
            float r4 = (float) r10
            int r2 = r15 + r18
            float r5 = (float) r2
            int r2 = r10 + 1
            float r7 = (float) r2
            r2 = r28
            r0 = 1
            r6 = r7
            r7 = r27
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x007f
        L_0x007e:
            r0 = 1
        L_0x007f:
            int r15 = r15 + r18
            if (r17 == 0) goto L_0x0085
            r2 = r15
            goto L_0x0013
        L_0x0085:
            r2 = r17
            r6 = 1
            goto L_0x0032
        L_0x0089:
            r0 = 1
            if (r1 != r5) goto L_0x0095
            if (r12 != 0) goto L_0x0091
            byte[] r3 = f16909j
            goto L_0x0092
        L_0x0091:
            r3 = r12
        L_0x0092:
            r17 = r3
            goto L_0x0097
        L_0x0095:
            r17 = 0
        L_0x0097:
            r6 = r2
            r2 = 0
        L_0x0099:
            int r3 = r9.g(r15)
            if (r3 == 0) goto L_0x00a0
            goto L_0x00f1
        L_0x00a0:
            boolean r3 = r9.f()
            if (r3 != 0) goto L_0x00b6
            int r3 = r9.g(r5)
            if (r3 == 0) goto L_0x00b4
            int r3 = r3 + 2
            r18 = r2
            r19 = r3
            r4 = 0
            goto L_0x00f6
        L_0x00b4:
            r2 = 1
            goto L_0x00ce
        L_0x00b6:
            boolean r3 = r9.f()
            if (r3 != 0) goto L_0x00c2
            int r3 = r9.g(r7)
            int r3 = r3 + r15
            goto L_0x00e1
        L_0x00c2:
            int r3 = r9.g(r7)
            if (r3 == 0) goto L_0x00f0
            if (r3 == r0) goto L_0x00ea
            if (r3 == r7) goto L_0x00db
            if (r3 == r5) goto L_0x00d4
        L_0x00ce:
            r18 = r2
            r4 = 0
            r19 = 0
            goto L_0x00f6
        L_0x00d4:
            int r3 = r9.g(r14)
            int r3 = r3 + 25
            goto L_0x00e1
        L_0x00db:
            int r3 = r9.g(r15)
            int r3 = r3 + 9
        L_0x00e1:
            int r4 = r9.g(r15)
            r18 = r2
            r19 = r3
            goto L_0x00f6
        L_0x00ea:
            r18 = r2
            r4 = 0
            r19 = 2
            goto L_0x00f6
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            r18 = r2
            r4 = r3
            r19 = 1
        L_0x00f6:
            if (r19 == 0) goto L_0x011f
            if (r8 == 0) goto L_0x011f
            if (r17 == 0) goto L_0x00fe
            byte r4 = r17[r4]
        L_0x00fe:
            r2 = r23[r4]
            r8.setColor(r2)
            float r3 = (float) r6
            float r4 = (float) r10
            int r2 = r6 + r19
            float r2 = (float) r2
            int r5 = r10 + 1
            float r5 = (float) r5
            r20 = r2
            r2 = r28
            r21 = r5
            r15 = 3
            r5 = r20
            r20 = r6
            r6 = r21
            r14 = 2
            r7 = r27
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x0123
        L_0x011f:
            r20 = r6
            r14 = 2
            r15 = 3
        L_0x0123:
            int r6 = r20 + r19
            if (r18 == 0) goto L_0x012d
            r9.c()
            r2 = r6
            goto L_0x0013
        L_0x012d:
            r2 = r18
            r5 = 3
            r7 = 2
            r14 = 8
            r15 = 4
            goto L_0x0099
        L_0x0136:
            r0 = 1
            r14 = 2
            r15 = 3
            if (r1 != r15) goto L_0x0142
            if (r11 != 0) goto L_0x0140
            byte[] r3 = f16908i
            goto L_0x014a
        L_0x0140:
            r3 = r11
            goto L_0x014a
        L_0x0142:
            if (r1 != r14) goto L_0x014d
            if (r13 != 0) goto L_0x0149
            byte[] r3 = f16907h
            goto L_0x014a
        L_0x0149:
            r3 = r13
        L_0x014a:
            r17 = r3
            goto L_0x014f
        L_0x014d:
            r17 = 0
        L_0x014f:
            r7 = r2
            r6 = 0
        L_0x0151:
            int r2 = r9.g(r14)
            if (r2 == 0) goto L_0x0158
            goto L_0x016c
        L_0x0158:
            boolean r2 = r9.f()
            if (r2 == 0) goto L_0x0165
            int r2 = r9.g(r15)
            int r2 = r2 + r15
            r3 = r2
            goto L_0x018e
        L_0x0165:
            boolean r2 = r9.f()
            if (r2 == 0) goto L_0x0171
            r2 = 0
        L_0x016c:
            r18 = r6
            r19 = 1
            goto L_0x01a3
        L_0x0171:
            int r2 = r9.g(r14)
            if (r2 == 0) goto L_0x019d
            if (r2 == r0) goto L_0x0197
            if (r2 == r14) goto L_0x0187
            if (r2 == r15) goto L_0x017e
            goto L_0x019e
        L_0x017e:
            r2 = 8
            int r3 = r9.g(r2)
            int r3 = r3 + 29
            goto L_0x018e
        L_0x0187:
            r2 = 4
            int r3 = r9.g(r2)
            int r3 = r3 + 12
        L_0x018e:
            int r2 = r9.g(r14)
            r19 = r3
            r18 = r6
            goto L_0x01a3
        L_0x0197:
            r18 = r6
            r2 = 0
            r19 = 2
            goto L_0x01a3
        L_0x019d:
            r6 = 1
        L_0x019e:
            r18 = r6
            r2 = 0
            r19 = 0
        L_0x01a3:
            if (r19 == 0) goto L_0x01c2
            if (r8 == 0) goto L_0x01c2
            if (r17 == 0) goto L_0x01ab
            byte r2 = r17[r2]
        L_0x01ab:
            r2 = r23[r2]
            r8.setColor(r2)
            float r3 = (float) r7
            float r4 = (float) r10
            int r2 = r7 + r19
            float r5 = (float) r2
            int r2 = r10 + 1
            float r6 = (float) r2
            r2 = r28
            r20 = r7
            r7 = r27
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x01c4
        L_0x01c2:
            r20 = r7
        L_0x01c4:
            int r7 = r20 + r19
            if (r18 == 0) goto L_0x01ce
            r9.c()
            r2 = r7
            goto L_0x0013
        L_0x01ce:
            r6 = r18
            goto L_0x0151
        L_0x01d1:
            r0 = 16
            byte[] r12 = new byte[r0]
            r3 = 0
        L_0x01d6:
            if (r3 >= r0) goto L_0x0013
            r4 = 8
            int r5 = r9.g(r4)
            byte r4 = (byte) r5
            r12[r3] = r4
            int r3 = r3 + 1
            goto L_0x01d6
        L_0x01e4:
            r0 = 4
            byte[] r11 = new byte[r0]
            r3 = 0
        L_0x01e8:
            if (r3 >= r0) goto L_0x0013
            r4 = 8
            int r5 = r9.g(r4)
            byte r5 = (byte) r5
            r11[r3] = r5
            int r3 = r3 + 1
            goto L_0x01e8
        L_0x01f6:
            r0 = 4
            byte[] r13 = new byte[r0]
            r3 = 0
        L_0x01fa:
            if (r3 >= r0) goto L_0x0013
            int r4 = r9.g(r0)
            byte r4 = (byte) r4
            r13[r3] = r4
            int r3 = r3 + 1
            goto L_0x01fa
        L_0x0206:
            int r10 = r10 + 2
            r2 = r25
            goto L_0x0013
        L_0x020c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.h.d(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static b e(a0 a0Var, int i10) {
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        a0 a0Var2 = a0Var;
        int i15 = 8;
        int g10 = a0Var2.g(8);
        a0Var2.m(8);
        int i16 = i10 - 2;
        int i17 = 4;
        int[] iArr2 = {0, -1, -16777216, -8421505};
        int[] a10 = a();
        int[] b10 = b();
        while (i16 > 0) {
            int g11 = a0Var2.g(i15);
            int g12 = a0Var2.g(i15);
            int i18 = i16 - 2;
            if ((g12 & 128) != 0) {
                iArr = iArr2;
            } else if ((g12 & 64) != 0) {
                iArr = a10;
            } else {
                iArr = b10;
            }
            if ((g12 & 1) != 0) {
                i14 = a0Var2.g(i15);
                i13 = a0Var2.g(i15);
                i12 = a0Var2.g(i15);
                i11 = a0Var2.g(i15);
                i16 = i18 - 4;
            } else {
                int g13 = a0Var2.g(2) << 6;
                i16 = i18 - 2;
                i12 = a0Var2.g(i17) << i17;
                int g14 = a0Var2.g(i17) << i17;
                i11 = g13;
                i14 = a0Var2.g(6) << 2;
                i13 = g14;
            }
            if (i14 == 0) {
                i13 = 0;
                i12 = 0;
                i11 = 255;
            }
            double d10 = (double) i14;
            double d11 = (double) (i13 - 128);
            double d12 = (double) (i12 - 128);
            iArr[g11] = c((byte) (255 - (i11 & 255)), l0.h((int) ((1.402d * d11) + d10), 0, 255), l0.h((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), l0.h((int) ((d12 * 1.772d) + d10), 0, 255));
            iArr2 = iArr2;
            g10 = g10;
            i15 = 8;
            i17 = 4;
        }
        return new b(g10, iArr2, a10, b10);
    }

    public static c f(a0 a0Var) {
        byte[] bArr;
        int g10 = a0Var.g(16);
        a0Var.m(4);
        int g11 = a0Var.g(2);
        boolean f10 = a0Var.f();
        a0Var.m(1);
        byte[] bArr2 = l0.f8458f;
        if (g11 == 1) {
            a0Var.m(a0Var.g(8) * 16);
        } else if (g11 == 0) {
            int g12 = a0Var.g(16);
            int g13 = a0Var.g(16);
            if (g12 > 0) {
                bArr2 = new byte[g12];
                a0Var.i(bArr2, g12);
            }
            if (g13 > 0) {
                bArr = new byte[g13];
                a0Var.i(bArr, g13);
                return new c(g10, f10, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(g10, f10, bArr2, bArr);
    }
}
