package m1;

import g1.i1;
import j1.q;

public final /* synthetic */ class a0 implements q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10172h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k1 f10173i;

    public /* synthetic */ a0(k1 k1Var, int i10) {
        this.f10172h = i10;
        this.f10173i = k1Var;
    }

    public final void invoke(Object obj) {
        int i10 = this.f10172h;
        k1 k1Var = this.f10173i;
        switch (i10) {
            case 0:
                ((i1) obj).h(k1Var.f10328m);
                return;
            case 1:
                ((i1) obj).Y(n0.f1(k1Var));
                return;
            case 2:
                ((i1) obj).N(k1Var.f10329n);
                return;
            case 3:
                ((i1) obj).u(k1Var.f10321f);
                return;
            case 4:
                ((i1) obj).B(k1Var.f10321f);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((i1) obj).P(k1Var.f10324i.f17490d);
                return;
            case 6:
                i1 i1Var = (i1) obj;
                i1Var.j(k1Var.f10322g);
                i1Var.q(k1Var.f10322g);
                return;
            case 7:
                ((i1) obj).y(k1Var.f10320e, k1Var.f10327l);
                return;
            default:
                ((i1) obj).F(k1Var.f10320e);
                return;
        }
    }
}
