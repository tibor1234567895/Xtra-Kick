package v3;

import q0.f;

public final class g extends RuntimeException {

    /* renamed from: h  reason: collision with root package name */
    public final int f15906h;

    /* renamed from: i  reason: collision with root package name */
    public final Throwable f15907i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(int i10, Throwable th) {
        super(th);
        f.j("callbackName", i10);
        this.f15906h = i10;
        this.f15907i = th;
    }

    public final Throwable getCause() {
        return this.f15907i;
    }
}
