package z1;

import d9.e0;
import d9.o1;
import d9.p1;
import d9.r0;
import d9.y1;
import g1.v1;

public final class m extends o implements Comparable {

    /* renamed from: l  reason: collision with root package name */
    public final int f17440l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f17441m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f17442n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f17443o;

    /* renamed from: p  reason: collision with root package name */
    public final int f17444p;

    /* renamed from: q  reason: collision with root package name */
    public final int f17445q;

    /* renamed from: r  reason: collision with root package name */
    public final int f17446r;

    /* renamed from: s  reason: collision with root package name */
    public final int f17447s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f17448t;

    public m(int i10, v1 v1Var, int i11, j jVar, int i12, String str) {
        super(i10, i11, v1Var);
        boolean z10;
        boolean z11;
        r0 r0Var;
        int i13;
        int i14;
        boolean z12;
        boolean z13;
        boolean z14;
        int i15 = 0;
        this.f17441m = q.j(i12, false);
        int i16 = this.f17452k.f6268k & (~jVar.B);
        if ((i16 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f17442n = z10;
        if ((i16 & 2) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f17443o = z11;
        r0 r0Var2 = jVar.f6743z;
        if (r0Var2.isEmpty()) {
            r0Var = r0.n("");
        } else {
            r0Var = r0Var2;
        }
        int i17 = 0;
        while (true) {
            i13 = Integer.MAX_VALUE;
            if (i17 >= r0Var.size()) {
                i17 = Integer.MAX_VALUE;
                i14 = 0;
                break;
            }
            i14 = q.i(this.f17452k, (String) r0Var.get(i17), jVar.C);
            if (i14 > 0) {
                break;
            }
            i17++;
        }
        this.f17444p = i17;
        this.f17445q = i14;
        int i18 = this.f17452k.f6269l;
        int i19 = jVar.A;
        i13 = (i18 == 0 || i18 != i19) ? Integer.bitCount(i18 & i19) : i13;
        this.f17446r = i13;
        if ((this.f17452k.f6269l & 1088) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f17448t = z12;
        if (q.l(str) == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        int i20 = q.i(this.f17452k, str, z13);
        this.f17447s = i20;
        if (i14 > 0 || ((r0Var2.isEmpty() && i13 > 0) || this.f17442n || (this.f17443o && i20 > 0))) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (q.j(i12, jVar.f17428s0) && z14) {
            i15 = 1;
        }
        this.f17440l = i15;
    }

    public final int a() {
        return this.f17440l;
    }

    public final /* bridge */ /* synthetic */ boolean b(o oVar) {
        m mVar = (m) oVar;
        return false;
    }

    /* renamed from: c */
    public final int compareTo(m mVar) {
        e0 c10 = e0.f4608a.c(this.f17441m, mVar.f17441m);
        Integer valueOf = Integer.valueOf(this.f17444p);
        Integer valueOf2 = Integer.valueOf(mVar.f17444p);
        p1 p1Var = o1.f4642h;
        p1Var.getClass();
        p1 p1Var2 = y1.f4713h;
        e0 b10 = c10.b(valueOf, valueOf2, p1Var2);
        int i10 = this.f17445q;
        e0 a10 = b10.a(i10, mVar.f17445q);
        int i11 = this.f17446r;
        e0 c11 = a10.a(i11, mVar.f17446r).c(this.f17442n, mVar.f17442n);
        Boolean valueOf3 = Boolean.valueOf(this.f17443o);
        Boolean valueOf4 = Boolean.valueOf(mVar.f17443o);
        if (i10 != 0) {
            p1Var = p1Var2;
        }
        e0 a11 = c11.b(valueOf3, valueOf4, p1Var).a(this.f17447s, mVar.f17447s);
        if (i11 == 0) {
            a11 = a11.d(this.f17448t, mVar.f17448t);
        }
        return a11.e();
    }
}
