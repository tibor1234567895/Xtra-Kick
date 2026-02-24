package j3;

import androidx.lifecycle.g2;
import androidx.lifecycle.w1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import xa.j;

public final class n0 extends w1 implements h2 {

    /* renamed from: e  reason: collision with root package name */
    public static final m0 f8629e = new m0(0);

    /* renamed from: f  reason: collision with root package name */
    public static final l0 f8630f = new l0();

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap f8631d = new LinkedHashMap();

    public final void b() {
        LinkedHashMap linkedHashMap = this.f8631d;
        for (g2 a10 : linkedHashMap.values()) {
            a10.a();
        }
        linkedHashMap.clear();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator it = this.f8631d.keySet().iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}
