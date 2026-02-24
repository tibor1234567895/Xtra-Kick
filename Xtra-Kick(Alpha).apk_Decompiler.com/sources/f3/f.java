package f3;

import d2.p;
import d2.v;
import d2.w;
import d2.y;
import j1.a0;
import j1.b0;

public final class f implements v {

    /* renamed from: a  reason: collision with root package name */
    public final int f5539a;

    /* renamed from: b  reason: collision with root package name */
    public final g f5540b;

    /* renamed from: c  reason: collision with root package name */
    public final b0 f5541c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f5542d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f5543e;

    /* renamed from: f  reason: collision with root package name */
    public y f5544f;

    /* renamed from: g  reason: collision with root package name */
    public long f5545g;

    /* renamed from: h  reason: collision with root package name */
    public long f5546h;

    /* renamed from: i  reason: collision with root package name */
    public int f5547i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5548j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5549k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5550l;

    public f() {
        this(0);
    }

    public final void a() {
    }

    public final int b(w wVar) {
        int i10 = 0;
        while (true) {
            b0 b0Var = this.f5542d;
            wVar.m(b0Var.f8414a, 0, 10);
            b0Var.G(0);
            if (b0Var.x() != 4801587) {
                break;
            }
            b0Var.H(3);
            int u10 = b0Var.u();
            i10 += u10 + 10;
            wVar.n(u10);
        }
        wVar.f();
        wVar.n(i10);
        if (this.f5546h == -1) {
            this.f5546h = (long) i10;
        }
        return i10;
    }

    public final void c(long j10, long j11) {
        this.f5549k = false;
        this.f5540b.a();
        this.f5545g = j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0120 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r20, d2.s0 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            d2.y r2 = r0.f5544f
            j1.a.f(r2)
            long r6 = r20.c()
            int r2 = r0.f5539a
            r3 = r2 & 2
            r11 = 0
            r12 = 1
            if (r3 != 0) goto L_0x0022
            r4 = r2 & 1
            if (r4 == 0) goto L_0x0020
            r4 = -1
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r4 = 0
            goto L_0x0023
        L_0x0022:
            r4 = 1
        L_0x0023:
            r13 = -1
            r14 = 4
            if (r4 == 0) goto L_0x00ae
            j1.a0 r4 = r0.f5543e
            j1.b0 r5 = r0.f5542d
            boolean r8 = r0.f5548j
            if (r8 == 0) goto L_0x0031
            goto L_0x00ae
        L_0x0031:
            r0.f5547i = r13
            r20.f()
            long r8 = r20.p()
            r15 = 0
            int r10 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x0043
            r19.b(r20)
        L_0x0043:
            r8 = 0
        L_0x0044:
            byte[] r9 = r5.f8414a     // Catch:{ EOFException -> 0x009a }
            r10 = 2
            boolean r9 = r1.k(r9, r11, r10, r12)     // Catch:{ EOFException -> 0x009a }
            if (r9 == 0) goto L_0x009b
            r5.G(r11)     // Catch:{ EOFException -> 0x009a }
            int r9 = r5.A()     // Catch:{ EOFException -> 0x009a }
            r10 = 65526(0xfff6, float:9.1821E-41)
            r9 = r9 & r10
            r10 = 65520(0xfff0, float:9.1813E-41)
            if (r9 != r10) goto L_0x005f
            r9 = 1
            goto L_0x0060
        L_0x005f:
            r9 = 0
        L_0x0060:
            if (r9 != 0) goto L_0x0064
            r8 = 0
            goto L_0x009b
        L_0x0064:
            byte[] r9 = r5.f8414a     // Catch:{ EOFException -> 0x009a }
            boolean r9 = r1.k(r9, r11, r14, r12)     // Catch:{ EOFException -> 0x009a }
            if (r9 != 0) goto L_0x006d
            goto L_0x009b
        L_0x006d:
            r9 = 14
            r4.k(r9)     // Catch:{ EOFException -> 0x009a }
            r9 = 13
            int r9 = r4.g(r9)     // Catch:{ EOFException -> 0x009a }
            r10 = 6
            if (r9 <= r10) goto L_0x0090
            long r13 = (long) r9     // Catch:{ EOFException -> 0x009a }
            long r15 = r15 + r13
            int r8 = r8 + 1
            r10 = 1000(0x3e8, float:1.401E-42)
            if (r8 != r10) goto L_0x0084
            goto L_0x009b
        L_0x0084:
            int r9 = r9 + -6
            boolean r9 = r1.h(r9, r12)     // Catch:{ EOFException -> 0x009a }
            if (r9 != 0) goto L_0x008d
            goto L_0x009b
        L_0x008d:
            r13 = -1
            r14 = 4
            goto L_0x0044
        L_0x0090:
            r0.f5548j = r12     // Catch:{ EOFException -> 0x009a }
            java.lang.String r4 = "Malformed ADTS stream"
            r5 = 0
            g1.b1 r4 = g1.b1.a(r4, r5)     // Catch:{ EOFException -> 0x009a }
            throw r4     // Catch:{ EOFException -> 0x009a }
        L_0x009a:
        L_0x009b:
            r20.f()
            if (r8 <= 0) goto L_0x00a8
            long r4 = (long) r8
            long r4 = r15 / r4
            int r5 = (int) r4
            r0.f5547i = r5
            r4 = -1
            goto L_0x00ab
        L_0x00a8:
            r4 = -1
            r0.f5547i = r4
        L_0x00ab:
            r0.f5548j = r12
            goto L_0x00af
        L_0x00ae:
            r4 = -1
        L_0x00af:
            j1.b0 r13 = r0.f5541c
            byte[] r5 = r13.f8414a
            r8 = 2048(0x800, float:2.87E-42)
            int r1 = r1.o(r5, r11, r8)
            if (r1 != r4) goto L_0x00bd
            r14 = 1
            goto L_0x00be
        L_0x00bd:
            r14 = 0
        L_0x00be:
            boolean r4 = r0.f5550l
            f3.g r15 = r0.f5540b
            if (r4 == 0) goto L_0x00c5
            goto L_0x00de
        L_0x00c5:
            r2 = r2 & r12
            if (r2 == 0) goto L_0x00ce
            int r2 = r0.f5547i
            if (r2 <= 0) goto L_0x00ce
            r2 = 1
            goto L_0x00cf
        L_0x00ce:
            r2 = 0
        L_0x00cf:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x00e2
            long r8 = r15.f5577q
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x00e2
            if (r14 != 0) goto L_0x00e2
        L_0x00de:
            r18 = r15
            r2 = 1
            goto L_0x011e
        L_0x00e2:
            if (r2 == 0) goto L_0x010f
            long r8 = r15.f5577q
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x010f
            d2.y r2 = r0.f5544f
            if (r3 == 0) goto L_0x00f0
            r10 = 1
            goto L_0x00f1
        L_0x00f0:
            r10 = 0
        L_0x00f1:
            int r5 = r0.f5547i
            long r3 = (long) r5
            r17 = 8
            long r3 = r3 * r17
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 * r17
            long r3 = r3 / r8
            int r4 = (int) r3
            d2.o r8 = new d2.o
            long r11 = r0.f5546h
            r3 = r8
            r18 = r15
            r15 = r8
            r8 = r11
            r3.<init>(r4, r5, r6, r8, r10)
            r2.g(r15)
            goto L_0x011b
        L_0x010f:
            r18 = r15
            d2.y r2 = r0.f5544f
            d2.e0 r3 = new d2.e0
            r3.<init>(r4)
            r2.g(r3)
        L_0x011b:
            r2 = 1
            r0.f5550l = r2
        L_0x011e:
            if (r14 == 0) goto L_0x0122
            r3 = -1
            return r3
        L_0x0122:
            r3 = 0
            r13.G(r3)
            r13.F(r1)
            boolean r1 = r0.f5549k
            if (r1 != 0) goto L_0x0138
            long r4 = r0.f5545g
            r6 = r18
            r1 = 4
            r6.e(r1, r4)
            r0.f5549k = r2
            goto L_0x013a
        L_0x0138:
            r6 = r18
        L_0x013a:
            r6.c(r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f5544f = yVar;
        this.f5540b.d(yVar, new j0(0, 1));
        yVar.a();
    }

    public final boolean h(w wVar) {
        boolean z10;
        int b10 = b(wVar);
        int i10 = b10;
        int i11 = 0;
        int i12 = 0;
        do {
            b0 b0Var = this.f5542d;
            p pVar = (p) wVar;
            pVar.k(b0Var.f8414a, 0, 2, false);
            b0Var.G(0);
            if ((b0Var.A() & 65526) == 65520) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                pVar.k(b0Var.f8414a, 0, 4, false);
                a0 a0Var = this.f5543e;
                a0Var.k(14);
                int g10 = a0Var.g(13);
                if (g10 > 6) {
                    pVar.h(g10 - 6, false);
                    i12 += g10;
                }
            }
            i10++;
            pVar.f4276f = 0;
            pVar.h(i10, false);
            i11 = 0;
            i12 = 0;
        } while (i10 - b10 < 8192);
        return false;
    }

    public f(int i10) {
        this.f5539a = 0;
        this.f5540b = new g((String) null, true);
        this.f5541c = new b0(2048);
        this.f5547i = -1;
        this.f5546h = -1;
        b0 b0Var = new b0(10);
        this.f5542d = b0Var;
        byte[] bArr = b0Var.f8414a;
        this.f5543e = new a0(bArr.length, bArr);
    }
}
