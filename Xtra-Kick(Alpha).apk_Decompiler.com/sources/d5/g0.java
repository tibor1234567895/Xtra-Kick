package d5;

import b5.j;
import w5.n;

public final class g0 implements o0 {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4383h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4384i;

    /* renamed from: j  reason: collision with root package name */
    public final o0 f4385j;

    /* renamed from: k  reason: collision with root package name */
    public final f0 f4386k;

    /* renamed from: l  reason: collision with root package name */
    public final j f4387l;

    /* renamed from: m  reason: collision with root package name */
    public int f4388m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4389n;

    public g0(o0 o0Var, boolean z10, boolean z11, j jVar, f0 f0Var) {
        n.b(o0Var);
        this.f4385j = o0Var;
        this.f4383h = z10;
        this.f4384i = z11;
        this.f4387l = jVar;
        n.b(f0Var);
        this.f4386k = f0Var;
    }

    public final synchronized void a() {
        if (!this.f4389n) {
            this.f4388m++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public final int b() {
        return this.f4385j.b();
    }

    public final void c() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f4388m;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.f4388m = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            ((w) this.f4386k).e(this.f4387l, this);
        }
    }

    public final Class d() {
        return this.f4385j.d();
    }

    public final synchronized void e() {
        if (this.f4388m > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f4389n) {
            this.f4389n = true;
            if (this.f4384i) {
                this.f4385j.e();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public final Object get() {
        return this.f4385j.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f4383h + ", listener=" + this.f4386k + ", key=" + this.f4387l + ", acquired=" + this.f4388m + ", isRecycled=" + this.f4389n + ", resource=" + this.f4385j + '}';
    }
}
