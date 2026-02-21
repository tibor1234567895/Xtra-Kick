package m0;

import e0.d;

public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f10085a;

    /* renamed from: b  reason: collision with root package name */
    public d[] f10086b;

    public g2() {
        this(new q2());
    }

    public final void a() {
        d[] dVarArr = this.f10086b;
        if (dVarArr != null) {
            d dVar = dVarArr[n2.a(1)];
            d dVar2 = this.f10086b[n2.a(2)];
            q2 q2Var = this.f10085a;
            if (dVar2 == null) {
                dVar2 = q2Var.a(2);
            }
            if (dVar == null) {
                dVar = q2Var.a(1);
            }
            g(d.a(dVar, dVar2));
            d dVar3 = this.f10086b[n2.a(16)];
            if (dVar3 != null) {
                f(dVar3);
            }
            d dVar4 = this.f10086b[n2.a(32)];
            if (dVar4 != null) {
                d(dVar4);
            }
            d dVar5 = this.f10086b[n2.a(64)];
            if (dVar5 != null) {
                h(dVar5);
            }
        }
    }

    public q2 b() {
        a();
        return this.f10085a;
    }

    public void c(int i10, d dVar) {
        if (this.f10086b == null) {
            this.f10086b = new d[9];
        }
        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                this.f10086b[n2.a(i11)] = dVar;
            }
        }
    }

    public void d(d dVar) {
    }

    public void e(d dVar) {
    }

    public void f(d dVar) {
    }

    public void g(d dVar) {
    }

    public void h(d dVar) {
    }

    public g2(q2 q2Var) {
        this.f10085a = q2Var;
    }
}
