package androidx.fragment.app;

import androidx.lifecycle.g2;
import androidx.lifecycle.w1;
import java.util.HashMap;
import java.util.Iterator;

public final class h1 extends w1 {

    /* renamed from: j  reason: collision with root package name */
    public static final g1 f1446j = new g1();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f1447d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f1448e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f1449f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1450g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1451h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1452i = false;

    public h1(boolean z10) {
        this.f1450g = z10;
    }

    public final void b() {
        if (c1.I(3)) {
            toString();
        }
        this.f1451h = true;
    }

    public final void d(String str) {
        HashMap hashMap = this.f1448e;
        h1 h1Var = (h1) hashMap.get(str);
        if (h1Var != null) {
            h1Var.b();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f1449f;
        g2 g2Var = (g2) hashMap2.get(str);
        if (g2Var != null) {
            g2Var.a();
            hashMap2.remove(str);
        }
    }

    public final void e(c0 c0Var) {
        if (this.f1452i) {
            c1.I(2);
            return;
        }
        if ((this.f1447d.remove(c0Var.f1356l) != null) && c1.I(2)) {
            c0Var.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1.class != obj.getClass()) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.f1447d.equals(h1Var.f1447d) && this.f1448e.equals(h1Var.f1448e) && this.f1449f.equals(h1Var.f1449f);
    }

    public final int hashCode() {
        int hashCode = this.f1448e.hashCode();
        return this.f1449f.hashCode() + ((hashCode + (this.f1447d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f1447d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f1448e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f1449f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
