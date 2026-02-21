package m1;

import g1.h1;
import g1.i1;
import g1.y;
import j1.q;
import j1.r;

public final /* synthetic */ class x implements r, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10524h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n0 f10525i;

    public /* synthetic */ x(n0 n0Var, int i10) {
        this.f10524h = i10;
        this.f10525i = n0Var;
    }

    public final void c(Object obj, y yVar) {
        n0 n0Var = this.f10525i;
        n0Var.getClass();
        ((i1) obj).l(n0Var.f10376f, new h1(yVar));
    }

    public final void invoke(Object obj) {
        int i10 = this.f10524h;
        n0 n0Var = this.f10525i;
        switch (i10) {
            case 2:
                ((i1) obj).O(n0Var.M);
                return;
            default:
                ((i1) obj).e(n0Var.O);
                return;
        }
    }
}
