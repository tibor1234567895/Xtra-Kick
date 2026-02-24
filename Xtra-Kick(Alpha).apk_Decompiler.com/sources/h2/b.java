package h2;

import d2.p;
import d2.v;
import d2.w;
import d2.y;
import j1.b0;

public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f6887a = new b0(4);

    /* renamed from: b  reason: collision with root package name */
    public final b0 f6888b = new b0(9);

    /* renamed from: c  reason: collision with root package name */
    public final b0 f6889c = new b0(11);

    /* renamed from: d  reason: collision with root package name */
    public final b0 f6890d = new b0();

    /* renamed from: e  reason: collision with root package name */
    public final c f6891e = new c();

    /* renamed from: f  reason: collision with root package name */
    public y f6892f;

    /* renamed from: g  reason: collision with root package name */
    public int f6893g = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6894h;

    /* renamed from: i  reason: collision with root package name */
    public long f6895i;

    /* renamed from: j  reason: collision with root package name */
    public int f6896j;

    /* renamed from: k  reason: collision with root package name */
    public int f6897k;

    /* renamed from: l  reason: collision with root package name */
    public int f6898l;

    /* renamed from: m  reason: collision with root package name */
    public long f6899m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f6900n;

    /* renamed from: o  reason: collision with root package name */
    public a f6901o;

    /* renamed from: p  reason: collision with root package name */
    public e f6902p;

    public final void a() {
    }

    public final b0 b(w wVar) {
        int i10 = this.f6898l;
        b0 b0Var = this.f6890d;
        byte[] bArr = b0Var.f8414a;
        if (i10 > bArr.length) {
            b0Var.E(0, new byte[Math.max(bArr.length * 2, i10)]);
        } else {
            b0Var.G(0);
        }
        b0Var.F(this.f6898l);
        wVar.readFully(b0Var.f8414a, 0, this.f6898l);
        return b0Var;
    }

    public final void c(long j10, long j11) {
        if (j10 == 0) {
            this.f6893g = 1;
            this.f6894h = false;
        } else {
            this.f6893g = 3;
        }
        this.f6896j = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00cc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r17, d2.s0 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            d2.y r2 = r0.f6892f
            j1.a.f(r2)
        L_0x0009:
            int r2 = r0.f6893g
            r3 = 4
            r4 = 0
            r5 = 1
            r6 = -1
            r7 = 8
            r8 = 9
            r9 = 2
            if (r2 == r5) goto L_0x011a
            r10 = 3
            if (r2 == r9) goto L_0x010f
            if (r2 == r10) goto L_0x00d3
            if (r2 != r3) goto L_0x00cd
            boolean r2 = r0.f6894h
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            h2.c r6 = r0.f6891e
            if (r2 == 0) goto L_0x002e
            long r14 = r0.f6895i
            long r10 = r0.f6899m
            long r14 = r14 + r10
            goto L_0x0039
        L_0x002e:
            long r10 = r6.f6903b
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0037
            r14 = 0
            goto L_0x0039
        L_0x0037:
            long r14 = r0.f6899m
        L_0x0039:
            int r2 = r0.f6897k
            if (r2 != r7) goto L_0x0054
            h2.a r7 = r0.f6901o
            if (r7 == 0) goto L_0x0054
            boolean r2 = r0.f6900n
            if (r2 != 0) goto L_0x0051
            d2.y r2 = r0.f6892f
            d2.e0 r7 = new d2.e0
            r7.<init>(r12)
            r2.g(r7)
            r0.f6900n = r5
        L_0x0051:
            h2.a r2 = r0.f6901o
            goto L_0x006c
        L_0x0054:
            if (r2 != r8) goto L_0x007e
            h2.e r7 = r0.f6902p
            if (r7 == 0) goto L_0x007e
            boolean r2 = r0.f6900n
            if (r2 != 0) goto L_0x006a
            d2.y r2 = r0.f6892f
            d2.e0 r7 = new d2.e0
            r7.<init>(r12)
            r2.g(r7)
            r0.f6900n = r5
        L_0x006a:
            h2.e r2 = r0.f6902p
        L_0x006c:
            j1.b0 r7 = r16.b(r17)
            boolean r8 = r2.c(r7)
            if (r8 == 0) goto L_0x00a6
            boolean r2 = r2.d(r14, r7)
            if (r2 == 0) goto L_0x00a6
            r2 = 1
            goto L_0x00a7
        L_0x007e:
            r7 = 18
            if (r2 != r7) goto L_0x00a9
            boolean r2 = r0.f6900n
            if (r2 != 0) goto L_0x00a9
            j1.b0 r2 = r16.b(r17)
            r6.getClass()
            r6.d(r14, r2)
            long r7 = r6.f6903b
            int r2 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x00a6
            d2.y r2 = r0.f6892f
            d2.j0 r10 = new d2.j0
            long[] r11 = r6.f6905d
            long[] r14 = r6.f6904c
            r10.<init>(r7, r11, r14)
            r2.g(r10)
            r0.f6900n = r5
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            r7 = 1
            goto L_0x00b0
        L_0x00a9:
            int r2 = r0.f6898l
            r1.g(r2)
            r2 = 0
            r7 = 0
        L_0x00b0:
            boolean r8 = r0.f6894h
            if (r8 != 0) goto L_0x00c6
            if (r2 == 0) goto L_0x00c6
            r0.f6894h = r5
            long r5 = r6.f6903b
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00c2
            long r5 = r0.f6899m
            long r10 = -r5
            goto L_0x00c4
        L_0x00c2:
            r10 = 0
        L_0x00c4:
            r0.f6895i = r10
        L_0x00c6:
            r0.f6896j = r3
            r0.f6893g = r9
            if (r7 == 0) goto L_0x0009
            return r4
        L_0x00cd:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00d3:
            j1.b0 r2 = r0.f6889c
            byte[] r7 = r2.f8414a
            r8 = 11
            boolean r7 = r1.b(r7, r4, r8, r5)
            if (r7 != 0) goto L_0x00e0
            goto L_0x010c
        L_0x00e0:
            r2.G(r4)
            int r4 = r2.v()
            r0.f6897k = r4
            int r4 = r2.x()
            r0.f6898l = r4
            int r4 = r2.x()
            long r7 = (long) r4
            r0.f6899m = r7
            int r4 = r2.v()
            int r4 = r4 << 24
            long r7 = (long) r4
            long r11 = r0.f6899m
            long r7 = r7 | r11
            r11 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r11
            r0.f6899m = r7
            r2.H(r10)
            r0.f6893g = r3
            r4 = 1
        L_0x010c:
            if (r4 != 0) goto L_0x0009
            return r6
        L_0x010f:
            int r2 = r0.f6896j
            r1.g(r2)
            r0.f6896j = r4
            r0.f6893g = r10
            goto L_0x0009
        L_0x011a:
            j1.b0 r2 = r0.f6888b
            byte[] r10 = r2.f8414a
            boolean r10 = r1.b(r10, r4, r8, r5)
            if (r10 != 0) goto L_0x0125
            goto L_0x0171
        L_0x0125:
            r2.G(r4)
            r2.H(r3)
            int r10 = r2.v()
            r11 = r10 & 4
            if (r11 == 0) goto L_0x0135
            r11 = 1
            goto L_0x0136
        L_0x0135:
            r11 = 0
        L_0x0136:
            r10 = r10 & 1
            if (r10 == 0) goto L_0x013b
            r4 = 1
        L_0x013b:
            if (r11 == 0) goto L_0x014e
            h2.a r10 = r0.f6901o
            if (r10 != 0) goto L_0x014e
            h2.a r10 = new h2.a
            d2.y r11 = r0.f6892f
            d2.x0 r7 = r11.d(r7, r5)
            r10.<init>(r7)
            r0.f6901o = r10
        L_0x014e:
            if (r4 == 0) goto L_0x0161
            h2.e r4 = r0.f6902p
            if (r4 != 0) goto L_0x0161
            h2.e r4 = new h2.e
            d2.y r7 = r0.f6892f
            d2.x0 r7 = r7.d(r8, r9)
            r4.<init>(r7)
            r0.f6902p = r4
        L_0x0161:
            d2.y r4 = r0.f6892f
            r4.a()
            int r2 = r2.f()
            int r2 = r2 - r8
            int r2 = r2 + r3
            r0.f6896j = r2
            r0.f6893g = r9
            r4 = 1
        L_0x0171:
            if (r4 != 0) goto L_0x0009
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.b.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f6892f = yVar;
    }

    public final boolean h(w wVar) {
        b0 b0Var = this.f6887a;
        p pVar = (p) wVar;
        pVar.k(b0Var.f8414a, 0, 3, false);
        b0Var.G(0);
        if (b0Var.x() != 4607062) {
            return false;
        }
        pVar.k(b0Var.f8414a, 0, 2, false);
        b0Var.G(0);
        if ((b0Var.A() & 250) != 0) {
            return false;
        }
        pVar.k(b0Var.f8414a, 0, 4, false);
        b0Var.G(0);
        int f10 = b0Var.f();
        pVar.f4276f = 0;
        pVar.h(f10, false);
        pVar.k(b0Var.f8414a, 0, 4, false);
        b0Var.G(0);
        if (b0Var.f() == 0) {
            return true;
        }
        return false;
    }
}
