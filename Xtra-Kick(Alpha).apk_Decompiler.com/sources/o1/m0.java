package o1;

import java.util.Arrays;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f11949a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11950b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11951c;

    /* renamed from: d  reason: collision with root package name */
    public final float f11952d;

    /* renamed from: e  reason: collision with root package name */
    public final float f11953e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11954f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11955g;

    /* renamed from: h  reason: collision with root package name */
    public final int f11956h;

    /* renamed from: i  reason: collision with root package name */
    public final short[] f11957i;

    /* renamed from: j  reason: collision with root package name */
    public short[] f11958j;

    /* renamed from: k  reason: collision with root package name */
    public int f11959k;

    /* renamed from: l  reason: collision with root package name */
    public short[] f11960l;

    /* renamed from: m  reason: collision with root package name */
    public int f11961m;

    /* renamed from: n  reason: collision with root package name */
    public short[] f11962n;

    /* renamed from: o  reason: collision with root package name */
    public int f11963o;

    /* renamed from: p  reason: collision with root package name */
    public int f11964p;

    /* renamed from: q  reason: collision with root package name */
    public int f11965q;

    /* renamed from: r  reason: collision with root package name */
    public int f11966r;

    /* renamed from: s  reason: collision with root package name */
    public int f11967s;

    /* renamed from: t  reason: collision with root package name */
    public int f11968t;

    /* renamed from: u  reason: collision with root package name */
    public int f11969u;

    /* renamed from: v  reason: collision with root package name */
    public int f11970v;

    public m0(float f10, float f11, int i10, int i11, int i12) {
        this.f11949a = i10;
        this.f11950b = i11;
        this.f11951c = f10;
        this.f11952d = f11;
        this.f11953e = ((float) i10) / ((float) i12);
        this.f11954f = i10 / 400;
        int i13 = i10 / 65;
        this.f11955g = i13;
        int i14 = i13 * 2;
        this.f11956h = i14;
        this.f11957i = new short[i14];
        this.f11958j = new short[(i14 * i11)];
        this.f11960l = new short[(i14 * i11)];
        this.f11962n = new short[(i14 * i11)];
    }

    public static void e(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr3[i17] * i19) + ((i10 - i19) * sArr2[i18])) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    public final void a(short[] sArr, int i10, int i11) {
        short[] c10 = c(this.f11960l, this.f11961m, i11);
        this.f11960l = c10;
        int i12 = this.f11950b;
        System.arraycopy(sArr, i10 * i12, c10, this.f11961m * i12, i12 * i11);
        this.f11961m += i11;
    }

    public final void b(short[] sArr, int i10, int i11) {
        int i12 = this.f11956h / i11;
        int i13 = this.f11950b;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.f11957i[i16] = (short) (i17 / i14);
        }
    }

    public final short[] c(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.f11950b;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    public final int d(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.f11950b;
        int i14 = 255;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int i18 = 0;
            for (int i19 = 0; i19 < i11; i19++) {
                i18 += Math.abs(sArr[i13 + i19] - sArr[(i13 + i11) + i19]);
            }
            if (i18 * i16 < i15 * i11) {
                i16 = i11;
                i15 = i18;
            }
            if (i18 * i14 > i17 * i11) {
                i14 = i11;
                i17 = i18;
            }
            i11++;
        }
        this.f11969u = i15 / i16;
        this.f11970v = i17 / i14;
        return i16;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x018c: MOVE  (r3v1 int) = (r23v0 int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    public final void f() {
        /*
            r25 = this;
            r0 = r25
            int r1 = r0.f11961m
            float r2 = r0.f11951c
            float r3 = r0.f11952d
            float r2 = r2 / r3
            float r4 = r0.f11953e
            float r4 = r4 * r3
            double r5 = (double) r2
            r7 = 4607182463836013682(0x3ff0000a7c5ac472, double:1.00001)
            int r9 = r0.f11949a
            int r10 = r0.f11950b
            r11 = 1
            r12 = 0
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 > 0) goto L_0x0038
            r7 = 4607182328728024861(0x3fefffeb074a771d, double:0.99999)
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x0027
            goto L_0x0038
        L_0x0027:
            short[] r2 = r0.f11958j
            int r5 = r0.f11959k
            r0.a(r2, r12, r5)
            r0.f11959k = r12
        L_0x0030:
            r23 = r1
            r24 = r4
            r22 = r9
            goto L_0x0184
        L_0x0038:
            int r7 = r0.f11959k
            int r8 = r0.f11956h
            if (r7 >= r8) goto L_0x003f
            goto L_0x0030
        L_0x003f:
            r15 = 0
        L_0x0040:
            int r13 = r0.f11966r
            if (r13 <= 0) goto L_0x005b
            int r13 = java.lang.Math.min(r8, r13)
            short[] r14 = r0.f11958j
            r0.a(r14, r15, r13)
            int r14 = r0.f11966r
            int r14 = r14 - r13
            r0.f11966r = r14
            int r15 = r15 + r13
            r23 = r1
            r24 = r4
            r22 = r9
            goto L_0x0171
        L_0x005b:
            short[] r13 = r0.f11958j
            r14 = 4000(0xfa0, float:5.605E-42)
            if (r9 <= r14) goto L_0x0064
            int r14 = r9 / 4000
            goto L_0x0065
        L_0x0064:
            r14 = 1
        L_0x0065:
            int r3 = r0.f11955g
            int r12 = r0.f11954f
            if (r10 != r11) goto L_0x0075
            if (r14 != r11) goto L_0x0075
            r23 = r1
            r24 = r4
            r22 = r9
            r4 = 1
            goto L_0x009e
        L_0x0075:
            r0.b(r13, r15, r14)
            int r11 = r12 / r14
            r22 = r9
            int r9 = r3 / r14
            r23 = r1
            short[] r1 = r0.f11957i
            r24 = r4
            r4 = 0
            int r9 = r0.d(r1, r4, r11, r9)
            r4 = 1
            if (r14 == r4) goto L_0x00ab
            int r9 = r9 * r14
            int r14 = r14 * 4
            int r4 = r9 - r14
            int r9 = r9 + r14
            if (r4 >= r12) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r12 = r4
        L_0x0097:
            if (r9 <= r3) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r3 = r9
        L_0x009b:
            r4 = 1
            if (r10 != r4) goto L_0x00a3
        L_0x009e:
            int r9 = r0.d(r13, r15, r12, r3)
            goto L_0x00ab
        L_0x00a3:
            r0.b(r13, r15, r4)
            r4 = 0
            int r9 = r0.d(r1, r4, r12, r3)
        L_0x00ab:
            int r1 = r0.f11969u
            int r3 = r0.f11970v
            if (r1 == 0) goto L_0x00c6
            int r4 = r0.f11967s
            if (r4 != 0) goto L_0x00b6
            goto L_0x00c6
        L_0x00b6:
            int r4 = r1 * 3
            if (r3 <= r4) goto L_0x00bb
            goto L_0x00c6
        L_0x00bb:
            int r3 = r1 * 2
            int r4 = r0.f11968t
            int r4 = r4 * 3
            if (r3 > r4) goto L_0x00c4
            goto L_0x00c6
        L_0x00c4:
            r3 = 1
            goto L_0x00c7
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            if (r3 == 0) goto L_0x00cc
            int r3 = r0.f11967s
            goto L_0x00cd
        L_0x00cc:
            r3 = r9
        L_0x00cd:
            r0.f11968t = r1
            r0.f11967s = r9
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x011b
            short[] r4 = r0.f11958j
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L_0x00e7
            float r1 = (float) r3
            r9 = 1065353216(0x3f800000, float:1.0)
            float r11 = r2 - r9
            float r1 = r1 / r11
            int r1 = (int) r1
            goto L_0x00f4
        L_0x00e7:
            r9 = 1065353216(0x3f800000, float:1.0)
            float r11 = (float) r3
            float r1 = r1 - r2
            float r1 = r1 * r11
            float r11 = r2 - r9
            float r1 = r1 / r11
            int r1 = (int) r1
            r0.f11966r = r1
            r1 = r3
        L_0x00f4:
            short[] r9 = r0.f11960l
            int r11 = r0.f11961m
            short[] r9 = r0.c(r9, r11, r1)
            r0.f11960l = r9
            int r14 = r0.f11950b
            int r11 = r0.f11961m
            int r20 = r15 + r3
            r13 = r1
            r12 = r15
            r15 = r9
            r16 = r11
            r17 = r4
            r18 = r12
            r19 = r4
            e(r13, r14, r15, r16, r17, r18, r19, r20)
            int r4 = r0.f11961m
            int r4 = r4 + r1
            r0.f11961m = r4
            int r3 = r3 + r1
            int r3 = r3 + r12
            r15 = r3
            goto L_0x0171
        L_0x011b:
            r12 = r15
            short[] r4 = r0.f11958j
            r9 = 1056964608(0x3f000000, float:0.5)
            int r9 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x012e
            float r1 = (float) r3
            float r1 = r1 * r2
            r9 = 1065353216(0x3f800000, float:1.0)
            float r11 = r9 - r2
            float r1 = r1 / r11
            int r1 = (int) r1
            goto L_0x013d
        L_0x012e:
            r9 = 1065353216(0x3f800000, float:1.0)
            float r11 = (float) r3
            float r1 = r1 * r2
            float r1 = r1 - r9
            float r1 = r1 * r11
            float r11 = r9 - r2
            float r1 = r1 / r11
            int r1 = (int) r1
            r0.f11966r = r1
            r1 = r3
        L_0x013d:
            short[] r9 = r0.f11960l
            int r11 = r0.f11961m
            int r15 = r3 + r1
            short[] r9 = r0.c(r9, r11, r15)
            r0.f11960l = r9
            int r11 = r12 * r10
            int r13 = r0.f11961m
            int r13 = r13 * r10
            int r14 = r10 * r3
            java.lang.System.arraycopy(r4, r11, r9, r13, r14)
            int r14 = r0.f11950b
            short[] r9 = r0.f11960l
            int r11 = r0.f11961m
            int r16 = r11 + r3
            int r18 = r12 + r3
            r13 = r1
            r3 = r15
            r15 = r9
            r17 = r4
            r19 = r4
            r20 = r12
            e(r13, r14, r15, r16, r17, r18, r19, r20)
            int r4 = r0.f11961m
            int r4 = r4 + r3
            r0.f11961m = r4
            int r15 = r12 + r1
        L_0x0171:
            int r1 = r15 + r8
            if (r1 <= r7) goto L_0x0250
            int r1 = r0.f11959k
            int r1 = r1 - r15
            short[] r2 = r0.f11958j
            int r15 = r15 * r10
            int r3 = r10 * r1
            r4 = 0
            java.lang.System.arraycopy(r2, r15, r2, r4, r3)
            r0.f11959k = r1
        L_0x0184:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r24 > r1 ? 1 : (r24 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x024f
            int r1 = r0.f11961m
            r3 = r23
            if (r1 != r3) goto L_0x0192
            goto L_0x024f
        L_0x0192:
            r4 = r22
            float r1 = (float) r4
            float r1 = r1 / r24
            int r1 = (int) r1
            r9 = r4
        L_0x0199:
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r1 > r2) goto L_0x0247
            if (r9 <= r2) goto L_0x01a1
            goto L_0x0247
        L_0x01a1:
            int r2 = r0.f11961m
            int r2 = r2 - r3
            short[] r4 = r0.f11962n
            int r5 = r0.f11963o
            short[] r4 = r0.c(r4, r5, r2)
            r0.f11962n = r4
            short[] r5 = r0.f11960l
            int r6 = r3 * r10
            int r7 = r0.f11963o
            int r7 = r7 * r10
            int r8 = r10 * r2
            java.lang.System.arraycopy(r5, r6, r4, r7, r8)
            r0.f11961m = r3
            int r3 = r0.f11963o
            int r3 = r3 + r2
            r0.f11963o = r3
            r4 = 0
        L_0x01c3:
            int r2 = r0.f11963o
            int r3 = r2 + -1
            if (r4 >= r3) goto L_0x0233
        L_0x01c9:
            int r2 = r0.f11964p
            r3 = 1
            int r2 = r2 + r3
            int r5 = r2 * r1
            int r6 = r0.f11965q
            int r7 = r6 * r9
            if (r5 <= r7) goto L_0x021c
            short[] r2 = r0.f11960l
            int r5 = r0.f11961m
            short[] r2 = r0.c(r2, r5, r3)
            r0.f11960l = r2
            r2 = 0
        L_0x01e0:
            if (r2 >= r10) goto L_0x0210
            short[] r3 = r0.f11960l
            int r5 = r0.f11961m
            int r5 = r5 * r10
            int r5 = r5 + r2
            short[] r6 = r0.f11962n
            int r7 = r4 * r10
            int r7 = r7 + r2
            short r8 = r6[r7]
            int r7 = r7 + r10
            short r6 = r6[r7]
            int r7 = r0.f11965q
            int r7 = r7 * r9
            int r11 = r0.f11964p
            int r12 = r11 * r1
            r13 = 1
            int r11 = r11 + r13
            int r11 = r11 * r1
            int r7 = r11 - r7
            int r11 = r11 - r12
            int r8 = r8 * r7
            int r7 = r11 - r7
            int r7 = r7 * r6
            int r7 = r7 + r8
            int r7 = r7 / r11
            short r6 = (short) r7
            r3[r5] = r6
            int r2 = r2 + 1
            goto L_0x01e0
        L_0x0210:
            int r2 = r0.f11965q
            r11 = 1
            int r2 = r2 + r11
            r0.f11965q = r2
            int r2 = r0.f11961m
            int r2 = r2 + r11
            r0.f11961m = r2
            goto L_0x01c9
        L_0x021c:
            r11 = 1
            r0.f11964p = r2
            if (r2 != r9) goto L_0x0230
            r2 = 0
            r0.f11964p = r2
            if (r6 != r1) goto L_0x0229
            r21 = 1
            goto L_0x022b
        L_0x0229:
            r21 = 0
        L_0x022b:
            j1.a.e(r21)
            r0.f11965q = r2
        L_0x0230:
            int r4 = r4 + 1
            goto L_0x01c3
        L_0x0233:
            if (r3 != 0) goto L_0x0236
            goto L_0x024f
        L_0x0236:
            short[] r1 = r0.f11962n
            int r4 = r3 * r10
            int r2 = r2 - r3
            int r2 = r2 * r10
            r12 = 0
            java.lang.System.arraycopy(r1, r4, r1, r12, r2)
            int r1 = r0.f11963o
            int r1 = r1 - r3
            r0.f11963o = r1
            goto L_0x024f
        L_0x0247:
            r11 = 1
            r12 = 0
            int r1 = r1 / 2
            int r9 = r9 / 2
            goto L_0x0199
        L_0x024f:
            return
        L_0x0250:
            r9 = r22
            r1 = r23
            r4 = r24
            r11 = 1
            r12 = 0
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.m0.f():void");
    }
}
