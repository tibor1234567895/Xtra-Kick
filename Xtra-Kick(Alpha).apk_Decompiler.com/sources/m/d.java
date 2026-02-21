package m;

import android.content.Context;
import android.view.MenuItem;
import androidx.lifecycle.p1;
import g0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import la.f;
import la.o;
import q.k;
import r3.n0;
import xa.j;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9904a;

    /* renamed from: b  reason: collision with root package name */
    public Object f9905b;

    /* renamed from: c  reason: collision with root package name */
    public o f9906c;

    public d(Context context) {
        this.f9904a = context;
    }

    public final u3.o c() {
        ((n0) this.f9904a).a();
        if (((AtomicBoolean) this.f9905b).compareAndSet(false, true)) {
            return (u3.o) this.f9906c.getValue();
        }
        return d();
    }

    public final u3.o d() {
        String e10 = e();
        n0 n0Var = (n0) this.f9904a;
        n0Var.getClass();
        j.f("sql", e10);
        n0Var.a();
        n0Var.b();
        return n0Var.i().x0().y(e10);
    }

    public abstract String e();

    public final MenuItem f(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (((k) this.f9905b) == null) {
            this.f9905b = new k();
        }
        MenuItem menuItem2 = (MenuItem) ((k) this.f9905b).getOrDefault(bVar, (Object) null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        w wVar = new w((Context) this.f9904a, bVar);
        ((k) this.f9905b).put(bVar, wVar);
        return wVar;
    }

    public final void g(u3.o oVar) {
        j.f("statement", oVar);
        if (oVar == ((u3.o) this.f9906c.getValue())) {
            ((AtomicBoolean) this.f9905b).set(false);
        }
    }

    public d(n0 n0Var) {
        j.f("database", n0Var);
        this.f9904a = n0Var;
        this.f9905b = new AtomicBoolean(false);
        this.f9906c = f.b(new p1(5, this));
    }
}
