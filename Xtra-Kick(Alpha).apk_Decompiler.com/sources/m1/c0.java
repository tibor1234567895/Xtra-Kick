package m1;

import g1.i1;
import g1.v0;
import h3.a4;
import h3.d2;
import h3.m2;
import h3.s3;
import j1.h;
import j1.q;

public final /* synthetic */ class c0 implements q, m2, h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10192h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ v0 f10193i;

    public /* synthetic */ c0(int i10, v0 v0Var) {
        this.f10192h = i10;
        this.f10193i = v0Var;
    }

    public final void b(Object obj) {
        int i10 = s3.f7316j;
        ((a4) obj).l0(this.f10193i);
    }

    public final void i(d2 d2Var, int i10) {
        d2Var.e(this.f10193i);
    }

    public final void invoke(Object obj) {
        int i10 = this.f10192h;
        v0 v0Var = this.f10193i;
        switch (i10) {
            case 0:
                ((i1) obj).t(v0Var);
                return;
            default:
                ((i1) obj).e(v0Var);
                return;
        }
    }
}
