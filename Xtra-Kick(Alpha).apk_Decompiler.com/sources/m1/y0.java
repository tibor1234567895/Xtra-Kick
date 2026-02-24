package m1;

import g1.u1;
import j1.a;
import j1.v;
import java.util.IdentityHashMap;
import v1.b1;
import v1.d;
import v1.l1;
import v1.o;
import v1.y;
import z1.s;
import z1.x;

public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final y f10529a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10530b;

    /* renamed from: c  reason: collision with root package name */
    public final b1[] f10531c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10532d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10533e;

    /* renamed from: f  reason: collision with root package name */
    public z0 f10534f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10535g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f10536h;

    /* renamed from: i  reason: collision with root package name */
    public final f[] f10537i;

    /* renamed from: j  reason: collision with root package name */
    public final x f10538j;

    /* renamed from: k  reason: collision with root package name */
    public final j1 f10539k;

    /* renamed from: l  reason: collision with root package name */
    public y0 f10540l;

    /* renamed from: m  reason: collision with root package name */
    public l1 f10541m = l1.f15714k;

    /* renamed from: n  reason: collision with root package name */
    public z1.y f10542n;

    /* renamed from: o  reason: collision with root package name */
    public long f10543o;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: v1.s} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: v1.s} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: v1.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: v1.s} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public y0(m1.f[] r8, long r9, z1.x r11, a2.e r12, m1.j1 r13, m1.z0 r14, z1.y r15) {
        /*
            r7 = this;
            r7.<init>()
            r7.f10537i = r8
            r7.f10543o = r9
            r7.f10538j = r11
            r7.f10539k = r13
            v1.a0 r9 = r14.f10547a
            java.lang.Object r10 = r9.f6678a
            r7.f10530b = r10
            r7.f10534f = r14
            v1.l1 r10 = v1.l1.f15714k
            r7.f10541m = r10
            r7.f10542n = r15
            int r10 = r8.length
            v1.b1[] r10 = new v1.b1[r10]
            r7.f10531c = r10
            int r8 = r8.length
            boolean[] r8 = new boolean[r8]
            r7.f10536h = r8
            long r5 = r14.f10550d
            r13.getClass()
            int r8 = m1.n1.f10403v
            java.lang.Object r8 = r9.f6678a
            android.util.Pair r8 = (android.util.Pair) r8
            java.lang.Object r10 = r8.first
            java.lang.Object r8 = r8.second
            v1.a0 r8 = r9.b(r8)
            java.util.HashMap r9 = r13.f10298d
            java.lang.Object r9 = r9.get(r10)
            m1.i1 r9 = (m1.i1) r9
            r9.getClass()
            java.util.HashSet r10 = r13.f10301g
            r10.add(r9)
            java.util.HashMap r10 = r13.f10300f
            java.lang.Object r10 = r10.get(r9)
            m1.h1 r10 = (m1.h1) r10
            if (r10 == 0) goto L_0x0057
            v1.a r11 = r10.f10259a
            v1.b0 r10 = r10.f10260b
            r11.e(r10)
        L_0x0057:
            java.util.ArrayList r10 = r9.f10272c
            r10.add(r8)
            v1.v r10 = r9.f10270a
            long r14 = r14.f10548b
            v1.s r1 = r10.b(r8, r12, r14)
            java.util.IdentityHashMap r8 = r13.f10297c
            r8.put(r1, r9)
            r13.c()
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x007f
            v1.d r8 = new v1.d
            r2 = 1
            r3 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r5)
            r1 = r8
        L_0x007f:
            r7.f10529a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.y0.<init>(m1.f[], long, z1.x, a2.e, m1.j1, m1.z0, z1.y):void");
    }

    public final long a(z1.y yVar, long j10, boolean z10, boolean[] zArr) {
        f[] fVarArr;
        b1[] b1VarArr;
        boolean z11;
        z1.y yVar2 = yVar;
        int i10 = 0;
        while (true) {
            boolean z12 = true;
            if (i10 >= yVar2.f17487a) {
                break;
            }
            if (z10 || !yVar2.a(this.f10542n, i10)) {
                z12 = false;
            }
            this.f10536h[i10] = z12;
            i10++;
        }
        int i11 = 0;
        while (true) {
            fVarArr = this.f10537i;
            int length = fVarArr.length;
            b1VarArr = this.f10531c;
            if (i11 >= length) {
                break;
            }
            if (fVarArr[i11].f10216h == -2) {
                b1VarArr[i11] = null;
            }
            i11++;
        }
        b();
        this.f10542n = yVar2;
        c();
        long p10 = this.f10529a.p(yVar2.f17489c, this.f10536h, this.f10531c, zArr, j10);
        for (int i12 = 0; i12 < fVarArr.length; i12++) {
            if (fVarArr[i12].f10216h == -2 && this.f10542n.b(i12)) {
                b1VarArr[i12] = new o();
            }
        }
        this.f10533e = false;
        for (int i13 = 0; i13 < b1VarArr.length; i13++) {
            if (b1VarArr[i13] != null) {
                a.e(yVar2.b(i13));
                if (fVarArr[i13].f10216h != -2) {
                    this.f10533e = true;
                }
            } else {
                if (yVar2.f17489c[i13] == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                a.e(z11);
            }
        }
        return p10;
    }

    public final void b() {
        boolean z10;
        int i10 = 0;
        if (this.f10540l == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            while (true) {
                z1.y yVar = this.f10542n;
                if (i10 < yVar.f17487a) {
                    boolean b10 = yVar.b(i10);
                    s sVar = this.f10542n.f17489c[i10];
                    if (b10 && sVar != null) {
                        sVar.j();
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final void c() {
        boolean z10;
        int i10 = 0;
        if (this.f10540l == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            while (true) {
                z1.y yVar = this.f10542n;
                if (i10 < yVar.f17487a) {
                    boolean b10 = yVar.b(i10);
                    s sVar = this.f10542n.f17489c[i10];
                    if (b10 && sVar != null) {
                        sVar.f();
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final long d() {
        if (!this.f10532d) {
            return this.f10534f.f10548b;
        }
        long u10 = this.f10533e ? this.f10529a.u() : Long.MIN_VALUE;
        return u10 == Long.MIN_VALUE ? this.f10534f.f10551e : u10;
    }

    public final long e() {
        return this.f10534f.f10548b + this.f10543o;
    }

    public final void f() {
        b();
        j1 j1Var = this.f10539k;
        y yVar = this.f10529a;
        try {
            if (yVar instanceof d) {
                yVar = ((d) yVar).f15597h;
            }
            IdentityHashMap identityHashMap = j1Var.f10297c;
            i1 i1Var = (i1) identityHashMap.remove(yVar);
            i1Var.getClass();
            i1Var.f10270a.n(yVar);
            i1Var.f10272c.remove(((v1.s) yVar).f15778h);
            if (!identityHashMap.isEmpty()) {
                j1Var.c();
            }
            j1Var.d(i1Var);
        } catch (RuntimeException e10) {
            v.d("MediaPeriodHolder", "Period release failed.", e10);
        }
    }

    public final z1.y g(float f10, u1 u1Var) {
        z1.y d10 = this.f10538j.d(this.f10537i, this.f10541m, this.f10534f.f10547a, u1Var);
        for (s sVar : d10.f17489c) {
            if (sVar != null) {
                sVar.p(f10);
            }
        }
        return d10;
    }

    public final void h() {
        y yVar = this.f10529a;
        if (yVar instanceof d) {
            long j10 = this.f10534f.f10550d;
            if (j10 == -9223372036854775807L) {
                j10 = Long.MIN_VALUE;
            }
            d dVar = (d) yVar;
            dVar.f15601l = 0;
            dVar.f15602m = j10;
        }
    }
}
