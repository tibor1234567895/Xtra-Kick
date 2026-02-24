package ma;

import java.util.LinkedHashSet;
import java.util.Set;
import xa.j;

public class p0 extends o0 {
    public static final LinkedHashSet c(Set set, Object obj) {
        j.f("<this>", set);
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.a(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
