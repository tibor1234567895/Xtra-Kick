package androidx.lifecycle;

class LiveData$LifecycleBoundObserver extends j0 implements b0 {

    /* renamed from: l  reason: collision with root package name */
    public final d0 f1630l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ k0 f1631m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveData$LifecycleBoundObserver(k0 k0Var, d0 d0Var, p0 p0Var) {
        super(k0Var, p0Var);
        this.f1631m = k0Var;
        this.f1630l = d0Var;
    }

    public final void d(d0 d0Var, r rVar) {
        d0 d0Var2 = this.f1630l;
        s b10 = d0Var2.o().b();
        if (b10 == s.DESTROYED) {
            this.f1631m.k(this.f1707h);
            return;
        }
        s sVar = null;
        while (sVar != b10) {
            c(j());
            sVar = b10;
            b10 = d0Var2.o().b();
        }
    }

    public final void h() {
        this.f1630l.o().c(this);
    }

    public final boolean i(d0 d0Var) {
        return this.f1630l == d0Var;
    }

    public final boolean j() {
        return this.f1630l.o().b().a(s.STARTED);
    }
}
