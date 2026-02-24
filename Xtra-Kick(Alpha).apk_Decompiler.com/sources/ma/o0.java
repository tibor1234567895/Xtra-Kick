package ma;

import java.util.LinkedHashSet;
import java.util.Set;

public class o0 extends n0 {
    public static final Set b(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.a(objArr.length));
        for (Object add : objArr) {
            linkedHashSet.add(add);
        }
        return linkedHashSet;
    }
}
