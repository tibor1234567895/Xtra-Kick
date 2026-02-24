package b4;

public final class z extends v {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f2612a;

    public z(a0 a0Var) {
        this.f2612a = a0Var;
    }

    public final void a(u uVar) {
        a0 a0Var = this.f2612a;
        int i10 = a0Var.H - 1;
        a0Var.H = i10;
        if (i10 == 0) {
            a0Var.I = false;
            a0Var.m();
        }
        uVar.v(this);
    }

    public final void b(u uVar) {
        a0 a0Var = this.f2612a;
        if (!a0Var.I) {
            a0Var.F();
            a0Var.I = true;
        }
    }
}
