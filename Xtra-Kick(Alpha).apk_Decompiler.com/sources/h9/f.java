package h9;

public final class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final n f7739h;

    /* renamed from: i  reason: collision with root package name */
    public final e0 f7740i;

    public f(n nVar, e0 e0Var) {
        this.f7739h = nVar;
        this.f7740i = e0Var;
    }

    public final void run() {
        if (this.f7739h.f7762h == this) {
            if (n.f7760m.b(this.f7739h, this, n.i(this.f7740i))) {
                n.f(this.f7739h);
            }
        }
    }
}
