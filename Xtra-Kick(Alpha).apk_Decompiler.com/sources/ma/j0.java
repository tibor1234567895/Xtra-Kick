package ma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import la.i;
import xa.j;

public class j0 extends i0 {
    public static final c0 d() {
        c0 c0Var = c0.f10802h;
        j.d("null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>", c0Var);
        return c0Var;
    }

    public static final Object e(Map map, String str) {
        j.f("<this>", map);
        Object obj = map.get(str);
        if (obj != null || map.containsKey(str)) {
            return obj;
        }
        throw new NoSuchElementException("Key " + str + " is missing in the map.");
    }

    public static final Map f(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return d();
        }
        if (size == 1) {
            return i0.b((i) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(i0.a(arrayList.size()));
        h(arrayList, linkedHashMap);
        return linkedHashMap;
    }

    public static final Map g(Map map) {
        j.f("<this>", map);
        int size = map.size();
        return size != 0 ? size != 1 ? i(map) : i0.c(map) : d();
    }

    public static final void h(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            linkedHashMap.put(iVar.f9799h, iVar.f9800i);
        }
    }

    public static final LinkedHashMap i(Map map) {
        j.f("<this>", map);
        return new LinkedHashMap(map);
    }
}
