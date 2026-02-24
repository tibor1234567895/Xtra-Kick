package j3;

import android.os.Bundle;
import android.support.v4.media.h;
import android.util.Log;
import androidx.lifecycle.g2;
import androidx.lifecycle.s;
import java.util.Collection;
import java.util.Iterator;
import ma.l;
import ma.z;
import xa.j;

public final class y extends r2 {

    /* renamed from: g  reason: collision with root package name */
    public final o2 f8723g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k0 f8724h;

    public y(k0 k0Var, o2 o2Var) {
        j.f("navigator", o2Var);
        this.f8724h = k0Var;
        this.f8723g = o2Var;
    }

    public final r a(c1 c1Var, Bundle bundle) {
        n nVar = r.f8659t;
        k0 k0Var = this.f8724h;
        return n.b(nVar, k0Var.f8576a, c1Var, bundle, k0Var.i(), k0Var.f8590o);
    }

    public final void b(r rVar) {
        boolean z10;
        n0 n0Var;
        j.f("entry", rVar);
        k0 k0Var = this.f8724h;
        boolean a10 = j.a(k0Var.f8600y.get(rVar), Boolean.TRUE);
        super.b(rVar);
        k0Var.f8600y.remove(rVar);
        l lVar = k0Var.f8582g;
        if (!lVar.contains(rVar)) {
            k0Var.t(rVar);
            if (rVar.f8667o.f1688d.a(s.CREATED)) {
                rVar.c(s.DESTROYED);
            }
            boolean z11 = lVar instanceof Collection;
            String str = rVar.f8665m;
            if (!z11 || !lVar.isEmpty()) {
                Iterator it = lVar.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (j.a(((r) it.next()).f8665m, str)) {
                            z10 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z10 = true;
            if (z10 && !a10 && (n0Var = k0Var.f8590o) != null) {
                j.f("backStackEntryId", str);
                g2 g2Var = (g2) n0Var.f8631d.remove(str);
                if (g2Var != null) {
                    g2Var.a();
                }
            }
            k0Var.u();
        } else if (!this.f8677d) {
            k0Var.u();
            k0Var.f8583h.k(z.K(lVar));
        } else {
            return;
        }
        k0Var.f8584i.k(k0Var.q());
    }

    public final void d(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        k0 k0Var = this.f8724h;
        o2 b10 = k0Var.f8596u.b(rVar.f8661i.f8506h);
        if (j.a(b10, this.f8723g)) {
            wa.l lVar = k0Var.f8599x;
            if (lVar != null) {
                lVar.invoke(rVar);
                super.d(rVar, z10);
                return;
            }
            x xVar = new x(this, rVar, z10);
            l lVar2 = k0Var.f8582g;
            int indexOf = lVar2.indexOf(rVar);
            if (indexOf < 0) {
                Log.i("NavController", "Ignoring pop of " + rVar + " as it was not found on the current back stack");
                return;
            }
            int i10 = indexOf + 1;
            if (i10 != lVar2.f10819j) {
                k0Var.n(((r) lVar2.get(i10)).f8661i.f8513o, true, false);
            }
            k0Var.o(rVar, false, new l());
            xVar.b();
            k0Var.v();
            k0Var.b();
            return;
        }
        Object obj = k0Var.f8597v.get(b10);
        j.c(obj);
        ((y) obj).d(rVar, z10);
    }

    public final void e(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        super.e(rVar, z10);
        this.f8724h.f8600y.put(rVar, Boolean.valueOf(z10));
    }

    public final void f(r rVar) {
        super.f(rVar);
        if (this.f8724h.f8582g.contains(rVar)) {
            rVar.c(s.STARTED);
            return;
        }
        throw new IllegalStateException("Cannot transition entry that is not in the back stack");
    }

    public final void g(r rVar) {
        j.f("backStackEntry", rVar);
        k0 k0Var = this.f8724h;
        o2 b10 = k0Var.f8596u.b(rVar.f8661i.f8506h);
        if (j.a(b10, this.f8723g)) {
            wa.l lVar = k0Var.f8598w;
            if (lVar != null) {
                lVar.invoke(rVar);
                j(rVar);
                return;
            }
            Log.i("NavController", "Ignoring add of destination " + rVar.f8661i + " outside of the call to navigate(). ");
            return;
        }
        Object obj = k0Var.f8597v.get(b10);
        if (obj != null) {
            ((y) obj).g(rVar);
            return;
        }
        throw new IllegalStateException(h.p(new StringBuilder("NavigatorBackStack for "), rVar.f8661i.f8506h, " should already be created").toString());
    }

    public final void j(r rVar) {
        j.f("backStackEntry", rVar);
        super.g(rVar);
    }
}
