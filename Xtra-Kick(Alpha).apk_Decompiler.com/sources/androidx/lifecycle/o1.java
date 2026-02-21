package androidx.lifecycle;

import android.os.Bundle;
import android.support.v4.media.session.u;
import b1.e;
import b1.f;
import b1.g;
import hb.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import t3.d;
import t3.h;
import xa.j;
import xa.v;

public abstract class o1 {

    /* renamed from: a  reason: collision with root package name */
    public static final l1 f1735a = new l1();

    /* renamed from: b  reason: collision with root package name */
    public static final m1 f1736b = new m1();

    /* renamed from: c  reason: collision with root package name */
    public static final k1 f1737c = new k1();

    public static final j1 a(f fVar) {
        q1 q1Var;
        Bundle bundle;
        h hVar = (h) fVar.a(f1735a);
        if (hVar != null) {
            h2 h2Var = (h2) fVar.a(f1736b);
            if (h2Var != null) {
                Bundle bundle2 = (Bundle) fVar.a(f1737c);
                String str = (String) fVar.a(e2.f1678c);
                if (str != null) {
                    d b10 = hVar.a().b();
                    if (b10 instanceof q1) {
                        q1Var = (q1) b10;
                    } else {
                        q1Var = null;
                    }
                    if (q1Var != null) {
                        LinkedHashMap linkedHashMap = c(h2Var).f1746d;
                        j1 j1Var = (j1) linkedHashMap.get(str);
                        if (j1Var != null) {
                            return j1Var;
                        }
                        i1 i1Var = j1.f1711f;
                        boolean z10 = true;
                        if (!q1Var.f1742b) {
                            q1Var.f1743c = q1Var.f1741a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
                            q1Var.f1742b = true;
                            r1 r1Var = (r1) q1Var.f1744d.getValue();
                        }
                        Bundle bundle3 = q1Var.f1743c;
                        if (bundle3 != null) {
                            bundle = bundle3.getBundle(str);
                        } else {
                            bundle = null;
                        }
                        Bundle bundle4 = q1Var.f1743c;
                        if (bundle4 != null) {
                            bundle4.remove(str);
                        }
                        Bundle bundle5 = q1Var.f1743c;
                        if (bundle5 == null || !bundle5.isEmpty()) {
                            z10 = false;
                        }
                        if (z10) {
                            q1Var.f1743c = null;
                        }
                        i1Var.getClass();
                        j1 a10 = i1.a(bundle, bundle2);
                        linkedHashMap.put(str, a10);
                        return a10;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final void b(h hVar) {
        j.f("<this>", hVar);
        s b10 = hVar.o().b();
        if (!(b10 == s.INITIALIZED || b10 == s.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (hVar.a().b() == null) {
            q1 q1Var = new q1(hVar.a(), (h2) hVar);
            hVar.a().c("androidx.lifecycle.internal.SavedStateHandlesProvider", q1Var);
            hVar.o().a(new SavedStateHandleAttacher(q1Var));
        }
    }

    public static final r1 c(h2 h2Var) {
        j.f("<this>", h2Var);
        e eVar = new e();
        Class<r1> cls = r1.class;
        xa.e a10 = v.a(cls);
        n1 n1Var = n1.f1733h;
        j.f("initializer", n1Var);
        ArrayList arrayList = eVar.f2412a;
        arrayList.add(new g(h0.s0(a10), n1Var));
        g[] gVarArr = (g[]) arrayList.toArray(new g[0]);
        return (r1) new u(h2Var, (b2) new b1.d((g[]) Arrays.copyOf(gVarArr, gVarArr.length))).r(cls, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
