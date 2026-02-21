package g;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.view.View;
import androidx.fragment.app.f2;
import androidx.fragment.app.g2;
import androidx.fragment.app.h2;
import i0.f;
import java.util.LinkedHashSet;
import xa.j;

public abstract class h0 {

    /* renamed from: a  reason: collision with root package name */
    public Object f6079a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6080b;

    public h0(h2 h2Var, f fVar) {
        this.f6079a = h2Var;
        this.f6080b = fVar;
    }

    public final void a() {
        Object obj = this.f6079a;
        if (((BroadcastReceiver) obj) != null) {
            try {
                ((k0) this.f6080b).f6167r.unregisterReceiver((BroadcastReceiver) obj);
            } catch (IllegalArgumentException unused) {
            }
            this.f6079a = null;
        }
    }

    public final void b() {
        h2 h2Var = (h2) this.f6079a;
        f fVar = (f) this.f6080b;
        h2Var.getClass();
        j.f("signal", fVar);
        LinkedHashSet linkedHashSet = h2Var.f1457e;
        if (linkedHashSet.remove(fVar) && linkedHashSet.isEmpty()) {
            h2Var.b();
        }
    }

    public abstract IntentFilter c();

    public abstract int d();

    public final boolean e() {
        g2 g2Var;
        f2 f2Var = g2.f1435h;
        View view = ((h2) this.f6079a).f1455c.M;
        j.e("operation.fragment.mView", view);
        f2Var.getClass();
        g2 a10 = f2.a(view);
        g2 g2Var2 = ((h2) this.f6079a).f1453a;
        if (a10 == g2Var2 || (a10 != (g2Var = g2.VISIBLE) && g2Var2 != g2Var)) {
            return true;
        }
        return false;
    }

    public abstract void f();

    public final void g() {
        a();
        IntentFilter c10 = c();
        if (c10 != null && c10.countActions() != 0) {
            if (((BroadcastReceiver) this.f6079a) == null) {
                this.f6079a = new g0(0, this);
            }
            ((k0) this.f6080b).f6167r.registerReceiver((BroadcastReceiver) this.f6079a, c10);
        }
    }

    public h0(k0 k0Var) {
        this.f6080b = k0Var;
    }
}
