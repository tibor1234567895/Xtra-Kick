package j4;

import dc.f0;
import dc.i0;
import dc.l;
import dc.r;
import hb.h0;
import java.io.Closeable;
import w4.e;

public final class q extends e0 {

    /* renamed from: h  reason: collision with root package name */
    public final f0 f8773h;

    /* renamed from: i  reason: collision with root package name */
    public final r f8774i;

    /* renamed from: j  reason: collision with root package name */
    public final String f8775j;

    /* renamed from: k  reason: collision with root package name */
    public final Closeable f8776k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f8777l = null;

    /* renamed from: m  reason: collision with root package name */
    public boolean f8778m;

    /* renamed from: n  reason: collision with root package name */
    public i0 f8779n;

    public q(f0 f0Var, r rVar, String str, Closeable closeable) {
        super(0);
        this.f8773h = f0Var;
        this.f8774i = rVar;
        this.f8775j = str;
        this.f8776k = closeable;
    }

    public final synchronized f0 c() {
        if (!this.f8778m) {
        } else {
            throw new IllegalStateException("closed".toString());
        }
        return this.f8773h;
    }

    public final synchronized void close() {
        this.f8778m = true;
        i0 i0Var = this.f8779n;
        if (i0Var != null) {
            e.a(i0Var);
        }
        Closeable closeable = this.f8776k;
        if (closeable != null) {
            e.a(closeable);
        }
    }

    public final f0 e() {
        return c();
    }

    public final d0 k() {
        return this.f8777l;
    }

    public final synchronized l v() {
        if (!this.f8778m) {
            i0 i0Var = this.f8779n;
            if (i0Var != null) {
                return i0Var;
            }
            i0 o10 = h0.o(this.f8774i.l(this.f8773h));
            this.f8779n = o10;
            return o10;
        }
        throw new IllegalStateException("closed".toString());
    }
}
