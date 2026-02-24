package h3;

public final /* synthetic */ class p0 implements u0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7272h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f7273i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f7274j;

    public /* synthetic */ p0(y0 y0Var, float f10, int i10) {
        this.f7272h = i10;
        this.f7273i = y0Var;
        this.f7274j = f10;
    }

    public final void d(r rVar, int i10) {
        int i11 = this.f7272h;
        float f10 = this.f7274j;
        y0 y0Var = this.f7273i;
        switch (i11) {
            case 0:
                rVar.p0(y0Var.f7455c, i10, f10);
                return;
            default:
                rVar.p(y0Var.f7455c, i10, f10);
                return;
        }
    }
}
