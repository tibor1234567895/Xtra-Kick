package f3;

import android.util.SparseArray;
import d2.p;
import d2.v;
import d2.w;
import d2.y;
import g2.a;
import j1.b0;
import j1.h0;

public final class c0 implements v {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f5506a = new h0(0);

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray f5507b = new SparseArray();

    /* renamed from: c  reason: collision with root package name */
    public final b0 f5508c = new b0(4096);

    /* renamed from: d  reason: collision with root package name */
    public final a0 f5509d = new a0();

    /* renamed from: e  reason: collision with root package name */
    public boolean f5510e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5511f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5512g;

    /* renamed from: h  reason: collision with root package name */
    public long f5513h;

    /* renamed from: i  reason: collision with root package name */
    public a f5514i;

    /* renamed from: j  reason: collision with root package name */
    public y f5515j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5516k;

    public final void a() {
    }

    public final void c(long j10, long j11) {
        boolean z10;
        h0 h0Var = this.f5506a;
        boolean z11 = true;
        if (h0Var.d() == -9223372036854775807L) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            long c10 = h0Var.c();
            if (c10 == -9223372036854775807L || c10 == 0 || c10 == j11) {
                z11 = false;
            }
            z10 = z11;
        }
        if (z10) {
            h0Var.e(j11);
        }
        a aVar = this.f5514i;
        if (aVar != null) {
            aVar.c(j11);
        }
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f5507b;
            if (i10 < sparseArray.size()) {
                b0 b0Var = (b0) sparseArray.valueAt(i10);
                b0Var.f5492f = false;
                b0Var.f5487a.a();
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r19, d2.s0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            d2.y r3 = r0.f5515j
            j1.a.f(r3)
            long r10 = r19.c()
            r3 = 1
            r12 = 0
            r13 = -1
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x0019
            r4 = 1
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            r6 = 442(0x1ba, float:6.2E-43)
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            f3.a0 r5 = r0.f5509d
            if (r4 == 0) goto L_0x010b
            boolean r4 = r5.f5478c
            if (r4 != 0) goto L_0x010b
            boolean r4 = r5.f5480e
            j1.b0 r7 = r5.f5477b
            r10 = 20000(0x4e20, double:9.8813E-320)
            if (r4 != 0) goto L_0x007a
            long r8 = r19.c()
            long r10 = java.lang.Math.min(r10, r8)
            int r4 = (int) r10
            long r10 = (long) r4
            long r8 = r8 - r10
            long r10 = r19.p()
            int r15 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r15 == 0) goto L_0x0048
            r2.f4296a = r8
            goto L_0x00cd
        L_0x0048:
            r7.D(r4)
            r19.f()
            byte[] r2 = r7.f8414a
            r1.m(r2, r12, r4)
            int r1 = r7.f8415b
            int r2 = r7.f8416c
            int r2 = r2 + -4
        L_0x0059:
            if (r2 < r1) goto L_0x0075
            byte[] r4 = r7.f8414a
            int r4 = f3.a0.b(r2, r4)
            if (r4 != r6) goto L_0x0072
            int r4 = r2 + 4
            r7.G(r4)
            long r8 = f3.a0.c(r7)
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0072
            r13 = r8
            goto L_0x0075
        L_0x0072:
            int r2 = r2 + -1
            goto L_0x0059
        L_0x0075:
            r5.f5482g = r13
            r5.f5480e = r3
            goto L_0x00cc
        L_0x007a:
            long r8 = r5.f5482g
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0082
            goto L_0x0107
        L_0x0082:
            boolean r4 = r5.f5479d
            if (r4 != 0) goto L_0x00cf
            long r8 = r19.c()
            long r8 = java.lang.Math.min(r10, r8)
            int r4 = (int) r8
            long r8 = r19.p()
            long r10 = (long) r12
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 == 0) goto L_0x009b
            r2.f4296a = r10
            goto L_0x00cd
        L_0x009b:
            r7.D(r4)
            r19.f()
            byte[] r2 = r7.f8414a
            r1.m(r2, r12, r4)
            int r1 = r7.f8415b
            int r2 = r7.f8416c
        L_0x00aa:
            int r4 = r2 + -3
            if (r1 >= r4) goto L_0x00c8
            byte[] r4 = r7.f8414a
            int r4 = f3.a0.b(r1, r4)
            if (r4 != r6) goto L_0x00c5
            int r4 = r1 + 4
            r7.G(r4)
            long r8 = f3.a0.c(r7)
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x00c5
            r13 = r8
            goto L_0x00c8
        L_0x00c5:
            int r1 = r1 + 1
            goto L_0x00aa
        L_0x00c8:
            r5.f5481f = r13
            r5.f5479d = r3
        L_0x00cc:
            r3 = 0
        L_0x00cd:
            r12 = r3
            goto L_0x010a
        L_0x00cf:
            long r2 = r5.f5481f
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x00d6
            goto L_0x0107
        L_0x00d6:
            j1.h0 r4 = r5.f5476a
            long r2 = r4.b(r2)
            long r6 = r5.f5482g
            long r6 = r4.b(r6)
            long r6 = r6 - r2
            r5.f5483h = r6
            r8 = 0
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0107
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid duration: "
            r2.<init>(r3)
            long r3 = r5.f5483h
            r2.append(r3)
            java.lang.String r3 = ". Using TIME_UNSET instead."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "PsDurationReader"
            j1.v.g(r3, r2)
            r5.f5483h = r13
        L_0x0107:
            r5.a(r1)
        L_0x010a:
            return r12
        L_0x010b:
            r8 = 0
            boolean r4 = r0.f5516k
            if (r4 != 0) goto L_0x0138
            r0.f5516k = r3
            long r6 = r5.f5483h
            int r4 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x012b
            g2.a r13 = new g2.a
            j1.h0 r5 = r5.f5476a
            r4 = r13
            r14 = 442(0x1ba, float:6.2E-43)
            r8 = r10
            r4.<init>(r5, r6, r8)
            r0.f5514i = r13
            d2.y r4 = r0.f5515j
            d2.f r5 = r13.f4219a
            goto L_0x0134
        L_0x012b:
            r14 = 442(0x1ba, float:6.2E-43)
            d2.y r4 = r0.f5515j
            d2.e0 r5 = new d2.e0
            r5.<init>(r6)
        L_0x0134:
            r4.g(r5)
            goto L_0x013a
        L_0x0138:
            r14 = 442(0x1ba, float:6.2E-43)
        L_0x013a:
            g2.a r4 = r0.f5514i
            if (r4 == 0) goto L_0x014c
            d2.h r5 = r4.f4221c
            if (r5 == 0) goto L_0x0144
            r5 = 1
            goto L_0x0145
        L_0x0144:
            r5 = 0
        L_0x0145:
            if (r5 == 0) goto L_0x014c
            int r1 = r4.a(r1, r2)
            return r1
        L_0x014c:
            r19.f()
            if (r15 == 0) goto L_0x0157
            long r4 = r19.l()
            long r10 = r10 - r4
            goto L_0x0159
        L_0x0157:
            r10 = -1
        L_0x0159:
            r2 = -1
            r4 = -1
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0167
            r4 = 4
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0167
            return r2
        L_0x0167:
            j1.b0 r4 = r0.f5508c
            byte[] r5 = r4.f8414a
            r6 = 4
            boolean r5 = r1.k(r5, r12, r6, r3)
            if (r5 != 0) goto L_0x0173
            return r2
        L_0x0173:
            r4.G(r12)
            int r5 = r4.f()
            r7 = 441(0x1b9, float:6.18E-43)
            if (r5 != r7) goto L_0x017f
            return r2
        L_0x017f:
            if (r5 != r14) goto L_0x0196
            byte[] r2 = r4.f8414a
            r3 = 10
            r1.m(r2, r12, r3)
            r2 = 9
            r4.G(r2)
            int r2 = r4.v()
            r2 = r2 & 7
            int r2 = r2 + 14
            goto L_0x01a9
        L_0x0196:
            r2 = 443(0x1bb, float:6.21E-43)
            r7 = 2
            r8 = 6
            if (r5 != r2) goto L_0x01ad
            byte[] r2 = r4.f8414a
            r1.m(r2, r12, r7)
            r4.G(r12)
            int r2 = r4.A()
            int r2 = r2 + r8
        L_0x01a9:
            r1.g(r2)
            return r12
        L_0x01ad:
            r2 = r5 & -256(0xffffffffffffff00, float:NaN)
            r9 = 8
            int r2 = r2 >> r9
            if (r2 == r3) goto L_0x01b8
            r1.g(r3)
            return r12
        L_0x01b8:
            r2 = r5 & 255(0xff, float:3.57E-43)
            android.util.SparseArray r5 = r0.f5507b
            java.lang.Object r10 = r5.get(r2)
            f3.b0 r10 = (f3.b0) r10
            boolean r11 = r0.f5510e
            if (r11 != 0) goto L_0x022d
            if (r10 != 0) goto L_0x020d
            r11 = 189(0xbd, float:2.65E-43)
            if (r2 != r11) goto L_0x01d2
            f3.c r11 = new f3.c
            r11.<init>()
            goto L_0x01dd
        L_0x01d2:
            r11 = r2 & 224(0xe0, float:3.14E-43)
            r13 = 192(0xc0, float:2.69E-43)
            if (r11 != r13) goto L_0x01e0
            f3.x r11 = new f3.x
            r11.<init>()
        L_0x01dd:
            r0.f5511f = r3
            goto L_0x01ed
        L_0x01e0:
            r11 = r2 & 240(0xf0, float:3.36E-43)
            r13 = 224(0xe0, float:3.14E-43)
            if (r11 != r13) goto L_0x01f4
            f3.m r11 = new f3.m
            r11.<init>()
            r0.f5512g = r3
        L_0x01ed:
            long r13 = r19.p()
            r0.f5513h = r13
            goto L_0x01f5
        L_0x01f4:
            r11 = 0
        L_0x01f5:
            if (r11 == 0) goto L_0x020d
            f3.j0 r10 = new f3.j0
            r13 = 256(0x100, float:3.59E-43)
            r10.<init>(r2, r13)
            d2.y r13 = r0.f5515j
            r11.d(r13, r10)
            f3.b0 r10 = new f3.b0
            j1.h0 r13 = r0.f5506a
            r10.<init>(r11, r13)
            r5.put(r2, r10)
        L_0x020d:
            boolean r2 = r0.f5511f
            if (r2 == 0) goto L_0x021b
            boolean r2 = r0.f5512g
            if (r2 == 0) goto L_0x021b
            long r13 = r0.f5513h
            r15 = 8192(0x2000, double:4.0474E-320)
            long r13 = r13 + r15
            goto L_0x021e
        L_0x021b:
            r13 = 1048576(0x100000, double:5.180654E-318)
        L_0x021e:
            long r15 = r19.p()
            int r2 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x022d
            r0.f5510e = r3
            d2.y r2 = r0.f5515j
            r2.a()
        L_0x022d:
            byte[] r2 = r4.f8414a
            r1.m(r2, r12, r7)
            r4.G(r12)
            int r2 = r4.A()
            int r2 = r2 + r8
            if (r10 != 0) goto L_0x0241
            r1.g(r2)
            goto L_0x02f0
        L_0x0241:
            r4.D(r2)
            byte[] r5 = r4.f8414a
            r1.readFully(r5, r12, r2)
            r4.G(r8)
            j1.a0 r1 = r10.f5489c
            byte[] r2 = r1.f8405a
            r5 = 3
            r4.d(r2, r12, r5)
            r1.k(r12)
            r1.m(r9)
            boolean r2 = r1.f()
            r10.f5490d = r2
            boolean r2 = r1.f()
            r10.f5491e = r2
            r1.m(r8)
            int r2 = r1.g(r9)
            byte[] r7 = r1.f8405a
            r4.d(r7, r12, r2)
            r1.k(r12)
            r7 = 0
            r10.f5493g = r7
            boolean r2 = r10.f5490d
            if (r2 == 0) goto L_0x02dc
            r1.m(r6)
            int r2 = r1.g(r5)
            long r7 = (long) r2
            r2 = 30
            long r7 = r7 << r2
            r1.m(r3)
            r9 = 15
            int r11 = r1.g(r9)
            int r11 = r11 << r9
            long r13 = (long) r11
            long r7 = r7 | r13
            r1.m(r3)
            int r11 = r1.g(r9)
            long r13 = (long) r11
            long r7 = r7 | r13
            r1.m(r3)
            boolean r11 = r10.f5492f
            j1.h0 r13 = r10.f5488b
            if (r11 != 0) goto L_0x02d2
            boolean r11 = r10.f5491e
            if (r11 == 0) goto L_0x02d2
            r1.m(r6)
            int r5 = r1.g(r5)
            long r14 = (long) r5
            long r14 = r14 << r2
            r1.m(r3)
            int r2 = r1.g(r9)
            int r2 = r2 << r9
            r16 = r7
            long r6 = (long) r2
            long r5 = r14 | r6
            r1.m(r3)
            int r2 = r1.g(r9)
            long r7 = (long) r2
            long r5 = r5 | r7
            r1.m(r3)
            r13.b(r5)
            r10.f5492f = r3
            goto L_0x02d4
        L_0x02d2:
            r16 = r7
        L_0x02d4:
            r1 = r16
            long r1 = r13.b(r1)
            r10.f5493g = r1
        L_0x02dc:
            long r1 = r10.f5493g
            f3.k r3 = r10.f5487a
            r5 = 4
            r3.e(r5, r1)
            r3.c(r4)
            r3.f()
            byte[] r1 = r4.f8414a
            int r1 = r1.length
            r4.F(r1)
        L_0x02f0:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.c0.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f5515j = yVar;
    }

    public final boolean h(w wVar) {
        byte[] bArr = new byte[14];
        p pVar = (p) wVar;
        pVar.k(bArr, 0, 14, false);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        pVar.h(bArr[13] & 7, false);
        pVar.k(bArr, 0, 3, false);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }
}
