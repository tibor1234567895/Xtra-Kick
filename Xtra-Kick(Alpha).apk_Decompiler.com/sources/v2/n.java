package v2;

import d0.d;
import d2.a1;
import j1.a;
import j1.b0;
import java.util.Arrays;

public final class n extends l {

    /* renamed from: n  reason: collision with root package name */
    public m f15894n;

    /* renamed from: o  reason: collision with root package name */
    public int f15895o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f15896p;

    /* renamed from: q  reason: collision with root package name */
    public a1 f15897q;

    /* renamed from: r  reason: collision with root package name */
    public d f15898r;

    public final void a(long j10) {
        boolean z10;
        this.f15882g = j10;
        int i10 = 0;
        if (j10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f15896p = z10;
        a1 a1Var = this.f15897q;
        if (a1Var != null) {
            i10 = a1Var.f4141e;
        }
        this.f15895o = i10;
    }

    public final long b(b0 b0Var) {
        int i10;
        int i11 = 0;
        byte b10 = b0Var.f8414a[0];
        if ((b10 & 1) == 1) {
            return -1;
        }
        m mVar = this.f15894n;
        a.f(mVar);
        boolean z10 = mVar.f15892d[(b10 >> 1) & (255 >>> (8 - mVar.f15893e))].f4315a;
        a1 a1Var = mVar.f15889a;
        if (!z10) {
            i10 = a1Var.f4141e;
        } else {
            i10 = a1Var.f4142f;
        }
        if (this.f15896p) {
            i11 = (this.f15895o + i10) / 4;
        }
        long j10 = (long) i11;
        byte[] bArr = b0Var.f8414a;
        int length = bArr.length;
        int i12 = b0Var.f8416c + 4;
        if (length < i12) {
            byte[] copyOf = Arrays.copyOf(bArr, i12);
            b0Var.E(copyOf.length, copyOf);
        } else {
            b0Var.F(i12);
        }
        byte[] bArr2 = b0Var.f8414a;
        int i13 = b0Var.f8416c;
        bArr2[i13 - 4] = (byte) ((int) (j10 & 255));
        bArr2[i13 - 3] = (byte) ((int) ((j10 >>> 8) & 255));
        bArr2[i13 - 2] = (byte) ((int) ((j10 >>> 16) & 255));
        bArr2[i13 - 1] = (byte) ((int) ((j10 >>> 24) & 255));
        this.f15896p = true;
        this.f15895o = i10;
        return j10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x03d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(j1.b0 r24, long r25, v2.j r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r27
            v2.m r3 = r0.f15894n
            r4 = 0
            if (r3 == 0) goto L_0x0011
            g1.a0 r1 = r2.f15874a
            r1.getClass()
            return r4
        L_0x0011:
            d2.a1 r6 = r0.f15897q
            r5 = 4
            r11 = 1
            if (r6 != 0) goto L_0x006c
            d2.b1.c(r11, r1, r4)
            r24.m()
            int r13 = r24.v()
            int r14 = r24.m()
            int r4 = r24.i()
            if (r4 > 0) goto L_0x002d
            r15 = -1
            goto L_0x002e
        L_0x002d:
            r15 = r4
        L_0x002e:
            int r4 = r24.i()
            if (r4 > 0) goto L_0x0037
            r16 = -1
            goto L_0x0039
        L_0x0037:
            r16 = r4
        L_0x0039:
            r24.i()
            int r3 = r24.v()
            r4 = r3 & 15
            double r8 = (double) r4
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = java.lang.Math.pow(r11, r8)
            int r4 = (int) r8
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> r5
            double r5 = (double) r3
            double r5 = java.lang.Math.pow(r11, r5)
            int r3 = (int) r5
            r24.v()
            byte[] r5 = r1.f8414a
            int r1 = r1.f8416c
            byte[] r19 = java.util.Arrays.copyOf(r5, r1)
            d2.a1 r1 = new d2.a1
            r12 = r1
            r17 = r4
            r18 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r0.f15897q = r1
            r9 = 1
            goto L_0x0077
        L_0x006c:
            d0.d r8 = r0.f15898r
            if (r8 != 0) goto L_0x007a
            r9 = 1
            d0.d r1 = d2.b1.b(r1, r9, r9)
            r0.f15898r = r1
        L_0x0077:
            r7 = 0
            goto L_0x03d4
        L_0x007a:
            r9 = 1
            int r10 = r1.f8416c
            byte[] r11 = new byte[r10]
            byte[] r12 = r1.f8414a
            java.lang.System.arraycopy(r12, r4, r11, r4, r10)
            r10 = 5
            d2.b1.c(r10, r1, r4)
            int r12 = r24.v()
            int r12 = r12 + r9
            d2.r0 r9 = new d2.r0
            byte[] r13 = r1.f8414a
            r9.<init>(r13)
            int r1 = r1.f8415b
            r13 = 8
            int r1 = r1 * 8
            r9.m(r1)
            r1 = 0
        L_0x009e:
            r14 = 24
            r3 = 16
            if (r1 >= r12) goto L_0x01a8
            int r4 = r9.h(r14)
            r13 = 5653314(0x564342, float:7.92198E-39)
            if (r4 != r13) goto L_0x018b
            int r3 = r9.h(r3)
            int r4 = r9.h(r14)
            long[] r13 = new long[r4]
            boolean r14 = r9.f()
            r17 = 0
            if (r14 != 0) goto L_0x00fa
            boolean r14 = r9.f()
            r7 = 0
        L_0x00c4:
            if (r7 >= r4) goto L_0x00f6
            if (r14 == 0) goto L_0x00e3
            boolean r20 = r9.f()
            if (r20 == 0) goto L_0x00dc
            int r20 = r9.h(r10)
            r21 = 1
            int r15 = r20 + 1
            r20 = r6
            long r5 = (long) r15
            r13[r7] = r5
            goto L_0x00f0
        L_0x00dc:
            r20 = r6
            r21 = 1
            r13[r7] = r17
            goto L_0x00f0
        L_0x00e3:
            r20 = r6
            r21 = 1
            int r5 = r9.h(r10)
            int r5 = r5 + 1
            long r5 = (long) r5
            r13[r7] = r5
        L_0x00f0:
            int r7 = r7 + 1
            r6 = r20
            r5 = 4
            goto L_0x00c4
        L_0x00f6:
            r20 = r6
            r15 = r11
            goto L_0x012d
        L_0x00fa:
            r20 = r6
            r21 = 1
            int r5 = r9.h(r10)
            int r5 = r5 + 1
            r6 = 0
        L_0x0105:
            if (r6 >= r4) goto L_0x012b
            int r7 = r4 - r6
            r14 = 0
        L_0x010a:
            if (r7 <= 0) goto L_0x0111
            int r14 = r14 + 1
            int r7 = r7 >>> 1
            goto L_0x010a
        L_0x0111:
            int r7 = r9.h(r14)
            r14 = 0
        L_0x0116:
            if (r14 >= r7) goto L_0x0125
            if (r6 >= r4) goto L_0x0125
            r15 = r11
            long r10 = (long) r5
            r13[r6] = r10
            int r6 = r6 + 1
            int r14 = r14 + 1
            r11 = r15
            r10 = 5
            goto L_0x0116
        L_0x0125:
            r15 = r11
            int r5 = r5 + 1
            r11 = r15
            r10 = 5
            goto L_0x0105
        L_0x012b:
            r15 = r11
            r5 = 4
        L_0x012d:
            int r6 = r9.h(r5)
            r7 = 2
            if (r6 > r7) goto L_0x0177
            r10 = 1
            if (r6 == r10) goto L_0x0139
            if (r6 != r7) goto L_0x016b
        L_0x0139:
            r7 = 32
            r9.m(r7)
            r9.m(r7)
            int r7 = r9.h(r5)
            int r7 = r7 + r10
            r9.m(r10)
            if (r6 != r10) goto L_0x0160
            if (r3 == 0) goto L_0x0164
            long r4 = (long) r4
            long r10 = (long) r3
            double r3 = (double) r4
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = (double) r10
            double r5 = r5 / r10
            double r3 = java.lang.Math.pow(r3, r5)
            double r3 = java.lang.Math.floor(r3)
            long r3 = (long) r3
            r17 = r3
            goto L_0x0164
        L_0x0160:
            long r4 = (long) r4
            long r10 = (long) r3
            long r17 = r4 * r10
        L_0x0164:
            long r3 = (long) r7
            long r3 = r3 * r17
            int r4 = (int) r3
            r9.m(r4)
        L_0x016b:
            int r1 = r1 + 1
            r11 = r15
            r6 = r20
            r4 = 0
            r5 = 4
            r10 = 5
            r13 = 8
            goto L_0x009e
        L_0x0177:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x018b:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r1.<init>(r3)
            int r3 = r9.f4291d
            r4 = 8
            int r3 = r3 * 8
            int r4 = r9.f4292e
            int r3 = r3 + r4
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x01a8:
            r20 = r6
            r15 = r11
            r1 = 6
            int r4 = r9.h(r1)
            r5 = 1
            int r4 = r4 + r5
            r5 = 0
        L_0x01b3:
            if (r5 >= r4) goto L_0x01c6
            int r6 = r9.h(r3)
            if (r6 != 0) goto L_0x01be
            int r5 = r5 + 1
            goto L_0x01b3
        L_0x01be:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x01c6:
            int r4 = r9.h(r1)
            r5 = 1
            int r4 = r4 + r5
            r6 = 0
        L_0x01cd:
            r7 = 3
            if (r6 >= r4) goto L_0x0281
            int r10 = r9.h(r3)
            if (r10 == 0) goto L_0x0255
            if (r10 != r5) goto L_0x0241
            r5 = 5
            int r10 = r9.h(r5)
            int[] r5 = new int[r10]
            r11 = 0
            r12 = -1
        L_0x01e1:
            if (r11 >= r10) goto L_0x01f2
            r13 = 4
            int r14 = r9.h(r13)
            r5[r11] = r14
            if (r14 <= r12) goto L_0x01ed
            r12 = r14
        L_0x01ed:
            int r11 = r11 + 1
            r14 = 24
            goto L_0x01e1
        L_0x01f2:
            int r12 = r12 + 1
            int[] r11 = new int[r12]
            r13 = 0
        L_0x01f7:
            if (r13 >= r12) goto L_0x0223
            int r14 = r9.h(r7)
            r18 = 1
            int r14 = r14 + 1
            r11[r13] = r14
            r14 = 2
            int r22 = r9.h(r14)
            r14 = 8
            if (r22 <= 0) goto L_0x020f
            r9.m(r14)
        L_0x020f:
            r7 = 0
        L_0x0210:
            int r1 = r18 << r22
            if (r7 >= r1) goto L_0x021e
            r9.m(r14)
            int r7 = r7 + 1
            r14 = 8
            r18 = 1
            goto L_0x0210
        L_0x021e:
            int r13 = r13 + 1
            r1 = 6
            r7 = 3
            goto L_0x01f7
        L_0x0223:
            r1 = 2
            r9.m(r1)
            r1 = 4
            int r7 = r9.h(r1)
            r1 = 0
            r12 = 0
            r13 = 0
        L_0x022f:
            if (r1 >= r10) goto L_0x0279
            r14 = r5[r1]
            r14 = r11[r14]
            int r12 = r12 + r14
        L_0x0236:
            if (r13 >= r12) goto L_0x023e
            r9.m(r7)
            int r13 = r13 + 1
            goto L_0x0236
        L_0x023e:
            int r1 = r1 + 1
            goto L_0x022f
        L_0x0241:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0255:
            r1 = 8
            r9.m(r1)
            r9.m(r3)
            r9.m(r3)
            r5 = 6
            r9.m(r5)
            r9.m(r1)
            r5 = 4
            int r7 = r9.h(r5)
            r5 = 1
            int r7 = r7 + r5
            r5 = 0
        L_0x026f:
            if (r5 >= r7) goto L_0x0279
            r9.m(r1)
            int r5 = r5 + 1
            r1 = 8
            goto L_0x026f
        L_0x0279:
            int r6 = r6 + 1
            r1 = 6
            r5 = 1
            r14 = 24
            goto L_0x01cd
        L_0x0281:
            int r4 = r9.h(r1)
            r5 = 1
            int r4 = r4 + r5
            r6 = 0
        L_0x0288:
            if (r6 >= r4) goto L_0x02f3
            int r7 = r9.h(r3)
            r10 = 2
            if (r7 > r10) goto L_0x02eb
            r7 = 24
            r9.m(r7)
            r9.m(r7)
            r9.m(r7)
            int r10 = r9.h(r1)
            int r10 = r10 + r5
            r1 = 8
            r9.m(r1)
            int[] r5 = new int[r10]
            r11 = 0
        L_0x02a9:
            r12 = 3
            if (r11 >= r10) goto L_0x02c8
            int r13 = r9.h(r12)
            boolean r14 = r9.f()
            if (r14 == 0) goto L_0x02bc
            r14 = 5
            int r17 = r9.h(r14)
            goto L_0x02bf
        L_0x02bc:
            r14 = 5
            r17 = 0
        L_0x02bf:
            int r17 = r17 * 8
            int r17 = r17 + r13
            r5[r11] = r17
            int r11 = r11 + 1
            goto L_0x02a9
        L_0x02c8:
            r14 = 5
            r11 = 0
        L_0x02ca:
            if (r11 >= r10) goto L_0x02e6
            r13 = 0
        L_0x02cd:
            if (r13 >= r1) goto L_0x02e1
            r17 = r5[r11]
            r18 = 1
            int r21 = r18 << r13
            r17 = r17 & r21
            if (r17 == 0) goto L_0x02dc
            r9.m(r1)
        L_0x02dc:
            int r13 = r13 + 1
            r1 = 8
            goto L_0x02cd
        L_0x02e1:
            int r11 = r11 + 1
            r1 = 8
            goto L_0x02ca
        L_0x02e6:
            int r6 = r6 + 1
            r1 = 6
            r5 = 1
            goto L_0x0288
        L_0x02eb:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x02f3:
            int r4 = r9.h(r1)
            r1 = 1
            int r4 = r4 + r1
            r1 = 0
        L_0x02fa:
            if (r1 >= r4) goto L_0x038f
            int r5 = r9.h(r3)
            if (r5 == 0) goto L_0x031b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "mapping type other than 0 not supported: "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "VorbisUtil"
            j1.v.c(r6, r5)
            r10 = r20
            r5 = 2
            r12 = 4
            goto L_0x0381
        L_0x031b:
            boolean r5 = r9.f()
            if (r5 == 0) goto L_0x0329
            r5 = 4
            int r6 = r9.h(r5)
            r5 = 1
            int r6 = r6 + r5
            goto L_0x032b
        L_0x0329:
            r5 = 1
            r6 = 1
        L_0x032b:
            boolean r7 = r9.f()
            r10 = r20
            int r11 = r10.f4137a
            if (r7 == 0) goto L_0x035b
            r7 = 8
            int r12 = r9.h(r7)
            int r12 = r12 + r5
            r5 = 0
        L_0x033d:
            if (r5 >= r12) goto L_0x035b
            int r7 = r11 + -1
            r13 = r7
            r14 = 0
        L_0x0343:
            if (r13 <= 0) goto L_0x034a
            int r14 = r14 + 1
            int r13 = r13 >>> 1
            goto L_0x0343
        L_0x034a:
            r9.m(r14)
            r13 = 0
        L_0x034e:
            if (r7 <= 0) goto L_0x0355
            int r13 = r13 + 1
            int r7 = r7 >>> 1
            goto L_0x034e
        L_0x0355:
            r9.m(r13)
            int r5 = r5 + 1
            goto L_0x033d
        L_0x035b:
            r5 = 2
            int r7 = r9.h(r5)
            if (r7 != 0) goto L_0x0387
            r7 = 1
            if (r6 <= r7) goto L_0x036f
            r7 = 0
        L_0x0366:
            if (r7 >= r11) goto L_0x036f
            r12 = 4
            r9.m(r12)
            int r7 = r7 + 1
            goto L_0x0366
        L_0x036f:
            r12 = 4
            r7 = 0
        L_0x0371:
            if (r7 >= r6) goto L_0x0381
            r11 = 8
            r9.m(r11)
            r9.m(r11)
            r9.m(r11)
            int r7 = r7 + 1
            goto L_0x0371
        L_0x0381:
            int r1 = r1 + 1
            r20 = r10
            goto L_0x02fa
        L_0x0387:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x038f:
            r10 = r20
            r1 = 6
            int r1 = r9.h(r1)
            r4 = 1
            int r1 = r1 + r4
            d2.z0[] r4 = new d2.z0[r1]
            r5 = 0
        L_0x039b:
            if (r5 >= r1) goto L_0x03b6
            boolean r6 = r9.f()
            r9.h(r3)
            r9.h(r3)
            r7 = 8
            r9.h(r7)
            d2.z0 r11 = new d2.z0
            r11.<init>(r6)
            r4[r5] = r11
            int r5 = r5 + 1
            goto L_0x039b
        L_0x03b6:
            boolean r3 = r9.f()
            if (r3 == 0) goto L_0x041f
            r3 = 1
            int r1 = r1 - r3
            r16 = 0
        L_0x03c0:
            if (r1 <= 0) goto L_0x03c7
            int r16 = r16 + 1
            int r1 = r1 >>> 1
            goto L_0x03c0
        L_0x03c7:
            v2.m r1 = new v2.m
            r5 = r1
            r6 = r10
            r7 = r8
            r8 = r15
            r9 = r4
            r10 = r16
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = r1
        L_0x03d4:
            r0.f15894n = r7
            if (r7 != 0) goto L_0x03da
            r1 = 1
            return r1
        L_0x03da:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            d2.a1 r3 = r7.f15889a
            byte[] r4 = r3.f4143g
            r1.add(r4)
            byte[] r4 = r7.f15891c
            r1.add(r4)
            d0.d r4 = r7.f15890b
            java.lang.Object r4 = r4.f4092j
            java.lang.String[] r4 = (java.lang.String[]) r4
            d9.r1 r4 = d9.r0.k(r4)
            g1.z0 r4 = d2.b1.a(r4)
            g1.z r5 = new g1.z
            r5.<init>()
            java.lang.String r6 = "audio/vorbis"
            r5.f6754k = r6
            int r6 = r3.f4140d
            r5.f6749f = r6
            int r6 = r3.f4139c
            r5.f6750g = r6
            int r6 = r3.f4137a
            r5.f6767x = r6
            int r3 = r3.f4138b
            r5.f6768y = r3
            r5.f6756m = r1
            r5.f6752i = r4
            g1.a0 r1 = new g1.a0
            r1.<init>(r5)
            r2.f15874a = r1
            r1 = 1
            return r1
        L_0x041f:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.n.c(j1.b0, long, v2.j):boolean");
    }

    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f15894n = null;
            this.f15897q = null;
            this.f15898r = null;
        }
        this.f15895o = 0;
        this.f15896p = false;
    }
}
