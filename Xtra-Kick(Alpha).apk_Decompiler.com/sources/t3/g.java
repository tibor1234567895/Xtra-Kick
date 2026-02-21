package t3;

import android.os.Bundle;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.savedstate.Recreator;
import j3.v;
import java.util.Map;
import o.d;
import xa.j;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    public static final f f14538d = new f(0);

    /* renamed from: a  reason: collision with root package name */
    public final h f14539a;

    /* renamed from: b  reason: collision with root package name */
    public final e f14540b = new e();

    /* renamed from: c  reason: collision with root package name */
    public boolean f14541c;

    public g(h hVar) {
        this.f14539a = hVar;
    }

    public final void a() {
        boolean z10;
        h hVar = this.f14539a;
        t o10 = hVar.o();
        if (o10.b() == s.INITIALIZED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            o10.a(new Recreator(hVar));
            e eVar = this.f14540b;
            eVar.getClass();
            if (!eVar.f14533b) {
                o10.a(new v(2, eVar));
                eVar.f14533b = true;
                this.f14541c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void b(Bundle bundle) {
        Bundle bundle2;
        if (!this.f14541c) {
            a();
        }
        t o10 = this.f14539a.o();
        if (!o10.b().a(s.STARTED)) {
            e eVar = this.f14540b;
            if (!eVar.f14533b) {
                throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
            } else if (!eVar.f14535d) {
                if (bundle != null) {
                    bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                } else {
                    bundle2 = null;
                }
                eVar.f14534c = bundle2;
                eVar.f14535d = true;
            } else {
                throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
            }
        } else {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + o10.b()).toString());
        }
    }

    public final void c(Bundle bundle) {
        j.f("outBundle", bundle);
        e eVar = this.f14540b;
        eVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = eVar.f14534c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        o.g gVar = eVar.f14532a;
        gVar.getClass();
        d dVar = new d(gVar);
        gVar.f11851j.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((d) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}
