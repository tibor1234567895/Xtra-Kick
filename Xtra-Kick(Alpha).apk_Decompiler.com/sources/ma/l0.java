package ma;

public final class l0 extends b {

    /* renamed from: j  reason: collision with root package name */
    public int f10820j;

    /* renamed from: k  reason: collision with root package name */
    public int f10821k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ m0 f10822l;

    public l0(m0 m0Var) {
        this.f10822l = m0Var;
        this.f10820j = m0Var.a();
        this.f10821k = m0Var.f10825k;
    }

    public final void a() {
        int i10 = this.f10820j;
        if (i10 == 0) {
            this.f10799h = 3;
            return;
        }
        m0 m0Var = this.f10822l;
        Object[] objArr = m0Var.f10823i;
        int i11 = this.f10821k;
        this.f10800i = objArr[i11];
        this.f10799h = 1;
        this.f10821k = (i11 + 1) % m0Var.f10824j;
        this.f10820j = i10 - 1;
    }
}
