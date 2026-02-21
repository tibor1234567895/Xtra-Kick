package m1;

import g1.i1;
import h3.a4;
import h3.d2;
import h3.m2;
import h3.s3;
import j1.h;
import j1.q;

public final /* synthetic */ class e0 implements q, h, m2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10209h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10210i;

    public /* synthetic */ e0(int i10, int i11) {
        this.f10209h = i11;
        this.f10210i = i10;
    }

    public final void b(Object obj) {
        int i10 = this.f10209h;
        int i11 = this.f10210i;
        switch (i10) {
            case 1:
                ((p1.q) obj).d(i11);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                int i12 = s3.f7316j;
                ((a4) obj).t0(i11);
                return;
            default:
                int i13 = s3.f7316j;
                ((a4) obj).f(i11);
                return;
        }
    }

    public final void i(d2 d2Var, int i10) {
        d2Var.a(this.f10210i);
    }

    public final void invoke(Object obj) {
        int i10 = this.f10209h;
        int i11 = this.f10210i;
        switch (i10) {
            case 0:
                ((i1) obj).a(i11);
                return;
            default:
                ((i1) obj).a(i11);
                return;
        }
    }
}
