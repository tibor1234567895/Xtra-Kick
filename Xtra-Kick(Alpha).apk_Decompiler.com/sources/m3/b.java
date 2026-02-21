package m3;

import android.os.Bundle;
import android.support.v4.media.h;
import android.util.Log;
import android.view.MenuItem;
import com.woxthebox.draglistview.R;
import eb.m;
import j3.a1;
import j3.c;
import j3.c1;
import j3.f1;
import j3.h1;
import j3.k0;
import j3.m1;
import j3.z0;
import java.util.Iterator;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f10568a = 0;

    static {
        new b();
    }

    private b() {
    }

    public static final boolean a(c1 c1Var, int i10) {
        boolean z10;
        j.f("<this>", c1Var);
        c1.f8505q.getClass();
        Iterator it = m.b(c1Var, z0.f8727h).iterator();
        do {
            z10 = false;
            if (!it.hasNext()) {
                return false;
            }
            if (((c1) it.next()).f8513o == i10) {
                z10 = true;
                continue;
            }
        } while (!z10);
        return true;
    }

    public static final boolean b(MenuItem menuItem, k0 k0Var) {
        int i10;
        j.f("item", menuItem);
        m1 m1Var = new m1();
        boolean z10 = true;
        m1Var.f8615a = true;
        m1Var.f8616b = true;
        c1 f10 = k0Var.f();
        j.c(f10);
        h1 h1Var = f10.f8507i;
        j.c(h1Var);
        if (h1Var.i(menuItem.getItemId(), true) instanceof c) {
            m1Var.f8621g = R.anim.nav_default_enter_anim;
            m1Var.f8622h = R.anim.nav_default_exit_anim;
            m1Var.f8623i = R.anim.nav_default_pop_enter_anim;
            i10 = R.anim.nav_default_pop_exit_anim;
        } else {
            m1Var.f8621g = R.animator.nav_default_enter_anim;
            m1Var.f8622h = R.animator.nav_default_exit_anim;
            m1Var.f8623i = R.animator.nav_default_pop_enter_anim;
            i10 = R.animator.nav_default_pop_exit_anim;
        }
        m1Var.f8624j = i10;
        if ((menuItem.getOrder() & 196608) == 0) {
            f1 f1Var = h1.f8556v;
            h1 h10 = k0Var.h();
            f1Var.getClass();
            m1Var.f8617c = f1.a(h10).f8513o;
            m1Var.f8618d = null;
            m1Var.f8619e = false;
            m1Var.f8620f = true;
        }
        try {
            k0Var.k(menuItem.getItemId(), (Bundle) null, m1Var.a());
            c1 f11 = k0Var.f();
            if (f11 == null || !a(f11, menuItem.getItemId())) {
                z10 = false;
            }
            return z10;
        } catch (IllegalArgumentException e10) {
            a1 a1Var = c1.f8505q;
            int itemId = menuItem.getItemId();
            a1Var.getClass();
            StringBuilder s10 = h.s("Ignoring onNavDestinationSelected for MenuItem ", a1.b(k0Var.f8576a, itemId), " as it cannot be found from the current destination ");
            s10.append(k0Var.f());
            Log.i("NavigationUI", s10.toString(), e10);
            return false;
        }
    }
}
