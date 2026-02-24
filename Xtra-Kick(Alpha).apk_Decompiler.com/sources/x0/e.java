package x0;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final long f16526a;

    /* renamed from: b  reason: collision with root package name */
    public final long f16527b;

    public e(long j10, long j11) {
        if (j11 == 0) {
            this.f16526a = 0;
            this.f16527b = 1;
            return;
        }
        this.f16526a = j10;
        this.f16527b = j11;
    }

    public final String toString() {
        return this.f16526a + Constants.LIST_SEPARATOR + this.f16527b;
    }
}
