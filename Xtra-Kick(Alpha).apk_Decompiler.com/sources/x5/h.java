package x5;

public final class h extends i {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f16681a;

    public h() {
        super(0);
    }

    public final void a() {
        if (this.f16681a) {
            throw new IllegalStateException("Already released");
        }
    }
}
