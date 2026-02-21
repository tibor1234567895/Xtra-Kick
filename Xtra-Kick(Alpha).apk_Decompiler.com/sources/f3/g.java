package f3;

import d2.u;
import d2.x0;
import d2.y;
import g1.z;
import j1.a0;
import j1.b0;
import java.util.Arrays;

public final class g implements k {

    /* renamed from: v  reason: collision with root package name */
    public static final byte[] f5560v = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5561a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f5562b = new a0(7, new byte[7]);

    /* renamed from: c  reason: collision with root package name */
    public final b0 f5563c = new b0(Arrays.copyOf(f5560v, 10));

    /* renamed from: d  reason: collision with root package name */
    public final String f5564d;

    /* renamed from: e  reason: collision with root package name */
    public String f5565e;

    /* renamed from: f  reason: collision with root package name */
    public x0 f5566f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f5567g;

    /* renamed from: h  reason: collision with root package name */
    public int f5568h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f5569i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f5570j = 256;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5571k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5572l;

    /* renamed from: m  reason: collision with root package name */
    public int f5573m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f5574n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f5575o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5576p;

    /* renamed from: q  reason: collision with root package name */
    public long f5577q = -9223372036854775807L;

    /* renamed from: r  reason: collision with root package name */
    public int f5578r;

    /* renamed from: s  reason: collision with root package name */
    public long f5579s = -9223372036854775807L;

    /* renamed from: t  reason: collision with root package name */
    public x0 f5580t;

    /* renamed from: u  reason: collision with root package name */
    public long f5581u;

    public g(String str, boolean z10) {
        this.f5561a = z10;
        this.f5564d = str;
    }

    public final void a() {
        this.f5579s = -9223372036854775807L;
        this.f5572l = false;
        this.f5568h = 0;
        this.f5569i = 0;
        this.f5570j = 256;
    }

    public final boolean b(int i10, b0 b0Var, byte[] bArr) {
        int min = Math.min(b0Var.f8416c - b0Var.f8415b, i10 - this.f5569i);
        b0Var.d(bArr, this.f5569i, min);
        int i11 = this.f5569i + min;
        this.f5569i = i11;
        if (i11 == i10) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x027a, code lost:
        if (r5[r10] != 51) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025d, code lost:
        if (((r5 & 8) >> 3) == r8) goto L_0x027c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0281 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            d2.x0 r2 = r0.f5566f
            r2.getClass()
            int r2 = j1.l0.f8453a
        L_0x000b:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r4 = r2 - r3
            if (r4 <= 0) goto L_0x02f7
            int r5 = r0.f5568h
            r7 = 13
            r8 = 256(0x100, float:3.59E-43)
            r9 = 4
            r10 = 7
            r11 = 2
            r12 = 3
            r13 = 1
            r14 = 0
            j1.b0 r15 = r0.f5563c
            j1.a0 r6 = r0.f5562b
            if (r5 == 0) goto L_0x018f
            if (r5 == r13) goto L_0x0157
            r2 = 10
            if (r5 == r11) goto L_0x0131
            if (r5 == r12) goto L_0x0074
            if (r5 != r9) goto L_0x006e
            int r2 = r0.f5578r
            int r3 = r0.f5569i
            int r2 = r2 - r3
            int r2 = java.lang.Math.min(r4, r2)
            d2.x0 r3 = r0.f5580t
            r3.d(r2, r1)
            int r3 = r0.f5569i
            int r3 = r3 + r2
            r0.f5569i = r3
            int r2 = r0.f5578r
            if (r3 != r2) goto L_0x000b
            long r3 = r0.f5579s
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0067
            d2.x0 r15 = r0.f5580t
            r18 = 1
            r20 = 0
            r21 = 0
            r16 = r3
            r19 = r2
            r15.e(r16, r18, r19, r20, r21)
            long r2 = r0.f5579s
            long r4 = r0.f5581u
            long r2 = r2 + r4
            r0.f5579s = r2
        L_0x0067:
            r0.f5568h = r14
            r0.f5569i = r14
            r0.f5570j = r8
            goto L_0x000b
        L_0x006e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0074:
            boolean r3 = r0.f5571k
            r4 = 5
            if (r3 == 0) goto L_0x007b
            r3 = 7
            goto L_0x007c
        L_0x007b:
            r3 = 5
        L_0x007c:
            byte[] r5 = r6.f8405a
            boolean r3 = r0.b(r3, r1, r5)
            if (r3 == 0) goto L_0x000b
            r6.k(r14)
            boolean r3 = r0.f5576p
            if (r3 != 0) goto L_0x010e
            int r2 = r6.g(r11)
            int r2 = r2 + r13
            if (r2 == r11) goto L_0x00ab
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Detected audio object type: "
            r3.<init>(r5)
            r3.append(r2)
            java.lang.String r2 = ", but assuming AAC LC."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AdtsReader"
            j1.v.g(r3, r2)
            r2 = 2
        L_0x00ab:
            r6.m(r4)
            int r3 = r6.g(r12)
            int r5 = r0.f5574n
            byte[] r8 = new byte[r11]
            int r2 = r2 << r12
            r2 = r2 & 248(0xf8, float:3.48E-43)
            int r15 = r5 >> 1
            r15 = r15 & r10
            r2 = r2 | r15
            byte r2 = (byte) r2
            r8[r14] = r2
            int r2 = r5 << 7
            r2 = r2 & 128(0x80, float:1.794E-43)
            int r3 = r3 << r12
            r3 = r3 & 120(0x78, float:1.68E-43)
            r2 = r2 | r3
            byte r2 = (byte) r2
            r8[r13] = r2
            j1.a0 r2 = new j1.a0
            r2.<init>(r11, r8)
            j1.k r2 = d2.a.b(r2, r14)
            g1.z r3 = new g1.z
            r3.<init>()
            java.lang.String r5 = r0.f5565e
            r3.f6744a = r5
            java.lang.String r5 = "audio/mp4a-latm"
            r3.f6754k = r5
            java.lang.String r5 = r2.f8452c
            r3.f6751h = r5
            int r5 = r2.f8451b
            r3.f6767x = r5
            int r2 = r2.f8450a
            r3.f6768y = r2
            java.util.List r2 = java.util.Collections.singletonList(r8)
            r3.f6756m = r2
            java.lang.String r2 = r0.f5564d
            r3.f6746c = r2
            g1.a0 r2 = new g1.a0
            r2.<init>(r3)
            int r3 = r2.G
            long r14 = (long) r3
            r16 = 1024000000(0x3d090000, double:5.059232213E-315)
            long r14 = r16 / r14
            r0.f5577q = r14
            d2.x0 r3 = r0.f5566f
            r3.a(r2)
            r0.f5576p = r13
            goto L_0x0111
        L_0x010e:
            r6.m(r2)
        L_0x0111:
            r6.m(r9)
            int r2 = r6.g(r7)
            int r2 = r2 - r11
            int r2 = r2 - r4
            boolean r3 = r0.f5571k
            if (r3 == 0) goto L_0x0120
            int r2 = r2 + -2
        L_0x0120:
            d2.x0 r3 = r0.f5566f
            long r6 = r0.f5577q
            r0.f5568h = r9
            r4 = 0
            r0.f5569i = r4
            r0.f5580t = r3
            r0.f5581u = r6
            r0.f5578r = r2
            goto L_0x000b
        L_0x0131:
            byte[] r3 = r15.f8414a
            boolean r3 = r0.b(r2, r1, r3)
            if (r3 == 0) goto L_0x000b
            d2.x0 r3 = r0.f5567g
            r3.d(r2, r15)
            r3 = 6
            r15.G(r3)
            d2.x0 r3 = r0.f5567g
            int r4 = r15.u()
            int r4 = r4 + r2
            r0.f5568h = r9
            r0.f5569i = r2
            r0.f5580t = r3
            r2 = 0
            r0.f5581u = r2
            r0.f5578r = r4
            goto L_0x000b
        L_0x0157:
            if (r4 != 0) goto L_0x015b
            goto L_0x000b
        L_0x015b:
            byte[] r2 = r6.f8405a
            byte[] r4 = r1.f8414a
            byte r3 = r4[r3]
            r4 = 0
            r2[r4] = r3
            r6.k(r11)
            int r2 = r6.g(r9)
            int r3 = r0.f5574n
            r5 = -1
            if (r3 == r5) goto L_0x017c
            if (r2 == r3) goto L_0x017c
            r0.f5572l = r4
            r0.f5568h = r4
            r0.f5569i = r4
            r0.f5570j = r8
            goto L_0x000b
        L_0x017c:
            boolean r3 = r0.f5572l
            if (r3 != 0) goto L_0x0188
            r0.f5572l = r13
            int r3 = r0.f5575o
            r0.f5573m = r3
            r0.f5574n = r2
        L_0x0188:
            r0.f5568h = r12
            r2 = 0
            r0.f5569i = r2
            goto L_0x000b
        L_0x018f:
            byte[] r4 = r1.f8414a
        L_0x0191:
            if (r3 >= r2) goto L_0x02f2
            int r14 = r3 + 1
            byte r3 = r4[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r5 = r0.f5570j
            r8 = 512(0x200, float:7.175E-43)
            if (r5 != r8) goto L_0x02a1
            byte r5 = (byte) r3
            r5 = r5 & 255(0xff, float:3.57E-43)
            r19 = 65280(0xff00, float:9.1477E-41)
            r5 = r5 | r19
            r20 = 65526(0xfff6, float:9.1821E-41)
            r5 = r5 & r20
            r8 = 65520(0xfff0, float:9.1813E-41)
            if (r5 != r8) goto L_0x01b3
            r5 = 1
            goto L_0x01b4
        L_0x01b3:
            r5 = 0
        L_0x01b4:
            if (r5 == 0) goto L_0x02a1
            boolean r5 = r0.f5572l
            if (r5 != 0) goto L_0x0281
            int r22 = r14 + -2
            int r5 = r22 + 1
            r1.G(r5)
            byte[] r5 = r6.f8405a
            int r12 = r1.f8416c
            int r8 = r1.f8415b
            int r12 = r12 - r8
            if (r12 >= r13) goto L_0x01cd
            r17 = 0
            goto L_0x01d3
        L_0x01cd:
            r8 = 0
            r1.d(r5, r8, r13)
            r17 = 1
        L_0x01d3:
            if (r17 != 0) goto L_0x01d6
            goto L_0x0209
        L_0x01d6:
            r6.k(r9)
            int r8 = r6.g(r13)
            int r12 = r0.f5573m
            r5 = -1
            if (r12 == r5) goto L_0x01e5
            if (r8 == r12) goto L_0x01e5
            goto L_0x0209
        L_0x01e5:
            int r12 = r0.f5574n
            if (r12 == r5) goto L_0x0211
            byte[] r5 = r6.f8405a
            int r12 = r1.f8416c
            int r10 = r1.f8415b
            int r12 = r12 - r10
            if (r12 >= r13) goto L_0x01f5
            r17 = 0
            goto L_0x01fb
        L_0x01f5:
            r10 = 0
            r1.d(r5, r10, r13)
            r17 = 1
        L_0x01fb:
            if (r17 != 0) goto L_0x01fe
            goto L_0x0225
        L_0x01fe:
            r6.k(r11)
            int r10 = r6.g(r9)
            int r12 = r0.f5574n
            if (r10 == r12) goto L_0x020c
        L_0x0209:
            r12 = -1
            goto L_0x027e
        L_0x020c:
            int r10 = r22 + 2
            r1.G(r10)
        L_0x0211:
            byte[] r10 = r6.f8405a
            int r12 = r1.f8416c
            int r5 = r1.f8415b
            int r12 = r12 - r5
            if (r12 >= r9) goto L_0x021d
            r17 = 0
            goto L_0x0223
        L_0x021d:
            r5 = 0
            r1.d(r10, r5, r9)
            r17 = 1
        L_0x0223:
            if (r17 != 0) goto L_0x0227
        L_0x0225:
            r12 = -1
            goto L_0x027c
        L_0x0227:
            r10 = 14
            r6.k(r10)
            int r10 = r6.g(r7)
            r12 = 7
            if (r10 >= r12) goto L_0x0234
            goto L_0x0209
        L_0x0234:
            byte[] r5 = r1.f8414a
            int r7 = r1.f8416c
            int r10 = r22 + r10
            if (r10 < r7) goto L_0x023d
            goto L_0x0225
        L_0x023d:
            byte r9 = r5[r10]
            r12 = -1
            if (r9 != r12) goto L_0x0260
            int r10 = r10 + 1
            if (r10 != r7) goto L_0x0247
            goto L_0x027c
        L_0x0247:
            byte r5 = r5[r10]
            r7 = r5 & 255(0xff, float:3.57E-43)
            r7 = r7 | r19
            r7 = r7 & r20
            r9 = 65520(0xfff0, float:9.1813E-41)
            if (r7 != r9) goto L_0x0256
            r7 = 1
            goto L_0x0257
        L_0x0256:
            r7 = 0
        L_0x0257:
            if (r7 == 0) goto L_0x027e
            r5 = r5 & 8
            r7 = 3
            int r5 = r5 >> r7
            if (r5 != r8) goto L_0x027e
            goto L_0x027c
        L_0x0260:
            r8 = 73
            if (r9 == r8) goto L_0x0265
            goto L_0x027e
        L_0x0265:
            int r8 = r10 + 1
            if (r8 != r7) goto L_0x026a
            goto L_0x027c
        L_0x026a:
            byte r8 = r5[r8]
            r9 = 68
            if (r8 == r9) goto L_0x0271
            goto L_0x027e
        L_0x0271:
            int r10 = r10 + 2
            if (r10 != r7) goto L_0x0276
            goto L_0x027c
        L_0x0276:
            byte r5 = r5[r10]
            r7 = 51
            if (r5 != r7) goto L_0x027e
        L_0x027c:
            r5 = 1
            goto L_0x027f
        L_0x027e:
            r5 = 0
        L_0x027f:
            if (r5 == 0) goto L_0x02a2
        L_0x0281:
            r2 = r3 & 8
            r4 = 3
            int r2 = r2 >> r4
            r0.f5575o = r2
            r2 = r3 & 1
            if (r2 != 0) goto L_0x028d
            r5 = 1
            goto L_0x028e
        L_0x028d:
            r5 = 0
        L_0x028e:
            r0.f5571k = r5
            boolean r2 = r0.f5572l
            if (r2 != 0) goto L_0x029a
            r0.f5568h = r13
            r2 = 0
            r0.f5569i = r2
            goto L_0x02cf
        L_0x029a:
            r2 = 0
            r3 = 3
            r0.f5568h = r3
            r0.f5569i = r2
            goto L_0x02cf
        L_0x02a1:
            r12 = -1
        L_0x02a2:
            int r7 = r0.f5570j
            r3 = r3 | r7
            r8 = 329(0x149, float:4.61E-43)
            if (r3 == r8) goto L_0x02e2
            r8 = 511(0x1ff, float:7.16E-43)
            if (r3 == r8) goto L_0x02db
            r8 = 836(0x344, float:1.171E-42)
            if (r3 == r8) goto L_0x02d4
            r8 = 1075(0x433, float:1.506E-42)
            if (r3 == r8) goto L_0x02c4
            r8 = 256(0x100, float:3.59E-43)
            if (r7 == r8) goto L_0x02c1
            r0.f5570j = r8
            int r14 = r14 + -1
            r3 = r14
            r5 = 0
            r7 = 3
            goto L_0x02eb
        L_0x02c1:
            r5 = 0
            r7 = 3
            goto L_0x02ea
        L_0x02c4:
            r0.f5568h = r11
            r7 = 3
            r0.f5569i = r7
            r5 = 0
            r0.f5578r = r5
            r15.G(r5)
        L_0x02cf:
            r1.G(r14)
            goto L_0x000b
        L_0x02d4:
            r5 = 0
            r7 = 3
            r8 = 256(0x100, float:3.59E-43)
            r3 = 1024(0x400, float:1.435E-42)
            goto L_0x02e8
        L_0x02db:
            r5 = 0
            r7 = 3
            r8 = 256(0x100, float:3.59E-43)
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x02e8
        L_0x02e2:
            r5 = 0
            r7 = 3
            r8 = 256(0x100, float:3.59E-43)
            r3 = 768(0x300, float:1.076E-42)
        L_0x02e8:
            r0.f5570j = r3
        L_0x02ea:
            r3 = r14
        L_0x02eb:
            r7 = 13
            r9 = 4
            r10 = 7
            r12 = 3
            goto L_0x0191
        L_0x02f2:
            r1.G(r3)
            goto L_0x000b
        L_0x02f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.g.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5565e = j0Var.f5631e;
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 1);
        this.f5566f = d10;
        this.f5580t = d10;
        if (this.f5561a) {
            j0Var.a();
            j0Var.b();
            x0 d11 = yVar.d(j0Var.f5630d, 5);
            this.f5567g = d11;
            z zVar = new z();
            j0Var.b();
            zVar.f6744a = j0Var.f5631e;
            zVar.f6754k = "application/id3";
            d11.a(new g1.a0(zVar));
            return;
        }
        this.f5567g = new u();
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5579s = j10;
        }
    }

    public final void f() {
    }
}
