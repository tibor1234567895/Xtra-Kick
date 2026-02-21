package m3;

import android.view.Menu;
import android.view.MenuItem;
import j3.c1;
import j3.g;
import j3.k0;
import java.lang.ref.WeakReference;
import o8.n;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f10566a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f10567b;

    public a(WeakReference weakReference, k0 k0Var) {
        this.f10566a = weakReference;
        this.f10567b = k0Var;
    }

    public final void a(k0 k0Var, c1 c1Var) {
        j.f("controller", k0Var);
        j.f("destination", c1Var);
        n nVar = (n) this.f10566a.get();
        if (nVar == null) {
            k0 k0Var2 = this.f10567b;
            k0Var2.getClass();
            k0Var2.f8591p.remove(this);
        } else if (!(c1Var instanceof g)) {
            Menu menu = nVar.getMenu();
            j.e("view.menu", menu);
            int size = menu.size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = menu.getItem(i10);
                j.b("getItem(index)", item);
                if (b.a(c1Var, item.getItemId())) {
                    item.setChecked(true);
                }
            }
        }
    }
}
