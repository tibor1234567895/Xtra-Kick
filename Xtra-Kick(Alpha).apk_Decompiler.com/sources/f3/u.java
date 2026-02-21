package f3;

import android.support.v4.media.n;
import d2.p0;
import d2.x0;
import d2.y;
import j1.b0;

public final class u implements k {

    /* renamed from: a  reason: collision with root package name */
    public final n f5744a;

    /* renamed from: b  reason: collision with root package name */
    public String f5745b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f5746c;

    /* renamed from: d  reason: collision with root package name */
    public t f5747d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5748e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f5749f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    public final y f5750g = new y(32);

    /* renamed from: h  reason: collision with root package name */
    public final y f5751h = new y(33);

    /* renamed from: i  reason: collision with root package name */
    public final y f5752i = new y(34);

    /* renamed from: j  reason: collision with root package name */
    public final y f5753j = new y(39);

    /* renamed from: k  reason: collision with root package name */
    public final y f5754k = new y(40);

    /* renamed from: l  reason: collision with root package name */
    public long f5755l;

    /* renamed from: m  reason: collision with root package name */
    public long f5756m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    public final b0 f5757n = new b0();

    public u(n nVar) {
        this.f5744a = nVar;
    }

    public final void a() {
        this.f5755l = 0;
        this.f5756m = -9223372036854775807L;
        p0.a(this.f5749f);
        this.f5750g.c();
        this.f5751h.c();
        this.f5752i.c();
        this.f5753j.c();
        this.f5754k.c();
        t tVar = this.f5747d;
        if (tVar != null) {
            tVar.f5736f = false;
            tVar.f5737g = false;
            tVar.f5738h = false;
            tVar.f5739i = false;
            tVar.f5740j = false;
        }
    }

    public final void b(byte[] bArr, int i10, int i11) {
        boolean z10;
        t tVar = this.f5747d;
        if (tVar.f5736f) {
            int i12 = tVar.f5734d;
            int i13 = (i10 + 2) - i12;
            if (i13 < i11) {
                if ((bArr[i13] & 128) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                tVar.f5737g = z10;
                tVar.f5736f = false;
            } else {
                tVar.f5734d = (i11 - i10) + i12;
            }
        }
        if (!this.f5748e) {
            this.f5750g.a(bArr, i10, i11);
            this.f5751h.a(bArr, i10, i11);
            this.f5752i.a(bArr, i10, i11);
        }
        this.f5753j.a(bArr, i10, i11);
        this.f5754k.a(bArr, i10, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x023c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x022d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r36) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            d2.x0 r2 = r0.f5746c
            j1.a.f(r2)
            int r2 = j1.l0.f8453a
        L_0x000b:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r4 = r2 - r3
            if (r4 <= 0) goto L_0x0250
            byte[] r5 = r1.f8414a
            long r6 = r0.f5755l
            long r8 = (long) r4
            long r6 = r6 + r8
            r0.f5755l = r6
            d2.x0 r6 = r0.f5746c
            r6.d(r4, r1)
        L_0x0020:
            if (r3 >= r2) goto L_0x024c
            boolean[] r4 = r0.f5749f
            int r4 = d2.p0.b(r5, r3, r2, r4)
            if (r4 != r2) goto L_0x002e
            r0.b(r5, r3, r2)
            return
        L_0x002e:
            int r6 = r4 + 3
            byte r7 = r5[r6]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            r8 = 1
            int r7 = r7 >> r8
            int r9 = r4 - r3
            if (r9 <= 0) goto L_0x003d
            r0.b(r5, r3, r4)
        L_0x003d:
            int r15 = r2 - r4
            long r3 = r0.f5755l
            long r10 = (long) r15
            long r3 = r3 - r10
            r14 = 0
            if (r9 >= 0) goto L_0x0048
            int r9 = -r9
            goto L_0x0049
        L_0x0048:
            r9 = 0
        L_0x0049:
            long r10 = r0.f5756m
            f3.t r12 = r0.f5747d
            boolean r13 = r0.f5748e
            boolean r8 = r12.f5740j
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 == 0) goto L_0x0063
            boolean r8 = r12.f5737g
            if (r8 == 0) goto L_0x0063
            boolean r8 = r12.f5733c
            r12.f5743m = r8
            r12.f5740j = r14
            goto L_0x006c
        L_0x0063:
            boolean r8 = r12.f5738h
            if (r8 != 0) goto L_0x0074
            boolean r8 = r12.f5737g
            if (r8 == 0) goto L_0x006c
            goto L_0x0074
        L_0x006c:
            r19 = r2
            r27 = r5
            r28 = r6
            r8 = r15
            goto L_0x00bf
        L_0x0074:
            if (r13 == 0) goto L_0x00a9
            boolean r8 = r12.f5739i
            if (r8 == 0) goto L_0x00a9
            r8 = r15
            long r14 = r12.f5732b
            r19 = r2
            long r1 = r3 - r14
            int r2 = (int) r1
            int r25 = r2 + r8
            long r1 = r12.f5742l
            int r13 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r13 != 0) goto L_0x008f
            r27 = r5
            r28 = r6
            goto L_0x00b0
        L_0x008f:
            boolean r13 = r12.f5743m
            r27 = r5
            r28 = r6
            long r5 = r12.f5741k
            long r14 = r14 - r5
            int r5 = (int) r14
            d2.x0 r6 = r12.f5731a
            r26 = 0
            r20 = r6
            r21 = r1
            r23 = r13
            r24 = r5
            r20.e(r21, r23, r24, r25, r26)
            goto L_0x00b0
        L_0x00a9:
            r19 = r2
            r27 = r5
            r28 = r6
            r8 = r15
        L_0x00b0:
            long r1 = r12.f5732b
            r12.f5741k = r1
            long r1 = r12.f5735e
            r12.f5742l = r1
            boolean r1 = r12.f5733c
            r12.f5743m = r1
            r1 = 1
            r12.f5739i = r1
        L_0x00bf:
            boolean r1 = r0.f5748e
            f3.y r2 = r0.f5752i
            f3.y r5 = r0.f5751h
            f3.y r6 = r0.f5750g
            if (r1 != 0) goto L_0x0161
            r6.b(r9)
            r5.b(r9)
            r2.b(r9)
            boolean r1 = r6.f5799c
            if (r1 == 0) goto L_0x0161
            boolean r1 = r5.f5799c
            if (r1 == 0) goto L_0x0161
            boolean r1 = r2.f5799c
            if (r1 == 0) goto L_0x0161
            d2.x0 r1 = r0.f5746c
            java.lang.String r12 = r0.f5745b
            int r13 = r6.f5801e
            int r14 = r5.f5801e
            int r14 = r14 + r13
            int r15 = r2.f5801e
            int r14 = r14 + r15
            byte[] r14 = new byte[r14]
            byte[] r15 = r6.f5800d
            r20 = r8
            r8 = 0
            java.lang.System.arraycopy(r15, r8, r14, r8, r13)
            byte[] r13 = r5.f5800d
            int r15 = r6.f5801e
            r21 = r7
            int r7 = r5.f5801e
            java.lang.System.arraycopy(r13, r8, r14, r15, r7)
            byte[] r7 = r2.f5800d
            int r13 = r6.f5801e
            int r15 = r5.f5801e
            int r13 = r13 + r15
            int r15 = r2.f5801e
            java.lang.System.arraycopy(r7, r8, r14, r13, r15)
            byte[] r7 = r5.f5800d
            int r8 = r5.f5801e
            r13 = 3
            d2.m0 r7 = d2.p0.c(r7, r13, r8)
            int r8 = r7.f4230a
            boolean r13 = r7.f4231b
            int r15 = r7.f4232c
            r22 = r2
            int r2 = r7.f4233d
            r23 = r5
            int[] r5 = r7.f4234e
            r24 = r6
            int r6 = r7.f4235f
            r29 = r8
            r30 = r13
            r31 = r15
            r32 = r2
            r33 = r5
            r34 = r6
            java.lang.String r2 = j1.e.b(r29, r30, r31, r32, r33, r34)
            g1.z r5 = new g1.z
            r5.<init>()
            r5.f6744a = r12
            java.lang.String r6 = "video/hevc"
            r5.f6754k = r6
            r5.f6751h = r2
            int r2 = r7.f4236g
            r5.f6759p = r2
            int r2 = r7.f4237h
            r5.f6760q = r2
            float r2 = r7.f4238i
            r5.f6763t = r2
            java.util.List r2 = java.util.Collections.singletonList(r14)
            r5.f6756m = r2
            g1.a0 r2 = new g1.a0
            r2.<init>(r5)
            r1.a(r2)
            r1 = 1
            r0.f5748e = r1
            goto L_0x016b
        L_0x0161:
            r22 = r2
            r23 = r5
            r24 = r6
            r21 = r7
            r20 = r8
        L_0x016b:
            f3.y r1 = r0.f5753j
            boolean r2 = r1.b(r9)
            android.support.v4.media.n r5 = r0.f5744a
            r6 = 5
            j1.b0 r7 = r0.f5757n
            if (r2 == 0) goto L_0x018f
            byte[] r2 = r1.f5800d
            int r8 = r1.f5801e
            int r2 = d2.p0.f(r8, r2)
            byte[] r8 = r1.f5800d
            r7.E(r2, r8)
            r7.H(r6)
            java.lang.Object r2 = r5.f338j
            d2.x0[] r2 = (d2.x0[]) r2
            d2.m.a(r10, r7, r2)
        L_0x018f:
            f3.y r2 = r0.f5754k
            boolean r8 = r2.b(r9)
            if (r8 == 0) goto L_0x01ae
            byte[] r8 = r2.f5800d
            int r9 = r2.f5801e
            int r8 = d2.p0.f(r9, r8)
            byte[] r9 = r2.f5800d
            r7.E(r8, r9)
            r7.H(r6)
            java.lang.Object r5 = r5.f338j
            d2.x0[] r5 = (d2.x0[]) r5
            d2.m.a(r10, r7, r5)
        L_0x01ae:
            long r5 = r0.f5756m
            f3.t r7 = r0.f5747d
            boolean r8 = r0.f5748e
            r9 = 0
            r7.f5737g = r9
            r7.f5738h = r9
            r7.f5735e = r5
            r7.f5734d = r9
            r7.f5732b = r3
            r5 = 32
            r6 = r21
            if (r6 < r5) goto L_0x01cc
            r10 = 40
            if (r6 != r10) goto L_0x01ca
            goto L_0x01cc
        L_0x01ca:
            r10 = 0
            goto L_0x01cd
        L_0x01cc:
            r10 = 1
        L_0x01cd:
            if (r10 != 0) goto L_0x020e
            boolean r10 = r7.f5739i
            if (r10 == 0) goto L_0x01f5
            boolean r10 = r7.f5740j
            if (r10 != 0) goto L_0x01f5
            if (r8 == 0) goto L_0x01f1
            long r11 = r7.f5742l
            int r8 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x01e0
            goto L_0x01f1
        L_0x01e0:
            boolean r13 = r7.f5743m
            long r14 = r7.f5741k
            long r3 = r3 - r14
            int r14 = (int) r3
            d2.x0 r10 = r7.f5731a
            r16 = 0
            r3 = 0
            r15 = r20
            r10.e(r11, r13, r14, r15, r16)
            goto L_0x01f2
        L_0x01f1:
            r3 = 0
        L_0x01f2:
            r7.f5739i = r3
            goto L_0x01f6
        L_0x01f5:
            r3 = 0
        L_0x01f6:
            if (r5 > r6) goto L_0x01fc
            r4 = 35
            if (r6 <= r4) goto L_0x0200
        L_0x01fc:
            r4 = 39
            if (r6 != r4) goto L_0x0202
        L_0x0200:
            r14 = 1
            goto L_0x0203
        L_0x0202:
            r14 = 0
        L_0x0203:
            if (r14 == 0) goto L_0x020f
            boolean r4 = r7.f5740j
            r5 = 1
            r4 = r4 ^ r5
            r7.f5738h = r4
            r7.f5740j = r5
            goto L_0x0210
        L_0x020e:
            r3 = 0
        L_0x020f:
            r5 = 1
        L_0x0210:
            r4 = 16
            if (r6 < r4) goto L_0x021a
            r4 = 21
            if (r6 > r4) goto L_0x021a
            r14 = 1
            goto L_0x021b
        L_0x021a:
            r14 = 0
        L_0x021b:
            r7.f5733c = r14
            if (r14 != 0) goto L_0x0226
            r4 = 9
            if (r6 > r4) goto L_0x0224
            goto L_0x0226
        L_0x0224:
            r8 = 0
            goto L_0x0227
        L_0x0226:
            r8 = 1
        L_0x0227:
            r7.f5736f = r8
            boolean r3 = r0.f5748e
            if (r3 != 0) goto L_0x023c
            r3 = r24
            r3.d(r6)
            r3 = r23
            r3.d(r6)
            r3 = r22
            r3.d(r6)
        L_0x023c:
            r1.d(r6)
            r2.d(r6)
            r1 = r36
            r2 = r19
            r5 = r27
            r3 = r28
            goto L_0x0020
        L_0x024c:
            r1 = r36
            goto L_0x000b
        L_0x0250:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.u.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5745b = j0Var.f5631e;
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 2);
        this.f5746c = d10;
        this.f5747d = new t(d10);
        this.f5744a.m(yVar, j0Var);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5756m = j10;
        }
    }

    public final void f() {
    }
}
