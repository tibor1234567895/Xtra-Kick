package m0;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.n;
import e.a;
import m.b0;
import m.i0;
import m.o;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public n f10062a;

    /* renamed from: b  reason: collision with root package name */
    public a f10063b;

    public abstract boolean a();

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public abstract void f(i0 i0Var);

    public boolean g() {
        return false;
    }

    public void h(a aVar) {
        if (this.f10063b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f10063b = aVar;
    }

    public final void i(boolean z10) {
        n nVar = this.f10062a;
        if (nVar == null) {
            return;
        }
        if (z10) {
            b0 b0Var = nVar.f948l;
            if (b0Var != null) {
                b0Var.n(nVar.f946j);
                return;
            }
            return;
        }
        o oVar = nVar.f946j;
        if (oVar != null) {
            oVar.c(false);
        }
    }
}
