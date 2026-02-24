package d5;

import b5.j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import w5.n;

public final class b extends WeakReference {

    /* renamed from: a  reason: collision with root package name */
    public final j f4337a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4338b;

    /* renamed from: c  reason: collision with root package name */
    public o0 f4339c;

    public b(j jVar, g0 g0Var, ReferenceQueue referenceQueue, boolean z10) {
        super(g0Var, referenceQueue);
        o0 o0Var;
        n.b(jVar);
        this.f4337a = jVar;
        if (!g0Var.f4383h || !z10) {
            o0Var = null;
        } else {
            o0Var = g0Var.f4385j;
            n.b(o0Var);
        }
        this.f4339c = o0Var;
        this.f4338b = g0Var.f4383h;
    }
}
