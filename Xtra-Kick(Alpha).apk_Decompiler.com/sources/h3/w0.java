package h3;

import android.view.Surface;

public final /* synthetic */ class w0 implements u0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7393h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x0 f7394i;

    public /* synthetic */ w0(x0 x0Var, int i10) {
        this.f7393h = i10;
        this.f7394i = x0Var;
    }

    public final void d(r rVar, int i10) {
        int i11 = this.f7393h;
        x0 x0Var = this.f7394i;
        switch (i11) {
            case 0:
                y0 y0Var = x0Var.f7431h;
                rVar.y0(y0Var.f7455c, i10, y0Var.f7471s);
                return;
            case 1:
                rVar.y0(x0Var.f7431h.f7455c, i10, (Surface) null);
                return;
            case 2:
                rVar.y0(x0Var.f7431h.f7455c, i10, (Surface) null);
                return;
            default:
                y0 y0Var2 = x0Var.f7431h;
                rVar.y0(y0Var2.f7455c, i10, y0Var2.f7471s);
                return;
        }
    }
}
