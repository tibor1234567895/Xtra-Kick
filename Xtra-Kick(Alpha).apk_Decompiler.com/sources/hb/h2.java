package hb;

import pa.k;

public final class h2 extends d0 {

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f7807j = 0;

    static {
        new h2();
    }

    private h2() {
    }

    public final void M0(k kVar, Runnable runnable) {
        m2 m2Var = (m2) kVar.N(m2.f7826j);
        if (m2Var != null) {
            m2Var.f7827i = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
