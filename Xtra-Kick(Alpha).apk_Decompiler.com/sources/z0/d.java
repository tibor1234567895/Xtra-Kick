package z0;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import g.r0;
import java.util.Set;
import ma.z;
import xa.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f17359a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final c f17360b = c.f17356c;

    private d() {
    }

    public static c a(c0 c0Var) {
        while (c0Var != null) {
            if (c0Var.F()) {
                c0Var.x();
            }
            c0Var = c0Var.C;
        }
        return f17360b;
    }

    public static void b(c cVar, i iVar) {
        c0 c0Var = iVar.f17361h;
        String name = c0Var.getClass().getName();
        a aVar = a.PENALTY_LOG;
        Set set = cVar.f17357a;
        set.contains(aVar);
        if (set.contains(a.PENALTY_DEATH)) {
            r0 r0Var = new r0(name, 4, iVar);
            if (c0Var.F()) {
                Handler handler = c0Var.x().f1392v.f1404j;
                j.e("fragment.parentFragmentManager.host.handler", handler);
                if (!j.a(handler.getLooper(), Looper.myLooper())) {
                    handler.post(r0Var);
                    return;
                }
            }
            r0Var.run();
        }
    }

    public static void c(i iVar) {
        if (c1.I(3)) {
            iVar.f17361h.getClass();
        }
    }

    public static final void d(c0 c0Var, String str) {
        j.f("fragment", c0Var);
        j.f("previousFragmentId", str);
        e eVar = new e(c0Var, str);
        f17359a.getClass();
        c(eVar);
        c a10 = a(c0Var);
        if (a10.f17357a.contains(a.DETECT_FRAGMENT_REUSE) && e(a10, c0Var.getClass(), e.class)) {
            b(a10, eVar);
        }
    }

    public static boolean e(c cVar, Class cls, Class cls2) {
        Set set = (Set) cVar.f17358b.get(cls.getName());
        if (set == null) {
            return true;
        }
        if (j.a(cls2.getSuperclass(), i.class) || !z.n(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
