package b6;

import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.v0;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.util.AppLifecycleObserver;
import s7.i;
import xa.j;

public final class a extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XtraApp f2638a;

    public a(XtraApp xtraApp) {
        this.f2638a = xtraApp;
    }

    public final void a(c1 c1Var, c0 c0Var) {
        j.f("fm", c1Var);
        j.f("f", c0Var);
        if (c0Var instanceof i) {
            XtraApp xtraApp = this.f2638a;
            xtraApp.getClass();
            AppLifecycleObserver appLifecycleObserver = xtraApp.f3321j;
            appLifecycleObserver.getClass();
            appLifecycleObserver.f3557h.add((i) c0Var);
        }
    }

    public final void b(c1 c1Var, c0 c0Var) {
        j.f("fm", c1Var);
        j.f("f", c0Var);
        if (c0Var instanceof i) {
            XtraApp xtraApp = this.f2638a;
            xtraApp.getClass();
            AppLifecycleObserver appLifecycleObserver = xtraApp.f3321j;
            appLifecycleObserver.getClass();
            appLifecycleObserver.f3557h.remove((i) c0Var);
        }
    }
}
