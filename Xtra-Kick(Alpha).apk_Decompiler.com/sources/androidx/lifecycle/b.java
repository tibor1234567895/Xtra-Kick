package androidx.lifecycle;

import android.os.Bundle;
import b1.f;
import j3.r;
import t3.e;
import xa.j;

public abstract class b extends f2 implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final e f1655a;

    /* renamed from: b  reason: collision with root package name */
    public final t f1656b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f1657c;

    static {
        new a(0);
    }

    public b() {
    }

    public b(r rVar) {
        j.f("owner", rVar);
        this.f1655a = rVar.f8668p.f14540b;
        this.f1656b = rVar.f8667o;
        this.f1657c = null;
    }

    public final w1 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            t tVar = this.f1656b;
            if (tVar != null) {
                e eVar = this.f1655a;
                j.c(eVar);
                j.c(tVar);
                SavedStateHandleController b10 = o.b(eVar, tVar, canonicalName, this.f1657c);
                w1 d10 = d(canonicalName, cls, b10.f1643i);
                d10.c("androidx.lifecycle.savedstate.vm.tag", b10);
                return d10;
            }
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final w1 b(Class cls, f fVar) {
        String str = (String) fVar.a(e2.f1678c);
        if (str != null) {
            e eVar = this.f1655a;
            if (eVar == null) {
                return d(str, cls, o1.a(fVar));
            }
            j.c(eVar);
            t tVar = this.f1656b;
            j.c(tVar);
            SavedStateHandleController b10 = o.b(eVar, tVar, str, this.f1657c);
            w1 d10 = d(str, cls, b10.f1643i);
            d10.c("androidx.lifecycle.savedstate.vm.tag", b10);
            return d10;
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public final void c(w1 w1Var) {
        e eVar = this.f1655a;
        if (eVar != null) {
            t tVar = this.f1656b;
            j.c(tVar);
            o.a(w1Var, eVar, tVar);
        }
    }

    public abstract w1 d(String str, Class cls, j1 j1Var);
}
