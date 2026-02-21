package y2;

import j1.b0;
import java.util.List;
import w2.c;

public final class a extends c {

    /* renamed from: m  reason: collision with root package name */
    public final h f16875m;

    public a(List list) {
        b0 b0Var = new b0((byte[]) list.get(0));
        this.f16875m = new h(b0Var.A(), b0Var.A());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: y2.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: y2.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: y2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: y2.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: y2.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: y2.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: y2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: y2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: y2.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: y2.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: y2.c} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a9, code lost:
        r5.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0248, code lost:
        if ((r4.f11920c + 1) == r2.f16916g.getHeight()) goto L_0x025d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.d f(byte[] r32, int r33, boolean r34) {
        /*
            r31 = this;
            r0 = 0
            r1 = r31
            y2.h r2 = r1.f16875m
            if (r34 == 0) goto L_0x0026
            y2.g r3 = r2.f16915f
            android.util.SparseArray r4 = r3.f16900c
            r4.clear()
            android.util.SparseArray r4 = r3.f16901d
            r4.clear()
            android.util.SparseArray r4 = r3.f16902e
            r4.clear()
            android.util.SparseArray r4 = r3.f16903f
            r4.clear()
            android.util.SparseArray r4 = r3.f16904g
            r4.clear()
            r3.f16905h = r0
            r3.f16906i = r0
        L_0x0026:
            x2.j r3 = new x2.j
            r2.getClass()
            j1.a0 r4 = new j1.a0
            r5 = r32
            r6 = r33
            r4.<init>(r6, r5)
        L_0x0034:
            int r5 = r4.b()
            r6 = 2
            r7 = 3
            r9 = 1
            r10 = 48
            y2.g r11 = r2.f16915f
            if (r5 < r10) goto L_0x021c
            r5 = 8
            int r10 = r4.g(r5)
            r12 = 15
            if (r10 != r12) goto L_0x021c
            int r10 = r4.g(r5)
            r12 = 16
            int r13 = r4.g(r12)
            int r14 = r4.g(r12)
            int r15 = r4.d()
            int r15 = r15 + r14
            int r0 = r14 * 8
            int r8 = r4.b()
            if (r0 <= r8) goto L_0x0076
            java.lang.String r0 = "DvbParser"
            java.lang.String r5 = "Data field length exceeds limit"
            j1.v.g(r0, r5)
            int r0 = r4.b()
            r4.m(r0)
            goto L_0x0219
        L_0x0076:
            r0 = 4
            switch(r10) {
                case 16: goto L_0x01ad;
                case 17: goto L_0x00f2;
                case 18: goto L_0x00d9;
                case 19: goto L_0x00c0;
                case 20: goto L_0x007c;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x0211
        L_0x007c:
            int r5 = r11.f16898a
            if (r13 != r5) goto L_0x0211
            r4.m(r0)
            boolean r0 = r4.f()
            r4.m(r7)
            int r17 = r4.g(r12)
            int r18 = r4.g(r12)
            if (r0 == 0) goto L_0x00ad
            int r8 = r4.g(r12)
            int r0 = r4.g(r12)
            int r5 = r4.g(r12)
            int r6 = r4.g(r12)
            r20 = r0
            r21 = r5
            r22 = r6
            r19 = r8
            goto L_0x00b5
        L_0x00ad:
            r20 = r17
            r22 = r18
            r19 = 0
            r21 = 0
        L_0x00b5:
            o1.g0 r0 = new o1.g0
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r11.f16905h = r0
            goto L_0x0211
        L_0x00c0:
            int r0 = r11.f16898a
            if (r13 != r0) goto L_0x00cb
            y2.c r0 = y2.h.f(r4)
            android.util.SparseArray r5 = r11.f16902e
            goto L_0x00d5
        L_0x00cb:
            int r0 = r11.f16899b
            if (r13 != r0) goto L_0x0211
            y2.c r0 = y2.h.f(r4)
            android.util.SparseArray r5 = r11.f16904g
        L_0x00d5:
            int r6 = r0.f16880a
            goto L_0x01a9
        L_0x00d9:
            int r0 = r11.f16898a
            if (r13 != r0) goto L_0x00e4
            y2.b r0 = y2.h.e(r4, r14)
            android.util.SparseArray r5 = r11.f16901d
            goto L_0x00ee
        L_0x00e4:
            int r0 = r11.f16899b
            if (r13 != r0) goto L_0x0211
            y2.b r0 = y2.h.e(r4, r14)
            android.util.SparseArray r5 = r11.f16903f
        L_0x00ee:
            int r6 = r0.f16876a
            goto L_0x01a9
        L_0x00f2:
            d2.r0 r8 = r11.f16906i
            int r10 = r11.f16898a
            if (r13 != r10) goto L_0x0211
            if (r8 == 0) goto L_0x0211
            int r10 = r4.g(r5)
            r4.m(r0)
            boolean r18 = r4.f()
            r4.m(r7)
            int r19 = r4.g(r12)
            int r20 = r4.g(r12)
            r4.g(r7)
            int r21 = r4.g(r7)
            r4.m(r6)
            int r22 = r4.g(r5)
            int r23 = r4.g(r5)
            int r24 = r4.g(r0)
            int r25 = r4.g(r6)
            r4.m(r6)
            int r14 = r14 + -10
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
        L_0x0134:
            if (r14 <= 0) goto L_0x016e
            int r13 = r4.g(r12)
            int r12 = r4.g(r6)
            r4.g(r6)
            r5 = 12
            int r6 = r4.g(r5)
            r4.m(r0)
            int r5 = r4.g(r5)
            int r14 = r14 + -6
            if (r12 == r9) goto L_0x0155
            r9 = 2
            if (r12 != r9) goto L_0x015f
        L_0x0155:
            r9 = 8
            r4.g(r9)
            r4.g(r9)
            int r14 = r14 + -2
        L_0x015f:
            y2.f r9 = new y2.f
            r9.<init>(r6, r5)
            r7.put(r13, r9)
            r5 = 8
            r6 = 2
            r9 = 1
            r12 = 16
            goto L_0x0134
        L_0x016e:
            y2.e r0 = new y2.e
            r16 = r0
            r17 = r10
            r26 = r7
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r5 = r8.f4292e
            android.util.SparseArray r6 = r11.f16900c
            if (r5 != 0) goto L_0x01a2
            java.lang.Object r5 = r6.get(r10)
            y2.e r5 = (y2.e) r5
            if (r5 == 0) goto L_0x01a2
            r8 = 0
        L_0x0188:
            android.util.SparseArray r7 = r5.f16895j
            int r9 = r7.size()
            if (r8 >= r9) goto L_0x01a2
            int r9 = r7.keyAt(r8)
            java.lang.Object r7 = r7.valueAt(r8)
            y2.f r7 = (y2.f) r7
            android.util.SparseArray r10 = r0.f16895j
            r10.put(r9, r7)
            int r8 = r8 + 1
            goto L_0x0188
        L_0x01a2:
            int r5 = r0.f16886a
            r30 = r6
            r6 = r5
            r5 = r30
        L_0x01a9:
            r5.put(r6, r0)
            goto L_0x0211
        L_0x01ad:
            int r5 = r11.f16898a
            if (r13 != r5) goto L_0x0211
            d2.r0 r5 = r11.f16906i
            r6 = 8
            int r7 = r4.g(r6)
            int r0 = r4.g(r0)
            r8 = 2
            int r9 = r4.g(r8)
            r4.m(r8)
            int r14 = r14 + -2
            android.util.SparseArray r8 = new android.util.SparseArray
            r8.<init>()
        L_0x01cc:
            if (r14 <= 0) goto L_0x01ec
            int r10 = r4.g(r6)
            r4.m(r6)
            r12 = 16
            int r13 = r4.g(r12)
            int r6 = r4.g(r12)
            int r14 = r14 + -6
            y2.d r12 = new y2.d
            r12.<init>(r13, r6)
            r8.put(r10, r12)
            r6 = 8
            goto L_0x01cc
        L_0x01ec:
            d2.r0 r6 = new d2.r0
            r6.<init>((int) r7, (int) r0, (int) r9, (android.util.SparseArray) r8)
            int r0 = r6.f4292e
            if (r0 == 0) goto L_0x0207
            r11.f16906i = r6
            android.util.SparseArray r0 = r11.f16900c
            r0.clear()
            android.util.SparseArray r0 = r11.f16901d
            r0.clear()
            android.util.SparseArray r0 = r11.f16902e
            r0.clear()
            goto L_0x0211
        L_0x0207:
            if (r5 == 0) goto L_0x0211
            int r0 = r5.f4291d
            int r5 = r6.f4291d
            if (r0 == r5) goto L_0x0211
            r11.f16906i = r6
        L_0x0211:
            int r0 = r4.d()
            int r15 = r15 - r0
            r4.n(r15)
        L_0x0219:
            r0 = 0
            goto L_0x0034
        L_0x021c:
            d2.r0 r0 = r11.f16906i
            if (r0 != 0) goto L_0x0228
            java.util.List r0 = java.util.Collections.emptyList()
            r1 = r3
        L_0x0225:
            r2 = 1
            goto L_0x03e6
        L_0x0228:
            o1.g0 r4 = r11.f16905h
            if (r4 == 0) goto L_0x022d
            goto L_0x022f
        L_0x022d:
            o1.g0 r4 = r2.f16913d
        L_0x022f:
            android.graphics.Bitmap r5 = r2.f16916g
            android.graphics.Canvas r6 = r2.f16912c
            if (r5 == 0) goto L_0x024b
            int r8 = r4.f11919b
            r9 = 1
            int r8 = r8 + r9
            int r5 = r5.getWidth()
            if (r8 != r5) goto L_0x024c
            int r5 = r4.f11920c
            int r5 = r5 + r9
            android.graphics.Bitmap r8 = r2.f16916g
            int r8 = r8.getHeight()
            if (r5 == r8) goto L_0x025d
            goto L_0x024c
        L_0x024b:
            r9 = 1
        L_0x024c:
            int r5 = r4.f11919b
            int r5 = r5 + r9
            int r8 = r4.f11920c
            int r8 = r8 + r9
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r8, r9)
            r2.f16916g = r5
            r6.setBitmap(r5)
        L_0x025d:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Cloneable r0 = r0.f4289b
            android.util.SparseArray r0 = (android.util.SparseArray) r0
            r8 = 0
        L_0x0267:
            int r9 = r0.size()
            if (r8 >= r9) goto L_0x03db
            r6.save()
            java.lang.Object r9 = r0.valueAt(r8)
            y2.d r9 = (y2.d) r9
            int r10 = r0.keyAt(r8)
            android.util.SparseArray r12 = r11.f16900c
            java.lang.Object r10 = r12.get(r10)
            y2.e r10 = (y2.e) r10
            int r12 = r9.f16884a
            int r13 = r4.f11921d
            int r12 = r12 + r13
            int r9 = r9.f16885b
            int r13 = r4.f11923f
            int r9 = r9 + r13
            int r13 = r10.f16888c
            int r13 = r13 + r12
            int r14 = r4.f11922e
            int r13 = java.lang.Math.min(r13, r14)
            int r14 = r10.f16889d
            int r15 = r9 + r14
            int r7 = r4.f11924g
            int r7 = java.lang.Math.min(r15, r7)
            r6.clipRect(r12, r9, r13, r7)
            android.util.SparseArray r7 = r11.f16901d
            int r13 = r10.f16891f
            java.lang.Object r7 = r7.get(r13)
            y2.b r7 = (y2.b) r7
            if (r7 != 0) goto L_0x02ba
            android.util.SparseArray r7 = r11.f16903f
            java.lang.Object r7 = r7.get(r13)
            y2.b r7 = (y2.b) r7
            if (r7 != 0) goto L_0x02ba
            y2.b r7 = r2.f16914e
        L_0x02ba:
            r34 = r0
            r13 = 0
        L_0x02bd:
            android.util.SparseArray r0 = r10.f16895j
            int r1 = r0.size()
            if (r13 >= r1) goto L_0x0345
            int r1 = r0.keyAt(r13)
            java.lang.Object r0 = r0.valueAt(r13)
            y2.f r0 = (y2.f) r0
            r25 = r3
            android.util.SparseArray r3 = r11.f16902e
            java.lang.Object r3 = r3.get(r1)
            y2.c r3 = (y2.c) r3
            if (r3 != 0) goto L_0x02e4
            android.util.SparseArray r3 = r11.f16904g
            java.lang.Object r1 = r3.get(r1)
            r3 = r1
            y2.c r3 = (y2.c) r3
        L_0x02e4:
            if (r3 == 0) goto L_0x032d
            boolean r1 = r3.f16881b
            if (r1 == 0) goto L_0x02ee
            r26 = r11
            r1 = 0
            goto L_0x02f2
        L_0x02ee:
            android.graphics.Paint r1 = r2.f16910a
            r26 = r11
        L_0x02f2:
            int r11 = r10.f16890e
            r27 = r8
            int r8 = r0.f16896a
            int r8 = r8 + r12
            int r0 = r0.f16897b
            int r0 = r0 + r9
            r28 = r5
            r5 = 3
            if (r11 != r5) goto L_0x0306
            int[] r5 = r7.f16879d
        L_0x0303:
            r29 = r4
            goto L_0x030f
        L_0x0306:
            r5 = 2
            if (r11 != r5) goto L_0x030c
            int[] r5 = r7.f16878c
            goto L_0x0303
        L_0x030c:
            int[] r5 = r7.f16877b
            goto L_0x0303
        L_0x030f:
            byte[] r4 = r3.f16882c
            r18 = r4
            r19 = r5
            r20 = r11
            r21 = r8
            r22 = r0
            r23 = r1
            r24 = r6
            y2.h.d(r18, r19, r20, r21, r22, r23, r24)
            byte[] r3 = r3.f16883d
            r4 = 1
            int r22 = r0 + 1
            r18 = r3
            y2.h.d(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x0335
        L_0x032d:
            r29 = r4
            r28 = r5
            r27 = r8
            r26 = r11
        L_0x0335:
            int r13 = r13 + 1
            r1 = r31
            r3 = r25
            r11 = r26
            r8 = r27
            r5 = r28
            r4 = r29
            goto L_0x02bd
        L_0x0345:
            r25 = r3
            r29 = r4
            r28 = r5
            r27 = r8
            r26 = r11
            boolean r0 = r10.f16887b
            int r1 = r10.f16888c
            if (r0 == 0) goto L_0x038d
            int r0 = r10.f16890e
            r3 = 3
            if (r0 != r3) goto L_0x0362
            int[] r0 = r7.f16879d
            int r4 = r10.f16892g
            r0 = r0[r4]
            r4 = 2
            goto L_0x0372
        L_0x0362:
            r4 = 2
            if (r0 != r4) goto L_0x036c
            int[] r0 = r7.f16878c
            int r5 = r10.f16893h
            r0 = r0[r5]
            goto L_0x0372
        L_0x036c:
            int[] r0 = r7.f16877b
            int r5 = r10.f16894i
            r0 = r0[r5]
        L_0x0372:
            android.graphics.Paint r5 = r2.f16911b
            r5.setColor(r0)
            float r0 = (float) r12
            float r7 = (float) r9
            int r8 = r12 + r1
            float r8 = (float) r8
            float r10 = (float) r15
            r18 = r6
            r19 = r0
            r20 = r7
            r21 = r8
            r22 = r10
            r23 = r5
            r18.drawRect(r19, r20, r21, r22, r23)
            goto L_0x038f
        L_0x038d:
            r3 = 3
            r4 = 2
        L_0x038f:
            i1.a r0 = new i1.a
            r0.<init>()
            android.graphics.Bitmap r5 = r2.f16916g
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r12, r9, r1, r14)
            r0.f7954b = r5
            float r5 = (float) r12
            r7 = r29
            int r8 = r7.f11919b
            float r8 = (float) r8
            float r5 = r5 / r8
            r0.f7960h = r5
            r5 = 0
            r0.f7961i = r5
            float r9 = (float) r9
            int r10 = r7.f11920c
            float r10 = (float) r10
            float r9 = r9 / r10
            r0.f7957e = r9
            r0.f7958f = r5
            r0.f7959g = r5
            float r1 = (float) r1
            float r1 = r1 / r8
            r0.f7964l = r1
            float r1 = (float) r14
            float r1 = r1 / r10
            r0.f7965m = r1
            i1.b r0 = r0.a()
            r1 = r28
            r1.add(r0)
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.CLEAR
            r6.drawColor(r5, r0)
            r6.restore()
            int r8 = r27 + 1
            r0 = r34
            r5 = r1
            r4 = r7
            r3 = r25
            r11 = r26
            r7 = 3
            r1 = r31
            goto L_0x0267
        L_0x03db:
            r25 = r3
            r1 = r5
            java.util.List r0 = java.util.Collections.unmodifiableList(r1)
            r1 = r25
            goto L_0x0225
        L_0x03e6:
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.f(byte[], int, boolean):w2.d");
    }
}
