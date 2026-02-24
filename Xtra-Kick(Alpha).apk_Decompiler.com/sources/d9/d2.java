package d9;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class d2 extends AbstractSet {
    public boolean removeAll(Collection collection) {
        collection.getClass();
        boolean z10 = false;
        if (!(collection instanceof Set) || collection.size() <= size()) {
            for (Object remove : collection) {
                z10 |= remove(remove);
            }
        } else {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public boolean retainAll(Collection collection) {
        collection.getClass();
        return super.retainAll(collection);
    }
}
