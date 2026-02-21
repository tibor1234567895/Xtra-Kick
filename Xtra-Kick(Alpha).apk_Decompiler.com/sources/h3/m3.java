package h3;

public final /* synthetic */ class m3 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s3 f7197h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e2 f7198i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7199j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7200k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ n2 f7201l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ r3 f7202m;

    public /* synthetic */ m3(s3 s3Var, e2 e2Var, int i10, int i11, n2 n2Var, r3 r3Var) {
        this.f7197h = s3Var;
        this.f7198i = e2Var;
        this.f7199j = i10;
        this.f7200k = i11;
        this.f7201l = n2Var;
        this.f7202m = r3Var;
    }

    public final void run() {
        s3 s3Var = this.f7197h;
        e2 e2Var = this.f7198i;
        int i10 = this.f7199j;
        int i11 = this.f7200k;
        n2 n2Var = this.f7201l;
        r3 r3Var = this.f7202m;
        if (!s3Var.f7319f.h(i10, e2Var)) {
            s3.I0(e2Var, i11, new j4(-4));
            return;
        }
        n2Var.f7231d.e();
        if (i10 == 27) {
            r3Var.h(n2Var, e2Var, i11);
            return;
        }
        g gVar = s3Var.f7319f;
        g3 g3Var = new g3(r3Var, n2Var, e2Var, i11);
        synchronized (gVar.f7037a) {
            f fVar = (f) gVar.f7039c.getOrDefault(e2Var, (Object) null);
            if (fVar != null) {
                fVar.f7014c.add(g3Var);
            }
        }
    }
}
