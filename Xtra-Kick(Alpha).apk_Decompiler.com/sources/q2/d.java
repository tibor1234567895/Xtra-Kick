package q2;

import j1.a0;
import j1.b0;
import j1.h0;
import j2.b;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f13288a = new b0();

    /* renamed from: b  reason: collision with root package name */
    public final a0 f13289b = new a0();

    /* renamed from: c  reason: collision with root package name */
    public h0 f13290c;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: q2.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: q2.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: q2.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: q2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: q2.b} */
    /* JADX WARNING: type inference failed for: r0v5, types: [q2.m] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g1.z0 b(j2.a r57, java.nio.ByteBuffer r58) {
        /*
            r56 = this;
            r0 = r56
            r1 = r57
            j1.h0 r2 = r0.f13290c
            if (r2 == 0) goto L_0x0012
            long r3 = r1.f8487p
            long r5 = r2.d()
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0023
        L_0x0012:
            j1.h0 r2 = new j1.h0
            long r3 = r1.f9517l
            r2.<init>(r3)
            r0.f13290c = r2
            long r3 = r1.f9517l
            long r5 = r1.f8487p
            long r3 = r3 - r5
            r2.a(r3)
        L_0x0023:
            byte[] r1 = r58.array()
            int r2 = r58.limit()
            j1.b0 r3 = r0.f13288a
            r3.E(r2, r1)
            j1.a0 r4 = r0.f13289b
            r4.j(r2, r1)
            r1 = 39
            r4.m(r1)
            r1 = 1
            int r2 = r4.g(r1)
            long r5 = (long) r2
            r2 = 32
            long r5 = r5 << r2
            int r7 = r4.g(r2)
            long r7 = (long) r7
            long r13 = r5 | r7
            r5 = 20
            r4.m(r5)
            r5 = 12
            int r5 = r4.g(r5)
            r6 = 8
            int r4 = r4.g(r6)
            r6 = 14
            r3.H(r6)
            if (r4 == 0) goto L_0x0281
            r7 = 255(0xff, float:3.57E-43)
            if (r4 == r7) goto L_0x026c
            r11 = 0
            r15 = 1
            r5 = 4
            r17 = 128(0x80, double:6.32E-322)
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == r5) goto L_0x0176
            r5 = 5
            if (r4 == r5) goto L_0x008e
            r2 = 6
            if (r4 == r2) goto L_0x007d
            r2 = 0
            goto L_0x0286
        L_0x007d:
            j1.h0 r2 = r0.f13290c
            long r3 = q2.o.u(r13, r3)
            long r7 = r2.b(r3)
            q2.o r2 = new q2.o
            r2.<init>(r3, r7)
            goto L_0x0286
        L_0x008e:
            j1.h0 r4 = r0.f13290c
            android.os.Parcelable$Creator<q2.g> r5 = q2.g.CREATOR
            long r22 = r3.w()
            int r5 = r3.v()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x00a1
            r24 = 1
            goto L_0x00a3
        L_0x00a1:
            r24 = 0
        L_0x00a3:
            java.util.List r5 = java.util.Collections.emptyList()
            if (r24 != 0) goto L_0x0152
            int r1 = r3.v()
            r6 = r1 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00b3
            r6 = 1
            goto L_0x00b4
        L_0x00b3:
            r6 = 0
        L_0x00b4:
            r21 = r1 & 64
            if (r21 == 0) goto L_0x00bb
            r21 = 1
            goto L_0x00bd
        L_0x00bb:
            r21 = 0
        L_0x00bd:
            r25 = r1 & 32
            if (r25 == 0) goto L_0x00c4
            r25 = 1
            goto L_0x00c6
        L_0x00c4:
            r25 = 0
        L_0x00c6:
            r1 = r1 & 16
            if (r1 == 0) goto L_0x00cc
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            if (r21 == 0) goto L_0x00d6
            if (r1 != 0) goto L_0x00d6
            long r26 = q2.o.u(r13, r3)
            goto L_0x00d8
        L_0x00d6:
            r26 = r19
        L_0x00d8:
            if (r21 != 0) goto L_0x010b
            int r5 = r3.v()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r5)
            r8 = 0
        L_0x00e4:
            if (r8 >= r5) goto L_0x010a
            int r31 = r3.v()
            if (r1 != 0) goto L_0x00f3
            long r32 = q2.o.u(r13, r3)
            r9 = r32
            goto L_0x00f5
        L_0x00f3:
            r9 = r19
        L_0x00f5:
            q2.f r2 = new q2.f
            long r34 = r4.b(r9)
            r30 = r2
            r32 = r9
            r30.<init>(r31, r32, r34)
            r7.add(r2)
            int r8 = r8 + 1
            r2 = 32
            goto L_0x00e4
        L_0x010a:
            r5 = r7
        L_0x010b:
            if (r25 == 0) goto L_0x012e
            int r2 = r3.v()
            long r7 = (long) r2
            long r9 = r7 & r17
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x011a
            r2 = 1
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            long r7 = r7 & r15
            r9 = 32
            long r7 = r7 << r9
            long r9 = r3.w()
            long r7 = r7 | r9
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            r9 = 90
            long r7 = r7 / r9
            r19 = r7
            goto L_0x012f
        L_0x012e:
            r2 = 0
        L_0x012f:
            int r7 = r3.A()
            int r8 = r3.v()
            int r3 = r3.v()
            r33 = r2
            r38 = r3
            r32 = r5
            r25 = r6
            r36 = r7
            r37 = r8
            r34 = r19
            r54 = r26
            r27 = r1
            r26 = r21
            r1 = r54
            goto L_0x0166
        L_0x0152:
            r32 = r5
            r1 = r19
            r34 = r1
            r25 = 0
            r26 = 0
            r27 = 0
            r33 = 0
            r36 = 0
            r37 = 0
            r38 = 0
        L_0x0166:
            q2.g r3 = new q2.g
            r21 = r3
            long r30 = r4.b(r1)
            r28 = r1
            r21.<init>(r22, r24, r25, r26, r27, r28, r30, r32, r33, r34, r36, r37, r38)
            r2 = r3
            goto L_0x0286
        L_0x0176:
            android.os.Parcelable$Creator<q2.m> r1 = q2.m.CREATOR
            int r1 = r3.v()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            r4 = 0
        L_0x0182:
            if (r4 >= r1) goto L_0x0265
            long r40 = r3.w()
            int r5 = r3.v()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0193
            r42 = 1
            goto L_0x0195
        L_0x0193:
            r42 = 0
        L_0x0195:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r42 != 0) goto L_0x0239
            int r6 = r3.v()
            r7 = r6 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x01a6
            r7 = 1
            goto L_0x01a7
        L_0x01a6:
            r7 = 0
        L_0x01a7:
            r8 = r6 & 64
            if (r8 == 0) goto L_0x01ad
            r8 = 1
            goto L_0x01ae
        L_0x01ad:
            r8 = 0
        L_0x01ae:
            r6 = r6 & 32
            if (r6 == 0) goto L_0x01b4
            r6 = 1
            goto L_0x01b5
        L_0x01b4:
            r6 = 0
        L_0x01b5:
            if (r8 == 0) goto L_0x01bc
            long r9 = r3.w()
            goto L_0x01be
        L_0x01bc:
            r9 = r19
        L_0x01be:
            if (r8 != 0) goto L_0x01e6
            int r5 = r3.v()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>(r5)
            r14 = 0
        L_0x01ca:
            if (r14 >= r5) goto L_0x01e5
            int r15 = r3.v()
            long r11 = r3.w()
            q2.k r0 = new q2.k
            r0.<init>(r15, r11)
            r13.add(r0)
            int r14 = r14 + 1
            r0 = r56
            r11 = 0
            r15 = 1
            goto L_0x01ca
        L_0x01e5:
            r5 = r13
        L_0x01e6:
            if (r6 == 0) goto L_0x020d
            int r0 = r3.v()
            long r11 = (long) r0
            long r13 = r11 & r17
            r15 = 0
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x01f7
            r0 = 1
            goto L_0x01f8
        L_0x01f7:
            r0 = 0
        L_0x01f8:
            r13 = 1
            long r11 = r11 & r13
            r6 = 32
            long r11 = r11 << r6
            long r21 = r3.w()
            long r11 = r11 | r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r21
            r23 = 90
            long r11 = r11 / r23
            goto L_0x021a
        L_0x020d:
            r6 = 32
            r13 = 1
            r15 = 0
            r21 = 1000(0x3e8, double:4.94E-321)
            r23 = 90
            r11 = r19
            r0 = 0
        L_0x021a:
            int r25 = r3.A()
            int r26 = r3.v()
            int r27 = r3.v()
            r48 = r0
            r45 = r5
            r43 = r7
            r44 = r8
            r46 = r9
            r49 = r11
            r51 = r25
            r52 = r26
            r53 = r27
            goto L_0x0253
        L_0x0239:
            r13 = r15
            r6 = 32
            r21 = 1000(0x3e8, double:4.94E-321)
            r23 = 90
            r15 = r11
            r45 = r5
            r46 = r19
            r49 = r46
            r43 = 0
            r44 = 0
            r48 = 0
            r51 = 0
            r52 = 0
            r53 = 0
        L_0x0253:
            q2.l r0 = new q2.l
            r39 = r0
            r39.<init>(r40, r42, r43, r44, r45, r46, r48, r49, r51, r52, r53)
            r2.add(r0)
            int r4 = r4 + 1
            r0 = r56
            r11 = r15
            r15 = r13
            goto L_0x0182
        L_0x0265:
            q2.m r0 = new q2.m
            r0.<init>((java.util.ArrayList) r2)
            r2 = r0
            goto L_0x0286
        L_0x026c:
            android.os.Parcelable$Creator<q2.b> r0 = q2.b.CREATOR
            long r10 = r3.w()
            int r5 = r5 + -4
            byte[] r12 = new byte[r5]
            r0 = 0
            r3.d(r12, r0, r5)
            q2.b r2 = new q2.b
            r9 = r2
            r9.<init>(r10, r12, r13)
            goto L_0x0286
        L_0x0281:
            q2.i r2 = new q2.i
            r2.<init>()
        L_0x0286:
            if (r2 != 0) goto L_0x0291
            g1.z0 r0 = new g1.z0
            r1 = 0
            g1.y0[] r1 = new g1.y0[r1]
            r0.<init>((g1.y0[]) r1)
            goto L_0x029c
        L_0x0291:
            r1 = 0
            g1.z0 r0 = new g1.z0
            r3 = 1
            g1.y0[] r3 = new g1.y0[r3]
            r3[r1] = r2
            r0.<init>((g1.y0[]) r3)
        L_0x029c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.d.b(j2.a, java.nio.ByteBuffer):g1.z0");
    }
}
