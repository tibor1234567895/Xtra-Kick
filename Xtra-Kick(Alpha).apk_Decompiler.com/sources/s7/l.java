package s7;

import android.util.Log;
import androidx.lifecycle.d0;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;
import java.util.concurrent.atomic.AtomicBoolean;
import xa.j;

public final class l extends o0 {

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f14378l = new AtomicBoolean(false);

    static {
        new k(0);
    }

    public final void f(d0 d0Var, p0 p0Var) {
        boolean z10;
        j.f("owner", d0Var);
        if (this.f1721c > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.f(d0Var, new j(this, p0Var));
    }

    public final void l(Object obj) {
        this.f14378l.set(true);
        super.l(obj);
    }
}
