package v1;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15604h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f0 f15605i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g0 f15606j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ r f15607k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w f15608l;

    public /* synthetic */ d0(f0 f0Var, g0 g0Var, r rVar, w wVar, int i10) {
        this.f15604h = i10;
        this.f15605i = f0Var;
        this.f15606j = g0Var;
        this.f15607k = rVar;
        this.f15608l = wVar;
    }

    public final void run() {
        int i10 = this.f15604h;
        w wVar = this.f15608l;
        r rVar = this.f15607k;
        g0 g0Var = this.f15606j;
        f0 f0Var = this.f15605i;
        switch (i10) {
            case 0:
                g0Var.I(f0Var.f15618a, f0Var.f15619b, rVar, wVar);
                return;
            case 1:
                g0Var.w(f0Var.f15618a, f0Var.f15619b, rVar, wVar);
                return;
            default:
                g0Var.M(f0Var.f15618a, f0Var.f15619b, rVar, wVar);
                return;
        }
    }
}
