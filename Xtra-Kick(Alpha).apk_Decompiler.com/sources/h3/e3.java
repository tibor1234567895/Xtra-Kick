package h3;

public final /* synthetic */ class e3 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s3 f6999h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e2 f7000i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f4 f7001j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7002k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7003l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ r3 f7004m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ n2 f7005n;

    public /* synthetic */ e3(s3 s3Var, e2 e2Var, f4 f4Var, int i10, int i11, l3 l3Var, n2 n2Var) {
        this.f6999h = s3Var;
        this.f7000i = e2Var;
        this.f7001j = f4Var;
        this.f7002k = i10;
        this.f7003l = i11;
        this.f7004m = l3Var;
        this.f7005n = n2Var;
    }

    public final void run() {
        j4 j4Var;
        g gVar = this.f6999h.f7319f;
        e2 e2Var = this.f7000i;
        if (gVar.g(e2Var)) {
            f4 f4Var = this.f7001j;
            int i10 = this.f7002k;
            if (f4Var != null) {
                if (!gVar.j(e2Var, f4Var)) {
                    j4Var = new j4(-4);
                }
                this.f7004m.h(this.f7005n, e2Var, i10);
                return;
            }
            if (!gVar.i(this.f7003l, e2Var)) {
                j4Var = new j4(-4);
            }
            this.f7004m.h(this.f7005n, e2Var, i10);
            return;
            s3.I0(e2Var, i10, j4Var);
        }
    }
}
