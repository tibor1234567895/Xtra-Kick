package j3;

import wa.l;
import xa.j;
import xa.k;

public final class d0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8517h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k0 f8518i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(k0 k0Var, int i10) {
        super(1);
        this.f8517h = i10;
        this.f8518i = k0Var;
    }

    public final Boolean a(c1 c1Var) {
        int i10 = this.f8517h;
        k0 k0Var = this.f8518i;
        switch (i10) {
            case 0:
                j.f("destination", c1Var);
                return Boolean.valueOf(!k0Var.f8587l.containsKey(Integer.valueOf(c1Var.f8513o)));
            default:
                j.f("destination", c1Var);
                return Boolean.valueOf(!k0Var.f8587l.containsKey(Integer.valueOf(c1Var.f8513o)));
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f8517h) {
            case 0:
                return a((c1) obj);
            default:
                return a((c1) obj);
        }
    }
}
