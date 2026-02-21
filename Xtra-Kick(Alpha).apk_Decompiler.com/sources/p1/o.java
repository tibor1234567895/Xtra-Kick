package p1;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12500h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ q f12501i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ r f12502j;

    public /* synthetic */ o(q qVar, r rVar, int i10) {
        this.f12500h = i10;
        this.f12501i = qVar;
        this.f12502j = rVar;
    }

    public final void run() {
        int i10 = this.f12500h;
        r rVar = this.f12502j;
        q qVar = this.f12501i;
        switch (i10) {
            case 0:
                rVar.p(qVar.f12505a, qVar.f12506b);
                return;
            case 1:
                rVar.C(qVar.f12505a, qVar.f12506b);
                return;
            case 2:
                rVar.T(qVar.f12505a, qVar.f12506b);
                return;
            default:
                rVar.U(qVar.f12505a, qVar.f12506b);
                return;
        }
    }
}
