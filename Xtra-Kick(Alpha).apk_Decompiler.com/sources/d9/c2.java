package d9;

import c9.r;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public final class c2 extends b2 implements SortedSet {
    public c2(SortedSet sortedSet, r rVar) {
        super(sortedSet, rVar);
    }

    public final Comparator comparator() {
        return ((SortedSet) this.f4596h).comparator();
    }

    public final Object first() {
        Iterator it = this.f4596h.iterator();
        it.getClass();
        r rVar = this.f4597i;
        rVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (rVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new c2(((SortedSet) this.f4596h).headSet(obj), this.f4597i);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.f4596h;
        while (true) {
            Object last = sortedSet.last();
            if (this.f4597i.apply(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new c2(((SortedSet) this.f4596h).subSet(obj, obj2), this.f4597i);
    }

    public final SortedSet tailSet(Object obj) {
        return new c2(((SortedSet) this.f4596h).tailSet(obj), this.f4597i);
    }
}
