package m1;

import g1.e1;
import j1.d0;

public final class n implements x0 {

    /* renamed from: h  reason: collision with root package name */
    public final q1 f10360h;

    /* renamed from: i  reason: collision with root package name */
    public final m f10361i;

    /* renamed from: j  reason: collision with root package name */
    public f f10362j;

    /* renamed from: k  reason: collision with root package name */
    public x0 f10363k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f10364l = true;

    /* renamed from: m  reason: collision with root package name */
    public boolean f10365m;

    public n(m mVar, d0 d0Var) {
        this.f10361i = mVar;
        this.f10360h = new q1(d0Var);
    }

    public final long a() {
        if (this.f10364l) {
            return this.f10360h.a();
        }
        x0 x0Var = this.f10363k;
        x0Var.getClass();
        return x0Var.a();
    }

    public final void d(e1 e1Var) {
        x0 x0Var = this.f10363k;
        if (x0Var != null) {
            x0Var.d(e1Var);
            e1Var = this.f10363k.i();
        }
        this.f10360h.d(e1Var);
    }

    public final e1 i() {
        x0 x0Var = this.f10363k;
        if (x0Var != null) {
            return x0Var.i();
        }
        return this.f10360h.f10448l;
    }
}
