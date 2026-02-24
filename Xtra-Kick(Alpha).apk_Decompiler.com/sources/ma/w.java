package ma;

import java.util.Collection;
import java.util.Iterator;
import wa.l;
import xa.j;

public class w extends v {
    public static final void k(Iterable iterable, Collection collection) {
        j.f("<this>", collection);
        j.f("elements", iterable);
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        for (Object add : iterable) {
            collection.add(add);
        }
    }

    public static final boolean l(Collection collection, l lVar, boolean z10) {
        Iterator it = collection.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }
}
