package f3;

import android.util.SparseArray;
import android.util.SparseIntArray;
import d2.y;
import j1.a0;
import j1.h0;

public final class g0 implements d0 {

    /* renamed from: h  reason: collision with root package name */
    public final a0 f5582h = new a0(5, new byte[5]);

    /* renamed from: i  reason: collision with root package name */
    public final SparseArray f5583i = new SparseArray();

    /* renamed from: j  reason: collision with root package name */
    public final SparseIntArray f5584j = new SparseIntArray();

    /* renamed from: k  reason: collision with root package name */
    public final int f5585k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ h0 f5586l;

    public g0(h0 h0Var, int i10) {
        this.f5586l = h0Var;
        this.f5585k = i10;
    }

    public final void b(h0 h0Var, y yVar, j0 j0Var) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0145, code lost:
        if (r27.v() == 21) goto L_0x0147;
     */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            int r2 = r27.v()
            r3 = 2
            if (r2 == r3) goto L_0x000c
            return
        L_0x000c:
            f3.h0 r2 = r0.f5586l
            int r4 = r2.f5589a
            r5 = 1
            r6 = 0
            java.util.List r7 = r2.f5591c
            if (r4 == r5) goto L_0x0030
            if (r4 == r3) goto L_0x0030
            int r4 = r2.f5601m
            if (r4 != r5) goto L_0x001d
            goto L_0x0030
        L_0x001d:
            j1.h0 r4 = new j1.h0
            java.lang.Object r8 = r7.get(r6)
            j1.h0 r8 = (j1.h0) r8
            long r8 = r8.c()
            r4.<init>(r8)
            r7.add(r4)
            goto L_0x0036
        L_0x0030:
            java.lang.Object r4 = r7.get(r6)
            j1.h0 r4 = (j1.h0) r4
        L_0x0036:
            int r7 = r27.v()
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 != 0) goto L_0x003f
            return
        L_0x003f:
            r1.H(r5)
            int r7 = r27.A()
            r8 = 3
            r1.H(r8)
            j1.a0 r9 = r0.f5582h
            byte[] r10 = r9.f8405a
            r1.d(r10, r6, r3)
            r9.k(r6)
            r9.m(r8)
            r10 = 13
            int r11 = r9.g(r10)
            r2.f5607s = r11
            byte[] r11 = r9.f8405a
            r1.d(r11, r6, r3)
            r9.k(r6)
            r11 = 4
            r9.m(r11)
            r12 = 12
            int r13 = r9.g(r12)
            r1.H(r13)
            r13 = 21
            r14 = 0
            r15 = 8192(0x2000, float:1.14794E-41)
            f3.h r5 = r2.f5594f
            int r12 = r2.f5589a
            if (r12 != r3) goto L_0x009c
            f3.k0 r3 = r2.f5605q
            if (r3 != 0) goto L_0x009c
            j1.z r3 = new j1.z
            byte[] r11 = j1.l0.f8458f
            r3.<init>((int) r13, (java.lang.String) r14, (java.util.ArrayList) r14, (byte[]) r11)
            f3.k0 r3 = r5.a(r13, r3)
            r2.f5605q = r3
            if (r3 == 0) goto L_0x009c
            d2.y r11 = r2.f5600l
            f3.j0 r14 = new f3.j0
            r14.<init>(r7, r13, r15)
            r3.b(r4, r11, r14)
        L_0x009c:
            android.util.SparseArray r3 = r0.f5583i
            r3.clear()
            android.util.SparseIntArray r11 = r0.f5584j
            r11.clear()
            int r14 = r1.f8416c
            int r15 = r1.f8415b
            int r14 = r14 - r15
        L_0x00ab:
            android.util.SparseBooleanArray r15 = r2.f5596h
            if (r14 <= 0) goto L_0x022d
            byte[] r13 = r9.f8405a
            r10 = 5
            r1.d(r13, r6, r10)
            r9.k(r6)
            r13 = 8
            int r13 = r9.g(r13)
            r9.m(r8)
            r6 = 13
            int r8 = r9.g(r6)
            r6 = 4
            r9.m(r6)
            r6 = 12
            int r16 = r9.g(r6)
            int r6 = r1.f8415b
            int r10 = r16 + r6
            r20 = r4
            r21 = r7
            r19 = r9
            r0 = 0
            r4 = 0
            r9 = -1
        L_0x00de:
            int r7 = r1.f8415b
            if (r7 >= r10) goto L_0x01b9
            int r7 = r27.v()
            int r18 = r27.v()
            r22 = r3
            int r3 = r1.f8415b
            int r3 = r3 + r18
            r23 = r8
            if (r3 <= r10) goto L_0x00f6
            goto L_0x01bd
        L_0x00f6:
            r8 = 5
            if (r7 != r8) goto L_0x0123
            long r7 = r27.w()
            r24 = 1094921523(0x41432d33, double:5.409631094E-315)
            int r18 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r18 != 0) goto L_0x0105
            goto L_0x0127
        L_0x0105:
            r24 = 1161904947(0x45414333, double:5.74057318E-315)
            int r18 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r18 != 0) goto L_0x010d
            goto L_0x0134
        L_0x010d:
            r24 = 1094921524(0x41432d34, double:5.4096311E-315)
            int r18 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r18 != 0) goto L_0x0115
            goto L_0x0147
        L_0x0115:
            r24 = 1212503619(0x48455643, double:5.990563836E-315)
            int r18 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r18 != 0) goto L_0x014e
            r7 = 36
            r17 = r11
            r9 = 36
            goto L_0x012d
        L_0x0123:
            r8 = 106(0x6a, float:1.49E-43)
            if (r7 != r8) goto L_0x0130
        L_0x0127:
            r7 = 129(0x81, float:1.81E-43)
            r17 = r11
            r9 = 129(0x81, float:1.81E-43)
        L_0x012d:
            r11 = 3
            goto L_0x01ab
        L_0x0130:
            r8 = 122(0x7a, float:1.71E-43)
            if (r7 != r8) goto L_0x013b
        L_0x0134:
            r7 = 135(0x87, float:1.89E-43)
            r17 = r11
            r9 = 135(0x87, float:1.89E-43)
            goto L_0x012d
        L_0x013b:
            r8 = 127(0x7f, float:1.78E-43)
            if (r7 != r8) goto L_0x0150
            int r7 = r27.v()
            r8 = 21
            if (r7 != r8) goto L_0x014e
        L_0x0147:
            r7 = 172(0xac, float:2.41E-43)
            r17 = r11
            r9 = 172(0xac, float:2.41E-43)
            goto L_0x012d
        L_0x014e:
            r8 = 3
            goto L_0x0168
        L_0x0150:
            r8 = 123(0x7b, float:1.72E-43)
            if (r7 != r8) goto L_0x015b
            r7 = 138(0x8a, float:1.93E-43)
            r17 = r11
            r9 = 138(0x8a, float:1.93E-43)
            goto L_0x012d
        L_0x015b:
            r8 = 10
            if (r7 != r8) goto L_0x016b
            r8 = 3
            java.lang.String r0 = r1.s(r8)
            java.lang.String r0 = r0.trim()
        L_0x0168:
            r17 = r11
            goto L_0x012d
        L_0x016b:
            r8 = 89
            if (r7 != r8) goto L_0x01a0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x0174:
            int r7 = r1.f8415b
            if (r7 >= r3) goto L_0x019a
            r7 = 3
            java.lang.String r9 = r1.s(r7)
            java.lang.String r9 = r9.trim()
            r27.v()
            r8 = 4
            byte[] r7 = new byte[r8]
            r17 = r11
            r11 = 0
            r1.d(r7, r11, r8)
            f3.i0 r11 = new f3.i0
            r11.<init>(r9, r7)
            r4.add(r11)
            r11 = r17
            r8 = 89
            goto L_0x0174
        L_0x019a:
            r17 = r11
            r8 = 4
            r9 = 89
            goto L_0x012d
        L_0x01a0:
            r17 = r11
            r11 = 3
            r8 = 111(0x6f, float:1.56E-43)
            if (r7 != r8) goto L_0x01ab
            r7 = 257(0x101, float:3.6E-43)
            r9 = 257(0x101, float:3.6E-43)
        L_0x01ab:
            int r7 = r1.f8415b
            int r3 = r3 - r7
            r1.H(r3)
            r11 = r17
            r3 = r22
            r8 = r23
            goto L_0x00de
        L_0x01b9:
            r22 = r3
            r23 = r8
        L_0x01bd:
            r17 = r11
            r11 = 3
            r1.G(r10)
            j1.z r3 = new j1.z
            byte[] r7 = r1.f8414a
            byte[] r6 = java.util.Arrays.copyOfRange(r7, r6, r10)
            r3.<init>((int) r9, (java.lang.String) r0, (java.util.ArrayList) r4, (byte[]) r6)
            r0 = 6
            if (r13 == r0) goto L_0x01d4
            r0 = 5
            if (r13 != r0) goto L_0x01d6
        L_0x01d4:
            int r13 = r3.f8483a
        L_0x01d6:
            int r16 = r16 + 5
            int r14 = r14 - r16
            r0 = 2
            if (r12 != r0) goto L_0x01df
            r4 = r13
            goto L_0x01e1
        L_0x01df:
            r4 = r23
        L_0x01e1:
            boolean r6 = r15.get(r4)
            if (r6 == 0) goto L_0x01ee
            r0 = r17
            r7 = r22
            r6 = 21
            goto L_0x021b
        L_0x01ee:
            if (r12 != r0) goto L_0x01f7
            r6 = 21
            if (r13 != r6) goto L_0x01f9
            f3.k0 r3 = r2.f5605q
            goto L_0x01fd
        L_0x01f7:
            r6 = 21
        L_0x01f9:
            f3.k0 r3 = r5.a(r13, r3)
        L_0x01fd:
            if (r12 != r0) goto L_0x020f
            r0 = r17
            r7 = 8192(0x2000, float:1.14794E-41)
            int r8 = r0.get(r4, r7)
            r7 = r23
            if (r7 >= r8) goto L_0x020c
            goto L_0x0213
        L_0x020c:
            r7 = r22
            goto L_0x021b
        L_0x020f:
            r0 = r17
            r7 = r23
        L_0x0213:
            r0.put(r4, r7)
            r7 = r22
            r7.put(r4, r3)
        L_0x021b:
            r11 = r0
            r3 = r7
            r9 = r19
            r4 = r20
            r7 = r21
            r6 = 0
            r8 = 3
            r10 = 13
            r13 = 21
            r0 = r26
            goto L_0x00ab
        L_0x022d:
            r20 = r4
            r21 = r7
            r0 = r11
            r7 = r3
            int r1 = r0.size()
            r11 = 0
        L_0x0238:
            android.util.SparseArray r3 = r2.f5595g
            if (r11 >= r1) goto L_0x0281
            int r4 = r0.keyAt(r11)
            int r5 = r0.valueAt(r11)
            r6 = 1
            r15.put(r4, r6)
            android.util.SparseBooleanArray r8 = r2.f5597i
            r8.put(r5, r6)
            java.lang.Object r6 = r7.valueAt(r11)
            f3.k0 r6 = (f3.k0) r6
            if (r6 == 0) goto L_0x0274
            f3.k0 r8 = r2.f5605q
            if (r6 == r8) goto L_0x026a
            d2.y r8 = r2.f5600l
            f3.j0 r9 = new f3.j0
            r10 = r21
            r13 = 8192(0x2000, float:1.14794E-41)
            r9.<init>(r10, r4, r13)
            r4 = r20
            r6.b(r4, r8, r9)
            goto L_0x0270
        L_0x026a:
            r4 = r20
            r10 = r21
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0270:
            r3.put(r5, r6)
            goto L_0x027a
        L_0x0274:
            r4 = r20
            r10 = r21
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x027a:
            int r11 = r11 + 1
            r20 = r4
            r21 = r10
            goto L_0x0238
        L_0x0281:
            r5 = 2
            if (r12 != r5) goto L_0x0296
            boolean r0 = r2.f5602n
            if (r0 != 0) goto L_0x0293
            d2.y r0 = r2.f5600l
            r0.a()
            r0 = 0
            r2.f5601m = r0
            r1 = 1
            r2.f5602n = r1
        L_0x0293:
            r4 = r26
            goto L_0x02b3
        L_0x0296:
            r4 = r26
            r0 = 0
            r1 = 1
            int r5 = r4.f5585k
            r3.remove(r5)
            if (r12 != r1) goto L_0x02a3
            r6 = 0
            goto L_0x02a8
        L_0x02a3:
            int r0 = r2.f5601m
            r3 = -1
            int r6 = r0 + -1
        L_0x02a8:
            r2.f5601m = r6
            if (r6 != 0) goto L_0x02b3
            d2.y r0 = r2.f5600l
            r0.a()
            r2.f5602n = r1
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.g0.c(j1.b0):void");
    }
}
