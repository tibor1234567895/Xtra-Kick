package h9;

import java.util.concurrent.Callable;

public final class l0 extends d0 {

    /* renamed from: j  reason: collision with root package name */
    public final Callable f7752j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ m0 f7753k;

    public l0(m0 m0Var, Callable callable) {
        this.f7753k = m0Var;
        callable.getClass();
        this.f7752j = callable;
    }

    public final void a(Throwable th) {
        this.f7753k.m(th);
    }

    public final void b(Object obj) {
        this.f7753k.l(obj);
    }

    public final boolean c() {
        return this.f7753k.isDone();
    }

    public final Object d() {
        return this.f7752j.call();
    }

    public final String e() {
        return this.f7752j.toString();
    }
}
