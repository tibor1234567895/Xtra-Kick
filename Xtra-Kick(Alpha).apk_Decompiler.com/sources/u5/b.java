package u5;

import b5.a;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f15359a;

    /* renamed from: b  reason: collision with root package name */
    public c f15360b;

    public b(int i10) {
        this.f15359a = i10;
    }

    public final g a(a aVar) {
        if (aVar == a.MEMORY_CACHE) {
            return e.f15363a;
        }
        if (this.f15360b == null) {
            this.f15360b = new c(this.f15359a, false);
        }
        return this.f15360b;
    }
}
