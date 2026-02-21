package t3;

import android.os.Bundle;
import g.n;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.g;
import xa.j;

public final class e {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f14531g = 0;

    /* renamed from: a  reason: collision with root package name */
    public final g f14532a = new g();

    /* renamed from: b  reason: collision with root package name */
    public boolean f14533b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f14534c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14535d;

    /* renamed from: e  reason: collision with root package name */
    public n f14536e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14537f = true;

    static {
        new c(0);
    }

    public final Bundle a(String str) {
        if (this.f14535d) {
            Bundle bundle = this.f14534c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f14534c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f14534c;
            if (!(bundle4 != null && !bundle4.isEmpty())) {
                this.f14534c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final d b() {
        Map.Entry entry;
        d dVar;
        Iterator it = this.f14532a.iterator();
        do {
            o.e eVar = (o.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            entry = (Map.Entry) eVar.next();
            j.e("components", entry);
            dVar = (d) entry.getValue();
        } while (!j.a((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return dVar;
    }

    public final void c(String str, d dVar) {
        j.f("key", str);
        j.f("provider", dVar);
        if (!(((d) this.f14532a.b(str, dVar)) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() {
        Class<androidx.lifecycle.n> cls = androidx.lifecycle.n.class;
        if (this.f14537f) {
            n nVar = this.f14536e;
            if (nVar == null) {
                nVar = new n(this);
            }
            this.f14536e = nVar;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                n nVar2 = this.f14536e;
                if (nVar2 != null) {
                    ((Set) nVar2.f6183b).add(cls.getName());
                }
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}
