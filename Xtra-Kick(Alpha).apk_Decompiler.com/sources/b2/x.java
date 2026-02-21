package b2;

import android.os.Handler;
import m1.g;
import m1.k0;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f2511a;

    /* renamed from: b  reason: collision with root package name */
    public final y f2512b;

    public x(Handler handler, k0 k0Var) {
        this.f2511a = handler;
        this.f2512b = k0Var;
    }

    public final void a(g gVar) {
        synchronized (gVar) {
        }
        Handler handler = this.f2511a;
        if (handler != null) {
            handler.post(new w(this, gVar, 1));
        }
    }
}
