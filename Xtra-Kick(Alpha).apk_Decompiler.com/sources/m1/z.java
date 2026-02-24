package m1;

import g1.i1;
import j1.q;

public final /* synthetic */ class z implements q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10544h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k1 f10545i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10546j;

    public /* synthetic */ z(int i10, int i11, k1 k1Var) {
        this.f10544h = i11;
        this.f10545i = k1Var;
        this.f10546j = i10;
    }

    public final void invoke(Object obj) {
        int i10 = this.f10544h;
        int i11 = this.f10546j;
        k1 k1Var = this.f10545i;
        switch (i10) {
            case 0:
                ((i1) obj).Q(k1Var.f10316a, i11);
                return;
            default:
                ((i1) obj).z(i11, k1Var.f10327l);
                return;
        }
    }
}
