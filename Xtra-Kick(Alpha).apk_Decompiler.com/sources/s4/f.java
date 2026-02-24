package s4;

import androidx.lifecycle.c0;
import androidx.lifecycle.h;
import androidx.lifecycle.s;
import androidx.lifecycle.t;

public final class f extends t {

    /* renamed from: b  reason: collision with root package name */
    public static final f f14221b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final e f14222c = new e();

    private f() {
    }

    public final void a(c0 c0Var) {
        if (c0Var instanceof h) {
            h hVar = (h) c0Var;
            e eVar = f14222c;
            hVar.b(eVar);
            hVar.onStart(eVar);
            hVar.a(eVar);
            return;
        }
        throw new IllegalArgumentException((c0Var + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
    }

    public final s b() {
        return s.RESUMED;
    }

    public final void c(c0 c0Var) {
    }

    public final String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
