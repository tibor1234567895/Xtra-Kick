package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.w1;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import t3.a;
import t3.b;
import t3.e;
import t3.h;
import xa.j;

public final class Recreator implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final h f2282h;

    static {
        new a(0);
    }

    public Recreator(h hVar) {
        j.f("owner", hVar);
        this.f2282h = hVar;
    }

    public final void d(d0 d0Var, r rVar) {
        LinkedHashMap linkedHashMap;
        if (rVar == r.ON_CREATE) {
            d0Var.o().c(this);
            h hVar = this.f2282h;
            Bundle a10 = hVar.a().a("androidx.savedstate.Restarter");
            if (a10 != null) {
                ArrayList<String> stringArrayList = a10.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String next : stringArrayList) {
                        try {
                            Class<? extends U> asSubclass = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                            j.e("{\n                Class.…class.java)\n            }", asSubclass);
                            try {
                                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                                    j.e("{\n                constr…wInstance()\n            }", newInstance);
                                    b bVar = (b) newInstance;
                                    if (hVar instanceof h2) {
                                        g2 m10 = ((h2) hVar).m();
                                        e a11 = hVar.a();
                                        m10.getClass();
                                        Iterator it = new HashSet(m10.f1696a.keySet()).iterator();
                                        while (true) {
                                            boolean hasNext = it.hasNext();
                                            linkedHashMap = m10.f1696a;
                                            if (!hasNext) {
                                                break;
                                            }
                                            String str = (String) it.next();
                                            j.f("key", str);
                                            w1 w1Var = (w1) linkedHashMap.get(str);
                                            j.c(w1Var);
                                            o.a(w1Var, a11, hVar.o());
                                        }
                                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                            a11.d();
                                        }
                                    } else {
                                        throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
                                    }
                                } catch (Exception e10) {
                                    throw new RuntimeException(android.support.v4.media.h.m("Failed to instantiate ", next), e10);
                                }
                            } catch (NoSuchMethodException e11) {
                                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                            }
                        } catch (ClassNotFoundException e12) {
                            throw new RuntimeException(android.support.v4.media.h.n("Class ", next, " wasn't found"), e12);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
