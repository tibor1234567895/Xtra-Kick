package r;

public final class c extends Throwable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13499h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i10) {
        super("Failure occurred while trying to finish a future.");
        this.f13499h = i10;
    }

    private synchronized void a() {
    }

    private synchronized void b() {
    }

    public final synchronized Throwable fillInStackTrace() {
        switch (this.f13499h) {
            case 0:
                a();
                return this;
            default:
                b();
                return this;
        }
    }
}
