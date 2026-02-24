package j1;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8430a;

    public g() {
        d0 d0Var = d.f8420a;
    }

    public final synchronized void a() {
        this.f8430a = false;
    }

    public final synchronized boolean b() {
        if (this.f8430a) {
            return false;
        }
        this.f8430a = true;
        notifyAll();
        return true;
    }

    public g(int i10) {
    }
}
