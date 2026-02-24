package f3;

import d2.e0;
import d2.s0;
import d2.v;
import d2.w;
import d2.y;
import j1.b0;

public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    public final c f5484a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5485b = new b0(2786);

    /* renamed from: c  reason: collision with root package name */
    public boolean f5486c;

    public final void a() {
    }

    public final void c(long j10, long j11) {
        this.f5486c = false;
        this.f5484a.a();
    }

    public final int d(w wVar, s0 s0Var) {
        b0 b0Var = this.f5485b;
        int o10 = wVar.o(b0Var.f8414a, 0, 2786);
        if (o10 == -1) {
            return -1;
        }
        b0Var.G(0);
        b0Var.F(o10);
        boolean z10 = this.f5486c;
        c cVar = this.f5484a;
        if (!z10) {
            cVar.e(4, 0);
            this.f5486c = true;
        }
        cVar.c(b0Var);
        return 0;
    }

    public final void e(y yVar) {
        this.f5484a.d(yVar, new j0(0, 1));
        yVar.a();
        yVar.g(new e0(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
        r5.f4276f = 0;
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if ((r4 - r3) < 8192) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(d2.w r14) {
        /*
            r13 = this;
            j1.b0 r0 = new j1.b0
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f8414a
            r5 = r14
            d2.p r5 = (d2.p) r5
            r5.k(r4, r2, r1, r2)
            r0.G(r2)
            int r4 = r0.x()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L_0x0084
            r5.f4276f = r2
            r5.h(r3, r2)
            r4 = r3
        L_0x0024:
            r14 = 0
        L_0x0025:
            byte[] r6 = r0.f8414a
            r8 = 6
            r5.k(r6, r2, r8, r2)
            r0.G(r2)
            int r6 = r0.A()
            r9 = 2935(0xb77, float:4.113E-42)
            r10 = 1
            if (r6 == r9) goto L_0x0045
            r5.f4276f = r2
            int r4 = r4 + r10
            int r14 = r4 - r3
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r14 < r6) goto L_0x0041
            return r2
        L_0x0041:
            r5.h(r4, r2)
            goto L_0x0024
        L_0x0045:
            int r14 = r14 + r10
            r6 = 4
            if (r14 < r6) goto L_0x004a
            return r10
        L_0x004a:
            byte[] r9 = r0.f8414a
            int r11 = r9.length
            r12 = -1
            if (r11 >= r8) goto L_0x0052
            r8 = -1
            goto L_0x007b
        L_0x0052:
            r11 = 5
            byte r11 = r9[r11]
            r11 = r11 & 248(0xf8, float:3.48E-43)
            int r11 = r11 >> r7
            if (r11 <= r1) goto L_0x005c
            r11 = 1
            goto L_0x005d
        L_0x005c:
            r11 = 0
        L_0x005d:
            if (r11 == 0) goto L_0x006f
            r6 = 2
            byte r8 = r9[r6]
            r8 = r8 & 7
            int r8 = r8 << 8
            byte r9 = r9[r7]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r8 = r8 | r9
            int r8 = r8 + r10
            int r8 = r8 * 2
            goto L_0x007b
        L_0x006f:
            byte r6 = r9[r6]
            r9 = r6 & 192(0xc0, float:2.69E-43)
            int r8 = r9 >> 6
            r6 = r6 & 63
            int r8 = d2.c.a(r8, r6)
        L_0x007b:
            if (r8 != r12) goto L_0x007e
            return r2
        L_0x007e:
            int r8 = r8 + -6
            r5.h(r8, r2)
            goto L_0x0025
        L_0x0084:
            r0.H(r7)
            int r4 = r0.u()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.h(r4, r2)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.h(d2.w):boolean");
    }
}
