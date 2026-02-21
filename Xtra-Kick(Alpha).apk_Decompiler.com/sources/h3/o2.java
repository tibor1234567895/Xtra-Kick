package h3;

public final /* synthetic */ class o2 implements w2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7267h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x2 f7268i;

    public /* synthetic */ o2(x2 x2Var, int i10) {
        this.f7267h = i10;
        this.f7268i = x2Var;
    }

    public final void e(e2 e2Var) {
        int i10 = this.f7267h;
        x2 x2Var = this.f7268i;
        switch (i10) {
            case 0:
                a4 a4Var = x2Var.f7437g.f7246s;
                int b10 = a4Var.b();
                if (!a4Var.y() || b10 == 4 || b10 == 1) {
                    if (b10 == 1) {
                        if (a4Var.L0(2)) {
                            a4Var.e();
                        }
                    } else if (b10 == 4 && a4Var.L0(4)) {
                        a4Var.R();
                    }
                    a4Var.P();
                    return;
                }
                a4Var.g();
                return;
            case 1:
                x2Var.f7437g.f7246s.e();
                return;
            case 2:
                x2Var.f7437g.f7246s.u0();
                return;
            case 3:
                x2Var.f7437g.f7246s.B();
                return;
            case 4:
                x2Var.f7437g.f7246s.g();
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                x2Var.f7437g.f7246s.v0();
                return;
            case 6:
                n2 n2Var = x2Var.f7437g;
                a4 a4Var2 = n2Var.f7246s;
                int b11 = a4Var2.b();
                if (b11 == 1) {
                    if (a4Var2.L0(2)) {
                        a4Var2.e();
                    }
                } else if (b11 == 4 && a4Var2.L0(4)) {
                    a4Var2.R();
                }
                if (n2Var.h()) {
                    a4Var2.P();
                    return;
                }
                return;
            case 7:
                x2Var.f7437g.f7246s.A0();
                return;
            case 8:
                x2Var.f7437g.f7246s.D0();
                return;
            case 9:
                x2Var.f7437g.f7246s.O();
                return;
            default:
                x2Var.f7437g.f7246s.stop();
                return;
        }
    }
}
