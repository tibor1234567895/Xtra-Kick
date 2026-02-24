package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import la.f;
import la.o;
import t3.d;
import t3.e;
import xa.j;

public final class q1 implements d {

    /* renamed from: a  reason: collision with root package name */
    public final e f1741a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1742b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1743c;

    /* renamed from: d  reason: collision with root package name */
    public final o f1744d;

    public q1(e eVar, h2 h2Var) {
        j.f("savedStateRegistry", eVar);
        j.f("viewModelStoreOwner", h2Var);
        this.f1741a = eVar;
        this.f1744d = f.b(new p1(0, h2Var));
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1743c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((r1) this.f1744d.getValue()).f1746d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a10 = ((j1) entry.getValue()).f1717e.a();
            if (!j.a(a10, Bundle.EMPTY)) {
                bundle.putBundle(str, a10);
            }
        }
        this.f1742b = false;
        return bundle;
    }
}
