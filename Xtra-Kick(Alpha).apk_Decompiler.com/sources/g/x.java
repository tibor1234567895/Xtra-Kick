package g;

import android.view.MenuItem;
import android.view.ViewGroup;
import java.util.WeakHashMap;
import l.b;
import l.c;
import l.h;
import m.o;
import m0.c1;
import m0.m0;
import m0.n1;

public final class x implements b {

    /* renamed from: h  reason: collision with root package name */
    public final b f6231h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k0 f6232i;

    public x(k0 k0Var, h hVar) {
        this.f6232i = k0Var;
        this.f6231h = hVar;
    }

    public final boolean e(c cVar, o oVar) {
        ViewGroup viewGroup = this.f6232i.I;
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(viewGroup);
        return this.f6231h.e(cVar, oVar);
    }

    public final boolean f(c cVar, MenuItem menuItem) {
        return this.f6231h.f(cVar, menuItem);
    }

    public final boolean g(c cVar, o oVar) {
        return this.f6231h.g(cVar, oVar);
    }

    public final void h(c cVar) {
        this.f6231h.h(cVar);
        k0 k0Var = this.f6232i;
        if (k0Var.D != null) {
            k0Var.f6168s.getDecorView().removeCallbacks(k0Var.E);
        }
        if (k0Var.C != null) {
            n1 n1Var = k0Var.F;
            if (n1Var != null) {
                n1Var.b();
            }
            n1 a10 = c1.a(k0Var.C);
            a10.a(0.0f);
            k0Var.F = a10;
            a10.d(new w(2, this));
        }
        p pVar = k0Var.f6170u;
        if (pVar != null) {
            pVar.d();
        }
        k0Var.B = null;
        ViewGroup viewGroup = k0Var.I;
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(viewGroup);
        k0Var.Z();
    }
}
