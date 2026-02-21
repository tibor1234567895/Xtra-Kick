package h3;

import g1.i1;
import j1.q;

public final /* synthetic */ class m0 implements u0, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7193h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f7194i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7195j;

    public /* synthetic */ m0(y0 y0Var, boolean z10, int i10) {
        this.f7193h = i10;
        this.f7194i = y0Var;
        this.f7195j = z10;
    }

    public final void d(r rVar, int i10) {
        int i11 = this.f7193h;
        boolean z10 = this.f7195j;
        y0 y0Var = this.f7194i;
        switch (i11) {
            case 0:
                rVar.z(y0Var.f7455c, i10, z10);
                return;
            case 1:
                rVar.c0(y0Var.f7455c, i10, z10);
                return;
            default:
                rVar.v(y0Var.f7455c, i10, z10);
                return;
        }
    }

    public final void invoke(Object obj) {
        ((i1) obj).g(this.f7194i.f7466n.f7428x, this.f7195j);
    }
}
