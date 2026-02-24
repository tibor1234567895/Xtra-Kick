package d5;

import android.support.v4.media.session.u;
import x5.e;
import x5.g;
import x5.h;

public final class n0 implements o0, e {

    /* renamed from: l  reason: collision with root package name */
    public static final u f4453l = g.a(20, new m0());

    /* renamed from: h  reason: collision with root package name */
    public final h f4454h = new h();

    /* renamed from: i  reason: collision with root package name */
    public o0 f4455i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4456j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4457k;

    public final synchronized void a() {
        this.f4454h.a();
        if (this.f4456j) {
            this.f4456j = false;
            if (this.f4457k) {
                e();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public final int b() {
        return this.f4455i.b();
    }

    public final h c() {
        return this.f4454h;
    }

    public final Class d() {
        return this.f4455i.d();
    }

    public final synchronized void e() {
        this.f4454h.a();
        this.f4457k = true;
        if (!this.f4456j) {
            this.f4455i.e();
            this.f4455i = null;
            f4453l.e(this);
        }
    }

    public final Object get() {
        return this.f4455i.get();
    }
}
