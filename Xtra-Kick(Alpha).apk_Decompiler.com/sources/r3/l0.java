package r3;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import r9.a;
import xa.j;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f13713a = new LinkedHashMap();

    public final void a(a... aVarArr) {
        j.f("migrations", aVarArr);
        for (a aVar : aVarArr) {
            int i10 = aVar.f13890a;
            LinkedHashMap linkedHashMap = this.f13713a;
            Integer valueOf = Integer.valueOf(i10);
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new TreeMap();
                linkedHashMap.put(valueOf, obj);
            }
            TreeMap treeMap = (TreeMap) obj;
            int i11 = aVar.f13891b;
            if (treeMap.containsKey(Integer.valueOf(i11))) {
                Log.w("ROOM", "Overriding migration " + treeMap.get(Integer.valueOf(i11)) + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }
    }
}
