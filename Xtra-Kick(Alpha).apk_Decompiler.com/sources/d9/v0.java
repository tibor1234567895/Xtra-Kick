package d9;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class v0 {
    private v0() {
    }

    public static Object a(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return list.get(list.size() - 1);
            }
            throw new NoSuchElementException();
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }
}
