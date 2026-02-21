package c2;

public final class h {
    private h() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01bb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList a(j1.b0 r27) {
        /*
            r0 = r27
            int r1 = r27.v()
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            r1 = 7
            r0.H(r1)
            int r3 = r27.f()
            r4 = 1684433976(0x64666c38, float:1.7002196E22)
            r5 = 1
            if (r3 != r4) goto L_0x0034
            j1.b0 r3 = new j1.b0
            r3.<init>()
            java.util.zip.Inflater r4 = new java.util.zip.Inflater
            r4.<init>(r5)
            boolean r0 = j1.l0.B(r0, r3, r4)     // Catch:{ all -> 0x002e }
            r4.end()
            if (r0 != 0) goto L_0x002c
            return r2
        L_0x002c:
            r0 = r3
            goto L_0x003a
        L_0x002e:
            r0 = move-exception
            r1 = r0
            r4.end()
            throw r1
        L_0x0034:
            r4 = 1918990112(0x72617720, float:4.465801E30)
            if (r3 == r4) goto L_0x003a
            return r2
        L_0x003a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r0.f8415b
            int r6 = r0.f8416c
        L_0x0043:
            if (r4 >= r6) goto L_0x01bd
            int r7 = r0.f()
            int r7 = r7 + r4
            if (r7 <= r4) goto L_0x01bb
            if (r7 <= r6) goto L_0x0050
            goto L_0x01bb
        L_0x0050:
            int r4 = r0.f()
            r8 = 1835365224(0x6d657368, float:4.438224E27)
            if (r4 != r8) goto L_0x01aa
            int r4 = r0.f()
            r8 = 10000(0x2710, float:1.4013E-41)
            if (r4 <= r8) goto L_0x0062
            goto L_0x007c
        L_0x0062:
            float[] r8 = new float[r4]
            r10 = 0
        L_0x0065:
            if (r10 >= r4) goto L_0x0074
            int r11 = r0.f()
            float r11 = java.lang.Float.intBitsToFloat(r11)
            r8[r10] = r11
            int r10 = r10 + 1
            goto L_0x0065
        L_0x0074:
            int r10 = r0.f()
            r11 = 32000(0x7d00, float:4.4842E-41)
            if (r10 <= r11) goto L_0x0084
        L_0x007c:
            r27 = r3
        L_0x007e:
            r19 = r6
        L_0x0080:
            r20 = 1
            goto L_0x017b
        L_0x0084:
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r13 = java.lang.Math.log(r11)
            r27 = r3
            double r2 = (double) r4
            double r2 = r2 * r11
            double r2 = java.lang.Math.log(r2)
            double r2 = r2 / r13
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            j1.a0 r3 = new j1.a0
            byte[] r9 = r0.f8414a
            int r15 = r9.length
            r3.<init>(r15, r9)
            int r9 = r0.f8415b
            r15 = 8
            int r9 = r9 * 8
            r3.k(r9)
            int r9 = r10 * 5
            float[] r9 = new float[r9]
            r11 = 5
            int[] r12 = new int[r11]
            r15 = 0
            r18 = 0
        L_0x00b4:
            if (r15 >= r10) goto L_0x00e0
            r1 = 0
        L_0x00b7:
            if (r1 >= r11) goto L_0x00db
            r19 = r12[r1]
            int r20 = r3.g(r2)
            int r21 = r20 >> 1
            r11 = r20 & 1
            int r11 = -r11
            r11 = r11 ^ r21
            int r11 = r11 + r19
            if (r11 >= r4) goto L_0x007e
            if (r11 >= 0) goto L_0x00cd
            goto L_0x0109
        L_0x00cd:
            int r19 = r18 + 1
            r20 = r8[r11]
            r9[r18] = r20
            r12[r1] = r11
            int r1 = r1 + 1
            r18 = r19
            r11 = 5
            goto L_0x00b7
        L_0x00db:
            int r15 = r15 + 1
            r1 = 7
            r11 = 5
            goto L_0x00b4
        L_0x00e0:
            int r1 = r3.e()
            r2 = 7
            int r1 = r1 + r2
            r1 = r1 & -8
            r3.k(r1)
            r1 = 32
            int r4 = r3.g(r1)
            androidx.activity.result.j[] r8 = new androidx.activity.result.j[r4]
            r11 = 0
        L_0x00f4:
            if (r11 >= r4) goto L_0x0198
            r12 = 8
            int r15 = r3.g(r12)
            int r2 = r3.g(r12)
            int r12 = r3.g(r1)
            r1 = 128000(0x1f400, float:1.79366E-40)
            if (r12 <= r1) goto L_0x010b
        L_0x0109:
            goto L_0x007e
        L_0x010b:
            r19 = r6
            double r5 = (double) r10
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = r5 * r16
            double r5 = java.lang.Math.log(r5)
            double r5 = r5 / r13
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            int r6 = r12 * 3
            float[] r6 = new float[r6]
            int r1 = r12 * 2
            float[] r1 = new float[r1]
            r21 = r1
            r1 = 0
            r22 = 0
        L_0x0129:
            if (r1 >= r12) goto L_0x017d
            int r23 = r3.g(r5)
            int r24 = r23 >> 1
            r25 = r3
            r20 = 1
            r3 = r23 & 1
            r23 = r4
            r4 = r21
            int r3 = -r3
            r3 = r3 ^ r24
            int r3 = r3 + r22
            if (r3 < 0) goto L_0x0080
            if (r3 < r10) goto L_0x0146
            goto L_0x0080
        L_0x0146:
            int r21 = r1 * 3
            int r22 = r3 * 5
            r24 = r9[r22]
            r6[r21] = r24
            int r24 = r21 + 1
            int r26 = r22 + 1
            r26 = r9[r26]
            r6[r24] = r26
            int r21 = r21 + 2
            int r24 = r22 + 2
            r24 = r9[r24]
            r6[r21] = r24
            int r21 = r1 * 2
            int r24 = r22 + 3
            r24 = r9[r24]
            r4[r21] = r24
            r20 = 1
            int r21 = r21 + 1
            int r22 = r22 + 4
            r22 = r9[r22]
            r4[r21] = r22
            int r1 = r1 + 1
            r22 = r3
            r21 = r4
            r4 = r23
            r3 = r25
            goto L_0x0129
        L_0x017b:
            r1 = 0
            goto L_0x01a1
        L_0x017d:
            r25 = r3
            r23 = r4
            r4 = r21
            r20 = 1
            androidx.activity.result.j r1 = new androidx.activity.result.j
            r1.<init>((int) r15, (float[]) r6, (float[]) r4, (int) r2)
            r8[r11] = r1
            int r11 = r11 + 1
            r6 = r19
            r4 = r23
            r1 = 32
            r2 = 7
            r5 = 1
            goto L_0x00f4
        L_0x0198:
            r19 = r6
            r20 = 1
            c2.f r1 = new c2.f
            r1.<init>(r8)
        L_0x01a1:
            if (r1 != 0) goto L_0x01a4
            goto L_0x01bb
        L_0x01a4:
            r2 = r27
            r2.add(r1)
            goto L_0x01af
        L_0x01aa:
            r2 = r3
            r19 = r6
            r20 = 1
        L_0x01af:
            r0.G(r7)
            r3 = r2
            r4 = r7
            r6 = r19
            r1 = 7
            r2 = 0
            r5 = 1
            goto L_0x0043
        L_0x01bb:
            r2 = 0
            goto L_0x01be
        L_0x01bd:
            r2 = r3
        L_0x01be:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.h.a(j1.b0):java.util.ArrayList");
    }
}
