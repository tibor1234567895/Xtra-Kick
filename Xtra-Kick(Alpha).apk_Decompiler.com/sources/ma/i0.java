package ma;

import java.util.Collections;
import java.util.Map;
import la.i;
import xa.j;

public class i0 extends h0 {
    public static final int a(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((((float) i10) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map b(i iVar) {
        j.f("pair", iVar);
        Map singletonMap = Collections.singletonMap(iVar.f9799h, iVar.f9800i);
        j.e("singletonMap(pair.first, pair.second)", singletonMap);
        return singletonMap;
    }

    public static final Map c(Map map) {
        j.f("<this>", map);
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        j.e("with(entries.iterator().…ingletonMap(key, value) }", singletonMap);
        return singletonMap;
    }
}
