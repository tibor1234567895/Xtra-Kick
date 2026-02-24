package v1;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15720h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r0 f15721i;

    public /* synthetic */ m0(r0 r0Var, int i10) {
        this.f15720h = i10;
        this.f15721i = r0Var;
    }

    public final void run() {
        int i10 = this.f15720h;
        r0 r0Var = this.f15721i;
        switch (i10) {
            case 0:
                r0Var.t();
                return;
            case 1:
                if (!r0Var.S) {
                    x xVar = r0Var.f15775x;
                    xVar.getClass();
                    xVar.r(r0Var);
                    return;
                }
                return;
            default:
                r0Var.M = true;
                return;
        }
    }
}
