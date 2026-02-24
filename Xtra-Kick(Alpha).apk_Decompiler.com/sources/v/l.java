package v;

import u.f;

public final class l extends q {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f15522k = new int[2];

    public l(f fVar) {
        super(fVar);
        this.f15548h.f15512e = 4;
        this.f15549i.f15512e = 5;
        this.f15546f = 0;
    }

    public static void m(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 == -1) {
            int i17 = (int) ((((float) i16) * f10) + 0.5f);
            int i18 = (int) ((((float) i15) / f10) + 0.5f);
            if (i17 <= i15) {
                iArr[0] = i17;
                iArr[1] = i16;
            } else if (i18 <= i16) {
                iArr[0] = i15;
                iArr[1] = i18;
            }
        } else if (i14 == 0) {
            iArr[0] = (int) ((((float) i16) * f10) + 0.5f);
            iArr[1] = i16;
        } else if (i14 == 1) {
            iArr[0] = i15;
            iArr[1] = (int) ((((float) i15) * f10) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022d, code lost:
        if (r3 != 1) goto L_0x027d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(v.d r24) {
        /*
            r23 = this;
            r0 = r23
            int r1 = r0.f15550j
            int r1 = s.i.a(r1)
            r2 = 0
            r3 = 3
            if (r1 == r3) goto L_0x0355
            v.g r1 = r0.f15545e
            boolean r4 = r1.f15517j
            v.f r5 = r0.f15548h
            v.f r6 = r0.f15549i
            r7 = 1
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r4 != 0) goto L_0x027d
            int r4 = r0.f15544d
            if (r4 != r3) goto L_0x027d
            u.f r4 = r0.f15542b
            int r9 = r4.f15115s
            r10 = 2
            if (r9 == r10) goto L_0x0265
            if (r9 == r3) goto L_0x0028
            goto L_0x027d
        L_0x0028:
            int r9 = r4.f15116t
            r10 = -1
            if (r9 == 0) goto L_0x0057
            if (r9 != r3) goto L_0x0030
            goto L_0x0057
        L_0x0030:
            int r9 = r4.Y
            if (r9 == r10) goto L_0x0045
            if (r9 == 0) goto L_0x003a
            if (r9 == r7) goto L_0x0045
            r4 = 0
            goto L_0x0052
        L_0x003a:
            v.n r9 = r4.f15088e
            v.g r9 = r9.f15545e
            int r9 = r9.f15514g
            float r9 = (float) r9
            float r4 = r4.X
            float r9 = r9 / r4
            goto L_0x0050
        L_0x0045:
            v.n r9 = r4.f15088e
            v.g r9 = r9.f15545e
            int r9 = r9.f15514g
            float r9 = (float) r9
            float r4 = r4.X
            float r9 = r9 * r4
        L_0x0050:
            float r9 = r9 + r8
            int r4 = (int) r9
        L_0x0052:
            r1.d(r4)
            goto L_0x027d
        L_0x0057:
            v.n r9 = r4.f15088e
            v.f r11 = r9.f15548h
            v.f r9 = r9.f15549i
            u.e r12 = r4.J
            u.e r12 = r12.f15076f
            if (r12 == 0) goto L_0x0065
            r12 = 1
            goto L_0x0066
        L_0x0065:
            r12 = 0
        L_0x0066:
            u.e r13 = r4.K
            u.e r13 = r13.f15076f
            if (r13 == 0) goto L_0x006e
            r13 = 1
            goto L_0x006f
        L_0x006e:
            r13 = 0
        L_0x006f:
            u.e r14 = r4.L
            u.e r14 = r14.f15076f
            if (r14 == 0) goto L_0x0077
            r14 = 1
            goto L_0x0078
        L_0x0077:
            r14 = 0
        L_0x0078:
            u.e r15 = r4.M
            u.e r15 = r15.f15076f
            if (r15 == 0) goto L_0x0080
            r15 = 1
            goto L_0x0081
        L_0x0080:
            r15 = 0
        L_0x0081:
            int r3 = r4.Y
            if (r12 == 0) goto L_0x0199
            if (r13 == 0) goto L_0x0199
            if (r14 == 0) goto L_0x0199
            if (r15 == 0) goto L_0x0199
            float r4 = r4.X
            boolean r10 = r11.f15517j
            int[] r12 = f15522k
            if (r10 == 0) goto L_0x00e2
            boolean r10 = r9.f15517j
            if (r10 == 0) goto L_0x00e2
            boolean r8 = r5.f15510c
            if (r8 == 0) goto L_0x00e1
            boolean r8 = r6.f15510c
            if (r8 != 0) goto L_0x00a0
            goto L_0x00e1
        L_0x00a0:
            java.util.ArrayList r8 = r5.f15519l
            java.lang.Object r8 = r8.get(r2)
            v.f r8 = (v.f) r8
            int r8 = r8.f15514g
            int r5 = r5.f15513f
            int r17 = r8 + r5
            java.util.ArrayList r5 = r6.f15519l
            java.lang.Object r5 = r5.get(r2)
            v.f r5 = (v.f) r5
            int r5 = r5.f15514g
            int r6 = r6.f15513f
            int r18 = r5 - r6
            int r5 = r11.f15514g
            int r6 = r11.f15513f
            int r19 = r5 + r6
            int r5 = r9.f15514g
            int r6 = r9.f15513f
            int r20 = r5 - r6
            r16 = r12
            r21 = r4
            r22 = r3
            m(r16, r17, r18, r19, r20, r21, r22)
            r2 = r12[r2]
            r1.d(r2)
            u.f r1 = r0.f15542b
            v.n r1 = r1.f15088e
            v.g r1 = r1.f15545e
            r2 = r12[r7]
            r1.d(r2)
        L_0x00e1:
            return
        L_0x00e2:
            boolean r10 = r5.f15517j
            java.util.ArrayList r13 = r11.f15519l
            if (r10 == 0) goto L_0x0136
            boolean r10 = r6.f15517j
            if (r10 == 0) goto L_0x0136
            boolean r10 = r11.f15510c
            if (r10 == 0) goto L_0x0135
            boolean r10 = r9.f15510c
            if (r10 != 0) goto L_0x00f5
            goto L_0x0135
        L_0x00f5:
            int r10 = r5.f15514g
            int r14 = r5.f15513f
            int r17 = r10 + r14
            int r10 = r6.f15514g
            int r14 = r6.f15513f
            int r18 = r10 - r14
            java.lang.Object r10 = r13.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r14 = r11.f15513f
            int r19 = r10 + r14
            java.util.ArrayList r10 = r9.f15519l
            java.lang.Object r10 = r10.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r14 = r9.f15513f
            int r20 = r10 - r14
            r16 = r12
            r21 = r4
            r22 = r3
            m(r16, r17, r18, r19, r20, r21, r22)
            r10 = r12[r2]
            r1.d(r10)
            u.f r10 = r0.f15542b
            v.n r10 = r10.f15088e
            v.g r10 = r10.f15545e
            r14 = r12[r7]
            r10.d(r14)
            goto L_0x0136
        L_0x0135:
            return
        L_0x0136:
            boolean r10 = r5.f15510c
            if (r10 == 0) goto L_0x0198
            boolean r10 = r6.f15510c
            if (r10 == 0) goto L_0x0198
            boolean r10 = r11.f15510c
            if (r10 == 0) goto L_0x0198
            boolean r10 = r9.f15510c
            if (r10 != 0) goto L_0x0147
            goto L_0x0198
        L_0x0147:
            java.util.ArrayList r10 = r5.f15519l
            java.lang.Object r10 = r10.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r14 = r5.f15513f
            int r17 = r10 + r14
            java.util.ArrayList r10 = r6.f15519l
            java.lang.Object r10 = r10.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r14 = r6.f15513f
            int r18 = r10 - r14
            java.lang.Object r10 = r13.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r11 = r11.f15513f
            int r19 = r10 + r11
            java.util.ArrayList r10 = r9.f15519l
            java.lang.Object r10 = r10.get(r2)
            v.f r10 = (v.f) r10
            int r10 = r10.f15514g
            int r9 = r9.f15513f
            int r20 = r10 - r9
            r16 = r12
            r21 = r4
            r22 = r3
            m(r16, r17, r18, r19, r20, r21, r22)
            r3 = r12[r2]
            r1.d(r3)
            u.f r3 = r0.f15542b
            v.n r3 = r3.f15088e
            v.g r3 = r3.f15545e
            r4 = r12[r7]
            r3.d(r4)
            goto L_0x027d
        L_0x0198:
            return
        L_0x0199:
            if (r12 == 0) goto L_0x0200
            if (r14 == 0) goto L_0x0200
            boolean r9 = r5.f15510c
            if (r9 == 0) goto L_0x01ff
            boolean r9 = r6.f15510c
            if (r9 != 0) goto L_0x01a6
            goto L_0x01ff
        L_0x01a6:
            float r4 = r4.X
            java.util.ArrayList r9 = r5.f15519l
            java.lang.Object r9 = r9.get(r2)
            v.f r9 = (v.f) r9
            int r9 = r9.f15514g
            int r11 = r5.f15513f
            int r9 = r9 + r11
            java.util.ArrayList r11 = r6.f15519l
            java.lang.Object r11 = r11.get(r2)
            v.f r11 = (v.f) r11
            int r11 = r11.f15514g
            int r12 = r6.f15513f
            int r11 = r11 - r12
            if (r3 == r10) goto L_0x01dd
            if (r3 == 0) goto L_0x01dd
            if (r3 == r7) goto L_0x01ca
            goto L_0x027d
        L_0x01ca:
            int r11 = r11 - r9
            int r3 = r0.g(r11, r2)
            float r9 = (float) r3
            float r9 = r9 / r4
            float r9 = r9 + r8
            int r9 = (int) r9
            int r10 = r0.g(r9, r7)
            if (r9 == r10) goto L_0x01f1
            float r3 = (float) r10
            float r3 = r3 * r4
            goto L_0x01ef
        L_0x01dd:
            int r11 = r11 - r9
            int r3 = r0.g(r11, r2)
            float r9 = (float) r3
            float r9 = r9 * r4
            float r9 = r9 + r8
            int r9 = (int) r9
            int r10 = r0.g(r9, r7)
            if (r9 == r10) goto L_0x01f1
            float r3 = (float) r10
            float r3 = r3 / r4
        L_0x01ef:
            float r3 = r3 + r8
            int r3 = (int) r3
        L_0x01f1:
            r1.d(r3)
            u.f r3 = r0.f15542b
            v.n r3 = r3.f15088e
            v.g r3 = r3.f15545e
            r3.d(r10)
            goto L_0x027d
        L_0x01ff:
            return
        L_0x0200:
            if (r13 == 0) goto L_0x027d
            if (r15 == 0) goto L_0x027d
            boolean r12 = r11.f15510c
            if (r12 == 0) goto L_0x0264
            boolean r12 = r9.f15510c
            if (r12 != 0) goto L_0x020d
            goto L_0x0264
        L_0x020d:
            float r4 = r4.X
            java.util.ArrayList r12 = r11.f15519l
            java.lang.Object r12 = r12.get(r2)
            v.f r12 = (v.f) r12
            int r12 = r12.f15514g
            int r11 = r11.f15513f
            int r12 = r12 + r11
            java.util.ArrayList r11 = r9.f15519l
            java.lang.Object r11 = r11.get(r2)
            v.f r11 = (v.f) r11
            int r11 = r11.f15514g
            int r9 = r9.f15513f
            int r11 = r11 - r9
            if (r3 == r10) goto L_0x0243
            if (r3 == 0) goto L_0x0230
            if (r3 == r7) goto L_0x0243
            goto L_0x027d
        L_0x0230:
            int r11 = r11 - r12
            int r3 = r0.g(r11, r7)
            float r9 = (float) r3
            float r9 = r9 * r4
            float r9 = r9 + r8
            int r9 = (int) r9
            int r10 = r0.g(r9, r2)
            if (r9 == r10) goto L_0x0257
            float r3 = (float) r10
            float r3 = r3 / r4
            goto L_0x0255
        L_0x0243:
            int r11 = r11 - r12
            int r3 = r0.g(r11, r7)
            float r9 = (float) r3
            float r9 = r9 / r4
            float r9 = r9 + r8
            int r9 = (int) r9
            int r10 = r0.g(r9, r2)
            if (r9 == r10) goto L_0x0257
            float r3 = (float) r10
            float r3 = r3 * r4
        L_0x0255:
            float r3 = r3 + r8
            int r3 = (int) r3
        L_0x0257:
            r1.d(r10)
            u.f r4 = r0.f15542b
            v.n r4 = r4.f15088e
            v.g r4 = r4.f15545e
            r4.d(r3)
            goto L_0x027d
        L_0x0264:
            return
        L_0x0265:
            u.f r3 = r4.U
            if (r3 == 0) goto L_0x027d
            v.l r3 = r3.f15086d
            v.g r3 = r3.f15545e
            boolean r9 = r3.f15517j
            if (r9 == 0) goto L_0x027d
            float r4 = r4.f15120x
            int r3 = r3.f15514g
            float r3 = (float) r3
            float r3 = r3 * r4
            float r3 = r3 + r8
            int r3 = (int) r3
            r1.d(r3)
        L_0x027d:
            boolean r3 = r5.f15510c
            if (r3 == 0) goto L_0x0354
            boolean r3 = r6.f15510c
            if (r3 != 0) goto L_0x0287
            goto L_0x0354
        L_0x0287:
            boolean r3 = r5.f15517j
            if (r3 == 0) goto L_0x0294
            boolean r3 = r6.f15517j
            if (r3 == 0) goto L_0x0294
            boolean r3 = r1.f15517j
            if (r3 == 0) goto L_0x0294
            return
        L_0x0294:
            boolean r3 = r1.f15517j
            java.util.ArrayList r4 = r5.f15519l
            java.util.ArrayList r9 = r6.f15519l
            if (r3 != 0) goto L_0x02cf
            int r3 = r0.f15544d
            r10 = 3
            if (r3 != r10) goto L_0x02cf
            u.f r3 = r0.f15542b
            int r10 = r3.f15115s
            if (r10 != 0) goto L_0x02cf
            boolean r3 = r3.x()
            if (r3 != 0) goto L_0x02cf
            java.lang.Object r3 = r4.get(r2)
            v.f r3 = (v.f) r3
            java.lang.Object r2 = r9.get(r2)
            v.f r2 = (v.f) r2
            int r3 = r3.f15514g
            int r4 = r5.f15513f
            int r3 = r3 + r4
            int r2 = r2.f15514g
            int r4 = r6.f15513f
            int r2 = r2 + r4
            int r4 = r2 - r3
            r5.d(r3)
            r6.d(r2)
            r1.d(r4)
            return
        L_0x02cf:
            boolean r3 = r1.f15517j
            if (r3 != 0) goto L_0x0318
            int r3 = r0.f15544d
            r10 = 3
            if (r3 != r10) goto L_0x0318
            int r3 = r0.f15541a
            if (r3 != r7) goto L_0x0318
            int r3 = r4.size()
            if (r3 <= 0) goto L_0x0318
            int r3 = r9.size()
            if (r3 <= 0) goto L_0x0318
            java.lang.Object r3 = r4.get(r2)
            v.f r3 = (v.f) r3
            java.lang.Object r7 = r9.get(r2)
            v.f r7 = (v.f) r7
            int r3 = r3.f15514g
            int r10 = r5.f15513f
            int r3 = r3 + r10
            int r7 = r7.f15514g
            int r10 = r6.f15513f
            int r7 = r7 + r10
            int r7 = r7 - r3
            int r3 = r1.f15520m
            int r3 = java.lang.Math.min(r7, r3)
            u.f r7 = r0.f15542b
            int r10 = r7.f15119w
            int r7 = r7.f15118v
            int r3 = java.lang.Math.max(r7, r3)
            if (r10 <= 0) goto L_0x0315
            int r3 = java.lang.Math.min(r10, r3)
        L_0x0315:
            r1.d(r3)
        L_0x0318:
            boolean r3 = r1.f15517j
            if (r3 != 0) goto L_0x031d
            return
        L_0x031d:
            java.lang.Object r3 = r4.get(r2)
            v.f r3 = (v.f) r3
            java.lang.Object r2 = r9.get(r2)
            v.f r2 = (v.f) r2
            int r4 = r3.f15514g
            int r7 = r5.f15513f
            int r7 = r7 + r4
            int r9 = r2.f15514g
            int r10 = r6.f15513f
            int r10 = r10 + r9
            u.f r11 = r0.f15542b
            float r11 = r11.f15089e0
            if (r3 != r2) goto L_0x033c
            r11 = 1056964608(0x3f000000, float:0.5)
            goto L_0x033e
        L_0x033c:
            r4 = r7
            r9 = r10
        L_0x033e:
            int r9 = r9 - r4
            int r2 = r1.f15514g
            int r9 = r9 - r2
            float r2 = (float) r4
            float r2 = r2 + r8
            float r3 = (float) r9
            float r3 = r3 * r11
            float r3 = r3 + r2
            int r2 = (int) r3
            r5.d(r2)
            int r2 = r5.f15514g
            int r1 = r1.f15514g
            int r2 = r2 + r1
            r6.d(r2)
        L_0x0354:
            return
        L_0x0355:
            u.f r1 = r0.f15542b
            u.e r3 = r1.J
            u.e r1 = r1.L
            r0.l(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.l.a(v.d):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        r0 = r12.f15542b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r12 = this;
            u.f r0 = r12.f15542b
            boolean r1 = r0.f15080a
            v.g r2 = r12.f15545e
            if (r1 == 0) goto L_0x000f
            int r0 = r0.q()
            r2.d(r0)
        L_0x000f:
            boolean r0 = r2.f15517j
            v.f r1 = r12.f15549i
            v.f r3 = r12.f15548h
            r4 = 1
            r5 = 4
            r6 = 3
            r7 = 0
            if (r0 != 0) goto L_0x0076
            u.f r0 = r12.f15542b
            int[] r8 = r0.f15113q0
            r8 = r8[r7]
            r12.f15544d = r8
            if (r8 == r6) goto L_0x00a6
            if (r8 != r5) goto L_0x006c
            u.f r9 = r0.U
            if (r9 == 0) goto L_0x006c
            int[] r10 = r9.f15113q0
            r10 = r10[r7]
            if (r10 == r4) goto L_0x0033
            if (r10 != r5) goto L_0x006c
        L_0x0033:
            int r0 = r9.q()
            u.f r4 = r12.f15542b
            u.e r4 = r4.J
            int r4 = r4.e()
            int r0 = r0 - r4
            u.f r4 = r12.f15542b
            u.e r4 = r4.L
            int r4 = r4.e()
            int r0 = r0 - r4
            v.l r4 = r9.f15086d
            v.f r4 = r4.f15548h
            u.f r5 = r12.f15542b
            u.e r5 = r5.J
            int r5 = r5.e()
            v.q.b(r3, r4, r5)
            v.l r3 = r9.f15086d
            v.f r3 = r3.f15549i
            u.f r4 = r12.f15542b
            u.e r4 = r4.L
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r3, r4)
            r2.d(r0)
            return
        L_0x006c:
            if (r8 != r4) goto L_0x00a6
            int r0 = r0.q()
            r2.d(r0)
            goto L_0x00a6
        L_0x0076:
            int r0 = r12.f15544d
            if (r0 != r5) goto L_0x00a6
            u.f r0 = r12.f15542b
            u.f r8 = r0.U
            if (r8 == 0) goto L_0x00a6
            int[] r9 = r8.f15113q0
            r9 = r9[r7]
            if (r9 == r4) goto L_0x0088
            if (r9 != r5) goto L_0x00a6
        L_0x0088:
            v.l r2 = r8.f15086d
            v.f r2 = r2.f15548h
            u.e r0 = r0.J
            int r0 = r0.e()
            v.q.b(r3, r2, r0)
            v.l r0 = r8.f15086d
            v.f r0 = r0.f15549i
            u.f r2 = r12.f15542b
            u.e r2 = r2.L
            int r2 = r2.e()
            int r2 = -r2
            v.q.b(r1, r0, r2)
            return
        L_0x00a6:
            boolean r0 = r2.f15517j
            if (r0 == 0) goto L_0x0171
            u.f r0 = r12.f15542b
            boolean r8 = r0.f15080a
            if (r8 == 0) goto L_0x0171
            u.e[] r5 = r0.R
            r6 = r5[r7]
            u.e r8 = r6.f15076f
            if (r8 == 0) goto L_0x0111
            r9 = r5[r4]
            u.e r9 = r9.f15076f
            if (r9 == 0) goto L_0x0111
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x00d8
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r7]
            int r0 = r0.e()
            r3.f15513f = r0
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
            goto L_0x0278
        L_0x00d8:
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r7]
            v.f r0 = v.q.h(r0)
            if (r0 == 0) goto L_0x00f1
            u.f r2 = r12.f15542b
            u.e[] r2 = r2.R
            r2 = r2[r7]
            int r2 = r2.e()
            v.q.b(r3, r0, r2)
        L_0x00f1:
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
            v.f r0 = v.q.h(r0)
            if (r0 == 0) goto L_0x010b
            u.f r2 = r12.f15542b
            u.e[] r2 = r2.R
            r2 = r2[r4]
            int r2 = r2.e()
            int r2 = -r2
            v.q.b(r1, r0, r2)
        L_0x010b:
            r3.f15509b = r4
            r1.f15509b = r4
            goto L_0x02ec
        L_0x0111:
            if (r8 == 0) goto L_0x0127
            v.f r0 = v.q.h(r6)
            if (r0 == 0) goto L_0x02ec
            u.f r4 = r12.f15542b
            u.e[] r4 = r4.R
            r4 = r4[r7]
            int r4 = r4.e()
            v.q.b(r3, r0, r4)
            goto L_0x016a
        L_0x0127:
            r5 = r5[r4]
            u.e r6 = r5.f15076f
            if (r6 == 0) goto L_0x0149
            v.f r0 = v.q.h(r5)
            if (r0 == 0) goto L_0x02ec
            u.f r5 = r12.f15542b
            u.e[] r5 = r5.R
            r4 = r5[r4]
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r0, r4)
            int r0 = r2.f15514g
            int r0 = -r0
            v.q.b(r3, r1, r0)
            goto L_0x02ec
        L_0x0149:
            boolean r4 = r0 instanceof u.k
            if (r4 != 0) goto L_0x02ec
            u.f r4 = r0.U
            if (r4 == 0) goto L_0x02ec
            u.d r4 = u.d.CENTER
            u.e r0 = r0.j(r4)
            u.e r0 = r0.f15076f
            if (r0 != 0) goto L_0x02ec
            u.f r0 = r12.f15542b
            u.f r4 = r0.U
            v.l r4 = r4.f15086d
            v.f r4 = r4.f15548h
            int r0 = r0.r()
            v.q.b(r3, r4, r0)
        L_0x016a:
            int r0 = r2.f15514g
            v.q.b(r1, r3, r0)
            goto L_0x02ec
        L_0x0171:
            int r0 = r12.f15544d
            if (r0 != r6) goto L_0x0250
            u.f r0 = r12.f15542b
            int r8 = r0.f15115s
            r9 = 2
            java.util.ArrayList r10 = r2.f15518k
            java.util.ArrayList r11 = r2.f15519l
            if (r8 == r9) goto L_0x0237
            if (r8 == r6) goto L_0x0184
            goto L_0x0250
        L_0x0184:
            int r8 = r0.f15116t
            if (r8 != r6) goto L_0x0202
            r3.f15508a = r12
            r1.f15508a = r12
            v.n r6 = r0.f15088e
            v.f r8 = r6.f15548h
            r8.f15508a = r12
            v.f r6 = r6.f15549i
            r6.f15508a = r12
            r2.f15508a = r12
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x01dc
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            r11.add(r0)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r6 = r0.f15545e
            r6.f15508a = r12
            v.f r0 = r0.f15548h
            r11.add(r0)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.f r0 = r0.f15549i
            r11.add(r0)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.f r0 = r0.f15548h
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.f r0 = r0.f15549i
            java.util.ArrayList r0 = r0.f15518k
            goto L_0x0233
        L_0x01dc:
            u.f r0 = r12.f15542b
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x01f9
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            java.util.ArrayList r0 = r0.f15519l
            r0.add(r2)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            r10.add(r0)
            goto L_0x0250
        L_0x01f9:
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            java.util.ArrayList r0 = r0.f15519l
            goto L_0x0233
        L_0x0202:
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            r11.add(r0)
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.f r0 = r0.f15548h
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            u.f r0 = r12.f15542b
            v.n r0 = r0.f15088e
            v.f r0 = r0.f15549i
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            r2.f15509b = r4
            r10.add(r3)
            r10.add(r1)
            java.util.ArrayList r0 = r3.f15519l
            r0.add(r2)
            java.util.ArrayList r0 = r1.f15519l
        L_0x0233:
            r0.add(r2)
            goto L_0x0250
        L_0x0237:
            u.f r0 = r0.U
            if (r0 != 0) goto L_0x023c
            goto L_0x0250
        L_0x023c:
            v.n r0 = r0.f15088e
            v.g r0 = r0.f15545e
            r11.add(r0)
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            r2.f15509b = r4
            r10.add(r3)
            r10.add(r1)
        L_0x0250:
            u.f r0 = r12.f15542b
            u.e[] r6 = r0.R
            r8 = r6[r7]
            u.e r9 = r8.f15076f
            if (r9 == 0) goto L_0x02a1
            r10 = r6[r4]
            u.e r10 = r10.f15076f
            if (r10 == 0) goto L_0x02a1
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x0280
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r7]
            int r0 = r0.e()
            r3.f15513f = r0
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
        L_0x0278:
            int r0 = r0.e()
            int r0 = -r0
            r1.f15513f = r0
            goto L_0x02ec
        L_0x0280:
            u.f r0 = r12.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r7]
            v.f r0 = v.q.h(r0)
            u.f r1 = r12.f15542b
            u.e[] r1 = r1.R
            r1 = r1[r4]
            v.f r1 = v.q.h(r1)
            if (r0 == 0) goto L_0x0299
            r0.b(r12)
        L_0x0299:
            if (r1 == 0) goto L_0x029e
            r1.b(r12)
        L_0x029e:
            r12.f15550j = r5
            goto L_0x02ec
        L_0x02a1:
            if (r9 == 0) goto L_0x02b7
            v.f r0 = v.q.h(r8)
            if (r0 == 0) goto L_0x02ec
            u.f r5 = r12.f15542b
            u.e[] r5 = r5.R
            r5 = r5[r7]
            int r5 = r5.e()
            v.q.b(r3, r0, r5)
            goto L_0x02e9
        L_0x02b7:
            r5 = r6[r4]
            u.e r6 = r5.f15076f
            if (r6 == 0) goto L_0x02d6
            v.f r0 = v.q.h(r5)
            if (r0 == 0) goto L_0x02ec
            u.f r5 = r12.f15542b
            u.e[] r5 = r5.R
            r4 = r5[r4]
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r0, r4)
            r0 = -1
            r12.c(r3, r1, r0, r2)
            goto L_0x02ec
        L_0x02d6:
            boolean r5 = r0 instanceof u.k
            if (r5 != 0) goto L_0x02ec
            u.f r5 = r0.U
            if (r5 == 0) goto L_0x02ec
            v.l r5 = r5.f15086d
            v.f r5 = r5.f15548h
            int r0 = r0.r()
            v.q.b(r3, r5, r0)
        L_0x02e9:
            r12.c(r1, r3, r4, r2)
        L_0x02ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.l.d():void");
    }

    public final void e() {
        f fVar = this.f15548h;
        if (fVar.f15517j) {
            this.f15542b.Z = fVar.f15514g;
        }
    }

    public final void f() {
        this.f15543c = null;
        this.f15548h.c();
        this.f15549i.c();
        this.f15545e.c();
        this.f15547g = false;
    }

    public final boolean k() {
        return this.f15544d != 3 || this.f15542b.f15115s == 0;
    }

    public final void n() {
        this.f15547g = false;
        f fVar = this.f15548h;
        fVar.c();
        fVar.f15517j = false;
        f fVar2 = this.f15549i;
        fVar2.c();
        fVar2.f15517j = false;
        this.f15545e.f15517j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f15542b.f15097i0;
    }
}
