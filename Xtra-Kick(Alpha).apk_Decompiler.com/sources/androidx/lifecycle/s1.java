package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import b1.f;
import java.lang.reflect.Constructor;
import java.util.List;
import t3.e;
import t3.h;
import xa.j;

public final class s1 extends f2 implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final Application f1758a;

    /* renamed from: b  reason: collision with root package name */
    public final a2 f1759b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f1760c;

    /* renamed from: d  reason: collision with root package name */
    public final t f1761d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1762e;

    public s1() {
        this.f1759b = new a2();
    }

    public final w1 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final w1 b(Class cls, f fVar) {
        List list;
        String str = (String) fVar.a(e2.f1678c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (fVar.a(o1.f1735a) != null && fVar.a(o1.f1736b) != null) {
            Application application = (Application) fVar.a(a2.f1653g);
            boolean isAssignableFrom = c.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                list = t1.f1765b;
            } else {
                list = t1.f1764a;
            }
            Constructor a10 = t1.a(cls, list);
            if (a10 == null) {
                return this.f1759b.b(cls, fVar);
            }
            if (!isAssignableFrom || application == null) {
                return t1.b(cls, a10, o1.a(fVar));
            }
            return t1.b(cls, a10, application, o1.a(fVar));
        } else if (this.f1761d != null) {
            return d(cls, str);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public final void c(w1 w1Var) {
        t tVar = this.f1761d;
        if (tVar != null) {
            e eVar = this.f1762e;
            j.c(eVar);
            o.a(w1Var, eVar, tVar);
        }
    }

    public final w1 d(Class cls, String str) {
        List list;
        w1 w1Var;
        t tVar = this.f1761d;
        if (tVar != null) {
            boolean isAssignableFrom = c.class.isAssignableFrom(cls);
            Application application = this.f1758a;
            if (!isAssignableFrom || application == null) {
                list = t1.f1765b;
            } else {
                list = t1.f1764a;
            }
            Constructor a10 = t1.a(cls, list);
            if (a10 != null) {
                e eVar = this.f1762e;
                j.c(eVar);
                SavedStateHandleController b10 = o.b(eVar, tVar, str, this.f1760c);
                j1 j1Var = b10.f1643i;
                if (!isAssignableFrom || application == null) {
                    w1Var = t1.b(cls, a10, j1Var);
                } else {
                    w1Var = t1.b(cls, a10, application, j1Var);
                }
                w1Var.c("androidx.lifecycle.savedstate.vm.tag", b10);
                return w1Var;
            } else if (application != null) {
                return this.f1759b.a(cls);
            } else {
                e2.f1676a.getClass();
                if (e2.f1677b == null) {
                    e2.f1677b = new e2();
                }
                e2 e2Var = e2.f1677b;
                j.c(e2Var);
                return e2Var.a(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public s1(Application application, h hVar, Bundle bundle) {
        a2 a2Var;
        j.f("owner", hVar);
        this.f1762e = hVar.a();
        this.f1761d = hVar.o();
        this.f1760c = bundle;
        this.f1758a = application;
        if (application != null) {
            a2.f1651e.getClass();
            if (a2.f1652f == null) {
                a2.f1652f = new a2(application);
            }
            a2Var = a2.f1652f;
            j.c(a2Var);
        } else {
            a2Var = new a2();
        }
        this.f1759b = a2Var;
    }
}
