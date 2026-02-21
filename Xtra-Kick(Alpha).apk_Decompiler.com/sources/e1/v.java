package e1;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4942a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4943b;

    /* renamed from: c  reason: collision with root package name */
    public int f4944c;

    public v(Object obj) {
        this.f4942a = obj;
    }

    public final boolean a() {
        return this.f4943b;
    }

    public abstract void b();

    public final void c() {
        if (!this.f4943b) {
            this.f4943b = true;
            b();
            return;
        }
        throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f4942a);
    }
}
