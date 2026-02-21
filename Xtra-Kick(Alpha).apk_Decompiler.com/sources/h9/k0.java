package h9;

public final class k0 extends i {
    private k0() {
    }

    public static k0 n() {
        return new k0();
    }

    public final boolean l(Object obj) {
        return super.l(obj);
    }

    public final boolean m(Throwable th) {
        return super.m(th);
    }

    public final boolean o(e0 e0Var) {
        f fVar;
        c cVar;
        e0Var.getClass();
        Object obj = this.f7762h;
        if (obj == null) {
            if (e0Var.isDone()) {
                if (!n.f7760m.b(this, (Object) null, n.i(e0Var))) {
                    return false;
                }
                n.f(this);
            } else {
                fVar = new f(this, e0Var);
                if (n.f7760m.b(this, (Object) null, fVar)) {
                    try {
                        e0Var.a(fVar, q.f7765h);
                    } catch (Throwable unused) {
                        cVar = c.f7726b;
                    }
                } else {
                    obj = this.f7762h;
                }
            }
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        e0Var.cancel(((b) obj).f7723a);
        return false;
        n.f7760m.b(this, fVar, cVar);
        return true;
    }
}
