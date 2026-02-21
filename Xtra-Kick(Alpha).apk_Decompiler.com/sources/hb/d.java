package hb;

import la.v;
import xa.j;

public final class d extends i {

    /* renamed from: h  reason: collision with root package name */
    public final c[] f7784h;

    public d(c[] cVarArr) {
        this.f7784h = cVarArr;
    }

    public final void a(Throwable th) {
        c();
    }

    public final void c() {
        c[] cVarArr = this.f7784h;
        int length = cVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            q0 q0Var = cVarArr[i10].f7781m;
            if (q0Var != null) {
                q0Var.a();
                i10++;
            } else {
                j.l("handle");
                throw null;
            }
        }
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        c();
        return v.f9814a;
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f7784h + ']';
    }
}
