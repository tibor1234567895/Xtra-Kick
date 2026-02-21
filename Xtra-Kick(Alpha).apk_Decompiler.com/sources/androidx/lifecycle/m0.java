package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import o.e;
import o.g;

public final class m0 extends o0 {

    /* renamed from: l  reason: collision with root package name */
    public final g f1732l = new g();

    public final void h() {
        Iterator it = this.f1732l.iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                l0 l0Var = (l0) ((Map.Entry) eVar.next()).getValue();
                l0Var.f1729a.g(l0Var);
            } else {
                return;
            }
        }
    }

    public final void i() {
        Iterator it = this.f1732l.iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                l0 l0Var = (l0) ((Map.Entry) eVar.next()).getValue();
                l0Var.f1729a.k(l0Var);
            } else {
                return;
            }
        }
    }

    public final void m(k0 k0Var, v1 v1Var) {
        boolean z10;
        if (k0Var != null) {
            l0 l0Var = new l0(k0Var, v1Var);
            l0 l0Var2 = (l0) this.f1732l.b(k0Var, l0Var);
            if (l0Var2 != null && l0Var2.f1730b != v1Var) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (l0Var2 == null) {
                if (this.f1721c > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    k0Var.g(l0Var);
                }
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }
}
