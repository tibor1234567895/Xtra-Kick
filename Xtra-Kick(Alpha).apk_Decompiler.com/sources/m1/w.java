package m1;

import g1.i1;
import h3.a4;
import h3.d2;
import h3.m2;
import h3.s3;
import j1.h;
import j1.q;

public final /* synthetic */ class w implements q, m2, h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10520h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f10521i;

    public /* synthetic */ w(int i10, boolean z10) {
        this.f10520h = i10;
        this.f10521i = z10;
    }

    public final void b(Object obj) {
        int i10 = this.f10520h;
        boolean z10 = this.f10521i;
        switch (i10) {
            case 6:
                int i11 = s3.f7316j;
                ((a4) obj).A(z10);
                return;
            case 7:
                int i12 = s3.f7316j;
                ((a4) obj).m(z10);
                return;
            default:
                int i13 = s3.f7316j;
                ((a4) obj).X(z10);
                return;
        }
    }

    public final void i(d2 d2Var, int i10) {
        d2Var.f(this.f10521i);
    }

    public final void invoke(Object obj) {
        int i10 = this.f10520h;
        boolean z10 = this.f10521i;
        switch (i10) {
            case 0:
                ((i1) obj).f(z10);
                return;
            case 1:
                ((i1) obj).v(z10);
                return;
            default:
                ((i1) obj).f(z10);
                return;
        }
    }
}
