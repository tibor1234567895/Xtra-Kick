package androidx.lifecycle;

import hb.f0;
import hb.h0;
import java.io.Closeable;
import java.util.concurrent.CancellationException;
import pa.k;
import xa.j;

public final class g implements Closeable, f0 {

    /* renamed from: h  reason: collision with root package name */
    public final k f1684h;

    public g(k kVar) {
        j.f("context", kVar);
        this.f1684h = kVar;
    }

    public final void close() {
        h0.w(this.f1684h, (CancellationException) null);
    }

    public final k v() {
        return this.f1684h;
    }
}
