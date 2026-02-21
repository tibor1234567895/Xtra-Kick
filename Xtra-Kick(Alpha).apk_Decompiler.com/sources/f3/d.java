package f3;

import d2.e0;
import d2.s0;
import d2.v;
import d2.w;
import d2.y;
import j1.b0;

public final class d implements v {

    /* renamed from: a  reason: collision with root package name */
    public final e f5517a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5518b = new b0(16384);

    /* renamed from: c  reason: collision with root package name */
    public boolean f5519c;

    public final void a() {
    }

    public final void c(long j10, long j11) {
        this.f5519c = false;
        this.f5517a.a();
    }

    public final int d(w wVar, s0 s0Var) {
        b0 b0Var = this.f5518b;
        int o10 = wVar.o(b0Var.f8414a, 0, 16384);
        if (o10 == -1) {
            return -1;
        }
        b0Var.G(0);
        b0Var.F(o10);
        boolean z10 = this.f5519c;
        e eVar = this.f5517a;
        if (!z10) {
            eVar.e(4, 0);
            this.f5519c = true;
        }
        eVar.c(b0Var);
        return 0;
    }

    public final void e(y yVar) {
        this.f5517a.d(yVar, new j0(0, 1));
        yVar.a();
        yVar.g(new e0(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        r5.f4276f = 0;
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if ((r4 - r3) < 8192) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(d2.w r15) {
        /*
            r14 = this;
            j1.b0 r0 = new j1.b0
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f8414a
            r5 = r15
            d2.p r5 = (d2.p) r5
            r5.k(r4, r2, r1, r2)
            r0.G(r2)
            int r4 = r0.x()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L_0x008e
            r5.f4276f = r2
            r5.h(r3, r2)
            r4 = r3
        L_0x0024:
            r15 = 0
        L_0x0025:
            byte[] r1 = r0.f8414a
            r6 = 7
            r5.k(r1, r2, r6, r2)
            r0.G(r2)
            int r1 = r0.A()
            r8 = 1
            r9 = 44096(0xac40, float:6.1792E-41)
            r10 = 44097(0xac41, float:6.1793E-41)
            if (r1 == r9) goto L_0x004b
            if (r1 == r10) goto L_0x004b
            r5.f4276f = r2
            int r4 = r4 + r8
            int r15 = r4 - r3
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r15 < r1) goto L_0x0047
            return r2
        L_0x0047:
            r5.h(r4, r2)
            goto L_0x0024
        L_0x004b:
            int r15 = r15 + r8
            r9 = 4
            if (r15 < r9) goto L_0x0050
            return r8
        L_0x0050:
            byte[] r8 = r0.f8414a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r6) goto L_0x0058
            r11 = -1
            goto L_0x0085
        L_0x0058:
            r11 = 2
            byte r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            byte r13 = r8[r7]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L_0x007f
            byte r9 = r8[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << 16
            r11 = 5
            byte r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r9 = r9 | r11
            r11 = 6
            byte r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r9 | r8
            goto L_0x0080
        L_0x007f:
            r6 = 4
        L_0x0080:
            if (r1 != r10) goto L_0x0084
            int r6 = r6 + 2
        L_0x0084:
            int r11 = r11 + r6
        L_0x0085:
            if (r11 != r12) goto L_0x0088
            return r2
        L_0x0088:
            int r11 = r11 + -7
            r5.h(r11, r2)
            goto L_0x0025
        L_0x008e:
            r0.H(r7)
            int r4 = r0.u()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.h(r4, r2)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.d.h(d2.w):boolean");
    }
}
