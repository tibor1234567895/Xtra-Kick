package tb;

public final class i implements z {

    /* renamed from: a  reason: collision with root package name */
    public final y f14966a;

    public i(Throwable th) {
        this.f14966a = new y(this, (d) null, th, 2);
    }

    public final z a() {
        throw new IllegalStateException("unexpected retry".toString());
    }

    public final boolean b() {
        return false;
    }

    public final y c() {
        return this.f14966a;
    }

    public final void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    public final r d() {
        throw new IllegalStateException("unexpected call".toString());
    }

    public final y f() {
        return this.f14966a;
    }
}
