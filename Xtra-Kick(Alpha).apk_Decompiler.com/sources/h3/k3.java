package h3;

import d9.r0;
import g1.i1;
import g1.s0;
import j1.q;

public final /* synthetic */ class k3 implements r3, q, m2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s0 f7160h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7161i;

    public /* synthetic */ k3(int i10, s0 s0Var) {
        this.f7161i = i10;
        this.f7160h = s0Var;
    }

    public Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11 = this.f7161i;
        s0 s0Var = this.f7160h;
        switch (i11) {
            case 0:
                return n2Var.g(e2Var, r0.n(s0Var));
            default:
                return n2Var.g(e2Var, r0.n(s0Var));
        }
    }

    public void i(d2 d2Var, int i10) {
        d2Var.h(this.f7160h);
    }

    public void invoke(Object obj) {
        ((i1) obj).L(this.f7161i, this.f7160h);
    }
}
