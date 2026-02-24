package h3;

import g1.i1;
import j1.q;

public final /* synthetic */ class h0 implements q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7064h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ w3 f7065i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7066j;

    public /* synthetic */ h0(w3 w3Var, int i10, int i11) {
        this.f7064h = i11;
        this.f7065i = w3Var;
        this.f7066j = i10;
    }

    public final void invoke(Object obj) {
        int i10 = this.f7064h;
        int i11 = this.f7066j;
        w3 w3Var = this.f7065i;
        switch (i10) {
            case 0:
                ((i1) obj).L(i11, w3Var.o());
                return;
            case 1:
                ((i1) obj).n(i11, w3Var.f7415k, w3Var.f7416l);
                return;
            case 2:
                ((i1) obj).Q(w3Var.f7421q, i11);
                return;
            default:
                ((i1) obj).z(i11, w3Var.f7430z);
                return;
        }
    }
}
