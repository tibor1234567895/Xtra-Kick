package androidx.lifecycle;

import android.os.Bundle;
import java.util.HashMap;
import t3.e;
import xa.j;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f1734a = new o();

    private o() {
    }

    public static final void a(w1 w1Var, e eVar, t tVar) {
        Object obj;
        j.f("registry", eVar);
        j.f("lifecycle", tVar);
        HashMap hashMap = w1Var.f1781a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = w1Var.f1781a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController != null && !savedStateHandleController.f1644j) {
            savedStateHandleController.c(tVar, eVar);
            f1734a.getClass();
            c(tVar, eVar);
        }
    }

    public static final SavedStateHandleController b(e eVar, t tVar, String str, Bundle bundle) {
        Bundle a10 = eVar.a(str);
        j1.f1711f.getClass();
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, i1.a(a10, bundle));
        savedStateHandleController.c(tVar, eVar);
        f1734a.getClass();
        c(tVar, eVar);
        return savedStateHandleController;
    }

    public static void c(t tVar, e eVar) {
        s b10 = tVar.b();
        if (b10 == s.INITIALIZED || b10.a(s.STARTED)) {
            eVar.d();
        } else {
            tVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(tVar, eVar));
        }
    }
}
