package v2;

import d2.b1;
import d2.v;
import d2.w;
import d2.y;
import j1.b0;
import j1.l0;

public final class e implements v {

    /* renamed from: a  reason: collision with root package name */
    public y f15856a;

    /* renamed from: b  reason: collision with root package name */
    public l f15857b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15858c;

    public final void a() {
    }

    public final boolean b(w wVar) {
        boolean z10;
        l lVar;
        boolean z11;
        g gVar = new g();
        if (gVar.a(wVar, true) && (gVar.f15864a & 2) == 2) {
            int min = Math.min(gVar.f15868e, 8);
            b0 b0Var = new b0(min);
            wVar.m(b0Var.f8414a, 0, min);
            b0Var.G(0);
            if (b0Var.f8416c - b0Var.f8415b >= 5 && b0Var.v() == 127 && b0Var.w() == 1179402563) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                lVar = new d();
            } else {
                b0Var.G(0);
                try {
                    z11 = b1.c(1, b0Var, true);
                } catch (g1.b1 unused) {
                    z11 = false;
                }
                if (z11) {
                    lVar = new n();
                } else {
                    b0Var.G(0);
                    if (i.e(b0Var, i.f15871o)) {
                        lVar = new i();
                    }
                }
            }
            this.f15857b = lVar;
            return true;
        }
        return false;
    }

    public final void c(long j10, long j11) {
        l lVar = this.f15857b;
        if (lVar != null) {
            f fVar = lVar.f15876a;
            g gVar = fVar.f15859a;
            gVar.f15864a = 0;
            gVar.f15865b = 0;
            gVar.f15866c = 0;
            gVar.f15867d = 0;
            gVar.f15868e = 0;
            fVar.f15860b.D(0);
            fVar.f15861c = -1;
            fVar.f15863e = false;
            if (j10 == 0) {
                lVar.d(!lVar.f15887l);
            } else if (lVar.f15883h != 0) {
                long j12 = (((long) lVar.f15884i) * j11) / 1000000;
                lVar.f15880e = j12;
                h hVar = lVar.f15879d;
                int i10 = l0.f8453a;
                hVar.c(j12);
                lVar.f15883h = 2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r22, d2.s0 r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            d2.y r2 = r0.f15856a
            j1.a.f(r2)
            v2.l r2 = r0.f15857b
            if (r2 != 0) goto L_0x001f
            boolean r2 = r21.b(r22)
            if (r2 == 0) goto L_0x0017
            r22.f()
            goto L_0x001f
        L_0x0017:
            java.lang.String r1 = "Failed to determine bitstream type"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x001f:
            boolean r2 = r0.f15858c
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x003d
            d2.y r2 = r0.f15856a
            d2.x0 r2 = r2.d(r4, r3)
            d2.y r5 = r0.f15856a
            r5.a()
            v2.l r5 = r0.f15857b
            d2.y r6 = r0.f15856a
            r5.f15878c = r6
            r5.f15877b = r2
            r5.d(r3)
            r0.f15858c = r3
        L_0x003d:
            v2.l r2 = r0.f15857b
            d2.x0 r5 = r2.f15877b
            j1.a.f(r5)
            int r5 = j1.l0.f8453a
            int r5 = r2.f15883h
            r6 = 2
            r7 = 3
            r8 = -1
            v2.f r10 = r2.f15876a
            if (r5 == 0) goto L_0x00e8
            if (r5 == r3) goto L_0x00de
            if (r5 == r6) goto L_0x005e
            if (r5 != r7) goto L_0x0058
            goto L_0x010f
        L_0x0058:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x005e:
            v2.h r5 = r2.f15879d
            long r5 = r5.b(r1)
            r11 = 0
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x0070
            r13 = r23
            r13.f4296a = r5
            goto L_0x0183
        L_0x0070:
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x007b
            r13 = 2
            long r5 = r5 + r13
            long r5 = -r5
            r2.a(r5)
        L_0x007b:
            boolean r5 = r2.f15887l
            if (r5 != 0) goto L_0x008f
            v2.h r5 = r2.f15879d
            d2.u0 r5 = r5.a()
            j1.a.f(r5)
            d2.y r6 = r2.f15878c
            r6.g(r5)
            r2.f15887l = r3
        L_0x008f:
            long r5 = r2.f15886k
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x009f
            boolean r1 = r10.a(r1)
            if (r1 == 0) goto L_0x009c
            goto L_0x009f
        L_0x009c:
            r2.f15883h = r7
            goto L_0x010f
        L_0x009f:
            r2.f15886k = r11
            j1.b0 r1 = r10.f15860b
            long r5 = r2.b(r1)
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 < 0) goto L_0x00d7
            long r10 = r2.f15882g
            long r12 = r10 + r5
            long r14 = r2.f15880e
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x00d7
            r12 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r10 * r12
            int r3 = r2.f15884i
            long r12 = (long) r3
            long r15 = r10 / r12
            d2.x0 r3 = r2.f15877b
            int r7 = r1.f8416c
            r3.d(r7, r1)
            d2.x0 r14 = r2.f15877b
            r17 = 1
            int r1 = r1.f8416c
            r19 = 0
            r20 = 0
            r18 = r1
            r14.e(r15, r17, r18, r19, r20)
            r2.f15880e = r8
        L_0x00d7:
            long r7 = r2.f15882g
            long r7 = r7 + r5
            r2.f15882g = r7
            goto L_0x0182
        L_0x00de:
            long r7 = r2.f15881f
            int r3 = (int) r7
            r1.g(r3)
            r2.f15883h = r6
            goto L_0x0182
        L_0x00e8:
            boolean r5 = r10.a(r1)
            j1.b0 r15 = r10.f15860b
            if (r5 != 0) goto L_0x00f4
            r2.f15883h = r7
            r5 = 0
            goto L_0x010d
        L_0x00f4:
            long r11 = r22.p()
            long r13 = r2.f15881f
            long r11 = r11 - r13
            r2.f15886k = r11
            v2.j r5 = r2.f15885j
            boolean r5 = r2.c(r15, r13, r5)
            if (r5 == 0) goto L_0x010c
            long r11 = r22.p()
            r2.f15881f = r11
            goto L_0x00e8
        L_0x010c:
            r5 = 1
        L_0x010d:
            if (r5 != 0) goto L_0x0112
        L_0x010f:
            r3 = -1
            goto L_0x0183
        L_0x0112:
            v2.j r5 = r2.f15885j
            g1.a0 r5 = r5.f15874a
            int r7 = r5.G
            r2.f15884i = r7
            boolean r7 = r2.f15888m
            if (r7 != 0) goto L_0x0125
            d2.x0 r7 = r2.f15877b
            r7.a(r5)
            r2.f15888m = r3
        L_0x0125:
            v2.j r5 = r2.f15885j
            v2.c r5 = r5.f15875b
            if (r5 == 0) goto L_0x012e
            r2.f15879d = r5
            goto L_0x013d
        L_0x012e:
            long r11 = r22.c()
            int r5 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x013f
            v2.k r1 = new v2.k
            r1.<init>(r4)
            r2.f15879d = r1
        L_0x013d:
            r1 = r15
            goto L_0x0168
        L_0x013f:
            v2.g r5 = r10.f15859a
            int r7 = r5.f15864a
            r7 = r7 & 4
            if (r7 == 0) goto L_0x014a
            r17 = 1
            goto L_0x014c
        L_0x014a:
            r17 = 0
        L_0x014c:
            v2.b r3 = new v2.b
            long r9 = r2.f15881f
            long r11 = r22.c()
            int r1 = r5.f15867d
            int r7 = r5.f15868e
            int r1 = r1 + r7
            long r13 = (long) r1
            long r7 = r5.f15865b
            r18 = r7
            r7 = r3
            r8 = r2
            r1 = r15
            r15 = r18
            r7.<init>(r8, r9, r11, r13, r15, r17)
            r2.f15879d = r3
        L_0x0168:
            r2.f15883h = r6
            byte[] r2 = r1.f8414a
            int r3 = r2.length
            r5 = 65025(0xfe01, float:9.112E-41)
            if (r3 != r5) goto L_0x0173
            goto L_0x0182
        L_0x0173:
            int r3 = r1.f8416c
            int r3 = java.lang.Math.max(r5, r3)
            byte[] r2 = java.util.Arrays.copyOf(r2, r3)
            int r3 = r1.f8416c
            r1.E(r3, r2)
        L_0x0182:
            r3 = 0
        L_0x0183:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.e.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f15856a = yVar;
    }

    public final boolean h(w wVar) {
        try {
            return b(wVar);
        } catch (g1.b1 unused) {
            return false;
        }
    }
}
