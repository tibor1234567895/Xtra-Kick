package androidx.recyclerview.widget;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s f1929a = new s();

    private a0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0124, code lost:
        r11 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.recyclerview.widget.v a(androidx.recyclerview.widget.t r20) {
        /*
            r0 = r20
            int r1 = r20.e()
            int r2 = r20.d()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            androidx.recyclerview.widget.y r5 = new androidx.recyclerview.widget.y
            r5.<init>(r1, r2)
            r4.add(r5)
            int r1 = r1 + r2
            r2 = 1
            int r1 = r1 + r2
            int r1 = r1 / 2
            j0.h r5 = new j0.h
            int r1 = r1 * 2
            int r1 = r1 + r2
            r5.<init>((int) r1)
            j0.h r6 = new j0.h
            r6.<init>((int) r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0033:
            boolean r7 = r4.isEmpty()
            if (r7 != 0) goto L_0x025d
            int r7 = r4.size()
            int r7 = r7 - r2
            java.lang.Object r7 = r4.remove(r7)
            androidx.recyclerview.widget.y r7 = (androidx.recyclerview.widget.y) r7
            int r8 = r7.f2246b
            int r9 = r7.f2245a
            int r10 = r8 - r9
            if (r10 < r2) goto L_0x01c1
            int r13 = r7.f2248d
            int r14 = r7.f2247c
            int r13 = r13 - r14
            if (r13 >= r2) goto L_0x0055
            goto L_0x01c1
        L_0x0055:
            int r13 = r13 + r10
            int r13 = r13 + r2
            int r13 = r13 / 2
            java.lang.Object r10 = r5.f8396i
            int[] r10 = (int[]) r10
            int r14 = r5.f8395h
            int r14 = r14 + r2
            r10[r14] = r9
            java.lang.Object r9 = r6.f8396i
            int[] r9 = (int[]) r9
            int r10 = r6.f8395h
            int r10 = r10 + r2
            r9[r10] = r8
            r8 = 0
        L_0x006c:
            if (r8 >= r13) goto L_0x01c1
            int r9 = r7.f2246b
            int r10 = r7.f2245a
            int r9 = r9 - r10
            int r10 = r7.f2248d
            int r14 = r7.f2247c
            int r10 = r10 - r14
            int r9 = r9 - r10
            int r9 = java.lang.Math.abs(r9)
            int r9 = r9 % 2
            if (r9 != r2) goto L_0x0083
            r9 = 1
            goto L_0x0084
        L_0x0083:
            r9 = 0
        L_0x0084:
            int r10 = r7.f2246b
            int r14 = r7.f2245a
            int r10 = r10 - r14
            int r14 = r7.f2248d
            int r15 = r7.f2247c
            int r14 = r14 - r15
            int r10 = r10 - r14
            int r14 = -r8
            r15 = r14
        L_0x0091:
            if (r15 > r8) goto L_0x011a
            if (r15 == r14) goto L_0x00af
            if (r15 == r8) goto L_0x00a6
            int r11 = r15 + 1
            int r11 = r5.j(r11)
            int r2 = r15 + -1
            int r2 = r5.j(r2)
            if (r11 <= r2) goto L_0x00a6
            goto L_0x00af
        L_0x00a6:
            int r2 = r15 + -1
            int r2 = r5.j(r2)
            int r11 = r2 + 1
            goto L_0x00b6
        L_0x00af:
            int r2 = r15 + 1
            int r2 = r5.j(r2)
            r11 = r2
        L_0x00b6:
            int r12 = r7.f2247c
            r16 = r13
            int r13 = r7.f2245a
            int r13 = r11 - r13
            int r13 = r13 + r12
            int r13 = r13 - r15
            if (r8 == 0) goto L_0x00ca
            if (r11 == r2) goto L_0x00c5
            goto L_0x00ca
        L_0x00c5:
            int r12 = r13 + -1
            r17 = r4
            goto L_0x00cd
        L_0x00ca:
            r17 = r4
            r12 = r13
        L_0x00cd:
            int r4 = r7.f2246b
            if (r11 >= r4) goto L_0x00e0
            int r4 = r7.f2248d
            if (r13 >= r4) goto L_0x00e0
            boolean r4 = r0.b(r11, r13)
            if (r4 == 0) goto L_0x00e0
            int r11 = r11 + 1
            int r13 = r13 + 1
            goto L_0x00cd
        L_0x00e0:
            java.lang.Object r4 = r5.f8396i
            int[] r4 = (int[]) r4
            r18 = r1
            int r1 = r5.f8395h
            int r1 = r1 + r15
            r4[r1] = r11
            if (r9 == 0) goto L_0x010e
            int r1 = r10 - r15
            int r4 = r14 + 1
            if (r1 < r4) goto L_0x010e
            int r4 = r8 + -1
            if (r1 > r4) goto L_0x010e
            int r1 = r6.j(r1)
            if (r1 > r11) goto L_0x010e
            androidx.recyclerview.widget.z r1 = new androidx.recyclerview.widget.z
            r1.<init>()
            r1.f2265a = r2
            r1.f2266b = r12
            r1.f2267c = r11
            r1.f2268d = r13
            r2 = 0
            r1.f2269e = r2
            goto L_0x0122
        L_0x010e:
            r2 = 0
            int r15 = r15 + 2
            r13 = r16
            r4 = r17
            r1 = r18
            r2 = 1
            goto L_0x0091
        L_0x011a:
            r18 = r1
            r17 = r4
            r16 = r13
            r2 = 0
            r1 = 0
        L_0x0122:
            if (r1 == 0) goto L_0x0127
        L_0x0124:
            r11 = r1
            goto L_0x01c6
        L_0x0127:
            int r1 = r7.f2246b
            int r4 = r7.f2245a
            int r1 = r1 - r4
            int r4 = r7.f2248d
            int r9 = r7.f2247c
            int r4 = r4 - r9
            int r1 = r1 - r4
            int r4 = r1 % 2
            if (r4 != 0) goto L_0x0138
            r4 = 1
            goto L_0x0139
        L_0x0138:
            r4 = 0
        L_0x0139:
            r9 = r14
        L_0x013a:
            if (r9 > r8) goto L_0x01b1
            if (r9 == r14) goto L_0x0158
            if (r9 == r8) goto L_0x014f
            int r10 = r9 + 1
            int r10 = r6.j(r10)
            int r11 = r9 + -1
            int r11 = r6.j(r11)
            if (r10 >= r11) goto L_0x014f
            goto L_0x0158
        L_0x014f:
            int r10 = r9 + -1
            int r10 = r6.j(r10)
            int r11 = r10 + -1
            goto L_0x015f
        L_0x0158:
            int r10 = r9 + 1
            int r10 = r6.j(r10)
            r11 = r10
        L_0x015f:
            int r12 = r7.f2248d
            int r13 = r7.f2246b
            int r13 = r13 - r11
            int r13 = r13 - r9
            int r12 = r12 - r13
            if (r8 == 0) goto L_0x016e
            if (r11 == r10) goto L_0x016b
            goto L_0x016e
        L_0x016b:
            int r13 = r12 + 1
            goto L_0x016f
        L_0x016e:
            r13 = r12
        L_0x016f:
            int r15 = r7.f2245a
            if (r11 <= r15) goto L_0x0185
            int r15 = r7.f2247c
            if (r12 <= r15) goto L_0x0185
            int r15 = r11 + -1
            int r2 = r12 + -1
            boolean r19 = r0.b(r15, r2)
            if (r19 == 0) goto L_0x0185
            r12 = r2
            r11 = r15
            r2 = 0
            goto L_0x016f
        L_0x0185:
            java.lang.Object r2 = r6.f8396i
            int[] r2 = (int[]) r2
            int r15 = r6.f8395h
            int r15 = r15 + r9
            r2[r15] = r11
            if (r4 == 0) goto L_0x01ad
            int r2 = r1 - r9
            if (r2 < r14) goto L_0x01ad
            if (r2 > r8) goto L_0x01ad
            int r2 = r5.j(r2)
            if (r2 < r11) goto L_0x01ad
            androidx.recyclerview.widget.z r1 = new androidx.recyclerview.widget.z
            r1.<init>()
            r1.f2265a = r11
            r1.f2266b = r12
            r1.f2267c = r10
            r1.f2268d = r13
            r2 = 1
            r1.f2269e = r2
            goto L_0x01b2
        L_0x01ad:
            int r9 = r9 + 2
            r2 = 0
            goto L_0x013a
        L_0x01b1:
            r1 = 0
        L_0x01b2:
            if (r1 == 0) goto L_0x01b6
            goto L_0x0124
        L_0x01b6:
            int r8 = r8 + 1
            r13 = r16
            r4 = r17
            r1 = r18
            r2 = 1
            goto L_0x006c
        L_0x01c1:
            r18 = r1
            r17 = r4
            r11 = 0
        L_0x01c6:
            if (r11 == 0) goto L_0x0251
            int r1 = r11.a()
            if (r1 <= 0) goto L_0x020b
            int r1 = r11.f2268d
            int r2 = r11.f2266b
            int r1 = r1 - r2
            int r4 = r11.f2267c
            int r8 = r11.f2265a
            int r4 = r4 - r8
            if (r1 == r4) goto L_0x01dc
            r9 = 1
            goto L_0x01dd
        L_0x01dc:
            r9 = 0
        L_0x01dd:
            if (r9 == 0) goto L_0x0203
            boolean r9 = r11.f2269e
            if (r9 == 0) goto L_0x01ed
            androidx.recyclerview.widget.u r1 = new androidx.recyclerview.widget.u
            int r4 = r11.a()
            r1.<init>(r8, r2, r4)
            goto L_0x0208
        L_0x01ed:
            if (r1 <= r4) goto L_0x01f1
            r12 = 1
            goto L_0x01f2
        L_0x01f1:
            r12 = 0
        L_0x01f2:
            androidx.recyclerview.widget.u r1 = new androidx.recyclerview.widget.u
            if (r12 == 0) goto L_0x01f9
            int r2 = r2 + 1
            goto L_0x01fb
        L_0x01f9:
            int r8 = r8 + 1
        L_0x01fb:
            int r4 = r11.a()
            r1.<init>(r8, r2, r4)
            goto L_0x0208
        L_0x0203:
            androidx.recyclerview.widget.u r1 = new androidx.recyclerview.widget.u
            r1.<init>(r8, r2, r4)
        L_0x0208:
            r3.add(r1)
        L_0x020b:
            boolean r1 = r18.isEmpty()
            if (r1 == 0) goto L_0x021a
            androidx.recyclerview.widget.y r1 = new androidx.recyclerview.widget.y
            r1.<init>()
            r4 = r18
            r2 = 1
            goto L_0x0228
        L_0x021a:
            int r1 = r18.size()
            r2 = 1
            int r1 = r1 - r2
            r4 = r18
            java.lang.Object r1 = r4.remove(r1)
            androidx.recyclerview.widget.y r1 = (androidx.recyclerview.widget.y) r1
        L_0x0228:
            int r8 = r7.f2245a
            r1.f2245a = r8
            int r8 = r7.f2247c
            r1.f2247c = r8
            int r8 = r11.f2265a
            r1.f2246b = r8
            int r8 = r11.f2266b
            r1.f2248d = r8
            r8 = r17
            r8.add(r1)
            int r1 = r7.f2246b
            r7.f2246b = r1
            int r1 = r7.f2248d
            r7.f2248d = r1
            int r1 = r11.f2267c
            r7.f2245a = r1
            int r1 = r11.f2268d
            r7.f2247c = r1
            r8.add(r7)
            goto L_0x0259
        L_0x0251:
            r8 = r17
            r4 = r18
            r2 = 1
            r4.add(r7)
        L_0x0259:
            r1 = r4
            r4 = r8
            goto L_0x0033
        L_0x025d:
            androidx.recyclerview.widget.s r1 = f1929a
            java.util.Collections.sort(r3, r1)
            androidx.recyclerview.widget.v r1 = new androidx.recyclerview.widget.v
            java.lang.Object r2 = r5.f8396i
            int[] r2 = (int[]) r2
            java.lang.Object r4 = r6.f8396i
            int[] r4 = (int[]) r4
            r1.<init>(r0, r3, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a0.a(androidx.recyclerview.widget.t):androidx.recyclerview.widget.v");
    }
}
