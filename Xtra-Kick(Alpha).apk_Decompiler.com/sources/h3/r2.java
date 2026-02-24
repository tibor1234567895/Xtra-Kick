package h3;

public final /* synthetic */ class r2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s2 f7301h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f2 f7302i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7303j;

    public /* synthetic */ r2(s2 s2Var, f2 f2Var, boolean z10) {
        this.f7301h = s2Var;
        this.f7302i = f2Var;
        this.f7303j = z10;
    }

    public final void run() {
        a4 a4Var = ((x2) this.f7301h.f7315i).f7437g.f7246s;
        t3.A(a4Var, this.f7302i);
        int b10 = a4Var.b();
        if (b10 == 1) {
            if (a4Var.L0(2)) {
                a4Var.e();
            }
        } else if (b10 == 4 && a4Var.L0(4)) {
            a4Var.R();
        }
        if (this.f7303j && a4Var.L0(1)) {
            a4Var.P();
        }
    }
}
