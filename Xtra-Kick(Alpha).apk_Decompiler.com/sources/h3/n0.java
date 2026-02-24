package h3;

import g1.i1;
import j1.q;

public final /* synthetic */ class n0 implements q, u0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7222h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f7223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7224j;

    public /* synthetic */ n0(y0 y0Var, int i10, int i11) {
        this.f7222h = i11;
        this.f7223i = y0Var;
        this.f7224j = i10;
    }

    public final void d(r rVar, int i10) {
        int i11 = this.f7222h;
        int i12 = this.f7224j;
        y0 y0Var = this.f7223i;
        switch (i11) {
            case 1:
                rVar.Z(y0Var.f7455c, i10, i12);
                return;
            case 3:
                rVar.u0(y0Var.f7455c, i10, i12);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                rVar.R(y0Var.f7455c, i10, i12);
                return;
            default:
                rVar.c(y0Var.f7455c, i10, i12);
                return;
        }
    }

    public final void invoke(Object obj) {
        int i10 = this.f7222h;
        int i11 = this.f7224j;
        y0 y0Var = this.f7223i;
        switch (i10) {
            case 0:
                ((i1) obj).g(i11, y0Var.f7466n.f7429y);
                return;
            case 2:
                ((i1) obj).g(i11, y0Var.f7466n.f7429y);
                return;
            default:
                ((i1) obj).g(i11, y0Var.f7466n.f7429y);
                return;
        }
    }
}
